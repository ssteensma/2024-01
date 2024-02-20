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

    public double      reverse = 1;

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

    public void Display() {
        SmartDashboard.putNumber( ModuleName + "-Speed", DriveMotor.getVelocity().getValueAsDouble() );
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
        SmartDashboard.putNumber( ModuleName + "-SP", SP );

        // SMALLEST ANGLE TO TURN: -180 to 180
        double a = SP - PV;
        double minTurn = ( a + 180 ) % 360 - 180;

        double turnMag = Math.abs   ( minTurn );
        double turnDir = Math.signum( minTurn );

        if ( turnMag > 90 && turnMag <= 180 ) {
            turnMag = 180 - turnMag;
            reverse = -1;
        }

        SmartDashboard.putNumber( ModuleName + "-Turn Mag"  , turnMag   );

        // DETERMINE POWER USING PSEUDO PID CONTROLLER
        double SteerRatio = Math.abs( turnMag ) / 80;
        if ( SteerRatio > 0.50 ) { SteerRatio = 0.20; }

        // if      ( Math.abs(turnMag) > 20 ) { SteerRatio = 0.80; }
        // else if ( Math.abs(turnMag) > 10 ) { SteerRatio = 0.25; }
        // else if ( Math.abs(turnMag) >  5 ) { SteerRatio = 0.08; }
        // else if ( Math.abs(turnMag) >  1 ) { SteerRatio = Math.abs(turnMag) / 100; }
        // else                               { SteerRatio = 0.00; }

        SmartDashboard.putNumber( "Swerve/" + ModuleName + "-SteerRatio", SteerRatio );
        SmartDashboard.putNumber( "Swerve/" + ModuleName + "-Turn Dir"  , turnDir   );

        SmartDashboard.putNumber( "Swerve/" + ModuleName + "-Absolute", SteerEncoder.GetDirection() );

        double Dpower = DriveRatio * 7 * reverse;
        double Spower = SteerRatio * 7 * turnDir;

        SmartDashboard.putNumber( "Swerve/" + ModuleName + "-D_Power", Dpower );
        SmartDashboard.putNumber( "Swerve/" + ModuleName + "-S_Power", Spower * reverse );

        // SET MOTOR CONTROLLERS
        DriveMotor.setVoltage( Dpower );
        SteerMotor.setVoltage( Spower * reverse );
    }

}
