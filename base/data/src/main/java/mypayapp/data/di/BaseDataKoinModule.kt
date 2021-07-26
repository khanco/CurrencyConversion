package mypayapp.data.di

import android.content.Context
import androidx.room.Room
import mypayapp.data.database.AppDatabase
import mypayapp.data.datasource.*
import mypayapp.data.network.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

val baseDataKoinModule = module {

    single {
        androidContext()
            .getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
    single {
        InternetConnectivityImpl(get())
    } bind InternetConnectivity::class

    single { RetrofitFactory.makeRetrofitService() }

    single { SharedPrefDataSourceImpl(get()) }

    single { RemoteDataSourceImpl(get()) }

    single { DataSourceImpl(get(), get()) } bind DataSource::class

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }
}