package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SpeedController;

public class Climber extends Command{
	private SpeedController sController1, sController2;
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
		if(xbox.getRawButton(1)){ //Press A to turn motor forward and climb
			sController1.set(speed);
			sController2.set(speed);
			if (speed <= 1){
				speed += 0.01;
			}
		}else if(xbox.getRawButton(2)){ //Press B to stop motor
			sController1.set(0);
			sController2.set(0);
			speed = 0;
		}else if(xbox.getRawButton(3)){ //Press X to turn motor backward and descend
			sController1.set(-speed);
			sController2.set(-speed);
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
