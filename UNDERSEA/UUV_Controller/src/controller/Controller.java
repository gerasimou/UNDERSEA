package controller;

import java.io.IOException;
import java.util.TimerTask;

import auxiliary.Utility;
import controller.comms.Client;

public class Controller extends TimerTask{

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
    private long TIME_WINDOW;
    
    /** Simulation time*/
    private long SIMULATION_TIME;
    
    /** Simulation speed*/
    private static long SIMULATION_SPEED;

    
    private long start = System.currentTimeMillis();		

	
	/**
	 * Controller constructor
	 */
	public Controller(Monitor monitor, Analyser analyser, Planner planner, Executor executor) {		
	    try {
	    	//init comms client
	    	host	= "localhost";
	    	port	= Integer.parseInt(Utility.getProperty("PORT"));
	    	client	= new Client(host, port);
	    	
		    //init MAPE
			sensor 		= new Sensor(client);		    
		    effector 	= new Effector(client);		    
		    
		    this.monitor 	= monitor;
		    this.analyser	= analyser;
		    this.planner	= planner;
		    this.executor	= executor;
		    
			//init time window
			TIME_WINDOW = Math.round(Double.parseDouble(Utility.getProperty("TIME_WINDOW")) * 1000);
			
			//init sumulation time
			SIMULATION_TIME = Math.round(Double.parseDouble(Utility.getProperty("SIMULATION_TIME")) * 1000);
			
			//init simulation speed
			SIMULATION_SPEED = Math.round(Double.parseDouble(Utility.getProperty("SIMULATION_SPEED")));
	    }
	    catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * start the controller
	 */
	public void run(){			
		sensor.run();
		System.out.println((System.currentTimeMillis() - start)/1000.0*SIMULATION_SPEED 
							+"\tSending:\t"+ sensor.getReply());				
		monitor.run();
		
		analyser.run();
		
		planner.run();
		
		executor.run();
		
		effector.setCommand(executor.getCommand());
		effector.run();
		System.out.println((System.currentTimeMillis() - start)/1000.0*SIMULATION_SPEED 
							+"\tReceived:\t"+ effector.getReply() +"\n");					
	}
	
	
	public void shutDown(){
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
	
	
	
	/**
	 * start the controller
	 */
	@Deprecated
	public void run2(){
//		long previousInvocation = System.currentTimeMillis();
//		
//		long now, start=previousInvocation;
//				
//		do{
//			now = System.currentTimeMillis();
//			if (now - previousInvocation > (TIME_WINDOW)){
//				previousInvocation = now;
//				
//				sensor.run();
//				System.out.println((System.currentTimeMillis() - start)/1000.0 +"\tSending:\t"+ sensor.getReply());
//				
//				monitor.run();
//				
//				analyser.run();
//				
//				planner.run();
//				
//				executor.run();
//				
//				effector.setCommand(executor.getCommand());
//				effector.run();
//				System.out.println((System.currentTimeMillis() - start)/1000.0 +"\tReceived:\t"+ effector.getReply() +"\n");				
//			}	
//		}
//		while (now - start <= SIMULATION_TIME);
//		shutDown();
	}
	
}
