package com.shubham.design.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    modifier: Modifier,
    textValue: String? = null,
    textColorValue: Color = com.shubham.design.ui.theme.blackColor,
    fontSizeValue: TextUnit = 16.sp,
    paddingValue: Dp = 0.dp,
    fontWeightValue: FontWeight = FontWeight.Normal,
    textAlignValue: TextAlign = TextAlign.Center
) {
    textValue?.let {
        Text(
            modifier = modifier
                .padding(all = paddingValue),
            text = it,
            style = TextStyle(
                color = textColorValue,
                fontSize = fontSizeValue,
                fontWeight = fontWeightValue
            ),
            textAlign = textAlignValue
        )
    }
}