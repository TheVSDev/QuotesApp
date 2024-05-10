package com.thevs.quotesapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thevs.quotesapp.model.QuoteBean
import com.thevs.quotesapp.model.QuotesAPI
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // States for storing ...
    // ... quotes
    private val _quotes = mutableStateOf<List<QuoteBean>>(emptyList())
    val quotes: State<List<QuoteBean>> = _quotes

    // ... categories
    private val _categories = mutableStateOf<List<String>>(emptyList())
    val categories: State<List<String>> = _categories

    // ... error messages
    private val _errorMessage = mutableStateOf<String?>(null)


    // Functions for loading ...
    // ... one quote
    fun loadQuotes() {
        viewModelScope.launch {
            try {
                val newQuotes = QuotesAPI.loadQuotes(1)
                _quotes.value = newQuotes
                _errorMessage.value = null // Reset error message if previous attempt was successful
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load quotes: ${e.message}"
            }
        }
    }

    // ... categories
    fun loadCategories() {
        viewModelScope.launch {
            try {
                val categories = QuotesAPI.loadQuoteCategories()
                _categories.value = categories
                _errorMessage.value = null // Reset error message if previous attempt was successful
            } catch (e: Exception) {
                _errorMessage.value = "Failed to load categories: ${e.message}"
            }
        }
    }
}