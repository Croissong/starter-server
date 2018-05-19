package croissong.starter

import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct


@Component
class PostHandler(private var repository: CustomerRepository, private var asyncWrapper: AsyncJdbcWrapper) {

    fun hello2(request: ServerRequest): Mono<ServerResponse> {
        val customers = asyncWrapper.async { repository.testQuery("Ba%", "%er") }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(customers, object : ParameterizedTypeReference<List<Customer>>() {})
    }

    @PostConstruct
    fun init(): Unit {


    }
}