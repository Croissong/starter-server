package croissong.starter

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Executors

@Configuration
open class SchedulerConfiguration(@Value("\${spring.datasource.maximum-pool-size}") private var connectionPoolSize: Int) {
    @Bean
    open fun jdbcScheduler(): Scheduler {
        return Schedulers.fromExecutor(Executors.newFixedThreadPool(connectionPoolSize))
    }
}

