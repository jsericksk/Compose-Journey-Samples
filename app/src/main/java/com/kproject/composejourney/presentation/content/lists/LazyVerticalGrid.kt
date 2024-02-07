package com.kproject.composejourney.presentation.content.lists

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.MyAppTheme

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
        ImageListAdaptive(imageList = imageList)
    }
}

@Composable
private fun ImageList(
    imageList: List<ResourceImage>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
    ) {
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
private fun ImageListAdaptive(
    imageList: List<ResourceImage>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        modifier = modifier
    ) {
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
private fun ImageItem(
    image: ResourceImage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .clickable { onClick.invoke() }
    ) {
        Image(
            painter = painterResource(id = image.resourceId),
            contentDescription = image.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ImageScreenPreview() {
    MyAppTheme(darkTheme = false) {
        ImageScreen()
    }
}