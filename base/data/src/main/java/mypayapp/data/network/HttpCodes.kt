package mypayapp.data.network

//codes
const val CODE_204 = 204
const val CODE_999 = 999
const val CODE_413 = 413
const val CODE_404 = 404

const val SERVER_ERROR_DATA_NOT_AVAILABLE = "Data not available"
const val SERVER_ERROR_REQUEST_ENTITY_LARGE = "Request Entity Too Large"
const val SERVER_ERROR_SOMETHING_WRONG =
    "Something went wrong or might be network issue. Please try again"
const val SERVER_ERROR_NO_RESPONSE =
    "Server has received the request but there is no information to send back"
const val SERVER_ERROR_SOMETHING_WENT_WRONG = "Something went wrong"

sealed class HttpCodes {
    data class HttpCustomError(
        val code: Int = CODE_999,
        val message: String = SERVER_ERROR_SOMETHING_WRONG
    )

    data class Http413(
        val code: Int = CODE_413,
        val message: String = SERVER_ERROR_REQUEST_ENTITY_LARGE
    )

    data class Http404(
        val code: Int = CODE_404,
        val message: String = SERVER_ERROR_DATA_NOT_AVAILABLE
    )

    data class Http204(val code: Int = CODE_204, val message: String = SERVER_ERROR_NO_RESPONSE)
}