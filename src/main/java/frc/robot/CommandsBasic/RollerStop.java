package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Roller;

public class RollerStop extends InstantCommand {
  public RollerStop() {}

  @Override public void initialize() {
    Roller.Stop();
  }

}
