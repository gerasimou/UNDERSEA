package controllerRandom;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;
import controller.uuv.UUVSensor;

public class PlannerRandom extends Planner {

	Random rand = new Random(System.currentTimeMillis());

	
	public PlannerRandom() {
	}

	@Override
	public void run () {
		Knowledge.setUUVspeed(rand.nextDouble() + rand.nextInt(4));
		
		for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
			Knowledge.setSensorState(uuvSensor.getName(), rand.nextInt(2)-1);
		}
	}	

}
