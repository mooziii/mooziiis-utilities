package me.obsilabor.util

import java.awt.Desktop
import java.net.URI
import java.net.URISyntaxException
import java.net.URL

object WebUtils {

    fun openURI(uri: URI): Boolean {
        val desktop = if (Desktop.isDesktopSupported()) Desktop.getDesktop() else null
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri)
                return true
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return false
    }

    fun openURL(url: URL): Boolean {
        try {
            return openURI(url.toURI())
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
        return false
    }

}