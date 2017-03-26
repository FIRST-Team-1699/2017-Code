package org.usfirst.frc.team1699.robot.pid.sensors;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision implements PIDSensor {
	private NetworkTable table;
	private double initX = table.getNumber("centerX", 0.0);
	
	@Override
	public double get() {
		return initX;
	}

}
