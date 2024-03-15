package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class PathB_Red {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            // SHOOT FIRST RING
            case 1: Auton.PrepShooter    (); break;
            case 2: Auton.ShootHi        (); break;

            // TURN TOWARD NEXT RING
            case 3: Auton.TurnLft    ( 60 ); break;

            // COLLECT RING
            case 4: Auton.TransToRing    (); break;
            case 5: Auton.CollectRing    (); break;

            // MOVE TOWARD SPEAKER
            case 6: Auton.TransToSpeaker (); break;

            // SHOOT SECOND RING
            case 7: Auton.PrepShooter    (); break;
            case 8: Auton.ShootHi        (); break;

            default: Stage.Last(); break;
        }
    }
}
