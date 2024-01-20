package com.kproject.composejourney.presentation.content.interoperability

import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.kproject.composejourney.presentation.content.components.PaddingForPreview
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun ComposeTextView() {
    var count by remember { mutableIntStateOf(0) }
    AndroidView(
        factory = { context ->
            // Cria e retorna a View (TextView)
            TextView(context).apply {
                // Aplica customizações iniciais
                textSize = 22f
                setTextColor(Color.Blue.toArgb())
                setOnClickListener {
                    count++
                }
            }
        },
        update = { textView ->
            // Atualiza a View de acordo com alguma mudança de estado
            textView.text = "Jetpack Compose Journey $count"
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyAppTheme {
        PaddingForPreview {
            ComposeTextView()
        }
    }
}