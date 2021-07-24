package mypayapp.dashboard.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mypayapp.dashboard.ui.databinding.FragmentDashboardBinding
import mypayapp.dashboard.ui.viewmodel.DashboardViewModel
import mypayapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class DashboardFragment : BaseFragment() {

    private val viewModelDashboard by lazy { requireActivity().getViewModel<DashboardViewModel>() }

    companion object {
        fun getInstance() = DashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDashboardBinding.inflate(inflater, container, false).apply {
        viewModel = viewModelDashboard
        viewState = viewModelDashboard.viewState
    }.root
}