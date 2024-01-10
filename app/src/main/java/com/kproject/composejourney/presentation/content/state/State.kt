package com.kproject.composejourney.presentation.content.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.content.components.PaddingForPreview
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun State1() {
    var name by remember { mutableStateOf("John") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            fontSize = 22.sp
        )
        Button(onClick = { name = "Mary" }) {
            Text("Mudar nome")
        }
    }
}

@Composable
private fun Custom(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black
) {
    var name by remember { mutableStateOf("John") }
    Box(
        modifier = modifier.background(backgroundColor)
    ) {
        Text(
            text = name,
            fontSize = 22.sp,
        )
        Button(onClick = { name = "Mary" }) {
            Text("Mudar nome")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        PaddingForPreview {
            State1()
        }
    }
}