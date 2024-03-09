package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootTwice_PENDING {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            // SHOOT FIRST RING
            case 1: Auton.PrepShooter   (); break;
            case 2: Auton.ShootHi       (); break;

            // COLLECT SECOND RING
            case 3: Auton.DriveToRing   (); break;
            case 4: Auton.CollectRing   (); break;

            // DRIVE TO SPEAKER
            case 5: Auton.DriveToSpeaker(); break;

            // SHOOT SECOND RING
            case 6: Auton.PrepShooter   (); break;
            case 7: Auton.ShootHi       (); break;

            // CROSS LINE AGAIN
            case 8:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( 60 );
                break;
    
            default: Stage.Last(); break;
        }
    }
}
