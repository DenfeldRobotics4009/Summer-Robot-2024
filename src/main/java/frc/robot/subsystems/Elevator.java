// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkBase.SoftLimitDirection;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  static Elevator instance;

  /**
   * @return singleton instance of Intake
   */
  public static Elevator getInstance() {
    if (instance == null) {
      instance = new Elevator();
    }

    return instance;
  }
 
  CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);

  RelativeEncoder motor1Encoder = motor1.getEncoder();
  RelativeEncoder motor2Encoder = motor2.getEncoder();

  private PIDController movePidController = new PIDController (.012, 0, 0.001);

  public Elevator() {
    motor1.getEncoder().setPosition(0);
    motor2.getEncoder().setPosition(0);

    motor1.setSoftLimit(SoftLimitDirection.kForward, (float)Constants.Elevator.maxHeight);
    motor1.setSoftLimit(SoftLimitDirection.kReverse, (float)Constants.Elevator.maxHeight);
    motor1.enableSoftLimit(SoftLimitDirection.kForward, true);
    motor1.enableSoftLimit(SoftLimitDirection.kReverse, true);

    motor2.setSoftLimit(SoftLimitDirection.kReverse, (float)-Constants.Elevator.maxHeight);
    motor2.setSoftLimit(SoftLimitDirection.kForward, (float)-Constants.Elevator.maxHeight);
    motor2.enableSoftLimit(SoftLimitDirection.kForward, true);
    motor2.enableSoftLimit(SoftLimitDirection.kReverse, true);

    movePidController.setTolerance(Constants.Elevator.pidTolerance);
  }
  
  @Override
  public void periodic() {

    double speed = movePidController.calculate(motor1.getEncoder().getPosition());
    MathUtil.clamp(speed, -1, 1);
    //use your set speed funtion!
    movePidController.setSetpoint(speed);

  }

  public void topPosition (double targetPosition) {
    if (targetPosition == Constants.Elevator.maxHeight) {
      motor1.set(1);
      motor2.set(-1);
    }
  }

  public void bottomPosition (double targetPosition) {
    if (targetPosition == 0) {
      motor1.getEncoder().setPosition(0);
      motor2.getEncoder().setPosition(0);
    }
  }

  public void moveUp(double power) {
    motor1.set(power);
    motor2.set(-power);
  }

  public void stopMove() {
    motor1.set(0);
    motor2.set(0);
  }
}
