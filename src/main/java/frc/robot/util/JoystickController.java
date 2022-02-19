package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class JoystickController extends Joystick
 {
    public JoystickController(int port)
    {
        super(port);
        b1 = new JoystickButton(this, 1);
        b2 = new JoystickButton(this, 2);
        b3 = new JoystickButton(this, 3);
        b4 = new JoystickButton(this, 4);
        b5 = new JoystickButton(this, 5);
        b6 = new JoystickButton(this, 6);
        b7 = new JoystickButton(this, 7);
        b8 = new JoystickButton(this, 8);
        b9 = new JoystickButton(this, 9);
        b10 = new JoystickButton(this, 10);
        b11 = new JoystickButton(this, 11);
        b12 = new JoystickButton(this, 12);
    }


    public JoystickButton b1;
	public JoystickButton b2;
	public JoystickButton b3;
	public JoystickButton b4; 
	public JoystickButton b5; 
	public JoystickButton b6;
	public JoystickButton b7;
	public JoystickButton b8;
	public JoystickButton b9;
    public JoystickButton b10; 
    public JoystickButton b11;
    public JoystickButton b12;
}