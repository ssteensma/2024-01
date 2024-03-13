package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class RgtShootCross {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3: Auton.BackupRgt  (); break;
            case 4: Auton.TurnLft60    (); break;
            case 5: Auton.Backup ( 48 ); break;

            default: Stage.Last(); break;
        }
    }
}
