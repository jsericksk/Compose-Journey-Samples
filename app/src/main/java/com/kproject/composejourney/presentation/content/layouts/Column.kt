package com.kproject.composejourney.presentation.content.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
private fun ProfileNoLayout() {
    Image(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "profile image",
        modifier = Modifier.size(50.dp)
    )
    Text(text = "John")
}

@Composable
private fun ProfileColumn() {
    Column {
        Content()
    }
}

@Composable
private fun ProfileColumnHorizontalStart() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(250.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnCenterHorizontally() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(250.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnHorizontalEnd() {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.width(250.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnArrangementTop() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.size(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnArrangementCenter() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.size(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnArrangementBottom() {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.size(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnArrangementSpaceBetween() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.size(150.dp)
    ) {
        Content()
    }
}

@Composable
private fun ProfileColumnCenter() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
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
        ProfileNoLayout()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    ComposeJourneyTheme {
        ProfileColumn()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    ComposeJourneyTheme {
        ProfileColumnHorizontalStart()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    ComposeJourneyTheme {
        ProfileColumnCenterHorizontally()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    ComposeJourneyTheme {
        ProfileColumnHorizontalEnd()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview6() {
    ComposeJourneyTheme {
        ProfileColumnArrangementTop()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview7() {
    ComposeJourneyTheme {
        ProfileColumnArrangementCenter()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview8() {
    ComposeJourneyTheme {
        ProfileColumnArrangementBottom()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview9() {
    ComposeJourneyTheme {
        ProfileColumnArrangementSpaceBetween()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview10() {
    ComposeJourneyTheme {
        ProfileColumnCenter()
    }
}
