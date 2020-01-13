package com.example.testmvvm

import org.koin.dsl.module

val module = module {

    factory { TestIteractor() }
    factory { TestRepository() }
}