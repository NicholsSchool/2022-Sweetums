package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase
{
    private WPI_TalonFX shooter;

    public Shooter() 
    {
        shooter = new WPI_TalonFX( RobotMap.SHOOTER_ID );
        
        shooter.configFactoryDefault();
        shooter.configSelectedFeedbackSensor( FeedbackDevice.IntegratedSensor );
        shooter.config_kF(0, Constants.SHOOTER_F);
        shooter.config_kP(0, Constants.SHOOTER_P);
        shooter.config_kI(0, Constants.SHOOTER_I);
        shooter.config_kD(0, Constants.SHOOTER_D);
        shooter.configOpenloopRamp(Constants.SHOOTER_RAMP_TIME);
        shooter.configClosedloopRamp(Constants.SHOOTER_RAMP_TIME);

        shooter.setInverted( true );
        
        shooter.setNeutralMode( NeutralMode.Coast );
    }
    
    public void move( double speed ) 
    {
        shooter.set( speed );
    }
    
    public void stop() 
    {
        shooter.stopMotor();
    }
    
    public double getPosition() 
    {
        return shooter.getSelectedSensorPosition();
    }

    public double getVelocity() 
    {
        return shooter.getSelectedSensorVelocity();
    }

    public void setVelocity( double velocity ) 
    {
        shooter.set( ControlMode.Velocity, velocity );
    }
}
