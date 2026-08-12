package com.quotes.presentation.screens.detailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.domain.models.AllQuotesDC
import com.quotes.domain.usecase.GetSingleQuoteUseCase
import com.quotes.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(
    saveStateHandle: SavedStateHandle,
    private val getSingleQuoteUseCase: GetSingleQuoteUseCase
) : ViewModel() {

    var singleQupte = MutableStateFlow<NetworkUIState<AllQuotesDC.Quote?>>(NetworkUIState.Loading)
        private set

    init {
        getSingleQuote(saveStateHandle.get<String>("id") ?: "")
    }

    private fun getSingleQuote(id: String) {
        singleQupte.tryEmit(NetworkUIState.Loading)
        getSingleQuoteUseCase(id = id).onEach {
            singleQupte.tryEmit(NetworkUIState.Success(it))
        }.launchIn(viewModelScope)
    }
}