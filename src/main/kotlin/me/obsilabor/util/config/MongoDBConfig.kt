package me.obsilabor.util.config

import kotlinx.serialization.Serializable

@Serializable
data class MongoConfig(
    val host: String,
    val port: Int,
    val username: String,
    val password: String,
    val database: String
) {

    companion object {
        val DEFAULTS = MongoConfig(
            "127.0.0.1",
            27107,
            "username",
            "password",
            "database"
        )
    }

}