package controllerPMC.prism;

//class that represents a data structure for storing an RQVResult
public class RQVResult{
	int 	sensor1;
	int		sensor2;
	int		sensor3;
	double 	speed;
	double 	req1Result; // expected number of accurate measurements
	double 	req2Result; // expected power consumption
	
	public RQVResult(){
		sensor1 	= -1;
		sensor2 	= -1;
		sensor3		= -1;
		speed		= -1;
		req1Result 	= -1;
		req2Result 	= -1;
	}
	
	public RQVResult (int CSC, double speed, double req1Result, double req2Result){
		this.sensor1 	= CSC%2;
		this.sensor2 	= CSC%4>1 ? 1 : 0;
		this.sensor3 	= CSC%8>3 ? 1 : 0;
		this.speed   	= speed;
		this.req1Result	= req1Result;
		this.req2Result	= req2Result;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    str.append("Sensor1:" + sensor1 + NEW_LINE);
	    str.append("Sensor2:" + sensor2 + NEW_LINE);
	    str.append("Sensor3:" + sensor3 + NEW_LINE);
	    str.append("Speed:" + speed + NEW_LINE);
	    str.append("Req1Result:" + req1Result + NEW_LINE);
	    str.append("Req2Result:" + req2Result + NEW_LINE);
		return str.toString();
	}
	
	public int getSensor1(){
		return sensor1;
	}
	
	public int getSensor2(){
		return sensor2;
	}
	
	public int getSensor3(){
		return sensor3;
	}

	public double getSpeed(){
		return speed;
	}
	
	public double getReq1Result(){
		return req1Result;
	}
	
	public double getReq2Result(){
		return req2Result;
	}



}