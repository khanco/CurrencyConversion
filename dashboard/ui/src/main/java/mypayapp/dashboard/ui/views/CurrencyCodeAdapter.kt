package mypayapp.dashboard.ui.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.spn_item_currency_codes.view.*
import mypayapp.dashboard.ui.R
import mypayapp.domain.models.QuoteEntity

class CurrencyCodeAdapter(
    context: Context,
    quoteEntities: List<QuoteEntity>
) : ArrayAdapter<QuoteEntity>(context, 0, quoteEntities) {

    override fun getView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    override fun getDropDownView(position: Int, recycledView: View?, parent: ViewGroup): View {
        return this.createView(position, recycledView, parent)
    }

    private fun createView(position: Int, recycledView: View?, parent: ViewGroup): View {

        val quoteEntity = getItem(position)

        val view = recycledView ?: LayoutInflater.from(context).inflate(
            R.layout.spn_item_currency_codes,
            parent,
            false
        )
        if (quoteEntity != null) {
            view.tvCurrencyCode.text = quoteEntity.currencyCode
        }
        return view
    }
}