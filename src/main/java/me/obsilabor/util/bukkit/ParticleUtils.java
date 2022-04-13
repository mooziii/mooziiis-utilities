package me.obsilabor.util.bukkit;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.jetbrains.annotations.Nullable;

public class ParticleUtils {

    public static  <T> void drawCircle(double radius, Location center, Particle particle, @Nullable T particleData) {
        for (double i = 0; i < 0.5; i++) {
            for (double y = 0.0; y < (Math.PI * 2); y += .1) {
                double x = radius * Math.cos(y);
                double z = radius * Math.sin(y);
                center.getWorld().spawnParticle(particle, center.clone().add(x, i / 4, z), 0, 0, 0, 0, 5, particleData);
            }
        }
    }

}
