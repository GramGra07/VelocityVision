package org.gentrifiedApps.velocityvision

import org.gentrifiedApps.velocityvision.enums.Alliance
import org.gentrifiedApps.velocityvision.pipelines.bow.DotColor
import org.gentrifiedApps.velocityvision.pipelines.sample.ReturnType
import org.gentrifiedApps.velocityvision.pipelines.bow.BlackAndWhiteDotDetector
import org.gentrifiedApps.velocityvision.pipelines.bow.DotDetectionBuilder
import org.gentrifiedApps.velocityvision.pipelines.sample.SampleDataDetector
import org.opencv.core.Rect

class mainTestOpMode {
    var blackAndWhiteDotDetector: BlackAndWhiteDotDetector = BlackAndWhiteDotDetector(
        DotColor.BLACK,
        DotDetectionBuilder(
            Rect(50, 50, 100, 75), 10.0, 100.0
        )
    )
    var targetLock:SampleDataDetector = SampleDataDetector(
        ReturnType.all(),
        Alliance.RED
    )
}