package com.shubham.wealth.data.repository

import com.shubham.wealth.data.api.WealthApi
import com.shubham.wealth.domain.model.Coin
import com.shubham.wealth.domain.model.CoinList
import com.shubham.wealth.domain.repository.WealthRepository
import javax.inject.Inject

class WealthRepositoryImpl @Inject constructor(
    private val wealthApi: WealthApi
) : WealthRepository {
    override suspend fun getWealthList(): List<CoinList> {
        return wealthApi.fetchWealthList()
    }

    override suspend fun getWealthById(coinId: String): Coin {
        return wealthApi.getCoinDetails(coinId)
    }
}