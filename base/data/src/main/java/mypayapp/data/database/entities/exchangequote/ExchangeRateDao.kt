package mypayapp.data.database.entities.exchangequote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import mypayapp.domain.models.QuoteEntity

@Dao
interface ExchangeRateDao {

    @Query("SELECT * FROM QuoteEntity")
    fun getAllQuoteEntity(): List<QuoteEntity>

    @Query("SELECT COUNT(currencyCode) FROM QuoteEntity")
    fun getCount(): Int

    @Query("SELECT * FROM QuoteEntity WHERE currencyCode = :currencyCode")
    fun getQuoteById(currencyCode: String): QuoteEntity

    @Insert
    fun insertAll(quoteEntity: List<QuoteEntity>)

    @Insert
    fun insert(quoteEntity: QuoteEntity)

    @Update
    fun updateQuote(QuoteEntity: QuoteEntity)
}