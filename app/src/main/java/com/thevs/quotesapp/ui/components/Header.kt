package com.thevs.quotesapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Header(title: String, navHostController: NavHostController?) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        BaseButton({ navHostController?.popBackStack() }, "", "ArrowBack")
    }
    Spacer(modifier = Modifier.height(16.dp))
    Title(title = title)
}