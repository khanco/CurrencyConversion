package mypayapp.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import mypayapp.data.database.entities.exchangequote.ExchangeRateDao
import mypayapp.domain.models.QuoteEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {

    private lateinit var database: AppDatabase
    private lateinit var dao: ExchangeRateDao

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = database.exchangeRateDao()
    }

    @Test
    fun saveExchangeRateAndRead() {
        val quoteEntity = QuoteEntity("INR", 55.55)
        dao.insert(quoteEntity)
        val allQuotes = dao.getAllQuoteEntity()

        assertTrue(allQuotes.contains(quoteEntity))
    }

    @Test
    fun updateExchangeRateInsert() {
        val quoteEntity = QuoteEntity("INR", 55.55)
        dao.insert(quoteEntity)
        val updateQuoteEntity = QuoteEntity("INR", 100.00)
        dao.updateQuote(updateQuoteEntity)

        val allQuotes = dao.getAllQuoteEntity()
        assertFalse(allQuotes.contains(quoteEntity))
        assertTrue(allQuotes.contains(updateQuoteEntity))
    }

    @Test
    fun searchById() {
        val quoteEntity = QuoteEntity("INR", 55.55)
        dao.insert(quoteEntity)

        val quoteEntityById = dao.getQuoteById(quoteEntity.currencyCode)
        assertTrue(quoteEntityById == quoteEntity)
    }

    @Test
    fun insertAll() {
        val listOfQuotes = ArrayList<QuoteEntity>()
        val quoteEntity1 = QuoteEntity("INR", 74.55)
        val quoteEntity2 = QuoteEntity("USD", 1.00)

        listOfQuotes.add(quoteEntity1)
        listOfQuotes.add(quoteEntity2)

        dao.insertAll(listOfQuotes)

        val listOfSaveData = dao.getAllQuoteEntity()

        listOfSaveData.forEach {
            assertTrue(listOfQuotes.contains(it))
        }
    }

    @Test
    fun checkCount() {
        val quoteEntity = QuoteEntity("INR", 55.55)
        dao.insert(quoteEntity)

        assertTrue(dao.getCount() == 1)
    }

    @After
    fun closeDB() {
        database.close()
    }
}