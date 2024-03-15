package frc.robot.Mode;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.System.*;

public class Onabot {

    public static void Initialize() {
        DataLogManager.start();
        DriverStation .startDataLog( DataLogManager.getLog() );

        Navigation   .Initialize();
        Drivetrain   .Initialize();

        Aimer        .Initialize();
        Autonomous   .Initialize();
        ChooserAuton .Initialize();
        ChooserColor .Initialize();
        ChooserStart .Initialize();
        Intake       .Initialize();
        CamShooter   .Initialize();
        CamIntake    .Initialize();
        Climber      .Initialize();
        Mover        .Initialize();
        Roller       .Initialize();
        Shooter      .Initialize();
    }

    public static void Periodic() {
        Aimer        .Display();
        Climber      .Display();
        Intake       .Display();
        Mover        .Display();
        Roller       .Display();
        Shooter      .Display();
    }

    public static void UpdateMechanism() {
        Aimer        .Periodic();
        Intake       .Periodic();
        CamShooter   .Periodic();
        CamIntake    .Periodic();
        Climber      .Periodic();
        Mover        .Periodic();
        Navigation   .Periodic();
        Roller       .Periodic();
        Shooter      .Periodic();
    }

    public static void ResetMechanism() {
        Aimer         .Reset();
        Climber       .Reset();
        Intake        .Reset();
        CamShooter    .Reset();
        CamIntake     .Reset();
        Mover         .Reset();
        Navigation    .Reset();
        Roller        .Reset();
        Shooter       .Reset();
    }

}
