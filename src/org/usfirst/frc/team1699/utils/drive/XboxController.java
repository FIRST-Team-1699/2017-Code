//When writing JavaDocs, include team 3309
package org.usfirst.frc.team1699.utils.drive;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends GenericHID {
	
	//Constants
	//Buttons
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	//DPad
	public static final int BUTTON_DPAD_UP = 5;
	public static final int BUTTON_DPAD_DOWN = 6;
	public static final int BUTTON_DPAD_LEFT = 7;
	public static final int BUTTON_DPAD_RIGHT = 8;
	//Middle Buttons
	public static final int BUTTON_START = 8;
	public static final int BUTTON_BACK = 7;
	public static final int BUTTON_HOME = 13;
	//Sticks
	public static final int BUTTON_LEFT_STICK = 9;
	public static final int BUTTON_RIGHT_STICK = 10;
	//Bumpers
	public static final int BUTTON_LEFT_BUMPER = 5;
	public static final int BUTTON_RIGHT_BUMPER = 6;
	
	//Axes
	public static final int AXIS_LEFT_X = 0;
	public static final int AXIS_LEFT_Y = 1;
	public static final int AXIS_LEFT_TRIGGER = 2;
	public static final int AXIS_RIGHT_TRIGGER = 3;
	public static final int AXIS_RIGHT_X = 4;
	public static final int AXIS_RIGHT_Y = 5;
	public static final int AXIS_DPAD = 6;
	
	
	@SuppressWarnings("unused")
	private final int port;
	private double deadband;
	private Joystick joystick;
	
	/**
	 * Constructor for the XboxController class
	 * 
	 * @param port
	 * @param deadband
	 */
	public XboxController(final int port, double deadband){
		super(port);
		this.port = port;
		this.deadband = deadband;
		joystick = new Joystick(port);
	}
	
	/**
	 * Gets whether or not the A button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */
	public boolean getA(){
		return joystick.getRawButton(3);
	}

	/**
	 * Gets whether or not the B button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */
	public boolean getB(){
		return joystick.getRawButton(4);
	}

	/**
	 * Gets whether or not the X button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */
	public boolean getXButton(){
		return joystick.getRawButton(1);
	}
	
	/**
	 * Gets whether or not the Y button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */
	public boolean getYButton(){
		return joystick.getRawButton(2);
	}
	
	/**
	 * Gets how far left or right the left joystick is
	 * 
	 * @return double containing the position of the left joystick on the x-axis
	 */
	public double getLeftXAxis(){
		return scaleAxis(joystick.getRawAxis(AXIS_LEFT_X));
	}

	/**
	 * Gets how far up or down the left joystick is
	 * 
	 * @return double containing the position of the left joystick on the y-axis
	 */
	public double getLeftYAxis(){
		return scaleAxis(joystick.getRawAxis(AXIS_LEFT_Y));
	}
	
	/**
	 * Gets how far left or right the right joystick is
	 * 
	 * @return double containing the position of the right joystick on the x-axis
	 */
	public double getRightXAxis(){
		return scaleAxis(joystick.getRawAxis(AXIS_RIGHT_X));
	}

	/**
	 * Gets how far up or down the right joystick is
	 * 
	 * @return double containing the position of the right joystick on the y-axis
	 */	
	public double getRightYAxis(){
		return scaleAxis(joystick.getRawAxis(AXIS_RIGHT_Y));
	}

	/**
	 * Gets how far down the right trigger is pressed
	 * 
	 * @return double containing the current position of the right trigger
	 */
	public double getRightTrigger(){
		return scaleAxis(joystick.getRawAxis(AXIS_RIGHT_TRIGGER));
	}

	/**
	 * Gets how far down the left trigger is pressed
	 * 
	 * @return double containing the current position of the left trigger
	 */	
	public double getLeftTrigger(){
		return scaleAxis(joystick.getRawAxis(AXIS_LEFT_TRIGGER));
	}

	/**
	 * Gets whether or not the start button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */	
	public boolean getStart(){
		return joystick.getRawButton(8);
	}

	/**
	 * Gets whether or not the back button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */
	public boolean getBack(){
		return joystick.getRawButton(7);
	}

	/**
	 * Gets whether or not the home button is pressed
	 * 
	 * @return true if button is pressed, false if not
	 */	
	public boolean getHome(){
		return joystick.getRawButton(13);
	}

	/**
	 * Gets whether or not the right joystick is being pressed
	 * 
	 * @return true if joystick is pressed, false if not
	 */		
	public boolean getRightStickButton(){
		return joystick.getRawButton(9);
	}

	/**
	 * Gets whether or not the left joystick is being pressed
	 * 
	 * @return true if joystick is pressed, false if not
	 */	
	public boolean getLeftStickButton(){
		return joystick.getRawButton(10);
	}

	/**
	 * Gets whether or not the right bumper is being pressed
	 * 
	 * @return true if bumper is pressed, false if not
	 */		
	public boolean getRightBumper(){
		return joystick.getRawButton(BUTTON_LEFT_BUMPER);
	}

	/**
	 * Gets whether or not the left bumper is being pressed
	 * 
	 * @return true if bumper is pressed, false if not
	 */		
	public boolean getLeftBumper(){
		return joystick.getRawButton(BUTTON_RIGHT_BUMPER);
	}

	/**
	 * Gets the amount the joystick can be moved without moving the robot
	 * 
	 * @return deadband as a double
	 */		
	public double getDeadband(){
		return this.deadband;
	}
	
	/**
	 * Sets the amount the joystick can be moved without moving the robot
	 * 
	 * @param deadband
	 */
	public void setDeadband(int deadband){
		this.deadband = deadband;
	}

	/**
	 * Gets whether or not the DPad is being pressed up
	 * 
	 * @return true if DPad is pressed up, false if not
	 */		
	public boolean getDPadUp(){
		return joystick.getPOV(0) < 45 || joystick.getPOV(0) > 325;
	}

	/**
	 * Gets whether or not the DPad is being pressed down
	 * 
	 * @return true if DPad is pressed down, false if not
	 */			
	public boolean getDPadDown(){
		return joystick.getPOV(0) < 225 || joystick.getPOV(0) > 135;
	}

	/**
	 * Gets whether or not the DPad is being pressed left
	 * 
	 * @return true if DPad is pressed left, false if not
	 */			
	public boolean getDPadLeft(){
		return joystick.getPOV(0) < 315 || joystick.getPOV(0) > 225;
	}

	/**
	 * Gets whether or not the DPad is being pressed right
	 * 
	 * @return true if DPad is pressed right, false if not
	 */			
	public boolean getDPadRight(){
		return joystick.getPOV(0) < 135 || joystick.getPOV(0) > 245;
	}
	
	/**
	 * Finds the position of the joystick as long as it's outside of the deadband
	 * 
	 * @param value
	 * @return 0 if the joystick is within the deadband, otherwise return the position of the joystick
	 */
	private double scaleAxis(double value){
		if(Math.abs(value) < this.deadband && Math.abs(value) > -this.deadband){
			return 0;
		}else{
			return value;
		}
	}
	
	/**
	 * Gets the x-value for hand
	 * 
	 * @param hand
	 * @return x-value of hand
	 */
	@Override
	public double getX(Hand hand) {
		return joystick.getX(hand);
	}
	
	/**
	 * Gets the y-value for hand
	 * 
	 * @param hand
	 * @return y-value of hand
	 */
	@Override
	public double getY(Hand hand) {
		return joystick.getY(hand);
	}

	
	/**
	 * Gets the raw axis of the joystick
	 * 
	 * @param which
	 * @return raw axis of specified joystick
	 */
	@Override
	public double getRawAxis(int which) {
		return joystick.getRawAxis(which);
	}

	/**
	 * Gets whether or not a specified button is being pressed
	 * 
	 * @param button
	 * @return true if pressed, false if not
	 */
	@Override
	public boolean getRawButton(int button) {
		return joystick.getRawButton(button);
	}

	/**
	 * Gets the angle of a POV in degrees
	 * 
	 * @param pov
	 * @return the angle of the POV
	 */
	@Override
	public int getPOV(int pov) {
		return joystick.getPOV(pov);
	}

	/**
	 * Gets the amount of POVs on the joystick
	 * 
	 * @return number of POVs
	 */
	@Override
	public int getPOVCount() {
		return 0;
	}

	/**
	 * Gets the type of HID (returns null in all cases)
	 * 
	 * @return null
	 */
	@Override
	public HIDType getType() {
		return null;
	}

	/**
	 * Gets the name of the HID (returns null in all cases)
	 * 
	 * @return null
	 */
	@Override
	public String getName() {
		return null;
	}

	/**
	 * Sets a single joystick output value
	 * 
	 * @param outputNumber
	 * @param value
	 */
	@Override
	public void setOutput(int outputNumber, boolean value) {
		joystick.setOutput(outputNumber, value);
	}

	/**
	 * Sets all joystick output values
	 * 
	 * @param value
	 */
	@Override
	public void setOutputs(int value) {
		joystick.setOutputs(value);
	}

	/**
	 * Sets the rumble output for the joystick
	 * 
	 * @param type
	 * @param value
	 */
	@Override
	public void setRumble(RumbleType type, double value) {
		joystick.setRumble(type, value);
	}
}
