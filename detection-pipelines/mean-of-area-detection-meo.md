# Mean of Area Detection (meo)

Mean of area detection works through using rectangles you can specify, and then getting the average color over that entire area of the rectangle to determine if it should choose that "spot". For instance, in Centerstage 2023-2024, there are three spike marks. You can easily see two of them so it makes it easy to detect. In this case, you would choose which two to look at, and then assume if it isn't those, it must be the other one. We call this "assuming a third". Hence how in the pipeline we have created, there are Detection Builders and Assumed Builders.

### Detection Builder

When creating the pipeline, you will pass in two detection builders. These consist of a Rectangle with two points (TopLeft, BottomRight)

```java
Rect(Point(120.0, 50.0), Point(230.0, 150.0))
```

This allows you to define a box that the detection will specifically look at.&#x20;

Next, you will define a name for this detection. For instance, with my example of CenterStage earlier, it could be "left" or "center".

Next you will define a lower and upper **scalar** color. This pipeline uses the **HSV** color space because I have found it to be much simpler to navigate with simple colors.

```java
Scalar(255.0, 255.0, 255.0)
```

Next, you will define a function for the program to execute when it selects this detection. A very convenient way to do this is have BlinkinLED lights and setting them to different colors depending on the detection, a very easy way to make sure it is working correctly. Another way this could be used is to set a variable to different numbers so you know which detection has been selected.

For instance, a complete code module using this could look like:&#x20;

```java
package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.gentrifiedApps.velocityvision.AssumedBuilder;
import org.gentrifiedApps.velocityvision.DetectionBuilder;
import org.gentrifiedApps.velocityvision.MeanColorOfAreaDetector;
import org.opencv.core.Rect;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

@Autonomous
public class testAuto extends LinearOpMode {
    private MeanColorOfAreaDetector processor;
    private VisionPortal portal;
    private int detectionNum = 0;
    @Override
    public void runOpMode() {
        processor = new MeanColorOfAreaDetector(
                new DetectionBuilder(
                        new Rect(new Point(120.0, 50.0), new Point(230.0, 150.0)),
                        "left",
                        new Scalar(0.0, 140.0, 0.0),()->{detectionNum = 1}
                ) ,
                new DetectionBuilder(
                        new Rect(new Point(570.0, 70.0), new Point(680.0, 170.0)),
                        "right",
                        new Scalar(0.0, 140.0, 0.0),
                        new Scalar(255.0, 255.0, 255.0),()->{ detectionNum = 2}
                ) ,
                new AssumedBuilder("middle", ()->{detectionNum = 3}) 
                
        );

       portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .setCameraResolution(new Size(640, 480))
                .addProcessor(processor)
                .build();
        waitForStart();
    }
}
```

This makes the complete detector as well as also setting up the Assumed, which in this case would be center.

**If you have any questions, feel free to open an issue on the github repository for this project**
