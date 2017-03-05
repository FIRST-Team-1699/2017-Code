package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;

public class Sleep extends Command implements AutoCommand{

	public Sleep(String name, int id) {
		super(name, id);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void run() {
		
	}

	@Override
	public void outputToDashboard() {
		
	}

	@Override
	public void zeroAllSensors() {
		
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		try {
			Thread.sleep((long) distance);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean autoCommandDone() {
		return false;
	}
}
