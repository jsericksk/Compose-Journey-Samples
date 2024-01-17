package com.kproject.composejourney.presentation.content.sideeffects

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.theme.MyAppTheme
import kotlinx.coroutines.delay


private class ProfileDataSource {

    suspend fun getProfileName(): String {
        delay(3000L)
        return "Compose Journey"
    }
}

private enum class State {
    Loading,
    Success,
    Error
}

@Composable
private fun Profile() {
    val profileDataSource = remember { ProfileDataSource() }
    var state by remember { mutableStateOf(State.Loading) }
    var profileName by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        profileName = profileDataSource.getProfileName()
        state = State.Success
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            State.Loading -> {
                CircularProgressIndicator(color = Color.Blue)
            }
            State.Success -> {
                Text(text = "Nome do perfil: $profileName")
            }
            State.Error -> {
                Text(text = "Erro ao obter o nome do perfil.")
            }
        }
    }
}

@Composable
private fun CountdownTimer() {
    val initialTime = 5
    var currentTime by remember { mutableIntStateOf(initialTime) }

    LaunchedEffect(key1 = currentTime) {
        if (currentTime > 0) {
            delay(1000L)
            currentTime -= 1
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(250.dp)
            .clickable { currentTime = initialTime }
            .padding(50.dp)
            .border(
                width = 3.dp,
                color = Color.Red,
                shape = CircleShape
            )
    ) {
        Text(
            text = "$currentTime",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        Profile()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MyAppTheme {
        CountdownTimer()
    }
}