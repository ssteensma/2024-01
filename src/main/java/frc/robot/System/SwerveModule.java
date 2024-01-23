package frc.robot.System;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Hardware.CAN_Encoder;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class SwerveModule extends Subsystem {

    boolean     turning_flag = false;
    double      LastPosition = 0;
    double      SpeedPlus    = 0;

    String      ModuleName;
    TalonFX     DriveMotor;
    TalonFX     SteerMotor;
    CAN_Encoder SteerEncoder;

    public SwerveModule ( String ModuleName, int[] CAN_ID ) {
        this.ModuleName   = ModuleName;

        // DEFINE AND CONFIGURE DRIVE MOTOR
        DriveMotor = new TalonFX( CAN_ID[0] );
        DriveMotor.setNeutralMode( NeutralModeValue.Brake );

        // DEFINE AND CONFIGURE STEER MOTOR
        SteerMotor = new TalonFX( CAN_ID[1] );
        SteerMotor.setNeutralMode( NeutralModeValue.Brake );

        // DEFINE AND CONGIRUE STEER ENCODER
        SteerEncoder = new CAN_Encoder( CAN_ID[2] );
    }

    public double GetDirection () {
        return SteerEncoder.GetDirection();
    }

    public double GetSpeed () {
        return Math.abs( DriveMotor.getVelocity().getValueAsDouble() );
    }

    public void Update ( SwerveModuleState state ) {

        // CALCULATE DRIVE VALUES
        double DriveRatio = state.speedMetersPerSecond;
        double reverse    = GetDirection();

        // CALCUALTE TURN VALUES
        double SP = state.angle.getDegrees(); // Set Point
        double PV = GetDirection();           // Process Value

        // NORMALIZE 0 TO 360
        SP = ( SP + 360 ) % 360;

        // SMALLEST ANGLE TO SWIVEL: -180 to 180
        double minTurn = -( SP - PV );
        double turnMag = Math.abs   ( minTurn );
        double turnDir = Math.signum( minTurn );

        // MINIMIZE WHEEL SWIVEL: +120 BECOMES -60
        if ( turnMag > 90 ) {
            turnMag = 180 - turnMag;
            turnDir *= -1;
            reverse *= -1;
        }

        // DETERMINE POWER USING PSEUDO PID CONTROLLER
        double SteerRatio = 0;
        if      ( turnMag > 20 ) { SteerRatio = 0.08; }
        else if ( turnMag > 10 ) { SteerRatio = 0.08; }
        else if ( turnMag >  1 ) { SteerRatio = 0.08; }
        else                     { SteerRatio = 0.00; }

        double CurrentPosition = SteerEncoder.GetDirection();

        if ( turnMag > 1 & CurrentPosition == LastPosition ) {
            SpeedPlus += 0.001;
        }

        if ( turnMag <= 3 ) {
            turning_flag = false;
        } else {
            turning_flag = true;
        }

        LastPosition = CurrentPosition;
        SteerRatio   += SpeedPlus;
        SmartDashboard.putNumber( ModuleName + "-SpeedPlus", SpeedPlus );
        SmartDashboard.putNumber( ModuleName + "-Turn Mag" , turnMag   );

        // SET MOTOR CONTROLLERS
        DriveMotor.setVoltage( DriveRatio * 10 * reverse );
        SteerMotor.setVoltage( SteerRatio * 10 * turnDir );
    }
}
