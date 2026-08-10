# cc3087-labs-25238 - Iván Roblero 


## Laboratorio 5 — Primera pantalla en Jetpack Compose

Feed estático de artículos de la publicación **Zancada**, sobre deporte y salud.
La pantalla no responde al toque todavía: no tiene estado ni navegación.

### Estructura

- `model/` — `Articulo`, la entidad del dominio. No conoce colores ni tamaños.
- `data/` — `articulosDeEjemplo`, la `List<Articulo>` escrita a mano.
- `ui/components/` — `BarraSuperior`, `FilaPestanas`, `Separador`, `ArticuloItem`.
  Un archivo por componente; todos reciben sus datos por parámetro y un
  `modifier: Modifier = Modifier` aplicado a su contenedor más externo.
- `ui/screens/` — `FeedScreen`, la única pantalla. Ordena los componentes y
  recorre la lista de artículos.
- `MainActivity.kt` — solo arranca la aplicación y llama a `FeedScreen`.

### Cómo ver la pantalla

Abrir `ui/screens/FeedScreen.kt` en modo Split. El `@Preview` de
`FeedScreenPreview` renderiza la pantalla completa sin necesidad de emulador.

## Uso de IA

Usé Claude (Anthropic) para discutir la arquitectura de paquetes, el diseño de
las firmas de los componentes y dónde ubicar los colores de presentación,
antes de escribir el código. La implementación, el contenido de la publicación
y las pruebas en Android Studio son propias.

Anthropic. (2026). *Claude* [modelo de lenguaje grande]. https://claude.ai
