package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="AutonomousSkeleton")
public class Autonomous extends OpMode {

    DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
    DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
    DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
    DcMotor backRight = hardwareMap.dcMotor.get("backRight");
    DcMotor turret = hardwareMap.dcMotor.get("turret");
    DcMotor slide1 = hardwareMap.dcMotor.get("slide1");

    @Override
    public void init() {

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

    }
}
