package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Piston extends SubsystemBase 
{
    private Solenoid piston;

    public Piston()
    {
        piston = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.PISTON_SOLENOID_CHANNEL );
        
        piston.set( false );
    }

    public void activate()
    {
        piston.set( true );
    }

    public void deactivate()
    {
        piston.set( false );
    }
}