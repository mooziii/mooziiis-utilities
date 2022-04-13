package me.obsilabor.util.bukkit

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import kotlin.math.atan2
import kotlin.math.sqrt

object RotationUtils {

    fun getNeededRotations(to: Entity, from: Player): Rotation? {
        val eyesPos: Vector = from.eyeLocation.toVector()
        val vec: Vector = to.location.toVector()
        val diffX: Double = vec.x - eyesPos.x
        val diffY: Double = vec.y - eyesPos.y
        val diffZ: Double = vec.z - eyesPos.z
        val diffXZ = sqrt(diffX * diffX + diffZ * diffZ)
        val yaw = Math.toDegrees(atan2(diffZ, diffX)).toFloat() - 90f
        val pitch = (-Math.toDegrees(atan2(diffY, diffXZ))).toFloat()
        return Rotation(yaw, pitch)
    }

    fun getNeededRotations(to: Entity, from: Entity): Rotation {
        val eyesPos: Vector = from.location.toVector()
        val vec: Vector = to.location.toVector()
        val diffX: Double = vec.x - eyesPos.x
        val diffY: Double = vec.y - eyesPos.y
        val diffZ: Double = vec.z - eyesPos.z
        val diffXZ = sqrt(diffX * diffX + diffZ * diffZ)
        val yaw = Math.toDegrees(atan2(diffZ, diffX)).toFloat() - 90f
        val pitch = (-Math.toDegrees(atan2(diffY, diffXZ))).toFloat()
        return Rotation(yaw, pitch)
    }

    fun getNeededRotations(to: Location, from: Entity): Rotation {
        val eyesPos: Vector = from.location.toVector()
        val vec: Vector = to.toVector()
        val diffX: Double = vec.x - eyesPos.x
        val diffY: Double = vec.y - eyesPos.y
        val diffZ: Double = vec.z - eyesPos.z
        val diffXZ = sqrt(diffX * diffX + diffZ * diffZ)
        val yaw = Math.toDegrees(atan2(diffZ, diffX)).toFloat() - 90f
        val pitch = (-Math.toDegrees(atan2(diffY, diffXZ))).toFloat()
        return Rotation(yaw, pitch)
    }

    fun getNeededRotations(to: Location, from: Location): Rotation {
        val eyesPos: Vector = from.toVector()
        val vec: Vector = to.toVector()
        val diffX: Double = vec.x - eyesPos.x
        val diffY: Double = vec.y - eyesPos.y
        val diffZ: Double = vec.z - eyesPos.z
        val diffXZ = sqrt(diffX * diffX + diffZ * diffZ)
        val yaw = Math.toDegrees(atan2(diffZ, diffX)).toFloat() - 90f
        val pitch = (-Math.toDegrees(atan2(diffY, diffXZ))).toFloat()
        return Rotation(yaw, pitch)
    }

    class Rotation(yaw: Float, pitch: Float) {
        val yaw: Float
        val pitch: Float

        init {
            this.yaw = wrapDegrees(yaw)
            this.pitch = wrapDegrees(pitch)
        }
    }

    private fun wrapDegrees(degrees: Float): Float {
        var f = degrees % 360.0f
        if (f >= 180.0f) {
            f -= 360.0f
        }
        if (f < -180.0f) {
            f += 360.0f
        }
        return f
    }

}