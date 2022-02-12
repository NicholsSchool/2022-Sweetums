package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase
{
    private CANSparkMax climberLeft;
    private CANSparkMax climberRight;

    private DifferentialDrive diffDrive;

    public Climber() 
    {
        climberLeft = new CANSparkMax( RobotMap.CLIMBER_LEFT_ID, MotorType.kBrushless );
        climberRight = new CANSparkMax( RobotMap.CLIMBER_RIGHT_ID, MotorType.kBrushless );

        climberLeft.restoreFactoryDefaults();
        climberRight.restoreFactoryDefaults();

        diffDrive = new DifferentialDrive( climberLeft, climberRight );

        climberLeft.follow( climberRight );

        climberLeft.setIdleMode( IdleMode.kCoast );
        climberRight.setIdleMode( IdleMode.kCoast );
        
        climberLeft.setInverted( false );
        climberRight.setInverted( false );
    }
    
    public void move( double leftSpeed, double rightSpeed ) 
    {
        diffDrive.tankDrive( leftSpeed, rightSpeed );
    }

    public void stop() 
    {
        climberLeft.stopMotor();
        climberRight.stopMotor();
    }
}
