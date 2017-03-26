
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.Agitator;
import org.usfirst.frc.team1699.robot.commands.BallDoor;
import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Climber;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
//import org.usfirst.frc.team1699.robot.commands.LineUp;
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
	//private LineUp l;
	
	private VictorSP pickup;
	private VictorSP shooter;
	private VictorSP climber1;
	private VictorSP climber2;
	private VictorSP agitator;
	
	private CANTalon driveLeft1;
	private CANTalon driveLeft2;
	private CANTalon driveRight1;
	private CANTalon driveRight2;
	
	//private NetworkTable table;
	//private PIDVision pidVision;
	
	private DoubleSolenoid gearManipulator;
	
	private DoubleSolenoid ballDoor;
	
	private XboxController driverController;
	private XboxController appendageController;
	
	private Encoder enc1;
	private Encoder enc2;
	
	private RobotDrive rd;
	
	private AutoScriptReader baseLineAuto;
	private AutoScriptReader gearLeftAuto;
	private AutoScriptReader gearRightAuto;
	private AutoScriptReader gearStraightAuto;
	
	private final String gearStraight = "Gear Straight";
	private final String gearLeft = "Gear Left";
	private final String gearRight = "Gear Right";
	private final String baseLine = "Base Line";
	private String autoSelected;
	@SuppressWarnings("rawtypes")
	private SendableChooser autoChooser;
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	
    public void robotInit() {
    	Solenoid.setDefaultSolenoidModule(25);
    	comp = new Compressor(25);
    	comp.start();
    	
    	driverController = new XboxController(0, 0.1);
    	appendageController = new XboxController(1, 0.1);
    	
    	pickup = new VictorSP(Constants.MOTOR_PICKUP_PWM);
    	shooter = new VictorSP(Constants.MOTOR_SHOOTER);
    	climber1 = new VictorSP(Constants.MOTOR_CLIMBER1);
    	climber2 = new VictorSP(Constants.MOTOR_CLIMBER2);
    	agitator = new VictorSP(Constants.MOTOR_AGITATOR);
    	
    	driveLeft1 = new CANTalon(Constants.MOTOR_DRIVE_LEFT1);
    	driveLeft2 = new CANTalon(Constants.MOTOR_DRIVE_LEFT2);
    	driveRight1 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT1);
    	driveRight2 = new CANTalon(Constants.MOTOR_DRIVE_RIGHT2);
    	
    	gearManipulator = new DoubleSolenoid(Constants.GEAR_MANIPULATOR_SOLENOID_OPEN, Constants.GEAR_MANIPULATOR_SOLENOID_CLOSE);
    	ballDoor = new DoubleSolenoid(Constants.BALL_DOOR_SOLENOID_OPEN, Constants.BALL_DOOR_SOLENOID_CLOSE);
    	
    	//pidVision = new PIDVision();
    	
    	//this might not be right
    	enc1 = new Encoder(Constants.ENCODER1_1, Constants.ENCODER1_2, false, Encoder.EncodingType.k4X);
    	enc2 = new Encoder(Constants.ENCODER2_1, Constants.ENCODER2_2, true, Encoder.EncodingType.k4X);
    	
    	//instantiate map
    	map = new AutoCommandMap();
    	
    	//define and instantiate commands
    	p = new Pickup("pickup", 0, appendageController, pickup);
    	g = new GearManipulator("gear", 1, appendageController, gearManipulator, ballDoor);
    	b = new BallShooter("shooter", 2, appendageController, shooter);
    	db = new DriveBase("driveBase", 3, driverController, driveLeft1, driveLeft2, driveRight1, driveRight2);
    	rd = new RobotDrive(driveLeft1, driveLeft2, driveRight1, driveRight2);
    	d = new Drive("drive", 4, driverController, rd, enc1, enc2);
    	t = new Turn("turn", 5, driverController, rd, enc1, enc2);
    	//a = new BallDoor("ballDoor", 6, appendageController, ballDoor);
    	c = new Climber("climber", 7, driverController, climber1, climber2); //does not have toggle
    	//l = new LineUp("lineUp", 8, rd, appendageController, table, pidVision);
    	
    	e = new Agitator("agitator", 8, appendageController, agitator);
    	s = new Sleep("sleep", 9);
    	
    	CameraServer.getInstance().startAutomaticCapture();
    	
    	//add commands to map
    	map.addEntry(g.getName(), g);
    	map.addEntry(b.getName(), b);
    	map.addEntry(d.getName(), d);
    	map.addEntry(t.getName(), t);
    	
    	//map.addEntry(a.getName(), a);
    	map.addEntry(e.getName(), e);
    	map.addEntry(s.getName(), s);
    	//map.addEntry(l.getName(), l);
    	
    	baseLineAuto = new AutoScriptReader(Constants.path + Constants.forward, map);
    	gearLeftAuto = new AutoScriptReader(Constants.path + Constants.forwardLeftGear, map);
        gearRightAuto = new AutoScriptReader(Constants.path + Constants.forwardRightGear, map);
        gearStraightAuto = new AutoScriptReader(Constants.path + Constants.forwardGear, map);
    	
    	p.init();
    	g.init();
    	b.init();
    	db.init();
    	//a.init();
    	c.init();
    	e.init();
    	//l.init();
    	
    	System.out.println("|------------------------------------------------------|");
    	System.out.println("| Team 1699 Robot: awating drive mode           |");
    	System.out.println("|------------------------------------------------------|");
    	autoChooser = new SendableChooser();
    	autoChooser.addObject("Gear Straight",  gearStraight);
    	autoChooser.addObject("Gear Left", gearLeft);
    	autoChooser.addObject("Gear Right", gearRight);
    	autoChooser.addObject("Base Line", baseLine);
    	
    	SmartDashboard.putData("AutoChooser", autoChooser);
    	this.updateDashboard();
    }
    
    public void robotPeriodic(){
    	this.updateDashboard();
    }
    
    public void disabledInit(){
    	this.updateDashboard();
    }
	
	public void disabledPeriodic() {
		this.updateDashboard();
	}

    public void autonomousInit() {
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
        this.updateDashboard();
    }
    
    public void autonomousPeriodic() {
    	this.updateDashboard();
    }

    public void teleopInit() {
    	this.updateDashboard();
    }

    public void teleopPeriodic() {
    	p.run();
    	g.run();
    	b.run();
    	db.run();
  //  	a.run();
    	c.run();
    	e.run();
    	//l.run();
    	//rd.arcadeDrive(driverController);
    	//this.updateDashboard();
    }
    
    public void testPeriodic() {
    	this.updateDashboard();
    }
    
    private void updateDashboard(){
//    	p.outputToDashboard();
//    	g.outputToDashboard();
//    	b.outputToDashboard();
//    	db.outputToDashboard();
//    	d.outputToDashboard();
//    	t.outputToDashboard();
//    	c.outputToDashboard();
    }
    
}