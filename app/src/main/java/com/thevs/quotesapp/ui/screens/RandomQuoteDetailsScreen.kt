package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thevs.quotesapp.ui.Routes
import com.thevs.quotesapp.ui.components.Title
import com.thevs.quotesapp.ui.components.BaseButton

@Composable
fun RandomQuoteDetailsScreen(navHostController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            BaseButton({ navHostController.navigate(Routes.HomeScreen.route) }, "", "ArrowBack")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Title(title = "Random Quote Details")
    }
}