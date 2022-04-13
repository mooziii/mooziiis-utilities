package me.obsilabor.util.bukkit

import org.bukkit.Location
import org.bukkit.World

class WorldlessLocation(val x: Double, val y: Double, val z: Double, var yaw: Float = 0f, var pitch: Float = 0f) {

    fun buildLocation(world: World): Location {
        return Location(world, x, y, z, yaw, pitch)
    }

    constructor(location: Location) : this(location.x, location.y, location.z, location.yaw, location.pitch)

}