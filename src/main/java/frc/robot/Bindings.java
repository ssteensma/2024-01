package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Ports.pStick;

public class Bindings {

    public static CommandXboxController DS = new CommandXboxController( pStick.pUSB_Drive );
    public static CommandPS4Controller  MS = new CommandPS4Controller ( pStick.pUSM_Manip );

    public static void DoBindings() {
        DS_Scott();
        MS_Scott();
    }

    public static void DS_Scott() {
        // DS.b().whileTrue(
        //     Shared.m_Subsystem.exampleMethodCommand()
        // );
    }

    public static void MS_Scott() {
    }

    // public static void ManipScott() {

    //     // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //     new Trigger( Shared.m_Subsystem::exampleCondition)
    //         .onTrue(new ExampleCommand( Shared.m_Subsystem ));
    // }

}
