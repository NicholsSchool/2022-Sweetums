package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase
{
    private CANSparkMax intake;
    private RelativeEncoder encoder;
    private SparkMaxPIDController pidController;

    public Intake() 
    {
        intake = new CANSparkMax( RobotMap.RIGHT_INTAKE_ID, MotorType.kBrushless );

        intake.restoreFactoryDefaults();

        intake.setIdleMode( IdleMode.kBrake );
        
        intake.setInverted( false );

        encoder = intake.getEncoder();

        pidController = intake.getPIDController();

        pidController.setFeedbackDevice( encoder );

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

        Robot.state.put( "Intake Speed", String.format( "%1.2f", speed ) );
        Robot.state.put( "Encoder Position", String.format( "%1.2f", getPosition() ) );
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
