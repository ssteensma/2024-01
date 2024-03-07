package frc.robot.System;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Navigation {
    
    public static ADXRS450_Gyro NavX;

    public static void Initialize() {
        NavX = new ADXRS450_Gyro();
        NavX.calibrate();
    }

    public static void Periodic() {}

    public static double GetDirection() { 
        return ( GetYaw() + GetNavigationOffset() + 360 ) % 360;
    }

    public static void Calibrate() { NavX.calibrate(); }
    public static void Reset    () { NavX.reset    (); }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

    public static double GetNavigationOffset() {
        double Offset = 0;
        if ( Chooser.GetStart() == "Red Wal" ) { Offset =   0; }
        if ( Chooser.GetStart() == "Red Lft" ) { Offset = 300; } // TEST
        if ( Chooser.GetStart() == "Red Ctr" ) { Offset =   0; }
        if ( Chooser.GetStart() == "Red Rgt" ) { Offset =  60; } // TEST
        if ( Chooser.GetStart() == "Blu Wal" ) { Offset =   0; }
        if ( Chooser.GetStart() == "Blu Lft" ) { Offset = 300; } // TEST
        if ( Chooser.GetStart() == "Blu Ctr" ) { Offset =   0; }
        if ( Chooser.GetStart() == "Blu Rgt" ) { Offset =  60; } // TEST
        return Offset;
    }
}
