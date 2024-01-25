package com.kproject.composejourney.presentation.content.screens.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
fun RegisterScreen(
    onNavigateToProfile: (email: String) -> Unit,
    uiState: RegisterUiState,
    onUiEvent: (RegisterUiEvent) -> Unit
) {
   RegisterScreenContent(
       onNavigateToProfile = onNavigateToProfile,
       uiState = uiState,
       onUiEvent = onUiEvent
   )
}

@Composable
private fun RegisterScreen(
    onNavigateToProfile: (email: String) -> Unit
) {
    val viewModel: RegisterViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    RegisterScreenContent(
        onNavigateToProfile = onNavigateToProfile,
        uiState = uiState,
        onUiEvent = viewModel::onUiEvent
    )
}

@Composable
private fun RegisterScreenContent(
    onNavigateToProfile: (email: String) -> Unit,
    uiState: RegisterUiState,
    onUiEvent: (RegisterUiEvent) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        val verticalSpacing = 14.dp
        Text(
            text = "Registrar-se",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        CommonTextField(
            text = uiState.username,
            onTextChange = {
              onUiEvent.invoke(RegisterUiEvent.UsernameChanged(it))
            },
            label = "Nome de usuário",
            leadingIcon = Icons.Default.Person
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = uiState.email,
            onTextChange = {
                onUiEvent.invoke(RegisterUiEvent.EmailChanged(it))
            },
            label = "E-mail",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = uiState.password,
            onTextChange = {
                onUiEvent.invoke(RegisterUiEvent.PasswordChanged(it))
            },
            label = "Senha",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = uiState.address,
            onTextChange = {
                onUiEvent.invoke(RegisterUiEvent.AddressChanged(it))
            },
            label = "Endereço",
            leadingIcon = Icons.Default.LocationOn
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        Button(
            onClick = {
                onNavigateToProfile.invoke(uiState.email)
            },
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar-se")
        }
    }
}

@Composable
private fun RegisterScreenWithoutStateHolder(
    onNavigateToProfile: (email: String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {
        val verticalSpacing = 14.dp
        Text(
            text = "Registrar-se",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        CommonTextField(
            text = username,
            onTextChange = { username = it },
            label = "Nome de usuário",
            leadingIcon = Icons.Default.Person
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = email,
            onTextChange = { email = it },
            label = "E-mail",
            leadingIcon = Icons.Default.Email,
            keyboardType = KeyboardType.Email
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = password,
            onTextChange = { password = it },
            label = "Senha",
            leadingIcon = Icons.Default.Lock,
            visualTransformation = PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password
        )
        Spacer(Modifier.height(verticalSpacing))
        CommonTextField(
            text = address,
            onTextChange = { address = it },
            label = "Endereço",
            leadingIcon = Icons.Default.LocationOn
        )
        Spacer(Modifier.height(verticalSpacing + verticalSpacing))
        Button(
            onClick = {
                onNavigateToProfile.invoke(email)
            },
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar-se")
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
    visualTransformation: VisualTransformation = VisualTransformation.None,
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
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = CircleShape,
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    PreviewTheme(darkTheme = false) {
        RegisterScreen(
            onNavigateToProfile = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    PreviewTheme(darkTheme = false) {
        RegisterScreenContent(
            onNavigateToProfile = {},
            uiState = RegisterUiState(),
            onUiEvent = {}
        )
    }
}