package org.gentrifiedApps.velocityvision.classes

import org.opencv.core.MatOfPoint3f
import org.opencv.core.Point3

data class KnownMark (
    val marks: List<Point3>
){
    fun toMatOfPoint3f(): MatOfPoint3f {
        val points = MatOfPoint3f()
        points.fromList(marks)
        return points
    }
}
