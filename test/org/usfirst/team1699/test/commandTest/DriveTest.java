package org.usfirst.team1699.test.commandTest;

import org.junit.Test;
import org.usfirst.frc.team1699.robot.commands.Pickup;
import org.usfirst.team1699.test.simElectronics.SimSpeedController;
import org.usfirst.team1699.test.simElectronics.SimXboxController;

public class DriveTest {
	
	@Test
	public void driveTest(){
		SimXboxController xbox = new SimXboxController(0, 0.1);
		SimSpeedController cont1 = new SimSpeedController();
		SimSpeedController cont2 = new SimSpeedController();
		SimSpeedController cont3 = new SimSpeedController();
		SimSpeedController cont4 = new SimSpeedController();
		Pickup p = new Pickup("pickup", 0, xbox, cont1);
		p.run();
		xbox.setState(SimXboxController.Button.A, SimXboxController.State.Pressed);
		p.run();
	}
}
