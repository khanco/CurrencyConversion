package mypayapp.domain.models

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class BaseResponse<out R> {

    data class Success<out T>(val data: T) : BaseResponse<T>()
    data class Error(val exception: Exception) : BaseResponse<Nothing>()
    data class ApiError(val message: String, val errorCode: Int) : BaseResponse<Nothing>()
    object Loading : BaseResponse<Nothing>()
    object NetworkError : BaseResponse<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception]"
            is ApiError -> "ApiError[message=$message, errorCode:$errorCode]"
            is NetworkError -> "Network Error"
            Loading -> "Loading"
        }
    }
}

/**
 * [Success.data] if [Result] is of type [Success]
 */
fun <T> BaseResponse<T>.successOr(fallback: T): T {
    return (this as? BaseResponse.Success<T>)?.data ?: fallback
}

val <T> BaseResponse<T>.data: T?
    get() = (this as? BaseResponse.Success)?.data
