package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thevs.quotesapp.model.QuotesAPI
import com.thevs.quotesapp.ui.components.Title
import com.thevs.quotesapp.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    Title(title = "Home Screen")
    Column {
        viewModel.quotes.value.forEach { quote ->
            QuoteItem(quote, viewModel)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun QuoteItem(quote: QuotesAPI.QuoteBean, viewModel: MainViewModel) {
    Column {
        Text(text = "${quote.text} - ${quote.author}")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { viewModel.loadQuotes() }) {
            Text(text = "Refresh")
        }
    }
}
