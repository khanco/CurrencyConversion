package mypayapp.data.network

import mypayapp.data.utils.SOMETHING_WENT_WRONG

//codes
const val CODE_999 = 999

sealed class HttpCodes {
    data class HttpCustomError(
        val code: Int = CODE_999,
        val message: String = SOMETHING_WENT_WRONG
    )
}