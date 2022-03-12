package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase 
{
    private CANSparkMax rightClimb;
    private CANSparkMax leftClimb;

    private RelativeEncoder rightClimberEncoder;
    private RelativeEncoder leftClimberEncoder;

    private Solenoid climberSolenoid;

    private SparkMaxPIDController rightClimbPIDController;
    private SparkMaxPIDController leftClimbPIDController;

    // private final double EPSILON = 1;

    public Climber() 
    {
        rightClimb = new CANSparkMax( RobotMap.RIGHT_CLIMBER_ID, MotorType.kBrushless );
        leftClimb = new CANSparkMax( RobotMap.LEFT_CLIMBER_ID, MotorType.kBrushless );

        rightClimb.restoreFactoryDefaults();
        leftClimb.restoreFactoryDefaults();

        rightClimb.setIdleMode( IdleMode.kBrake );
        leftClimb.setIdleMode( IdleMode.kBrake );

        rightClimb.setInverted( false );
        leftClimb.setInverted( true );

        rightClimberEncoder = rightClimb.getEncoder();
        leftClimberEncoder = leftClimb.getEncoder();

        resetClimberEncoders();

        climberSolenoid = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.CLIMBER_SLOENOID_CHANNEL );

        lockClimberSolenoid();

        rightClimbPIDController = rightClimb.getPIDController();

        rightClimbPIDController.setFeedbackDevice( rightClimberEncoder );

        // PID Settings
        rightClimbPIDController.setP( Constants.RIGHT_CLIMB_P );
        rightClimbPIDController.setI( Constants.RIGHT_CLIMB_I );
        rightClimbPIDController.setD( Constants.RIGHT_CLIMB_D );
        rightClimbPIDController.setIZone( Constants.RIGHT_CLIMB_Iz );
        rightClimbPIDController.setFF( Constants.RIGHT_CLIMB_FF );
        rightClimbPIDController.setOutputRange( Constants.RIGHT_CLIMB_MIN_OUTPUT , Constants.RIGHT_CLIMB_MAX_OUTPUT );

        leftClimbPIDController = leftClimb.getPIDController();

        leftClimbPIDController.setFeedbackDevice( leftClimberEncoder );

        // PID Settings
        leftClimbPIDController.setP( Constants.LEFT_CLIMB_P );
        leftClimbPIDController.setI( Constants.LEFT_CLIMB_I );
        leftClimbPIDController.setD( Constants.LEFT_CLIMB_D );
        leftClimbPIDController.setIZone( Constants.LEFT_CLIMB_Iz );
        leftClimbPIDController.setFF( Constants.LEFT_CLIMB_FF );
        leftClimbPIDController.setOutputRange( Constants.LEFT_CLIMB_MIN_OUTPUT , Constants.LEFT_CLIMB_MAX_OUTPUT );
    }

    public void climb( double power ) 
    {
        rightClimb.set( power );
        leftClimb.set( power );
    }

    public void climbAtVelocity( double velocity ) 
    {
        rightClimbPIDController.setReference( velocity, CANSparkMax.ControlType.kVelocity );
        leftClimbPIDController.setReference( velocity, CANSparkMax.ControlType.kVelocity );
        // rightClimbPIDController.setReference( rightTooFarAhead()? velocity / 3 : velocity, CANSparkMax.ControlType.kVelocity );
        // leftClimbPIDController.setReference( leftTooFarAhead()? velocity / 3 : velocity, CANSparkMax.ControlType.kVelocity );
    }

    public void stop() 
    {
        rightClimb.stopMotor();
        leftClimb.stopMotor();
    }

    public void resetClimberEncoders() 
    {
        rightClimberEncoder.setPosition( 0.0 );
        leftClimberEncoder.setPosition( 0.0 );
    }

    public double getLeftClimberPosition() 
    {
        return leftClimberEncoder.getPosition();
    }

    public double getRightClimberPosition() 
    {
        return rightClimberEncoder.getPosition();
    }

    public boolean get() 
    {
        return climberSolenoid.get();
    }

    public void toggleClimberSolenoid() 
    {
        climberSolenoid.toggle();
    }

    public void lockClimberSolenoid() 
    {
        climberSolenoid.set( Constants.CLIMBER_LOCKED );
    }

    public void unlockClimberSolenoid() 
    {
        climberSolenoid.set( Constants.CLIMBER_UNLOCKED );
    }

    // public boolean rightTooFarAhead() 
    // {
    //     return getRightClimberPosition() - getLeftClimberPosition() > EPSILON;
    // }

    // public boolean leftTooFarAhead() 
    // {
    //     return getLeftClimberPosition() - getRightClimberPosition() > EPSILON;
    // }
}
