package programmer.zaman.now.kotlin.restful.model

import jakarta.validation.constraints.*

data class CreateProductRequest(
    
    @field:NotBlank(message = "ID tidak boleh kosong")
    @field:Size(min = 3, max = 50, message = "ID harus antara 3-50 karakter")
    val id: String?,
    
    @field:NotBlank(message = "Nama tidak boleh kosong")
    @field:Size(min = 3, max = 100, message = "Nama harus antara 3-100 karakter")
    val name: String?,
    
    @field:Min(value = 1, message = "Harga minimal adalah 1")
    val price: Long?,
    
    @field:Min(value = 0, message = "Jumlah minimal adalah 0")
    val quantity: Int?
)
