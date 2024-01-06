package com.kproject.composejourney.presentation.content.components1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PaddingForPreview(
    padding: Dp = 10.dp,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        modifier = Modifier.padding(padding),
        content = content
    )
}