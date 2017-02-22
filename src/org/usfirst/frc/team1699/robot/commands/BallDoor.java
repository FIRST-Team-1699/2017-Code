package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.TimeControlledMotor;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;

public class BallDoor extends Command implements AutoCommand{
	private XboxController xbox;
	private DoubleSolenoid solenoid;
	
	/**
	 * Constructor for the BallDoor class
	 * 
	 * @param name
	 * @param id
	 * @param xbox
	 * @param solenoid
	 */
	public BallDoor(String name, int id, XboxController xbox, DoubleSolenoid solenoid){
		super(name, id);
		this.solenoid = solenoid;
		//this.solenoid2 = solenoid2;
		this.xbox = xbox;
	
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void run() {
		if(xbox.getStart()){
			solenoid.set(Value.kForward);
		}else{
			solenoid.set(Value.kReverse);
		}
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		if(speed == 0){
			solenoid.set(Value.kReverse);
		}else if(speed == 1){
			solenoid.set(Value.kForward);
		}else{
			solenoid.set(Value.kOff);
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
