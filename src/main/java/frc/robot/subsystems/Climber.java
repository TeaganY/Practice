/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.VariableVault;

public class Climber extends SubsystemBase {
  private final VictorSP climbMotor = new VictorSP(VariableVault.kClimberClimbMotorID);

  private final DoubleSolenoid Upper = new DoubleSolenoid(VariableVault.kUpperClimberForwardChannel,VariableVault.kUpperClimberReverseChannel);
  private final DoubleSolenoid Lower = new DoubleSolenoid(VariableVault.kLowerClimberForwardChannel,VariableVault.kLowerClimberReverseChannel);

  /**
   * Creates a new Climber.
   */
  public Climber() {
    climbMotor.setInverted(true);
    climbMotor.setSubsystem("Climber");

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
