package main;

import controller.Analyser;
import controller.Controller;
import controller.Executor;
import controller.Monitor;
import controller.Planner;
import controllerPMC.AnalyserPMC;
import controllerPMC.ExecutorPMC;
import controllerPMC.MonitorPMC;
import controllerPMC.PlannerPMC;

public class MainController {

	public static String configFile = "resources/config.properties";	

	public static void main(String[] args) {
		//init MAPE elements
//	    Monitor monitor  	= new MonitorRandom();
//	    Analyser analyser	= new AnalyserRandom();
//	    Planner planner		= new PlannerRandom();
//	    Executor executor	= new ExecutorRandom();

	    Monitor monitor  	= new MonitorPMC();
	    Analyser analyser	= new AnalyserPMC();
	    Planner planner		= new PlannerPMC();
	    Executor executor	= new ExecutorPMC();

		
		//create new controller
		Controller controller = new Controller(monitor, analyser, planner, executor);
					
		//start engine
		ControllerEngine.start(controller);
	}

}
