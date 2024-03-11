package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismAscend extends InstantCommand {

  public MechanismAscend() {}

  @Override public void initialize() {
    Mechanism.Ascend();
  }

}
