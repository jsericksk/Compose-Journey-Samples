package com.kproject.composejourney.presentation.content.modifier

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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

@Composable
private fun ConditionalModifier(showBackgroundAndBorderColor: Boolean) {
    Text(
        text = "Compose Journey",
        modifier = Modifier
            .padding(12.dp)
            .then(
                if (showBackgroundAndBorderColor) {
                    Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .border(BorderStroke(2.dp, MaterialTheme.colorScheme.primary))
                        .padding(6.dp)
                } else {
                    Modifier
                }
            )
    )
}

private const val loremIpsumText =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis" +
                " nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
                " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla" +
                " pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia" +
                " deserunt mollit anim id est laborum."

val reusableModifier = Modifier
    .fillMaxWidth()
    .background(Color.Black)
    .padding(8.dp)
    .border(
        width = 4.dp,
        color = Color.White,
        shape = RoundedCornerShape(8.dp)
    )
    .padding(12.dp)

@Composable
private fun ReusableModifier() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Início do capítulo",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = reusableModifier
        )
        Text(
            text = loremIpsumText,
            modifier = Modifier.padding(vertical = 12.dp)
        )
        Text(
            text = "Fim do capítulo",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = reusableModifier
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

@Preview(showBackground = true)
@Composable
private fun ConditionalModifierPreview() {
    MyAppTheme {
        ConditionalModifier(showBackgroundAndBorderColor = true)
    }
}

@Preview(showBackground = true)
@Composable
private fun ReusableModifierPreview() {
    MyAppTheme {
        ReusableModifier()
    }
}