package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mover;

public class MoverForward extends InstantCommand {

  public MoverForward() {}

  @Override public void initialize() {
    Mover.Forward();
  }

}
