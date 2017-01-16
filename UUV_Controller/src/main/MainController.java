package main;

import controller.Analyser;
import controller.Controller;
import controller.Executor;
import controller.Monitor;
import controller.Planner;
import controllerRQV.AnalyserRQV;
import controllerRQV.ExecutorRQV;
import controllerRQV.MonitorRQV;
import controllerRQV.PlannerRQV;

public class MainController {

	public static String configFile = "resources/config.properties";	

	public static void main(String[] args) {
		//init MAPE elements
	    Monitor monitor  	= new MonitorRQV();
	    Analyser analyser	= new AnalyserRQV();
	    Planner planner		= new PlannerRQV();
	    Executor executor	= new ExecutorRQV();
		
		//create new controller
		Controller controller = new Controller(monitor, analyser, planner, executor);
					
		//start engine
		ControllerEngine.start(controller);
	}

}
