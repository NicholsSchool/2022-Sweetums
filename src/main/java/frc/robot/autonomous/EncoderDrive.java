package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class EncoderDrive extends CommandBase 
{
    private final double RIGHT_DISTANCE;
    private final double LEFT_DISTANCE;
    private final double SPEED;

    public EncoderDrive( double leftDistance, double rightDistance, double speed ) 
    {        
        addRequirements( RobotContainer.driveTrain );
        RIGHT_DISTANCE = rightDistance * Constants.TICKS_PER_INCH; // Can be + or -, + for going forward, - for going backward
        LEFT_DISTANCE = leftDistance * Constants.TICKS_PER_INCH;
        SPEED = Math.abs( speed );
    }

    @Override
    public void initialize() 
    {
        RobotContainer.driveTrain.resetEncoder();
    }

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move( LEFT_DISTANCE > 0? SPEED : -SPEED, RIGHT_DISTANCE > 0? SPEED : -SPEED );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return Math.abs( RobotContainer.driveTrain.getFrontRightEncoderValue() - RIGHT_DISTANCE ) < Constants.CLOSE_ENOUGH_DISTANCE &&
               Math.abs( RobotContainer.driveTrain.getFrontLeftEncoderValue() - LEFT_DISTANCE ) < Constants.CLOSE_ENOUGH_DISTANCE;
    }

}