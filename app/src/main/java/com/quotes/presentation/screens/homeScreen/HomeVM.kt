package com.quotes.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.domain.models.HOmeQuotesDC
import com.quotes.domain.usecase.AllQuoteUseCase
import com.quotes.domain.usecase.RandomQuoteUseCase
import com.quotes.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val allQuotesUseCase: AllQuoteUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase
) : ViewModel() {

    var quotesData = MutableStateFlow<NetworkUIState<HOmeQuotesDC>>(NetworkUIState.Loading)
        private set

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            try {
                quotesData.tryEmit(NetworkUIState.Loading)
                allQuotesUseCase()
                    .combine(randomQuoteUseCase()) { allQuotesList, randomQuote ->
                        HOmeQuotesDC(
                            allQuotesList = allQuotesList,
                            randomQuote = randomQuote
                        )
                    }
                    .collect { data ->
                        quotesData.emit(
                            NetworkUIState.Success(data)
                        )
                    }

            } catch (e: Exception) {
                quotesData.emit(
                    NetworkUIState.Error("Internet")
                )
            }
        }
    }
}