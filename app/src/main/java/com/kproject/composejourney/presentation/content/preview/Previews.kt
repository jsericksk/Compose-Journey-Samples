package com.kproject.composejourney.presentation.content.preview

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Item() {
    Text(
        text = "Jetpack Compose",
        fontSize = 16.sp,
        color = Color.Red
    )
}

@Composable
private fun Profile() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(250.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Profile image",
            tint = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .size(50.dp)
        )
        Text(
            text = "John",
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun ClickableItem() {
    var count by remember { mutableIntStateOf(0) }
    Text(
        text = "Clicks: $count",
        fontSize = 16.sp,
        color = Color.Red,
        modifier = Modifier.clickable { count++ }
    )
}

@Preview(name = "Light theme")
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class PreviewLightDark

@Preview
@Composable
private fun Preview1() {
    MyAppTheme {
        Item()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        Item()
    }
}

@Preview(name = "Light theme")
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
    MyAppTheme {
        Profile()
    }
}

@PreviewLightDark
@Composable
private fun Preview4() {
    MyAppTheme {
        Profile()
    }
}

@Preview(
    name = "Devices.PIXEL_3A_XL",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    device = Devices.PIXEL_3A_XL
)
@Preview(
    name = "Devices.NEXUS_7",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true,
    device = Devices.NEXUS_7
)
@Composable
private fun Preview5() {
    MyAppTheme {
        Profile()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview6() {
    MyAppTheme {
        ClickableItem()
    }
}