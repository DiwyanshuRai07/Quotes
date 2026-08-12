package com.quotes.presentation.screens.homeScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeadingTitle(
    title: String? = ""
) {
    Text(
        text = title ?: "", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

}


@Preview(showBackground = true)
@Composable
fun HeadingTitlePreview() {
    HeadingTitle(title = "Random Quote")
}