package controller;

import java.io.IOException;
import java.util.Random;

import auxiliary.Utility;
import controller.comms.Client;

public abstract class Controller {

	/** Sensor handle*/
	private Sensor sensor;
	
	/** Effector handle*/
	private Effector effector;
	
	/** Comms handle*/
	private Client client;

	/** Monitor handle*/
	protected Monitor monitor;

	/** Analyser handle*/
	protected Analyser analyser;

	/** Planner handle*/
	protected Planner planner;

	/** Executor handle*/
	protected Executor executor;
	
	/** Socket details*/
	private String host;//	= "localhost";
	private int port;// 		= 8888;
	
    /** Time window for invoking the uuv*/
    private double TIME_WINDOW;
    
    /** Simulation time*/
    private double SIMULATION_TIME;

	
	/**
	 * Controller constructor
	 */
	public Controller(String hostName, int portNumber) {		
	    try {
	    	//init comms client
	    	host	= hostName;
	    	port	= portNumber;
	    	client	= new Client(host, port);
	    	
		    //init MAPE
			sensor 		= new Sensor(client);		    
		    effector 	= new Effector(client);		    
		    
			//init time window
			TIME_WINDOW = Double.parseDouble(Utility.getProperty("TIME_WINDOW")) * 1000;
			
			//init sumulation time
			SIMULATION_TIME = Double.parseDouble(Utility.getProperty("SIMULATION_TIME")) * 1000;
	    }
	    catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * start the controller
	 */
	public void run(){
		long previousInvocation = System.currentTimeMillis();
		
		long now, start=previousInvocation;
		
		do{
			now = System.currentTimeMillis();
			if (now - previousInvocation > (TIME_WINDOW)){
				
				sensor.run();
				System.out.println((System.currentTimeMillis() - start)/1000.0 +"\tSending:\t"+ sensor.getReply());
				
				monitor.run();
				
				analyser.run();
				
				planner.run();
				
				executor.run();
				
				effector.setCommand(executor.getCommand());
				effector.run();
				System.out.println((System.currentTimeMillis() - start)/1000.0 +"\tReceived:\t"+ effector.getReply() +"\n");
				
				previousInvocation = now;
			}
		}
		while (now - start <= SIMULATION_TIME);
		shutDown();
	}
	
	
	
	private void shutDown(){
		boolean closed = false;
		
		try {
			closed = client.shutDown();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if (closed)
				System.out.println("Comms terminated correctly!");
			else
				System.out.println("Something was wrong with terminating comms!");
		}
	}
	
}
