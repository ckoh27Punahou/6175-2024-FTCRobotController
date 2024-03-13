package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp
public class Robot extends OpMode {

//    DcMotor frontRight, backRight, frontLeft, backLeft;
    DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
    DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
    DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
    DcMotor backRight = hardwareMap.dcMotor.get("backRight");

    DcMotor slide1 = hardwareMap.dcMotor.get("slide1");
    CRServo slide2 = hardwareMap.crservo.get("slide2");
    CRServo turret = hardwareMap.crservo.get("turret");


    @Override
    public void init() {

        // one side has to be reversed; default is forward. If this makes it's direction inverted, switch the side
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        slide1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {

        //Mecanum Code
        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x * 1.1; // 1.1 is for minor errors in strafing to make sure values are true
        double turn = gamepad1.right_stick_x;

        //denominator = largest motor value
        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1);
        double frontLeftPower = (forward + strafe + turn) / denominator;
        double backLeftPower = (forward - strafe + turn) / denominator;
        double frontRightPower = (forward - strafe - turn) / denominator;
        double backRightPower = (forward + strafe - turn) / denominator;

        if (gamepad1.left_bumper) {
            forward = forward/3;
            strafe = strafe/3;
            turn = turn/3;
        }

        if (gamepad1.right_bumper) {
            forward = forward * 3;
            strafe = strafe * 3;
            turn = turn * 3;
        }

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);



        //Turret

        double turretRotation = gamepad2.left_stick_x;
        if (gamepad2.left_bumper) {
            turret.setPower(turretRotation/3);
        } else {
            turret.setPower(turretRotation);
        }

        //Slide on turret

        double slide1Extension = gamepad2.right_trigger;
        double slide1Retraction = gamepad2.left_trigger;
        if (gamepad2.right_bumper) {
            if (slide1Extension > 0.05) {
                slide1.setDirection(DcMotorSimple.Direction.FORWARD);
                slide1.setPower(slide1Extension/3);
            } else if (slide1Retraction > 0.05) {
                slide1.setDirection(DcMotorSimple.Direction.REVERSE);
                slide1.setPower(slide1Retraction/3);
            } else {
                slide1.setPower(0);
            }
        } else {
            if (slide1Extension>0.05) {
                slide1.setDirection(DcMotorSimple.Direction.FORWARD);
                slide1.setPower(slide1Extension);
            } else if (slide1Retraction>0.05) {
                slide1.setDirection(DcMotorSimple.Direction.REVERSE);
                slide1.setPower(slide1Retraction);
            } else {
                slide1.setPower(0);
            }
        }

        //Vertical Slide

        double slide2Extension = gamepad1.right_trigger;
        double slide2Retraction = gamepad1.left_trigger;
        if (gamepad1.right_bumper) {
            if (slide2Extension > 0.05) {
                slide2.setDirection(DcMotorSimple.Direction.FORWARD);
                slide2.setPower(slide2Extension/3);
            } else if (slide2Retraction > 0.05) {
                slide2.setDirection(DcMotorSimple.Direction.REVERSE);
                slide2.setPower(slide2Retraction/3);
            } else {
                slide2.setPower(0);
            }
        } else {
            if (slide2Extension>0.05) {
                slide2.setDirection(DcMotorSimple.Direction.FORWARD);
                slide2.setPower(slide2Extension);
            } else if (slide2Retraction>0.05) {
                slide2.setDirection(DcMotorSimple.Direction.REVERSE);
                slide2.setPower(slide2Retraction);
            } else {
                slide2.setPower(0);
            }
        }


    }
}
