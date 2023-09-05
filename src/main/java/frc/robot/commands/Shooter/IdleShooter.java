package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class IdleShooter extends CommandBase {
    private final Shooter shooter;

    public IdleShooter(Shooter s) {
        this.shooter = s;
        addRequirements(s);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooter.run(0);
    }
}
