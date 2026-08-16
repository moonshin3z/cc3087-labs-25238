# Walkthrough - Laboratorio 6: Estado y rotación en el feed

Interactive feed implementation with state management and lifecycle monitoring.

## Changes Made

### 1. Data Model Refactoring
- [Article.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/model/Articulo.kt) renamed model and properties to English.
- Added `isAuthorFollowed` and `isFeatured` flags for filtering.
- Updated [ArticulosDeEjemplo.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/data/ArticulosDeEjemplo.kt) with expanded sample data.

### 2. Interactive Components
- **Tabs:** [FilaPestanas.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/ui/components/FilaPestanas.kt) now handles clicks and reports selection.
- **Feed Logic:** [FeedScreen.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/ui/screens/FeedScreen.kt) implements:
    - Search field (title/author).
    - "Short reads" toggle (<= 5 min).
    - "Aplaudir" button with saved counter.
    - Derived filtering logic (no duplicate mutable lists).
    - Empty state message.

### 3. Lifecycle Monitoring
- [MainActivity.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/MainActivity.kt) overrides lifecycle callbacks (`onCreate` through `onDestroy`) with `Log.d` using tag `LAB6_LOGS`.

## Verification Results

### Build
- Successfully compiled using `gradle assembleDebug`.

### Manual Testing Protocol (Recommended)
1.  **Interact:** Change tabs, type "ana" in search, toggle "Short reads", and click "Aplaudir".
2.  **Rotate:** Verify all these values stay exactly as they were.
3.  **Logcat:** Filter by `LAB6_LOGS` to see the `Activity` being destroyed and recreated during rotation, while the `FeedScreen` recomposes with the saved state.
