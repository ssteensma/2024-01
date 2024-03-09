package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class Auton {

    public static double
        DriveSpeed   = 0.17,
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
        Far_Long    = 414;
        
    public static void Backup( double Distance ) {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( Distance );
    }

    public static void BackupCtr() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( 48 );
    }

    public static void BackupLft() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( 34 );
    }

    public static void BackupRgt() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( 34 );
    }

    public static void BackupWall() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( 120 );
    }

    public static void CollectRing() {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Mechanism.Collect();
        Stage.WaitForMinDistance( 18 );
    }

    public static void TransToSpeaker() {
        Autopilot.TransToAprilTag();
        Stage.WaitForAprilTagY( 10, 1 );
    }

    public static void Forward( double Distance ) {
        Autopilot.TranslateN( Auton.DriveSpeed );
        Stage.WaitForMinDistance( Distance );
    }

    public static void PrepShooter() {
        Shooter.Shoot( 1.00 );
        Stage.WaitForMinDuration( 0.50 );
    }

    public static void ShootHi() {
        Mechanism.ShootHi();
        Stage.WaitForMinDuration( 2.00 );
    }

    public static void TranslateS( double Distance ) {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( Distance );
    }

    public static void TransToRing() {
        Autopilot.TransToRing();
        Mechanism.Collect();
        Stage.WaitForRing();
    }

    public static void TurnLft() {
        Autopilot.TurnLftAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( 60, 2 );
    }

    public static void TurnRgt() {
        Autopilot.TurnRgtAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( 300, 2 );
    }

}
