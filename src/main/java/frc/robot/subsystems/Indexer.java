package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//creates indexer subsystem
public class Indexer extends SubsystemBase {
    private ShuffleboardTab indexerTab = Shuffleboard.getTab("Indexer");
    private VictorSP motor = new VictorSP(Constants.Indexer.indexerMotorID);
    boolean inverted = true;
    
    
    public Indexer() {
        // inverts indexer motor
    
        motor.setInverted(true);
    }

    public void run(double output) {
        motor.set(output);
    }

    public void reverse() {
        motor.setInverted(false);
    }

    public void unreverse() {
        motor.setInverted(true);
    }
    

    @Override
    public void periodic() {
    }

}
