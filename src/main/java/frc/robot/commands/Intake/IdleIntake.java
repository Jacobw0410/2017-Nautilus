package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;

public class IdleIntake extends CommandBase{
    private final Intake piston;
    public IdleIntake(Intake i){
        this.piston=i;
        addRequirements(i);
    }
    
    @Override
    public void initialize(){
        piston.setSolenoids();
    }
    @Override
    public void execute(){
        
    }
    @Override
    public void end(boolean interrupted){
        piston.setSolenoids();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
