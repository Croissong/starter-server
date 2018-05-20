package croissong.starter

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class PostHandler(private var repository: ShipRepository, private var asyncWrapper: AsyncJdbcWrapper) {

    fun getAll(_req: ServerRequest): Mono<ServerResponse> {
        val ships = asyncWrapper.async { repository.findAll() }
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(ships, object : ParameterizedTypeReference<Iterable<Ship>>() {})
    }
}