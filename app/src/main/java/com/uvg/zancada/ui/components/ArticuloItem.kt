package com.uvg.zancada.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.zancada.model.Articulo

@Composable
fun ArticuloItem(
    articulo: Articulo,
    colorAvatar: Color,
    colorMiniatura: Color,
    modifier: Modifier = Modifier
) {
    // Row 1: el articulo completo, texto a la izquierda y miniatura a la derecha
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier.weight(1f)) {

            // Row 2: el autor
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(colorAvatar)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = articulo.autor,
                    fontSize = 12.sp,
                    color = Color(0xFF4A4A4A)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = articulo.titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF242424)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = articulo.extracto,
                fontSize = 14.sp,
                color = Color(0xFF6B6B6B)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Row 3: la metadata
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "${articulo.minutosLectura} min de lectura",
                    fontSize = 12.sp,
                    color = Color(0xFF9A9A9A)
                )
                Text(text = "·", fontSize = 12.sp, color = Color(0xFF9A9A9A))
                Text(
                    text = articulo.fecha,
                    fontSize = 12.sp,
                    color = Color(0xFF9A9A9A)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(colorMiniatura)
        )
    }
}