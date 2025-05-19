package com.shubham.crypto.data.repository.mapper

import com.shubham.crypto.data.local.entity.CryptoListEntity
import com.shubham.crypto.domain.model.CryptoList

fun CryptoListEntity.toDomain() : CryptoList = CryptoList(
    id = id,
    name = name,
    symbol = symbol,
    is_active = is_active,
    rank = rank,
    is_new = is_new,
    type = type
)

fun CryptoList.toEntity() : CryptoListEntity = CryptoListEntity(
    id = id,
    name = name,
    symbol = symbol,
    is_active = is_active,
    rank = rank,
    is_new = is_new,
    type = type
)