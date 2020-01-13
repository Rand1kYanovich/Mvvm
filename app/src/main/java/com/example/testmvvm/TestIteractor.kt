package com.example.testmvvm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class TestIteractor : KoinComponent {

    private val repository: TestRepository by inject()

    suspend fun getList() = repository.getStrings()

    suspend fun getTitle() = repository.getTitle()
}