package org.gentrifiedApps.velocityvision.enums

enum class ReturnType {
    ANGLE,
    CENTER,
    COLOR;
    companion object {
        @JvmStatic
        fun all(): List<ReturnType> {
            return listOf(ReturnType.ANGLE, ReturnType.CENTER, ReturnType.COLOR)
        }
    }
}