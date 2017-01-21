package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class Turn extends DriveBase{

	public Turn(String name, int id, XboxController xBox, SpeedController mot1, SpeedController mot2, SpeedController mot3, SpeedController mot4) {
		super(name, id, xBox, mot1, mot2, mot3, mot4);
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		super.getDrive().setMaxOutput(speed);
		super.getDrive().arcadeDrive(0, distance);
		super.getDrive().setMaxOutput(1.0);
	}

	@Override
	public boolean autoCommandDone() {
		return false;
	}

}
