package programmer.zaman.now.kotlin.restful.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, World!"
    }
}
