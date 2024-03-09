package frc.robot.System;

// import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class Shuffle {
    
    public static ShuffleboardTab AutoTab = Shuffleboard.getTab( "Auto" );
    public static ShuffleboardTab CompTab = Shuffleboard.getTab( "Comp" );
    public static ShuffleboardTab DrivTab = Shuffleboard.getTab( "Driv" );
    public static ShuffleboardTab LimeTab = Shuffleboard.getTab( "Lime" );
    public static ShuffleboardTab MechTab = Shuffleboard.getTab( "Mech" );
    public static ShuffleboardTab PoseTab = Shuffleboard.getTab( "Pose`" );

    // public static ShuffleboardLayout CamIntake = Shuffleboard.getTab("Lime")
    //     .getLayout( "Intake Cam", BuiltInLayouts.kList )
    //     .withSize( 5, 1 );

    public static void Initialize() {


        // AutoTab.add( "Stage Distance", Stage.GetStageDist( Stage.Number ) ).withPosition( 2, 1 ).withSize( 2, 1 );
        // AutoTab.add( "Stage Number", Stage.GetStageNumber() ).withPosition( 3, 1 ).withSize( 2, 1 );

    // //
    // // DRIVETRAIN TAB
    // //
    //     if ( DrivTab != null ) {
    //         DrivTab.add( "FL Power", Drivetrain.FL_module.GetPower() ).withPosition( 0, 0 ).withSize( 2, 1 );
    //         DrivTab.add( "FR Power", Drivetrain.FR_module.GetPower() ).withPosition( 3, 1 ).withSize( 2, 1 );
    //         DrivTab.add( "RL Power", Drivetrain.FL_module.GetPower() ).withPosition( 1, 2 ).withSize( 2, 1 );
    //         DrivTab.add( "RR Power", Drivetrain.FR_module.GetPower() ).withPosition( 3, 2 ).withSize( 2, 1 );

    //         DrivTab.add( Drivetrain.FL_module.DriveMotor );
    //         DrivTab.add( Drivetrain.FR_module.DriveMotor );
    //         DrivTab.add( Drivetrain.RL_module.DriveMotor );
    //         DrivTab.add( Drivetrain.RR_module.DriveMotor );

    //         DrivTab.add( Navigation.NavX );
    //     }

    // //
    // // MECHANISM TAB
    // //
    //     if ( MechTab != null ) {        
    //         MechTab.add( "Intake Current Power" , Intake  .GetPower() ).withPosition( 1, 1 ).withSize( 2, 1 );
    //         MechTab.add( "Roller Current Power" , Roller  .GetPower() ).withPosition( 2, 1 ).withSize( 2, 1 );
    //         MechTab.add( "Mover Current Power"  , Mover   .GetPower() ).withPosition( 3, 1 ).withSize( 2, 1 );
    //         MechTab.add( "Shooter Current Power", Shooter .GetPower() ).withPosition( 4, 1 ).withSize( 2, 1 );
    //         MechTab.add( "Aimer Current State"  , Aimer   .GetState() ).withPosition( 5, 1 ).withSize( 2, 1 );
    //     }

    // //
    // // ROBOT POSE
    // //
    //     if ( PoseTab != null ) {
    //         if ( Drivetrain.Pose != null ) {
    //             PoseTab.add( "Pose X", Drivetrain.GetPose().getX()        );
    //             PoseTab.add( "Pose Y", Drivetrain.GetPose().getY()        );
    //             PoseTab.add( "Pose Z", Drivetrain.GetPose().getRotation() );
    //         }
    //     }

    // }

    // public static void Reset() {
    //     CompTab.addPersistent( "Target Vertical",  CamIntake .TargetY ).getEntry();
    //     CompTab.addPersistent( "Shooter Vertical", CamShooter.TargetY ).getEntry();
    // }
    }
}
