package com.quotes.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quotes.domain.models.HOmeQuotesDC
import com.quotes.network.NetworkUIState
import com.quotes.presentation.components.AppProgressBar
import com.quotes.presentation.components.ToolBarComponent
import com.quotes.presentation.screens.homeScreen.components.HomeBody

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onclick: (id: String) -> Unit = {}, homeVM: HomeVM = hiltViewModel()
) {
    val state = homeVM.quotesData.collectAsStateWithLifecycle().value

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        ToolBarComponent(title = "Home")
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {

            when (state) {
                is NetworkUIState.Loading -> {
                    AppProgressBar()
                }

                is NetworkUIState.Success<HOmeQuotesDC> -> {
                    HomeBody(onclick = {
                        onclick(it)

                    }, hOmeQuotesDC = state.data)
                }

                is NetworkUIState.Error -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "No internet",
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
