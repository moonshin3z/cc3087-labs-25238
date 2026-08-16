package com.uvg.zancada.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.zancada.data.exampleArticles
import com.uvg.zancada.model.Article
import com.uvg.zancada.ui.components.ArticuloItem
import com.uvg.zancada.ui.components.BarraSuperior
import com.uvg.zancada.ui.components.FilaPestanas
import com.uvg.zancada.ui.components.Separador

private val paletaDeArticulos = listOf(
    Color(0xFF2E7D6B) to Color(0xFFCFE0D8),
    Color(0xFFB4553C) to Color(0xFFE8D3C4),
    Color(0xFF4A6FA5) to Color(0xFFD5DCE8)
)

@Composable
fun FeedScreen(
    articulos: List<Article>,
    modifier: Modifier = Modifier
) {
    // 1. Estados controlados con rememberSaveable para sobrevivir a la rotación
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }
    var selectedTab by rememberSaveable { mutableStateOf("Para ti") }
    
    // El contador de aplausos es el único estado que varía entre experimentos A, B y C.
    // Usamos Prueba C: rememberSaveable para que se conserve al rotar.
    var applauseCount by rememberSaveable { mutableStateOf(0) }

    // 2. Lista filtrada derivada (val calculado, no otro estado mutable)
    val filteredArticles = articulos.filter { article ->
        val matchesTab = when (selectedTab) {
            "Siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        val matchesSearch = article.title.contains(searchQuery, ignoreCase = true) ||
                article.author.contains(searchQuery, ignoreCase = true)
        val matchesShortRead = if (showShortReadsOnly) article.readingMinutes <= 5 else true

        matchesTab && matchesSearch && matchesShortRead
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BarraSuperior(
            nombrePublicacion = "Lecturas",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        FilaPestanas(
            pestanas = listOf("Para ti", "Siguiendo", "Destacados"),
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )

        Separador()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Campo de búsqueda
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar por título o autor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Filtro de lecturas cortas y botón de aplaudir
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Switch(
                        checked = showShortReadsOnly,
                        onCheckedChange = { showShortReadsOnly = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Solo lecturas cortas", fontSize = 14.sp)
                }

                TextButton(onClick = { applauseCount++ }) {
                    Text(text = "Aplaudir · $applauseCount")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            
            // Cantidad de resultados
            Text(
                text = "${filteredArticles.size} resultados",
                fontSize = 12.sp,
                color = Color(0xFF4A6FA5),
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (filteredArticles.isEmpty()) {
                // Estado vacío
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "No se encontraron artículos",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    Text(
                        text = "Cambia la pestaña, la búsqueda o el filtro.",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }
            } else {
                filteredArticles.forEachIndexed { indice, articulo ->
                    val (colorAvatar, colorMiniatura) = paletaDeArticulos[indice % paletaDeArticulos.size]

                    ArticuloItem(
                        articulo = articulo,
                        colorAvatar = colorAvatar,
                        colorMiniatura = colorMiniatura,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    if (indice < filteredArticles.lastIndex) {
                        Separador()
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen(articulos = exampleArticles)
}
