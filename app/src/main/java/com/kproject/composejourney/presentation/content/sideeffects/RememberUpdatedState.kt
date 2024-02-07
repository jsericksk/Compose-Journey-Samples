package com.kproject.composejourney.presentation.content.sideeffects

import android.content.res.Configuration
import android.webkit.URLUtil
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.theme.MyAppTheme
import com.kproject.composejourney.presentation.theme.PreviewTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private suspend fun downloadFile(onDownloadFinished: () -> Unit) {
    withContext(Dispatchers.IO) {
        delay(3000)
        withContext(Dispatchers.Main) {
            onDownloadFinished.invoke()
        }
    }
}

@Composable
private fun DownloadScreen() {
    val fileUrl = "https://site.com/files/video-123.mp4"
    val defaultFileName = "???"
    var fileName by remember { mutableStateOf(defaultFileName) }
    var isDownloadingFile by remember { mutableStateOf(false) }

    if (isDownloadingFile) {
        FileDownload(
            url = fileUrl,
            fileName = fileName,
            onFileNameObtained = { realFileName ->
                fileName = realFileName
            },
            onDownloadFinished = {
                isDownloadingFile = false
            }
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isDownloadingFile) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                LinearProgressIndicator(
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(14.dp))
                Text(
                    text = "Baixando arquivo... Aguarde.",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        } else {
            Text(
                text = "Nenhum arquivo sendo baixado no momento.",
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(18.dp))

        Button(
            onClick = {
                fileName = defaultFileName
                isDownloadingFile = true
            },
            enabled = !isDownloadingFile
        ) {
            Text(
                text = "Baixar",
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun FileDownload(
    url: String,
    onFileNameObtained: (String) -> Unit,
    fileName: String,
    onDownloadFinished: () -> Unit
) {
    val context = LocalContext.current
    val realFileName by rememberUpdatedState(newValue = fileName)
    LaunchedEffect(Unit) {
        onFileNameObtained.invoke(URLUtil.guessFileName(url, null, null))
        downloadFile(
            onDownloadFinished = {
                Toast.makeText(
                    context,
                    "Arquivo \"$realFileName\" baixado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()
                onDownloadFinished.invoke()
            }
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DownloadScreenPreview() {
    PreviewTheme(darkTheme = true) {
        DownloadScreen()
    }
}