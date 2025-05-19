package com.shubham.superapp.presentation.screens

sealed class Screen (
    val route : String
) {
    data object HomeScreen : Screen(route = "home_screen")
    data object UserProfileScreen : Screen(route = "user_profile_screen")
    data object CryptoHomeScreen : Screen(route = "crypto_home_screen")
    data object CryptoDetailScreen : Screen(route = "crypto_detail_screen")
}