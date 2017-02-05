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
	 * Constructor for the Auger class
	 * 
	 * @param name
	 * @param id
	 * @param speedController
	 * @param xbox
	 */
	public BallDoor(String name, int id, DoubleSolenoid solenoid, XboxController xbox){
		super(name, id);
		this.solenoid = solenoid;
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
