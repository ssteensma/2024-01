package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class ChooserColor {

    public static final String[] kColor = {
        "Red",
        "Blue"
    };

    public static final SendableChooser<String>
        colorchooser = new SendableChooser<>();

    public static void Initialize() {
        colorchooser.setDefaultOption( kColor[ 0], kColor[ 0] );
        colorchooser.setDefaultOption( kColor[ 1], kColor[ 1] );

        Shuffle.CompTab.add( "Color Chooser", colorchooser )
            .withPosition( 7, 2 )
            .withSize( 2, 2 );
    }

    public static void Periodic () {}

    public static String GetColor() { return colorchooser.getSelected(); }
}
