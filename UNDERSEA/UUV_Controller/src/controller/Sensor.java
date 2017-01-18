package controller;

import java.io.IOException;

import controller.comms.Client;

public class Sensor {

	/** Communication handles*/
    private Client client;			

    /** Command to send to managed system*/
    private String command = "SENSORS";
    
    /** Reply from managed system*/
    private String reply;
    
    /**
     * Constructor: create a new sensor
     */
	public Sensor(Client client) {
		//assign client handler
		this.client = client;		
	}

	
	protected void run (){
		try {
			reply = client.write(command); 
			parseReply(reply);
		} 
		catch (IOException e) {
			e.printStackTrace();
			reply = "ERROR";
		}
	}	
	
	
	private void parseReply (String reply){
		//SENSOR1=2.49,SENSOR2=2.14,SENSOR3=1.96,SENSOR4=1.78
		String[] sensorsStr = reply.split(",");
		
		for (String str : sensorsStr){
			String[] sensorData = str.split("=");
			Knowledge.setSensorRate(sensorData[0], Double.parseDouble(sensorData[1]));
		}
	}
	
	
	public String getReply(){
		return this.reply;
	}
}
