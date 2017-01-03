/************************************************************/
/*    NAME: Simos Gerasimou                                              */
/*    ORGN: MIT                                             */
/*    FILE: Sensor.h                                          */
/*    DATE:                                                 */
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
