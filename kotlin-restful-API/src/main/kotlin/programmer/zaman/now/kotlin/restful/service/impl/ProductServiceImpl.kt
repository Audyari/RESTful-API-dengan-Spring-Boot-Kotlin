package programmer.zaman.now.kotlin.restful.service.impl

import org.springframework.stereotype.Service
import programmer.zaman.now.kotlin.restful.entity.Product
import programmer.zaman.now.kotlin.restful.model.CreateProductRequest
import programmer.zaman.now.kotlin.restful.model.ProductResponse
import programmer.zaman.now.kotlin.restful.repository.ProductRepository
import programmer.zaman.now.kotlin.restful.service.ProductService
import programmer.zaman.now.kotlin.restful.validation.ValidationUtil
import java.util.*

@Service
// (1) Class utama yang mengimplementasikan ProductService
//     - Menerima ProductRepository sebagai dependency
//     - Mewarisi interface ProductService
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val validationUtil: ValidationUtil
) : ProductService {
   
    // (2) Method untuk membuat produk baru
    //     - Menerima CreateProductRequest dari controller
    //     - Mengembalikan ProductResponse
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        // Validasi request
        validationUtil.validate(createProductRequest)
        

        // Periksa apakah ID sudah ada
        if (createProductRequest.id?.let { productRepository.existsById(it) } == true) {
            throw RuntimeException("Product with ID ${createProductRequest.id} already exists")
        }

        // (3) Membuat objek Product baru dengan data dari request
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),  // (4) Menambahkan timestamp saat dibuat
            updatedAt = null     // (5) updatedAt null karena ini data baru
        )
        
        // (6) Menyimpan data ke database
        productRepository.save(product)
        
        // (7) Membuat dan mengembalikan ProductResponse
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}