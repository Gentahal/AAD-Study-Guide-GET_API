package com.idn.getapi

import android.database.DatabaseErrorHandler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idn.getapi.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.logging.Handler

class MainViewModel : ViewModel() {

    val gunungResponse = MutableLiveData<List<GunungResponseItem>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    private fun getNamaGunung(
        responHandler: (List<GunungResponseItem>)-> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ApiClient.getApiService().getVolcanicMount()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it as List<GunungResponseItem>)
            },{
                 errorHandler(it)
            })
    }

    fun getData(){
        isLoading.value = true
        getNamaGunung({
            Log.d("MainViewModel", "getData: $it")
            isLoading.value = false
            gunungResponse.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }
}