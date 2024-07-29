package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class DriveTrain {
    private DifferentialDrive TankDrive;
    //TODO: Find actual sparkmax channels
    private final PWMSparkMax frontLeftMax = new PWMSparkMax(0);
    private final PWMSparkMax frontRightMax = new PWMSparkMax(1);
    private final PWMSparkMax backLeftMax = new PWMSparkMax(2);
    private final PWMSparkMax backRightMax = new PWMSparkMax(3);
    public void DriveTrain(){
        TankDrive = new DifferentialDrive(frontLeftMax, frontRightMax);
        backLeftMax.addFollower(frontLeftMax);
        backRightMax.addFollower(frontRightMax);
        //TODO:find which side needs to be inverted


        
    }
    // public void drive(double Forward, double Twist) {

    //     frontLeftMax.set(clamp(Forward + Twist, -1, 1));
    //     backLeftMax.set(clamp(Forward + Twist, -1, 1));
    
    //     frontRightMax.set(-clamp(Forward - Twist, -1, 1));
    //     backRightMax.set(-clamp(Forward - Twist, -1, 1));    
    //   }
}
