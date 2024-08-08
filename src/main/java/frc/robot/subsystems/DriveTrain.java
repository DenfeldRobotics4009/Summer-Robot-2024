// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  CANSparkMax 
    left1 = new CANSparkMax(10, MotorType.kBrushless),
    left2 = new CANSparkMax(21, MotorType.kBrushless),
    right1 = new CANSparkMax(33, MotorType.kBrushless),
    right2 = new CANSparkMax(19, MotorType.kBrushless);
  
  RelativeEncoder[] encoderArr = {left1.getEncoder(), right1.getEncoder()};


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    //shifter.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {

  }

  public void drive(double Forward) {

    left1.set(clamp(Forward, -1, 1));
    left2.set(clamp(Forward, -1, 1));

    right1.set(-clamp(Forward, -1, 1));
    right2.set(-clamp(Forward, -1, 1));
  
    
  }
  
  double clamp(double in, double min, double max) {
    if (in >= max) {return max;}
    else if (in <= min) {return min;}
    return in;
  }
}
