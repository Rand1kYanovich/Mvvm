package com.example.testmvvm.smartsport.model

import com.example.testmvvm.smartsport.model.TestRepository
import com.timon.TimonRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class TestIteractor(
    private val repository: TestRepository,
    private val timonRepository: TimonRepository
) : KoinComponent {

    suspend fun getList() = repository.getStrings()

    suspend fun getTitle() = repository.getTitle()

    suspend fun getTimon() = timonRepository.getTimon()
}