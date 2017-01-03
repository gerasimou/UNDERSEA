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


	 private: // Configuration variables
	   std::string m_uuv_name; //uuv name
	   std::vector<std::string> m_uuv_sensors;


	 private: // State variables
	   unsigned int m_iterations;
	   double       m_timewarp;

	   struct Sensor{
	   	   protected:
		   	   std::string toString()
		   	   {
		   		    std::string str = name +"\t\t"+ intToString(numOfReadings) +"\t\t"+ doubleToString(averageRate,2);
		   			return str;
		   	   }

		   public:
			   std::string name;
			   int numOfReadings;
			   double averageRate;
			   int state;

	   };
	   typedef std::map<std::string, Sensor> sensorsMap;

	   sensorsMap m_sensors_map;

};

#endif 
