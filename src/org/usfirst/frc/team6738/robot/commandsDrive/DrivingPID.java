package org.usfirst.frc.team6738.robot.commandsDrive;

import org.usfirst.frc.team6738.robot.Robot;
import org.usfirst.frc.team6738.robot.subsystems.Chassi;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivingPID extends Command 
{
	private static int DRIVING_UNIT = 2048;
	private static double FACTOR_ERROR = 0.4; //nitai - if the robot sotae  - increase this, if he gets crazy, decrease
	
	private double left_distance;
	private double right_distance;
	private Chassi drive;
	private boolean inTurning;

	double dif_error;
	
	private double left_speed, right_speed;
	public DrivingPID(double left, double right) {
		left_distance = left * DRIVING_UNIT;
		right_distance = right * DRIVING_UNIT;
		requires(Robot.drive);
		this.drive = Robot.drive;
		dif_error = 0;
		inTurning = left * right < 0;
	}

	@Override
	protected void initialize() {
		drive.getLeftEncoder().reset();
		drive.getRightEncoder().reset();
		
		drive.getPIDLeft().enable();
		drive.getPIDRight().enable();
		
		drive.getPIDLeft().setSetpoint(left_distance);
		drive.getPIDRight().setSetpoint(right_distance);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() 
	{

		//if you need to use this line - just in extrime situation - put everything else in comma
		drive.setLeftDrive(-1, 1); 
		drive.setRightDrive(-1,1);
		
		
		/*dif_error =  ((drive.getPIDLeft().getError() / left_distance) - (drive.getPIDRight().getError() / right_distance)) * FACTOR_ERROR; //(drive.getPIDLeft().getError() - drive.getPIDRight().getError()) * FACTOR_ERROR; //> 0 ? FACTOR_ERROR : -FACTOR_ERROR;
		//dif_error = 0; // nitai - put this to cancel PID
		left_speed = drive.getPIDLeft().get();
		right_speed = drive.getPIDRight().get();
		
		drive.setLeftDrive(-left_speed, (inTurning? 0.3 : 0.5) + dif_error); //nitai - 0.3 = speed when turning, 0.5 = speed when driving
		drive.setRightDrive(-right_speed, (inTurning? 0.3 : 0.5) - dif_error); //nitai - 0.3 = speed when turning, 0.5 = speed when driving
		
		SmartDashboard.putNumber("Auto - left pid error :", drive.getPIDLeft().getError());
		SmartDashboard.putNumber("Auto - right pid error :", drive.getPIDRight().getError());
		SmartDashboard.putNumber("Auto - dif error:", drive.getPIDLeft().getError() - drive.getPIDRight().getError());
		*/
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(drive.getPIDLeft().getError())<100 && Math.abs(drive.getPIDRight().getError())<100;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		drive.setLeftDrive(0,0);
		drive.setRightDrive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
