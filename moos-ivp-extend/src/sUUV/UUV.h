/************************************************************/
/*    NAME: Simos Gerasimou                                              */
/*    ORGN: MIT                                             */
/*    FILE: UUV.h                                          */
/*    DATE:                                                 */
/************************************************************/

#ifndef UUV_HEADER
#define UUV_HEADER

#include "MOOS/libMOOS/MOOSLib.h"

class UUV : public CMOOSApp
{
 public:
   UUV();
   ~UUV();

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
