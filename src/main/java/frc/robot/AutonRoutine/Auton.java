package frc.robot.AutonRoutine;

import frc.robot.Setting;
import frc.robot.System.*;

public class Auton {

    public static double
        DriveSpeed   = 0.17,
        TurnSpeed    = 0.15,

        toIn  = 5.30,

        CameraRange = 36.0,
        RobotLength = 17.5,

        DistA =  53,
        DistB = 276,
        DistC = 318,
        DistD = 106,
        DistE =  58,
        DistF = 116,
        DistG =  58,
        DistH =  95,
        DistI =  85,
        DistJ = 408,

        HeadA =   0,
        HeadB =   0,
        HeadC = 300,
        HeadD = 300,
        HeadE =   0,
        HeadF =   0,
        HeadG =   0,
        HeadH =  60,
        HeadI =   0,
        HeadJ =  60;     

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
        Autopilot.TransToSpeakerNear();
        Stage.WaitForAprilTagY( Setting.Speaker_0, 1 );
    }

    public static void Forward( double Distance ) {
        Autopilot.TranslateN( Auton.DriveSpeed );
        Stage.WaitForMinDistance( Distance );
    }

    public static void Reverse( double Distance ) {
        Autopilot.TranslateS( Auton.DriveSpeed );
        Stage.WaitForMinDistance( Distance );
    }

    public static void ForHeading( double Speed, double Heading, double Distance ) {
        Autopilot.ForwardAtHeading( Speed, Heading );
        Stage.WaitForMinDistance( Distance );
    }

    public static void RevHeading( double Speed, double Heading, double Distance ) {
        Autopilot.ReverseAtHeading( Speed, Heading );
        Stage.WaitForMinDistance( Distance );
    }

    public static void PrepShooter() {
        Shooter.Shoot( 1.00 );
        Stage.WaitForMinDuration( 0.50 );
    }

    public static void ShootHi() {
        Mechanism.ShootHi();
        Stage.WaitForMinDuration( 1.50 );
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

    public static void TurnLft( double Heading ) {
        Autopilot.TurnLftAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( Heading, 2 );
    }

    public static void TurnRgt( double Heading ) {
        Autopilot.TurnRgtAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( Heading, 2 );
    }

    public static void TurnLft60() {
        Autopilot.TurnLftAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( 60, 2 );
    }

    public static void TurnRgt60() {
        Autopilot.TurnRgtAtSpeed( Auton.TurnSpeed );
        Stage.WaitForHeading( 300, 2 );
    }

}
