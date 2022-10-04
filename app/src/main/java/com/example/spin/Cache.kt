package com.example.spin

interface Cache {
    fun saveInСache(url:String)
    fun GetCachedUrl():String
    fun IsSameUrls():Boolean
    fun loadCashUrl()
}