/************************************************************/
/*    NAME: Simos Gerasimou                                              */
/*    ORGN: MIT                                             */
/*    FILE: UUV.h                                          */
/*    DATE:                                                 */
/************************************************************/

#ifndef UUV_HEADER
#define UUV_HEADER

#include "MOOS/libMOOS/Thirdparty/AppCasting/AppCastingMOOSApp.h"
#include <map>

class UUV : public AppCastingMOOSApp
{
	 public:
	   UUV();
	   ~UUV();
	   bool buildReport();


	 protected:
	   bool OnNewMail(MOOSMSG_LIST &NewMail);
	   bool Iterate();
	   bool OnConnectToServer();
	   bool OnStartUp();
	   void RegisterVariables();

	 private:
	   bool handleSensorsNames(std::string value);
	   void initSensorsMap();
	   void sendNotifications();


	 private: // Configuration variables
	   std::string m_uuv_name; //uuv name
	   std::vector<std::string> m_uuv_sensors;
	   double M_TIME_WINDOW;


	 private: // State variables
	   unsigned int m_iterations;
	   double       m_timewarp;

	   double m_app_start_time;
	   double m_current_iterate;
	   double m_previous_iterate;


	   struct Sensor{
	   	   public:
		   	   std::string toString()
		   	   {
		   		    std::string str = name +"\t\t"+ intToString(numOfReadings) +"\t\t"+ doubleToString(averageRate,2);
		   			return str;
		   	   }

		   	   void newReading()
		   	   {
		   		   numOfReadings += 1;
		   		   averageRate	  = numOfReadings / (MOOSTime(true) - time);
		   	   }

		   	   void reset()
		   	   {
		   		   numOfReadings	= 0;
				   averageRate  	= 0;
				   state			= -1;
				   time				= MOOSTime(true);
		   	   }

		   public:
			   std::string name;
			   int numOfReadings;
			   double averageRate;
			   int state;
			   double time;

	   };
	   typedef std::map<std::string, Sensor> sensorsMap;

	   sensorsMap m_sensors_map;

};

#endif 
