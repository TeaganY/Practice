/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.ejml.equation.Variable;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.VariableVault;

public class Drivetrain extends SubsystemBase {
  private final WPI_TalonSRX leftMaster= new WPI_TalonSRX(VariableVault.kLeftMasterMotorID);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(VariableVault.kRightMasterMotorID);
  private final WPI_TalonSRX leftSlave = new WPI_TalonSRX(VariableVault.kLeftSlaveMotorID);
  private final WPI_TalonSRX rightSlave = new WPI_TalonSRX(VariableVault.kRightSlaveMotorID);

  private final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  private final DoubleSolenoid shifter = new DoubleSolenoid(VariableVault.kDrivetrainForwardChannel,VariableVault.kDrivetrainReverseChannel);


  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    leftMaster.setSubsystem("Drivetrain");
    
    leftSlave.follow(leftMaster);
    leftSlave.setSubsystem("Drivetrain");
    
    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    rightMaster.setSubsystem("Drivetrain");

    rightSlave.follow(rightMaster);
    rightSlave.setSubsystem("Drivetrain");
  }

  @Override
  public void periodic() {
    OpDrive(RobotContainer.getOpStick());
    // This method will be called once per scheduler run
  }

  public void OpDrive(Joystick stick) {
    drive.arcadeDrive(-stick.getY(), -stick.getZ());
  }
}
