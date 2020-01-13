package com.example.testmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel : ViewModel(){

    private val errorsLiveData:MutableLiveData<Throwable> = MutableLiveData()

    private val exHandler = CoroutineExceptionHandler { _, exception -> }
    private val job = SupervisorJob()

    val coroutineContext = Dispatchers.IO + exHandler + job
    val coroutineScope = CoroutineScope(coroutineContext)
    fun observeErrors():LiveData<Throwable>{
        return errorsLiveData
    }
}
