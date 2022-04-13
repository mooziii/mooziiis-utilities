package me.obsilabor.util.bukkit

import net.md_5.bungee.api.ChatColor
import java.awt.Color

object ColorUtils {

    fun offsetRainbowEffect(x: Int, y: Int): Int {
        val longHue = System.currentTimeMillis() - (x * 10 - y * 10)
        return Color.HSBtoRGB(longHue % 3000 / 3000.0f, 1f, 1f)
    }

    fun offsetRainbowEffectToColor(x: Int, y: Int): Color {
        val longHue = System.currentTimeMillis() - (x * 10 - y * 10)
        return Color(Color.HSBtoRGB(longHue % 3000 / 3000.0f, 1f, 1f))
    }

    fun colorInRainbow(text: String): String {
        var finalText = ""
        var currentX = 2
        for (textChar in text.toCharArray()) {
            finalText += "${ChatColor.of(hex(offsetRainbowEffect(currentX, 150)))}$textChar"
            currentX += 7
        }
        return finalText
    }

    fun colorInRainbowBold(text: String): String {
        var finalText = ""
        var currentX = 2
        for (textChar in text.toCharArray()) {
            finalText += "${ChatColor.of(hex(offsetRainbowEffect(currentX, 150)))}${ChatColor.BOLD}$textChar"
            currentX += 7
        }
        return finalText
    }

    private fun hex(rgb: Int): String {
        val color = Color(rgb)
        return java.lang.String.format("#%02x%02x%02x", color.red, color.green, color.blue)
    }
}