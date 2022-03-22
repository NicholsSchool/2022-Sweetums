// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;
import frc.robot.autonomous.EncoderDrive;
import frc.robot.autonomous.GyroTurn;
import frc.robot.autonomous.*;
import frc.robot.commands.*;
import frc.robot.sensors.NavX;
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

	// Compressor
	Compressor compressor;

	// Sensors
	public static DigitalInput button;

	// Subsystems
	public static AHRS ahrs;
	public static Climber climber;
	public static DriveTrain driveTrain;
	public static Hooks hooks;
	public static Indexer indexer;
	public static Intake intake;
	public static NavX navX;
	public static Roller roller;
	public static Shifter shifter; 
	public static Shooter shooter;
	public static Slider slider;

  	/** 
	 * The container for the robot. Contains subsystems, OI devices, and commands. 
	 */
  	public RobotContainer() 
	{
		// Controllers
    	j0 = new JoystickController( 0 );
		j1 = new JoystickController( 1 );
    	c2 = new XboxController( 2 );

		// Compressors
		compressor = new Compressor( PneumaticsModuleType.CTREPCM );
		
		// Sensors
		button = new DigitalInput( RobotMap.BUTTON_CHANNEL );

		// Subsystems
		ahrs = new AHRS( SPI.Port.kMXP );
		climber = new Climber();
    	driveTrain = new DriveTrain();
		hooks = new Hooks();
		indexer = new Indexer();
		intake = new Intake();
		intake.resetEncoder();
		navX = new NavX( ahrs );
		roller = new Roller();
		shifter = new Shifter();
		shooter = new Shooter();
		slider = new Slider();

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

		// button.setDefaultCommand( new CheckButton() );

		// Driver
        j0.b2.whenPressed( new InstantCommand( () -> shifter.toggle() ) );

		j0.b1.whileHeld( new TakeIn() );

		j1.b1.whenPressed( new InstantCommand( () -> intake.goToPosition( 50 ) ) );
		j1.b1.whileHeld( new TakeIn() );
		j1.b1.whenReleased( new InstantCommand( () -> intake.goToPosition( 0 ) ) );

		j0.b5.whileHeld( new LiftArm( Constants.INTAKE_SLAM_DOWN_POWER ) );

		j1.b2.whenPressed( new InstantCommand( () -> driveTrain.setToIgnoreCorrection( true ) ) );
		j1.b2.whenReleased( new InstantCommand( () -> driveTrain.setToIgnoreCorrection( false ) ) );

		// Operator
		c2.rTrigger.whileHeld( new ShootHigh() );
		c2.rBumper.whileHeld( new ShootLow() );
		c2.dpadDown.whileHeld( new ThrowAway() );
		c2.dpadUp.whileHeld( new ShootTest() );

		// // Climbing
		// c2.a.whenPressed( new InstantCommand( () -> climber.resetClimberEncoders() ).andThen( 
		// 				  new InstantCommand( () -> climber.toggleClimberSolenoid() ) ) ); 

		// c2.dpadLeft.whenPressed( new InstantCommand( () -> climber.resetClimberEncoders() ) );

		c2.select.toggleWhenPressed( ( new TuckClimber() ).withInterrupt( () -> c2.start.get() ) );
		c2.b.whenPressed( new InstantCommand( () -> hooks.toggle() ) );
		c2.y.whenPressed( new InstantCommand( () -> slider.toggle() ) );
		c2.x.toggleWhenPressed( new TuckIntake() );
		c2.dpadRight.whileHeld( new InstantCommand( () -> climber.resetClimberEncoders() ).andThen( new PIDClimb( 78, 78 ) ) );
		c2.start.whileHeld( new PIDClimb( 77, 77 ) );
	}

	public static void getRobotState() 
	{
		Robot.state.put( "Shooter Velocity", RobotContainer.shooter.getVelocity() );
		// Robot.state.put( "Gear", shifter.get() == true? "High" : "Low" );
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
		return new InstantCommand( () -> intake.goToPosition( 50 ) ).andThen( new EncoderDrive( 48, 0.5 ).andThen( new GyroTurn( 90, 0.5 ) ) );
	}
}
