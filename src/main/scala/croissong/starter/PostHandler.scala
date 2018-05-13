package croissong.starter

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component class PostHandler {
  private val client = WebClient.create("https://jsonplaceholder.typicode.com")

  def hello(request: ServerRequest): Mono[ServerResponse] = {
    val result = client.get.uri("/posts/1").accept(MediaType.APPLICATION_JSON).exchange
    result.flatMap((res) => res.bodyToMono(classOf[String]))
      .flatMap((body) => ServerResponse.ok.contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(body)))
  }
}