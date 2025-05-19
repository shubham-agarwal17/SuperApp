package com.shubham.crypto.domain.model

data class CryptoList(
    val id : String,
    val name : String,
    val symbol : String,
    val rank : Int,
    val is_new : Boolean,
    val is_active : Boolean,
    val type : String
) {
    val isActive : String
        get() = if (is_active) "Active" else "Not Active"
}