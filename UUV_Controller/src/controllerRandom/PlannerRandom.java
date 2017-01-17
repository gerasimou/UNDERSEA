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
		Knowledge.setUUVspeed(rand.nextDouble()+3);
		
		for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
			Knowledge.setSensorState(uuvSensor.getName(), rand.nextInt(4)-1);
		}
//		Knowledge.setSensorState("SENSOR1", rand.nextInt(4)-1);
//		Knowledge.setSensorState("SENSOR2", rand.nextInt(4)-1);
//		Knowledge.setSensorState("SENSOR3", rand.nextInt(4)-1);	
//		Knowledge.setSensorState("SENSOR3", rand.nextInt(4)-1);
		
	}	

}
