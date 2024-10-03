// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  public CANSparkMax turretRotator = new CANSparkMax(11, MotorType.kBrushless); //make sure to find the actual deviceID
  public CANSparkMax invertedTurretRotator = new CANSparkMax(12, MotorType.kBrushless); //make sure to find the actual deviceID
  public CANSparkMax feeder = new CANSparkMax(10, MotorType.kBrushless); //make sure to find the actual deviceID
  public Turret() {}

  void manualrotate(){ //make this work

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
  void turretlock(){
  //Sets turret rotators to 0 
  }
  void setangle(){}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
