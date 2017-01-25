package org.usfirst.team1699.test.simElectronics;

import edu.wpi.first.wpilibj.Solenoid;

public class SimSolenoid extends Solenoid{
	private int channel;
	private int moduleNumber;
	private boolean state;

	/**
	 * Constructor
	 * 
	 * @param channel
	 */
	public SimSolenoid(int channel){
		super(channel);
		this.channel = channel;
		this.state = false;
	}
	
	/**
	 * Constructor
	 * 
	 * @param moduleNumber
	 * @param channel
	 */
	public SimSolenoid(int moduleNumber, int channel) {
		super(moduleNumber, channel);
		this.moduleNumber = moduleNumber;
		this.channel = channel;
		this.state = false;
	}
	
	/**
	 * Returns channel
	 * 
	 * @return channel
	 */
	public int getChannel(){
		return channel;
	}
	
	/**
	 * Gets module number
	 * 
	 * @return moduleNumber
	 */
	public int getModuleNumber(){
		return moduleNumber;
	}
	
	/**
	 * Returns current state
	 * 
	 * @return state
	 */
	public boolean get(){
		return state;
	}
	
	/**
	 * Sets state
	 * 
	 * @param state
	 */
	public void set(boolean state){
		this.state = state;
	}
}
