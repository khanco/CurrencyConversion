package mypayapp.dashboard.ui.viewmodel

import mypayapp.dashboard.domain.models.ExchangeRates
import mypayapp.dashboard.domain.models.Quotes
import mypayapp.dashboard.ui.views.DashboardViewState
import mypayapp.ui.base.BaseViewModel

class DashboardViewModel : BaseViewModel() {

    val viewState = DashboardViewState()

    fun setData() {
        val exchangeRates = ExchangeRates(
            success = true,
            timestamp = 1232423,
            quotes = ArrayList<Quotes>().apply {
                this.add(Quotes("INR", "74.44315"))
                this.add(Quotes("USD", "1"))
                this.add(Quotes("JPY", "110.528499"))
            }
        )
    }
}