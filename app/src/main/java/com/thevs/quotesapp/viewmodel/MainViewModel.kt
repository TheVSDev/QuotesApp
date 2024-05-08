package com.thevs.quotesapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thevs.quotesapp.model.QuotesAPI
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _quotes = mutableStateOf<List<QuotesAPI.QuoteBean>>(emptyList())
    val quotes: State<List<QuotesAPI.QuoteBean>> = _quotes

    // State for storing categories
    private val _categories = mutableStateOf<List<String>>(emptyList())
    val categories: State<List<String>> = _categories

    fun loadQuotes() {
        viewModelScope.launch {
            val newQuotes = QuotesAPI.loadQuotes(1)
            _quotes.value = newQuotes
        }
    }

    // Function to load categories
    fun loadCategories() {
        viewModelScope.launch {
            val categories = QuotesAPI.loadQuoteCategories()
            _categories.value = categories
        }
    }
}