package com.kproject.composejourney.presentation.content.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Icon1() {
    Icon(
        imageVector = Icons.Default.Person,
        contentDescription = "Person icon",
        tint = Color.Blue
    )
}

@Composable
private fun Icon2() {
    Icon(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "Person icon",
        tint = Color.Red
    )
}

@Composable
private fun Image1() {
    Image(
        painter = painterResource(id = R.drawable.img_nature),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(width = 200.dp, height = 150.dp)
    )
}

@Composable
private fun ImageWeb() {
    AsyncImage(
        model = "https://img.lermanga.org/Y/yotsuba-to/capitulo-09/12.jpg",
        contentDescription = "Image"
    )
}

@Composable
private fun Image2() {
    val borderWidth = 4.dp
    Image(
        painter = painterResource(id = R.drawable.img_nature),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .border(
                border = BorderStroke(borderWidth, Color.Red),
                shape = CircleShape
            )
            .clip(CircleShape)
    )
}

@Composable
private fun Image3() {
    Image(
        painter = painterResource(id = R.drawable.img_nature),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(color = Color.Green, blendMode = BlendMode.Darken),
        modifier = Modifier.size(width = 200.dp, height = 150.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun Icon1Preview() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            Icon1()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Icon2Preview() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            Icon2()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Image1Preview() {
    MyAppTheme {
        Image1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Image2Preview() {
    MyAppTheme {
        PaddingForPreview(padding = 4.dp) {
            Image2()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Image3Preview() {
    MyAppTheme {
        Image3()
    }
}