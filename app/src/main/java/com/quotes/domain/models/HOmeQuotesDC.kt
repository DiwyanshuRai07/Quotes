package com.quotes.domain.models

data class HOmeQuotesDC(
    val randomQuote: AllQuotesDC.Quote? = null,
    val allQuotesList: List<AllQuotesDC.Quote>? = null,

)
