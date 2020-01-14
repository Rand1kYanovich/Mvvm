package com.example.testmvvm.smartsport.model

import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine

class HttpEngine {
    val engine = OkHttpEngine(OkHttpConfig())
}