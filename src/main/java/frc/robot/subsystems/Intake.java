package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase
{
    private CANSparkMax intake;
    private RelativeEncoder encoder;
    private SparkMaxPIDController pidController;

    private double down = 50.0;

    public Intake()
    {
        // Intake
        intake = new CANSparkMax( RobotMap.INTAKE_ID, MotorType.kBrushless );

        intake.restoreFactoryDefaults();

        intake.setIdleMode( IdleMode.kBrake );
        
        intake.setInverted( false );

        // Encoder
        encoder = intake.getEncoder();

        resetEncoder();

        // PID Controller
        pidController = intake.getPIDController();

        pidController.setFeedbackDevice( encoder );

        // PID Settings
        pidController.setP( Constants.INTAKE_P );
        pidController.setI( Constants.INTAKE_I );
        pidController.setD( Constants.INTAKE_D );
        pidController.setIZone( Constants.INTAKE_Iz );
        pidController.setFF( Constants.INTAKE_FF );
        pidController.setOutputRange( Constants.INTAKE_MIN_OUTPUT , Constants.INTAKE_MAX_OUTPUT );
    }

    public void set( double power ) 
    {
        intake.set( power );
    }

    public void move( double speed ) 
    {
        intake.set( speed );
    }

    public void stop() 
    {
        intake.stopMotor();
    }

    public double getPosition() 
    {
        return encoder.getPosition();
    }

    public void setPosition( double position ) 
    {
        encoder.setPosition( position );
    }

    public void resetEncoder()
    {
        setPosition( 0 );
    }

    public void resetDown() 
    {
        down = getPosition();
    }

    public double getDown() 
    {
        return down;
    }

    public void goToPosition( double position ) 
    {
        pidController.setReference( position, CANSparkMax.ControlType.kPosition );
    }
}