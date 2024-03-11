package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mover;

public class MoverStop extends InstantCommand {
  public MoverStop() {}

  @Override public void initialize() {
    Mover.Stop();
  }

}
