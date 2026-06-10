# TriviaQuiz — Icône d'application (« ? » Vitamine)

Icône retenue : **le point d'interrogation blanc + point doré** sur le dégradé violet de la marque
(`#8B6CFF → #7A5AF8 → #553BD0`). Ce dossier contient tous les fichiers prêts à intégrer, pour **Android** et **iOS**.

> ✅ **Déjà intégré au projet (juin 2026).** Les fichiers `android/res/` et `ios/AppIcon.appiconset/` ont été
> copiés dans `androidApp/src/main/res/` et `iosApp/iosApp/Assets.xcassets/AppIcon.appiconset/`, puis **retirés
> d'ici** (redondants). Restent ici, pour référence : ce README + `android/play-store-icon-512.png` (à téléverser
> sur la Play Console) + `ios/AppIcon-1024.png`. Les sections ci-dessous documentent le pack d'origine.

---

## 📁 Contenu

```
icon_pack/
├─ android/
│  ├─ res/
│  │  ├─ mipmap-mdpi … mipmap-xxxhdpi/
│  │  │     ic_launcher.png            ← icône legacy (squircle), 48→192 px
│  │  │     ic_launcher_round.png      ← icône legacy ronde
│  │  │     ic_launcher_foreground.png ← calque AVANT (glyphe, transparent), 108→432 px
│  │  │     ic_launcher_background.png  ← calque ARRIÈRE (dégradé)
│  │  └─ mipmap-anydpi-v26/
│  │        ic_launcher.xml            ← icône adaptative (API 26+)
│  │        ic_launcher_round.xml
│  └─ play-store-icon-512.png          ← à téléverser sur le Play Console
└─ ios/
   ├─ AppIcon.appiconset/             ← glisser-déposer dans Xcode (Assets)
   │     Contents.json + icon-*.png   (toutes les tailles iPhone/iPad/marketing)
   └─ AppIcon-1024.png                ← version 1024 simple (SwiftUI / usage rapide)
```

---

## 🤖 Android — intégration

1. **Copie** le contenu de `android/res/` dans le `res/` de ton module app
   (`app/src/main/res/`). Les dossiers `mipmap-*` se fusionnent avec les tiens
   — remplace les `ic_launcher*` existants.
2. Vérifie dans `AndroidManifest.xml` que l'`<application>` pointe bien dessus
3. **Supprime** l'ancienne icône par défaut si elle traîne ailleurs
   (`mipmap-anydpi-v26/ic_launcher.xml` généré par Android Studio avec le robot vert,
   et un éventuel `ic_launcher_background.xml`/`.png` de couleur unie).
4. Build → l'icône adaptative s'affiche (forme suivant le launcher : ronde, squircle…).

> **Icône adaptative** : le système combine `ic_launcher_foreground` (le « ? ») et
> `ic_launcher_background` (le dégradé), puis applique le masque du téléphone. Le glyphe est
> volontairement dans la **zone de sécurité** (66 % central) pour ne jamais être rogné.
> Les `ic_launcher.png` / `_round.png` servent de repli sur Android < 8.0.

---

## 🍎 iOS — intégration

1. Dans Xcode, ouvre **`Assets.xcassets`**.
2. **Supprime** l'`AppIcon` existant, puis **glisse** le dossier `AppIcon.appiconset/`
   (fourni) à la place — il contient le `Contents.json` et toutes les tailles.
   *(Ou : sélectionne l'AppIcon et glisse chaque PNG dans son emplacement.)*
3. Vérifie *Target → General → App Icons and Launch Screen → App Icon = AppIcon*.
4. Build. iOS applique lui-même les coins arrondis — les images sont **pleines, sans
   transparence** (requis par l'App Store).

> Si tu es sur Xcode 14+ avec « Single Size », tu peux te contenter de `AppIcon-1024.png`
> glissé sur l'unique emplacement 1024.

---

## 🎨 Spécifications (pour régénérer si besoin)

| | Valeur |
|---|---|
| Fond | dégradé linéaire 150°, `#8B6CFF` → `#7A5AF8` (46 %) → `#553BD0` + halo blanc haut-gauche |
| Glyphe | « ? » blanc `#FFFFFF`, trait épais arrondi |
| Accent | point doré `#F5B716` (le point du « ? ») |
| Rayon (legacy/Play) | squircle ≈ 22,5 % |
| Zone de sécurité (adaptive fg) | glyphe dans le cercle central de 66 % |

Couleurs issues du système « Vitamine » (`brand #7A5AF8`, `brandDeep #553BD0`, or `#F5B716`).
Une **maquette comparative des 5 propositions** reste disponible dans `icon_explore/Icône TriviaQuiz.html`.
