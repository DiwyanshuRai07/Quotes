package com.quotes.domain.usecase

import com.quotes.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {

    operator fun invoke(id: String) = flow {
        quoteRepository.getSingleQuotes(id).let {
            if(it.isSuccessful)
            {
                emit(it.body())
            }
        }
    }
}