package frc.robot.System;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Wheel {

    public static double
        kWheelRadiusInches      = 0,
        kGearRatio              = 0,
        kCountsPerRev           = 0,
        k100msPerSecond         = 0,
        kMotorRotationsPer100ms = 0;

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

        // DEFINE AND CONFIGURE STEER MOTOR
        SteerMotor = new TalonFX( CAN_ID[1] );
        SteerMotor.setNeutralMode( NeutralModeValue.Brake );
    
        // DEFINE AND CONGIRUE STEER ENCODER
        SteerEncoder = new CANcoder( CAN_ID[2] );
    }

    public double GetDirection() {
        return SteerEncoder.getAbsolutePosition().getValueAsDouble() * 360;
    }

    public double GetPower() { return DrvPwr; }

    public double GetSpeed () {
        return Math.abs( DriveMotor.getVelocity().getValueAsDouble() / 105 );
    }

    private int DistanceToNativeUnits( double positionMeters ) {
        double wheelRotations = positionMeters/(2 * Math.PI * Units.inchesToMeters( kWheelRadiusInches ) );
        double motorRotations = wheelRotations * kGearRatio;
        int sensorCounts = (int)(motorRotations * kCountsPerRev);
        return sensorCounts;
      }
    
      private int VelocityToNativeUnits( double velocityMetersPerSecond ) {
        double wheelRotationsPerSecond = velocityMetersPerSecond/(2 * Math.PI * Units.inchesToMeters( kWheelRadiusInches ) );
        double motorRotationsPerSecond = wheelRotationsPerSecond * kGearRatio;
        double motorRotationsPer100ms = motorRotationsPerSecond / k100msPerSecond;
        int sensorCountsPer100ms = (int)(motorRotationsPer100ms * kCountsPerRev);
        return sensorCountsPer100ms;
      }
    
      private double NativeUnitsToDistanceMeters( double sensorCounts ) {
        double motorRotations = (double)sensorCounts / kCountsPerRev;
        double wheelRotations = motorRotations / kGearRatio;
        double positionMeters = wheelRotations * (2 * Math.PI * Units.inchesToMeters( kWheelRadiusInches ) );
        return positionMeters;
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
