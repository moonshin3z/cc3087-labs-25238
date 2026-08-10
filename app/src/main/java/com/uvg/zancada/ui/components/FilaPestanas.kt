package com.uvg.zancada.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilaPestanas(
    pestanas: List<String>,
    indiceActivo: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        pestanas.forEachIndexed { indice, pestana ->
            val activa = indice == indiceActivo
            Text(
                text = pestana,
                fontSize = 14.sp,
                fontWeight = if (activa) FontWeight.Bold else FontWeight.Normal,
                color = if (activa) Color(0xFF242424) else Color(0xFF9A9A9A)
            )
        }
    }
}