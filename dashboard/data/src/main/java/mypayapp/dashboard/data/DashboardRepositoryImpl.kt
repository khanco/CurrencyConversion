package mypayapp.dashboard.data

import mypayapp.dashboard.domain.DashboardRepository
import mypayapp.data.database.AppDatabase
import mypayapp.data.datasource.DataSource
import mypayapp.data.datasource.REQUEST_TYPE_GET
import mypayapp.data.network.InternetConnectivity
import mypayapp.domain.models.BaseResponse
import mypayapp.domain.models.QuoteEntity

class DashboardRepositoryImpl(
    private val dataSource: DataSource,
    private val database: AppDatabase,
    private val internetConnectivity: InternetConnectivity
) : DashboardRepository {
    override suspend fun fetchDataForExchangeRates(): BaseResponse<String> {
        return if (internetConnectivity.isOnline()) {
            val rawResponse = dataSource.fetchData(
                API_EXCHANGE_RATES, requestType = REQUEST_TYPE_GET
            )
            if (rawResponse.isSuccessful) {
                BaseResponse.Success(
                    rawResponse.body().toString()
                )
            } else {
                BaseResponse.ApiError(
                    errorCode = rawResponse.code(),
                    message = dataSource.getErrorMessage(rawResponse.errorBody()?.string())
                )
            }
        } else {
            BaseResponse.NetworkError
        }
    }

    override suspend fun saveAllExchangeRates(listOfQuotes: List<QuoteEntity>) {

        val quoteDao = database.exchangeRateDao()

        if (quoteDao.getAllQuoteEntity().isEmpty()) {
            quoteDao.insertAll(listOfQuotes)
        } else {
            listOfQuotes.forEach {
                quoteDao.updateQuote(it)
            }
        }
    }

    override suspend fun getSavedExchangeRate() = database.exchangeRateDao().getAllQuoteEntity()

    override fun getLastSavedTimeStamp() =
        dataSource.getData(TIME_STAMP_WHEN_RATES_WAS_FETCHED, 0L) as Long

    override fun saveCurrentTimeStamp(currentTimeMillis: Long) {
        dataSource.putData(TIME_STAMP_WHEN_RATES_WAS_FETCHED, currentTimeMillis)
    }
}