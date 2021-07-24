package mypayapp.currencyconversion.utils

import android.app.Application
import mypayapp.dashboard.ui.di.dashboardKoinModule
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
            modules(dashboardKoinModule)
        }
    }
}