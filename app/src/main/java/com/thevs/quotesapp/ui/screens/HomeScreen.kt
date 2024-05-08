package com.thevs.quotesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.thevs.quotesapp.model.QuotesAPI
import com.thevs.quotesapp.ui.Routes
import com.thevs.quotesapp.ui.components.Title
import com.thevs.quotesapp.ui.components.BaseButton
import com.thevs.quotesapp.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel, navHostController: NavHostController) {
    Title(title = "Random Quote")
    Column {
        viewModel.quotes.value.forEach { quote ->
            QuoteItem(quote, viewModel)
            Spacer(modifier = Modifier.height(16.dp))
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            BaseButton({ navHostController.navigate(Routes.CategoriesScreen.route) }, "Categories")
        }
    }
}


@Composable
fun QuoteItem(quote: QuotesAPI.QuoteBean, viewModel: MainViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 136.dp)
            .background(color = Color.DarkGray)
            .padding(16.dp)
    ) {
        Text(
            text = "${quote.text} - ${quote.author}",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row{
            BaseButton({ viewModel.loadQuotes() }, "", "Refresh")
            Spacer(modifier = Modifier.padding(16.dp))
            BaseButton({ /* TODO */ }, "Quote Details", "ArrowForward")
        }
    }
}

