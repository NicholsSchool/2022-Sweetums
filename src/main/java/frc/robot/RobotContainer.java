// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;


import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{	
	// Controllers 
	public static JoystickController j0;
	public static JoystickController j1;
	public static XboxController c0;
	public static XboxController c1;

	public static DriveTrain driveTrain;
	public static Indexer indexer;
	public static Roller roller;
	public static Shifter shifter; 
	public static Shooter shooter;
	public static Slider slider;
	public static Sorter sorter;

  	/** 
	 * The container for the robot. Contains subsystems, OI devices, and commands. 
	 */
  	public RobotContainer() 
	{
    	c0 = new XboxController( 0 );
    	c1 = new XboxController( 1 );
		
    	driveTrain = new DriveTrain();
		indexer = new Indexer();
		roller = new Roller();
		shifter = new Shifter();
		shooter = new Shooter();
		slider = new Slider();
		sorter = new Sorter();

    	configureButtonBindings();
  	}
	
	/**
	 * Use this method to define your button->command mappings. Buttons can be created by
   	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
	 * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() 
	{
		driveTrain.setDefaultCommand( new Drive() );
		//Driver Controller
		
        j0.b2.whenPressed( new InstantCommand( () -> shifter.toggle() ) );

	}

  	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() 
	{
		return null;
	}
}
