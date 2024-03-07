package frc.robot.Auton;

import frc.robot.System.*;

// FROM CENTER - SHOOT, BACKUP, PICK UP, SHOOT, BACKUP

public class Track04 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1: // POWER UP SHOOTER
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 2: // SHOOT INTO SPEAKER
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 3: // MOVE NEAR RING
                Autopilot.DriveS( 0.35 );
                Stage.WaitForMinDistance( 48 );
                break;

            case 4: // COLLECT RING
                Autopilot.DriveToRing();
                Mechanism.Collect();
                Stage.WaitForRing();
                break;

            case 5: // ENSURE RING ENGAGED
                Autopilot.DriveS( 0.30 );
                Mechanism.Collect();
                Stage.WaitForMinDistance( 8 );
                break;

            case 6: // BRING IN RING FULLY
                Mechanism.Collect();
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 7: // TURN TOWARD APRIL TAG
                Autopilot.AdjustToHeading( 0 );
                Stage.WaitForHeading( 0, 4 );
                break;

            case 8: // DRIVE TO APRIL TAG
                Autopilot.DriveToAprilTag();
                Stage.WaitForAprilTagY( 17, 5 );
                break;

            case 9: // POWER UP SHOOTER
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 10: // SHOOT SECOND RING
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 11: // CROSS LINE SECOND TIME
                Autopilot.DriveS( 0.30 );
                Stage.WaitForMinDistance( 60 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
