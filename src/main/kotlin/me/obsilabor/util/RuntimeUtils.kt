package me.obsilabor.util

import java.io.BufferedReader
import java.io.InputStreamReader

object RuntimeUtils {

    fun process(cmd: String): String {
        val process = Runtime.getRuntime().exec(cmd)
        process.waitFor()
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        return reader.readLine() ?: ""
    }

}