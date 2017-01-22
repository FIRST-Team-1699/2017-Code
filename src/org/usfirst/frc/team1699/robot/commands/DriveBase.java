package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveBase extends Command{
	private SpeedController mot1, mot2, mot3, mot4;
	private XboxController xBox;
	private RobotDrive drive;

	/**
	 * Constructor for the DriveBase class
	 * 
	 * @param name
	 * @param id
	 * @param xBox
	 * @param mot1
	 * @param mot2
	 * @param mot3
	 * @param mot4
	 */
	public DriveBase(String name, int id, XboxController xBox, SpeedController mot1, SpeedController mot2, SpeedController mot3, SpeedController mot4) {
		super(name, id);
		this.mot1 = mot1;
		this.mot2 = mot2;
		this.mot3 = mot3;
		this.mot4 = mot4;
		this.xBox = xBox;
	}

	/**
	 * Initializes the drive
	 */
	@Override
	public void init() {
		drive = new RobotDrive(mot1, mot2, mot3, mot4);
	}

	/**
	 * Allows the joystick to be used for driving
	 */
	@Override
	public void run() {
		drive.arcadeDrive(xBox);
	}

	@Override
	public void outputToDashboard() {
		
	}

	@Override
	public void zeroAllSensors() {
		
	}
	
	/**
	 * Gets the drive
	 * 
	 * @return the drive
	 */
	protected RobotDrive getDrive(){
		return drive;
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean autoCommandDone() {
		// TODO Auto-generated method stub
		return false;
	}
}
