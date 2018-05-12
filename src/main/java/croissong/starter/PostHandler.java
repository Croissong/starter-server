package croissong.starter;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class PostHandler {

    private WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

    private Mono<ClientResponse> result = client.get()
            .uri("/posts/1")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public Mono<ServerResponse> hello(ServerRequest request) {
        return result.flatMap(res -> res.bodyToMono(String.class))
                .flatMap(body -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(body)));
    }
}