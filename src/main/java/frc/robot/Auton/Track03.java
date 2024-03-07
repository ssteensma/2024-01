package frc.robot.Auton;

import frc.robot.System.*;

// FROM CENTER - SHOOT AND BACK UP FROM CENTER

public class Track03 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.50 );
                break;

            case 2:
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 3:
                Autopilot.DriveS( 0.35 );
                Stage.WaitForMinDistance( 120 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
