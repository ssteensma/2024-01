package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Commands.Autos;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  public RobotContainer() {
    Shared.Initialize();
    Bindings.DoBindings();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Autos.exampleAuto( Shared.m_Subsystem );
  }
}
