package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismStop extends InstantCommand {

  public MechanismStop() {}

  @Override public void initialize() {
    Mechanism.Stop();
  }

}
