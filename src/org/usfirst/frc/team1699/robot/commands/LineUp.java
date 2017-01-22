package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.pid.PIDLoop;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class LineUp extends Command{
	private Gyro gyro;
	private RobotDrive drive;
	private PIDLoop pid;
	private XboxController xbox;

	public LineUp(String name, int id, Gyro gyro, RobotDrive drive, PIDLoop pid, XboxController xbox) {
		super(name, id);
		this.gyro = gyro;
		this.drive = drive;
		this.pid = pid;
		this.xbox = xbox;
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void run() {
		
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		
	}

	@Override
	public boolean autoCommandDone() {
		return false;
	}

	@Override
	public void outputToDashboard() {
		
	}

	@Override
	public void zeroAllSensors() {
		
	}

}
