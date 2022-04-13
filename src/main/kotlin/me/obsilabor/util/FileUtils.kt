package me.obsilabor.util

import java.io.File

fun getOrCreateFile(file: File): File {
    if(!file.exists()) {
        file.createNewFile()
    }
    return file
}

fun getOrCreateDirectory(dir: File): File {
    if(!dir.exists()) {
        dir.createNewFile()
    }
    return dir
}

fun File.createParent() {
    if(!parentFile.exists()) {
        parentFile.mkdir()
    }
}

/**
 * Idk what i used this for but i found it in one of my projects
 */
val File.icon: String
    get()  {
        if(isDirectory) {
            return if(listFiles() == null) {
                "\uD83D\uDDC0"
            } else {
                if(listFiles()?.isNotEmpty() == true) {
                    "\uD83D\uDDC1"
                } else {
                    "\uD83D\uDDC0"
                }
            }
        } else {
            if(name.endsWith(".png")) {
                return "\uD83D\uDDBB"
            } else if(name.endsWith(".mp3") || name.endsWith(".ogg")) {
                return "\uD83D\uDDB8"
            } else if(name.endsWith(".html")) {
                return "\uD83D\uDD83"
            } else if(name.endsWith(".js") || name.endsWith(".jsx") || name.endsWith(".ts")) {
                return "\uD83D\uDD30"
            } else if(name.endsWith(".db")) {
                return "⛁"
            } else if(name.endsWith(".css")) {
                return "\uD83D\uDCD1"
            } else if(name.endsWith(".kt")) {
                return "\uD83C\uDD7A"
            } else if(name.endsWith(".java")) {
                return "☕"
            } else if(name.endsWith(".apk")) {
                return "\uD83D\uDCF1"
            } else if(name.endsWith(".json") || name.endsWith(".yml") || name.endsWith(".yaml") || name.endsWith(".toml") || name.endsWith(".conf")) {
                return "\uD83D\uDCDC"
            } else if(name.equals("PKGBUILD") || name.endsWith(".zip") || name.endsWith(".gz") || name.endsWith(".7z") || name.endsWith(".exe") || name.endsWith(".iso")) {
                return "\uD83D\uDCE6"
            }
        }
        return "\uD83D\uDDCB"
    }