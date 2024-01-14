package com.kproject.composejourney.presentation.content.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

/**
 * Stateful, pois text está sendo controlado internamente pela MyTextField().
 * Dificulta a reutilização do componente com outros valores.
 */
@Composable
private fun MyTextField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("John") }
    OutlinedTextField(
        value = text,
        onValueChange = { updatedText ->
            text = updatedText
        },
        label = { Text(text = "Texto") },
        shape = CircleShape,
        modifier = modifier
    )
}

/**
 * Stateless, pois elevamos o estado principal do MyTextField().
 * Facilita a reutilização, pois o estado será controlado pelo chamador da MyTextField().
 */
@Composable
private fun MyTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(text = "Texto") },
        shape = CircleShape,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        PaddingForPreview {
            State1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        PaddingForPreview {
            MyTextField()
        }
    }
}