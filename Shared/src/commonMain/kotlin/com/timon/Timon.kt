package com.timon

import kotlinx.serialization.Serializable

@Serializable
data class Timon (val coord:GeoTimon,val base:String)

@Serializable
data class GeoTimon(val lon:Float,val lat:Float)