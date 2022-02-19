package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase
{
    private WPI_TalonFX fRDrive;
    private WPI_TalonFX fLDrive;
    private WPI_TalonFX bRDrive;
    private WPI_TalonFX bLDrive;

    private DifferentialDrive diffDrive;

    public DriveTrain() 
    {
        fRDrive = new WPI_TalonFX( RobotMap.FRONT_RIGHT_DRIVE_ID );
        fLDrive = new WPI_TalonFX( RobotMap.FRONT_LEFT_DRIVE_ID );
        bRDrive = new WPI_TalonFX( RobotMap.BACK_RIGHT_DRIVE_ID );
        bLDrive = new WPI_TalonFX( RobotMap.BACK_LEFT_DRIVE_ID );

        fRDrive.configFactoryDefault();
        fLDrive.configFactoryDefault();
        bRDrive.configFactoryDefault();
        bLDrive.configFactoryDefault();

        diffDrive = new DifferentialDrive( fLDrive, fRDrive );

        bRDrive.follow( fRDrive );
        bLDrive.follow( fLDrive );

        fRDrive.setInverted( false );
        fLDrive.setInverted( false );
        bRDrive.setInverted( false );
        bLDrive.setInverted( false );
    }

    public void move( double leftSpeed, double rightSpeed ) 
    {
        diffDrive.tankDrive( leftSpeed, rightSpeed );
    }

    public void stop() 
    {
        fRDrive.stopMotor();
        fLDrive.stopMotor();
        bRDrive.stopMotor();
        bLDrive.stopMotor();
    }
}
