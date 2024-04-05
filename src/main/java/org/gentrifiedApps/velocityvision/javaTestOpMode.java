package org.gentrifiedApps.velocityvision;

import org.gentrifiedApps.velocityvision.enums.DotColor;
import org.gentrifiedApps.velocityvision.pipelines.bow.BlackAndWhiteDotDetector;
import org.gentrifiedApps.velocityvision.pipelines.bow.DotDetectionBuilder;
import org.opencv.core.Rect;

public class javaTestOpMode {
    BlackAndWhiteDotDetector blackAndWhiteDotDetector = new BlackAndWhiteDotDetector(
            DotColor.BLACK,
            new DotDetectionBuilder(
                    new Rect(50, 50, 100, 75), 10.0, 100.0
            )
    );
}
