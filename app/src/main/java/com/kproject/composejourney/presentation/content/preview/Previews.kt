package com.kproject.composejourney.presentation.content.preview

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.ComposeJourneyTheme

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

@Preview
@Composable
private fun Preview1() {
    ComposeJourneyTheme {
        Item()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview2() {
    ComposeJourneyTheme {
        Item()
    }
}

@Preview(name = "Default")
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview3() {
    ComposeJourneyTheme {
        Profile()
    }
}