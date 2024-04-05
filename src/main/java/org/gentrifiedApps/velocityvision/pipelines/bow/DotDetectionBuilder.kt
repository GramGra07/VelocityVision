package org.gentrifiedApps.velocityvision.pipelines.bow

import org.gentrifiedApps.velocityvision.pipelines.bow.interfaces.DotDetectionInterface

class DotDetectionBuilder(
    override val rectangle: org.opencv.core.Rect,
    override val minArea: Double,
    override val maxArea: Double
) : DotDetectionInterface