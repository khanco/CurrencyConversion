package mypayapp.dashboard.ui.di

import mypayapp.dashboard.ui.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardUiKoinModule = module {
    viewModel { DashboardViewModel(get()) }
}