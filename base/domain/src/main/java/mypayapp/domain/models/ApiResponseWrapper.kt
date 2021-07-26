package mypayapp.domain.models

open class ApiResponseWrapper(
    val success: Boolean = false,
    val timestamp: Long = 0L,
    val error: Error? = null
)

data class Error(
    val code: Int,
    val info: String
)