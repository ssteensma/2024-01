package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ChooserAuton {

    public static final String[] kPath = {
        "Do Nothing",               // 0
        "Wall Cross Line",          // 1
        "Shoot Only",               // 2

        "Ctr Shoot, Cross",         // 3
        "Lft Shoot, Cross",         // 4
        "Rgt Shoot, Cross",         // 5

        "Ctr Shoot, Cross, Grab",   // 6
        "Ctr Shoot Twice",          // 7

        "Unused 08",
        "Unused 09",
        "Unused 10",
        "Unused 11",
        "Unused 12",
        "Unused 13",
        "Unused 14",
        "Unused 15",
        "Unused 16",
    };

    public static final SendableChooser<String>
        autonchooser = new SendableChooser<>();
        // startchooser = new SendableChooser<>();

    public static void Initialize() {
        autonchooser.setDefaultOption( kPath[ 0], kPath[ 0] );
        autonchooser.setDefaultOption( kPath[ 1], kPath[ 1] );
        autonchooser.setDefaultOption( kPath[ 2], kPath[ 2] );
        autonchooser.setDefaultOption( kPath[ 3], kPath[ 3] );
        autonchooser.setDefaultOption( kPath[ 4], kPath[ 4] );
        autonchooser.setDefaultOption( kPath[ 5], kPath[ 5] );
        autonchooser.setDefaultOption( kPath[ 6], kPath[ 6] );
        autonchooser.setDefaultOption( kPath[ 7], kPath[ 7] );
        autonchooser.setDefaultOption( kPath[ 8], kPath[ 8] );
        autonchooser.setDefaultOption( kPath[ 9], kPath[ 9] );
        autonchooser.setDefaultOption( kPath[10], kPath[10] );
        autonchooser.setDefaultOption( kPath[11], kPath[11] );
        autonchooser.setDefaultOption( kPath[12], kPath[12] );
        autonchooser.setDefaultOption( kPath[13], kPath[13] );
        autonchooser.setDefaultOption( kPath[14], kPath[14] );
        autonchooser.setDefaultOption( kPath[15], kPath[15] );
        autonchooser.setDefaultOption( kPath[16], kPath[16] );

        Shuffle.CompTab.add( "Auton Chooser", autonchooser ).withPosition( 7, 0 ).withSize( 2, 2 );
    }

    public static void Periodic () {}

    public static String GetAuton() { return autonchooser.getSelected(); }
}
