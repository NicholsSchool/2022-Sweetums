package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoPath {

    public static CommandBase getCommand()
    {
        return new BBDrive( 36, .5 ).withTimeout( 5 ).andThen( new BBDrive( -36, 0.5).withTimeout( 5 ) );
    
    }
    
}
