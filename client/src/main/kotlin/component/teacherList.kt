package component

import kotlinext.js.jso
import react.Props
import react.dom.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.li
import react.dom.ol
import react.fc
import react.query.useMutation
import react.query.useQuery
import react.query.useQueryClient
import react.router.dom.Link
import ru.altmanea.edu.server.model.Config.Companion.teachersURL
import ru.altmanea.edu.server.model.Item
import ru.altmanea.edu.server.model.Teacher
import wrappers.AxiosResponse
import wrappers.QueryError
import wrappers.axios
import kotlin.js.json

external interface TeacherListProps : Props {
    var teachers : List<Item<Teacher>>
}

fun fcTeacherList() = fc("TeacherList"){ props: TeacherListProps ->
    h3 {"Teachers"}
    ol {
        props.teachers.mapIndexed { _, teacherItem ->
            li {
                val teacher =  teacherItem.elem
                Link {
                    attrs.to = "/teacher/${teacherItem.uuid}"
                    +"${teacher.teacherName} \t"
                }
            }
        }
    }
    h3{"getDB"}
}
fun fcContainerTeacherList() = fc("QueryTeacherList") { _: Props ->
    val query = useQuery<Any, QueryError, AxiosResponse<Array<Item<Teacher>>>, Any>(
        "teachersList",
        {
            axios<Array<Teacher>>(jso {
                url = teachersURL
            })
        }
    )
    if (query.isLoading) div { +"Loading .." }
    else if (query.isError) div { +"Error!" }
    else {
        val items = query.data?.data?.toList() ?: emptyList()
        child(fcTeacherList()) {
            attrs.teachers = items
        }
    }
}