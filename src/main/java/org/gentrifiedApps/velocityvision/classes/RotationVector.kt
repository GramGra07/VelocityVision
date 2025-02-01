package org.gentrifiedApps.velocityvision.classes

/**
 * @param pitch Angle in degrees around x axis (when camera faces up, pitch is positive)
 * @param roll Angle in degrees of tilt
 * @param yaw Angle in degrees around z axis (when camera rotated clockwise, yaw is positive)
 */
data class RotationVector (
    var pitch: Double,
    var roll: Double,
    var yaw: Double
)