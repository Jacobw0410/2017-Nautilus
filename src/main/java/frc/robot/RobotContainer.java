// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Drivetrain.Drive;
import frc.robot.commands.Indexer.Idle;
import frc.robot.commands.Indexer.Index;
import frc.robot.commands.Indexer.ReverseIndexer;
import frc.robot.commands.Intake.DeployIntake;
import frc.robot.commands.Intake.IdleIntake;
import frc.robot.commands.Intake.Tab;
import frc.robot.commands.LEDs.IdleLED;
import frc.robot.commands.Shooter.FarShot;
import frc.robot.commands.Shooter.IdleShooter;
import frc.robot.commands.Shooter.ManualShooter;
import frc.robot.commands.Shooter.Shoot;
import frc.robot.commands.Shooter.PrimeShooter;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private CommandXboxController mDriverController = new CommandXboxController(0);
  private CommandXboxController mOperatorController = new CommandXboxController(1);
  private final Drivetrain mDrivetrain = new Drivetrain(mDriverController);
  private final Shooter mShooter = new Shooter();
  private final Indexer mIndexer = new Indexer();
  private Intake mIntake;
  private LEDs mLEDs;
  public final XboxController d_Controller = new XboxController(0);
  public final XboxController m_Controller = new XboxController(1);

  

  public RobotContainer() {
    
    mDrivetrain.setDefaultCommand(new Drive(mDrivetrain, d_Controller));

    mShooter.setDefaultCommand(new IdleShooter(mShooter));

    mIndexer.setDefaultCommand(new Idle(mIndexer));

    mIntake = new Intake();
    mIntake.setDefaultCommand(new IdleIntake(mIntake));

    mLEDs = new LEDs();
    mLEDs.setDefaultCommand(new IdleLED(mLEDs));
    
    




    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    mOperatorController.x().whileTrue(new Shoot(mShooter));
    mOperatorController.rightTrigger().whileTrue(new Index(mIndexer));
    mOperatorController.leftTrigger().whileTrue(new ReverseIndexer(mIndexer));
    mOperatorController.pov(0).onTrue(new InstantCommand(mShooter::addRPM));
    mOperatorController.pov(180).onTrue(new InstantCommand(mShooter::addRPM));
    mOperatorController.rightBumper().and(mOperatorController.pov(270)).whileTrue(new FarShot(mShooter));
    mOperatorController.pov(90).whileTrue(mShooter.farSpeed());
    mOperatorController.pov(45).whileTrue(mShooter.lowSpeed());
    mOperatorController.pov(270).whileTrue(mShooter.midSpeed());
    mOperatorController.rightBumper().and(mOperatorController.pov(90)).whileTrue(mShooter.superFarSpeed());
    mOperatorController.rightBumper().and(mOperatorController.x()).whileTrue(new DeployIntake(mIntake));
    mOperatorController.rightBumper().and(mOperatorController.a()).whileTrue(new Tab(mIntake));
    mDriverController.b().whileTrue(new Shoot(mShooter).alongWith(new Index(mIndexer)));
    mDriverController.rightBumper().whileTrue(new PrimeShooter(mShooter));
    mOperatorController.leftBumper().whileTrue(new ManualShooter(mShooter, mOperatorController));
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
