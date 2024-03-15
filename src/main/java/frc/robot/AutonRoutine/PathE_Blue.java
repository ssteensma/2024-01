package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class PathE_Blue {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            // SHOOT FIRST RING
            case 1: Auton.PrepShooter    (); break;
            case 2: Auton.ShootHi        (); break;

            // BACK AWAY FROM SPEAKER
            case 3: Auton.RevHeading( 0.40, 0, 120 ); break;

            // TURN TOWARD NEXT RING
            case 4: Auton.TurnRgt   ( 300 ); break;

            // APPROACH TOWARD SECOND RING
            case 5: Auton.RevHeading( 0.40, 300, 120 ); break;

            default: Stage.Last(); break;
        }
    }
}
