package com.shubham.crypto.data.remote.api

import com.shubham.crypto.domain.model.Coin
import com.shubham.crypto.domain.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {
    @GET("coins")
    suspend fun fetchWealthList() : List<CryptoList>

    @GET("coins/{id}")
    suspend fun getCoinDetails(@Path("id") id: String): Coin
}