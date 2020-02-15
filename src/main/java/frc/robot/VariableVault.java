/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Variable Vault class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All variable vaults should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class VariableVault {
    //Intake variables
    public static final int kIntakeWristMotorID = 6;
    public static final int kIntakeMotorID = 1;
    public static final int kModuleNumber = 1;
    public static final int kIntakeForwardChannel = 0;
    public static final int kIntakeReverseChannel = 1;
    //Drivetrain variables
    public static final int kLeftMasterMotorID = 0;
    public static final int kRightMasterMotorID = 1;
    public static final int kLeftSlaveMotorID = 2;
    public static final int kRightSlaveMotorID = 3;

    public static final int kDrivetrainForwardChannel = 0;
    public static final int kDrivetrainReverseChannel = 1;

    //Climber variables
    public static final int kClimberClimbMotorID = 0;
    public static final int kUpperClimberForwardChannel = 2;
    public static final int kUpperClimberReverseChannel = 3;
    public static final int kLowerClimberForwardChannel = 4;
    public static final int kLowerClimberReverseChannel = 5;

    //Elevator variables
    public static final int kElevatorElevatorMotorID = 5;
    public static final int kElevatorShifterForwardChannel = 6;
    public static final int kElevatorShifterReverseChannel = 7;

    //Vision variables

    //Joystick variables
    public static final int kJoystickID = 0;
    public static final int kCoopStickID = 1;
}
