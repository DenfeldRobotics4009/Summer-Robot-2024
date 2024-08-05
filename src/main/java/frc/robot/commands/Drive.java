package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Controls;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
   
boolean twistToggle = true;
  final DriveTrain driveTrain;
  final Controls controls;
  /** Creates a new Drive. */
  public Drive(DriveTrain driveTrain, Controls controls) {
    this.driveTrain = driveTrain;
    this.controls = controls;
    addRequirements(driveTrain);
  }    @Override
    public void execute(){
        driveTrain.drive(controls.getForward() * 0.6, 0 * 0.5);

    }
}
