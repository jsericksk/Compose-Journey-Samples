package com.kproject.composejourney.presentation.content.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Item1() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color.Blue)
            .padding(24.dp)
    ) {
        Text(
            text = "Ordem importa!",
            color = Color.White,
        )
    }
}

@Composable
private fun Item2() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .padding(24.dp)
            .background(Color.Blue)
    ) {
        Text(
            text = "Ordem importa!",
            color = Color.White,
        )
    }
}

@Composable
private fun Item3() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .matchParentSize()
        )
    }
}

@Composable
private fun MarginAndPadding1() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Black)
            .width(150.dp)
    ) {
        Text(
            text = "Texto 1",
            color = Color.White,
            modifier = Modifier
                .padding(6.dp) // Margin
                .background(Color(0xFF004D40))
                .padding(6.dp) // Padding
        )
        Text(
            text = "Texto 2",
            color = Color.White,
            modifier = Modifier
                .padding(6.dp) // Margin
                .background(Color(0xFF004D40))
                .padding(6.dp) // Padding
        )
    }
}

@Composable
private fun MarginAndPadding2() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.Black)
            .width(150.dp)
    ) {
        Text(
            text = "Texto 1",
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 6.dp) // Margin
                .background(Color(0xFF004D40))
                .padding(horizontal = 4.dp, vertical = 8.dp) // Padding
        )
        Text(
            text = "Texto 2",
            color = Color.White,
            modifier = Modifier
                .padding(top = 6.dp) // Margin
                .background(Color(0xFF004D40))
                .padding(horizontal = 4.dp, vertical = 8.dp) // Padding
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Item1Preview() {
    MyAppTheme {
        Item1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Item2Preview() {
    MyAppTheme {
        Item2()
    }
}

@Preview(showBackground = true)
@Composable
private fun Item3Preview() {
    MyAppTheme {
        Item3()
    }
}

@Preview(showBackground = true)
@Composable
private fun MarginAndPadding1Preview() {
    MyAppTheme {
        MarginAndPadding1()
    }
}

@Preview(showBackground = true)
@Composable
private fun MarginAndPadding2Preview() {
    MyAppTheme {
        MarginAndPadding2()
    }
}