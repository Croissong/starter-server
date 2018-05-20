package croissong.starter


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Customer {

    private lateinit var firstName: String
    private lateinit var lastName: String

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id = 0L

    override fun toString(): String = "Customer[id=$id, firstName='$firstName', lastName='$lastName']"

}