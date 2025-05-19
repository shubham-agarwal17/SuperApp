package com.shubham.superapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.shubham.superapp.R
import com.shubham.design.components.AppToolbar
import com.shubham.design.components.BannerComponent

@Composable
fun HomeScreen(
    primaryButtonClicked : () -> Unit = {},
    wealthBannerClicked : () -> Unit = {}
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(R.string.add_address),
                isNotificationVisible = true,
                primaryButtonClicked = {
                    primaryButtonClicked()
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.TopStart)
                .background(com.shubham.design.ui.theme.whiteColor)
                .padding(innerPadding)
        ) {
            BannerComponent(
                title = stringResource(R.string.wealth),
                description = stringResource(R.string.investment_ideas_for_you),
                imageUrl = null,
                resourceValue = R.drawable.ic_wealth,
                bannerClicked = {
                    wealthBannerClicked()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}