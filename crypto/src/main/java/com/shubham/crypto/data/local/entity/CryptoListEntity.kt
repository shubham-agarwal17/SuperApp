package com.shubham.crypto.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CoinList")
data class CryptoListEntity(
    @PrimaryKey val id : String,
    val name : String,
    val symbol : String,
    val rank : Int,
    val is_new : Boolean,
    val is_active : Boolean,
    val type : String
)