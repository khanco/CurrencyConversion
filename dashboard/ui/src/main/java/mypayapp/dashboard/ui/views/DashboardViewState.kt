package mypayapp.dashboard.ui.views

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import mypayapp.dashboard.domain.models.Quotes
import mypayapp.dashboard.ui.BR
import mypayapp.dashboard.ui.utils.bind

class DashboardViewState(
    initAmount: String = "0",
    initCurrencyChosen: String = "",
    initExchangeRates: List<Quotes> = emptyList()
) : BaseObservable() {

    @get: Bindable
    val amount by bind(
        BR.amount,
        initAmount
    )

    @get: Bindable
    val currencyChosen by bind(
        BR.currencyChosen,
        initCurrencyChosen
    )

    @get: Bindable
    val exchangeRates by bind(
        BR.exchangeRates,
        initExchangeRates
    )
}