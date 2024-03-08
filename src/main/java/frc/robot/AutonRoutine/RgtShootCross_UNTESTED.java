package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class RgtShootCross_UNTESTED {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1: // POWER UP SHOOTER
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 2: // SHOOT INTO SPEAKER
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            case 3: // BACK UP
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

            default:
                Stage.Last();
                break;
        }
    }
}
