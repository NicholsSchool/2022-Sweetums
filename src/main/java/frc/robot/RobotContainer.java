// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
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
	public static XboxController c2;
	public static JoystickController j3;

	// Compressor
	// Compressor compressor;

	// Subsystems
	public static DriveTrain driveTrain;
	public static Indexer indexer;
	public static Intake intake;
	public static Roller roller;
	// public static Shifter shifter; 
	public static Shooter shooter;
	// public static Slider slider;

  	/** 
	 * The container for the robot. Contains subsystems, OI devices, and commands. 
	 */
  	public RobotContainer() 
	{
    	j0 = new JoystickController( 0 );
		j1 = new JoystickController( 1 );
    	c2 = new XboxController( 2 );
		j3 = new JoystickController( 3 );

		// compressor = new Compressor( PneumaticsModuleType.CTREPCM );
		
    	driveTrain = new DriveTrain();
		indexer = new Indexer();
		intake = new Intake();
		roller = new Roller();
		// shifter = new Shifter();
		shooter = new Shooter();
		// slider = new Slider();

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

		intake.setDefaultCommand( new LiftArm() );

		// intakeSwitch.setDefaultCommand( new InstantCommand( () -> intakeSwitch.getPressed() ) );

		// Driver
        // j0.b2.whenPressed( new InstantCommand( () -> shifter.toggle() ) );

		j1.b1.whenPressed( new InstantCommand( () -> intake.goToPosition( Constants.DOWN ) ) );
		j1.b1.whileHeld( new TakeIn() );
		j1.b1.whenReleased( new InstantCommand( () -> intake.goToPosition( Constants.UP ) ) );

		// Operator
		c2.rTrigger.whileHeld( new ShootHigh() );
		c2.rBumper.whileHeld( new ShootLow() );
		c2.y.whileHeld( new ThrowAway() );

		c2.dpadUp.whenPressed( new InstantCommand( () -> intake.goToPosition( Constants.UP ) ) );
		c2.dpadDown.whenPressed( new InstantCommand( () -> intake.goToPosition( Constants.DOWN ) ) );
		c2.a.whileHeld( new TakeOut() );
		c2.b.whileHeld( new TakeIn() );
	}

	public static void getRobotState() 
	{
		Robot.state.put( "Shooter Velocity", RobotContainer.shooter.getVelocity() );
		Robot.state.put( "Intake Switch", intake.isButtonPressed() );
		// Robot.state.put( "Ball", '!' );
		// Robot.state.put( "Gear", shifter.get() == true? "High" : "Low" );
		// // Robot.state.put( "Intake", piston.get() == true? "Extended" : "In" );
		// Robot.state.put( "Slider", slider.get() == true? "In" : "Extended" );
		System.out.println( Robot.state );
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
