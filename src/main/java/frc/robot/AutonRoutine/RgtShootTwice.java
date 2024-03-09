package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class RgtShootTwice {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter    (); break;
            case 2: Auton.ShootHi        (); break;

            case 3: Auton.BackupLft      (); break;
            case 4: Auton.TurnRgt        (); break;
            case 5: Auton.Backup     ( 48 ); break;
            
            case 6: Auton.TransToRing    (); break;
            case 7: Auton.CollectRing    (); break;

            case 8: Auton.Forward    ( 48 ); break;
            case 9: Auton.TurnLft        (); break;
            case 10: Auton.TransToSpeaker(); break;

            case 11: Auton.PrepShooter   (); break;
            case 12: Auton.ShootHi       (); break;

            default: Stage.Last(); break;
        }
    }
}
