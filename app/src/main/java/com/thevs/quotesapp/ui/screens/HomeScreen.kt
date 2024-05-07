package com.thevs.quotesapp.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.thevs.quotesapp.model.QuotesAPI
import com.thevs.quotesapp.ui.components.Title

@Composable
fun HomeScreen(quotes: List<QuotesAPI.QuoteBean>) {
    Title(title = "Home Screen")
    quotes.forEach { quote ->
        Text(text = "${quote.text} - ${quote.author}")
    }
}
