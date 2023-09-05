package frc.robot.commands.LEDs;



import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDs;

public class IdleLED extends CommandBase {
  private final LEDs lights;

  /** Creates a new IdleLED. */
  public IdleLED(LEDs L) {
    this.lights = L;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(L);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // call LED commands for ones that need to stay on here and move on w/ your
    // life. also yes, you can combine colors to make other colors
    lights.setPurple();
    
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if u wanna do some funny business w/ like the flap leds go wack whenever it
    // takes in a gear in the reveal u can
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
