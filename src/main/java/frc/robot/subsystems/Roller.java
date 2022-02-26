package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Roller extends SubsystemBase 
{
    private CANSparkMax roller;

    public Roller() 
    {
        roller = new CANSparkMax( RobotMap.LEFT_INTAKE_ID, MotorType.kBrushless );

        roller.restoreFactoryDefaults();

        roller.setIdleMode( IdleMode.kBrake );
        
        roller.setInverted( true );
    }

    public void move( double speed ) 
    {
        roller.set( speed );
    }

    public void stop() 
    {
        roller.stopMotor();
    }
}