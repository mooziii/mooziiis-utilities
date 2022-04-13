package me.obsilabor.util

import java.lang.System

enum class OperatingSystem {

    LINUX,
    WINDOWS,
    MACOS,
    UNKNOWN;

    companion object {
        val running = System.getProperty("os.name").lowercase().let { sysName ->
            when {
                sysName.contains("linux") -> LINUX
                sysName.contains("windows") -> WINDOWS
                sysName.contains("mac") -> MACOS
                else -> UNKNOWN
            }
        }
    }

}