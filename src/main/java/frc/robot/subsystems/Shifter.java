package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shifter extends SubsystemBase {

    private Solenoid shifter;

    public Shifter() {
        shifter = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.SHIFTER_SOLENOID_CHANNEL);
        // Assuming high gear by default is true.
        shifter.set(true);
    }

    public void highGear() {
        shifter.set(false);
        // Slowed down high gear because driver at Ruckus reported issues controling robot.
        RobotMap.GOVERNOR = RobotMap.GOVERNOR_SLOW;
    }

    public void lowGear()
     {
        shifter.set(true);
        RobotMap.GOVERNOR = RobotMap.GOVERNOR_FAST;
    }
}
