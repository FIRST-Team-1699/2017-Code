
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.BallDoor;
import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Climber;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.frc.team1699.robot.commands.Turn;
import org.usfirst.frc.team1699.utils.command.AutoCommandMap;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
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
	
	private VictorSP pickup;
	private VictorSP shooter;
	private VictorSP climber1;
	private VictorSP climber2;
	
	private TalonSRX driveLeft1;
	private TalonSRX driveLeft2;
	private TalonSRX driveRight1;
	private TalonSRX driveRight2;
	
	private DoubleSolenoid gearManipulator;
	private DoubleSolenoid ballDoor;
	
	private XboxController driverController;
	private XboxController appendageController;
	
	private Encoder enc1;
	private Encoder enc2;
	
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
    	
    	driveLeft1 = new TalonSRX(Constants.MOTOR_DRIVE_LEFT1);
    	driveLeft2 = new TalonSRX(Constants.MOTOR_DRIVE_LEFT2);
    	driveRight1 = new TalonSRX(Constants.MOTOR_DRIVE_RIGHT1);
    	driveRight2 = new TalonSRX(Constants.MOTOR_DRIVE_RIGHT2);
    	
    	gearManipulator = new DoubleSolenoid(Constants.GEAR_MANIPULATOR_SOLENOID_OPEN, Constants.GEAR_MANIPULATOR_SOLENOID_CLOSE);
    	ballDoor = new DoubleSolenoid(Constants.BALL_DOOR_SOLENOID_OPEN, Constants.BALL_DOOR_SOLENOID_CLOSE);
    	
    	//this might not be right
    	enc1 = new Encoder(Constants.ENCODER1_1, Constants.ENCODER1_2, false, Encoder.EncodingType.k4X);
    	enc2 = new Encoder(Constants.ENCODER2_1, Constants.ENCODER2_2, true, Encoder.EncodingType.k4X);
    	
    	//instantiate map
    	map = new AutoCommandMap();
    	
    	//define and instantiate commands
    	p = new Pickup("pickup", 0, appendageController, pickup); //needs actual values
    	g = new GearManipulator("gear", 1, appendageController, gearManipulator); //needs actual values (does not have toggle param)
    	b = new BallShooter("shooter", 2, appendageController, shooter); //needs actual values
    	db = new DriveBase("driveBase", 3, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2); //needs actual values
    	d = new Drive("drive", 4, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2, enc1, enc2); //needs actual values
    	t = new Turn("turn", 5, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2, enc1, enc2); //needs actual values
    	a = new BallDoor("auger", 6, appendageController, ballDoor); //needs actual values
    	c = new Climber("climber", 7, appendageController, climber1, climber2, comp); //needs actual values (does not have toggle param)
    	
    	//add commands to map
    	map.addEntry(g.getName(), g);
    	map.addEntry(b.getName(), b);
    	map.addEntry(d.getName(), d);
    	map.addEntry(t.getName(), t);
    	map.addEntry(a.getName(), a);
    	
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
    	
    }

    public void teleopPeriodic() {
    	p.run();
    	g.run();
    	b.run();
    	db.run();
    	a.run();
    	c.run();
    }
    
    public void testPeriodic() {
        
    }
    
}
