package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {

    public static final String[] pStart = {
        "Red Wall",
        "Red Left",
        "Red Center",
        "Red Right",
        "Blue Wall",
        "Blue Left",
        "Blue Center",
        "Blue Right"
    };

    public static final String[] kPath = {
        "Do Nothing",
        "Path-01",
        "Path-02",
        "Path-03",
        "Path-04",
        "Path-05",
        "Path-06",
        "Path-07",
        "Path-08",
        "Path-09"
    };

    public static final SendableChooser<String>
        chooser = new SendableChooser<>();

    public static void Initialize() {
        chooser.setDefaultOption( "Do Nothing", kPath[0] );
        chooser.setDefaultOption( "Path 01",    kPath[1] );
        chooser.setDefaultOption( "Path 02",    kPath[2] );
        chooser.setDefaultOption( "Path 03",    kPath[3] );
        chooser.setDefaultOption( "Path 04",    kPath[4] );
        chooser.setDefaultOption( "Path 05",    kPath[5] );
        chooser.setDefaultOption( "Path 06",    kPath[6] );
        chooser.setDefaultOption( "Path 07",    kPath[7] );
        chooser.setDefaultOption( "Path 08",    kPath[8] );
        chooser.setDefaultOption( "Path 09",    kPath[9] );
        SmartDashboard.putData  ( "PATH",       chooser  );
    }

    public static void Periodic () {}

    public static String GetSelected() {
        return chooser.getSelected();
    }

}
