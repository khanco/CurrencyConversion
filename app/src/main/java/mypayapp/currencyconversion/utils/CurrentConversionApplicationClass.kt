package mypayapp.currencyconversion.utils

import android.app.Application
import mypayapp.dashboard.data.di.dashboardDataKoiModule
import mypayapp.dashboard.domain.di.dashboardDomainKoinModule
import mypayapp.dashboard.ui.di.dashboardUiKoinModule
import mypayapp.data.di.baseDataKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CurrentConversionApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        loadKoinModules()
    }

    private fun loadKoinModules() {
        startKoin {
            androidContext(applicationContext)

            modules(
                baseDataKoinModule
            )

            modules(
                listOf(
                    dashboardUiKoinModule,
                    dashboardDataKoiModule,
                    dashboardDomainKoinModule
                )
            )
        }
    }
}