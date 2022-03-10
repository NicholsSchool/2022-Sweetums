package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TimeDrive extends CommandBase 
{
    private final long START_TIME;
    private final long TIME_TO_TAKE;

    private final double POWER;
    
    public TimeDrive( int t, double power ) 
    {
        addRequirements( RobotContainer.driveTrain );

        START_TIME  = System.currentTimeMillis() / 1000;
        TIME_TO_TAKE = t;

        POWER = power;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move( POWER, POWER );
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
        // return ( System.currentTimeMillis() / 1000 ) - START_TIME > TIME_TO_TAKE;
    }
}
