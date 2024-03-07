package frc.robot.System;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class CamTarget {

    public static NetworkTable
        LL;

    public static void Initialize() {
        LL = NetworkTableInstance.getDefault().getTable("limelight-target");
    }

    public static void Periodic() {
        // SmartDashboard.putNumber( "CamTarget TX", GetCode("tx") );
        // SmartDashboard.putNumber( "CamTarget TY", GetCode("ty") );
    }

    public static void Reset() {}

    public static double GetCode( String S ) { return LL.getEntry( S ).getDouble( 0 ); }

    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCode("ty"); }
    public static double TV() { return GetCode("tv"); }

    public static double GetErr( String Code, double Desired ) {
        return Desired - GetCode( Code );
    }
}
