package org.gentrifiedApps.velocityvision.pipelines.homography

import android.graphics.Bitmap
import android.graphics.Canvas
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.robotcore.external.function.Consumer
import org.firstinspires.ftc.robotcore.external.function.Continuation
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamSource
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration
import org.firstinspires.ftc.vision.VisionProcessor
import org.gentrifiedApps.velocityvision.classes.CameraParams
import org.gentrifiedApps.velocityvision.enums.Color
import org.gentrifiedApps.velocityvision.pipelines.sample.CameraLock
import org.gentrifiedApps.velocityvision.pipelines.sample.CameraLock.Companion.ofReturnables
import org.opencv.android.Utils
import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.MatOfPoint
import org.opencv.core.MatOfPoint2f
import org.opencv.core.Point
import org.opencv.core.Scalar
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc
import java.util.concurrent.atomic.AtomicReference
import kotlin.math.abs

class HomographicProjection (
    val cameraParams: CameraParams,
) : VisionProcessor,
    CameraStreamSource {

    private val lastFrame = AtomicReference(Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565))

    override fun init(width: Int, height: Int, calibration: CameraCalibration) {
        lastFrame.set(Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565))
    }

    override fun processFrame(frame: Mat, captureTimeNanos: Long): Any {
        val warped = HomographicMatrix().warpToTopDown(frame, cameraParams)

        val b =
            Bitmap.createBitmap(frame.width(), frame.height(), Bitmap.Config.RGB_565)
        Utils.matToBitmap(frame, b)
        lastFrame.set(b)
        return warped
    }

    override fun onDrawFrame(
        canvas: Canvas,
        onscreenWidth: Int,
        onscreenHeight: Int,
        scaleBmpPxToCanvasPx: Float,
        scaleCanvasDensity: Float,
        userContext: Any
    ) {
    }

    override fun getFrameBitmap(continuation: Continuation<out Consumer<Bitmap>?>) {
        continuation.dispatch { bitmapConsumer: Consumer<Bitmap>? ->
            bitmapConsumer!!.accept(
                lastFrame.get()
            )
        }
    }
}