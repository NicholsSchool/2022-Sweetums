// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    // DriveTrain Power
    public static final double DRIVE_TRAIN_POWER = 0.75;

    // Gears 
    public static final boolean HIGH_GEAR = false;
    public static final boolean LOW_GEAR = !HIGH_GEAR;

    // Climb Power
    public static final double CLIMBER_CLIMB_VELOCITY = 3000.0; 

    // Climber PID
    public static final double RIGHT_CLIMB_P = 0.1;
    public static final double RIGHT_CLIMB_I = 1e-4;
    public static final double RIGHT_CLIMB_D = 0.1;
    public static final double RIGHT_CLIMB_Iz = 0;
    public static final double RIGHT_CLIMB_FF = 0;
    public static final double RIGHT_CLIMB_MAX_OUTPUT = 0.5;
    public static final double RIGHT_CLIMB_MIN_OUTPUT = -0.5;

    public static final double LEFT_CLIMB_P = 0.1;
    public static final double LEFT_CLIMB_I = 1e-4;
    public static final double LEFT_CLIMB_D = 0.1;
    public static final double LEFT_CLIMB_Iz = 0;
    public static final double LEFT_CLIMB_FF = 0;
    public static final double LEFT_CLIMB_MAX_OUTPUT = 0.5;
    public static final double LEFT_CLIMB_MIN_OUTPUT = -0.5;

    // Roller Power
    public static final double ROLLER_SPEED = 0.9;

    // Shooter Power
    public static final double SHOOTER_SPEED = 1.0;
    public static final double CLOSE_ENOUGH = 250.0;

    // Shooter Vs
    public static final double HIGH_GOAL_VELOCITY = 12300.0;
    public static final double LOW_GOAL_VELOCITY = 7000.0;
    public static final double THROW_AWAY_VELOCITY = 12000.0;
    
    // Indexer Power
    public static final double INDEXER_SPEED = 1.0;

    // Intake Power
    public static final double INTAKE_GO_DOWN_POWER = 0.5;

    public static final double INTAKE_TUCK_POWER = -0.1;

    // Intake Positions
    public static final double INTAKE_RANGE = 50.0;

    // Intake PID Control Loop Constants
    public static final double INTAKE_P = 0.1;
    public static final double INTAKE_I = 0;
    public static final double INTAKE_D = 0.3; // 0.1
    public static final double INTAKE_Iz = 0;
    public static final double INTAKE_FF = 0;
    public static final double INTAKE_MAX_OUTPUT = 0.33;
    public static final double INTAKE_MIN_OUTPUT = -0.40;

    // Shooter PID Control Loop Constants
    public static final double SHOOTER_F = 0.057;
    public static final double SHOOTER_P = 0.14;
    public static final double SHOOTER_I = 0;
    public static final double SHOOTER_D = 0;
    public static final double SHOOTER_RAMP_TIME = 1;

    // Default Solenoid Positions
    public static final boolean CLIMBER_LOCKED = false;
    public static final boolean CLIMBER_UNLOCKED = !CLIMBER_LOCKED;

    public static final boolean HOOKS_IN = true;
    public static final boolean HOOKS_OUT = !HOOKS_IN;

    public static final boolean SLIDER_LOCKED = false;
    public static final boolean SLIDER_UNLOCKED = !SLIDER_LOCKED;
    ;
}