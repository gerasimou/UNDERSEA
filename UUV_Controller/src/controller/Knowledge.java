package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import auxiliary.Utility;
import controller.uuv.UUV;
import controller.uuv.UUVSensor;
import controllerPMC.prism.PMCResult;

public class Knowledge {

	private Knowledge() {}

	/** UUV*/
	public static UUV uuv = new UUV("name");

	/** Sensors*/
	public static Map<String, UUVSensor> sensorsMap = new HashMap<String, UUVSensor>();
	
    /** Structure that keeps the result after PMC */
    public static Map<Integer,PMCResult> PMCResultsMap = new HashMap<Integer, PMCResult>();    

	/** flag showning whether analysis is required*/
	public static boolean analysisRequired = false;

	public static void setUUVspeed (double s){
		uuv.setSpeed(s);
	}
	
	
	public static double getUUVspeed (){
		return uuv.getSpeed();
	}
	
	
	public static void setSensorRate (String sensorName, double rate){
		if (!sensorsMap.containsKey(sensorName))
			sensorsMap.put(sensorName, new UUVSensor(sensorName, rate));
		sensorsMap.get(sensorName).setRate(rate);
	}
	
	
	public static double getSensorRate (String sensorName){
		try{
			return sensorsMap.get(sensorName).getRate();
		} catch (NullPointerException e){
			return 0;
		}
	}
	
	
	public static void setSensorState (String sensorName, int state){
		sensorsMap.get(sensorName).setState(state);
	}

	
	public static double getSensorState (String sensorName){
		try{
			return sensorsMap.get(sensorName).getState();
		} catch (NullPointerException e){
			return 0;
		}
	}

	
	public static boolean systemStateChanged(){
		if (!uuv.speedSame())
			return true;
		for (UUVSensor uuvSensor : sensorsMap.values()){
			if (!uuvSensor.rateSame())
				return true;
		}
		return false;
	}
	
	
	public static void addResult (int index, PMCResult result){
		PMCResultsMap.put(index, result);
	}

	public static void logData(){
		System.out.println(uuv.getSpeedList().size());
		for (UUVSensor sensor : sensorsMap.values()){
			System.out.println(sensor.getRatesList().size() + ","+sensor.getStatesList().size());
		}

		StringBuilder outputStr = new StringBuilder();
		for (int i=0; i<uuv.getSpeedList().size(); i++){
			
			//append sensor rates first
			for (UUVSensor sensor : sensorsMap.values()){
				outputStr.append(sensor.getRatesList().get(i) + ","); 
			}
			//append sensor rates first
			for (UUVSensor sensor : sensorsMap.values()){
				outputStr.append(sensor.getStatesList().get(i) + ","); 
			}
			//append current UUV speed
			outputStr.append(uuv.getSpeedList().get(i) + "\n");
		}
		
		Utility.exportToFile("log.csv", outputStr.toString(), false);
	}
}


