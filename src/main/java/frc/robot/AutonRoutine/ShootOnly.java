package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class ShootOnly {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
                break;

            case 2:
                Mechanism.ShootHi();
                Stage.WaitForMinDuration( Auton.Shoot_Duration );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
