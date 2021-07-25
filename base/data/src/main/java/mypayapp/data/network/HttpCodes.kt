package mypayapp.data.network

sealed class HttpCodes {
    data class Http999(val code: Int = CODE_999, val message: String = SERVER_ERROR_SOMETHING_WRONG)
    data class Http413(val code: Int = CODE_413, val message: String = SERVER_ERROR_REQUEST_ENTITY_LARGE)
    data class Http404(val code: Int = CODE_404, val message: String = SERVER_ERROR_DATA_NOT_AVAILABLE)
    data class Http204(val code: Int = CODE_204, val message: String = SERVER_ERROR_NO_RESPONSE)
}