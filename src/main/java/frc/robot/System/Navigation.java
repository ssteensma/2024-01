package frc.robot.System;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Navigation {
    
    public static AHRS NavX;

    public static void Initialize() {
        NavX = new AHRS( SerialPort.Port.kMXP );
    }

    public static void Display() {
        SmartDashboard.putNumber( "DIR", GetDirection() );
    }

    public static double GetDirection() {
        return GetYaw();
    }

    public static void   Reset()    { NavX.reset();            }

    public static double GetPitch() { return +NavX.getPitch(); }
    public static double GetRoll()  { return +NavX.getRoll();  }
    public static double GetYaw()   { return -NavX.getYaw();   }

}
