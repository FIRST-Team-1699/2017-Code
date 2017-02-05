package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class GearManipulator extends Command implements AutoCommand{
		private DoubleSolenoid solenoid;
		private boolean controllerToggle;
		private XboxController controller;
		public static final double SOLENOID_OFF = 0.0;
		public static final double SOLENOID_ON = 1.0;
		
	/**
	 * Constructor for the GearManipulator class
	 * 
	 * @param name
	 * @param id
	 * @param compressor
	 * @param controller
	 * @param solid_1
	 */
	 public GearManipulator(String name, int id, XboxController controller,  DoubleSolenoid solenoid){
		super(name, id);
		controllerToggle = false;
		this.solenoid = solenoid;
		this.controller = controller;
		
	}
	 
	 /**
	  * Constructor for the GearManipulator class, allows for the controller to be toggled
	  * 
	  * @param compressor
	  * @param controller
	  * @param solid_1
	  * @param controllerToggle
	  * @param name
	  * @param id
	  */
	 public GearManipulator(String name, int id, XboxController controller, DoubleSolenoid solenoid, boolean controllerToggle){
			super(name, id);
			
			this.controllerToggle = controllerToggle;
			this.solenoid = solenoid;
			this.controller = controller;
			
		}


	@Override
	public void init() {
	}

	@Override
	public void run() {
		if(controller.getA()){
			solenoid.set(Value.kForward);
		}else if(controller.getB()){
			solenoid.set(Value.kReverse);
		}else{
			solenoid.set(Value.kOff);
		}
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		if(speed == SOLENOID_OFF){
			solenoid.set(Value.kReverse);
		}else if(speed == SOLENOID_ON){
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
