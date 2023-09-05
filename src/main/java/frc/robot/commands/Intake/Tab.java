package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class Tab extends CommandBase{
    private final Intake system;
    public Tab(Intake i){
        this.system=i;
        addRequirements(i);
    }
    @Override
    public void initialize(){
        system.Tabout();
    }
    @Override
    public void execute(){}
    @Override
    public void end(boolean interrupted){
        system.Tabin();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
