package frc.robot.Mode;

import edu.wpi.first.wpilibj.DataLogManager;
import frc.robot.System.Drivetrain;
import frc.robot.System.Intake;
import frc.robot.System.Navigation;

// import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Onabot {

    public static void Initialize() {
        DataLogManager.start();

        Autonomous.Initialize();
        Drivetrain.Initialize();
        Intake.Initialize();
        Navigation.Initialize();
    }

    public static void Periodic() {
        // CommandScheduler.getInstance().run();

        // DISPLAY METHODS
        Drivetrain.Display();
        Intake.Display();
        Navigation.Display();

    }

}
