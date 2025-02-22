package org.gentrifiedApps.velocityvision.classes

/**
 * @param x The x-component of translational vector in inches from center of robot to camera, forward is positive
 * @param y The y-component of translational vector in inches from center of robot to camera, right is positive
 * @param z The z-component of translational vector in inches from center of robot to camera, up is positive
 */
data class TranslationalVector(
    val x: Double,
    val y: Double,
    val z: Double
){
    constructor() : this(0.0, 0.0, 0.0)
    fun toPoint3(): org.opencv.core.Point3 {
        return org.opencv.core.Point3(x, y, z)
    }

}
