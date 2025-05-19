package com.shubham.crypto.domain.model

data class Coin(
    val id : String,
    val name : String,
    val symbol : String,
    val rank : Number,
    val type : String,
    val logo : String,
    val description : String,
    val org_structure : String,
    val hash_algorithm : String,
    val team : List<Team>
)

data class Team(
    val id : String,
    val name : String,
    val position : String
)
