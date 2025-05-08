package programmer.zaman.now.kotlin.restful.service

import programmer.zaman.now.kotlin.restful.model.CreateProductRequest
import programmer.zaman.now.kotlin.restful.model.ProductResponse

/**
 * Interface untuk service layer yang menangani operasi produk
 * @author Your Name
 */
interface ProductService {
    /**
     * Method untuk membuat produk baru
     * @param createProductRequest Data produk yang akan dibuat
     * @return Data produk yang sudah dibuat
     */
    fun create(createProductRequest: CreateProductRequest): ProductResponse

  
}
