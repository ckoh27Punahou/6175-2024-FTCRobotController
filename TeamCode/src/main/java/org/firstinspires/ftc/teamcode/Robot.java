package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp
public class Robot extends OpMode {

//    DcMotor frontRight, backRight, frontLeft, backLeft;
    DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
    DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
    DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
    DcMotor backRight = hardwareMap.dcMotor.get("backRight");
    DcMotor turret = hardwareMap.dcMotor.get("turret");
    DcMotor slide1 = hardwareMap.dcMotor.get("slide1");

    @Override
    public void init() {

        // one side has to be reversed; default is forward. If this makes it's direction inverted, switch the side
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        slide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        turret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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

        double turretRotation = gamepad2.right_stick_x;

        turret.setPower(turretRotation);

        //Slides

        double slideExtension = gamepad2.right_trigger;
        double slideRetraction = gamepad2.left_trigger;

        if (slideExtension>0.05) {
            slide1.setDirection(DcMotorSimple.Direction.FORWARD);
            slide1.setPower(slideExtension);
        } else if (slideRetraction>0.05) {
            slide1.setDirection(DcMotorSimple.Direction.REVERSE);
            slide1.setPower(slideRetraction);
        } else {
            slide1.setPower(0);
        }
    }
}
