package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class PIDClimb extends CommandBase 
{
    private double LEFT_POSITION;
    private double RIGHT_POSITION;

    public PIDClimb( double leftPosition, double rightPosition ) 
    {
        addRequirements( RobotContainer.climber );

        LEFT_POSITION = leftPosition;
        RIGHT_POSITION = rightPosition;
    }    

    @Override
    public void initialize() 
    {
        RobotContainer.climber.resetClimberEncoders();

        RobotContainer.climber.climbToPositions( LEFT_POSITION, RIGHT_POSITION );
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) 
    {
        RobotContainer.climber.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;    
    }
}