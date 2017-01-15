package uuv.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	private String simulationSpeed;

	/** UUV*/
	private UUV uuv;

	/** Sensors*/
	private Map<String, Sensor> sensorsMap;

	
	public UUVproperties() {
		simulationTime 	= null;
		timeWindow		= null;
		host			= null;
		port			= null;
		simulationSpeed	= null;
		uuv				= null;
		sensorsMap		= new HashMap<String, Sensor>();
	}
	
	
	public void checkProperties() throws DSLException{
		StringBuilder errors = new StringBuilder();
		if (simulationTime == null)
			errors.append("* Undefined simulation time! (e.g., simulation time = 10)\n");
		if (simulationSpeed == null)
			errors.append("* Undefined simulation speed! (e.g., simulation speed = 2)\n");
		if (timeWindow == null)
			errors.append("* Undefined time window! (e.g., time window = 10)\n");
		if (host == null)
			errors.append("* Undefined host! (e.g., host = localhost)\n");
		if (port == null)
			errors.append("* Undefined port! (e.g., port = 12345)\n");
		if (uuv == null)
			errors.append("* Undefined uuv configuration block! (e.g., UUV {...})\n");
		if (sensorsMap.size() == 0)
			errors.append("* No sensors found! (e.g., (e.g., Sensor {...})\n");
		
		if (errors.length() > 0)
			throw new DSLException( "Incorrect configuration file!\n" + errors.toString());
	
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
		if (simulationSpeed != null)
			throw new DSLException("Speed is already defined. Value Ignored!");
		this.simulationSpeed = s;
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
		sensorsMap.get(sensorName).addDegradation(newDegradation);
	}

	
	
	class UUV{
		/** name*/
		private String name;

		/** name*/
		private String rate;

		/** port*/
		private String port;
		
		/** speed range*/
		private Range speedRange;
		

		public UUV(String name, String port, double min, double max, int steps){
			this.name			= name;
			this.port			= port;
			this.speedRange		= new Range (min, max, steps);
			this.rate			= "4";
		}
		
		
		public String getName(){
			return this.name;
		}
		
		
		public String getPort(){
			return this.port;
		}
		
		
		public double getSpeedMax(){
			return speedRange.max;
		}

		
		public double getSpeedMin(){
			return speedRange.min;
		}
		
		
		public int getSpeedSteps(){
			return (int) speedRange.value;
		}


		public String toString(){
			StringBuilder str = new StringBuilder();
			str.append("//------------------------------------------\n");
			str.append("// sUUV config block\n");
			str.append("//------------------------------------------\n");
			str.append("ProcessConfig = " + name +"\n");
			str.append("{\n");
			str.append("\t AppTick = " + rate +"\n");
			str.append("\t CommsTick = " +  rate +"\n");
			str.append("\t MAX_APPCAST_EVENTS = 25 \n");
			str.append("\t NAME = " + name +"\n");
			str.append("\t PORT = " + port +"\n");
			
			String sensorsStr = "";
			Iterator<String> iterator = sensorsMap.keySet().iterator();
			while (iterator.hasNext()){
				sensorsStr += iterator.next();
				if (iterator.hasNext())
					sensorsStr += ",";
			}
			str.append("\t SENSORS = " + sensorsStr +"\n");
			
			str.append("}\n\n");
			
			return str.toString();
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
		
		
		protected void addDegradation(Range degradation){
			degradationsList.add(degradation);
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

		
		public String toString(){
			StringBuilder str = new StringBuilder();
			str.append("//------------------------------------------\n");
			str.append("// sSensor config block\n");
			str.append("//------------------------------------------\n");
			str.append("ProcessConfig = " + name +"\n");
			str.append("{\n");
			str.append("\t AppTick = " + rate +"\n");
			str.append("\t CommsTick = " + rate +"\n");
			str.append("\t MAX_APPCAST_EVENTS = 25 \n");
			str.append("\t NAME = " + name +"\n");
			str.append("\t RELIABILITY = " + reliability +"\n");
			for (Range d  : degradationsList){
				str.append("\t DEGRADATION = " + d.toString() +"\n");
			}				
			str.append("}\n\n");
			
			return str.toString();
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
		
		public String toString(){
			return min +":"+ max +":"+ value;
		}
	}
}



