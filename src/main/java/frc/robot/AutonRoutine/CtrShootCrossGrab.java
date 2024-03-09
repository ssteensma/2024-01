package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootCrossGrab {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 18 );
                break;

            case 4: Auton.DriveToRing(); break;
            case 5: Auton.CollectRing(); break;

            case 6:
                Autopilot.AdjustToHeading( 0 );
                Stage.WaitForHeading( 0, 1 );
                break;

            default: Stage.Last(); break;
        }
    }
}
