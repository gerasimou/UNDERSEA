package controller.uuv;

import java.util.ArrayList;
import java.util.List;

public class UUVSensor{
	/** name*/
	private String name;
	
	/** current rate*/
	private double currentRate;

	/** rate history*/
	protected List<Double> ratesList;
	
	/** current state*/
	private int currentState;

	/** states history*/
	protected List<Integer> statesList;

	
	public UUVSensor(String name, double rate){
		this.name			= name;
		this.currentRate	= rate;
		this.currentState	= -1;
		this.ratesList		= new ArrayList<Double>();
		this.statesList		= new ArrayList<Integer>();
	}
			
	public String getName(){
		return this.name;
	}
	
	public double getRate(){
		return this.currentRate;
	}

	public double getState(){
		return this.currentState;
	}
	
	public List<Double> getRatesList(){
		return this.ratesList;
	}

	public List<Integer> getStatesList(){
		return this.statesList;
	}

	public void setRate(double r){
		this.currentRate = r;
		this.ratesList.add(r);
	}

	public void setState(int s){
		this.currentState = s;
		this.statesList.add(s);
	}

	public boolean rateSame(){
		int size = ratesList.size();
		return ( (ratesList.get(size-1)) == (ratesList.get(size-2)));
	}

}