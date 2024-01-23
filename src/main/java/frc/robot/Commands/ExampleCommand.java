package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.System.Subsystem;

public class ExampleCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Subsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand( Subsystem subsystem ) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }

  @Override public void initialize() {}

  @Override public void execute() {}

  @Override public void end( boolean interrupted ) {}

  @Override public boolean isFinished() {
    return false;
  }
}
