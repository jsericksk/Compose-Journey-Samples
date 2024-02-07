package com.kproject.composejourney.presentation.content.components

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Checkbox1() {
    var checked by remember { mutableStateOf(true) }
    Checkbox(
        checked = checked,
        onCheckedChange = { isChecked ->
            checked = isChecked
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Checkbox1Preview() {
    MyAppTheme {
        PaddingForPreview {
            Checkbox1()
            Checkbox1()
        }
    }
}