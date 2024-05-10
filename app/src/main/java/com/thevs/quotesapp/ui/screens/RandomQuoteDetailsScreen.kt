package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thevs.quotesapp.model.QuoteBean
import com.thevs.quotesapp.ui.components.Header
import com.thevs.quotesapp.ui.components.Label
import com.thevs.quotesapp.viewmodel.MainViewModel

@Composable
fun RandomQuoteDetailsScreen(navHostController: NavHostController, viewModel: MainViewModel) {
    val randomQuote = remember { mutableStateOf<QuoteBean?>(null) }

    LaunchedEffect(Unit) {
        viewModel.loadQuotes()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Header("Random Quote Details", navHostController)

        randomQuote.value?.let { quote ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                QuoteDetails("Quote", quote.text)
                QuoteDetails("Author", quote.author)
                QuoteDetails("Category", quote.category)
                QuoteDetails("Id", "#${quote.id}")
            }
        }
    }

    // Observe changes in quotes and update randomQuote
    LaunchedEffect(viewModel.quotes.value) {
        val quotes = viewModel.quotes.value
        if (quotes.isNotEmpty()) {
            val randomIndex = quotes.indices.random()
            randomQuote.value = quotes[randomIndex]
        }
    }
}

@Composable
fun QuoteDetails(label: String, quoteValue: String) {
    Spacer(modifier = Modifier.height(25.dp))
    Label(label)
    Spacer(modifier = Modifier.height(7.dp))
    Text(text = quoteValue)
}