package controllerPMC;

import java.util.List;

import auxiliary.Utility;
import controller.Analyser;
import controllerPMC.prism.PrismAPI;
import controllerPMC.prism.RQVResult;

public class AnalyserPMC extends Analyser {

	/** PRISM instance */
	PrismAPI prism;

	/** Name of model file */
	String modelFileName;

	/** Name of properties file */
	String propertiesFileName;
	
	/** Model string*/
	String modelAsString;

    /** output file */
    String fileName;
    
    /** Structure that keeps the result after RQV (i.e., reliability, cost, and response time) */
    private RQVResult RQVResultsArray[];    
    
    /** System characteristics*/
    private final int NUM_OF_SENSORS		;
    private final int NUM_OF_SENSOR_CONFIGS	;//possible sensor configurations
    private final int NUM_OF_SPEED_CONFIGS	; // [0,21], discrete steps
    private final int NUM_OF_CONFIGURATIONS ;

    
	/**
	 * Constructor
	 */
	public AnalyserPMC() {		
		//init system characteristics 
	    NUM_OF_SPEED_CONFIGS	= 21; // [0,21], discrete steps
	    NUM_OF_SENSORS			= 3;
	    NUM_OF_SENSOR_CONFIGS	= (int) (Math.pow(2,NUM_OF_SENSORS)); //possible sensor configurations
	    NUM_OF_CONFIGURATIONS	= (NUM_OF_SENSOR_CONFIGS-1) * NUM_OF_SPEED_CONFIGS; //discard configuration in which all sensors are switch off

		try{
			//Read  model and properties parameters
			this.modelFileName 		= Utility.getProperty("MODEL_FILE");
			this.propertiesFileName	= Utility.getProperty("PROPERTIES_FILE");

			//initialise PRISM instance
			this.prism = new PrismAPI();
			prism.setPropertiesFile(propertiesFileName);

		
			//Read the model
			this.modelAsString = Utility.readFile(modelFileName);		

			//init the output file
			this.fileName = Utility.getProperty("RQV_OUTPUT_FILE");		    
		    
			//init structure for storing QV results
			this.RQVResultsArray = new RQVResult[NUM_OF_CONFIGURATIONS];
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
    }	
    
    
    /**
     * Run quantitative verification
     * @param parameters
     */
	public void  run(){
		Object[] parameters = null;
		
		//For all configurations run QV and populate RQVResultArray
		for (int CSC=1; CSC<NUM_OF_SENSOR_CONFIGS; CSC++){
			for (int s=20; s<=40; s++){

				int index 	= ((CSC-1)*21)+(s-20);

				Object[] arguments = new Object[9]; 
				arguments[0]	= parameters[0];
				arguments[1]	= parameters[1];
				arguments[2]	= parameters[2];
				arguments[3]	= estimateP(s/10.0, 5);
				arguments[4]	= estimateP(s/10.0, 7);
				arguments[5]	= estimateP(s/10.0, 11);
				arguments[6]	= parameters[3];
				arguments[7]	= CSC;
				arguments[8]	= s/10.0;
				
				
				//1) Instantiate parametric stochastic model								
				String modelString = realiseProbabilisticModel(arguments);
				
				//2) load PRISM model
				prism.loadModel(modelString);
	
				//3) run PRISM
				List<Double> prismResult 	= prism.runPrism();
				double req1result 			= prismResult.get(0);
				double req2result 			= prismResult.get(1);
				
				//4) store configuration results
				RQVResultsArray[index] = new RQVResult(CSC, s/10.0, req1result, req2result);
			}
		}
		
		//return RQVResult for all configurations
//		return RQVResultsArray;
		
	}

			
	/**
	 * Estimate Probability of producing a successful measurement
	 * @param speed
	 * @param alpha
	 * @return
	 */
	private static double estimateP(double speed, double alpha){
		return 100 - alpha * speed;
	}

	
	
    /**
     * Generate a complete and correct PRISM model using parameters given
     * @param parameters for creating a correct PRISM model
     * @return a correct PRISM model instance as a String
     */
    private String realiseProbabilisticModel(Object ... parameters){
    	StringBuilder model = new StringBuilder(modelAsString + "\n\n//Variables\n");

    	//process the given parameters
		model.append("const double r1  = "+ parameters[0].toString() +";\n");
		model.append("const double r2  = "+ parameters[1].toString() +";\n");
		model.append("const double r3  = "+ parameters[2].toString() +";\n");
		model.append("const double p1  = "+ parameters[3].toString() +";\n");
		model.append("const double p2  = "+ parameters[4].toString() +";\n");
		model.append("const double p3  = "+ parameters[5].toString() +";\n");
		model.append("const int    PSC = "+ parameters[6].toString() +";\n");
		model.append("const int    CSC = "+ parameters[7].toString() +";\n");
		model.append("const double s   = "+ parameters[8].toString() +";\n\n");
    	
    	return model.toString();
    }
}
