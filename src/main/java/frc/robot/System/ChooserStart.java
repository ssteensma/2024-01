package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ChooserStart {

    public static final String[] kColor = {
        "Against wall",
        "Left side",
        "Center",
        "Right side"
    };

    public static final SendableChooser<String>
        startchooser = new SendableChooser<>();

    public static void Initialize() {
        startchooser.setDefaultOption( kColor[ 0], kColor[ 0] );
        startchooser.setDefaultOption( kColor[ 1], kColor[ 1] );
        startchooser.setDefaultOption( kColor[ 2], kColor[ 2] );
        startchooser.setDefaultOption( kColor[ 3], kColor[ 3] );

        Shuffle.AutoTab.add( "STARTING LOCATION", startchooser )
            .withPosition( 3, 0 )
            .withSize( 3, 2 );
    }

    public static void Periodic () {}

    public static String GetStart() { return startchooser.getSelected(); }
}
