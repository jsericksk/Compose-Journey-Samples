package com.kproject.composejourney.presentation.content.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
private fun ProfileRow() {
    Row {
        Content()
    }
}

@Composable
private fun ProfileRowHorizontalStart() {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.width(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileRowHorizontalCenter() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.width(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileRowHorizontalEnd() {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.width(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileRowHorizontalSpaceBetween() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.width(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileRowHorizontalSpaceEvenly() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.width(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileRowCenter() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.size(150.dp)
    ) {
        Content()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        ProfileRow()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        ProfileRowHorizontalStart()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        ProfileRowHorizontalCenter()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    MyAppTheme {
        ProfileRowHorizontalEnd()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    MyAppTheme {
        ProfileRowHorizontalSpaceBetween()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview6() {
    MyAppTheme {
        ProfileRowHorizontalSpaceEvenly()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview7() {
    MyAppTheme {
        ProfileRowCenter()
    }
}

