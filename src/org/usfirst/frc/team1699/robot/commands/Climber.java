package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;

public class Climber extends Command{
	private SpeedController sController1, sController2, sController3, sController4;
	private Compressor compressor;
	private Solenoid solid;
	private XboxController xbox;
	private boolean controllerToggle;
	private final double MOTOR_SPEED = 0.5;
	
	/**
	 * Constructor for the Climber class (no controller toggle)
	 * 
	 * @param name
	 * @param id
	 * @param sc1
	 * @param sc2
	 * @param sc3
	 * @param sc4
	 * @param compressor
	 * @param solid
	 * @param xbox
	 */
	public Climber(String name, int id, SpeedController sc1, SpeedController sc2, SpeedController sc3, SpeedController sc4,
			Compressor compressor, Solenoid solid, XboxController xbox){
		super(name, id);
		sController1 = sc1;
		sController2 = sc2;
		sController3 = sc3;
		sController4 = sc4;
		this.compressor = compressor;
		this.solid = solid;
		this.xbox = xbox;
	}
	
	/**
	 * Constructor for the Climber class (controller toggle included)
	 * 
	 * @param name
	 * @param id
	 * @param sc1
	 * @param sc2
	 * @param sc3
	 * @param sc4
	 * @param compressor
	 * @param solid
	 * @param xbox
	 * @param controllerToggle
	 */
	public Climber(String name, int id, SpeedController sc1, SpeedController sc2, SpeedController sc3, SpeedController sc4,
			Compressor compressor, Solenoid solid, XboxController xbox, boolean controllerToggle){
		super(name, id);
		sController1 = sc1;
		sController2 = sc2;
		sController3 = sc3;
		sController4 = sc4;
		this.compressor = compressor;
		this.solid = solid;
		this.xbox = xbox;
		this.controllerToggle = controllerToggle;
	}
	
	/**
	 * Engages the climber if the controller is toggled or if the home button is pressed
	 */
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
	
	/**
	 * Disengages the climber if the controller is toggled or if the B button is pressed
	 */	
	private void disengageClimber(){
		if (controllerToggle){
			if (xbox.getHome() && solid.get()){
				solid.set(false);
			}
		}
		else if (xbox.getB()){
			solid.set(false);
		}
	}
	
	/**
	 * Drives the climber at a specific speed
	 * 
	 * @param speed
	 */
	private void driveClimber(double speed){
		sController1.set(speed);
		sController2.set(speed);
		sController3.set(speed);
		sController4.set(speed);
	}
	
	/**
	 * Stops the climber
	 */
	private void stopClimber(){
		sController1.set(0);
		sController2.set(0);
		sController3.set(0);
		sController4.set(0);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		compressor.start();
		solid.set(false);
	}
	
	/**
	 * Runs the climber
	 */
	@Override
	public void run() {
		disengageClimber();
		engageClimber();
		if(xbox.getDPadUp()){
			driveClimber(MOTOR_SPEED);
		}else if(xbox.getDPadDown()){
			stopClimber();
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
