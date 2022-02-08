package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is used to instantiate and retrieve values from all buttons, triggers, and pov inputs of
 * a Xbox Controller
 */
public class XboxController extends Joystick {

    public JoystickButton a, b, x, y, lBumper, rBumper, select, start, lStick, rStick;
    public POVButton dpadUp, dpadDown, dpadLeft, dpadRight;
    public Trigger lTrigger, rTrigger;

    /**
     * Creates a new XboxController instance
     * @param port the id of the port the controller is plugged into
     */
	public XboxController(int port) {
        super(port);

        a = new JoystickButton(this, 1);
        b = new JoystickButton(this, 2);
        x = new JoystickButton(this, 3);
        y = new JoystickButton(this, 4);
        lBumper = new JoystickButton(this, 5);
        rBumper = new JoystickButton(this, 6);
        select = new JoystickButton(this, 7);
        start = new JoystickButton(this, 8);
        lStick = new JoystickButton(this, 9);
        rStick= new JoystickButton(this, 10);
        dpadUp = new POVButton(this, 0);
        dpadDown = new POVButton(this, 180);
        dpadLeft = new POVButton(this, 270);
        dpadRight = new POVButton(this, 90);
        lTrigger = new Trigger(this, 2);
        rTrigger = new Trigger(this, 3);

    }

    public double getLeftX() {

        return getRawAxis(0);
    }

    public double getLeftY() {

        return -getRawAxis(1);
    }

    public double getLeftTrigger() {

        return getRawAxis(2);
    }

    public double getRightTrigger() {

        return getRawAxis(3);
    }

    public double getRightX() {

        return getRawAxis(4);
    }

    public double getRightY() {

        return -getRawAxis(5);
    }
}