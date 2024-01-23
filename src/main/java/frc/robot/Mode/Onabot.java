package frc.robot.Mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Onabot {

    public static void Initialize() {

    }

    public static void Periodic() {
        CommandScheduler.getInstance().run();
    }

}
