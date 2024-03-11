package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Shooter;

public class ShooterHi extends InstantCommand {

  public ShooterHi() {}

  @Override public void initialize() {
    Shooter.ShootHi();
  }

}
