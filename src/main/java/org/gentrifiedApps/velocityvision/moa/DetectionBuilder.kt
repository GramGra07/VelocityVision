package org.firstinspires.ftc.teamcode.pub

import android.graphics.Rect
import org.firstinspires.ftc.teamcode.pub.builderInterfaces.ObjectDetectionBuilder
import org.opencv.core.Scalar

/**
 * This interface is used to build a detection object
 * @property rectangle the rectangle of the detection
 * @property name the name of the detection
 * @property function the function to execute when the detection is detected
 */
class DetectionBuilder(
    override val rectangle: org.opencv.core.Rect,
    override val name: String,
    override val scalarLow: Scalar,
    override val scalarHigh: Scalar,
    private val function: Runnable,
) : ObjectDetectionBuilder {
    override fun execute() {
        function.run()
    }
}