package com.thevs.quotesapp.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request

object QuotesAPI {
    val client = OkHttpClient()
    private val gson = Gson()

    fun sendGet(url: String, apiKey: String, host: String): String {
        println("url : $url")
        val request = Request.Builder().url(url).addHeader("X-RapidAPI-Key", apiKey).addHeader("X-RapidAPI-Host", host).build()
        return client.newCall(request).execute().use {
            if (!it.isSuccessful) {
                throw Exception("Server response incorrect :${it.code}\n${it.body.string()}")
            }
            it.body.string()
        }
    }

    data class QuoteBean(
        val id: Int,
        val text: String,
        val author: String,
        val category: String
    )

    fun loadQuotes(count: Int): List<QuoteBean> {
        val apiKey = "50e41f1dc6mshe5eb91a68efba7fp14e399jsn64be57b5266a"
        val host = "famous-quotes4.p.rapidapi.com"
        val url = "https://famous-quotes4.p.rapidapi.com/random?category=all&count=$count"
        val json = sendGet(url, apiKey, host)
        val type = object : TypeToken<List<QuoteBean>>() {}.type
        return gson.fromJson(json, type)
    }
}

fun main() {
    val count = 1
    val quotes = QuotesAPI.loadQuotes(count)
    quotes.forEach { quote ->
        println("Quote: $quote")
    }
}
