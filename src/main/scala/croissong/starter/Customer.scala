package croissong.starter

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity class Customer (firstName: String, lastName: String) {
  def this() = this(null, null)
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) private val id = 0L


  override def toString: String = s"Customer[id=$id, firstName='$firstName', lastName='$lastName']"


}