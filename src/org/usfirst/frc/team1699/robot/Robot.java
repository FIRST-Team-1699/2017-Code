
package org.usfirst.frc.team1699.robot;

import org.usfirst.frc.team1699.robot.commands.Auger;
import org.usfirst.frc.team1699.robot.commands.BallShooter;
import org.usfirst.frc.team1699.robot.commands.Climber;
import org.usfirst.frc.team1699.robot.commands.Drive;
import org.usfirst.frc.team1699.robot.commands.DriveBase;
import org.usfirst.frc.team1699.robot.commands.GearManipulator;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.frc.team1699.robot.commands.Turn;
import org.usfirst.frc.team1699.utils.command.AutoCommandMap;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	private AutoCommandMap map;
	
    public void robotInit() {
    	//instantiate map
    	map = new AutoCommandMap();
    	
    	//define and instantiate commands
    	Pickup p = new Pickup("pickup", 0, null, null); //needs actual values
    	GearManipulator g = new GearManipulator("gear", 0, null, null, null); //needs actual values (does not have toggle param)
    	BallShooter b = new BallShooter("shooter", 0, null, null); //needs actual values
    	DriveBase db = new DriveBase("drive base", 0, null, null, null, null, null); //needs actual values
    	Drive d = new Drive("dive", 0, null, null, null, null, null, null, null); //needs actual values
    	Turn t = new Turn("turn", 0, null, null, null, null, null, null); //needs actual values
    	Auger a = new Auger("auger", 0, null, null); //needs actual values
    	Climber c = new Climber("climber", 0, null, null, null, null, null, null, null); //needs actual values (does not have toggle param)
    	
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
    	
    }
    
    public void testPeriodic() {
        
    }
    
}
