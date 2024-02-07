package com.kproject.composejourney.presentation.content.lists

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun ColumnScrollable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Conteúdo que pode ultrapassar a resolução da tela verticalmente
    }
}

@Composable
private fun ImageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val imageList = remember {
            List(25) { index ->
                ResourceImage(
                    resourceId = if (index % 2 == 0) R.drawable.img_nature else R.drawable.img_moon_space,
                    title = "Image $index"
                )
            }
        }
        ImageListWithItem(imageList = imageList)
    }
}

@Composable
private fun ImageList(
    imageList: List<ResourceImage>,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    LazyColumn(modifier = modifier) {
        items(imageList) { image ->
            ImageItem(
                image = image,
                onClick = {
                    Toast.makeText(context, image.title, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
private fun ImageListWithItem(
    imageList: List<ResourceImage>,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    LazyColumn(modifier = modifier) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Blue)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Minhas imagens",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }

        items(imageList) { image ->
            ImageItem(
                image = image,
                onClick = {
                    Toast.makeText(context, image.title, Toast.LENGTH_SHORT).show()
                }
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Red)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Nenhuma nova imagem por enquanto.",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }
        }
    }
}

@Composable
private fun ImageItem(
    image: ResourceImage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(16.dp)
    OutlinedCard(
        shape = shape,
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape)
            .clickable { onClick.invoke() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = image.resourceId),
                contentDescription = image.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = image.title,
                fontSize = 18.sp
            )
        }
    }
}

data class ResourceImage(
    @DrawableRes val resourceId: Int,
    val title: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ImageScreenPreview() {
    MyAppTheme(darkTheme = false) {
        ImageScreen()
    }
}