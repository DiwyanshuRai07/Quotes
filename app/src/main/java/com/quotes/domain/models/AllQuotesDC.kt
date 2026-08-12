package com.quotes.domain.models

import androidx.annotation.Keep

@Keep
data class AllQuotesDC(
    val quotes: List<Quote>
){
    data class Quote(
        val author: String ? = "",
        val id: Int? = 0,
        val quote: String? = ""
    )
}