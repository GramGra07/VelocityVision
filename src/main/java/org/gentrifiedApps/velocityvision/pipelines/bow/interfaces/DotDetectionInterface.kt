package org.gentrifiedApps.velocityvision.pipelines.bow.interfaces

import org.gentrifiedApps.velocityvision.enums.DotColor
import org.opencv.core.Rect

interface DotDetectionInterface {
    val rectangle: Rect
    val color: DotColor
    val minArea: Double
    val maxArea: Double
}