package com.quotes.domain.usecase

import com.quotes.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllQuoteUseCase @Inject constructor(
    private val quotesRepository: QuoteRepository
) {

    operator fun invoke() = flow {
        quotesRepository.getAllQuotes().let {
            if (it.isSuccessful) {
                emit(it.body()?.quotes)
            }
        }
    }

}