package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase
{
    private WPI_TalonFX rFDrive;
    private WPI_TalonFX lFDrive;
    private WPI_TalonFX rBDrive;
    private WPI_TalonFX lBDrive;

    private DifferentialDrive diffDrive;

    public DriveTrain() 
    {
        rFDrive = new WPI_TalonFX( RobotMap.FRONT_RIGHT_DRIVE_ID );
        rBDrive = new WPI_TalonFX( RobotMap.BACK_RIGHT_DRIVE_ID );
        lFDrive = new WPI_TalonFX( RobotMap.FRONT_LEFT_DRIVE_ID );
        lBDrive = new WPI_TalonFX( RobotMap.BACK_LEFT_DRIVE_ID );

        rFDrive.configFactoryDefault();
        rBDrive.configFactoryDefault();
        lFDrive.configFactoryDefault();
        lBDrive.configFactoryDefault();

        diffDrive = new DifferentialDrive( lFDrive, rFDrive );

        rBDrive.follow( rFDrive );
        lBDrive.follow( lFDrive );

        rFDrive.setInverted( false );
        rBDrive.setInverted( false );
        lFDrive.setInverted( false );
        lBDrive.setInverted( false );
    }

    public void move( double leftSpeed, double rightSpeed ) 
    {
        diffDrive.tankDrive( leftSpeed, rightSpeed );
    }

    public void stop() 
    {
        rFDrive.stopMotor();
        rBDrive.stopMotor();
        lFDrive.stopMotor();
        lBDrive.stopMotor();
    }
}
