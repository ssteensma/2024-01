package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonRoutine.Auton;

public class Autopilot {

	public static double
		vx = 0,
		vy = 0,
		vt = 0;

	public static double
		Cos45 = Math.toRadians( 45 ),
		Sin45 = Math.toRadians( 45 ),
		ToDeg = 180 / Math.PI;

//
//	ADJUST HEADING
//
	public static double AdjustToHeading( double Heading ) {
		double Error  = Heading - Navigation.NavX.getAngle();
		double Offset = Error * -0.003;
		if ( Offset >  0.10 ) { Offset =  0.10; }
		if ( Offset < -0.10 ) { Offset = -0.10; }
		return Offset;
	}

	public static void TransToRing() {
		double X = ( CamIntake.TY() - -2 ) * -0.02;
		double Y = ( CamIntake.TX() )  * 0.02;

		if ( X >  Auton.DriveSpeed ) { X =  Auton.DriveSpeed; }
		if ( X < -Auton.DriveSpeed ) { X = -Auton.DriveSpeed; }

		Drivetrain.vx = X;
		Drivetrain.vy = Y;
		Drivetrain.vt = 0;
	}

//
// 	ALTERNATE FORM FOR DRIVE CARTESIAN
//
	public static void DriveStraight_UNTESTED ( double X, double Y ) {
		double angle = Math.atan2( Y, X ) * ToDeg;
		Drivetrain.vx = -X; Drivetrain.vy = Y; Drivetrain.vt = AdjustToHeading( angle );
	}

//
//
	public static void TransToAprilTag() {
		double X = ( 10 - CamShooter.TY() ) * 0.015;
		double Y = ( CamShooter.TX() ) * -0.01;
		double Z = 0;

		// MAXIMUM SPEED
		if ( X >  Auton.DriveSpeed ) { X =  Auton.DriveSpeed; }
		if ( X < -Auton.DriveSpeed ) { X = -Auton.DriveSpeed; }

		Drivetrain.vx = X;
		Drivetrain.vy = Y;
		Drivetrain.vt = Z;
	}

//
// TRANSLATION MOVEMENT ONLY
//
	public static void TranslateN ( double Speed ) { Drivetrain.vx = +Speed; Drivetrain.vy = 0; Drivetrain.vt = 0; }
	public static void TranslateS ( double Speed ) { Drivetrain.vx = -Speed; Drivetrain.vy = 0; Drivetrain.vt = 0; }
	public static void TranslateE_UNTESTED ( double Speed ) { Drivetrain.vx = 0; Drivetrain.vy = -Speed; Drivetrain.vt = 0; }
	public static void TranslateW_UNTESTED ( double Speed ) { Drivetrain.vx = 0; Drivetrain.vy = +Speed; Drivetrain.vt = 0; }

	// public static void Backup( double Speed ) { TranslateS( Speed ); }

//
// DRIVE BY CARDINAL COMPASS
//
	public static void DriveN_UNTESTED ( double Speed ) { Drivetrain.vx = +Speed; Drivetrain.vy = 0;      Drivetrain.vt = AdjustToHeading(   0 ); }
	public static void DriveE_UNTESTED ( double Speed ) { Drivetrain.vx = 0;      Drivetrain.vy = -Speed; Drivetrain.vt = AdjustToHeading(  90 ); }
	public static void DriveS_UNTESTED ( double Speed ) { Drivetrain.vx = -Speed; Drivetrain.vy = 0;      Drivetrain.vt = AdjustToHeading( 180 ); }
	public static void DriveW_UNTESTED ( double Speed ) { Drivetrain.vx = 0;      Drivetrain.vy = +Speed; Drivetrain.vt = AdjustToHeading( 270 ); }

//
// DRIVE BY COMPONENTS
//
	public static void DriveCartesian_UNTESTED( double X, double Y ) {
		Drivetrain.vx = -X; Drivetrain.vy = Y; Drivetrain.vt = 0;
	}

	// public static void DrivePolar( double Speed, double Degrees ) { 
	// 	Drivetrain.vx = Speed * Math.cos( Math.toRadians( Degrees ) );
	// 	Drivetrain.vy = Speed * Math.sin( Math.toRadians( Degrees ) );
	// 	Drivetrain.vt = AdjustToHeading( Degrees );
	// }


//
// DRIVE BY COMPASS HALVES
//
	public static void DriveNE_UNTESTED ( double S ) { Drivetrain.vx = -S*Cos45; Drivetrain.vy = -S*Sin45; Drivetrain.vt = AdjustToHeading(  45 ); }
	public static void DriveSE_UNTESTED ( double S ) { Drivetrain.vx = +S*Cos45; Drivetrain.vy = -S*Sin45; Drivetrain.vt = AdjustToHeading( 135 ); }
	public static void DriveSW_UNTESTED ( double S ) { Drivetrain.vx = +S*Cos45; Drivetrain.vy = +S*Sin45; Drivetrain.vt = AdjustToHeading( 225 ); }
	public static void DriveNW_UNTESTED ( double S ) { Drivetrain.vx = -S*Cos45; Drivetrain.vy = +S*Sin45; Drivetrain.vt = AdjustToHeading( 315 ); }

	public static void DriveAtBackardAtHeading( double Speed, double Heading ) {
		double Error = ( Navigation.NavX.getAngle() + 540 - Heading ) % 360 - 180;
		SmartDashboard.putNumber( "NAV ERROR", Error );

		double Power = Error * 0.007;
		if ( Power < -0.08 ) { Power = -0.10; }
		if ( Power >  0.08 ) { Power =  0.10; }
		SmartDashboard.putNumber( "NAV POWER", Power );

		Drivetrain.vx = -Speed;
		Drivetrain.vy = 0.00;
		Drivetrain.vt = Power;
	}

	public static void DriveAtForwardAtHeading( double Speed, double Heading ) {
		double Error = ( Navigation.NavX.getAngle() + 540 - Heading ) % 360 - 180;
		SmartDashboard.putNumber( "NAV ERROR", Error );

		double Power = Error * 0.007;
		if ( Power < -0.08 ) { Power = -0.10; }
		if ( Power >  0.08 ) { Power =  0.10; }
		SmartDashboard.putNumber( "NAV POWER", Power );

		Drivetrain.vx = Speed;
		Drivetrain.vy = 0.00;
		Drivetrain.vt = Power;
	}
	

//
// Stop sets the robot speed vector to zero. This is useful only in Autonomous
// mode. It should not be used elsewhere.
//
	public static void Reset() { Drivetrain.vx = 0; Drivetrain.vy = 0; Drivetrain.vt = 0; }
	public static void Stop () { Drivetrain.vx = 0; Drivetrain.vy = 0; Drivetrain.vt = 0; }

//
// These methods rotate the robot at a constant counter-clockwise speed and
// clockwise speed respectively. This is only useful in Autonomous mode.
//
	public static void TurnLftAtSpeed ( double Speed ) { Drivetrain.vx = 0; Drivetrain.vy = 0; Drivetrain.vt = +Speed; }
	public static void TurnRgtAtSpeed ( double Speed ) { Drivetrain.vx = 0; Drivetrain.vy = 0; Drivetrain.vt = -Speed; }

	public static void TurnToHeading  ( double Heading ) {
		Drivetrain.vx = 0;
		Drivetrain.vy = 0;

		double Error =  Navigation.GetError( 90 );
		double Power = Error * -0.001;
		if ( Power < -0.08 ) { Power = -0.08; }
		if ( Power >  0.08 ) { Power =  0.08; }

		Drivetrain.vt = Power;
	}
}
