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
    private double distance;
    private double power;

    /**
     * @param dist distance to travel
     * @param pow power to give motor
     */
    public EncoderDrive(double dist, double pow ) 
    {        
        addRequirements(RobotContainer.driveTrain);
        distance = dist;
        power = pow;
    }

    @Override
    public void initialize() 
    {
        RobotContainer.driveTrain.resetEncoder();
    }

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move( power, power );
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return distance <= Math.abs( RobotContainer.driveTrain.getEncoderValue() );
    }

}