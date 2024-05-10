package com.thevs.quotesapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Label(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        modifier = modifier,
        fontWeight = FontWeight(800)
    )
}

@Preview
@Composable
fun PreviewLabel() {
    Label(label = "Test:")
}
