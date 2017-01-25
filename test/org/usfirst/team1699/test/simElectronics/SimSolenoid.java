package org.usfirst.team1699.test.simElectronics;

import edu.wpi.first.wpilibj.Solenoid;

public class SimSolenoid extends Solenoid{
	private int channel;
	private int moduleNumber;
	private boolean state;

	public SimSolenoid(int channel){
		super(channel);
		this.channel = channel;
		this.state = false;
	}
	
	public SimSolenoid(int moduleNumber, int channel) {
		super(moduleNumber, channel);
		this.moduleNumber = moduleNumber;
		this.channel = channel;
		this.state = false;
	}
	
	public int getChannel(){
		return channel;
	}
	
	public int getModuleNumber(){
		return moduleNumber;
	}
	
	public boolean get(){
		return state;
	}
	
	public void set(boolean state){
		this.state = state;
	}
}
