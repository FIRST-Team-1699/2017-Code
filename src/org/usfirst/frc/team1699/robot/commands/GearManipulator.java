package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearManipulator extends Command implements AutoCommand{
		private DoubleSolenoid solenoid;
		private DoubleSolenoid solenoid2;
		private boolean controllerToggle;
		private boolean isOpen = false;
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
	 public GearManipulator(String name, int id, XboxController controller,  DoubleSolenoid solenoid, DoubleSolenoid solenoid2){
		super(name, id);
		controllerToggle = false;
		this.solenoid = solenoid;
		this.controller = controller;
		this.solenoid2 = solenoid2;
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
		if(controller.getRawButton(3)){ //Press button X
			solenoid.set(Value.kForward);
			solenoid2.set(Value.kForward);
			isOpen = true;
		}else if(controller.getRawButton(4)){ //Press button Y
			solenoid.set(Value.kReverse);
			solenoid2.set(Value.kReverse);
		}else{
			solenoid.set(Value.kOff);
			solenoid2.set(Value.kOff);
			isOpen = false;
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
		SmartDashboard.putBoolean("Gear Open", isOpen);
	}

	@Override
	public void zeroAllSensors() {
		
	}
}
