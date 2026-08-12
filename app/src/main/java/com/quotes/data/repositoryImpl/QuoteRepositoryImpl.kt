package com.quotes.data.repositoryImpl

import com.quotes.data.remote.APIService
import com.quotes.domain.models.AllQuotesDC
import com.quotes.domain.repository.QuoteRepository
import retrofit2.Response
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val apiService: APIService
) : QuoteRepository {

    override suspend fun getAllQuotes(): Response<AllQuotesDC> {
        return apiService.getAllQuotes()
    }

    override suspend fun getRandomQuote(): Response<AllQuotesDC.Quote> {
        return apiService.getRandomQuote()
    }

    override suspend fun getSingleQuotes(id: String): Response<AllQuotesDC.Quote> {
        return apiService.getSingleQuotes(id)
    }
}