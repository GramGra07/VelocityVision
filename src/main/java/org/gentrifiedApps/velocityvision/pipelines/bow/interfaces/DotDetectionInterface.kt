package org.gentrifiedApps.velocityvision.pipelines.bow.interfaces

import org.opencv.core.Rect

interface DotDetectionInterface {
    val rectangle: Rect
    val minArea: Double
    val maxArea: Double
}