package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;

public class Idle extends CommandBase {
    private final Indexer indexer;

    public Idle(Indexer i) {
        this.indexer = i;
        addRequirements(i);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        indexer.run(0);
    }

}
