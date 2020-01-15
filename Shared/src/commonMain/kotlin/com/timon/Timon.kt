package com.timon




@kotlinx.serialization.Serializable
data class Timon (val coord:GeoTimon,
                  val base:String)

@kotlinx.serialization.Serializable
data class GeoTimon(val lon:Float,val lat:Float)

@kotlinx.serialization.Serializable
data class PostTimon(val coord:GeoTimon,
                     val base:Base)

@kotlinx.serialization.Serializable
data class Base(val baseString:String)