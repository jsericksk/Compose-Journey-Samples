package com.kproject.composejourney.presentation.content.components1

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Switch1() {
    var checked by remember { mutableStateOf(true) }
    Switch(
        checked = checked,
        onCheckedChange = { isChecked ->
            checked = isChecked
        }
    )
}

@Composable
private fun Switch2() {
    var checked by remember { mutableStateOf(true) }
    Switch(
        checked = checked,
        onCheckedChange = { isChecked ->
            checked = isChecked
        },
        thumbContent = {
            val icon = if (checked) Icons.Filled.Check else Icons.Filled.Close
            Icon(
                imageVector = icon,
                contentDescription = "Switch",
                modifier = Modifier.size(SwitchDefaults.IconSize),
            )
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            uncheckedThumbColor = Color.Black,
            checkedTrackColor = Color.Black,
            uncheckedTrackColor = Color.DarkGray,
            checkedIconColor = Color.Black,
            uncheckedIconColor = Color.White,
            checkedBorderColor = Color.Green,
            uncheckedBorderColor = Color.Red
        )
    )
}


@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        PaddingForPreview {
            Switch1()
            Switch1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        PaddingForPreview {
            Switch2()
            Switch2()
        }
    }
}