package mypayapp.dashboard.domain

import mypayapp.domain.models.BaseResponse
import mypayapp.domain.models.QuoteEntity

interface DashboardRepository {
    suspend fun fetchDataForExchangeRates(): BaseResponse<String>
    suspend fun saveAllExchangeRates(listOfQuotes: List<QuoteEntity>)
    suspend fun getSavedExchangeRate(): List<QuoteEntity>
    fun getLastSavedTimeStamp(): Long
    fun saveCurrentTimeStamp(currentTimeMillis: Long)
}