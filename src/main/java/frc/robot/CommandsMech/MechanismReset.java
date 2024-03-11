package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismReset extends InstantCommand {

  public MechanismReset() {}

  @Override public void initialize() {
    Mechanism.Reset();
  }

}
