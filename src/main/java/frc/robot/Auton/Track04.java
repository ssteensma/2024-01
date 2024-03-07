package frc.robot.Auton;

import frc.robot.Mech.Mechanism;
import frc.robot.System.*;

// FROM CENTER - SHOOT, BACKUP, PICK UP, SHOOT, BACKUP

public class Track04 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 2:
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 3:
                // Autopilot.DriveS( 0.35 );
                // Stage.WaitForMinDistance( 80 );
                break;

            case 4:
                Autopilot.DriveToRing();
                Mechanism.Collect();
                Stage.WaitForRing();
                break;

            case 5:
                Autopilot.DriveS( 0.30 );
                Mechanism.Collect();
                Stage.WaitForMinDistance( 8 );
                break;

            case 6:
                Mechanism.Collect();
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 7:
                Autopilot.AdjustToHeading( 0 );
                Stage.WaitForHeading( 0, 4 );
                break;

            case 8:
                Autopilot.DriveToAprilTag();
                Stage.WaitForAprilTagY( 17, 5 );
                break;

            case 9:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 10:
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
