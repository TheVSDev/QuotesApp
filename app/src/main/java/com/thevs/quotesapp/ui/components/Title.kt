package com.thevs.quotesapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.thevs.quotesapp.ui.theme.tertiaryLight

@Composable
fun Title(title: String, modifier: Modifier = Modifier, color: Color = tertiaryLight) {
    Text(
        text = title,
        fontSize = 30.sp,
        color = color,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewTitle() {
    Title(title = "Test:")
}
