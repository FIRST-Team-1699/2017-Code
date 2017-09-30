
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.Agitator;
import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Climber;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.frc.team1699.robot.commands.Sleep;
import org.usfirst.frc.team1699.robot.commands.Turn;
import org.usfirst.frc.team1699.utils.autonomous.AutoScriptReader;
import org.usfirst.frc.team1699.utils.command.AutoCommandMap;
import org.usfirst.frc.team1699.utils.drive.XboxController;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	//Defines commands
	private Pickup p;
	private GearManipulator g;
	private BallShooter b;
	private DriveBase db;
	private Drive d;
	private Turn t;
	private Climber c;
	private AutoCommandMap map;
	private Compressor comp;
	private Agitator e;
	private Sleep s;
	
	//Ball manipulator motor controllers
	private VictorSP pickup;
	private VictorSP shooter;
	
	//Climber motor controllers
	private VictorSP climber1;
	private VictorSP climber2;
	
	//Agitator motor controller
	private VictorSP agitator;
	
	//Drive motor controllers
	private CANTalon driveLeft1;
	private CANTalon driveLeft2;
	private CANTalon driveRight1;
	private CANTalon driveRight2;
	
	//Solenoids
	private DoubleSolenoid gearManipulator1;
	private DoubleSolenoid gearManipulator2;
	
	//Controllers
	private XboxController driverController;
	private XboxController appendageController;
	
	//Encoders
	private Encoder enc1;
	private Encoder enc2;
	
	//Robot drive
	private RobotDrive rd;
	
	//Auto scripts
	private AutoScriptReader baseLineAuto;
	private AutoScriptReader gearLeftAuto;
	private AutoScriptReader gearRightAuto;
	private AutoScriptReader gearStraightAuto;
	
	//Auto modes
	private final String gearStraight = "Gear Straight";
	private final String gearLeft = "Gear Left";
	private final String gearRight = "Gear Right";
	private final String baseLine = "Base Line";
	private String autoSelected;
	private SendableChooser<String> autoChooser;
	
    public void robotInit() {
    	//Compressor/Solenoid init
    	Solenoid.setDefaultSolenoidModule(25);
    	comp = new Compressor(25);
    	comp.start();
    	
    	//Controller init
    	driverController = new XboxController(0, 0.1);
    	appendageController = new XboxController(1, 0.1);
    	
    	//Motor controller init
    	pickup = new VictorSP(Constants.MOTOR_PICKUP_PWM);
    	shooter = new VictorSP(Constants.MOTOR_SHOOTER);
    	climber1 = new VictorSP(Constants.MOTOR_CLIMBER1);
    	climber2 = new VictorSP(Constants.MOTOR_CLIMBER2);
    	agitator = new VictorSP(Constants.MOTOR_AGITATOR);
    	driveLeft1 = new CANTalon(Constants.MOTOR_DRIVE_LEFT1);
    	driveLeft2 = new CANTalon(Constants.MOTOR_DRIVE_LEFT2);
    	driveRight1 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT1);
    	driveRight2 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT2);
    	
    	//Solenoid init
    	gearManipulator1 = new DoubleSolenoid(Constants.GEAR_MANIPULATOR_SOLENOID_OPEN, Constants.GEAR_MANIPULATOR_SOLENOID_CLOSE);
    	gearManipulator2 = new DoubleSolenoid(Constants.BALL_DOOR_SOLENOID_OPEN, Constants.BALL_DOOR_SOLENOID_CLOSE);

    	//Encoder init
    	enc1 = new Encoder(Constants.ENCODER1_1, Constants.ENCODER1_2, false, Encoder.EncodingType.k4X);
    	enc2 = new Encoder(Constants.ENCODER2_1, Constants.ENCODER2_2, true, Encoder.EncodingType.k4X);
    	
    	//Map init
    	map = new AutoCommandMap();
    	
    	//Command init
    	p = new Pickup("pickup", 0, appendageController, pickup);
    	g = new GearManipulator("gear", 1, appendageController, gearManipulator1, gearManipulator2);
    	b = new BallShooter("shooter", 2, appendageController, shooter);
    	db = new DriveBase("driveBase", 3, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2);
    	rd = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);
    	d = new Drive("drive", 4, driverController, rd, enc1, enc2);
    	t = new Turn("turn", 5, driverController, rd, enc1, enc2);
    	c = new Climber("climber", 7, driverController, climber1, climber2);
    	e = new Agitator("agitator", 8, appendageController, agitator);
    	s = new Sleep("sleep", 9);
    	
    	//Camera init
    	CameraServer.getInstance().startAutomaticCapture();
    	
    	//Adds commands to map for auto
    	map.addEntry(g.getName(), g);
    	map.addEntry(b.getName(), b);
    	map.addEntry(d.getName(), d);
    	map.addEntry(t.getName(), t);
    	map.addEntry(e.getName(), e);
    	map.addEntry(s.getName(), s);
    	
    	//Auto command init
    	baseLineAuto = new AutoScriptReader(Constants.path + Constants.forward, map);
    	gearLeftAuto = new AutoScriptReader(Constants.path + Constants.forwardLeftGear, map);
        gearRightAuto = new AutoScriptReader(Constants.path + Constants.forwardRightGear, map);
        gearStraightAuto = new AutoScriptReader(Constants.path + Constants.forwardGear, map);
    	
        //Command init
    	p.init();
    	g.init();
    	b.init();
    	db.init();
    	c.init();
    	e.init();
    	
    	//Init msg
    	System.out.println("|------------------------------------------------------|");
    	System.out.println("| Team 1699 Robot: awating drive mode           |");
    	System.out.println("|------------------------------------------------------|");
    	
    	//Used to set auto mode
    	autoChooser = new SendableChooser<String>();
    	autoChooser.addObject("Gear Straight",  gearStraight);
    	autoChooser.addObject("Gear Left", gearLeft);
    	autoChooser.addObject("Gear Right", gearRight);
    	autoChooser.addObject("Base Line", baseLine);
    	
    	//Puts auto mode selector on dashboard
    	SmartDashboard.putData("AutoChooser", autoChooser);
    }

    //Called during the start of auto
    public void autonomousInit() {
    	//Runs selected auto mode
        autoSelected = (String) autoChooser.getSelected();
        
        System.out.println("Auto Mode: " + autoSelected);
        
        System.out.println("Auto Selected: " + autoSelected);
        switch(autoSelected){
        	case baseLine: baseLineAuto.runScript();
        		break;
        	case gearLeft: gearLeftAuto.runScript();
        		break;
        	case gearRight: gearRightAuto.runScript();
        		break;
        	case gearStraight: gearStraightAuto.runScript();
        		break;
        	default: baseLineAuto.runScript();
        		break;
        }
    }

    public void teleopPeriodic() {
    	//Runs commands during teleop
    	p.run();
    	g.run();
    	b.run();
    	db.run();
    	c.run();
    	e.run();
    }
}