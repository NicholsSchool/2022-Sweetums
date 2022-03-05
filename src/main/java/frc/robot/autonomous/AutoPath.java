package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoPath {

    public static CommandBase getCommand()
    {
        return new BBDrive( 80, .5 ).withTimeout( 5 ).andThen( new AutoShoot().withTimeout( 2 ).andThen( new PIDDrive( -100 ) ) );
    
    }
    
}
