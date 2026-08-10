package com.uvg.zancada.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Separador(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE6E6E6),
    grosor: Dp = 1.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(grosor)
            .background(color)
    )
}