package com.example.testmvvm.smartsport.viewmodel.secondtest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testmvvm.smartsport.model.TestIteractor
import com.example.testmvvm.smartsport.viewmodel.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class SecondTestViewModel : BaseViewModel(), KoinComponent {

    private val iteractor: TestIteractor by inject()

    val timonString: MutableLiveData<String> = MutableLiveData()

    init {
        getTimonString()
    }
    private fun getTimonString() {
        if (timonString.value == null) {
            coroutineScope.launch {
                try {
                    timonString.postValue(iteractor.getTimon().toString())
                    iteractor.postTimon()
                } catch (e: Exception) {
                    throw(e)
                    Log.e("Error", e.message)
                }
            }
        }
    }

}

