package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class ShootOnly {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi();     break;

            default: Stage.Last(); break;
        }
    }
}
