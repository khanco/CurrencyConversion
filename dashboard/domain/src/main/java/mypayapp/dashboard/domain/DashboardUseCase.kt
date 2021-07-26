package mypayapp.dashboard.domain

import mypayapp.domain.models.BaseResponse
import mypayapp.domain.models.QuoteEntity

interface DashboardUseCase {
    suspend fun fetchExchangeRates(): BaseResponse<String>
    suspend fun saveAllExchangeRates(listOfQuotes: List<QuoteEntity>)
    suspend fun getSavedExchangeRates(): List<QuoteEntity>
    fun getLastSavedTimeStamp(): Long
    fun saveCurrentTimeStamp(currentTimeMillis: Long)
}

class DashboardUseCaseImpl(private val repository: DashboardRepository) : DashboardUseCase {
    override suspend fun fetchExchangeRates() = repository.fetchDataForExchangeRates()
    override suspend fun saveAllExchangeRates(listOfQuotes: List<QuoteEntity>) =
        repository.saveAllExchangeRates(listOfQuotes)

    override suspend fun getSavedExchangeRates() = repository.getSavedExchangeRate()
    override fun getLastSavedTimeStamp() = repository.getLastSavedTimeStamp()
    override fun saveCurrentTimeStamp(currentTimeMillis: Long) =
        repository.saveCurrentTimeStamp(currentTimeMillis)
}