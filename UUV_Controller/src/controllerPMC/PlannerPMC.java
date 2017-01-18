package controllerPMC;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;
import controller.uuv.UUVSensor;

public class PlannerPMC extends Planner {

	Random rand = new Random(System.currentTimeMillis());

	public PlannerPMC() {
	}

	@Override
	public void run() {
		Knowledge.setUUVspeed(rand.nextDouble()+3);
		
		for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
			Knowledge.setSensorState(uuvSensor.getName(), rand.nextInt(4)-1);
		}		
	}	

}
