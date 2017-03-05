
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.Agitator;
import org.usfirst.frc.team1699.robot.commands.BallDoor;
import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Climber;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.frc.team1699.robot.commands.Sleep;
import org.usfirst.frc.team1699.robot.commands.Turn;
import org.usfirst.frc.team1699.utils.command.AutoCommandMap;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Robot extends IterativeRobot {
	
	//define and instantiate commands
	private Pickup p;
	private GearManipulator g;
	private BallShooter b;
	private DriveBase db;
	private Drive d;
	private Turn t;
	private BallDoor a;
	private Climber c;
	private AutoCommandMap map;
	private Compressor comp;
	private Agitator e;
	private Sleep s;
	
	private VictorSP pickup;
	private VictorSP shooter;
	private VictorSP climber1;
	private VictorSP climber2;
	
	private CANTalon driveLeft1;
	private CANTalon driveLeft2;
	private CANTalon driveRight1;
	private CANTalon driveRight2;
	
	private DoubleSolenoid gearManipulator;
	
	private DoubleSolenoid ballDoor;
	private DoubleSolenoid agitator;
	
	private XboxController driverController;
	private XboxController appendageController;
	
	private Encoder enc1;
	private Encoder enc2;
	
	private RobotDrive rd;
	
    public void robotInit() {
    	Solenoid.setDefaultSolenoidModule(0);
    	comp = new Compressor(0);
    	comp.start();
    	
    	driverController = new XboxController(0, 0.1);
    	appendageController = new XboxController(1, 0.1);
    	
    	pickup = new VictorSP(Constants.MOTOR_PICKUP_PWM);
    	shooter = new VictorSP(Constants.MOTOR_SHOOTER);
    	climber1 = new VictorSP(Constants.MOTOR_CLIMBER1);
    	climber2 = new VictorSP(Constants.MOTOR_CLIMBER2);
    	
    	driveLeft1 = new CANTalon(Constants.MOTOR_DRIVE_LEFT1);
    	driveLeft2 = new CANTalon(Constants.MOTOR_DRIVE_LEFT2);
    	driveRight1 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT1);
    	driveRight2 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT2);
    	
    	gearManipulator = new DoubleSolenoid(Constants.GEAR_MANIPULATOR_SOLENOID_OPEN, Constants.GEAR_MANIPULATOR_SOLENOID_CLOSE);
    	ballDoor = new DoubleSolenoid(Constants.BALL_DOOR_SOLENOID_OPEN, Constants.BALL_DOOR_SOLENOID_CLOSE);
        agitator = new DoubleSolenoid(Constants.AGITATOR_SOLENOID_OPEN, Constants.AGITATOR_SOLENOID_CLOSE);
    	
    	//this might not be right
    	enc1 = new Encoder(Constants.ENCODER1_1, Constants.ENCODER1_2, false, Encoder.EncodingType.k4X);
    	enc2 = new Encoder(Constants.ENCODER2_1, Constants.ENCODER2_2, true, Encoder.EncodingType.k4X);
    	
    	//instantiate map
    	map = new AutoCommandMap();
    	
    	//define and instantiate commands
    	p = new Pickup("pickup", 0, appendageController, pickup);
    	g = new GearManipulator("gear", 1, appendageController, gearManipulator); //does not have toggle
    	b = new BallShooter("shooter", 2, appendageController, shooter);
    	//db = new DriveBase("driveBase", 3, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2);
    	rd = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);
    	d = new Drive("drive", 4, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2, enc1, enc2);
    	t = new Turn("turn", 5, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2, enc1, enc2);
    	a = new BallDoor("auger", 6, appendageController, ballDoor);
    	c = new Climber("climber", 7, appendageController, climber1, climber2, comp); //does not have toggle
    	e = new Agitator("agitator", 8, appendageController, agitator);
    	s = new Sleep("sleep", 9);
    	
    	
    	//add commands to map
    	map.addEntry(g.getName(), g);
    	map.addEntry(b.getName(), b);
    	map.addEntry(d.getName(), d);
    	map.addEntry(t.getName(), t);
    	
    	map.addEntry(a.getName(), a);
    	map.addEntry(c.getName(), e);
    	map.addEntry(s.getName(), s);
    }
    
    public void robotPeriodic(){
    	
    }

    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		
	}

    public void autonomousInit() {
        
    }
    
    public void autonomousPeriodic() {
    	
    }

    public void teleopInit() {
    	p.init();
    	g.init();
    	b.init();
    	db.init();
    	a.init();
    	c.init();
    	e.init();
    }

    public void teleopPeriodic() {
    	p.run();
    	g.run();
    	b.run();
    	db.run(); //Might break
    	a.run();
    	c.run();
    	e.run();
    	//rd.arcadeDrive(driverController);
    }
    
    public void testPeriodic() {
        
    }
    
}
