package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TimeDrive extends CommandBase 
{
    private final long START_TIME;
    private final double SPEED;
    
    public TimeDrive( int time, double speed ) 
    {
        addRequirements( RobotContainer.driveTrain );

        START_TIME = System.currentTimeMillis();
        SPEED = speed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move( SPEED, SPEED );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
