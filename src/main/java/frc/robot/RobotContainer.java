/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.A1;
import frc.robot.commands.intakeOff;
import frc.robot.commands.intakeOn;
import frc.robot.commands.wristDown;
import frc.robot.commands.wristUp;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Vision;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Climber sClimber = new Climber();
  private final Drivetrain sDrivetrain = new Drivetrain();
  private final Elevator sElevator = new Elevator();
  private final Intake sIntake = new Intake();
  private final Vision sVision = new Vision();

  private static final Joystick OpStick = new Joystick(VariableVault.kJoystickID);
  private static final Joystick CoopStick = new Joystick(VariableVault.kCoopStickID);

  private final wristUp cWristUp = new wristUp(sIntake);
  private final wristDown cWristDown = new wristDown(sIntake);
  private final intakeOn cIntakeOn = new intakeOn(sIntake);
  private final intakeOff cIntakeOff = new intakeOff(sIntake);

  private JoystickButton moveWristUp;
  private JoystickButton moveWristDown;
  private JoystickButton turnIntakeOn;
  private JoystickButton turnIntakeOff;

  private final A1 cA1;

  public String A1 = "A1";

  SendableChooser<String> chooser = new SendableChooser<String>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    cA1 = new A1(sDrivetrain);\
    chooser.addDefault("Default", "Default");
    chooser.addOption("A1", A1);
    SmartDashboard.putData("Auto Chooser", chooser);
    // Configure the button bindings
    configureButtonBindings(); 

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    moveWristUp = new JoystickButton(OpStick, 1);
    moveWristUp.whenPressed(new wristUp(sIntake));
    
    moveWristDown = new JoystickButton(OpStick, 2);
    moveWristDown.whenPressed(new wristDown(sIntake));

    turnIntakeOn = new JoystickButton(OpStick, 3);
    turnIntakeOn.whenPressed(new intakeOn(sIntake));

    turnIntakeOff = new JoystickButton(OpStick, 4);
    turnIntakeOff.whenPressed(new intakeOff(sIntake));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    String choice = chooser.getSelected();
    Command autoCommand = null;
    // An ExampleCommand will run in autonomous

    switch(choice) {
      case "A1":
        autoCommand = cA1;
        break;
      case "default":
        autoCommand = null;
        break;
    }
    return autoCommand;
  }

  public static Joystick getOpStick() {
    return OpStick;
  }
}
