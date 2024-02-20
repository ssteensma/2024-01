package frc.robot.System;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Hardware.CAN_Encoder;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Wheel {

    public String
        ModuleName;

    public CAN_Encoder
        SteerEncoder;

    public TalonFX
        DriveMotor,
        SteerMotor;

    public double
        OldPower,  NewPower,
        DriveSP,   DrivePV , DriveDiff,
        SteerSP,   SteerPV , SteerDiff, SteerRatio,
        TurnAngle, TurnDir,  TurnMag;

    public double
        reverse = 1;

    public void Display() {
        PutNum( "DrvDif", DriveDiff );
        PutNum( "StrDif", SteerDiff );
        PutNum( "Power",  NewPower  );
        PutNum( "Speed",  DriveMotor.getVelocity().getValueAsDouble() );
    }

    public void PutNum( String text, double value ) {
        SmartDashboard.putNumber( ModuleName + "-" + text, value );
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
        SteerEncoder = new CAN_Encoder( CAN_ID[2] );
    }

    public double GetDirection () {
        return SteerEncoder.GetDirection();
    }

    public double GetSpeed () {
        return Math.abs( DriveMotor.getVelocity().getValueAsDouble() );
    }

    public void UpdateDrive ( SwerveModuleState state ) {

        // CURRENT POWER
        OldPower = this.DriveMotor.getMotorVoltage().getValueAsDouble();

        // CALCULATE DRIVE VALUES
        DriveSP = state.speedMetersPerSecond;                       // Set Point
        DrivePV = this.DriveMotor.getVelocity().getValueAsDouble(); // Process Value 

        // 
        DriveDiff = DriveSP - DrivePV;

        // CALCULATE POWER DIFFERENTIAL
        NewPower = OldPower + ( DriveDiff ) * 0.001;

        // ENSURE NEW POWER IS WITHIN LIMITS
        if ( NewPower > 1 ) { NewPower = 1; }

        // SET MOTOR CONTROLLERS
        DriveMotor.setVoltage( NewPower );
    }

    public void UpdateSteer( SwerveModuleState state ) {
        reverse = 1; // This variable impacts the DrivePower

        // CALCULATE TURN VALUES
        SteerSP = state.angle.getDegrees(); // Set Point
        SteerPV = GetDirection() * 360;     // Process Value

        // SMALLEST ANGLE TO TURN: -180 to 180
        SteerDiff = SteerSP - SteerPV;
        TurnAngle = ( SteerDiff + 180 ) % 360 - 180;

        TurnMag = Math.abs   ( TurnAngle );
        TurnDir = Math.signum( TurnAngle );

        // TURN +60 INSTEAD OF -120 AND REVERSE DIRECTION 
        if ( TurnMag > 90 && TurnMag <= 180 ) {
            TurnMag = 180 - TurnMag;
            reverse = -1;
        }

        // TURN POWER USING PSEUDO PID CONTROLLER
        SteerRatio = Math.abs( TurnMag ) * 0.00125;
        if ( SteerRatio > 0.50 ) { SteerRatio = 0.20; }
    
        // SET MOTOR CONTROLLERS
        SteerMotor.setVoltage( SteerRatio * 7 * TurnDir );
    }

}
