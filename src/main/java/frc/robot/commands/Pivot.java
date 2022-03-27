package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Pivot extends CommandBase
{
    private final Side SIDE;
    private final double ANGLE;
    private final double SPEED;

    public static enum Side 
    {
        RIGHT,
        LEFT;
    }

    public Pivot( Side side, double angle, double speed ) 
    {
        addRequirements( RobotContainer.driveTrain );

        SIDE = side;
        ANGLE = angle;
        SPEED = speed;
    }

    @Override
    public void initialize() 
    {
        RobotContainer.navX.reset();
    }

    @Override
    public void execute() 
    {
        switch( SIDE ) 
        {
            case RIGHT:
                RobotContainer.driveTrain.move( 0, ANGLE > 0? SPEED : -SPEED );
                break;
            case LEFT:
                RobotContainer.driveTrain.move( ANGLE > 0? -SPEED : SPEED, 0 );
        }
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return RobotContainer.navX.atAngle( ANGLE );
    }
}
