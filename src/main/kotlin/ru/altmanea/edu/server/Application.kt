package ru.altmanea.edu.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.apache.poi.xssf.usermodel.XSSFSheet
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.repo.*
import ru.altmanea.edu.server.rest.teacher
import ru.altmanea.edu.server.rest.upload


fun main() {
    embeddedServer(
        Netty,
        port = Config.serverPort,
        host = Config.serverDomain,
        watchPaths = listOf("classes", "resources")
    ) {
        main()
    }.start(wait = true)
}

fun Application.main(test: Boolean = true) {
    if(test) {
        teacherRepoTestData.forEach { teacherRepo.create(it) }
    }
    //val teachersRepoDumpTestData = ReturnsArrayOfTeachers(tables as XSSFSheet)
    //teachersRepoDumpTestData.isEmpty()
    install(ContentNegotiation) {
        json()
    }
    routing {
        teacher()
        upload()
        index()
    }
}