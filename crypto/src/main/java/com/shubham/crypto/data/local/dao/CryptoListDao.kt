package com.shubham.crypto.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shubham.crypto.data.local.entity.CryptoListEntity

@Dao
interface CryptoListDao {
    @Query("SELECT * from CoinList")
    suspend fun getCoinList() : List<CryptoListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(coinList : List<CryptoListEntity>)
}