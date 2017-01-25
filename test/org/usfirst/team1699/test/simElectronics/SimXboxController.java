package org.usfirst.team1699.test.simElectronics;

import java.util.HashMap;
import java.util.Map;

public class SimXboxController{
	private enum Button {A, B, X, Y, Back, Start, LSButton, RSButton, RBumper, LBumper}; //Available buttons on the controller
	private enum State {Pressed, Released}; //Valid states for a button
	private double rightStickValue; //Right stick value
	private double leftStickValue; //Left stick value
	private Map<Button, State> stateMap = new HashMap<>(); //Maps each button to a state

	/**
	 * Constructor
	 */
	public SimXboxController() {
		//Sets values to zero
		this.rightStickValue = 0; 
		this.leftStickValue = 0;
	}
	
	/**
	 * Sets state for a button
	 * 
	 * @param b
	 * @param s
	 */
	public void setState(Button b, State s){
		stateMap.put(b, s);
	}
	
	/**
	 * Gets state for a button
	 * 
	 * @param b
	 * @return State
	 */
	public State getState(Button b){
		return stateMap.get(b);
	}
	
	/**
	 * Returns right stick value
	 * 
	 * @return rightStickValue
	 */
	public double getRightStickValue() {
		return rightStickValue;
	}
	
	/**
	 * Sets right stick value
	 * 
	 * @param rightStickValue
	 */
	public void setRightStickValue(double rightStickValue) {
		this.rightStickValue = rightStickValue;
	}

	/**
	 * Returns leftStickValue
	 * 
	 * @return leftStickValue
	 */
	public double getLeftStickValue() {
		return leftStickValue;
	}

	/**
	 * Sets left stick value
	 * 
	 * @param leftStickValue
	 */
	public void setLeftStickValue(double leftStickValue) {
		this.leftStickValue = leftStickValue;
	}
 
	/**
	 * Returns stateMap
	 * 
	 * @return Map
	 */
	public Map<Button, State> getStateMap() {
		return stateMap;
	}
}
