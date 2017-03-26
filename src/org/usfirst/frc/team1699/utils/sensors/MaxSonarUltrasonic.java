package org.usfirst.frc.team1699.utils.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class MaxSonarUltrasonic {
	private final double IN_TO_CM_CONVERSION = 2.54;
	private boolean useUnits; //use units or return voltage?
	private double minVoltage; //Minimum voltage the ultrasonic sensor can return
	private double voltageRange; //Range of voltages returned by the sensor (maximum - minimum)
	private double minDistance; //Minimum distance the ultrasonic sensor can return in inches
	private double distanceRange; //The range of the distances returned by this class in inches (maximum - minimum)
	AnalogInput input;
	
	//constructor
	public MaxSonarUltrasonic(int input) {
		this.input = new AnalogInput(input);
		
		//default values
		useUnits = true;
		minVoltage = 0.5;
		voltageRange = 5.0 - minVoltage;
		minDistance = 3.0;
		distanceRange = 60.0 - minDistance;	
	}
	
	//constructor
	public MaxSonarUltrasonic(int input, boolean useUnits, double minVoltage, double maxVoltage, 
			double minDistance, double maxDistance) {
		this.input = new AnalogInput(input);
		
		//only use unit-specific variables if we're using units
		if(useUnits){
			this.useUnits = true;
			this.minVoltage = minVoltage;
			voltageRange = maxVoltage - minVoltage;
			this.minDistance = minDistance;
			distanceRange = maxDistance - minDistance;
		}
	}
	
	//Just get voltage
	double GetVoltage() {
		return input.getVoltage();
	}
	
	/* GetRangeInInches
	 * Returns the range in inches
	 * Returns -1.0 if units are not being used
	 * Returns -2.0 if the voltage is below the minimum voltage
	 */
	double GetRangeInInches(){
		double range;
		
		//if we're not using units, return -1
		if(!useUnits){
			return -1.0;
		}
		
		range = input.getVoltage();
		
		if(range < minVoltage){
			return -2.0;
		}
		
		//normalize the voltage
		range = (range - minVoltage) / voltageRange;
		
		//denormalize the unit range
		range = (range * distanceRange) + minDistance;
		
		return range;
	}
	
	/* GetRangeInCM
	 * Returns the range in centimeters
	 * Returns -1.0 if units are not being used
	 * Returns -2.0 if the voltage is below the minimum voltage
	 */
	double GetRangeInCM(){
		double range;
		
		//if we're not using units, return -1
		if(!useUnits){
			return -1.0;
		}
		
		range = input.getVoltage();
		
		if(range < minVoltage){
			return -2.0;
		}
		
		//normalize the voltage
		range = (range - minVoltage) / voltageRange;
		
		//denormalize unit range
		range = (range * distanceRange) + minDistance;
		
		//convert to centimeters
		range *= IN_TO_CM_CONVERSION;
		
		return range;
	}
}
