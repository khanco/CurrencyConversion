package mypayapp.dashboard.ui.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mypayapp.dashboard.ui.databinding.GridItemConversionRateBinding
import mypayapp.dashboard.ui.model.ConvertedRates
import mypayapp.ui.adapter.BindableAdapter
import mypayapp.ui.utils.diffCallback

class ExchangeRateAdapter : RecyclerView.Adapter<ExchangeRateAdapter.CurrencyViewHolder>(),
    BindableAdapter<ConvertedRates> {

    override var items: List<ConvertedRates> by diffCallback(emptyList()) { o, n ->
        o.currencyCode == n.currencyCode
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(
            GridItemConversionRateBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    class CurrencyViewHolder(private val binding: GridItemConversionRateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(
            dataModel: ConvertedRates
        ) {
            binding.convertedRate = dataModel
            binding.executePendingBindings()
        }
    }
}