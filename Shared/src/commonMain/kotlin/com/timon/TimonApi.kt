package com.timon

import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.url
import kotlinx.serialization.json.JSON


class TimonApi:TimonApiAbstract {

    private val jsonSerializer = KotlinxSerializer(JSON.unquoted)

    private val client by lazy {
        HttpClient{
            install(JsonFeature){
                serializer = KotlinxSerializer(JSON.nonstrict)
            }
            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            defaultRequest {
                header("Bearer","Auth {token}")
            }
        }
    }

    companion object {
        private const val BASE_URL = "https://samples.openweathermap.org"
    }

    override suspend fun getTimon(): Timon {
        return client.get {
            url("$BASE_URL/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
        }
    }

    override suspend fun postTimon() {
        client.post<Unit> {
            url(BASE_URL)
            val timon = Timon(GeoTimon(5f,5f), "Timonc")
            println(timon.toString())
            body = jsonSerializer.write(timon)
            println(body.toString())
        }
    }
}