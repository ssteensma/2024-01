package frc.robot.System;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class Navigation {
    
    public static AHRS NavX = new AHRS( SerialPort.Port.kMXP );

    public static void Initialize() {
    }

    public static double GetDirection() {
        return GetYaw();
    }

    public static void   Reset()    { NavX.reset();            }

    public static double GetPitch() { return +NavX.getPitch(); }
    public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getYaw();   }

}
