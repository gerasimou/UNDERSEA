package controllerRandom;

import java.util.Iterator;

import controller.Executor;
import controller.Knowledge;

public class ExecutorRandom extends Executor {

	String command;
	
	public ExecutorRandom() {
	}

	
	@Override
	public void run () {
		command = "SPEED="   + (Knowledge.getUUVspeed()) +",";
		
		Iterator<String> it = Knowledge.sensorsMap.keySet().iterator();
		while (it.hasNext()){
			String sensorName = it.next();
			command += sensorName +"="+ (Knowledge.getSensorState(sensorName));
			
			if (it.hasNext())
				command += ",";
		}
	}	

	
	@Override
	public String getCommand() {
		return command;
	}	

}
