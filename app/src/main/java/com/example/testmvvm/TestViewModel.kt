package com.example.testmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.coroutines.coroutineContext

class TestViewModel : BaseViewModel(), KoinComponent {

    private val iteractor: TestIteractor by inject()

    val text: MutableLiveData<CustomObject> = MutableLiveData()
    val list: MutableLiveData<List<CustomObject>> = MutableLiveData()


    init {
        loadList()
        loadTitle()
    }

    private fun loadList() {
        coroutineScope.launch {
            if (list.value == null) {
                list.postValue(iteractor.getList())
            }

        }
    }

    fun getList(): LiveData<List<CustomObject>> {
        return list
    }

    private fun loadTitle() {
        coroutineScope.launch {
            if (text.value == null) {
                text.postValue(iteractor.getTitle())
            }
        }
    }

    fun getTitle(): LiveData<CustomObject> {
        return text
    }

}