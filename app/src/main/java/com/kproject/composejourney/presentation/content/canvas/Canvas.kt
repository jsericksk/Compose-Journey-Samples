package com.kproject.composejourney.presentation.content.canvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.composejourney.presentation.theme.PreviewTheme

@Composable
private fun Rect1() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val rectSize = 150.dp.toPx()
        drawRect(
            color = Color.Red,
            topLeft = Offset(0f, 0f),
            size = Size(rectSize, rectSize),
            style = Fill
        )
    }
}

@Composable
private fun Rect2() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val width = size.width
        val height = size.height

        val rectSize = 150.dp.toPx()
        drawRect(
            color = Color.Red,
            topLeft = Offset(
                x = (width - rectSize) / 2,
                y = (height - rectSize) / 2 - rectSize - (30.dp.toPx())
            ),
            size = Size(rectSize, rectSize),
            style = Stroke(width = 10.dp.toPx())
        )

        val corner = 24.dp.toPx()
        drawRoundRect(
            color = Color.Red,
            topLeft = Offset(
                x = (width - rectSize) / 2,
                y = (height - rectSize) / 2
            ),
            size = Size(rectSize, rectSize),
            style = Fill,
            cornerRadius = CornerRadius(x = corner, y = corner)
        )
    }
}

@Composable
private fun Rect3() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val canvasSize = size
        val rectSize = 100.dp.toPx()

        // Top Start
        drawRect(
            color = Color.Red,
            topLeft = Offset(0f, 0f),
            size = Size(rectSize, rectSize)
        )

        // Top End
        drawRect(
            color = Color.Red,
            topLeft = Offset(canvasSize.width - rectSize, 0f),
            size = Size(rectSize, rectSize)
        )

        // Bottom Start
        drawRect(
            color = Color.Red,
            topLeft = Offset(0f, canvasSize.height - rectSize),
            size = Size(rectSize, rectSize)
        )

        // Bottom End
        drawRect(
            color = Color.Red,
            topLeft = Offset(canvasSize.width - rectSize, canvasSize.height - rectSize),
            size = Size(rectSize, rectSize)
        )
    }
}

@Composable
private fun Circle1() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val circleRadius = 100.dp.toPx()
        drawCircle(
            color = Color.Blue,
            radius = circleRadius,
            center = Offset(center.x, center.y - circleRadius),
            style = Fill
        )
        drawCircle(
            color = Color.Blue,
            radius = circleRadius,
            center = Offset(center.x, center.y + (circleRadius + 20.dp.toPx())),
            style = Stroke(width = 10.dp.toPx())
        )
    }
}

@Composable
private fun Arc1() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val arcSize = 150.dp.toPx()
        drawArc(
            color = Color.Blue,
            startAngle = 0f,
            sweepAngle = 270f,
            topLeft = Offset(5.dp.toPx(), arcSize),
            size = Size(arcSize, arcSize),
            useCenter = true
        )
        drawArc(
            color = Color.Blue,
            startAngle = 0f,
            sweepAngle = 270f,
            topLeft = Offset(arcSize + 20.dp.toPx(), arcSize),
            size = Size(arcSize, arcSize),
            useCenter = false
        )

        drawArc(
            color = Color.Red,
            startAngle = 90f,
            sweepAngle = 180f,
            topLeft = Offset(5.dp.toPx(), (arcSize * 2) + 30.dp.toPx()),
            size = Size(arcSize, arcSize),
            useCenter = true,
            style = Stroke(width = 6.dp.toPx()),
        )
        drawArc(
            color = Color.Red,
            startAngle = 90f,
            sweepAngle = 180f,
            topLeft = Offset(arcSize + 20.dp.toPx(), (arcSize * 2) + 30.dp.toPx()),
            size = Size(arcSize, arcSize),
            useCenter = false,
            style = Stroke(width = 6.dp.toPx()),
        )
    }
}

@Composable
private fun Path1() {
    Spacer(
        modifier = Modifier
            .drawWithCache {
                val path = Path().apply {
                    moveTo(x = 0f, y = size.height / 2)
                    lineTo(x = size.width / 2, y = 0f)
                    lineTo(x = size.width, y = size.height / 2)
                    close()
                }
                onDrawBehind {
                    drawPath(
                        path = path,
                        style = Stroke(width = 8.dp.toPx()),
                        color = Color.Red
                    )
                }
            }
            .fillMaxSize()
    )
}

@Composable
private fun Path2() {
    Spacer(
        modifier = Modifier
            .drawWithCache {
                val path = Path().apply {
                    moveTo(x = 0f, y = size.height / 2)
                    quadraticBezierTo(
                        x1 = size.width / 2,
                        y1 = 0f,
                        x2 = size.width,
                        y2 = size.height / 2
                    )
                    close()
                }
                onDrawBehind {
                    drawPath(
                        path = path,
                        style = Fill,
                        color = Color.Red
                    )
                }
            }
            .fillMaxSize()
    )
}

@Composable
private fun Path3() {
    Spacer(
        modifier = Modifier
            .drawWithCache {
                val path = Path().apply {
                    moveTo(x = 0f, y = size.height / 2)
                    quadraticBezierTo(
                        x1 = 30.dp.toPx(),
                        y1 = 0f,
                        x2 = size.width,
                        y2 = size.height / 2
                    )
                }
                onDrawBehind {
                    drawPath(
                        path = path,
                        style = Stroke(width = 8.dp.toPx()),
                        color = Color.Red
                    )
                }
            }
            .fillMaxSize()
    )
}

@Composable
private fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val decorationColor = MaterialTheme.colorScheme.primary
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                drawDecoration(color = decorationColor)
            }
            .padding(26.dp)
    ) {
        Text(
            text = "Login",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(24.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "E-mail")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            shape = CircleShape,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Senha")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            shape = CircleShape,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(18.dp))
        Button(
            onClick = {},
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

private fun DrawScope.drawDecoration(color: Color) {
    drawCircle(
        color = color,
        radius = 150.dp.toPx(),
        center = Offset(x = 0f, y = 0f),
        style = Fill
    )
    drawCircle(
        color = color,
        radius = 120.dp.toPx(),
        center = Offset(x = 120.dp.toPx(), y = -30.dp.toPx()),
        style = Fill
    )

    val path = Path().apply {
        moveTo(x = 0f, y = size.height)
        quadraticBezierTo(
            x1 = size.width / 2,
            y1 = size.height - 150.dp.toPx(),
            x2 = size.width,
            y2 = size.height
        )
        close()
    }
    drawPath(
        path = path,
        color = color,
        style = Fill
    )
}

@Preview(showBackground = true)
@Composable
private fun Rect1Preview() {
    PreviewTheme() {
        Rect1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Rect2Preview() {
    PreviewTheme() {
        Rect2()
    }
}

@Preview(showBackground = true)
@Composable
private fun Rect3Preview() {
    PreviewTheme() {
        Rect3()
    }
}

@Preview(showBackground = true)
@Composable
private fun Circle1Preview() {
    PreviewTheme() {
        Circle1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Arc1Preview() {
    PreviewTheme {
        Arc1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Path1Preview() {
    PreviewTheme {
        Path1()
    }
}

@Preview(showBackground = true)
@Composable
private fun Path2Preview() {
    PreviewTheme {
        Path2()
    }
}

@Preview(showBackground = true)
@Composable
private fun Path3Preview() {
    PreviewTheme {
        Path3()
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    PreviewTheme {
        LoginScreen()
    }
}
