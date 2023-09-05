package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Indexer;

public class Index extends CommandBase {
    private final Indexer indexer;

    public Index(Indexer i) {
        this.indexer = i;
        addRequirements(i);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        indexer.unreverse();
        indexer.run(Constants.Indexer.indexerSpeedPercent);
    }

}
