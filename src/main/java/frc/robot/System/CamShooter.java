package frc.robot.System;

import java.util.Map;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class CamShooter {

    public static NetworkTable
        LI = NetworkTableInstance.getDefault()
            .getTable("limelight-intake");

    private static GenericEntry
        IntakeTX = Shuffle.CompTab.add( "Shooter TX", 0 )
            .withPosition( 9, 0 )
            .withSize( 2, 1 )
            .getEntry(),

        IntakeTY = Shuffle.CompTab.add( "Shooter TY", 0 )
            .withPosition( 9, 1 )
            .withSize( 2, 1 )
            .getEntry();

    public static void Initialize() {
        LI = NetworkTableInstance.getDefault()
            .getTable("limelight-intake");

        Shuffle.CompTab.addCamera( "Camera Shooter", "Limelight 2", "http://10.55.34.12:5800" )
            .withPosition( 11, 0 )
            .withProperties( Map.of( "showControls", false ) )
            .withSize( 5, 5 );
    }

    public static void Periodic() {
        IntakeTX.setDouble( TX() );
        IntakeTY.setDouble( TY() );
    }

    public static void Reset() {}

    public static double GetCode( String S ) { return LI.getEntry( S ).getDouble( 0 ); }
    public static double TX() { return GetCode("tx"); }
    public static double TY() { return GetCode("ty"); }
    public static double TV() { return GetCode("tv"); }
}
