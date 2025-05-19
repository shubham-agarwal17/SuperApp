package com.shubham.crypto.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.shubham.design.components.AppToolbar
import com.shubham.design.components.TextComponent
import com.shubham.utilities.logging.AppLogger

@Composable
fun CryptoDetailScreen(
    cryptoId: String,
    primaryButtonClicked : () -> Unit = {}
) {
    val viewModel: CryptoViewModel = hiltViewModel()
    val crypto by viewModel.coin.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(true)

    LaunchedEffect(Unit) {
        viewModel.loadWealthDetails(cryptoId)
    }

    AppLogger.d(message = crypto.toString())

    Scaffold(
        topBar = {
            AppToolbar(
                title = if (isLoading) "Coin Details" else crypto?.name,
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
                .padding(innerPadding),
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else {
                crypto?.let {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 18.dp, vertical = 20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(75.dp),
                                model = crypto!!.logo,
                                contentDescription = "Coin logo",
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier.padding(start = 14.dp)
                            ) {
                                TextComponent(
                                    textValue = crypto!!.name,
                                    modifier = Modifier,
                                    fontSizeValue = 20.sp,
                                    textAlignValue = TextAlign.Start,
                                    fontWeightValue = FontWeight.Bold
                                )

                                TextComponent(
                                    textValue = crypto!!.symbol,
                                    modifier = Modifier.padding(top = 6.dp),
                                    textAlignValue = TextAlign.Start,
                                )
                            }
                        }

                        TextComponent(
                            textValue = "Founder - ${crypto!!.team[0].name}",
                            modifier = Modifier.padding(top = 16.dp),
                            textAlignValue = TextAlign.Start,
                            textColorValue = Color.Green,
                            fontSizeValue = 18.sp,
                        )

                        Row(
                            modifier = Modifier.padding(vertical = 12.dp)
                        ) {
                            Card(
                                modifier = Modifier,
                                shape = RoundedCornerShape(15.dp),
                                colors = CardColors(
                                    containerColor = Color.LightGray,
                                    contentColor = Color.Black,
                                    disabledContainerColor = Color.LightGray,
                                    disabledContentColor = Color.Black
                                ),
                                content = {
                                    TextComponent(
                                        textValue = crypto!!.org_structure,
                                        modifier = Modifier,
                                        textAlignValue = TextAlign.Start,
                                        paddingValue = 8.dp
                                    )
                                }
                            )

                            Card(
                                modifier = Modifier.padding(start = 16.dp),
                                shape = RoundedCornerShape(15.dp),
                                colors = CardColors(
                                    containerColor = Color.LightGray,
                                    contentColor = Color.Black,
                                    disabledContainerColor = Color.LightGray,
                                    disabledContentColor = Color.Black
                                ),
                                content = {
                                    TextComponent(
                                        textValue = crypto!!.hash_algorithm,
                                        modifier = Modifier,
                                        textAlignValue = TextAlign.Start,
                                        paddingValue = 8.dp
                                    )
                                }
                            )
                        }

                        TextComponent(
                            textValue = crypto!!.description,
                            modifier = Modifier.padding(top = 10.dp),
                            textAlignValue = TextAlign.Start
                        )
                    }
                }
            }
        }
    }
}
