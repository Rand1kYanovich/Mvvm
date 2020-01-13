package com.example.testmvvm.smartsport.viewmodel.test

import androidx.lifecycle.MutableLiveData
import com.example.testmvvm.smartsport.entity.core.main.CustomObject
import com.example.testmvvm.smartsport.model.TestIteractor
import com.example.testmvvm.smartsport.viewmodel.BaseViewModel
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject

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


    private fun loadTitle() {
        coroutineScope.launch {
            if (text.value == null) {
                text.postValue(iteractor.getTitle())
            }
        }
    }


}