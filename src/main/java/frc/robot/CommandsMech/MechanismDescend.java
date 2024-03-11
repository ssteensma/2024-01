package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismDescend extends InstantCommand {

  public MechanismDescend() {}

  @Override public void initialize() {
    Mechanism.Descend();
  }

}
