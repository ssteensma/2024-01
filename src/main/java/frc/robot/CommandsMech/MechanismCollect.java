package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismCollect extends InstantCommand {

  public MechanismCollect() {}

  @Override public void initialize() {
    Mechanism.Collect();
  }
}

