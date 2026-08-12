package com.quotes.domain.repository

import com.quotes.domain.models.AllQuotesDC
import retrofit2.Response

interface QuoteRepository {
    suspend fun getAllQuotes(): Response<AllQuotesDC>
    suspend fun getRandomQuote(): Response<AllQuotesDC.Quote>

    suspend fun getSingleQuotes(id : String): Response<AllQuotesDC.Quote>
}