package com.example.testmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.coroutineContext

class TestViewModel : ViewModel(), KoinComponent {

    private val iteractor: TestIteractor by inject()
    val text: MutableLiveData<CustomObject> = MutableLiveData()
    val list: MutableLiveData<List<CustomObject>> = MutableLiveData()

    private val exHandler = CoroutineExceptionHandler { _, exception -> }
    private val job = SupervisorJob()
    val coroutineContext = Dispatchers.IO + exHandler + job
    val coroutineScope = CoroutineScope(coroutineContext)

    fun getList(): LiveData<List<CustomObject>> {
        coroutineScope.launch {
            if (list.value == null) {
                list.postValue(iteractor.getList())
            }

        }
        return list
    }

    fun getTitle(): LiveData<CustomObject> {
        coroutineScope.launch {
            if (text.value == null) {
                text.postValue(iteractor.getTitle())
            }
        }
        return text
    }

}