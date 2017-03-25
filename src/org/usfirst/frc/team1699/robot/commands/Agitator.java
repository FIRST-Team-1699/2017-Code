package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Agitator extends Command implements AutoCommand{
	private XboxController xbox;
	private DoubleSolenoid solenoid;
	
	/**
	 * Constructor for the Agitator class
	 * 
	 * @param name
	 * @param id
	 * @param xbox
	 * @param solenoid
	 */
	public Agitator(String name, int id, XboxController xbox, DoubleSolenoid solenoid){
		super(name, id);
		this.xbox = xbox;
		this.solenoid = solenoid;
	
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void run() {
		if(xbox.getBack()){
			solenoid.set(Value.kForward);
		}else if(xbox.getDPadDown()){
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