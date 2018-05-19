package croissong.starter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router


@Configuration
open class PostRouter {
    @Bean
    open fun route(greetingHandler: PostHandler): RouterFunction<ServerResponse> {
        return router {
            accept(MediaType.TEXT_HTML).nest {
                GET("/post/1", greetingHandler::hello2)
            }
        }
    }
}