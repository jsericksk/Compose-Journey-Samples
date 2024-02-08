package com.kproject.composejourney.presentation.content.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
fun HomeScreen(
    onNavigateToTracking: (code: String, cep: Int) -> Unit,
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        onUiEvent = homeViewModel::onUiEvent,
        onNavigateToTracking = {
            onNavigateToTracking.invoke(uiState.code, uiState.cep)
        }
    )
}

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onUiEvent: (HomeUiEvent) -> Unit,
    onNavigateToTracking: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val verticalSpacing = 14.dp
        Text(
            text = stringResource(id = R.string.tracker),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        CommonTextField(
            text = uiState.code,
            onTextChange = {
                onUiEvent.invoke(HomeUiEvent.CodeChanged(it))
            },
            label = stringResource(id = R.string.tracking_code),
            leadingIcon = Icons.Default.Info
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = uiState.cepText,
            onTextChange = { updatedCep ->
                updatedCep.toIntOrNull()?.let { cep ->
                    onUiEvent.invoke(HomeUiEvent.CepChanged(cep))
                }
                if (updatedCep.isBlank()) {
                    onUiEvent.invoke(HomeUiEvent.CepChanged(UndefinedCep))
                }
            },
            label = stringResource(id = R.string.cep),
            leadingIcon = Icons.Default.LocationOn,
            keyboardType = KeyboardType.Number
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        Button(
            onClick = onNavigateToTracking,
            contentPadding = PaddingValues(16.dp),
            enabled = uiState.canNavigateToTrackingScreen,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.track))
        }
    }
}

@Composable
private fun HomeScreenWithoutStateHolder(onNavigateToTracking: (code: String, cep: Int) -> Unit) {
    var code by remember { mutableStateOf("") }
    var cepNumber by remember { mutableIntStateOf(UndefinedCep) }
    val cepText: String = remember(cepNumber) {
        if (cepNumber == UndefinedCep) "" else cepNumber.toString()
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        val verticalSpacing = 14.dp
        Text(
            text = stringResource(id = R.string.tracker),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        CommonTextField(
            text = code,
            onTextChange = {
                code = it
            },
            label = stringResource(id = R.string.tracking_code),
            leadingIcon = Icons.Default.Info
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = cepText,
            onTextChange = { updatedCep ->
                updatedCep.toIntOrNull()?.let { cep ->
                    cepNumber = cep
                }
                if (updatedCep.isBlank()) {
                    cepNumber = UndefinedCep
                }
            },
            label = stringResource(id = R.string.cep),
            leadingIcon = Icons.Default.LocationOn,
            keyboardType = KeyboardType.Number
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        Button(
            onClick = {
                onNavigateToTracking.invoke(code, cepNumber)
            },
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.track))
        }
    }
}

@Composable
private fun CommonTextField(
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null
            )
        },
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    PreviewTheme(darkTheme = false) {
        HomeScreen(
            uiState = HomeUiState(
                code = "AMZ123456789",
                cep = 1234689
            ),
            onUiEvent = {},
            onNavigateToTracking = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenWithoutStateHolderPreview() {
    PreviewTheme(darkTheme = false) {
        HomeScreenWithoutStateHolder(onNavigateToTracking = { _, _ -> })
    }
}