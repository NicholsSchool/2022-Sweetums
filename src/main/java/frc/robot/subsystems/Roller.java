package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Roller extends SubsystemBase 
{  
    private CANSparkMax intake;

    public Roller() 
    {
        intake = new CANSparkMax( RobotMap.INTAKE_ROLLER_ID, MotorType.kBrushless );

        intake.restoreFactoryDefaults();

        intake.setIdleMode( IdleMode.kCoast );
        
        intake.setInverted( false );
    }

    public void move( double speed ) 
    {
        intake.set( speed );
    }

    public void stop() 
    {
        intake.stopMotor();
    }
}
