package me.obsilabor.util

fun Double.cut(): Double {
    var finalString = "0.0"
    if (this != 0.0) {
        finalString =
            java.lang.String.valueOf(this).split(".")[0] + "." + java.lang.String.valueOf(this).split(".")[1].subSequence(0, 1)
    }
    return finalString.toDouble()
}

fun Float.cut(): Float {
    var finalString = "0.0"
    if (this != 0.0F) {
        finalString =
            java.lang.String.valueOf(this).split(".")[0] + "." + java.lang.String.valueOf(this).split(".")[1].subSequence(0, 1)
    }
    return finalString.toFloat()
}