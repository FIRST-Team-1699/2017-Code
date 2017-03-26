package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;

public class Light extends Command implements AutoCommand{
	
	private DigitalOutput spike;
	private Joystick stick;

	public Light(String name, int id, int port, Joystick stick) {
		super(name, id);
		this.spike = new DigitalOutput(port);
		this.spike.set(false);
		this.stick = stick;
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		if((int) speed == 1){
			spike.set(true);
		}else if((int) speed == 0){
			spike.set(false);
		}
	}

	@Override
	public boolean autoCommandDone() {
		return false;
	}

	@Override
	public void init() {
		
	}

	@Override
	public void run() {
		if(stick.getBumper(Hand.kLeft)){
			spike.set(true);
		}else{
			spike.set(false);
		}
	}

	@Override
	public void outputToDashboard() {
		
	}

	@Override
	public void zeroAllSensors() {
		
	}

}
