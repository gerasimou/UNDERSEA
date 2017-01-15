package uuv.dsl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uuv.dsl.gen.UUVBaseListener;
import uuv.dsl.gen.UUVParser;
import uuv.dsl.gen.UUVParser.DegradationContext;

public class UUVListener extends UUVBaseListener {

	
	@Override 
	public void enterSimulation(UUVParser.SimulationContext ctx) { 
		System.out.println(ctx.value.getText());
	}
	
	
	@Override 
	public void enterInvocation(UUVParser.InvocationContext ctx) { 
		System.out.println(ctx.value.getText());
	}

	@Override 
	public void enterSensor(UUVParser.SensorContext ctx) {		
		System.out.println(ctx.getText());
		String name 		= ctx.name.getText();
		String reliability	= ctx.reliability.getText();
		String rate			= ctx.rate.getText();
		
		List<String> degradationList = new ArrayList<String>();
		for (DegradationContext d : ctx.degradation()){
			degradationList.add(d.begin.getText());
			degradationList.add(d.end.getText());
			degradationList.add(d.value.getText());
		}
		
		System.out.println( 	name +"\n"
							+ 	reliability +"\n"
							+ 	rate +"\n"
							+	Arrays.toString(degradationList.toArray())
						  );
	}


	
	
}
