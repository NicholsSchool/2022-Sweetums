// package frc.robot.autonomous;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.RobotContainer;

// public class AutonomousDrive extends CommandBase 
// {
//     private long startTime = System.currentTimeMillis() / 1000;

//     private double distance;

//     public AutonomousDrive( double dist ) 
//     {
//         distance = dist;
//     }

//     @Override
//     public void initialize() {}

//     @Override
//     public void execute() 
//     {
//         RobotContainer.climber.climbAtVelocity( Constants.CLIMBER_CLIMB_VELOCITY );
//     }

//     @Override
//     public void end( boolean interrupted ) 
//     {
//         RobotContainer.climber.stop();
//     }

//     @Override
//     public boolean isFinished() 
//     {
//         return false;
//     }
// }
