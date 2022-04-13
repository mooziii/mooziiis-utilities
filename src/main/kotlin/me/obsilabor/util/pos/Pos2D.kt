package me.obsilabor.util.pos

import kotlinx.serialization.Serializable

@Serializable
data class Pos2D(
    var x: Double,
    var y: Double
) {

    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

    constructor(x: Float, y: Float) : this(x.toDouble(), y.toDouble())

}