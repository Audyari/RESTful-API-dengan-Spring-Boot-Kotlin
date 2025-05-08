package programmer.zaman.now.kotlin.restful.repository

import programmer.zaman.now.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
    
}