package controllerPMC;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;
import controllerPMC.prism.PMCResult;

public class PlannerPMC extends Planner {

	Random rand = new Random(System.currentTimeMillis());

	public PlannerPMC() {
	}

	@Override
	public void run() {
		int bestIndex		= -1;
		double bestCost 	= Double.MAX_VALUE;
		double MIN_READINGS = 20;
		double MAX_ENERGY	= 120;
		
		//analyse configuration
		for (Integer index : Knowledge.PMCResultsMap.keySet()){
			PMCResult result = Knowledge.PMCResultsMap.get(index);
			if ( (result.getReq1Result()>MIN_READINGS) && 
				 (result.getReq2Result()<MAX_ENERGY)  &&
				 ( result.getCost() < bestCost) ){
				bestCost 	= result.getCost();
				bestIndex	= index;
			}
		}
		
		//set new speed
		double desiredSpeed = Knowledge.PMCResultsMap.get(bestIndex).getSpeed();
		Knowledge.setUUVspeed(desiredSpeed);
		
		//set new sensor configuration
//		for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
			Knowledge.setSensorState("SENSOR1", Knowledge.PMCResultsMap.get(bestIndex).getSensor1());
			Knowledge.setSensorState("SENSOR2", Knowledge.PMCResultsMap.get(bestIndex).getSensor2());
			Knowledge.setSensorState("SENSOR3", Knowledge.PMCResultsMap.get(bestIndex).getSensor3());
//		}		
	}	

}
