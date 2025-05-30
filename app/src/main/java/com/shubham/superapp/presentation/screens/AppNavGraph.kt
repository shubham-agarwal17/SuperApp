package com.shubham.superapp.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shubham.superapp.presentation.screens.home.HomeScreen
import com.shubham.superapp.presentation.screens.userprofile.UserProfileScreen
import com.shubham.crypto.presentation.screens.CryptoDetailScreen
import com.shubham.crypto.presentation.screens.CryptoHomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHost(navController, startDestination = Screen.HomeScreen.route) {
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(
                    primaryButtonClicked = {
                        navController.navigate(Screen.UserProfileScreen.route)
                    },
                    wealthBannerClicked = {
                        navController.navigate(Screen.CryptoHomeScreen.route)
                    }
                )
            }

            composable(route = Screen.UserProfileScreen.route) {
                UserProfileScreen(
                    primaryButtonClicked = {
                        navController.popBackStack()
                    },
                )
            }

            composable(route = Screen.CryptoHomeScreen.route) {
                CryptoHomeScreen(
                    primaryButtonClicked = {
                        navController.popBackStack()
                    },
                    cardClicked = { coinId ->
                        navController.navigate(Screen.CryptoDetailScreen.route + "/$coinId")
                    }
                )
            }

            composable(
                route = Screen.CryptoDetailScreen.route + "/{coinId}",
                arguments = listOf(navArgument("coinId") { type = NavType.StringType })
            ) { backStackEntry ->
                val coinId = backStackEntry.arguments?.getString("coinId")!!
                CryptoDetailScreen(
                    cryptoId = coinId,
                    primaryButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}