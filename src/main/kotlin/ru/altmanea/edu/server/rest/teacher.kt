package ru.altmanea.edu.server.rest

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.apache.poi.xssf.usermodel.XSSFSheet
import ru.altmanea.edu.server.model.Config.Companion.teachersPath
import ru.altmanea.edu.server.repo.ReturnsArrayOfTeachers
import ru.altmanea.edu.server.repo.mapLessons
import ru.altmanea.edu.server.repo.tables
import ru.altmanea.edu.server.repo.teacherRepo

fun Route.teacher() =
route(teachersPath) {
    //Получение списка всех преподователей
    get {
        if (!teacherRepo.isEmpty()) {
            call.respond(teacherRepo.findAll())
        } else {
            call.respondText(
                "No teachers found",
                status = HttpStatusCode.NotFound
            )
        }
    }

    get("{id}"){
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing or malformed id",
            status = HttpStatusCode.BadRequest
        )
        val teacherItem =
            teacherRepo[id] ?: return@get call.respondText(
                "No teacher with id $id",
                status = HttpStatusCode.NotFound
            ) //находим преподавателя по id
        call.respond(listOf(teacherItem.elem.teacherName))
    }
        // Получение списка ошибок через MutableList
    get("{id}/lesson"){
        val id = call.parameters["id"] ?: return@get call.respondText(
            "Missing or malformed id",
            status = HttpStatusCode.BadRequest
        )
        val teacherItem =
            teacherRepo[id] ?: return@get call.respondText(
                "No teacher with id $id",
                status = HttpStatusCode.NotFound
            )
        val teacherRepoDumpTestData = ReturnsArrayOfTeachers(tables as XSSFSheet)
            val teacherItemDump =
                teacherRepoDumpTestData.find { it.teacherName == teacherItem.elem.teacherName } //находим преподавателя в выгрузке Excel с таким же именем
        var i = 0
        var n: Int
        val table = teacherItem.elem.table
        val table1 = teacherItemDump?.table

        if(table1 != null){
        while(i < 6){
            n = 0
                while (n < 5){
                    if( (table.upWeek[i].classes[n].name != table1.upWeek[i].classes[n].name)){
                        val lesson1 = table.upWeek[i].classes[n].name
                        val lesson2 = table1.upWeek[i].classes[n].name
                        val pair = lesson1 to lesson2
                        mapLessons += pair
                    }
                    if( (table.lowWeek[i].classes[n].name != table1.lowWeek[i].classes[n].name)){
                        val lesson1 = table.lowWeek[i].classes[n].name
                        val lesson2 = table1.lowWeek[i].classes[n].name
                        val pair = lesson1 to lesson2
                        mapLessons += pair
                    }
                    n++
                }
            i++
        }
        }else {mapLessons += ("Test" to "data")}
        call.respond(mapLessons)
    }
    //Исправление ошибки берем ключ, находим его во всем репозитории и меняем на его значение
    put("{id}/lesson/{name}"){
        val id = call.parameters["id"] ?: return@put call.respondText(
            "Missing or malformed id",
            status = HttpStatusCode.BadRequest
        )
        val name = call.parameters["name"] ?: return@put call.respondText(
            "Missing or malformed name",
            status = HttpStatusCode.BadRequest
        )
        val teacherItem =
            teacherRepo[id] ?: return@put call.respondText(
                "No teacher with id $id",
                status = HttpStatusCode.NotFound
            )
        val changeName = mapLessons.getValue(name)
        mapLessons.remove(name)
        val table = teacherItem.elem.table
        var i = 0
        var n: Int
        while(i < 6){
            n = 0
            while (n < 5){
                if( (table.upWeek[i].classes[n].name == name)){
                    table.upWeek[i].classes[n].name = changeName
                }
                if( (table.lowWeek[i].classes[n].name == name)){
                    table.lowWeek[i].classes[n].name = changeName
                }
                n++
            }
            i++
        }
        call.respondText("Lesson name on server update correctly",
        status = HttpStatusCode.Created)
    }
}

