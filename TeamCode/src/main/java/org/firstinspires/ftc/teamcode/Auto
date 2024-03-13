package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Auto")
public class Auto extends LinearOpMode {

//DcMotor frontRight, backRight, frontLeft, backLeft;
  DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
  DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
  DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
  DcMotor backRight = hardwareMap.dcMotor.get("backRight");
  DcMotor turret = hardwareMap.dcMotor.get("turret");
  DcMotor slide1 = hardwareMap.dcMotor.get("slide1");

  public void runOpMode() {

    frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    slide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    turret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1);
    double frontLeftPower = (forward + strafe + turn) / denominator;
    double backLeftPower = (forward - strafe + turn) / denominator;
    double frontRightPower = (forward - strafe - turn) / denominator;
    double backRightPower = (forward + strafe - turn) / denominator;
  }
}
