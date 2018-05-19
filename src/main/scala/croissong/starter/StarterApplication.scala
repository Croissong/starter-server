package croissong.starter

import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.slf4j.LoggerFactory


@SpringBootApplication
class StarterApplication

object StarterApplication extends App {
    private val log = LoggerFactory.getLogger(classOf[StarterApplication])

    SpringApplication.run(classOf[StarterApplication])

    @Bean def demo(repository: CustomerRepository): CommandLineRunner = (args: Array[String]) => {
        def foo(args: Array[String]) = { // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"))
            repository.save(new Customer("Chloe", "O'Brian"))
            repository.save(new Customer("Kim", "Bauer"))
            repository.save(new Customer("David", "Palmer"))
            repository.save(new Customer("Michelle", "Dessler"))
            // fetch all customers
            log.info("Customers found with findAll():")
            log.info("-------------------------------")
            import scala.collection.JavaConverters._
            repository.testQuery("C%").get().asScala.foreach(c => log.info(c.toString))
            log.info("")
            // fetch an individual customer by ID
            repository.findById(1L).ifPresent((customer: Customer) => {
                def foo(customer: Customer) = {
                    log.info("Customer found with findById(1L):")
                    log.info("--------------------------------")
                    log.info(customer.toString)
                    log.info("")
                }

                foo(customer)
            })
            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):")
            log.info("--------------------------------------------")
            repository.findByLastName("Bauer").get().forEach((bauer: Customer) => {
                def foo(bauer: Customer) = log.info(bauer.toString)

                foo(bauer)
            })
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("")
        }

        foo(args)
    }
}

