package mypayapp.dashboard.domain.models

data class ExchangeRates(
    val quotes: ArrayList<Quotes>,
    val success: Boolean,
    val timestamp: Long
)

data class Quotes(
    val currencyCode: String,
    val exchangeRate: String
)