package frc.robot.System;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Navigation {
    
    public static ADXRS450_Gyro NavX;

    public static void Initialize() {
        NavX = new ADXRS450_Gyro();
        NavX.calibrate();
    }

    public static void Periodic() {
    }

    public static double GetDirection() {
        return ( GetYaw() + 360 ) % 360;
    }

    public static void Calibrate() {
        NavX.calibrate();
    }

    public static void Reset() {
        NavX.reset();
    }

    // public static double GetPitch() { return +NavX.getPitch(); }
    // public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getAngle();   }

}
