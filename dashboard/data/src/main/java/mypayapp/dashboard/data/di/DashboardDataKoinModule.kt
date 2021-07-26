package mypayapp.dashboard.data.di

import mypayapp.dashboard.data.DashboardRepositoryImpl
import mypayapp.dashboard.domain.DashboardRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val dashboardDataKoiModule = module {
    single { DashboardRepositoryImpl(get(), get(), get()) } bind DashboardRepository::class
}