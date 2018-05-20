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
class MyBean(private var repository: ShipRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        val log = LoggerFactory.getLogger(StarterApplication::class.java)
        // fetch all customers
        log.info("Customers found with findAll():")
        log.info("-------------------------------")
        repository.findByName("C%").forEach { c -> log.info(c.toString()) }
        log.info("")
        // fetch an individual customer by ID
        repository.findById(1).ifPresent { customer ->
            log.info("Ship found with findById(1):")
            log.info("--------------------------------")
            log.info(customer.toString())
            log.info("")
        }
        // fetch customers by last name
        log.info("Ship found with findByLastName('Bauer'):")
        log.info("--------------------------------------------")
        repository.findByName("Bauer").forEach { bauer ->
            log.info(bauer.toString())
        }
    }

}