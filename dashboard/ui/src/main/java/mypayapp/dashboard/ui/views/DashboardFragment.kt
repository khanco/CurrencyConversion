package mypayapp.dashboard.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import mypayapp.dashboard.ui.databinding.FragmentDashboardBinding
import mypayapp.dashboard.ui.model.ConvertedRates
import mypayapp.dashboard.ui.viewmodel.DashboardViewModel
import mypayapp.ui.adapter.setItems
import mypayapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class DashboardFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    private val viewModelDashboard by lazy { requireActivity().getViewModel<DashboardViewModel>() }
    private var selectedCurrencyPosition = 0

    companion object {
        fun getInstance() = DashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDashboardBinding.inflate(inflater, container, false).apply {
        viewModel = viewModelDashboard
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        viewModelDashboard.getDataForExchangeRates()
        initListeners()
    }

    private fun initListeners() {
        spnSelectCurrency.onItemSelectedListener = this
    }

    private fun initObserver() {
        viewModelDashboard.listOfQuotes.observe(viewLifecycleOwner, {
            spnSelectCurrency.adapter =
                activity?.applicationContext?.let { it1 -> CurrencyCodeAdapter(it1, it) }
        })

        viewModelDashboard.amount.observe(viewLifecycleOwner, {
            setExchangeRate()
        })

        viewModelDashboard.errorMessage.observe(viewLifecycleOwner, {
            showToast(it)
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedCurrencyPosition = position
        setExchangeRate()
    }

    /***
     * This method is responsible for calculating exchange rates for all currencies
     */
    private fun setExchangeRate() {
        val listConvertedRates = ArrayList<ConvertedRates>()
        viewModelDashboard.amount.value?.let { amount ->
            if (amount.isNotBlank()) {
                val amountDouble: Double = amount.toDouble()
                viewModelDashboard.listOfQuotes.value?.let {
                    it.forEach { item ->
                        val convertFactor =
                            viewModelDashboard.getConvertedRate(
                                item.exchangeRate,
                                it[selectedCurrencyPosition]
                            )
                        val convertedRates = ConvertedRates(
                            currencyCode = item.currencyCode,
                            amount = String.format("%.2f", amountDouble * convertFactor),
                            rates = convertFactor.toString()
                        )
                        listConvertedRates.add(convertedRates)
                    }
                }
                setRecyclerAdapter(listConvertedRates)
            } else {
                /** set empty value if nothing entered in number input
                 */
                setRecyclerAdapter(ArrayList())
            }
        }
    }

    private fun setRecyclerAdapter(listConvertedRates: ArrayList<ConvertedRates>) {
        if (rvExchangeRates.adapter == null) {
            rvExchangeRates.layoutManager = GridLayoutManager(activity, 4)
            rvExchangeRates.adapter = ExchangeRateAdapter()
        }
        rvExchangeRates.setItems(listConvertedRates)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Nothing to implement here
    }
}