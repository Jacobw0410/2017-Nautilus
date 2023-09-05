
package frc.robot;

public final class Constants {
    public static final class Indexer {
        // motors
        public static final int indexerMotorID = 6;
        public static final double indexerSpeedPercent = 1 / 3;
    }

    public static final class Shooter {
        public static final double kP = 0.3;
        public static final double kI = 0.001;
        public static final double kD = 0.0;
        public static final double kF = 0.049;
        public static final double kIzone = 200.0;
        public static final int shooterMotorID = 5;
        public static final double shooterBaseSpeedPercent = .5;
        public static final double farSpeed = 1100.0;
        public static final double midSpeed = 850.0;
        public static final double lowSpeed = 350.0;
        public static final double superFarSpeed = 2000.0;
        public static final double superSpeed = 3200.0;
        public static final double lowShootRPM = 2000;
        public static final double wallShootRPM = 8350;
        
        public static double idlePercent;

        public void setOutput(double rightY) {
        }
    }

    public static final class Drivetrain {
        // motors
        public static final int leftBackMotorID = 0;
        public static final int leftFrontMotorID = 1;
        public static final int rightBackMotorID = 2;
        public static final int rightFrontMotorID = 3;
        public static final int DriveMotorID = 4;
        // pneumatics
        public static final int hSolenoidID = 1;
        public static final int grasshopperSolenoidID = 0;
        
    }
    public static final class Intake{
        //pneumatics
        public static final int wallsSolenoidID = 4;
        public static final int pusherSolenoidID = 2;
        public static final int flapSolenoidID = 5;
    }
    public static final class Vision {
        public static final double[] tagLocations = {
          0.0, -6.94659, -5.27019, -3.59379, -1.26839, -1.26839, -3.59379, -5.27019, -6.94659
        };
    }

    
}
