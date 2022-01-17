package org.usfirst.frc.team6738.robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;


public class OutputEncoder implements PIDOutput{

	double speed_data;
	
	public OutputEncoder() {
		this.speed_data = 0;
	}
	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		speed_data = output;
	}

	public double get() {
		return speed_data;
	}


}
