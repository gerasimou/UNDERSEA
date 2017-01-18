package controllerPMC;

import controller.Executor;
import controller.Knowledge;

public class ExecutorPMC extends Executor {

	String command;
	
	public ExecutorPMC() {
	}

	@Override
	public void run () {
		String sp = "SPEED="   + (Knowledge.getUUVspeed());
		String s1 = "SENSOR1=" + (Knowledge.getSensorState("SENSOR1"));
		String s2 = "SENSOR2=" + (Knowledge.getSensorState("SENSOR2"));
		String s3 = "SENSOR3=" + (Knowledge.getSensorState("SENSOR3"));
		command = sp +","+ s1 +","+ s2 +","+ s3;
//		System.out.println(command);
	}	

	
	@Override
	public String getCommand() {
		return command;
	}	

}
