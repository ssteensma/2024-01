package frc.robot.Auton;

import frc.robot.System.*;

// FROM CENTER - SHOOT, BACKUP, PICK UP, SHOOT, BACKUP

public class Track04 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.50 );
                break;

            case 2:
                Mover.Forward();
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 3:
                Mover.Stop();
                Shooter.Stop();
                break;

            case 4:
                // Autopilot.DriveS( 0.35 );
                // Stage.WaitForMinDistance( 80 );
                break;

            case 5:
                Autopilot.DriveToRing();
                Intake.Suck();
                Stage.WaitForRing();
                break;

            case 6:
                Autopilot.DriveS( 0.30 );
                Intake.Suck();
                Mover.Forward();
                Roller.Suck();
                Stage.WaitForMinDistance( 12 );
                break;

            case 7:
                Autopilot.Stop();
                Intake.Suck();
                Mover.Forward();
                Roller.Suck();
                Stage.WaitForMinDuration( 1.00 );
                break;

            case 8:
                Autopilot.DriveToAprilTag();
                Stage.WaitForAprilTagY( 17, 5 );
                break;

            case 9:
                Autopilot.Stop();
                break;

            case 10:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.50 );
                break;

            case 11:
                Mover.Forward();
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 12:
                Mover.Stop();
                Shooter.Stop();
                break;

            case 13:
                // Autopilot.DriveS( 0.35 );
                // Stage.WaitForMinDistance( 80 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
