package controllerControlTheory;

import controller.Controller;

public class ControllerCT extends Controller {

	
	public ControllerCT() {
		//call superclass
		super("localhost", 8888);

		//init MAPE elements
	    monitor  	= new MonitorCT();
	    analyser	= new AnalyserCT();
	    planner		= new PlannerCT();
	    executor	= new ExecutorCT();
	}
	
}
