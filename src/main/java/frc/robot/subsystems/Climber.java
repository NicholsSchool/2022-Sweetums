package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase
{
    private CANSparkMax climberLeft;
    private CANSparkMax climberRight;

    public Climber() 
    {
        climberLeft = new CANSparkMax( RobotMap.CLIMBER_LEFT_ID, MotorType.kBrushless );
        climberRight = new CANSparkMax( RobotMap.CLIMBER_RIGHT_ID, MotorType.kBrushless );

        climberLeft.restoreFactoryDefaults();
        climberRight.restoreFactoryDefaults();

        climberLeft.setIdleMode( IdleMode.kCoast );
        climberRight.setIdleMode( IdleMode.kCoast );
        
        climberLeft.setInverted( true );
        climberRight.setInverted( false );
    }
    
    public void move( double speed ) 
    {
        climberLeft.set( speed );
        climberRight.set( speed );
    }

    public void stop() 
    {
        climberLeft.stopMotor();
        climberRight.stopMotor();
    }
}
