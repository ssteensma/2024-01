package frc.robot.System;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class Navigation {
    
    public static ADXRS450_Gyro
        NavX = new ADXRS450_Gyro();

    public static void Initialize() {
        NavX.calibrate();

        Shuffle.CompTab.add( NavX )
            .withPosition( 5, 2 )
            .withSize( 3, 3 )
            .withWidget( BuiltInWidgets.kGyro );
    }

    public static void Periodic() {}

    public static double GetDirection() { 
        return ( GetYaw() + 360 ) % 360;
    }

    public static void Calibrate() { NavX.calibrate(); }
    public static void Reset    () { NavX.reset    (); }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

    // public static double GetNavigationOffset() {
    //     double Offset = 0;
    //     if      ( Chooser.GetStart() == "Red Wal" ) { Offset =   0; }
    //     else if ( Chooser.GetStart() == "Red Lft" ) { Offset = 300; } // TEST
    //     else if ( Chooser.GetStart() == "Red Ctr" ) { Offset =   0; }
    //     else if ( Chooser.GetStart() == "Red Rgt" ) { Offset =  60; } // TEST
    //     else if ( Chooser.GetStart() == "Blu Wal" ) { Offset =   0; }
    //     else if ( Chooser.GetStart() == "Blu Lft" ) { Offset = 300; } // TEST
    //     else if ( Chooser.GetStart() == "Blu Ctr" ) { Offset =   0; }
    //     else if ( Chooser.GetStart() == "Blu Rgt" ) { Offset =  60; } // TEST
    //     return Offset;
    // }
}
