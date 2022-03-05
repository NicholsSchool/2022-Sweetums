package frc.robot.util;

import edu.wpi.first.wpilibj2.command.button.Button;

public class DoubleButton extends Button
{
    private Button button1; 
    private Button button2;

    public DoubleButton( Button b1, Button b2 )
    {
        button1 = b1;
        button2 = b2;
    }

    @Override
    public boolean get() 
    {
        return button1.get() && button2.get();
    }
}