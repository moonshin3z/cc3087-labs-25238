package com.uvg.zancada.data
import com.uvg.zancada.model.Article

val exampleArticles: List<Article> = listOf(
    Article(
        author = "Abigail Vivar",
        title = "El kilómetro 15 no es problema de piernas",
        excerpt = "Por qué el ritmo cae antes de que se acabe el glucógeno.",
        readingMinutes = 7,
        date = "14 feb",
        isAuthorFollowed = true,
        isFeatured = false
    ),
    Article(
        author = "Andrés Joachin",
        title = "Subir volumen sin coleccionar lesiones",
        excerpt = "La regla del 10% funciona hasta que deja de funcionar.",
        readingMinutes = 6,
        date = "9 feb",
        isAuthorFollowed = false,
        isFeatured = true
    ),
    Article(
        author = "Marcela Herrera",
        title = "Lo que el tenis de mesa le enseña al resto",
        excerpt = "Un deporte donde la decisión llega antes que la vista.",
        readingMinutes = 4,
        date = "2 feb",
        isAuthorFollowed = true,
        isFeatured = true
    ),
    Article(
        author = "Ana Robles",
        title = "Por qué su primera app se siente lenta",
        excerpt = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde.",
        readingMinutes = 5,
        date = "12 dic",
        isAuthorFollowed = true,
        isFeatured = false
    ),
    Article(
        author = "Diego Marroquín",
        title = "El error de medir productividad",
        excerpt = "Líneas de código y horas pomodoro: la trampa del output vs outcome.",
        readingMinutes = 8,
        date = "8 min",
        isAuthorFollowed = false,
        isFeatured = false
    ),
    Article(
        author = "Sofía René",
        title = "Leí la documentación completa",
        excerpt = "Lo que descubrí sobre las APIs que todos ignoramos por inercia.",
        readingMinutes = 4,
        date = "4 min",
        isAuthorFollowed = false,
        isFeatured = true
    )
)
