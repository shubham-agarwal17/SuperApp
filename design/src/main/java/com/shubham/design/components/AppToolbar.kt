package com.shubham.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.design.R

@Composable
fun AppToolbar(
    title : String? = null,
    isBackButtonVisible : Boolean = false,
    isNotificationVisible : Boolean = false,
    primaryButtonClicked : () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .background(com.shubham.design.ui.theme.primaryColor)
            .systemBarsPadding()
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 18.dp, end = 18.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    primaryButtonClicked()
                },
            painter = painterResource(id = if (isBackButtonVisible) R.drawable.ic_arrow_back else R.drawable.ic_user),
            contentDescription = if (isBackButtonVisible) "Back Button" else "User Image",
            tint = com.shubham.design.ui.theme.whiteColor
        )

        Spacer(modifier = Modifier.width(18.dp))

        TextComponent(
            modifier = Modifier.wrapContentSize(),
            textValue = title,
            textColorValue = com.shubham.design.ui.theme.whiteColor,
            fontSizeValue = 20.sp,
            paddingValue = 8.dp
        )

        Spacer(modifier = Modifier.weight(1f))

        if (isNotificationVisible) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = "Notification",
                tint = com.shubham.design.ui.theme.whiteColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppToolbarPreview() {
    AppToolbar()
}