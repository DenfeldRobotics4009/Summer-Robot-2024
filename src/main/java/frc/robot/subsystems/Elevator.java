// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  public enum elevatorPosition {
    BOTTOM (0),
    TOP (Constants.Elevator.maxHeight);

    private double position;

    private elevatorPosition(double position) {
      this.position = position;
    }

    public double get() {
      return position;
    }
  }
 
  CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);
  SparkPIDController motorPidController = motor1.getPIDController();
  
  AbsoluteEncoder[] encoderArr = {motor1.getEncoder(), motor2.getEncoder()};

  private PIDController movePidController = new PIDController (.012, 0, 0.001);

  public Elevator() {
    movePidController.setTolerance(Constants.Elevator.pidTolerance);
    motor1.getEncoder().setPosition(0);
  }
  
  @Override
  public void periodic() {

    double speed = movePidController.calculate(motor1.getEncoder().getPosition()*2*Math.PI);
    MathUtil.clamp(speed, -1, 1);
    motor1.set(speed);
    motor2.getEncoder().setPosition(-motor1.getEncoder().getPosition());
  }

  void move() {

  }

  void stopMove() {

  }
}
