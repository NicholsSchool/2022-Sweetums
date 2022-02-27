package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

public class Shifter extends SubsystemBase 
{
    private Solenoid shifter;

    public Shifter()
    {
        shifter = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.SHIFTER_SOLENOID_CHANNEL );
    }

    public boolean get() 
    {
        return shifter.get();
    }
    
    public void toggle() 
    {
        shifter.set( !shifter.get() );
    }
}
