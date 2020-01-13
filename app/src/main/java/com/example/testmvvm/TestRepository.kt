package com.example.testmvvm

import kotlinx.coroutines.delay
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TestRepository {


    suspend fun getStrings(): List<CustomObject> {
        delay(3000)
        return listOf(CustomObject("PRIVET)))"), CustomObject("POKA((("))
    }

    suspend fun getTitle():CustomObject{
        delay(1000)
        return CustomObject("Title")
    }
}