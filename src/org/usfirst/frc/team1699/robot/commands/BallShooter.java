package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.TimeControlledMotor;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class BallShooter extends Command implements AutoCommand{
	private SpeedController speedController;
	private XboxController xBox;
	private final double MOTOR_SPEED = .5;
	
	/**
	 * constructor
	 * 
	 * @param speedController
	 * @param xBoxController
	 * @param name
	 * @param id
	 */
	public BallShooter(String name, int id,  XboxController xBox, SpeedController speedController){
		super(name, id);
		this.speedController = speedController;
		this.xBox = xBox;

	}
	
	/**
	 * sets motor speed to 0
	 */
	private void stopShooter(){
		speedController.set(0);
	}
	
	/**
	 * runs motor at set speed
	 * @param speed motor speed(-1.0 to 1.0)
	 */
	private void startShooter(double speed){
		speedController.set(speed);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * Calls startShooter() if right bumper pressed
	 * Calls stopShooter() if left bumper pressed
	 */
	@Override
	public void run() {
		if(xBox.getLeftBumper()){
			stopShooter();
		}
		else if(xBox.getRightBumper()){
			startShooter(MOTOR_SPEED);
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
		// TODO Auto-generated method stub
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
