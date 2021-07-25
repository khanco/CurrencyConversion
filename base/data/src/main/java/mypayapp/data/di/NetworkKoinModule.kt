package mypayapp.data.di

import mypayapp.data.datasource.DataSource
import mypayapp.data.datasource.DataSourceImpl
import mypayapp.data.datasource.LocalDataSourceImpl
import mypayapp.data.datasource.RemoteDataSourceImpl
import mypayapp.data.network.RetrofitFactory
import org.koin.dsl.bind
import org.koin.dsl.module

val networkKoinModule = module {
    single { RetrofitFactory.makeRetrofitService() }
    single { LocalDataSourceImpl(get()) }
    single { RemoteDataSourceImpl(get()) }
    single { DataSourceImpl(get(), get()) } bind DataSource::class
}