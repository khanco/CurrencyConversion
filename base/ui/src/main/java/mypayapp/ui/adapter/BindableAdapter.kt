package mypayapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Allows DataBinding to set items into [RecyclerView.Adapter]. Refer [RecyclerView.setItems].
 */
interface BindableAdapter<T> {
    var items: List<T>
}
