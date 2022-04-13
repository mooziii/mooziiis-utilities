package me.obsilabor.util

import java.io.*

object ByteUtils {

    fun readBytes(file: File): ByteArray {
        try {
            val `in`: InputStream = FileInputStream(file)
            val out = ByteArrayOutputStream()
            val buffer = ByteArray(256)
            var read: Int
            while (`in`.read(buffer).also { read = it } > 0) {
                out.write(buffer, 0, read)
            }
            `in`.close()
            return out.toByteArray()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return ByteArray(0)
    }

    fun copy(from: File, to: File) {
        try {
            val `in`: InputStream = FileInputStream(from)
            val out: OutputStream = FileOutputStream(to)
            copy(`in`, out)
            `in`.close()
            out.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun copy(`in`: InputStream, to: File) {
        try {
            val out: OutputStream = FileOutputStream(to)
            copy(`in`, out)
            `in`.close()
            out.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun copy(`in`: InputStream, out: OutputStream) {
        val bytes = ByteArray(512)
        var read: Int
        try {
            while (`in`.read(bytes).also { read = it } != -1) out.write(bytes, 0, read)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}