package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;


public class DeployIntake extends CommandBase{
    private final Intake system;
    public DeployIntake(Intake i){
        this.system=i;
        addRequirements(i);
    }
    @Override
    public void initialize(){
        system.actuatewalls();
        system.move();
    
    }
    @Override
    public void execute(){}
    @Override
    public void end(boolean interrupted){
        system.retractwalls();
        system.backMove();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
