package com.thevs.quotesapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun BaseButton(
    onClick: () -> Unit,
    buttonText: String,
    icon: String? = null,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium.copy(
            topStart = CornerSize(12.dp),
            topEnd = CornerSize(12.dp),
            bottomStart = CornerSize(12.dp),
            bottomEnd = CornerSize(12.dp)
        )
    ) {
        icon?.let {
            when (icon) {
                "Refresh" -> Icons.Default.Refresh
                "ArrowForward" -> Icons.Default.ArrowForward
                else -> null
            }?.let { it1 ->
                Icon(
                    imageVector = it1,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        }
        Text(
            text = buttonText,
            fontSize = 16.sp
        )
    }
}


@Preview
@Composable
fun PreviewBaseButton() {
    BaseButton(
        onClick = { /*TODO*/ },
        buttonText = "Refresh",
    )
}
