package com.quotes.data.remote


import com.quotes.domain.models.AllQuotesDC
import com.quotes.network.ALL_QUOTES
import com.quotes.network.GET_SINGLE_QUOTE
import com.quotes.network.RANDOM_QUOTES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET(ALL_QUOTES)
    suspend fun getAllQuotes(): Response<AllQuotesDC>

    @GET(RANDOM_QUOTES)
    suspend fun getRandomQuote() : Response<AllQuotesDC.Quote>


    @GET(GET_SINGLE_QUOTE)
    suspend fun getSingleQuotes(
        @Path("id") id: String
    ) : Response<AllQuotesDC.Quote>

}