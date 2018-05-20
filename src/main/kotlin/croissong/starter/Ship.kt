package croissong.starter


import javax.persistence.*


@Entity
data class Ship(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val speed: Float
)