package com.thevs.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.thevs.quotesapp.ui.screens.HomeScreen
import com.thevs.quotesapp.ui.theme.QuotesAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thevs.quotesapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuotesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MainViewModel = viewModel()
                    viewModel.loadQuotes()
                    HomeScreen(viewModel)
                }
            }
        }
    }
}