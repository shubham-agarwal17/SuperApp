package com.shubham.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.shubham.design.ui.theme.whiteColor

@Composable
fun BannerComponent(
    title : String? = null,
    description : String? = null,
    imageUrl : String? = null,
    resourceValue : Int? = null,
    bannerClicked : () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                bannerClicked()
            }
            .padding(12.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        com.shubham.design.ui.theme.primaryColor,
                        com.shubham.design.ui.theme.blackColor
                    )
                )
            )
    ) {
        imageUrl?.let {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = imageUrl,
                contentDescription = "Banner Image",
                contentScale = ContentScale.Crop
            )
        }

        resourceValue?.let {
            ImageComponent(
                modifier = Modifier
                    .size(120.dp)
                    .padding(18.dp)
                    .align(Alignment.CenterEnd),
                resourceValue = resourceValue
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(18.dp),
        ) {
            title?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize(),
                    textValue = it,
                    fontSizeValue = 24.sp,
                    textColorValue = whiteColor,
                )
            }

            description?.let {
                TextComponent(
                    modifier = Modifier
                        .wrapContentSize(),
                    textValue = it,
                    textColorValue = whiteColor,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        title = "Hello World",
        description = "This is some description",
        imageUrl = null,
    )
}