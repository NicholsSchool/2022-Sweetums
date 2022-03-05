package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoPath {

    public static CommandBase getCommand()
    {
        return new BBDrive( 200, .5 );
    
    }
    
}
