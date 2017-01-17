package controllerRandom;

import controller.Executor;
import controller.Knowledge;

public class ExecutorRandom extends Executor {

	public ExecutorRandom() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand() {

		String sp = "SPEED="   + (Knowledge.getUUVspeed());
		String s1 = "SENSOR1=" + (Knowledge.getSensorState(1));
		String s2 = "SENSOR2=" + (Knowledge.getSensorState(2));
		String s3 = "SENSOR3=" + (Knowledge.getSensorState(3));
		String command = sp +","+ s1 +","+ s2 +","+ s3;
		
		return command;
	}	

}
