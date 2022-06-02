package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable

data class TimeTable(
    val upWeek: MutableList<Day>,
    val lowWeek: MutableList<Day>
)
