package controllerRQV;

import auxiliary.Utility;
import controller.Controller;

public class ControllerRQV extends Controller {

	
	public ControllerRQV() {
		//call superclass
		super("localhost", Integer.parseInt(Utility.getProperty("PORT")));

		//init MAPE elements
	    monitor  	= new MonitorRQV();
	    analyser	= new AnalyserRQV();
	    planner		= new PlannerRQV();
	    executor	= new ExecutorRQV();
	}
	
}
