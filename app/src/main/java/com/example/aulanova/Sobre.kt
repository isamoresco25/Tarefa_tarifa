package com.example.aulanova

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Sobre() {
    Column() {
        Text(text = "Sobre")
        Text(
            text = stringResource(id = R.string.sobre),
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
        )
    }
}