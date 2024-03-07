package frc.robot.System;

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
	public static double GetError( double Heading ) {
		double Error = Heading - Navigation.GetYaw();
		return Error;
	}

	public static double AdjustToHeading( double Heading ) {
		double Error  = GetError( Heading );
		double Offset = Error * -0.007;
		if ( Offset >  0.10 ) { Offset =  0.10; }
		if ( Offset < -0.10 ) { Offset = -0.10; }
		return Offset;
	}

	public static double TurnToRing( double Speed ) {
		double Error = CamTarget.TX();
		return Error;
	}

	public static void DriveToRing() {
		double X = ( CamTarget.TY() - -20 ) * 0.02;
		double Y = 0;
		double Z = CamTarget.TX() * -0.008;
		if ( X > 0.15 ) { X = 0.15; }

		Drivetrain.vx = X;
		Drivetrain.vy = Y;
		Drivetrain.vt = Z;
	}

//
// 	ALTERNATE FORM FOR DRIVE CARTESIAN
//
	public static void DriveStraight ( double X, double Y ) {
		double angle = Math.atan2( Y, X ) * ToDeg;
		Drivetrain.vx = -X; Drivetrain.vy = Y; Drivetrain.vt = AdjustToHeading( angle );
	}

//
//
//
	public static void DriveToAprilTag() {
		double X = ( CamIntake.TY() - 17 ) * 0.007;
		double Y = ( CamIntake.TX() ) * 0.005;
		double Z = 0;		

		Drivetrain.vx = X;
		Drivetrain.vy = Y;
		Drivetrain.vt = Z;
	}

//
// TRANSLATION MOVEMENT ONLY
//
	public static void TranslateN ( double Speed ) { Drivetrain.vx = -Speed; Drivetrain.vy = 0;      Drivetrain.vt = 0; }
	public static void TranslateS ( double Speed ) { Drivetrain.vx = +Speed; Drivetrain.vy = 0;      Drivetrain.vt = 0; }
	public static void TranslateW ( double Speed ) { Drivetrain.vx = 0;      Drivetrain.vy = -Speed; Drivetrain.vt = 0; }

//
// DRIVE BY CARDINAL COMPASS
//
	public static void DriveN ( double Speed ) { Drivetrain.vx = -Speed; Drivetrain.vy = 0;      Drivetrain.vt = AdjustToHeading(   0 ); }
	public static void DriveE ( double Speed ) { Drivetrain.vx = 0;      Drivetrain.vy = +Speed; Drivetrain.vt = AdjustToHeading(  90 ); }
	public static void DriveS ( double Speed ) { Drivetrain.vx = +Speed; Drivetrain.vy = 0;      Drivetrain.vt = AdjustToHeading( 180 ); }
	public static void DriveW ( double Speed ) { Drivetrain.vx = 0;      Drivetrain.vy = -Speed; Drivetrain.vt = AdjustToHeading( 270 ); }

//
// DRIVE BY COMPONENTS
//
	public static void DriveCartesian( double X, double Y ) {
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
	public static void DriveNE ( double S ) { Drivetrain.vx = -S*Cos45; Drivetrain.vy = -S*Sin45; Drivetrain.vt = AdjustToHeading(  45 ); }
	public static void DriveSE ( double S ) { Drivetrain.vx = +S*Cos45; Drivetrain.vy = -S*Sin45; Drivetrain.vt = AdjustToHeading( 135 ); }
	public static void DriveSW ( double S ) { Drivetrain.vx = +S*Cos45; Drivetrain.vy = +S*Sin45; Drivetrain.vt = AdjustToHeading( 225 ); }
	public static void DriveNW ( double S ) { Drivetrain.vx = -S*Cos45; Drivetrain.vy = +S*Sin45; Drivetrain.vt = AdjustToHeading( 315 ); }

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
}
