package frc.robot.subsystems;

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
        
        shooter.setInverted( false );
        
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

    public void setVelocity( char buttonPressed )
    {
        switch( buttonPressed )
        {
            case 'Y':
                Constants.shooterVelocity = Constants.HIGH_GOAL_V;
                break;
            case 'X':
                Constants.shooterVelocity = Constants.LOW_GOAL_V;
                break;
            case 'A':
                Constants.shooterVelocity = Constants.THROW_AWAY_V;
        }
    }
}
