package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootCross {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 48 );
                break;

            default: Stage.Last(); break;
        }
    }
}
