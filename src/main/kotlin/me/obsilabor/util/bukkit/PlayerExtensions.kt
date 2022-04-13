package me.obsilabor.util.bukkit

import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

fun Player.clearEffects() {
    for (effect in activePotionEffects) {
        if(effect.type == PotionEffectType.SATURATION) continue
        removePotionEffect(effect.type)
    }
}