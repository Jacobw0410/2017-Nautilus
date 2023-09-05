// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {


  private final VictorSP m_leftBackMotor;
  private final VictorSP m_leftFrontMotor;
  private final VictorSP m_rightBackMotor;
  private final VictorSP m_rightFrontMotor;
  private final VictorSP m_hDriveMotor;
  private final MotorControllerGroup m_leftDrivetrainMotors;
  private final MotorControllerGroup m_rightDrivetrainMotors;
  private final DifferentialDrive m_drive;
  

  private Solenoid h_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Drivetrain.hSolenoidID);
  private Solenoid front_piston = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Drivetrain.grasshopperSolenoidID);
  

  public Drivetrain(CommandXboxController m_driverController) {
    m_leftBackMotor = new VictorSP(Constants.Drivetrain.leftBackMotorID);
    m_leftFrontMotor = new VictorSP(Constants.Drivetrain.leftFrontMotorID);
    m_rightBackMotor = new VictorSP(Constants.Drivetrain.rightBackMotorID);
    m_rightFrontMotor = new VictorSP(Constants.Drivetrain.rightFrontMotorID);
    m_hDriveMotor = new VictorSP(Constants.Drivetrain.DriveMotorID);
    m_leftDrivetrainMotors = new MotorControllerGroup(m_leftBackMotor, m_leftFrontMotor);
    m_rightDrivetrainMotors = new MotorControllerGroup(m_rightBackMotor, m_rightFrontMotor);
    m_leftDrivetrainMotors.setInverted(true);

    m_drive = new DifferentialDrive(m_leftDrivetrainMotors, m_rightDrivetrainMotors);

  }

  // pneumatic pistons

  public void setSolenoids() {
    h_piston.set(false);
    front_piston.set(false);
  }

  public void retract_tank() {
    front_piston.set(false);
  }

  public void retract_H() {
    h_piston.set(false);
  }

  public void tank() {
    front_piston.set(true);
  }

  // motors for H drive

  public void h_spin(double output) {
    m_hDriveMotor.set(output);
  }

  public void h_deploy() {
    h_piston.set(true);
  }

  public void drive(double x, double y) {
    m_drive.arcadeDrive(-x, -y);
  }

  public void run(double m_leftBackMotoroutput, double m_leftFrontMotoroutput, double m_rightFrontMotoroutput,
      double m_rightBackMotoroutput) {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
