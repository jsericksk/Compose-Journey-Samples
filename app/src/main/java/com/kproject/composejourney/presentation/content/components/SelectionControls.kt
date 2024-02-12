package com.kproject.composejourney.presentation.content.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.theme.PreviewTheme

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

@Composable
private fun Checkbox2() {
    var checked by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { checked = !checked }
            .padding(horizontal = 6.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { isChecked ->
                checked = isChecked
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                uncheckedColor = Color.Red,
                checkmarkColor = Color.Yellow
            )
        )
        Text(
            text = "Tema Dark",
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Composable
private fun RadioButton() {
    val options = listOf("Padrão do sistema", "Dark", "Light")
    var selectedOption by remember { mutableStateOf(options[0]) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(18.dp)
    ) {
        Text(
            text = "Selecione o tema do app",
            fontSize = 22.sp
        )
        Spacer(Modifier.height(18.dp))
        options.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { selectedOption = option }
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { selectedOption = option }
                )
                Text(
                    text = option,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
        }
    }
}

@Composable
private fun Switch1() {
    var checked by remember { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable { checked = !checked }
            .padding(horizontal = 6.dp)
    ) {
        Switch(
            checked = checked,
            onCheckedChange = { isChecked ->
                checked = isChecked
            },
            thumbContent = {
                val icon = if (checked) Icons.Filled.Check else Icons.Filled.Close
                Icon(
                    imageVector = icon,
                    contentDescription = null,
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
        Text(
            text = "Tema Dark",
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Checkbox1Preview() {
    PreviewTheme {
        PaddingForPreview {
            Checkbox1()
            Checkbox1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckboxPreview() {
    PreviewTheme {
        PaddingForPreview {
            Checkbox2()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RadioButtonPreview() {
    PreviewTheme(darkTheme = false) {
        RadioButton()
    }
}

@Preview(showBackground = true)
@Composable
private fun SwitchPreview() {
    PreviewTheme {
        PaddingForPreview {
            Switch1()
        }
    }
}