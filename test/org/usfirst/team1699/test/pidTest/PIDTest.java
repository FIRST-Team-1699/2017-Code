package org.usfirst.team1699.test.pidTest;

import org.junit.Test;
import org.usfirst.frc.team1699.robot.pid.PIDLoop;

public class PIDTest {
	@Test
	public void testPID() {
		final int CONSTANT = 180;
		PIDLoop pid;
		TestPIDSensor sensor = new TestPIDSensor();
		pid = new PIDLoop("test_loop", 0, 0.1, 0.1, 0.5, sensor);
		
		pid.setGoal(CONSTANT);
			while(sensor.get() != CONSTANT){
				if(sensor.get() > CONSTANT) {
					System.out.println(pid.output());
				}else if(sensor.get() < CONSTANT) {
					System.out.println(pid.output());
				}
				sensor.set((int) (sensor.get() + pid.output()));
		}
	}
}
