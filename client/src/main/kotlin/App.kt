import component.fcContainerTeacher
import component.fcContainerTeacherList
import component.fcContainerUpload
import kotlinx.browser.document
import react.createElement
import react.dom.h1
import react.dom.render
import react.query.QueryClient
import react.query.QueryClientProvider
import react.router.Route
import react.router.Routes
import react.router.dom.HashRouter
import react.router.dom.Link
import wrappers.cReactQueryDevtools

val queryClient = QueryClient()

fun main() {
    render(document.getElementById("root")!!){
        HashRouter { QueryClientProvider{
            attrs.client = queryClient
            Link{ attrs.to = "/"
                +"Teachers"
            }
            + "    "
            Link{
                attrs.to = "/upload"
                +"Upload"
            }
            Routes {
                Route { attrs.index = true
                    attrs.element =
                        createElement(fcContainerTeacherList())
                }
                Route {attrs.path = "/teacher/:id"
                    attrs.element =
                        createElement(fcContainerTeacher())
                }
                Route {
                    attrs.path = "/upload"
                    attrs.element =
                        createElement(fcContainerUpload())
                }
            }
            child(cReactQueryDevtools()){}
        }}
    }
}

