// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  public CANSparkMax turretRotator = new CANSparkMax(11, MotorType.kBrushless); //make sure to find the actual deviceID
  public CANSparkMax invertedTurretRotator = new CANSparkMax(12, MotorType.kBrushless); //make sure to find the actual deviceID
  public CANSparkMax feeder = new CANSparkMax(10, MotorType.kBrushless); //make sure to find the actual deviceID

  private PIDController rotatationPidController = new PIDController(0, 0, 0); //Makes a PID controller for turret rotation (put pid values in later)

  public Turret() {}

  void rotate(double rotationSpeed){ 
    //Rotate the turret with manual input
    turretRotator.set(MathUtil.clamp(rotationSpeed, -1, 1));
    invertedTurretRotator.set(MathUtil.clamp(rotationSpeed, -1, 1));
  }
  public void feed(){
    //feeder motor runs
    feeder.set(Constants.Turret.feederSpeed);
  }
  public void reversefeed(){
    //feeder motor runs opposite
    feeder.set(Constants.Turret.reverseFeederSpeed);
  }
  void holdfeeder(){
    //holds feeder motor in place
    feeder.set(Constants.Turret.staticMotor);
  }
  public void turretlock(){
    //Locks the turret's rotating motors in place
    turretRotator.set(Constants.Turret.staticMotor);
    invertedTurretRotator.set(Constants.Turret.staticMotor);
  }
  public void setangle(double targetAngle){
    //Allows you set a certain rotation angle in your code
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
