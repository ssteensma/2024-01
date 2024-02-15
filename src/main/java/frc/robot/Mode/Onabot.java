package frc.robot.Mode;

import frc.robot.System.Drivetrain;
import frc.robot.System.Intake;

// import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Onabot {

    public static void Initialize() {
        Autonomous.Initialize();
        Drivetrain.Initialize();
        Intake.Initialize();
    }

    public static void Periodic() {
        // CommandScheduler.getInstance().run();

        // DISPLAY METHODS
        Drivetrain.Display();
        Intake.Display();

    }

}
