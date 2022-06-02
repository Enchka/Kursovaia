package ru.altmanea.edu.server.model

class Config {
    companion object {
        const val serverDomain = "localhost"
        const val serverPort = 8000
        const val serverApi = "1"
        const val serverUrl = "http://$serverDomain:$serverPort/"
        const val pathPrefix = "api$serverApi/"

        const val teachersPath = "${pathPrefix}teacher/"
        const val teachersURL = "$serverUrl$teachersPath"
        const val uploadPath = "${pathPrefix}upload"
    }
}