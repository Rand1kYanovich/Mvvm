package com.example.testmvvm.smartsport.model

import com.example.testmvvm.smartsport.model.TestRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class TestIteractor : KoinComponent {

    private val repository: TestRepository by inject()

    suspend fun getList() = repository.getStrings()

    suspend fun getTitle() = repository.getTitle()
}