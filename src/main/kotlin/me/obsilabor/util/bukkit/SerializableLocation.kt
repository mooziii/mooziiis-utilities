package me.obsilabor.util.bukkit

import kotlinx.serialization.Serializable
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World

@Serializable
data class SerializableLocation(
    val worldName: String,
    val x: Double,
    val y: Double,
    val z: Double,
    val yaw: Float,
    val pitch: Float
) {

    val world: World
        get() = Bukkit.getWorld("world") ?: throw RuntimeException("World in SerializableLocation is null?")

    fun toLocation(): Location {
        return Location(world, x, y, z, yaw, pitch)
    }

    override fun toString(): String {
        return "[$worldName,$x,$y,$z]"
    }

}

fun Location.toSerializeLocation(): SerializableLocation {
    return SerializableLocation(world!!.name, x, y, z, yaw, pitch)
}