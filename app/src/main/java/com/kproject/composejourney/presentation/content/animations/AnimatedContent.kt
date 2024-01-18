package com.kproject.composejourney.presentation.content.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun ProfileScreen() {
    var state by remember { mutableStateOf(State.Loading) }
    AnimatedContent(
        targetState = state,
        transitionSpec = {
            scaleIn(
                animationSpec = tween(700)
            ) togetherWith fadeOut(animationSpec = tween(700))
        },
        label = "AnimatedContent",
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            state = when (state) {
                State.Loading -> State.Success
                State.Success -> State.Error
                State.Error -> State.Loading
            }
        }
    ) { targetState ->
        when (targetState) {
            State.Loading -> {
                LoadingContent()
            }
            State.Success -> {
                ProfileContent()
            }
            State.Error -> {
                ErrorContent()
            }
        }
    }
}

@Composable
private fun LoadingContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator()
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Carregando perfil...",
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ProfileContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_nature),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Informações carregadas com sucesso.",
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ErrorContent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Erro ao obter informações do perfil.",
            fontSize = 18.sp,
        )
    }
}

private enum class State {
    Loading,
    Success,
    Error
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen()
        }
    }
}