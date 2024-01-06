package com.kproject.composejourney.presentation.content.components1

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Button() {
    Button(onClick = {}) {
        Text("Filled")
    }
}

@Composable
private fun FilledTonalButton() {
    FilledTonalButton(onClick = {}) {
        Text("Tonal")
    }
}

@Composable
private fun OutlinedButton() {
    OutlinedButton(onClick = {}) {
        Text("Outlined")
    }
}

@Composable
private fun ElevatedButton() {
    ElevatedButton(onClick = {}) {
        Text("ElevatedButton")
    }
}

@Composable
private fun TextButton() {
    TextButton(onClick = {}) {
        Text("TextButton")
    }
}

@Composable
private fun CustomButton() {
    Button(
        onClick = {},
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFAF0101)
        )
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete icon"
        )
        Spacer(Modifier.width(6.dp))
        Text("Excluir arquivo")
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            Button()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            FilledTonalButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            OutlinedButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            ElevatedButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            TextButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview6() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            CustomButton()
        }
    }
}
