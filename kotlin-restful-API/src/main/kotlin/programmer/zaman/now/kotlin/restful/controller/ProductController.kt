
package programmer.zaman.now.kotlin.restful.controller

import org.springframework.web.bind.annotation.*
import programmer.zaman.now.kotlin.restful.model.CreateProductRequest
import programmer.zaman.now.kotlin.restful.model.ProductResponse
import programmer.zaman.now.kotlin.restful.model.WebResponse
import programmer.zaman.now.kotlin.restful.service.ProductService

@RestController
class ProductController(val productService: ProductService) {

  @PostMapping(
            value = ["/api/products"],
            consumes = ["application/json"],
            produces = ["application/json"]
  )
  fun createProduct(@RequestBody body: CreateProductRequest):WebResponse<ProductResponse> {
   val productResponse = productService.create(body)
   return WebResponse(
     code = 200,
     status = "OK",
     data = productResponse
   )
  }
}