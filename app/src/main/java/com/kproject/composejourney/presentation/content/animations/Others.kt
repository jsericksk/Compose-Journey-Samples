package com.kproject.composejourney.presentation.content.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
private fun Info() {
    var expanded by remember { mutableStateOf(false) }
    val textPadding by animateDpAsState(
        targetValue = if (expanded) 14.dp else 4.dp,
        animationSpec = spring(
            dampingRatio = 3f,
            stiffness = Spring.StiffnessLow
        ),
        label = "textPadding"
    )
    val iconRotationAngle by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = spring(
            dampingRatio = 2f,
            stiffness = Spring.StiffnessMediumLow
        ),
        label = "iconRotationAngle"
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Jetpack Compose Journey!",
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(textPadding)
        )
        Spacer(Modifier.height(24.dp))
        Button(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.rotate(iconRotationAngle)
            )
            Text(
                text = if (expanded) "Diminuir padding" else "Aumentar padding"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfoPreview() {
    PreviewTheme(darkTheme = false) {
        Info()
    }
}