package frc.robot.CommandsMech;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Mechanism;

public class MechanismShootHi extends InstantCommand {

  public MechanismShootHi() {}

  @Override public void initialize() {
    Mechanism.ShootHi();
  }

}
