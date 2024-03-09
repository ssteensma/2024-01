package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class LftShootCross {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi();     break;

            case 3: // BACK UP
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( Auton.Lft_Backup );
                break;

            case 4: // TURN 60 DEGREES RIGHT
                Autopilot.TurnRgtAtSpeed( Auton.TurnSpeed );
                Stage.WaitForHeading( 300, 3 );
                break;

            case 5: // CROSS LINE
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 4*12 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
