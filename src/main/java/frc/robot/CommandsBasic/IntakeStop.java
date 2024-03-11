package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.System.Intake;

public class IntakeStop extends Command {

  public IntakeStop() {}

  @Override public void initialize() {
    Intake.Stop();
  }

}
