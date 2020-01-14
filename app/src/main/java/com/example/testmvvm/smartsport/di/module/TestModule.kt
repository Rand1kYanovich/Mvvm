package com.example.testmvvm.smartsport.di.module

import com.example.testmvvm.smartsport.model.HttpEngine
import com.example.testmvvm.smartsport.model.TestIteractor
import com.example.testmvvm.smartsport.model.TestRepository
import com.timon.TimonApi
import com.timon.TimonRepository
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import org.koin.dsl.module

val module = module {

    factory { TestIteractor(get(),get()) }
    factory { TestRepository() }
    factory { TimonRepository() }

    factory { HttpEngine() }
}