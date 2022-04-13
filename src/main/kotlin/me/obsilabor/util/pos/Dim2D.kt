package me.obsilabor.util.pos

import kotlinx.serialization.Serializable

@Serializable
data class Dim2D(
    val width: Int,
    val height: Int
) {

    constructor(width: Double, height: Double) : this(width.toInt(), height.toInt())

    constructor(width: Float, height: Float) : this(width.toInt(), height.toInt())

}