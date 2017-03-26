package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.autonomous.AutoCommand;
import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;

public class Agitator extends Command implements AutoCommand{
	private XboxController xbox;
	private SpeedController cont;
	
	/**
	 * Constructor for the Agitator class
	 * 
	 * @param name
	 * @param id
	 * @param xbox
	 * @param solenoid
	 */
	public Agitator(String name, int id, XboxController xbox, SpeedController cont){
		super(name, id);
		this.xbox = xbox;
		this.cont = cont;
	
	}
	
	@Override
	public void init() {
		
	}
	
	@Override
	public void run() {
		if(xbox.getDPadUp()){
			cont.set(0.6);
		}else if(xbox.getDPadDown()){
			cont.set(-0.6);
		}else{
			cont.set(0);
		}
	}

	@Override
	public void runAuto(double distance, double speed, boolean useSensor) {
		int i = 0;
		while(i <= distance){
			cont.set(speed);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();			
			}
			i++;
		}
		cont.set(0);
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