package me.obsilabor.util.pos

import kotlinx.serialization.Serializable

@Serializable
data class Rect2D(
    var x1: Int,
    var y1: Int,
    var x2: Int,
    var y2: Int
) {

    constructor(x1: Double, y1: Double, x2: Double, y2: Double) : this(x1.toInt(), y1.toInt(), x2.toInt(), y2.toInt())

    constructor(x1: Float, y1: Float, x2: Float, y2: Float) : this(x1.toInt(), y1.toInt(), x1.toInt(), y2.toInt())

    init {
        if (x1 > x2) {
            val t = x1
            x1 = x2
            x2 = t
        }
        if (y1 > y2) {
            val t = y1
            y1 = y2
            y2 = t
        }
    }

    fun isIn(x: Int, y: Int): Boolean {
        if(x in x1..x2) {
            if(y in y1..y2) {
                return true
            }
        }
        return false
    }

}