package programmer.zaman.now.kotlin.restful.validation

import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import org.springframework.stereotype.Component

@Component
class ValidationUtil {
    private lateinit var validator: Validator

    init {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        validator = factory.validator
    }

    fun validate(any: Any) {
        val violations = validator.validate(any)
        if (violations.isNotEmpty()) {
            throw jakarta.validation.ConstraintViolationException(violations)
        }
    }
}