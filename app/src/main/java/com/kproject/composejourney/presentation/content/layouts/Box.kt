package com.kproject.composejourney.presentation.content.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.ComposeJourneyTheme

@Composable
private fun BoxExample() {
    Box(
        modifier = Modifier.size(200.dp)
    ) {
        Text(
            text = "Top start",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "Top end",
            modifier = Modifier.align(Alignment.TopEnd)
        )
        Text(
            text = "Center",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "Bottom start",
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "Bottom end",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun VideoItem() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_sample),
            contentDescription = "Video image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
            contentDescription = "Play icon",
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
        )
        Text(
            text = "15:23",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .background(Color.Black)
                .padding(2.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    ComposeJourneyTheme {
        BoxExample()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    ComposeJourneyTheme {
        VideoItem()
    }
}
