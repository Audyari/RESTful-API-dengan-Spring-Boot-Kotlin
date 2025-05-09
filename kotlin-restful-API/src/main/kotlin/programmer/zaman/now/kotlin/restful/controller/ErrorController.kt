package programmer.zaman.now.kotlin.restful.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import programmer.zaman.now.kotlin.restful.model.WebResponse
import jakarta.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    
    @ExceptionHandler(ConstraintViolationException::class)
    fun validationHandler(ex: ConstraintViolationException): ResponseEntity<WebResponse<String>> {
        val violations = ex.constraintViolations
        val errors = violations.map { "${it.propertyPath}: ${it.message}" }
        
        val webResponse = WebResponse(
            code = 400,
            status = "BAD_REQUEST",
            data = errors.joinToString(", ")
        )
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(webResponse)
    }

    @ExceptionHandler(RuntimeException::class)
    fun duplicateIdHandler(
        ex: RuntimeException
    ): ResponseEntity<WebResponse<String>> {
        return ResponseEntity(
            WebResponse(
                code = 400,
                status = "BAD_REQUEST",
                data = ex.message ?: "Product ID already exists"
            ),
            HttpStatus.BAD_REQUEST
        )
    }
}