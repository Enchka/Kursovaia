package ru.altmanea.edu.server.rest

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.altmanea.edu.server.model.Config.Companion.uploadPath
public var wayToFile: String = ""   //Объявляется для всего сервера, в нем хранится путь файла (чтобы спокойно считывать его в repo)
fun Route.upload() =
    route(uploadPath) {
        //запрос на чтение пути файла (активируентся при нажатии кнопочки, не той самой с преподов, а другой)
        post{
            wayToFile = call.receive<String>().replace("\"", "")  // в переменную записывается строка (изначально она приходит с доп кавычками и их мы меняем на  ничто) ""<- ничто в записи (пустота)
            call.respondText("Path add correctly",
                status = HttpStatusCode.Created)
        }
    }