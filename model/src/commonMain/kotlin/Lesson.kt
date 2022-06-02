package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable
import kotlin.coroutines.EmptyCoroutineContext.get

@Serializable

data class Lesson (
    var group: String = "",
    var classroom: String = "",
    var name: String = "",
    var type: String = "",
        )
