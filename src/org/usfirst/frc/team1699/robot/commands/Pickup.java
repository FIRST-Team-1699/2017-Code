package org.usfirst.frc.team1699.robot.commands;

import org.usfirst.frc.team1699.utils.command.Command;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.SpeedController;

public class Pickup extends Command{
	private XboxController controller;
	private SpeedController motor;
	public Pickup(String name, int id, XboxController controller, SpeedController motor) {
		super(name, id);
		this.controller = controller;
		this.motor = motor;
		
	}
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		if (controller.getA()){ //check to see if the button A is pressed
			motor.set(1);  //turns motor on
			}
		else if (controller.getB()){ //check to see if the button B is pressed
			motor.set(0);  //turns motor on
			}
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
		
	}}