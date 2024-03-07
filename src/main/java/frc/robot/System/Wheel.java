package frc.robot.System;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Wheel {

    public static double
        kWheelRadiusInches      = 2,
        kGearRatio              = 14, 
        kCountsPerRev           = 2048,
        k100msPerSecond         = 10,
        kWheelCircumference     = 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches),
        kRotationsPerMetre      = 1 / kWheelCircumference;

    public String
        ModuleName;

    public CANcoder
        SteerEncoder;

    public TalonFX
        DriveMotor,
        SteerMotor;

    public double
        DrvSP, DrvPV, DrvPwr, DrvErr,
        StrSP, StrPV, StrPwr, StrErr,
        TurnAng, TurnDir, TurnMag;

    public double
        reverse  = 1;

    public void Reset() {
        DrvPwr = 0; DrvSP = 0;
        StrPwr = 0; StrSP = 0;
    }

    public SwerveModulePosition GetPosition() {
        return new SwerveModulePosition(
            DriveMotor.getPosition().getValueAsDouble(),
            new Rotation2d( SteerEncoder.getPosition().getValueAsDouble() )
        );
    }

    public Wheel ( String ModuleName, int[] CAN_ID ) {
        this.ModuleName   = ModuleName;

        // DEFINE AND CONFIGURE DRIVE MOTOR
        DriveMotor = new TalonFX( CAN_ID[0] );
        DriveMotor.setNeutralMode( NeutralModeValue.Brake );
        DriveMotor.setPosition( 0.00 );
        TalonFXConfiguration DriveConfig = new TalonFXConfiguration();
            DriveConfig.Slot0.kP = 0;
            DriveConfig.Slot0.kI = 0;
            DriveConfig.Slot0.kD = 0;
            DriveConfig.Slot0.kV = 0;
            DriveConfig.Voltage.PeakForwardVoltage =  8;
            DriveConfig.Voltage.PeakReverseVoltage = -8;

            /* Torque-based velocity does not require a feed forward, as torque will accelerate the rotor up to the desired velocity by itself */
            DriveConfig.Slot1.kP = 5;     // An error of 1 rotation per second results in 5 amps output
            DriveConfig.Slot1.kI = 0.1;   // An error of 1 rotation per second increases output by 0.1 amps every second
            DriveConfig.Slot1.kD = 0.001; // A change of 1000 rotation per second squared results in 1 amp output

            /* Retry config apply up to 5 times, report if failure */
            StatusCode status = StatusCode.StatusCodeNotInitialized;
            for (int i = 0; i < 5; ++i) {
                status = DriveMotor.getConfigurator().apply( DriveConfig );
                if (status.isOK()) break;
            }
            if(!status.isOK()) {
                System.out.println("Could not apply configs, error code: " + status.toString());
            }

        // DEFINE AND CONFIGURE STEER MOTOR
        SteerMotor = new TalonFX( CAN_ID[1] );
        SteerMotor.setNeutralMode( NeutralModeValue.Brake );
    
        // DEFINE AND CONGIRUE STEER ENCODER
        SteerEncoder = new CANcoder( CAN_ID[2] );

            SteerEncoder.setPosition( 0.00 );
    }

    public double GetDirection() {
        return SteerEncoder.getAbsolutePosition().getValueAsDouble() * 360;
    }

    public double GetPower() { return DrvPwr; }

    public double GetSpeed () {
        return Math.abs( DriveMotor.getVelocity().getValueAsDouble() / 105 );
    }

    public int DistanceToNativeUnits( double PositionMeters ) {
        double WheelRotations = PositionMeters / kWheelCircumference;
        double MotorRotations = WheelRotations * kGearRatio;
        int    SensorCounts   = (int)(MotorRotations * kCountsPerRev);
        return SensorCounts;
    }
    
    public int VelocityToNativeUnits( double VelocityMetersPerSecond ) {
        double WheelRotationsPerSecond = VelocityMetersPerSecond / kWheelCircumference;
        double MotorRotationsPerSecond = WheelRotationsPerSecond * kGearRatio;
        double MotorRotationsPer100ms  = MotorRotationsPerSecond / k100msPerSecond;
        int    SensorCountsPer100ms    = (int)(MotorRotationsPer100ms * kCountsPerRev);
        return SensorCountsPer100ms;
    }
    
    public double NativeUnitsToDistanceMeters( double SensorCounts ) {
        double MotorRotations = (double)SensorCounts / kCountsPerRev;
        double WheelRotations = MotorRotations / kGearRatio;
        double PositionMeters = WheelRotations * kWheelCircumference;
        return PositionMeters;
    }

    public void UpdateDrive ( SwerveModuleState state ) {

        DrvSP  = state.speedMetersPerSecond;
        DrvPV  = Math.abs( DriveMotor.getVelocity().getValueAsDouble() / 105 );

        // PID CONTROLLER
        DrvErr =  DrvSP  - DrvPV;

        double Factor = 0.10;
        if ( Math.abs( DrvErr ) < 0.01 ) { Factor = 0.00002; }  

        DrvPwr += DrvErr * Factor;

        SmartDashboard.putNumber( ModuleName + "NEW Drv SP", DrvSP );
        SmartDashboard.putNumber( ModuleName + "NEW Drv PV", DrvPV );

        if ( DrvSP == 0 ) { DrvPwr = 0; } 

        if ( ModuleName == "RR" ) {
            SmartDashboard.putNumber( ModuleName + "Drive Factor", Factor );
            SmartDashboard.putNumber( ModuleName + "Drive Power", DrvPwr );
            SmartDashboard.putNumber( ModuleName + "Drive Error", DrvErr );
            SmartDashboard.putNumber( ModuleName + "Drive Reverse", reverse );
        }

        DriveMotor.set( DrvPwr * reverse );
    }

    public void UpdateSteer( SwerveModuleState state ) {
        reverse = 1; // This variable impacts the DrivePower

        StrSP  = state.angle.getDegrees();
        StrPV  = GetDirection();    

        TurnAng = ( StrSP + 360 - StrPV + 180 ) % 360 - 180;
        TurnMag = Math.abs   ( TurnAng );
        TurnDir = Math.signum( TurnAng );

        if      ( TurnMag >=   0 && TurnMag <   90 ) { }
        else if ( TurnMag >=  90 && TurnMag <= 180 ) { TurnMag = 180 - TurnMag; reverse = -1; }
        else if ( TurnMag >= 180 && TurnMag <= 270 ) { TurnMag = TurnMag - 180; reverse = -1; }
        else if ( TurnMag >= 270 && TurnMag <  360 ) { TurnMag = 360 - TurnMag; reverse = -1; }
        else if ( TurnMag <    0 && TurnMag >= -90 ) { }
        else if ( TurnMag <  -90 && TurnMag > -180 ) { TurnMag = 180 - TurnMag; reverse = -1; }
        else if ( TurnMag == -180                  ) { TurnMag = 0;             reverse = -1; }

        // PID CONTROLLER
        StrPwr = Math.abs( TurnMag ) * 0.01;

        if ( StrPwr < -0.35 ) { StrPwr = -0.35;  }
        if ( StrPwr >  0.35 ) { StrPwr =  0.35;  }

            SmartDashboard.putNumber( ModuleName + "-TurnAng", TurnAng );
            SmartDashboard.putNumber( ModuleName + "-TurnMag", TurnMag );
            SmartDashboard.putNumber( ModuleName + "-TurnDir", TurnDir );
            SmartDashboard.putNumber( ModuleName + "-Str Pwr", StrPwr  );

        SteerMotor.set( StrPwr * TurnDir );
    }

}
