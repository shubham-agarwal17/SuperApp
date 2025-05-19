package com.shubham.crypto.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shubham.crypto.data.local.dao.CryptoListDao
import com.shubham.crypto.data.local.entity.CryptoListEntity

@Database(entities = [CryptoListEntity::class], version = 1)
abstract class CryptoListDatabase : RoomDatabase() {
    abstract fun cryptoListDao(): CryptoListDao
}