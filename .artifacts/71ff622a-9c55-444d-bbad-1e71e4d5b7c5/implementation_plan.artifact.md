# Implementation Plan - Laboratorio 6: Estado y rotación en el feed

This plan covers the transition of a static feed into an interactive one that handles state, filtering, and configuration changes (rotation).

## User Review Required

> [!IMPORTANT]
> The `applauseCount` will be implemented using `rememberSaveable` as the final solution, but the lab mentions intermediate checkpoints for different declaration methods. I will provide the final code, assuming you've noted the differences for your report.

## Proposed Changes

### 1. Data Model and Sample Data

Refactor the model to English identifiers and add properties for filtering.

#### [MODIFY] [Articulo.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/model/Articulo.kt)
- Rename `Articulo` class to `Article`.
- Rename properties: `autor` -> `author`, `titulo` -> `title`, `extracto` -> `excerpt`, `minutosLectura` -> `readingMinutes`, `fecha` -> `date`.
- Add `isAuthorFollowed: Boolean` and `isFeatured: Boolean`.

#### [MODIFY] [ArticulosDeEjemplo.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/data/ArticulosDeEjemplo.kt)
- Update to use `Article`.
- Ensure at least one `true` and one `false` value for `isAuthorFollowed` and `isFeatured`.

---

### 2. UI Components

Update existing components to match the new model and requirements.

#### [MODIFY] [ArticuloItem.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/ui/components/ArticuloItem.kt)
- Update property references to English.

#### [MODIFY] [FilaPestanas.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/ui/components/FilaPestanas.kt)
- Update signature to accept `selectedTab: String` and `onTabSelected: (String) -> Unit`.

---

### 3. Screen Logic

Implement state management and filtering.

#### [MODIFY] [FeedScreen.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/ui/screens/FeedScreen.kt)
- Add state variables using `rememberSaveable`:
    - `searchQuery: String`
    - `showShortReads: Boolean`
    - `selectedTab: String`
    - `applauseCount: Int`
- Add UI controls:
    - `OutlinedTextField` for search.
    - `Switch` for short reads.
    - `TextButton` for applause and display `applauseCount`.
- Implement derived list filtering:
    - Filter by `selectedTab` ("Para ti", "Siguiendo", "Destacados").
    - Filter by `searchQuery` (case-insensitive title or author).
    - Filter by `showShortReads` (readingMinutes <= 5).
- Handle empty state with a message.

---

### 4. Lifecycle Monitoring

#### [MODIFY] [MainActivity.kt](file:///C:/Users/josue/AndroidStudioProjects/Zancada/app/src/main/java/com/uvg/zancada/MainActivity.kt)
- Override `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`.
- Add `Log.d` calls in all callbacks (including `onCreate`) with a specific tag (e.g., `LAB6_LOGS`).

## Verification Plan

### Automated Tests
- Build and run the app to ensure no compilation errors.

### Manual Verification
1.  **Search:** Type "ana" and verify it filters by "Ana Robles".
2.  **Tabs:** Switch between tabs and verify content changes based on `isAuthorFollowed` and `isFeatured`.
3.  **Switch:** Toggle "Short reads only" and verify only articles with <= 5 mins are shown.
4.  **Applause:** Click "Aplaudir" and verify the counter increases.
5.  **Rotation:** Change search, switch, tab, and applause count, then rotate device. Verify all values are preserved.
6.  **Logcat:** Verify lifecycle callbacks appear in order when opening, minimizing, and rotating the app.
