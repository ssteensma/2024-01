package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mover;

public class MoverReverse extends InstantCommand {

  public MoverReverse() {}

  @Override public void initialize() {
    Mover.Reverse();
  }

}
