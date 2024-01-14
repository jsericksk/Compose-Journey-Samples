package com.kproject.composejourney.presentation.content.sideeffects

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.presentation.theme.MyAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MyHorizontalPager() {
    val pagerState = rememberPagerState(pageCount = { 10 })
    Column {
        HorizontalPager(state = pagerState) { page ->
            Text(
                text = "Página atual: $page",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }

        val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                // animateScrollToPage() é uma suspend function
                coroutineScope.launch {
                    pagerState.animateScrollToPage(5)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Pular para a página 5")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        MyHorizontalPager()
    }
}