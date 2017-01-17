package controller;

public class Knowledge {

	private Knowledge() {}

	private static double speed;
	
	private static int sensor1State;
	private static int sensor2State;
	private static int sensor3State;
	
	
	public static void setUUVspeed (double s){
		speed = s;
	}
		
	public static double getUUVspeed (){
		return speed;
	}
	
	
	public static void setSensorState (int sensorID, int state){
		switch (sensorID){
			case 1:{ 	sensor1State = state;
						break;
				   }
			case 2:{ 	sensor2State = state;
						break;
				   }
			case 3:{ 	sensor3State = state;
						break;
				   }
		}
	}

	
	public static int getSensorState (int sensorID){
		switch (sensorID){
			case 1:{ 	return sensor1State;
				   }
			case 2:{ 	return sensor2State;
				   }
			case 3:{ 	return sensor3State;
				   }
			default:
				return 5;
		}
	}
	
	
	

}
