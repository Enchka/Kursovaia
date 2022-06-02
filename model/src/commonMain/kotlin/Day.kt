package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
class Day (
    var dayOfWeek: String, //название дня
    var classes: MutableList<Lesson> //пары в этот день
)

