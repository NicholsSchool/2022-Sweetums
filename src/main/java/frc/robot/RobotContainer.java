// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;

import frc.robot.commands.Shoot;
import frc.robot.subsystems.Shooter;

import frc.robot.subsystems.Indexer;

import frc.robot.commands.Climb;
import frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{	
	// Controllers 
	public static XboxController c0;
	public static XboxController c1;

	public static DriveTrain driveTrain;
	public static Shooter shooter;
	public static Indexer indexer;
	public static Climber climber;

  	/** 
	 * The container for the robot. Contains subsystems, OI devices, and commands. 
	 */
  	public RobotContainer() 
	{
    	c0 = new XboxController( 0 );
    	c1 = new XboxController( 1 );
		
    	driveTrain = new DriveTrain();
		shooter = new Shooter();
		indexer = new Indexer();
		climber = new Climber();

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
