package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class GearManipulator extends Command{
		private Compressor compressor;
		private Solenoid solid_1;
		private boolean controllerToggle;
		private XboxController controller;
		
		
	 public GearManipulator(Compressor compressor, XboxController controller,  Solenoid solid_1, String name, int id){
		super(name, id);
		controllerToggle = false;
		this.solid_1 = solid_1;
		this.compressor = compressor;
		this.controller = controller;
		
	}
	 
	 public GearManipulator(Compressor compressor, XboxController controller, Solenoid solid_1, boolean controllerToggle, String name, int id){
			super(name, id);
			
			this.controllerToggle = controllerToggle;
			this.solid_1 = solid_1;
			
			this.compressor = compressor;
			this.controller = controller;
			
		}


	@Override
	public void init() {
		// TODO Auto-generated method stub
		compressor.start();
		solid_1.set(false);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		close();
		open();
		
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean autoCommandDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void outputToDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroAllSensors() {
		// TODO Auto-generated method stub
		
	}
	

	private void open(){
		if (controllerToggle){
			if (!solid_1.get() && controller.getA()){
				solid_1.set(true);
			}
		}
		else if (controller.getA()){
			solid_1.set(true);
		}
	}
	
	private void close(){
		if (controllerToggle){
			if (controller.getA() && solid_1.get()){
				solid_1.set(false);
			}
		}
		else if (controller.getB()){
			solid_1.set(false);
		}
	}
}
