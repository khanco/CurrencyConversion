package mypayapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mypayapp.data.database.entities.exchangequote.ExchangeRateDao
import mypayapp.domain.models.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exchangeRateDao(): ExchangeRateDao
}