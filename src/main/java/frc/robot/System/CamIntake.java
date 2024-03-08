package frc.robot.System;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class CamIntake {

    public static NetworkTable
        LI;

    public static void Initialize() {
        LI = NetworkTableInstance.getDefault().getTable("limelight-intake");
    }

    public static void Periodic() {
        // SmartDashboard.putNumber( "CamIntake TX", GetCode("tx") );
        // SmartDashboard.putNumber( "CamIntake TY", GetCode("ty") );
    }

    public static double GetCode( String S ) { return LI.getEntry( S ).getDouble( 0 ); }

    public static void Reset() {}

    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCode("ty"); }
    public static double TV() { return GetCode("tv"); }

    public static double GetErr( String Code, double Desired ) {
        return Desired - GetCode( Code );
    }
}
