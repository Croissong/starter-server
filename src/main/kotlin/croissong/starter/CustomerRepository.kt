package croissong.starter

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param


interface CustomerRepository : CrudRepository<Customer, Long> {

    fun findByLastName(lastName: String): List<Customer>

    @Query(value = "select * from customer where last_name like :startswith and last_name like :endswith", nativeQuery = true)
    fun testQuery(@Param("startswith") startsWith: String, @Param("endswith") endsWith: String): List<Customer>

}