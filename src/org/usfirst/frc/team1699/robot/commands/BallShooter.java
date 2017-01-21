package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.TimeControlledMotor;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class BallShooter extends Command{
	private SpeedController speedController;
	private XboxController xBoxController;
	private final double MOTOR_SPEED = .5;
	
	public BallShooter(SpeedController speedController, XboxController xBoxController, String name, int id){
		super(name, id);
		this.speedController = speedController;
		this.xBoxController = xBoxController;

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		if(xBoxController.getLeftBumper()){
			stopShooter();
		}
		else if(xBoxController.getRightBumper()){
			startShooter(MOTOR_SPEED);
		}
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		// TODO Auto-generated method stub
		TimeControlledMotor timedMotor = new TimeControlledMotor(speedController);
		
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
	
	private void startShooter(double speed){
		speedController.set(speed);
	}
	
	private void stopShooter(){
		speedController.set(0);
	}
}
