package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Robot extends OpMode {

//    DcMotor frontRight, backRight, frontLeft, backLeft;
    DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
    DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
    DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
    DcMotor backRight = hardwareMap.dcMotor.get("backRight");

    @Override
    public void init() {

        // one side has to be reversed; default is forward. If this makes it's direction inverted, switch the side
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        //Mecanum Code
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x * 1.1; // 1.1 is for minor errors in strafing to make sure values are true
        double rx = gamepad1.right_stick_x;

        //denominator = largest motor value
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);

        //Turret

        double turretRotation = gamepad2.right_stick_x;

        //Slides


    }
}
