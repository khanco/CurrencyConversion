package mypayapp.ui.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showProgressBar = ObservableBoolean()
    val errorMessage = MediatorLiveData<String>()
}