package com.kproject.composejourney.presentation.content.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme


@Composable
private fun ConstraintLayoutColumn() {
    ConstraintLayout {
        // Referências
        val (profileImage, profileName) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(50.dp)
                // Atribui a referência "profileImage" a esse Composable Image()
                .constrainAs(profileImage) {
                    // Especificamos as constraints, onde "parent" é o próprio ConstraintLayout
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "John",
            modifier = Modifier
                .constrainAs(profileName) {
                    top.linkTo(profileImage.bottom)
                }
        )
    }
}

@Composable
private fun ConstraintLayoutRow() {
    ConstraintLayout {
        val (profileImage, profileName) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(50.dp)
                .constrainAs(profileImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = "John",
            modifier = Modifier
                .constrainAs(profileName) {
                    start.linkTo(profileImage.end)
                }
        )
    }
}

@Composable
private fun ConstraintLayoutBox() {
    ConstraintLayout(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        val (videoImage, playIcon, duration) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.img_sample),
            contentDescription = "Video image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(videoImage) {
                    start.linkTo(parent.start)
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.baseline_play_circle_outline_24),
            contentDescription = "Play icon",
            tint = Color.White,
            modifier = Modifier
                .size(50.dp)
                .constrainAs(playIcon) {
                    start.linkTo(videoImage.start)
                    end.linkTo(videoImage.end)
                    top.linkTo(videoImage.top)
                    bottom.linkTo(videoImage.bottom)
                }
        )
        Text(
            text = "15:23",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier
                .background(Color.Black)
                .padding(2.dp)
                .constrainAs(duration) {
                    bottom.linkTo(videoImage.bottom)
                    end.linkTo(videoImage.end)
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        ConstraintLayoutColumn()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        ConstraintLayoutRow()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        ConstraintLayoutBox()
    }
}