package me.obsilabor.util.borderfile

import java.io.File

class BorderFile(private val file: File) {

    private var borderEntries = arrayListOf<BorderEntry>()

    /**
     * As an example,
     *
     * `on second 300 set size 30 until second 800`
     *
     * On second 300 the border will shrink to 30x30 within 500 seconds
     */
    fun read() {
        if(!file.exists()) {
            file.createNewFile()
            file.writeText("""
                # Borderfile examples:
                # 
                # `on second 1200 set size 50 until second 2400`
                # This line tells the plugin to shrink the border from second 1200 to 50x60 within 20 minutes (until second 2400)
            """.trimIndent())
        }
        file.readLines().forEach { line ->
            if(!line.startsWith("#") && line.isNotEmpty()) {
                val firstHalf = line.split("set size")[0]
                val middle = line.split("set size")[1].split("until second")[0]
                val lastHalf = line.split("set size")[1].split("until second")[1]
                val startTime = firstHalf.replace("on second ", "").replace(" ", "").toInt()
                val size = middle.replace(" ", "").toInt()
                val endTime = lastHalf.replace(" ", "").toInt()
                borderEntries.add(BorderEntry(startTime, size, endTime-startTime))
            }
        }
    }

    fun entryForSecond(currentSecond: Int): BorderEntry? {
        for (entry in borderEntries) {
            if(entry.startTime == currentSecond) {
                return entry
            }
        }
        return null
    }

}