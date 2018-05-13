package croissong.starter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse


@Configuration class PostRouter {
  @Bean def route(greetingHandler: PostHandler): RouterFunction[ServerResponse] =
    RouterFunctions.route(RequestPredicates.GET("/rest/post/1").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), greetingHandler.hello)
}