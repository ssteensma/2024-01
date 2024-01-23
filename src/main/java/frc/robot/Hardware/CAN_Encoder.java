package frc.robot.Hardware;

import com.ctre.phoenix6.hardware.CANcoder;

public class CAN_Encoder {

    public CANcoder Enc;
    public final static int kUnitsPerRevolution = 2048;

    public CAN_Encoder ( int CanBusID ) {
        Enc = new CANcoder( CanBusID );
    }

    public double GetDirection () {
        return Enc.getAbsolutePosition().getValueAsDouble();
    }

    public double GetVelocity () {
        return Enc.getVelocity().getValueAsDouble();
    }
}
