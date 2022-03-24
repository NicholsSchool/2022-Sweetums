package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase
{
    private WPI_TalonFX rFDrive;
    private WPI_TalonFX lFDrive;
    private WPI_TalonFX rBDrive;
    private WPI_TalonFX lBDrive;

    private MotorControllerGroup rightDrives;
    private MotorControllerGroup leftDrives;

    private DifferentialDrive diffDrive;

    private boolean ignoreCorrection = true;
    private boolean defenseMode = false;

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

        rightDrives = new MotorControllerGroup( rFDrive, rBDrive );
        leftDrives = new MotorControllerGroup( lFDrive, lBDrive );

        diffDrive = new DifferentialDrive( leftDrives, rightDrives );
        // diffDrive = new DifferentialDrive( lFDrive, rFDrive );

        // rBDrive.follow( lFDrive );
        // lBDrive.follow( rFDrive );

        rFDrive.setInverted( true );
        rBDrive.setInverted( true );
        lFDrive.setInverted( false );
        lBDrive.setInverted( false );

        // setToIgnoreCorrection( false );
    }

    public void move( double leftSpeed, double rightSpeed ) 
    {
        SmartDashboard.putNumber( "Left Stick Y", leftSpeed );
        SmartDashboard.putNumber( "Right Stick Y", rightSpeed );

        if( Math.abs( rightSpeed - leftSpeed ) < Constants.JOYSTICK_EPSILON && // if we're close enough...
            rightSpeed * leftSpeed > 0 &&  // and on the same side...
            !ignoreCorrection ) // and we're not ignoring correction...
        {
            diffDrive.tankDrive( defenseMode? -rightSpeed : rightSpeed, defenseMode? -rightSpeed : rightSpeed ); // correct.

            SmartDashboard.putNumber( "leftSpeed", rightSpeed ); 
            SmartDashboard.putNumber( "rightSpeed", rightSpeed );
        }
        else // otherwise...
        {
            diffDrive.tankDrive( defenseMode? -leftSpeed : leftSpeed, defenseMode? -rightSpeed : rightSpeed ); // don't.

            SmartDashboard.putNumber( "leftSpeed", leftSpeed );
            SmartDashboard.putNumber( "rightSpeed", rightSpeed );
        }
    }

    public void toggleignoringCorrection() 
    {
        ignoreCorrection = !ignoreCorrection;
    }

    public void toggleMode() 
    {
        defenseMode = !defenseMode;
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

    public double getFrontRightEncoderValue()
    {
        return rFDrive.getSelectedSensorPosition();
    }

    public double getFrontLeftEncoderValue() 
    {
        return lFDrive.getSelectedSensorPosition();
    }

    public void resetEncoder()
    {
        rFDrive.setSelectedSensorPosition(0);
        rBDrive.setSelectedSensorPosition(0);
        lFDrive.setSelectedSensorPosition(0);
        lBDrive.setSelectedSensorPosition(0);
    }
}
