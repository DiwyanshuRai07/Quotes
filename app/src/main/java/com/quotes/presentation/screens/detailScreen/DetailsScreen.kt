package com.quotes.presentation.screens.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quotes.network.NetworkUIState
import com.quotes.presentation.components.AppProgressBar
import com.quotes.presentation.components.ToolBarComponent
import com.quotes.presentation.screens.detailScreen.components.DetailsQuote

@Composable
fun DetailsScreen(
    detailVM: DetailVM = hiltViewModel(),
    onBackPressed : () -> Unit = {}
) {


    val state =  detailVM.singleQupte.collectAsStateWithLifecycle().value
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolBarComponent(title = "Details", showBackButton = true,
                onBackPress = {
                    onBackPressed()
                })
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(paddingValues = innerPadding)
                .fillMaxSize()
                .background(color = Color.White)
        ) {

            when(state)
            {
                is NetworkUIState.Loading ->{
                    AppProgressBar()
                }

                is NetworkUIState.Success ->{
                    DetailsQuote(state.data)
                }

                is NetworkUIState.Error ->{

                }
            }


        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailsScreenPreview(){
    DetailsScreen()
}
