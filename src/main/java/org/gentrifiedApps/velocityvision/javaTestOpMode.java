package org.gentrifiedApps.velocityvision;

import org.gentrifiedApps.velocityvision.classes.CameraParams;
import org.gentrifiedApps.velocityvision.classes.LensIntrinsics;
import org.gentrifiedApps.velocityvision.classes.RotationVector;
import org.gentrifiedApps.velocityvision.classes.TranslationalVector;
import org.gentrifiedApps.velocityvision.pipelines.bow.DotColor;
import org.gentrifiedApps.velocityvision.pipelines.bow.BlackAndWhiteDotDetector;
import org.gentrifiedApps.velocityvision.pipelines.bow.DotDetectionBuilder;
import org.gentrifiedApps.velocityvision.pipelines.homography.HomographicProjection;
import org.opencv.core.Rect;

public class javaTestOpMode {
    BlackAndWhiteDotDetector blackAndWhiteDotDetector = new BlackAndWhiteDotDetector(
            DotColor.BLACK,
            new DotDetectionBuilder(
                    new Rect(50, 50, 100, 75), 10.0, 100.0
            )
    );
    HomographicProjection homographicProjection = new HomographicProjection(
            new CameraParams(new LensIntrinsics(0.0,0.0,0.0,0.0),new TranslationalVector(0.0,0.0,0.0),new RotationVector(0.0,0.0,0.0))
    );
}
