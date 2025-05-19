package com.shubham.wealth.data.api

import com.shubham.wealth.domain.model.Coin
import com.shubham.wealth.domain.model.CoinList
import retrofit2.http.GET
import retrofit2.http.Path

interface WealthApi {
    @GET("coins")
    suspend fun fetchWealthList() : List<CoinList>

    @GET("coins/{id}")
    suspend fun getCoinDetails(@Path("id") id: String): Coin
}