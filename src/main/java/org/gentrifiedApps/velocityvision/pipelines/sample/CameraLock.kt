package org.gentrifiedApps.velocityvision.pipelines.sample

import android.graphics.Camera
import org.gentrifiedApps.velocityvision.enums.Color
import org.gentrifiedApps.velocityvision.enums.ReturnType
import org.gentrifiedApps.velocityvision.extensions.Drawables.cross
import org.opencv.core.Mat
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.imgproc.Imgproc
import kotlin.math.roundToInt

data class CameraLock(
    var angle: Double,
    var color: Color,
    var center: Point,
) {
    companion object {
        fun empty(): CameraLock {
            return CameraLock(0.0, Color.NONE, Point(0.0, 0.0))
        }
        fun CameraLock.ofReturnables(returns: List<ReturnType>): CameraLock {
            val returnables = CameraLock.empty()
            for (returnable in returns) {
                when (returnable) {
                    ReturnType.ANGLE -> returnables.angle = this.angle
                    ReturnType.CENTER -> returnables.center = this.center
                    ReturnType.COLOR -> returnables.color = this.color
                }
            }
            return returnables
        }
    }
    fun draw(frame: Mat) {
        cross(frame, center, 10, Scalar(255.0, 0.0, 0.0))
        Imgproc.circle(frame, center, 10, Scalar(255.0, 0.0, 0.0), 1)
    }

    override fun toString(): String {
        return "Center: ${center}, Angle: $angle, Color: $color"
    }

    fun Point.toString(): String {
        return "${center.x.roundToInt()}, ${center.y.roundToInt()}"
    }
}