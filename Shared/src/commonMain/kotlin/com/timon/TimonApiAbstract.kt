package com.timon

interface TimonApiAbstract {
    suspend fun getTimon():Timon
    suspend fun postTimon()
}