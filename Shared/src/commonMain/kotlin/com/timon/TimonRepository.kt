package com.timon

import io.ktor.client.engine.HttpClientEngine

class TimonRepository() {

    private val timonApi:TimonApi = TimonApi()

    suspend fun getTimon() = timonApi.fetchTimon()
}