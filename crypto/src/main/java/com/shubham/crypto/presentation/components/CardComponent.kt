package com.shubham.crypto.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.design.components.TextComponent

@Composable
fun CardComponent(
    mainText : String? = null,
    activeText : String? = null,
    cardClicked : () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .clickable {
                cardClicked()
            }
            .padding(12.dp)
            .border(
                width = 2.dp,
                shape = RoundedCornerShape(12.dp),
                color = Color.Black
            ),
    ) {
        TextComponent(
            textValue = mainText,
            fontSizeValue = 18.sp,
            fontWeightValue = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )

        TextComponent(
            textValue = activeText,
            textColorValue = Color.Green,
            fontWeightValue = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    CardComponent(
        mainText = "1 Bitcoin BTC",
        activeText = "active"
    )
}