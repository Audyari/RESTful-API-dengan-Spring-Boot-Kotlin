package programmer.zaman.now.kotlin.restful.model

import java.util.Date

data class WebResponse<T>(
    val code: Int,
    val status: String,
    val data: T
)
