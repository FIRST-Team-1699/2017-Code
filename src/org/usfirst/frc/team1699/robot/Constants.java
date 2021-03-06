package org.usfirst.frc.team1699.robot;

public class Constants {
	
	//Stores ports for joysticks/controllers
	public static final int DRIVER_CONTROLLER = 0;
	public static final int APPENDAGE_CONTROLLER = 1;
	
	//Motor controller PWMS
	public static final int MOTOR_PICKUP_PWM = 2;
	public static final int MOTOR_CLIMBER1 = 0;
	public static final int MOTOR_CLIMBER2 = 1;
	public static final int MOTOR_SHOOTER = 3;
	public static final int MOTOR_AGITATOR = 4;
	
	//Drive motor CAN IDs
	public static final int MOTOR_DRIVE_LEFT1 = 10;
	public static final int MOTOR_DRIVE_LEFT2 = 13;
	public static final int MOTOR_DRIVE_RIGHT1 = 12;
	public static final int MOTOR_DRIVE_RIGHT2 = 11;
	
	//Solenoid ports
	public static final int GEAR_MANIPULATOR_SOLENOID_OPEN = 4;
	public static final int GEAR_MANIPULATOR_SOLENOID_CLOSE = 5;
	public static final int BALL_DOOR_SOLENOID_OPEN = 1;
	public static final int BALL_DOOR_SOLENOID_CLOSE = 0;
	
	//Encoder ports
	public static final int ENCODER1_1 = 0;
	public static final int ENCODER1_2 = 1;
	public static final int ENCODER2_1 = 2;
	public static final int ENCODER2_2 = 3;
	
	//Auto file paths
	public static final String path = "/home/lvuser/";
	public static final String forward = "forward.nav";
	public static final String forwardLeftGear = "forwardLeftGear.nav";
	public static final String forwardRightGear = "forwardRightGear.nav";
	public static final String forwardGear = "forwardGear.nav";
}
