/************************************************************/
/*    NAME: Simos Gerasimou                                 */
/*    ORGN: University of York, UK                          */
/*    FILE: Failure.cpp                                     */
/*    DATE: 2016                                            */
/************************************************************/

#include "Degradation.h"
#include "MBUtils.h"

using namespace std;

Degradation::Degradation(double start, double finish, double degradation)
{
	m_start  		= start;
	m_finish 	  	= finish;
	m_degradation 	= degradation==0 ? 0.0000001 : degradation ;
}


Degradation::~Degradation()
{
}


double Degradation::getStartTime()
{
	return m_start;
}


double Degradation::getFinishTime()
{
	return m_finish;
}


double Degradation::getDegradation()
{
	return m_degradation;
}


string Degradation::toString()
{
	string str = doubleToString(m_start,2) +"\t\t"+ doubleToString(m_finish,2) +"\t\t"+ doubleToString(m_degradation,2);
	return str;
}

