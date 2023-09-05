package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private Solenoid walls;
    private Solenoid push;
    private Solenoid flap;

    public Intake() {

        walls = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.wallsSolenoidID);
        push = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.pusherSolenoidID);
        flap = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Intake.flapSolenoidID);

    }

    public void actuatewalls() {
        walls.set(true);
    }

    public void move() {
        push.set(true);
    }

    public void backMove() {
        push.set(false);
    }

    public void Tabout() {
        flap.set(true);
    }

    public void Tabin() {
        flap.set(false);
    }

    public void retractwalls() {
        walls.set(false);
    }

    public void setSolenoids() {
        walls.set(false);
        push.set(false);
        flap.set(false);
    }

    @Override
    public void periodic() {
    }
}
