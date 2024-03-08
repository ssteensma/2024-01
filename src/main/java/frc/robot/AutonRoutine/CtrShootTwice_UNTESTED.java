package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootTwice_UNTESTED {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1: // 
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 2: // 
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            case 3: // DRIVE SOUTH (IF Needed)
                // Autopilot.TranslateS( Auton.DriveSpeed );
                // Stage.WaitForMinDistance( 18 );
                break;

            case 4: // ALIGN WITH RING
                Autopilot.DriveToRing();
                Mechanism.Collect();
                Stage.WaitForRing();
                break;
            
            case 5: // COLLECT RING
                Autopilot.TranslateS( Auton.DriveSpeed );
                Mechanism.Collect();
                Stage.WaitForMinDistance( 12 );
                break;

            case 6: // DRIVE BACK TO APRIL TAG
                Autopilot.TranslateN_UNTESTED( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 20 );
                break;

            case 7: // TURN TO HEADING ZERO
                Autopilot.AdjustToHeading( 0 );
                Stage.WaitForHeading( 0, 1 );
                break;

            case 8: //  SLIDE TO BE ALIGNED WITH APRIL TAG CENTER
                if ( CamIntake.TX() > 0 ) { Autopilot.TranslateE_UNTESTED( Auton.DriveSpeed ); }
                else                      { Autopilot.TranslateW_UNTESTED( Auton.DriveSpeed ); }
                Stage.WaitForAprilTagX( 0, 2 );
                break;

            case 9: // DRIVE TO APRIL TAG
                Autopilot.DriveToAprilTag_UNTESTED();
                Stage.WaitForAprilTagY( -13, 1 );
                break;

            case 10: // PREPARE TO SHOOT
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 11: // SHOOT SECOND NOTE
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            case 12: // RECROSS LINE
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 48 );
                break;
    
            default:
                Stage.Last();
                break;
        }
    }
}
