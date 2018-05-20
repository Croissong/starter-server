package croissong.starter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
open class RestRouter {
    @Bean
    open fun route(shipHandler: PostHandler): RouterFunction<ServerResponse> {
        return router {
            "/rest".nest {
                accept(MediaType.APPLICATION_JSON).nest {
                    GET("/ships", shipHandler::getAll)
                }
            }
        }
    }
}