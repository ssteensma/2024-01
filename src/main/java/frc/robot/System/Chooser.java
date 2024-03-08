package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {

    // public static final String[] kStart = {
    //     "Red Wal",
    //     "Red Lft",
    //     "Red Ctr",
    //     "Red Rg",
    //     "Blu Wal",
    //     "Blu Lft",
    //     "Blu Ctr",
    //     "Blu Rgt"
    // };

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
        autonchooser = new SendableChooser<>();
        // startchooser = new SendableChooser<>();

    public static void Initialize() {
        autonchooser.setDefaultOption( "Do Nothing", kPath[0] );
        autonchooser.setDefaultOption( "Path 01",    kPath[1] );
        autonchooser.setDefaultOption( "Path 02",    kPath[2] );
        autonchooser.setDefaultOption( "Path 03",    kPath[3] );
        autonchooser.setDefaultOption( "Path 04",    kPath[4] );
        // autonchooser.setDefaultOption( "Path 05",    kPath[5] );
        // autonchooser.setDefaultOption( "Path 06",    kPath[6] );
        // autonchooser.setDefaultOption( "Path 07",    kPath[7] );
        // autonchooser.setDefaultOption( "Path 08",    kPath[8] );
        // autonchooser.setDefaultOption( "Path 09",    kPath[9] );
        SmartDashboard.putData( "PATH", autonchooser );

        // startchooser.setDefaultOption( "Red Wal", kStart[0] );
        // startchooser.setDefaultOption( "Red Lft", kStart[1] );
        // startchooser.setDefaultOption( "Red Ctr", kStart[2] );
        // startchooser.setDefaultOption( "Red Rgt", kStart[3] );
        // startchooser.setDefaultOption( "Blu Wal", kStart[4] );
        // startchooser.setDefaultOption( "Blu Lft", kStart[5] );
        // startchooser.setDefaultOption( "Blu Ctr", kStart[6] );
        // startchooser.setDefaultOption( "Blu Rgt", kStart[7] );
        // SmartDashboard.putData( "START", startchooser );
    }

    public static void Periodic () {}

    public static String GetAuton() { return autonchooser.getSelected(); }
    // public static String GetStart() { return startchooser.getSelected(); }
}
