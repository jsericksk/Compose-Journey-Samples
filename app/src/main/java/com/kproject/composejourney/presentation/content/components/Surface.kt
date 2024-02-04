package com.kproject.composejourney.presentation.content.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun Surface() {
    Column(
        modifier = Modifier
            .background(Color(0xFF1A237E))
            .padding(12.dp)
    ) {
        Surface(color = MaterialTheme.colorScheme.background) {
            Text(
                text = "Texto com Surface",
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(Modifier.height(20.dp))
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            Text(
                text = "Texto sem Surface",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun LoginScreen(onThemeChange: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "E-mail")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Senha")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(18.dp))
        Button(
            onClick = {},
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
        Spacer(Modifier.height(18.dp))
        IconButton(onClick = onThemeChange) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_dark_mode_24),
                contentDescription = null,
                modifier = Modifier
                    .size(38.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme(darkTheme = true) {
        Surface()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        LoginScreen(onThemeChange = {})
    }
}