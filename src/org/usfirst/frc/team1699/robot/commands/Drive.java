package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drive extends Command implements AutoCommand{
	private Encoder sen;
	private RobotDrive drive;

	/**
	 * Constructor for the Drive class
	 * 
	 * @param name
	 * @param id
	 * @param xBox
	 * @param mot1
	 * @param mot2
	 * @param mot3
	 * @param mot4
	 * @param sen
	 * @param sen2
	 */
	public Drive(String name, int id, XboxController xBox, RobotDrive drive, Encoder sen, Encoder sen2) {
		super(name, id);
		this.sen = sen;
		this.drive = drive;
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
		System.out.println(distance + " " + speed + " " + useSensor);
		drive.setMaxOutput(speed);
		if(useSensor){
			driveSensorBased(distance, speed);
		}else{
			driveTimeBased(distance, speed);
		}
		drive.setMaxOutput(1.0);
	}
	
	/**
	 * Drives the robot for a specific duration of time
	 * 
	 * @param distance
	 * @param speed
	 */
	private void driveTimeBased(double distance, double speed){
		int i = 0;
		while(i <= distance){
			drive.tankDrive(speed, speed);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();			
			}
			i++;
		}
		drive.tankDrive(0, 0);
	}
	
	/**
	 * Drives the robot until a sensor goes off
	 * 
	 * @param distance
	 * @param speed
	 */
	private void driveSensorBased(double distance, double speed){
		while(sen.get() <= distance){
			drive.tankDrive(speed, speed);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		drive.tankDrive(0, 0);
	}

	/**
	 * Checks if an auto command is done
	 * 
	 * @return false in any case
	 */
	@Override
	public boolean autoCommandDone() {
		return false;
	}
	
	/**
	 * Resets all sensors
	 */
	public void zeroAllSensors(){
		sen.reset();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void outputToDashboard() {
		// TODO Auto-generated method stub
		
	}

}
