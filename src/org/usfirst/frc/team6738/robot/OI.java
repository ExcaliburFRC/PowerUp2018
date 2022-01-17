/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6738.robot;

import org.usfirst.frc.team6738.robot.commandsElevator.DropServo;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersHold;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersRollIn;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersRollOut;
import org.usfirst.frc.team6738.robot.commands.SwitchExposure;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick stickDrive;
	public Joystick stickArms;

	public JoystickButton catchB;
	public JoystickButton rollersHoldB;
	public JoystickButton injectB;
	public JoystickButton pullServo;
	public JoystickButton switchExposure;

	public OI() {
		stickDrive = new Joystick(1);
		stickArms = new Joystick(0);

		//nitai
		catchB = new JoystickButton(stickArms, 1);
		injectB = new JoystickButton(stickArms, 2);
		pullServo = new JoystickButton(stickArms, 4);
		rollersHoldB = new JoystickButton(stickArms, 5);
		switchExposure = new JoystickButton(stickArms, 7);
		//nitai end
		
		catchB.whileHeld(new RollersRollIn());
		rollersHoldB.whileHeld(new RollersHold());
		injectB.whileHeld(new RollersRollOut());
		pullServo.whileHeld(new DropServo());
		switchExposure.whenPressed(new SwitchExposure(10));
		
	}
}
