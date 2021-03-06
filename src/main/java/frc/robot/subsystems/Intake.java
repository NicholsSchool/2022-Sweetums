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

    public Intake() 
    {
        // Intake
        intake = new CANSparkMax( RobotMap.RIGHT_INTAKE_ID, MotorType.kBrushless );

        intake.restoreFactoryDefaults();

        intake.setIdleMode( IdleMode.kBrake );
        
        intake.setInverted( false );

        // Encoder
        encoder = intake.getEncoder();

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

    public void move( double speed ) 
    {
        intake.set( speed );
    }

    public void stop() 
    {
        intake.stopMotor();
    }

    public void goToPosition( double position ) 
    {
        pidController.setReference( position, CANSparkMax.ControlType.kPosition );
    }

    public double getPosition() 
    {
        return encoder.getPosition();
    }

    public void zeroEncoder() 
    {
        encoder.setPosition( 0 );
    }
}
