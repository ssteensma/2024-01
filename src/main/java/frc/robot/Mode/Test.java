package frc.robot.Mode;

import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Test {

    // Declare and define a drive motor controller here
    
    public static void Initialize() {
        CommandScheduler.getInstance().cancelAll();
    }

    public static void Periodic() {

        // Make the drive motor spin at 30%;

    }

}
