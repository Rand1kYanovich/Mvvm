package com.example.testmvvm.smartsport.di.module

import com.example.testmvvm.smartsport.model.TestIteractor
import com.example.testmvvm.smartsport.model.TestRepository
import org.koin.dsl.module

val module = module {

    factory { TestIteractor() }
    factory { TestRepository() }
}