package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase 
{
    private CANSparkMax rightClimb;
    private CANSparkMax leftClimb;

    private RelativeEncoder rightClimbEncoder;
    private RelativeEncoder leftClimbEncoder;

    private SparkMaxPIDController rightClimbPIDController;
    private SparkMaxPIDController leftClimbPIDController;

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

        rightClimbEncoder = rightClimb.getEncoder();
        leftClimbEncoder = leftClimb.getEncoder();

        rightClimbPIDController = rightClimb.getPIDController();

        rightClimbPIDController.setFeedbackDevice( rightClimbEncoder );

        // PID Settings
        rightClimbPIDController.setP( Constants.RIGHT_CLIMB_P );
        rightClimbPIDController.setI( Constants.RIGHT_CLIMB_I );
        rightClimbPIDController.setD( Constants.RIGHT_CLIMB_D );
        rightClimbPIDController.setIZone( Constants.RIGHT_CLIMB_Iz );
        rightClimbPIDController.setFF( Constants.RIGHT_CLIMB_FF );
        rightClimbPIDController.setOutputRange( Constants.RIGHT_CLIMB_MIN_OUTPUT , Constants.RIGHT_CLIMB_MAX_OUTPUT );

        leftClimbPIDController = leftClimb.getPIDController();

        leftClimbPIDController.setFeedbackDevice( leftClimbEncoder );

        // PID Settings
        leftClimbPIDController.setP( Constants.LEFT_CLIMB_P );
        leftClimbPIDController.setI( Constants.LEFT_CLIMB_I );
        leftClimbPIDController.setD( Constants.LEFT_CLIMB_D );
        leftClimbPIDController.setIZone( Constants.LEFT_CLIMB_Iz );
        leftClimbPIDController.setFF( Constants.LEFT_CLIMB_FF );
        leftClimbPIDController.setOutputRange( Constants.LEFT_CLIMB_MIN_OUTPUT , Constants.LEFT_CLIMB_MAX_OUTPUT );
    }

    public void climbAtVelocity( double velocity ) 
    {
        rightClimbPIDController.setReference( velocity, CANSparkMax.ControlType.kVelocity );
        leftClimbPIDController.setReference( velocity, CANSparkMax.ControlType.kVelocity );
    }

    public void stop() 
    {
        rightClimb.stopMotor();
        leftClimb.stopMotor();
    }

    public double getLeftClimberPosition() 
    {
        return leftClimbEncoder.getPosition();
    }

    public double getRightClimberPosition() 
    {
        return rightClimbEncoder.getPosition();
    }
}
