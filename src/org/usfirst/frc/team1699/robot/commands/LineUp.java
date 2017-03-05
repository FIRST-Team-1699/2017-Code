package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.robot.pid.PIDLoop;
import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class LineUp extends Command implements AutoCommand{
	private RobotDrive drive;
	private PIDLoop pid;
	private XboxController xbox;
	private NetworkTable table;
	public static final int TARGET_CENTER_X = 180;
	private double initX = table.getNumber("centerX", 0.0);

	public LineUp(String name, int id, RobotDrive drive, PIDLoop pid, XboxController xbox, NetworkTable table) {
		super(name, id);
		this.drive = drive;
		this.pid = pid;
		this.xbox = xbox;
		this.table = table;
	}
	
	@Override
	public void init() {
		pid.setGoal(TARGET_CENTER_X);
	}

	@Override
	public void run() {
		if(xbox.getBack()){
			drive.arcadeDrive(0, pid.output());
		}
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		if(xbox.getBack()){
			drive.arcadeDrive(0, pid.output());
		}
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
