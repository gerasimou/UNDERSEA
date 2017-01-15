/************************************************************/
/*    NAME: Simos Gerasimou                                 */
/*    ORGN: University of York, UK                          */
/*    FILE: Sensor.cpp                                      */
/*    DATE: 2016                                            */
/************************************************************/


#include <iterator>
#include "MBUtils.h"
#include "Sensor.h"

using namespace std;


//---------------------------------------------------------
// Constructor
//---------------------------------------------------------
Sensor::Sensor()
{
  m_iterations 	 = 0;
  m_timewarp   	 = 1;
  m_nominal_rate = 0;
  m_reliability	 = 1;
  m_sensor_name  = "NONE";

  //set stringstream precision
	m_msgs.precision(2);
}


//---------------------------------------------------------
// Destructor
//---------------------------------------------------------
Sensor::~Sensor()
{
}


//---------------------------------------------------------
// Procedure: OnConnectToServer
//---------------------------------------------------------
bool Sensor::OnConnectToServer()
{
   // register for variables here
   // possibly look at the mission file?
   // m_MissionReader.GetConfigurationParam("Name", <string>);
   // m_Comms.Register("VARNAME", 0);
	
   RegisterVariables();
   return(true);
}


//---------------------------------------------------------
// Procedure: OnStartUp()
//            happens before connection is open
//---------------------------------------------------------
bool Sensor::OnStartUp()
{
	AppCastingMOOSApp::OnStartUp();

	list<string> sParams;
	m_MissionReader.EnableVerbatimQuoting(false);

	if(m_MissionReader.GetConfiguration(GetAppName(), sParams)) {
		list<string>::iterator p;
		for(p=sParams.begin(); p!=sParams.end(); p++) {
		  string original_line = *p;
		  string param = stripBlankEnds(toupper(biteString(*p, '=')));
		  string value = stripBlankEnds(*p);


		  if(param == "NAME") { // get sensor name
			m_sensor_name = value;
		  }
	      else if (param == "APPTICK"){
	    	  m_nominal_rate = atof(value.c_str());
	      }
		  else if(param == "DEGRADATION") { // get degradation details
			  bool handled = handleDegradation(value);
		  }
		  else if(param == "RELIABILITY") { // get reliability details
			  m_reliability = atof(value.c_str());
		  }
		  else //throw a configuration warning
			  reportUnhandledConfigWarning(original_line);
		}
	}
	else{
		reportConfigWarning("No configuration block found for " + GetAppName());
	}
  
	m_timewarp = GetMOOSTimeWarp();

	RegisterVariables();
	return(true);
}


//---------------------------------------------------------
// Procedure: RegisterVariables
//---------------------------------------------------------
void Sensor::RegisterVariables()
{
	AppCastingMOOSApp::RegisterVariables();
	// Register("FOOBAR", 0);
}


//---------------------------------------------------------
// Procedure: OnNewMail
//---------------------------------------------------------
bool Sensor::OnNewMail(MOOSMSG_LIST &NewMail)
{
	AppCastingMOOSApp::OnNewMail(NewMail);
	MOOSMSG_LIST::iterator p;

  for(p=NewMail.begin(); p!=NewMail.end(); p++) {
	  CMOOSMsg &msg = *p;

		#if 0 // Keep these around just for template
			string key   = msg.GetKey();
			string comm  = msg.GetCommunity();
			double dval  = msg.GetDouble();
			string sval  = msg.GetString();
			string msrc  = msg.GetSource();
			double mtime = msg.GetTime();
			bool   mdbl  = msg.IsDouble();
			bool   mstr  = msg.IsString();
		#endif
   }

   return(true);
}


//---------------------------------------------------------
// Procedure: Iterate()
//            happens AppTick times per second
//---------------------------------------------------------
bool Sensor::Iterate()
{
	static unsigned int event_index=0;

	AppCastingMOOSApp::Iterate();

	//do stuff here
	m_iterations++;

	double currentTime = MOOSTime(true)-GetAppStartTime();
	if (event_index < m_degradations.size()){

		Degradation deg    = m_degradations.at(event_index);
		if ( (currentTime >= deg.getStartTime()) && (currentTime <= deg.getFinishTime()) ){
			Notify(m_sensor_name, doubleToString(currentTime,3) + "\t DOWN");
			SetAppFreq(deg.getDegradation(),deg.getDegradation());
		}
		else if (currentTime > deg.getFinishTime()){
			event_index++;
			Notify(m_sensor_name, doubleToString(currentTime,3) + "\t Recovered");
			SetAppFreq(m_nominal_rate, m_nominal_rate);
		}
		else{
			Notify(m_sensor_name, doubleToString(currentTime,3) + "\t OK");
		}
	}
	else
		Notify(m_sensor_name, doubleToString(currentTime,3) + "\t OK");

	reportEvent(doubleToString(currentTime,3) + "\t READING");

	AppCastingMOOSApp::PostReport();
	return(true);
}


//---------------------------------------------------------
// Procedure: buildReport
//---------------------------------------------------------
bool Sensor::buildReport()
{
	m_msgs << "Sensor name:\t" << m_sensor_name <<  endl << endl;


	m_msgs << "Degradation List (" << m_degradations.size() << ")" << endl;
	m_msgs << "------------------------------------------------"   << endl;
	m_msgs << "Start \t\tFinish \t\tDegradation\n"   << endl;
	for (unsigned i=0; i<m_degradations.size(); i++){
		m_msgs << m_degradations.at(i).toString() << endl;
	}

	return true;
}


//---------------------------------------------------------
// Procedure: handleDegradation
// check if the provided string is in the format start:end:degradationPercentage
// e.g. 50:100:50
//---------------------------------------------------------
bool Sensor::handleDegradation(string value)
{
	vector<string> v = parseString(removeWhite(value),":");

	//check if the provided string has 3 tokens
	if (v.empty() || v.size() != 3){
		reportConfigWarning("Problem with configuring 'DEGRADATTION ="+ value +"': expected 3 variables but received " + intToString(v.size()));
		return false;
	}

	//check if all tokens are doubles
	for (vector<string>::iterator it = v.begin();  it != v.end(); it++){
		if (!isNumber(*it, false)){
			reportConfigWarning("Problem with configuring 'DEGRADATTION ="+ value +"': expected double but received " + *it);
			return false;
		}
	}

	//check if the ending time is before the starting time
	if (atof(v.at(0).c_str()) > atof(v.at(1).c_str())){
		reportConfigWarning("Problem with configuring 'DEGRADATTION ="+ value +"': starting time (" +v.at(0) +") is after ending time (" +v.at(1)+") "
							"\n Ignored degradation: " + value);
		return false;
	}

	//if everything is OK, create a new degradation element and add it to the vector
	Degradation d =  Degradation( atof(v.at(0).c_str()),
			  	  	  	  	  	  atof(v.at(1).c_str()),
								  atof(v.at(2).c_str()));


	vector<Degradation>::iterator it = m_degradations.begin();
	for (;  it != m_degradations.end(); it++){
		if ((*it).getStartTime() > d.getFinishTime())
			break;
	}
	m_degradations.insert(it, d);

	return true;
}
