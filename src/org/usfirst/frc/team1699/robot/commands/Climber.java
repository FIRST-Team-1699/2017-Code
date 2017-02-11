package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class Climber extends Command{
	private SpeedController sController1, sController2;
	private Compressor compressor;
	private XboxController xbox;
//	private boolean controllerToggle;
	private double speed = 0;
	
	/**
	 * Constructor for the Climber class (no controller toggle)
	 * 
	 * @param name
	 * @param id
	 * @param sc1
	 * @param sc2
	 * @param compressor
	 * @param xbox
	 */
	public Climber(String name, int id, XboxController xbox, SpeedController sc1, SpeedController sc2, Compressor compressor){
		super(name, id);
		sController1 = sc1;
		sController2 = sc2;
		this.compressor = compressor;
		this.xbox = xbox;
	}
	
	/**
	 * Constructor for the Climber class (controller toggle included)
	 * 
	 * @param name
	 * @param id
	 * @param sc1
	 * @param sc2
	 * @param compressor
	 * @param xbox
	 * @param controllerToggle
	 */
	public Climber(String name, int id, XboxController xbox, SpeedController sc1, SpeedController sc2,Compressor compressor, boolean controllerToggle){
		super(name, id);
		sController1 = sc1;
		sController2 = sc2;
		this.compressor = compressor;
		this.xbox = xbox;
//		this.controllerToggle = controllerToggle;
	}
	
/*	*//**
	 * Engages the climber if the controller is toggled or if the home button is pressed
	 *//*
	private void engageClimber(){
		if (controllerToggle){
			if (!solid.get() && xbox.getHome()){
				solid.set(true);
			}
		}
		else if (xbox.getHome()){
			solid.set(true);
		}
	}
	
	*//**
	 * Disengages the climber if the controller is toggled or if the B button is pressed
	 *//*	
	private void disengageClimber(){
		if (controllerToggle){
			if (xbox.getHome() && solid.get()){
				solid.set(false);
			}
		}
		else if (xbox.getB()){
			solid.set(false);
		}
	}*/
	
	/**
	 * Drives the climber at a specific speed
	 * 
	 * @param speed
	 */
	private void driveClimber(double speed){
		sController1.set(speed);
		sController2.set(speed);
	}
	
	/**
	 * Stops the climber
	 */
	private void stopClimber(){
		sController1.set(0);
		sController2.set(0);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		compressor.start();

	}
	
	/**
	 * Runs the climber
	 */
	@Override
	public void run() {
		//disengageClimber();
		//engageClimber();
		if(xbox.getDPadUp()){
			driveClimber(speed);
			if (speed <= 1){
				speed += 0.01;
			}
		}else if(xbox.getDPadDown()){
			stopClimber();
			speed = 0;
		}		
	}

	@Override
	public void outputToDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroAllSensors() {
		// TODO Auto-generated method stub
		
	}

}
