package com.uvg.zancada.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Box
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

@Composable
fun BarraSuperior(
    nombrePublicacion: String,
    modifier: Modifier = Modifier,
    colorLogo: Color = Color(0xFF242424),
    colorPerfil: Color = Color(0xFF2E7D6B)
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(colorLogo),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = nombrePublicacion.take(1).uppercase(),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = nombrePublicacion,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Escribir",
                fontSize = 14.sp,
                color = Color(0xFF6B6B6B)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(colorPerfil)
            )
        }
    }
}