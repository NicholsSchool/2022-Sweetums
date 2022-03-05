package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase 
{
    private CANSparkMax rightClimb;
    private CANSparkMax leftClimb;

    public Climber() 
    {
        rightClimb = new CANSparkMax( RobotMap.RIGHT_CLIBER_ID, MotorType.kBrushless );
        leftClimb = new CANSparkMax( RobotMap.LEFT_INTAKE_ID, MotorType.kBrushless );

        rightClimb.restoreFactoryDefaults();
        leftClimb.restoreFactoryDefaults();

        rightClimb.setIdleMode( IdleMode.kBrake );
        leftClimb.setIdleMode( IdleMode.kBrake );

        rightClimb.setInverted( false );
        leftClimb.setInverted( true );
    }

    public void move( double power ) 
    {
        rightClimb.set( power );
        leftClimb.set( power );
    }

    public void stop() 
    {
        rightClimb.stopMotor();
        leftClimb.stopMotor();
    }
}
