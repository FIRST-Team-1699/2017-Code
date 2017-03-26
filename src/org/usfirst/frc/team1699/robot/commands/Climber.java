package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Command{
	private SpeedController sController1, sController2;
	private XboxController xbox;
	private boolean isRunning = false;
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
	public Climber(String name, int id, XboxController xbox, SpeedController sc1, SpeedController sc2){
		super(name, id);
		sController1 = sc1;
		sController2 = sc2;
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
		this.xbox = xbox;
	}

	@Override
	public void init() {
		sController1.setInverted(true);
		sController2.setInverted(true);
	}
	
	/**
	 * Runs the climber
	 */
	@Override
	public void run() {
		if(xbox.getRightBumper()){ //Press right bumper to turn motor forward and climb
			sController1.set(speed);
			sController2.set(speed);
			if (speed <= 1){
				speed += 0.01;
			}
			isRunning = true;
		}else if(xbox.getLeftBumper()){ //Press left bumper to stop motor
			sController1.set(0);
			sController2.set(0);
			speed = 0;
			isRunning = false;
		}
//		else if(xbox.getRawButton(3)){ //Press X to turn motor backward and descend
//			sController1.set(-speed);
//			sController2.set(-speed);
//		}
	
		
	}

	@Override
	public void outputToDashboard() {
		SmartDashboard.putBoolean("Climber Running", isRunning);
		
	}

	@Override
	public void zeroAllSensors() {
		// TODO Auto-generated method stub
		
	}

}
