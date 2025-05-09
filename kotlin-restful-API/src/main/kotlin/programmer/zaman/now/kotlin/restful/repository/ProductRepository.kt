package programmer.zaman.now.kotlin.restful.repository

import programmer.zaman.now.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String> {
    
    override fun existsById(id: String): Boolean

}