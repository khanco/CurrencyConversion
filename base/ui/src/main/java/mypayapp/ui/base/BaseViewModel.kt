package mypayapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showProgressBar = MutableLiveData<Boolean>()
}