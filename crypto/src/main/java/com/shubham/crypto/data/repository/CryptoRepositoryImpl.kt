package com.shubham.crypto.data.repository

import com.shubham.crypto.data.local.dao.CryptoListDao
import com.shubham.crypto.data.remote.api.CryptoApi
import com.shubham.crypto.data.repository.mapper.toDomain
import com.shubham.crypto.data.repository.mapper.toEntity
import com.shubham.crypto.domain.model.Coin
import com.shubham.crypto.domain.model.CryptoList
import com.shubham.crypto.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoApi: CryptoApi,
    private val cryptoListDao: CryptoListDao
) : CryptoRepository {
    override suspend fun getCryptoList(): List<CryptoList> {
        val cachedCryptoList = cryptoListDao.getCoinList()
        return if (cachedCryptoList.isNotEmpty()) {
            cachedCryptoList.map { it.toDomain() }
        } else {
            val cryptoListFromApi = cryptoApi.fetchWealthList()
            cryptoListDao.insertAll(cryptoListFromApi.map { it.toEntity() })
            cryptoListFromApi
        }
    }

    override suspend fun getCryptoById(coinId: String): Coin {
        return cryptoApi.getCoinDetails(coinId)
    }
}