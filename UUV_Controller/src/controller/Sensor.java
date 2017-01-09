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
		} 
		catch (IOException e) {
			e.printStackTrace();
			reply = "ERROR";
		}
	}	
	
	
	public String getReply(){
		return this.reply;
	}
}
