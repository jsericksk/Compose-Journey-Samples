package com.kproject.composejourney.presentation.content.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kproject.composejourney.presentation.theme.MyAppTheme
import kotlin.math.roundToInt

@Composable
private fun Slider1() {
    var sliderPosition by remember { mutableFloatStateOf(40f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { position ->
                sliderPosition = position
            },
            steps = 4,
            valueRange = 0f..100f
        )
        Text(
            text = sliderPosition.roundToInt().toString(),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun RangeSlider() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            onValueChange = { position ->
                sliderPosition = position
            },
            valueRange = 0f..100f
        )
        Text(
            text = "Start: ${sliderPosition.start.roundToInt()} / End: ${sliderPosition.endInclusive.roundToInt()}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Slider1Preview() {
    MyAppTheme {
        PaddingForPreview {
            Slider1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RangeSliderPreview() {
    MyAppTheme {
        PaddingForPreview {
            RangeSlider()
        }
    }
}