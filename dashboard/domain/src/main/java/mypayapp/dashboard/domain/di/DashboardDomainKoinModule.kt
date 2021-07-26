package mypayapp.dashboard.domain.di

import mypayapp.dashboard.domain.DashboardUseCase
import mypayapp.dashboard.domain.DashboardUseCaseImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dashboardDomainKoinModule = module {
    single { DashboardUseCaseImpl(get()) } bind DashboardUseCase::class
}