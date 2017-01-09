package controllerRQV;

import java.util.Random;

import controller.Executor;

public class ExecutorRQV extends Executor {

	public ExecutorRQV() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand() {
		Random rand = new Random(System.currentTimeMillis());

		String sp = "SPEED="   + (rand.nextDouble()+3);
		String s1 = "SENSOR1=" + (rand.nextInt(4)-1);
		String s2 = "SENSOR2=" + (rand.nextInt(4)-1);
		String s3 = "SENSOR3=" + (rand.nextInt(4)-1);
		String command = sp +","+ s1 +","+ s2 +","+ s3;
		
		return command;
	}	

}
