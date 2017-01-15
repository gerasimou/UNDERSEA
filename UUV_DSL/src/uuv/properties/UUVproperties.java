package uuv.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import auxiliary.DSLException;

public class UUVproperties {

	/** Simulation time*/
	private String simulationTime;
	
	/** Time window*/
	private String timeWindow;
	
	/** host*/
	private String host;

	/** port*/
	private String port;

	/** port*/
	private String speed;

	/** UUV*/
	private UUV uuv;

	/** Sensors*/
	private Map<String, Sensor> sensorsMap;

	
	public UUVproperties() {
		simulationTime 	= null;
		timeWindow		= null;
		host			= null;
		port			= null;
		speed			= null;
		uuv				= null;
		sensorsMap		= new HashMap<String, Sensor>();
	}
	
	
	public void setSimulationTime (String sm) throws DSLException{
		if (simulationTime != null)
			throw new DSLException("Simulation time is already defined.Value Ignored!");
		this.simulationTime = sm;
	}
	
	
	public void setTimeWindow (String tw) throws DSLException{
		if (timeWindow != null)
			throw new DSLException("Time Window is already defined. Value Ignored!");
		this.timeWindow = tw;
	}
	

	public void setHost (String h) throws DSLException{
		if (host != null)
			throw new DSLException("Host is already defined. Value Ignored!");
		this.host = h;
	}

	
	public void setPort (String p) throws DSLException{
		if (port != null)
			throw new DSLException("Port is already defined. Value Ignored!");
		this.port = p;
	}
	

	public void setSpeed(String s) throws DSLException{
		if (speed != null)
			throw new DSLException("Speed is already defined. Value Ignored!");
		this.speed = s;
	}

	
	public void setUUV(String name, String port, double min, double max, int steps) throws DSLException{
		if (uuv != null)
			throw new DSLException("UUV properties already defined. Block Ignored!");
		uuv = new UUV(name, port, min, max, steps);
	}


	public void setSensor(String name, double rate, double reliability) throws DSLException{
		if (sensorsMap.containsKey(name))
			throw new DSLException("Sensor "+ name + " properties already defined. Block Ignored!");
		Sensor newSensor = new Sensor(name, rate, reliability);
		sensorsMap.put(name, newSensor);
	}

	
	public void setDegradation(String sensorName, double begin, double end, double percentage) throws DSLException{
//		if (sensorsMap.containsKey(name))
//			throw new DSLException("Sensor "+ name + "properties already defined. Block Ignored!");
		Range newDegradation = new Range (begin, end, percentage);
		sensorsMap.get(sensorName).degradationsList.add(newDegradation);
	}

	
	
	class UUV{
		/** name*/
		private String name;

		/** port*/
		private String port;
		
		/** speed range*/
		private Range speedRange;
		

		public UUV(String name, String port, double min, double max, int steps){
			this.name			= name;
			this.port			= port;
			this.speedRange		= new Range (min, max, steps);
		}
		
		
		protected String getName(){
			return this.name;
		}
		
		
		protected String getPort(){
			return this.port;
		}
		
		
		protected double getSpeedMax(){
			return speedRange.max;
		}

		
		protected double getSpeedMin(){
			return speedRange.min;
		}
		
		
		protected int getSpeedSteps(){
			return (int) speedRange.value;
		}


	}

	
	
	class Sensor{
		/** name*/
		private String name;

		/** rate*/
		private double rate;

		/** reliability*/
		private double reliability;

		/** degradation list*/
		private List<Range> degradationsList;


		public Sensor(String name, double rate, double reliability){
			this.name				= name;
			this.rate				= rate;
			this.reliability		= reliability;
			this.degradationsList	= new ArrayList<Range>();
		}
		
		protected String getName(){
			return this.name;
		}
		
		
		protected double getRate(){
			return this.rate;
		}
		
		
		protected double getReliability(){
			return this.reliability;
		}

	}
	
	
	class Range{
		/** begin*/
		private double min;

		/** end*/
		private double max;

		/** percentage*/
		private Number value;

		public Range (double min, double max, Number value){
			this.min 		= min;
			this.max 		= max;
			this.value		= value;
		}
	}
}



