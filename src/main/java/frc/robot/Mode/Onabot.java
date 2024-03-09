package frc.robot.Mode;

import edu.wpi.first.wpilibj.DataLogManager;
import frc.robot.System.*;

public class Onabot {

    public static void Initialize() {
        DataLogManager.start();
        
        Navigation   .Initialize();
        Drivetrain   .Initialize();

        Aimer        .Initialize();
        Autonomous   .Initialize();
        ChooserAuton .Initialize();
        Intake       .Initialize();
        CamShooter   .Initialize();
        CamIntake    .Initialize();
        Climber      .Initialize();
        Mover        .Initialize();
        Roller       .Initialize();
        Shooter      .Initialize();
    }

    public static void Periodic() {}

    public static void UpdateMechanism() {
        Aimer        .Periodic();
        ChooserAuton .Periodic();
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
