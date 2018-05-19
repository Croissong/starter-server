package croissong.starter

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@SpringBootApplication
open class StarterApplication

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args)
}

@Component
class MyBean(private var repository: CustomerRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        val log = LoggerFactory.getLogger(StarterApplication::class.java)
        // save a couple of customers
        repository.save(Customer("Jack", "Bauer"))
        repository.save(Customer("Chloe", "O'Brian"))
        repository.save(Customer("Kim", "Bauer"))
        repository.save(Customer("David", "Palmer"))
        repository.save(Customer("Michelle", "Dessler"))
        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        repository.findByLastName("C%").forEach { c -> log.info(c.toString()) }
        log.info("")
        // fetch an individual customer by ID
        repository.findById(1L).ifPresent { customer ->
            log.info("Customer found with findById(1L):")
            log.info("--------------------------------")
            log.info(customer.toString())
            log.info("")
        }
        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        repository.findByLastName("Bauer").forEach { bauer ->
            log.info(bauer.toString())
        }
    }

}