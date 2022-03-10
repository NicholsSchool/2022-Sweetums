package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Indexer extends SubsystemBase 
{
    private CANSparkMax indexer;

    public Indexer() 
    {
        indexer = new CANSparkMax( RobotMap.INDEXER_ID, MotorType.kBrushless );
        
        indexer.restoreFactoryDefaults();

        indexer.setIdleMode( IdleMode.kBrake );
        
        indexer.setInverted( false );
    }

    public void index() 
    {
        move( Constants.INDEXER_SPEED );
    }

    public void move( double speed ) 
    {
        indexer.set( speed );
    }

    public void stop() 
    {
        indexer.stopMotor();
    }
}
