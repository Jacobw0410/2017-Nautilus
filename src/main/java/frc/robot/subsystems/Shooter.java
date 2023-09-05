package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//shooter subsystem

public class Shooter extends SubsystemBase {

  private ShuffleboardTab shootTab = Shuffleboard.getTab("Shooter");

  private GenericEntry dashSetRPM = shootTab.add("Goal RPM:", 0).withPosition(0, 1).getEntry();

  private GenericEntry dashCurrentRPM = shootTab.add("Current RPM:", 0).withPosition(1, 1).getEntry();

  private GenericEntry dashPrime = shootTab.add("Priming?", false).withPosition(2, 1).getEntry();

  private GenericEntry manualRPM = shootTab.add("Manual RPM: ", 0).withPosition(0, 3)
      .withWidget(BuiltInWidgets.kTextView).getEntry();

  private GenericEntry dashAddedRPM = shootTab.add("Added RPM:", 0).withPosition(1, 3).getEntry();

  private TalonSRX Shooter = new TalonSRX(Constants.Shooter.shooterMotorID);

  public double addedPercent = 0;

  private boolean isPriming;

  private boolean ntUpdatePID;

  // pid stuff rheeeeee
  public Shooter() {
    Shooter.setInverted(true);

    Shooter.configFactoryDefault();

    Shooter.configPeakOutputForward(1);

    Shooter.configPeakOutputReverse(-1);

    Shooter.config_kP(0, Constants.Shooter.kP);

    Shooter.config_kI(0, Constants.Shooter.kI);

    Shooter.config_kD(0, Constants.Shooter.kD);

    Shooter.config_kF(0, Constants.Shooter.kF);

    Shooter.config_IntegralZone(0, Constants.Shooter.kIzone);

    ntUpdatePID = false;

  }

  private double goalRPM;

  public double addedRPM = 0;

  // adds RPM
  public void addRPM() {

    addedRPM += 100;

  }

  // removes RPM
  public void loseRPM() {

    addedRPM -= 100;

  }

  public double getRPM() {
    return Shooter.getSelectedSensorVelocity();
  }

  public void run(double speed) {

  }

  // gets goal RPM
  public double getGoalRPM() {
    return goalRPM;
  }

  // Sets RPM
  public void setRPM(double RPM) {
    goalRPM = RPM;
    Shooter.set(TalonSRXControlMode.Velocity, goalRPM);
  }

  // Manually Sets RPM
  public void setManualRPM() {
    goalRPM = manualRPM.getDouble(0);
    Shooter.set(TalonSRXControlMode.Velocity, goalRPM);
  }

  // IDLE shooter flywheel
  public void idleShooter() {
    Shooter.set(ControlMode.PercentOutput, Constants.Shooter.idlePercent);

  }

  // stops flywheel
  public void stopShooter() {
    Shooter.set(ControlMode.PercentOutput, 0.0);
  }

  // Primes flywheel
  public void setPriming(boolean priming) {
    dashPrime.setBoolean(priming);
  }

  public CommandBase farSpeed() {
    return this.run(() -> {
      setRPM(Constants.Shooter.farSpeed);
    });
  }

  // sets midSpeed
  public CommandBase midSpeed() {
    return this.run(() -> {
      setRPM(Constants.Shooter.midSpeed);
    });
  }

  // sets super far speed
  public CommandBase superFarSpeed() {
    return this.run(() -> {
      setRPM(Constants.Shooter.superFarSpeed);
    });
  }

  // sets superspeed NEOWWWWW
  public CommandBase superSpeed() {
    return this.run(() -> {
      setRPM(Constants.Shooter.superSpeed);
    });
  }

  // low speed (old grandpa)
  public CommandBase lowSpeed() {
    return this.run(() -> {
      setRPM(Constants.Shooter.lowSpeed);
    });
  }

  public void setOutput(double percentOutput) {
    Shooter.set(TalonSRXControlMode.PercentOutput, percentOutput);

  }

  // updates shuffleboard dashboard
  private void updateDash() {
    dashSetRPM.setDouble(goalRPM);
    dashCurrentRPM.setDouble(getRPM());
    dashPrime.setBoolean(isPriming);
    dashAddedRPM.setDouble(addedRPM);
  }

}
