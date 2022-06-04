package component

import kotlinext.js.jso
import kotlinx.html.INPUT
import kotlinx.html.js.onClickFunction
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.files.FileReader
import react.Props
import react.dom.button
import react.dom.input
import react.dom.p
import react.fc
import react.query.useMutation
import react.useRef
import react.useState
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.model.Config.Companion.uploadPath
import wrappers.axios
import kotlin.js.json

external interface UploadProps: Props {
    var sendWay: (String) -> Unit
}

fun fcUpload() = fc("Upload") { props: UploadProps ->
    val wayRef = useRef<INPUT>()

    p {
        +"Way:"
    }
    input {
        ref = wayRef
    }
    button {
        +"Upload"

        attrs.onClickFunction = {
            val way = wayRef.current?.value ?: ""

            props.sendWay(way)
        }
    }
}

fun fcContainerUpload() = fc("ContainerUpload") { _: Props ->
    val sendWayMutation = useMutation<Any, Any, String, Any>(
        { way ->
            axios<String>(jso {
                url = "$uploadPath"
                method = "Post"
                headers = json(
                    "Content-Type" to "application/json"
                )
                data = Json.encodeToString(way)
            })
        }
    )

    child(fcUpload()) {
        attrs.sendWay = {
            sendWayMutation.mutate(it, null)
        }
    }
}