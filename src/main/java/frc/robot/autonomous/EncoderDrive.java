/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class EncoderDrive extends CommandBase 
{
    private final double DISTANCE;
    private final double SPEED;

    /**
     * @param distance distance to travel
     * @param speed power to give motor
     */
    public EncoderDrive( double distance, double speed ) 
    {        
        addRequirements( RobotContainer.driveTrain );

        DISTANCE = distance;
        SPEED = speed;
    }

    @Override
    public void initialize() 
    {
        RobotContainer.driveTrain.resetEncoder();
    }

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move( DISTANCE > 0? SPEED : -SPEED, DISTANCE > 0? SPEED : -SPEED );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return DISTANCE < Math.abs( RobotContainer.driveTrain.getEncoderValue() );
    }

}