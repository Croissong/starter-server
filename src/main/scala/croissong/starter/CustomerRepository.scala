package croissong.starter

import java.util
import java.util.concurrent.CompletableFuture

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.Async
import reactor.core.publisher.Mono


trait CustomerRepository extends CrudRepository[Customer, Long] {
  @Async
  def findByLastName(lastName: String): CompletableFuture[util.List[Customer]]

  @Async
  @Query(value = "select * from customer where first_name like :startswith", nativeQuery = true)
  def testQuery(@Param("startswith") startsWith: String): CompletableFuture[util.List[Customer]]
}