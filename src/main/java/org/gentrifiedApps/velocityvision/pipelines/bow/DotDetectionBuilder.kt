package org.gentrifiedApps.velocityvision.pipelines.bow

import org.gentrifiedApps.velocityvision.pipelines.bow.interfaces.DotDetectionInterface

class DotDetectionBuilder(
    override val rectangle: org.opencv.core.Rect,
    override val minArea: Double,
    override val maxArea: Double
) : DotDetectionInterface{
    constructor() : this(org.opencv.core.Rect(), 0.0, 1000000.0)
}