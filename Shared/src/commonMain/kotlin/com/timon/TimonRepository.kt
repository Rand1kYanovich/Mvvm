package com.timon

class TimonRepository {

    private val timonApi:TimonApi = TimonApi()

    suspend fun getTimon() = timonApi.getTimon()
    suspend fun postTimon(){
        timonApi.postTimon()
    }
}