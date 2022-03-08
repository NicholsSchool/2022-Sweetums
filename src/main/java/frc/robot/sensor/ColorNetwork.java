package frc.robot.sensor;

import edu.wpi.first.wpilibj.TimedRobot;

import java.io.IOException;

import edu.wpi.first.networktables.*;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class ColorNetwork extends TimedRobot 
{
 
   private NetworkTableEntry RValue;
   private NetworkTableEntry GValue;
   private NetworkTableEntry BValue;
   private NetworkTable table;

   public void robotInit() 
   {
      //Get the default instance of NetworkTables that was created automatically
      //when your program starts
      NetworkTableInstance inst = NetworkTableInstance.getDefault();

      //Get the table within that instance that contains the data. There can
      //be as many tables as you like and exist to make it easier to organize
      //your data. In this case, it's a table called datatable.
      table = inst.getTable("RaspberryPi");

      //Get the entries within that table that correspond to the X and Y values
      //for some operation in your program.
      RValue = table.getEntry("R");
      GValue = table.getEntry("G");
      BValue = table.getEntry("B");
   }

   private double R = 0;
   private double G = 0;
   private double B = 0;

   public void teleopPeriodic() 
   {
      RValue.setDouble(R);
      GValue.setDouble(G);
      BValue.setDouble(B);
      RValue = table.getEntry("R");
      GValue = table.getEntry("G");
      BValue = table.getEntry("B");
   }
   public void Output() 
   {
      try
      
      {
      System.out.println(Runtime.getRuntime().exec( "python2.6 main.py" ));
      }
      catch( IOException ioException )
      {

      }
   }
}