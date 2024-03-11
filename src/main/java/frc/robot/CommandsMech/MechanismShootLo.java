package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismShootLo extends InstantCommand {

  public MechanismShootLo() {}

  @Override public void initialize() {
    Mechanism.ShootLo();
  }

}
