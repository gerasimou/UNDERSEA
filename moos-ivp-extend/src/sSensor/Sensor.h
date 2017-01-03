/************************************************************/
/*    NAME: Simos Gerasimou                                 */
/*    ORGN: University of York, UK                          */
/*   FILE: Sensor.h                                         */
/*    DATE: 2016                                            */
/************************************************************/

#ifndef Sensor_HEADER
#define Sensor_HEADER

#include "MOOS/libMOOS/MOOSLib.h"

class Sensor : public CMOOSApp
{
 public:
   Sensor();
   ~Sensor();

 protected:
   bool OnNewMail(MOOSMSG_LIST &NewMail);
   bool Iterate();
   bool OnConnectToServer();
   bool OnStartUp();
   void RegisterVariables();

 private: // Configuration variables

 private: // State variables
   unsigned int m_iterations;
   double       m_timewarp;
};

#endif 
