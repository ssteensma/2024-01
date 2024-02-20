package frc.robot.System;

public class Autopilot {

	public static double LastHeading = 0;

	public static double vx = 0; // + North
	public static double vy = 0; // + East
	public static double vt = 0; // + Clockwise

//
// 	ALTERNATE FORM FOR DRIVE CARTESIAN
//
	public static void DriveStraight ( double X, double Y ) {
		vx = X; vy = Y; vt = 0;
	}

//
// DRIVE BY CARDINAL COMPASS
//
	public static void DriveNorth ( double Speed ) {
		vx = +Speed; vy = 0; vt = 0;
	}

	public static void DriveSouth ( double Speed ) {
		vx = -Speed; vy = 0; vt = 0;
	}

	public static void DriveWest ( double Speed ) {
		vx = 0; vy = -Speed; vt = 0;
	}

	public static void DriveEast ( double Speed ) {
		vx = 0; vy = +Speed; vt = 0;
	}

//
// DRIVE BY COMPONENTS
//
	public static void DriveCartesian( double X, double Y ) {
		vx = X; vy = Y; vt = 0;
	}

	public static void DrivePolar( double Speed, double Degrees ) { 
		double Radians = Math.toRadians( Degrees );
		vx = Speed * Math.cos( Radians );
		vy = Speed * Math.sin( Radians );
		vt = 0;
	}


//
// DRIVE BY COMPASS HALVES
//
	public static void DriveNorthWest ( double Speed ) {
		double radians = Math.toRadians( 45 );
		double speed   = Speed * Math.cos( radians );
		vx = +speed; vy = +speed; vt = 0;
	}

	public static void DriveNorthEast ( double Speed ) {
		double radians = Math.toRadians( 45 );
		double speed   = Speed * Math.cos( radians );
		vx = +speed; vy = -speed; vt = 0;
	}

	public static void DriveSouthWest ( double Speed ) {
		double radians = Math.toRadians( 45 );
		double speed   = Speed * Math.cos( radians );
		vx = -speed; vy = +speed; vt = 0;
	}

	public static void DriveSouthEast ( double Speed ) {
		double radians = Math.toRadians( 45 );
		double speed   = Speed * Math.cos( radians );
		vx = -speed; vy = -speed; vt = 0;
	}

//
// Stop sets the robot speed vector to zero. This is useful only in Autonomous
// mode. It should not be used elsewhere.
//
	public static void Stop () {
		vx = 0; vy = 0; vt = 0;
	}

//
// These methods rotate the robot at a constant counter-clockwise speed and
// clockwise speed respectively. This is only useful in Autonomous mode.
//
	// TESTED
	public static void TurnLeftAtSpeed ( double Speed ) {
		vx = 0; vy = 0; vt = -Speed;
	}

	// TESTED
	public static void TurnRightAtSpeed ( double Speed ) {
		vx = 0; vy = 0; vt = +Speed;
	}
    
}
