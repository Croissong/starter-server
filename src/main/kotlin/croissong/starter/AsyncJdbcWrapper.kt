package croissong.starter

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Callable

@Component
class AsyncJdbcWrapper(private val jdbcScheduler: Scheduler) {
    fun <T> async(callable: () -> T): Mono<T> {
        return Mono.fromCallable(callable).subscribeOn(jdbcScheduler).publishOn(Schedulers.parallel())
    }
}