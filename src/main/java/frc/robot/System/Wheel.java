package frc.robot.System;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Hardware.CAN_Encoder;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Wheel {

    public boolean     turning_flag = false;
    public double      LastPosition = 0;
    public double      SpeedPlus    = 0;

    public String      ModuleName;
    public TalonFX     DriveMotor;
    public TalonFX     SteerMotor;
    public CAN_Encoder SteerEncoder;

    public TalonFXConfiguration cfg;

    public Wheel ( String ModuleName, int[] CAN_ID ) {
        this.ModuleName   = ModuleName;

        // DEFINE AND CONFIGURE DRIVE MOTOR
        DriveMotor = new TalonFX( CAN_ID[0] );
        DriveMotor.setNeutralMode( NeutralModeValue.Brake );

            DriveMotor.setPosition( 0.00 );

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
        double reverse    = 1; // GetDirection();

        // CALCUALTE TURN VALUES
        double SP = state.angle.getDegrees(); // Set Point
        double PV = GetDirection() * 360;     // Process Value

        SmartDashboard.putNumber( ModuleName + "-PV", PV );

        // NORMALIZE 0 TO 360
        // SP = ( SP + 360 ) % 360;

        SmartDashboard.putNumber( ModuleName + "-SP", SP );

        // SMALLEST ANGLE TO SWIVEL: -180 to 180
        // double minTurn = SP - PV;
        double a = SP - PV;
        double minTurn = ( a + 180 ) % 360 - 180;

        double turnMag = Math.abs   ( minTurn );
        double turnDir = Math.signum( minTurn );

        SmartDashboard.putNumber( ModuleName + "-Turn Mag"  , turnMag   );

        // MINIMIZE WHEEL SWIVEL: +120 BECOMES -60
        // if ( Math.abs(turnMag) > 90 ) {
        //     turnMag = Math.abs(turnMag) - 180;
        //     turnDir *= -1;
        //     reverse *= -1;
        // }

        // DETERMINE POWER USING PSEUDO PID CONTROLLER
        double SteerRatio = 0;

        if      ( Math.abs(turnMag) > 20 ) { SteerRatio = 0.80; }
        else if ( Math.abs(turnMag) > 10 ) { SteerRatio = 0.25; }
        else if ( Math.abs(turnMag) >  5 ) { SteerRatio = 0.08; }
        else if ( Math.abs(turnMag) >  1 ) { SteerRatio = Math.abs(turnMag) / 100; }
        else                               { SteerRatio = 0.00; }

        SmartDashboard.putNumber( ModuleName + "-SteerRatio", SteerRatio );
        SmartDashboard.putNumber( ModuleName + "-Turn Dir"  , turnDir   );

        SmartDashboard.putNumber( ModuleName + "-Absolute", SteerEncoder.GetDirection() );

        double Dpower = DriveRatio * 7 * reverse;
        double Spower = SteerRatio * 7 * turnDir;

        SmartDashboard.putNumber( ModuleName + "-D_Power", Dpower );
        SmartDashboard.putNumber( ModuleName + "-S_Power", Spower );

        // SET MOTOR CONTROLLERS
        DriveMotor.setVoltage( Dpower );
        SteerMotor.setVoltage( Spower );
    }

}
