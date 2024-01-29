package com.kproject.composejourney.presentation.content.screens.tracking

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
fun TrackingScreen(
    code: String,
    cep: Int,
    onNavigateBack: () -> Unit
) {
    val trackingViewModel: TrackingViewModel = viewModel()
    val uiState by trackingViewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        trackingViewModel.getTrackingInfo(code = code, cep = cep)
    }
    TrackingScreenContent(
        uiState = uiState,
        onNavigateBack = onNavigateBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TrackingScreenContent(
    uiState: TrackingUiState,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Informações de Rastreio") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
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
                    MainContent(uiState = uiState)
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
    }
}

@Composable
private fun MainContent(uiState: TrackingUiState) {
    CenteredColumn {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = uiState.code,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Código de rastreio",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = uiState.cep.toString(),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "CEP",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "Status: Em trânsito",
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
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
            text = "Houve um erro ao obter as informações.",
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
private fun TrackingScreenContentPreview() {
    PreviewTheme(darkTheme = false) {
        TrackingScreenContent(
            uiState = TrackingUiState(
                viewState = ViewState.Success,
                code = "AMZ123456789",
                cep = 123456789
            ),
            onNavigateBack = {}
        )
    }
}