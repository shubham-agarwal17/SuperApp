package com.shubham.superapp.presentation.screens

sealed class Screen (
    val route : String
) {
    data object HomeScreen : Screen(route = "home_screen")
    data object UserProfileScreen : Screen(route = "user_profile_screen")
    data object WealthHomeScreen : Screen(route = "wealth_home_screen")
    data object WealthDetailScreen : Screen(route = "wealth_detail_screen")
}