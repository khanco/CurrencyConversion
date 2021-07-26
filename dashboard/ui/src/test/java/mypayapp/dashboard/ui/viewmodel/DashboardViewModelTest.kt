package mypayapp.dashboard.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import mypayapp.dashboard.domain.DashboardUseCase
import mypayapp.domain.models.QuoteEntity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class DashboardViewModelTest {

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val useCase = mock<DashboardUseCase>()

    @Test
    fun `fetch data from LOCAL if time stamp is not expired`() = coroutineRule.runBlockingTest {

        // given
        val viewModel = DashboardViewModel(useCase)
        whenever(useCase.getLastSavedTimeStamp()).doReturn(100000000000000L)

        // when
        viewModel.getDataForExchangeRates()

        // then
        verify(useCase).getSavedExchangeRates()
    }

    @Test
    fun `fetch data from API if time stamp is expired`() = coroutineRule.runBlockingTest {

        // given
        val viewModel = DashboardViewModel(useCase)
        whenever(useCase.getLastSavedTimeStamp()).doReturn(10000000L)

        // when
        viewModel.getDataForExchangeRates()

        // then
        verify(useCase).fetchExchangeRates()
    }

    @Test
    fun `check exchange rate`() {

        // given
        val viewModel = DashboardViewModel(useCase)

        val exchangeRateForUS = 74.45
        val quoteEntity = QuoteEntity(currencyCode = "INR", exchangeRate = 1.0)
        assert(viewModel.getConvertedRate(exchangeRateForUS, quoteEntity) == 74.45)
    }
}