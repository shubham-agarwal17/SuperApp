package com.shubham.crypto.domain.repository

import com.shubham.crypto.domain.model.Coin
import com.shubham.crypto.domain.model.CryptoList

interface CryptoRepository {
    suspend fun getCryptoList() : List<CryptoList>
    suspend fun getCryptoById(coinId : String) : Coin
}