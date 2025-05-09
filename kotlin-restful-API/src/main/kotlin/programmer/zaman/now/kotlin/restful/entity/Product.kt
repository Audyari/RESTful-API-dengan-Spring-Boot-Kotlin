package programmer.zaman.now.kotlin.restful.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "product")
@SequenceGenerator(
    name = "product_sequence",
    sequenceName = "product_sequence",
    allocationSize = 1
)
class Product(
    @Id
    @Column(name = "id", length = 50, updatable = false)
    val id: String,

    @Column(name = "name", length = 100, nullable = false)
    val name: String,

    @Column(name = "price", nullable = false)
    val price: Long,

    @Column(name = "quantity", nullable = false)
    val quantity: Int,

    @Column(name = "created_at", nullable = false)
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date?
) {
    init {
        require(id.isNotBlank()) { "ID tidak boleh kosong" }
        require(id.length in 3..50) { "ID harus antara 3-50 karakter" }
        require(name.isNotBlank()) { "Nama tidak boleh kosong" }
        require(name.length in 3..100) { "Nama harus antara 3-100 karakter" }
        require(price > 0) { "Harga harus lebih dari 0" }
        require(quantity >= 0) { "Jumlah harus lebih dari atau sama dengan 0" }
    }
}
