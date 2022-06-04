package component

import kotlinext.js.jso
import kotlinx.html.js.onClickFunction
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import queryClient
import react.Props
import react.dom.button
import react.dom.div
import react.dom.h3
import react.dom.p
import react.fc
import react.query.useMutation
import react.query.useQuery
import react.router.useParams
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.model.Item
import ru.altmanea.edu.server.model.Lesson
import ru.altmanea.edu.server.model.Teacher
import wrappers.AxiosResponse
import wrappers.QueryError
import wrappers.axios
import wrappers.fetchText
import kotlin.js.json

external interface TeacherProps : Props {
    var map: MutableMap<String, String>
    var teacherName: String
    var sendErrorKey: (String) -> Unit

}

fun fcTeacher() = fc("Teacher") { props: TeacherProps ->
    h3 { +props.teacherName }
    for (item in props.map) {
        p {
            +item.toString()
        }
        button { +"Update"
        attrs.onClickFunction = {
            props.sendErrorKey(item.key)
        }}
    }
}

fun fcContainerTeacher() = fc("QueryTeacherList") { _: Props ->

    val teacherParams = useParams()

    val teacherId = teacherParams["id"] ?: "Route param error"

    val query1 = useQuery<Any, Any, String, Any>(
        "lessonsList",
        {
            fetchText (
                "${Config.teachersPath}/$teacherId"
            )
        }
    )

    val query = useQuery<Any, Any, String, Any>(
        teacherId,
        {
            fetchText(
                "${Config.teachersURL}/$teacherId/lesson"
            )
        }
    )

    val updateLessonNameMutation = useMutation<Any, Any, String, Any>(
        { name ->
            axios<String>(jso {
                url = "${Config.teachersURL}/$teacherId/lesson/$name"
                method = "Put"
                data = Json.encodeToString(name)
                headers = json(
                    "Content-Type" to "application/json"
                )
            })
        },
        options = jso {
            onSuccess = { _: Any, _: Any, _: Any? ->
                queryClient.invalidateQueries<Any>(teacherId)
            }
        }
    )


    if (query.isLoading or query1.isLoading ) {
        div { +"Loading .." }
    } else if (query.isError or query1.isError) {
        div { +"Error!" }
    } else {
        val map: MutableMap<String,String> = Json.decodeFromString(query.data ?: "") //для карты с ошибками
        val teacher: List<String> = Json.decodeFromString(query1.data ?: "")         //кнопка исправления ошибок
        child(fcTeacher()) {
            attrs.map = map
            attrs.teacherName = teacher[0]
            attrs.sendErrorKey = {
                updateLessonNameMutation.mutate(it, null)
            }
        }
    }
}



