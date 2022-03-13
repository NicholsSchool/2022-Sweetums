package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class PIDClimb extends CommandBase 
{
    private double leftPosition;
    private double rightPosition;

    public PIDClimb( double lP, double rP ) 
    {
        addRequirements( RobotContainer.climber );

        leftPosition = lP;
        rightPosition = rP;
    }    

    @Override
    public void initialize() 
    {
        RobotContainer.climber.resetClimberEncoders();

        RobotContainer.climber.climbToPositions( leftPosition, rightPosition );
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