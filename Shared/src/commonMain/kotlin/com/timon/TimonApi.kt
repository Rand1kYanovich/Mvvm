package com.timon

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.serialization.json.JSON

class TimonApi() {

    private val client by lazy {
        HttpClient{
            install(JsonFeature){
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://samples.openweathermap.org"
    }

    suspend fun fetchTimon(): Timon {
        return client.get {
            url("$BASE_URL/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }
}