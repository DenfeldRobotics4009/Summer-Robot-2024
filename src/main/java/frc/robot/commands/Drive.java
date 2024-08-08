package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Controls;
import frc.robot.subsystems.DriveTrain;

public class Drive extends CommandBase{
   
  final DriveTrain driveTrain;
  final Controls controls;
  /** Creates a new Drive. */
  public Drive(DriveTrain driveTrain, Controls controls) {
    this.driveTrain = driveTrain;
    this.controls = controls;
    addRequirements(driveTrain);
  }   
  //called when the command is initially scheduled
      @Override
  public void initialize(){}
  //called every time the scheduler runs while the command is scheduled
      @Override
    public void execute(){
        driveTrain.drive(controls.getForward() * 0.6);

    }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}