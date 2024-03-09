package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class Auton {

    public static double
        DriveSpeed   = 0.15,
        TurnSpeed    = 0.15,

        Wall_To_Line = 114,

        Lft_Backup =  34,
        Rgt_Backup =  34,
        Med_Backup =  60,
        Far_Backup = 241,

        To_Lft_Ring = 130,
        To_Ctr_Ring = 114,
        To_Rgt_Ring = 130,

        Turn_Angle  =  60,

        Far_Short   = 337,
        Far_Long    = 414,
        
        Shoot_PrepTime = 1.50,
        Shoot_Duration = 2.00;

    public static void CollectRing() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Mechanism.Collect();
        Stage.WaitForMinDistance( 12 );
    }

    public static void DriveToRing() {
        Autopilot.DriveToRing();
        Mechanism.Collect();
        Stage.WaitForRing();
    }

    public static void DriveToSpeaker() {
        Autopilot.DriveToAprilTag_UNTESTED();
        Stage.WaitForAprilTagY( -13, 1 );
    }

    public static void PrepShooter() {
        Shooter.Shoot( 1.00 );
        Stage.WaitForMinDuration( Auton.Shoot_PrepTime );
    }

    public static void ShootHi() {
        Mechanism.ShootHi();
        Stage.WaitForMinDuration( Auton.Shoot_Duration );
    }
}
