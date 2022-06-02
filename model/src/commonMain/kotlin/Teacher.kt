package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable

data class Teacher (
    var teacherName: String,
    var table: TimeTable //расписание
        )
