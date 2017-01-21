package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.TimeControlledMotor;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class Auger extends Command {
	private XboxController xbox;
	private SpeedController speedController;
	private final double MOTOR_SPEED = 0.5;
	
	/**
	 * constructor
	 * 
	 * @param name
	 * @param id
	 * @param speedController
	 * @param xbox
	 */
	public Auger(String name, int id, SpeedController speedController, XboxController xbox){
		super(name, id);
		this.speedController = speedController;
		this.xbox = xbox;
	
	}

	public void stopAuger(){
		speedController.set(0);
	}
	
	public void startAuger(double speed){
		speedController.set(speed);
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Calls startAuger() if start pressed
	 * Calls stopAuger() if start unpressed
	 */
	@Override
	public void run() {
		if(xbox.getStart()){
			startAuger(MOTOR_SPEED);
		}
		else if(!xbox.getStart()){
			stopAuger();
		}
		
	}
	
	/**
	 * Creates instance of TimeControlledMotor 
	 * runs motors at set speed for set time
	 * @param distance time run(milliseconds)
	 * @param speed motor speed(-1.0 to 1.0)
	 * @param useSensor
	 */
	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		TimeControlledMotor timedMotor = new TimeControlledMotor(speedController);
		timedMotor.setSpeed(speed);
		timedMotor.setTime(distance);
		timedMotor.run();
		
	}

	@Override
	public boolean autoCommandDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void outputToDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroAllSensors() {
		// TODO Auto-generated method stub
		
	}
}
