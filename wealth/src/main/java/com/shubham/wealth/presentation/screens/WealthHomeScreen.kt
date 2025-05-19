package com.shubham.wealth.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.shubham.design.components.AppToolbar
import com.shubham.wealth.R
import com.shubham.wealth.presentation.components.CardComponent

@Composable
fun WealthHomeScreen(
    primaryButtonClicked : () -> Unit = {},
    cardClicked : (String) -> Unit = {}
) {
    val viewModel: WealthViewModel = hiltViewModel()
    val wealthList by viewModel.cryptoList.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.fetchWealthList()
    }

    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(R.string.wealth),
                isBackButtonVisible = true,
                primaryButtonClicked = {
                    primaryButtonClicked()
                }
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            else {
                LazyColumn(
                    modifier = Modifier
                ) {
                    items(wealthList) { wealth ->
                        CardComponent(
                            mainText = "${wealth.rank} ${wealth.name} ${wealth.symbol}",
                            activeText = wealth.isActive,
                            cardClicked = {
                                cardClicked(wealth.id)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WealthHomeScreenPreview() {
    WealthHomeScreen()
}