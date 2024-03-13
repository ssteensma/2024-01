package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class NarShootThree_PENDING {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case  0: break;
        
            case  1: Auton.PrepShooter    (); break;
            case  2: Auton.ShootHi        (); break;

            case  3: Auton.BackupRgt      (); break;
            case  4: Auton.TurnLft60        (); break;
            case  5: Auton.Backup     ( 48 ); break;
            
            case  6: Auton.TransToRing    (); break;
            case  7: Auton.CollectRing    (); break;

            case  8: Auton.Forward    ( 48 ); break;
            case  9: Auton.TurnRgt60        (); break;
            case 10: Auton.TransToSpeaker (); break;

            case 11: Auton.PrepShooter    (); break;
            case 12: Auton.ShootHi        (); break;

            case 13: Auton.BackupRgt      (); break;
            case 14: Auton.TurnLft60        (); break;
            case 15: Auton.Backup    ( 380 ); break;

            case 16: Auton.TransToRing    (); break;
            case 17: Auton.CollectRing    (); break;

            case 19: Auton.Forward   ( 410 ); break;
            case 20: 

            default: Stage.Last(); break;
        }
    }
}
