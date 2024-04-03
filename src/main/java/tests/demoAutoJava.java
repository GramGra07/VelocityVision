package tests;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import AssumedBuilder;
import DetectionBuilder;
import MeanColorOfAreaDetector;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

@Autonomous
public class demoAutoJava extends LinearOpMode {
    VisionPortal visionPortal;
    private MeanColorOfAreaDetector pubProcessor;

    @Override
    public void runOpMode() {
        pubProcessor = new MeanColorOfAreaDetector(
                new DetectionBuilder(
                        new Rect(new Point(120.0, 50.0), new Point(230.0, 150.0)), "left",
                        new Scalar(0.0, 140.0, 0.0),
                        new Scalar(255.0, 255.0, 255.0), () -> {
                }
                ),
                new DetectionBuilder(
                        new Rect(new Point(570.0, 70.0), new Point(680.0, 170.0)), "right",
                        new Scalar(0.0, 140.0, 0.0),
                        new Scalar(255.0, 255.0, 255.0), () -> {
                }
                ),
                new AssumedBuilder("middle", () -> {
                })
        );
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .setCameraResolution(new Size(1280, 720));
        builder.addProcessor(pubProcessor);
        visionPortal = builder.build();

        waitForStart();
    }
}
