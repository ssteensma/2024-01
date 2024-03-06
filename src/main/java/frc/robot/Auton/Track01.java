package frc.robot.Auton;

import frc.robot.System.*;

// CROSS LINE ONLY
// BATTERY AWAY FROM WALL

public class Track01 {

    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;

            case 1:
                Autopilot.DriveS( 0.20 );
                Stage.WaitForMinDistance( 120 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
