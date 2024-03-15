package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ChooserAuton {

    public static final String[] kPath = {
        "0",
        "1",
        "A",
        "B",
        "C",
        "D",
        "E",
        // "Long Shot"
   };

    public static final SendableChooser<String>
        autonchooser = new SendableChooser<>();

    public static void Initialize() {

        for ( int i = 0; i <= 6; i++ ) {
            autonchooser.setDefaultOption( kPath[ i ], kPath[ i ] );
        }

        Shuffle.AutoTab.add( "AUTONOMOUS ROUTINE", autonchooser )
            .withPosition( 6, 0 )
            .withSize( 3, 2 );
    }

    public static void Periodic () {}

    public static String GetAuton() { return autonchooser.getSelected(); }
}
