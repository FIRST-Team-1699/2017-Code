package org.usfirst.team1699.test.pidTest;

import org.usfirst.frc.team1699.robot.pid.sensors.PIDSensor;

public class TestPIDSensor implements PIDSensor{

	private int num = 123;
	
	@Override
	public double get() {
		// TODO Auto-generated method stub
		return num;
	}
	
	public void set(int num){
		this.num = num;
	}

}
