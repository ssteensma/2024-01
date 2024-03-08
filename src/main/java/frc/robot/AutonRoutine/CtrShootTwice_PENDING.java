package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootTwice_PENDING {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1: // PREPARE SHOOTER
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 2: // SHOOT NOTE
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            case 3: // ALIGN WITH SECOND RING
                Autopilot.DriveToRing();
                Mechanism.Collect();
                Stage.WaitForRing();
                break;
            
            case 4: // COLLECT SECOND RING
                Autopilot.TranslateS( Auton.DriveSpeed );
                Mechanism.Collect();
                Stage.WaitForMinDistance( 30 );
                break;

            case 5: // DRIVE TO APRIL TAG
                Autopilot.DriveToAprilTag_UNTESTED();
                Stage.WaitForAprilTagY( -13, 1 );
                break;

            case 6: // PREPARE SHOOTER
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 7: // SHOOT SECOND NOTE
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            case 8: // CROSS LINE AGAIN
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 60 );
                break;
    
            default:
                Stage.Last();
                break;
        }
    }
}
