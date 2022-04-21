package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
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

    private boolean ignoreCorrection = false;

    public static enum Mode 
    {
        NORMAL,
        DEFENSE;
    }

    private Mode mode;

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
        if( Math.abs( rightSpeed - leftSpeed ) < Constants.JOYSTICKS_CLOSE_ENOUGH && // if we're close enough...
            Math.abs( rightSpeed ) > Constants.JOYSTICK_DRIFT_THRESHOLD && Math.abs( leftSpeed ) > Constants.JOYSTICK_DRIFT_THRESHOLD &&
            rightSpeed * leftSpeed > 0 &&  // and on the same side...
            !ignoreCorrection ) // and we're not ignoring correction...
        {
            leftSpeed = rightSpeed;
            SmartDashboard.putBoolean( "BEN YOU ARE BEING CORRECTED", true );
        }
        else // otherwise...
            SmartDashboard.putBoolean( "BEN YOU ARE BEING CORRECTED", false );
        
        diffDrive.tankDrive( mode == Mode.DEFENSE? -rightSpeed : leftSpeed, 
                             mode == Mode.DEFENSE? -leftSpeed : rightSpeed ); // do this, i guess
    }

    public void toggleIgnoringCorrection() 
    {
        ignoreCorrection = !ignoreCorrection;
    }

    public void toggleMode() 
    {
        mode = mode == Mode.NORMAL? Mode.DEFENSE : Mode.NORMAL;
        SmartDashboard.putBoolean( "DEFENSE MODE", mode == Mode.DEFENSE );
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
