
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.frc.team1699.robot.commands.Turn;
import org.usfirst.frc.team1699.utils.command.CommandMap;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	private CommandMap map;
	
    public void robotInit() {
    	map = new CommandMap();
    	Pickup p = new Pickup(null, 0, null, null); //needs actual values
    	GearManipulator g = new GearManipulator(null, null, null, null, 0); //needs actual values
    	BallShooter b = new BallShooter(null, null, null, 0); //needs actual values
    	DriveBase db = new DriveBase(null, 0, null, null, null, null, null); //needs actual values
    	Drive d = new Drive(null, 0, null, null, null, null, null, null, null); //needs actual values
    	Turn t = new Turn(null, 0, null, null, null, null, null, null); //needs actual values
    	
    	map.addEntry(p.getName(), p);
    	map.addEntry(g.getName(), g);
    	map.addEntry(b.getName(), b);
    	map.addEntry(db.getName(), db);
    	map.addEntry(d.getName(), d);
    	map.addEntry(t.getName(), t);
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
    	
    }
    
    public void testPeriodic() {
        
    }
    
}
