package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
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
        rFDrive = new WPI_TalonFX( RobotMap.RIGHT_FRONT_DRIVE_ID );
        rBDrive = new WPI_TalonFX( RobotMap.RIGHT_BACK_DRIVE_ID );
        lFDrive = new WPI_TalonFX( RobotMap.LEFT_FRONT_DRIVE_ID );
        lBDrive = new WPI_TalonFX( RobotMap.LEFT_BACK_DRIVE_ID );

        rFDrive.configFactoryDefault();
        rBDrive.configFactoryDefault();
        lFDrive.configFactoryDefault();
        lBDrive.configFactoryDefault();

        diffDrive = new DifferentialDrive( lFDrive, rFDrive );

        rBDrive.follow( rFDrive );
        lBDrive.follow( lFDrive );

        rFDrive.setInverted( true );
        rBDrive.setInverted( true );
        lFDrive.setInverted( false );
        lBDrive.setInverted( false );

        brake();
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

    public void brake() 
    {
        rFDrive.setNeutralMode( NeutralMode.Brake );
        rBDrive.setNeutralMode( NeutralMode.Brake );
        lFDrive.setNeutralMode( NeutralMode.Brake );
        lBDrive.setNeutralMode( NeutralMode.Brake );
    }

    public void coast() 
    {
        rFDrive.setNeutralMode( NeutralMode.Coast );
        rBDrive.setNeutralMode( NeutralMode.Coast );
        lFDrive.setNeutralMode( NeutralMode.Coast );
        lBDrive.setNeutralMode( NeutralMode.Coast );
    }

    public double getEncoderValue()
    {
        return rFDrive.getSelectedSensorPosition();
    }

    public void resetEncoder()
    {
        rFDrive.setSelectedSensorPosition(0);
        rBDrive.setSelectedSensorPosition(0);
        lFDrive.setSelectedSensorPosition(0);
        lBDrive.setSelectedSensorPosition(0);
    }
}
