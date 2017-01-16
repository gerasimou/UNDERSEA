package main;

import controller.Controller;
import controllerRQV.ControllerRQV;

public class MainController {

	public static String configFile = "resources/config.properties";	

	public static void main(String[] args) {
		//create new controller
		Controller controller = new ControllerRQV();
					
		//start engine
		ControllerEngine.start(controller);
	}

}
