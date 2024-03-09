package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class CtrShootCrossGrab {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3: Auton.TransToRing(); break;
            case 4: Auton.CollectRing(); break;

            default: Stage.Last(); break;
        }
    }
}
