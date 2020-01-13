package com.example.testmvvm.smartsport.model

import com.example.testmvvm.smartsport.entity.core.main.CustomObject
import kotlinx.coroutines.delay

class TestRepository {


    suspend fun getStrings(): List<CustomObject> {
        delay(3000)
        return listOf(
            CustomObject("PRIVET)))"),
            CustomObject("POKA(((")
        )
    }

    suspend fun getTitle(): CustomObject {
        delay(1000)
        return CustomObject("Title")
    }
}