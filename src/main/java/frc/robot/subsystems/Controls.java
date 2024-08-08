package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controls {
    XboxController drive = new XboxController(0);


    public Controls() {}

    public double getForward() {
        return deadBand(-drive.getLeftY(),0.15);
    }

    public double getTurn() {
        return deadBand(drive.getLeftX(), 0.15);
    }
    public boolean getPrescisionMode() {
        return drive.getRightBumper();
    }
    public boolean setTurn() {
        return drive.getRawButton(7);
    }

    static double deadBand(double raw, double deadband) {

        if (Math.abs(raw)<deadband) return 0;

        return Math.signum(raw)*(Math.abs(raw)-deadband)/(1-deadband);
    }
}
