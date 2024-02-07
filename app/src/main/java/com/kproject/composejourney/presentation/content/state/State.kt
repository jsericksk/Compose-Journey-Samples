package com.kproject.composejourney.presentation.content.state

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.content.components.PaddingForPreview
import com.kproject.composejourney.presentation.theme.PreviewTheme

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
private fun Caption() {
    var caption by remember { mutableStateOf("Jetpack <b>Compose</b> Journey") }
    var backgroundColor by remember { mutableStateOf(Color.White) }
    val captionAnnotatedString = remember(key1 = caption) {
        createAnnotatedString(text = caption)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable {
                backgroundColor =
                        if (backgroundColor == Color.White) Color.LightGray else Color.White
            }
            .padding(24.dp)
    ) {
        Text(
            text = captionAnnotatedString,
            // text = createAnnotatedString(text = caption),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(12.dp)
        )
        Spacer(Modifier.height(18.dp))
        OutlinedTextField(
            value = caption,
            onValueChange = { newCaption ->
                caption = newCaption
            },
            label = { Text(text = "Legenda") },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

private fun createAnnotatedString(text: String): AnnotatedString {
    Log.d("Caption", "createAnnotatedString() chamada")
    val parts = text.split("<b>", "</b>")
    return buildAnnotatedString {
        var bold = false
        for (part in parts) {
            if (bold) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                ) { append(part) }
            } else {
                append(part)
            }
            bold = !bold
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
private fun State1Preview() {
    PreviewTheme {
        PaddingForPreview {
            State1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyTextFieldPreview() {
    PreviewTheme {
        PaddingForPreview {
            MyTextField()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CaptionPreview() {
    PreviewTheme(darkTheme = false) {
        Caption()
    }
}