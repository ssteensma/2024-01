package frc.robot.Mode;

import frc.robot.System.Drivetrain;

// import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Onabot {

    // public static TalonFX FL_wheel;

    public static void Initialize() {
        Autonomous.Initialize();
        Drivetrain.Initialize();
    }

    public static void Periodic() {
        // CommandScheduler.getInstance().run();
    }

}
