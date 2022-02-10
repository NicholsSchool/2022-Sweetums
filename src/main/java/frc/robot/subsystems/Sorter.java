package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Sorter extends SubsystemBase 
{
    private CANSparkMax sorter;

    public Sorter() 
    {
        sorter = new CANSparkMax( RobotMap.SORTER_ID, MotorType.kBrushless );

        sorter.restoreFactoryDefaults();

        sorter.setIdleMode( IdleMode.kCoast );
        
        sorter.setInverted( false );
    }

    public void move( double speed ) 
    {
        sorter.set( speed );
    }

    public void stop() 
    {
        sorter.stopMotor();
    }
}
