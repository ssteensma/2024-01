package frc.robot.Auton;

import frc.robot.System.Autopilot;
import frc.robot.System.Shooter;
import frc.robot.System.Stage;

// SHOOT ONLY

public class Track02 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.Stop();
                Shooter.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;
        
            default:
                Stage.Last();
                break;
        }
    }
}
