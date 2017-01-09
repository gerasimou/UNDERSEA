package controllerRQV;

import controller.Controller;

public class ControllerRQV extends Controller {

	
	public ControllerRQV() {
		//call superclass
		super("localhost", 8888);

		//init MAPE elements
	    monitor  	= new MonitorRQV();
	    analyser	= new AnalyserRQV();
	    planner		= new PlannerRQV();
	    executor	= new ExecutorRQV();
	}
	
}
