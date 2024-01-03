package com.kproject.composejourney.presentation.content.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kproject.composejourney.R
import com.kproject.composejourney.presentation.theme.ComposeJourneyTheme

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

@Composable
private fun Content() {
    Image(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "profile image",
        modifier = Modifier.size(50.dp)
    )
    Text(text = "John")
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    ComposeJourneyTheme {
        ProfileRow()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    ComposeJourneyTheme {
        ProfileRowHorizontalStart()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    ComposeJourneyTheme {
        ProfileRowHorizontalCenter()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    ComposeJourneyTheme {
        ProfileRowHorizontalEnd()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    ComposeJourneyTheme {
        ProfileRowHorizontalSpaceBetween()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview6() {
    ComposeJourneyTheme {
        ProfileRowHorizontalSpaceEvenly()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview7() {
    ComposeJourneyTheme {
        ProfileRowCenter()
    }
}

