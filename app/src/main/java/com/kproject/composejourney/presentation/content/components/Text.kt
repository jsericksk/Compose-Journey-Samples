package com.kproject.composejourney.presentation.content.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Text() {
    Text(
        text = "Jetpack Compose",
        color = Color.Blue,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 4.sp
    )
}

@Composable
private fun TextField() {
    var text by remember { mutableStateOf("Jetpack Compose") }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = {
            Text(text = "Label")
        },
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Blue,
            unfocusedLabelColor = Color.Blue
        )
    )
}

@Composable
private fun TextField2() {
    var text by remember { mutableStateOf("Jetpack Compose") }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = {
            Text(text = "E-mail")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = { text = "Jetpack Compose" }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Blue,
            unfocusedLabelColor = Color.Blue,
        ),
    )
}

@Composable
private fun OutlinedTextField() {
    var text by remember { mutableStateOf("123456789") }
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = {
            Text(text = "Senha")
        },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Blue,
            unfocusedLabelColor = Color.Blue,
            unfocusedContainerColor = Color.White
        ),
    )
}

@Composable
private fun OutlinedTextField2() {
    var text by remember { mutableStateOf("Jetpack Compose") }
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = {
            Text(text = "Nome")
        },
        shape = CircleShape,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Blue,
            unfocusedLabelColor = Color.Blue,
            unfocusedContainerColor = Color.White
        )
    )
}

@Composable
private fun BasicTextField() {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        Text()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        PaddingForPreview {
            TextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        PaddingForPreview {
            TextField2()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    MyAppTheme {
        PaddingForPreview {
            OutlinedTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    MyAppTheme {
        PaddingForPreview {
            OutlinedTextField2()
        }
    }
}