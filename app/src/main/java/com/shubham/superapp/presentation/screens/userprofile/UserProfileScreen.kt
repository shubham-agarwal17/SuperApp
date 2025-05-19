package com.shubham.superapp.presentation.screens.userprofile

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
import com.shubham.design.components.AppToolbar
import com.shubham.superapp.R

@Composable
fun UserProfileScreen(
    primaryButtonClicked : () -> Unit = {}
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(R.string.user_profile),
                isBackButtonVisible = true,
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
        }
    }
}
