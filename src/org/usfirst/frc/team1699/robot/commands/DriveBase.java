package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class DriveBase extends Command{
	private SpeedController mot1, mot2, mot3, mot4;
	XboxController xBox;

	public DriveBase(String name, int id, XboxController xBox, SpeedController mot1, SpeedController mot2, SpeedController mot3, SpeedController mot4) {
		super(name, id);
		this.mot1 = mot1;
		this.mot2 = mot2;
		this.mot3 = mot3;
		this.mot4 = mot4;
		this.xBox = xBox;
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
