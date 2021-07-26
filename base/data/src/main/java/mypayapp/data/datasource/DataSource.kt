package mypayapp.data.datasource

const val REQUEST_TYPE_GET = "get"

interface DataSource : RemoteDataSource, SharedPrefDataSource {
    fun getErrorMessage(errorBody: String?): String
}