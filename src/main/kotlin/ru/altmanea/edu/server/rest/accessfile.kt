package ru.altmanea.edu.server.rest

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.altmanea.edu.server.model.Config.Companion.uploadPath
public var wayToFile: String = ""    //Объявляется для всего сервера
fun Route.upload() =
    route(uploadPath) {
        //запрос на чтение пути файла
        post{
            wayToFile = call.receive<String>().replace("\"", "")  // в переменную записывается строка
            call.respondText("Path add correctly",
                status = HttpStatusCode.Created)
        }
    }