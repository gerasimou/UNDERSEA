/************************************************************/
/*    NAME: Simos Gerasimou                                 */
/*    ORGN: University of York, UK                          */
/*    FILE: Failure.h                                       */
/*    DATE: 2016                                            */
/************************************************************/


#ifndef SRC_SSENSOR_DEGRADATION_H_
#define SRC_SSENSOR_DEGRADATION_H_

#include <string>

class Degradation {
	public:
		Degradation(double start, double finish, double degradation);
		virtual ~Degradation();

		std::string toString();
		double getStartTime();
		double getFinishTime();
		double getDegradation();

	private:
		double m_start; 		//failure starting time
		double m_finish;		//failure finishing time
		double m_degradation;	//percentage degradation (based on -sensor- nominal operating rate)
};

#endif /* SRC_SSENSOR_DEGRADATION_H_ */
