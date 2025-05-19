package com.shubham.wealth.domain.repository

import com.shubham.wealth.domain.model.Coin
import com.shubham.wealth.domain.model.CoinList

interface WealthRepository {
    suspend fun getWealthList() : List<CoinList>
    suspend fun getWealthById(coinId : String) : Coin
}