package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.TimeControlledMotor;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class BallShooter extends Command implements AutoCommand{
	private SpeedController speedController;
	private XboxController xBox;
	private final double MOTOR_SPEED = .8;
	
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

	@Override
	public void init() {
		speedController.setInverted(true);
		 
	}

	/**
	 * Calls startShooter() if right bumper pressed
	 * Calls stopShooter() if left bumper pressed
	 */
	@Override
	public void run() {
		if(xBox.getRightBumper()){
			speedController.set(MOTOR_SPEED);
		}else{
			speedController.set(0);
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
