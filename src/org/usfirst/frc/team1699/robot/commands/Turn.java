package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class Turn extends DriveBase{
	private Encoder sen;

	/**
	 * Constructor for the Turn class
	 * 
	 * @param name
	 * @param id
	 * @param xBox
	 * @param mot1
	 * @param mot2
	 * @param mot3
	 * @param mot4
	 * @param sen
	 */
	public Turn(String name, int id, XboxController xBox, SpeedController mot1, SpeedController mot2, SpeedController mot3, SpeedController mot4, Encoder sen) {
		super(name, id, xBox, mot1, mot2, mot3, mot4);
		this.sen = sen;
	}

	/**
	 * Drives the robot automatically, either until a sensor goes off or for a period of time
	 * 
	 * @param distance
	 * @param speed
	 * @param useSensor
	 */
	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		super.getDrive().setMaxOutput(speed);
		if(useSensor){
			driveSensorBased(distance, speed);
		}else{
			driveTimeBased(distance, speed);
		}
		super.getDrive().setMaxOutput(1.0);
	}
	
	/**
	 * Drives the robot for a specific amount of time
	 * 
	 * @param distance
	 * @param speed
	 */
	private void driveTimeBased(double distance, double speed){
		int i = 0;
		double dist = Math.abs(distance);
		while(i <= dist){
			if(distance < 0){
				super.getDrive().tankDrive(speed, -speed);
			}else{
				super.getDrive().tankDrive(-speed, speed);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		super.getDrive().tankDrive(0, 0);
	}
	
	/**
	 * Drives the robot until a sensor goes off
	 * 
	 * @param distance
	 * @param speed
	 */
	private void driveSensorBased(double distance, double speed){
		double dist = Math.abs(distance);
		while(sen.get() <= dist){
			if(distance < 0){
				super.getDrive().tankDrive(speed, -speed);
			}else{
				super.getDrive().tankDrive(-speed, speed);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.getDrive().tankDrive(0, 0);
	}

	/**
	 * Returns if the command is finished
	 * 
	 * @return false in all cases
	 */
	@Override
	public boolean autoCommandDone() {
		return false;
	}

}
