package org.gentrifiedApps.velocityvision.pipelines.bow

import org.gentrifiedApps.velocityvision.pipelines.bow.interfaces.DotDetectionInterface
import org.gentrifiedApps.velocityvision.enums.DotColor

class DotDetectionBuilder(
    override val rectangle: org.opencv.core.Rect,
    override val color: DotColor,
    override val minArea: Double,
    override val maxArea: Double
) : DotDetectionInterface {
}