package croissong.starter


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Customer(var firstName: String="", var lastName: String="") {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id = 0L

    override fun toString(): String = "Customer[id=$id, firstName='$firstName', lastName='$lastName']"


}