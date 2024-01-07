package com.kproject.composejourney.presentation.content.components1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Card1() {
    Card(
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_nature),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nature image",
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "1.2 MB",
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
private fun Card2() {
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_nature),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nature image",
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "1.2 MB",
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
private fun Card3() {
    OutlinedCard(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_nature),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nature image",
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "1.2 MB",
                fontSize = 12.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        PaddingForPreview {
            Card1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        PaddingForPreview {
            Card2()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        PaddingForPreview {
            Card3()
        }
    }
}