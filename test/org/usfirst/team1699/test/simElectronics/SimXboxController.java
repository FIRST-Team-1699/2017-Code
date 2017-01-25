package org.usfirst.team1699.test.simElectronics;

import java.util.HashMap;
import java.util.Map;

public class SimXboxController{
	private enum Button {A, B, X, Y, Back, Start, LSButton, RSButton, RBumper, LBumper}; //Available buttons on the controller
	private enum State {Pressed, Released}; //Valid states for a button
	private double rightStickValue; //Right stick value
	private double leftStickValue; //Left stick value
	private Map<Button, State> stateMap = new HashMap<>(); //Maps each button to a state

	public SimXboxController() {
		//Sets values to zero
		this.rightStickValue = 0; 
		this.leftStickValue = 0;
	}
	
	public void setState(Button b, State s){
		//Sets state for a certain button
		stateMap.put(b, s);
	}
	
	public State getState(Button b){
		//Gets state for a button
		return stateMap.get(b);
	}
	
	public double getRightStickValue() {
		//Gets value for right stick
		return rightStickValue;
	}
	
	public void setRightStickValue(double rightStickValue) {
		//Sets value for right stick
		this.rightStickValue = rightStickValue;
	}

	public double getLeftStickValue() {
		return leftStickValue;
	}

	public void setLeftStickValue(double leftStickValue) {
		this.leftStickValue = leftStickValue;
	}

	public Map<Button, State> getStateMap() {
		return stateMap;
	}
}
