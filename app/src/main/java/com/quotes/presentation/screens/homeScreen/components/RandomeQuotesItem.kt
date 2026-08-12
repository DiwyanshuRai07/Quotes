package com.quotes.presentation.screens.homeScreen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.quotes.domain.models.AllQuotesDC

@Composable
fun RandomQuotesItem(
    quotesDC: AllQuotesDC.Quote
){
    QuotesItem(
        quotesDC = quotesDC,
        color  = Color.Red,
        textColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
private fun RandomQuotesItemsPreview() {
    RandomQuotesItem(quotesDC =  AllQuotesDC.Quote())
}