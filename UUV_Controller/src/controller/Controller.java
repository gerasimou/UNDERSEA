package controller;

import java.util.Random;

import auxiliary.Utility;
import controller.comms.Client;

public abstract class Controller {

	/** Sensor handle*/
	private Sensor sensor;
	
	/** Effector handle*/
	private Effector effector;

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
	    	host			= hostName;
	    	port			= portNumber;
	    	Client client	= new Client(host, port);
	    	
		    //init MAPE
			sensor 		= new Sensor(client);		    
		    effector 	= new Effector(client);		    
		    
			//init time window
			TIME_WINDOW = Double.parseDouble(Utility.getProperty("TIME_WINDOW"));
			
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
		
		Random rand = new Random(System.currentTimeMillis());

		do{
			now = System.currentTimeMillis();
			if (now - previousInvocation > (TIME_WINDOW * 1000)){
				
				sensor.run();
				System.out.println((now - start)/1000.0 +"\t"+ sensor.getReply());
				
				monitor.run();
				
				analyser.run();
				
				planner.run();
				
				executor.run();
				
				String sp = "SPEED="   + (rand.nextDouble()+3);
				String s1 = "SENSOR1=" + (rand.nextInt(4)-1);
				String s2 = "SENSOR2=" + (rand.nextInt(4)-1);
				String s3 = "SENSOR3=" + (rand.nextInt(4)-1);
				effector.setCommand(sp +","+ s1 +","+ s2 +","+ s3 +"\n");
				effector.run();
				System.out.println(effector.getReply());
				
				previousInvocation = now;
			}
		}
		while (now - start <= SIMULATION_TIME);
	}
	
}
