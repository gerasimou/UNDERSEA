package controllerRandom;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;

public class PlannerRandom extends Planner {

	Random rand = new Random(System.currentTimeMillis());

	
	public PlannerRandom() {
	}

	@Override
	public void run() {
		Knowledge.setUUVspeed(rand.nextDouble()+3);
		Knowledge.setSensorState(1, rand.nextInt(4)-1);
		Knowledge.setSensorState(2, rand.nextInt(4)-1);
		Knowledge.setSensorState(3, rand.nextInt(4)-1);
	}	

}
