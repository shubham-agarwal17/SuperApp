package com.shubham.wealth.domain.model

import androidx.room.Entity

@Entity(tableName = "CoinList")
data class CoinList(
    val id : String,
    val name : String,
    val symbol : String,
    val rank : Number,
    val is_new : Boolean,
    val is_active : Boolean,
    val type : String
) {
    val isActive : String
        get() = if (is_active) "Active" else "Not Active"
}