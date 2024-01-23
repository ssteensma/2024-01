package frc.robot.Commands.Intake;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Shared;
import frc.robot.System.Intake;

public class Stop extends InstantCommand {

  public Stop() {
    addRequirements( Shared.m_Intake );
  }

  @Override public void initialize() {
    Intake.Stop();
  }
}
