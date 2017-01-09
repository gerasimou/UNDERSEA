package main;

import controller.Controller;
import controllerRQV.ControllerRQV;

public class MainController {

	public static String configFile = "resources/config.properties";	

	
	public static void main(String[] args) {
		try {
			Controller controller = new ControllerRQV();
			controller.run();
			System.exit(-1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
