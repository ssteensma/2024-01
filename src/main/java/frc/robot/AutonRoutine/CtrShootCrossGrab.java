package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootCrossGrab {
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

            case 3: // 
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 18 );
                break;

            case 4:
                Autopilot.DriveToRing();
                Mechanism.Collect();
                Stage.WaitForRing();
                break;
            
            case 5:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Mechanism.Collect();
                Stage.WaitForMinDistance( 12 );
                break;

            case 6:
                Autopilot.AdjustToHeading( 0 );
                Stage.WaitForHeading( 0, 1 );
                break;

            default: // 
                Stage.Last();
                break;
        }
    }
}
