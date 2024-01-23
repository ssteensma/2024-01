package frc.robot.Commands.Intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Shared;

public class Spit extends Command {

  public Spit() {
    addRequirements( Shared.m_Intake );
  }

  @Override public void initialize() {}

  @Override public void execute() {
  }

  @Override public void end(boolean interrupted) {}

  @Override public boolean isFinished() {
    return false;
  }
}
