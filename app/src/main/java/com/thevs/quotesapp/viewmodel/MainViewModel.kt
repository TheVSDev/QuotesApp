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

    fun loadQuotes() {
        viewModelScope.launch {
            _quotes.value = QuotesAPI.loadQuotes(1)
        }
    }
}