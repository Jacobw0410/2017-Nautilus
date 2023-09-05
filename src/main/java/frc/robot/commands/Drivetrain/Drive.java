package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;

public class Drive extends CommandBase {
  private final Drivetrain drivetrain;
  private final XboxController d_controller;

  // Creates drive train command
  public Drive(Drivetrain drivetrain, XboxController d_controller) {
    this.drivetrain = drivetrain;
    this.d_controller = d_controller;

    addRequirements(drivetrain);
  }

  // Solenoid for Drive train
  @Override
  public void initialize() {
    drivetrain.setSolenoids();
  }

  // Configure Drivetrain Command
  @Override
  public void execute() {

    drivetrain.drive(d_controller.getRawAxis(1) * 0.85, d_controller.getRawAxis(4) * 0.85);

    if (!(d_controller.getRightTriggerAxis() > .05)
        && ((d_controller.getRawAxis(0) > .05) || (d_controller.getRawAxis(0) < -.05))) {

      // Deploys H-Drive
      drivetrain.h_deploy();

      // Spins h-Drive
      drivetrain.h_spin(d_controller.getRawAxis(0));
    }

    // retract H-Drive mechanism
    else {
      drivetrain.retract_H();
      drivetrain.h_spin(0);

    }
    // deploy tank
    if (d_controller.getLeftTriggerAxis() > .05) {
      drivetrain.tank();
    }
    // retract tank
    else {
      drivetrain.retract_tank();
    }

  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
