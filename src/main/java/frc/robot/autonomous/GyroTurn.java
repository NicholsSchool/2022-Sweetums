package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class GyroTurn extends CommandBase
{
    private final double ANGLE;
    private final double SPEED;

    public GyroTurn( double angle, double speed ) 
    {
        addRequirements( RobotContainer.driveTrain );

        ANGLE = angle;

        SPEED = speed;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        double angleAt = RobotContainer.navX.getAngle();

        RobotContainer.driveTrain.move( ANGLE - angleAt > 0? -SPEED : SPEED, ANGLE - angleAt > 0? SPEED : -SPEED );
    }

    @Override
    public void end(boolean interrupted) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return RobotContainer.navX.atAngle( ANGLE ); 
    }
}
