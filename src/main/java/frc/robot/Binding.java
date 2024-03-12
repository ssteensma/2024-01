package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.Ports.pStick;

public class Binding {

    // JOYSTICK CONTROLLERS
    public static CommandPS4Controller
        DS = new CommandPS4Controller( pStick.USB_Drive ),
        MS = new CommandPS4Controller( pStick.USM_Manip );

    public static void Bindings() {
        DS.cross().onTrue( Shared.mIntake.cSpit() );
    }

}
