package com.kproject.composejourney.presentation.content.screens.profile

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
fun ProfileScreen(email: String) {
    val viewModel: ProfileViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ProfileScreenContent(uiState = uiState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileScreenContent(uiState: ProfileUiState) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Meu Perfil") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }
    ) { paddingValues ->
        AnimatedContent(
            targetState = uiState.viewState,
            transitionSpec = {
                scaleIn(
                    animationSpec = tween(700)
                ) togetherWith scaleOut(animationSpec = tween(700))
            },
            label = "AnimatedContent",
            modifier = Modifier.padding(paddingValues)
        ) { targetState ->
            when (targetState) {
                ViewState.Loading -> {
                    LoadingContent()
                }
                ViewState.Success -> {
                    ProfileContent(uiState = uiState)
                }
                ViewState.Error -> {
                    ErrorContent()
                }
            }
        }
    }
}

@Composable
private fun LoadingContent() {
    CenteredColumn {
        CircularProgressIndicator()
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Carregando perfil...",
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ProfileContent(uiState: ProfileUiState) {
    CenteredColumn {
        Image(
            painter = painterResource(id = uiState.profileImage),
            contentDescription = "Profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(Modifier.height(14.dp))
        Text(
            text = uiState.username,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = uiState.email,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
private fun ErrorContent() {
    CenteredColumn {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Houve um erro ao obter as informações do perfil.",
            fontSize = 18.sp,
        )
    }
}

@Composable
private fun CenteredColumn(
    modifier: Modifier = Modifier,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        content = content
    )
}

@Preview
@Composable
private fun Preview1() {
    PreviewTheme(darkTheme = false) {
        ProfileScreenContent(
            uiState = ProfileUiState(
                viewState = ViewState.Success,
                username = "John Titor",
                email = "johntitor@gmail.com"
            )
        )
    }
}