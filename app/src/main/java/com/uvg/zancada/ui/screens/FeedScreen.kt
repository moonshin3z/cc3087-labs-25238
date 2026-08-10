/*
 * Quita el weight de la columna del artículo, observa el @Preview y describe qué le pasó a la pantalla y por qué. Deja el código final con el weight puesto.
 * 1. Al quitar el weight del Column, este pide el ancho que necesita su
 *    contenido y los titulos dejan de partirse en dos lineas. Como el Row
 *    mide a sus hijos en orden y el Column va primero, se lleva la mayor parte del espacio que hay disponible en la pagina hasta donde quepa el texto.
 *    y a la miniatura solo le queda la sobra y se ve como una tira muy delgada o incluso puede llegar a desaparecer cuando el titulo es más largo.
 *    Osea que size(80.dp) no garantiza el tamano por si solo: el weight es lo que obliga al Row a atender primero a los hijos de tamano fijo y repartir
 *    lo que sobra despues.
 *
 * 2. ¿Por qué tu componente de artículo recibe un Modifier por parámetro en lugar de fijar su propio margen adentro? Responde pensando en qué pasaría si el mismo componente se usara en dos pantallas con espaciados distintos.
 *    El componente recibe un Modifier por parametro para que el espacio a su alrededor lo decida quien lo coloca. Si el margen estuviera fijo adentro,
 *    usar el mismo ArticuloItem en otra pantalla con espaciado distinto obligaria a editarlo o a duplicarlo. Con el Modifier afuera, el mismo
 *    archivo sirve en las dos sin tocarlo — igual que ya pasa con Separador,
 *    que aqui se usa  t odo el espacio de la pantalla y el padding que se usa a los lados
 */
package com.uvg.zancada.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.zancada.data.articulosDeEjemplo
import com.uvg.zancada.model.Articulo
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
    articulos: List<Articulo>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BarraSuperior(
            nombrePublicacion = "Zancada",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        FilaPestanas(
            pestanas = listOf("Para ti", "Siguiendo", "Destacados"),
            indiceActivo = 0,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
        )

        Separador()

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            articulos.forEachIndexed { indice, articulo ->
                val (colorAvatar, colorMiniatura) = paletaDeArticulos[indice % paletaDeArticulos.size]

                ArticuloItem(
                    articulo = articulo,
                    colorAvatar = colorAvatar,
                    colorMiniatura = colorMiniatura,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                if (indice < articulos.lastIndex) {
                    Separador()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen(articulos = articulosDeEjemplo)
}