package mypayapp.data.datasource

interface DataSource : RemoteDataSource, LocalDataSource {
    // just used for proxy for Local and Remote data source
}