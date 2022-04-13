package me.obsilabor.util.bukkit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public interface Components {

    static Component error(String string) {
        return Component.text(string).color(TextColor.color(255, 0, 0));
    }

    static Component info(String string) {
        return Component.text(string).color(TextColor.color(0, 255, 0));
    }

    static Component debug(String string) {
        return Component.text(string).color(TextColor.color(0, 0, 255));
    }

}