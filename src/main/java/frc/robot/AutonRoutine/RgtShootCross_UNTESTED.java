package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class RgtShootCross_UNTESTED {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi();     break;

            case 3:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( Auton.Rgt_Backup );
                break;

            case 4: // TURN 60 DEGREES LEFT
                Autopilot.TurnLftAtSpeed( Auton.TurnSpeed );
                Stage.WaitForHeading( 60, 3 );
                break;

            case 5: // CROSS LINE
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 4*12 );
                break;

            default: Stage.Last(); break;
        }
    }
}
