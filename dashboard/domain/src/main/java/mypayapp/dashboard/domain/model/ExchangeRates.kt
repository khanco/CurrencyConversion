package mypayapp.dashboard.domain.model

import mypayapp.domain.models.ApiResponseWrapper
import mypayapp.domain.models.QuoteEntity

data class ExchangeRates(
    val quotes: ArrayList<QuoteEntity>,
) : ApiResponseWrapper()