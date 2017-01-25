package org.usfirst.team1699.test.simElectronics;

import java.util.HashMap;
import java.util.Map;

import org.usfirst.frc.team1699.utils.drive.XboxController;

public class SimXboxController extends XboxController{
	private enum Button {A, B, X, Y, Back, Start, LSButton, RSButton, RBumper, LBumper};
	private enum State {Pressed, Released};
	private double rightStickValue;
	private double leftStickValue;
	private Map<Button, State> stateMap = new HashMap<>();

	public SimXboxController(int port, double deadband) {
		super(port, deadband);
		this.rightStickValue = 0;
		this.leftStickValue = 0;
	}
	
	public void setState(Button b, State s){
		stateMap.put(b, s);
	}
	
	public State getState(Button b){
		return stateMap.get(b);
	}
	
	public double getRightStickValue() {
		return rightStickValue;
	}
	
	public void setRightStickValue(double rightStickValue) {
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
