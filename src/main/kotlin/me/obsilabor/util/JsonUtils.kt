package me.obsilabor.util

import kotlinx.serialization.json.Json

val prettyJson = Json {
    prettyPrint = true
    encodeDefaults = true
    @Suppress("EXPERIMENTAL_API_USAGE")
    prettyPrintIndent = "  "
    ignoreUnknownKeys = true
}