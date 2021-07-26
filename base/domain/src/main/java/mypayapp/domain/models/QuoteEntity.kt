package mypayapp.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteEntity(
    @PrimaryKey val currencyCode: String,
    @ColumnInfo val exchangeRate: Double
)