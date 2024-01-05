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
import com.kproject.composejourney.presentation.theme.MyAppTheme

@Composable
fun Content() {
    Image(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "profile image",
        modifier = Modifier.size(50.dp)
    )
    Text(text = "John")
}

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
private fun ProfileColumnCustomAlignment() {
    Column(
        modifier = Modifier.width(250.dp),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = "profile image",
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "John",
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview1() {
    MyAppTheme {
        ProfileNoLayout()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview2() {
    MyAppTheme {
        ProfileColumn()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview3() {
    MyAppTheme {
        ProfileColumnHorizontalStart()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview4() {
    MyAppTheme {
        ProfileColumnCenterHorizontally()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview5() {
    MyAppTheme {
        ProfileColumnHorizontalEnd()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview6() {
    MyAppTheme {
        ProfileColumnArrangementTop()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview7() {
    MyAppTheme {
        ProfileColumnArrangementCenter()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview8() {
    MyAppTheme {
        ProfileColumnArrangementBottom()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview9() {
    MyAppTheme {
        ProfileColumnArrangementSpaceBetween()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview10() {
    MyAppTheme {
        ProfileColumnCenter()
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview11() {
    MyAppTheme {
        ProfileColumnCustomAlignment()
    }
}
