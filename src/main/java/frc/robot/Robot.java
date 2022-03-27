// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Hashtable;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
	private Command m_autonomousCommand;

	public static Hashtable state = new Hashtable< String, Object >();

	private RobotContainer m_robotContainer;

  	/**
   	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
   	 */
	@Override
	public void robotInit() 
	{
		// Instantiate our RobotContainer.  This will perform all our button bindings, and put our
		// autonomous chooser on the dashboard.
		m_robotContainer = new RobotContainer();
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for items like
	 * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() 
	{
		// Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    	// commands, running already-scheduled commands, removing finished or interrupted commands,
    	// and running subsystem periodic() methods.  This must be called from the robot's periodic
    	// block in order for anything in the Command-based framework to work.
    	CommandScheduler.getInstance().run();

		Robot.state.put( "Arm Pos.", RobotContainer.intake.getPosition() );
		// Robot.state.put( "j3Y", -RobotContainer.j3.getY() );
		Robot.state.put( "LeftClimbV", RobotContainer.climber.getLeftClimberPosition() );
		Robot.state.put( "RightClimbV", RobotContainer.climber.getRightClimberPosition() );
	}

	/** 
	 * This function is called once each time the robot enters Disabled mode. 
	 */
	@Override
	public void disabledInit() 
	{
		RobotContainer.hooks.latch();
	}

	@Override
	public void disabledPeriodic() {}

  	/** 
	 * This autonomous runs the autonomous command selected by your {@link RobotContainer} class. 
	 */
  	@Override
	public void autonomousInit() 
	{
		m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    	// schedule the autonomous command (example)
    	if (m_autonomousCommand != null) 
    	{
			m_autonomousCommand.schedule();
		}

		configRobot();
	}
	private void configRobot() 
	{
		RobotContainer.climber.lock();

		RobotContainer.driveTrain.brake();

		RobotContainer.hooks.unlatch();

		RobotContainer.intake.resetEncoder();

		RobotContainer.shifter.lowGear();

		RobotContainer.slider.lock();
	}

  	/** This function is called periodically during autonomous. */
  	@Override
	public void autonomousPeriodic() {}

	@Override
	public void teleopInit() 
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.cancel();
		}

		RobotContainer.driveTrain.coast();
	}

  	/** This function is called periodically during operator control. */
  	@Override
  	public void teleopPeriodic() 
  	{
		SmartDashboard.putBoolean("Low Gear", RobotContainer.shifter.get() == Constants.LOW_GEAR );
		SmartDashboard.putBoolean("Hooks Latched", RobotContainer.hooks.get() == Constants.HOOKS_LATCHED );
		SmartDashboard.putBoolean("Climber Unlocked", RobotContainer.climber.get() == Constants.CLIMBER_UNLOCKED );
		SmartDashboard.putBoolean("Slider Unlocked", RobotContainer.slider.get() == Constants.SLIDER_UNLOCKED );
		RobotContainer.getRobotState();
  	}

	// WPI_TalonFX motor, motor2;	

	@Override
	public void testInit() 
	{
		// Cancels all running commands at the start of test mode.
		// CommandScheduler.getInstance().cancelAll();

		// motor = new WPI_TalonFX( RobotMap.LEFT_FRONT_DRIVE_ID );
		// motor2 = new WPI_TalonFX( RobotMap.RIGHT_FRONT_DRIVE_ID );

		// motor2.follow( motor, FollowerType.AuxOutput1 );
	}



	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() 
	{
		// motor.set( 0.25 );
	}
}
