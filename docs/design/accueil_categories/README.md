# Handoff — Écrans Accueil & Catégories (refonte « Vitamine »)

## À propos de ces fichiers
Les fichiers de `reference/` sont des **maquettes de design écrites en HTML/React** (prototype), **pas du code à copier**.
Objectif : **recréer ces deux écrans en Compose Multiplatform** dans le code existant (`commonMain`), avec les
patterns déjà en place (Material3, `Category` enum, navigation par callbacks). Fidélité : **haute** (hi-fi) — couleurs,
typo, tailles et rayons sont définitifs.

> Les fondations communes (palette par catégorie, typo Baloo 2 / Nunito, bouton « chunky », anneau de progression,
> confettis, etc.) sont **déjà documentées** dans `Notes Compose.html` à la racine du projet design. **Ce document ne
> ré-explique pas ces recettes** — il décrit précisément les **deux écrans** et le **système de niveau** qui s'y rattache.

## Où ça s'insère dans ton code
| Écran | Fichier cible | État actuel |
|---|---|---|
| Accueil | `ui/home/HomeScreen.kt` | placeholder (titre + 3 boutons) → à remplacer |
| Catégories | `ui/category/CategoryScreen.kt` | grille basique 2 col. → à restyler |
| Tokens couleur | `ui/theme/Color.kt` | ajouter `CatColors` + palette neutre (cf. Notes Compose §1) |
| Typo | `ui/theme/Type.kt` | ajouter Baloo 2 + Nunito (cf. Notes Compose §2) |
| Données niveau | `state.categoryRatings` **(existe déjà)** + `ui/theme/Rank.kt` (nouveau, voir §2) | brancher, ne pas recréer |

L'enum existant `Category` (`data/Question.kt`) correspond 1:1 aux 6 catégories du design :
`GEOGRAPHIE, HISTOIRE, SCIENCES_ET_NATURE, ART_ET_CULTURE, SPORTS, DIVERTISSEMENT` (libellés via `Category.displayName`).

---

## 1. Design tokens

### Palette neutre (surfaces & texte)
| Token | Hex | Usage |
|---|---|---|
| `bg` | `#FBF7F2` | fond d'écran (crème chaud) |
| `card` | `#FFFFFF` | cartes / pastilles |
| `ink` | `#1E1B2E` | texte principal |
| `inkSoft` | `#6B6680` | texte secondaire |
| `inkFaint` | `#A7A2B6` | texte tertiaire |
| `line` | `#ECE6F0` | filets |
| `good` / `goodTint` | `#1FA84B` / `#D5F2DD` | succès |
| `bad` / `badTint` | `#EF4444` / `#FBE0E0` | erreur |
| `gold` | `#F5B716` | série, couronne, rating |
| `brand` / `brandDeep` | `#7A5AF8` / `#553BD0` | accent produit (violet) |

### Couleurs par catégorie — `main / deep / tint`
| Category | main | deep | tint | icône (path) |
|---|---|---|---|---|
| GEOGRAPHIE | `#0FA697` | `#0A6F63` | `#D6F4EF` | globe |
| HISTOIRE | `#E5890F` | `#9C5A05` | `#FBEBCF` | column |
| SCIENCES_ET_NATURE | `#7A5AF8` | `#553BD0` | `#E7E1FF` | flask |
| ART_ET_CULTURE | `#EC4899` | `#C42B73` | `#FBDFEC` | palette |
| SPORTS | `#1FA84B` | `#157A36` | `#D5F2DD` | trophy |
| DIVERTISSEMENT | `#3B82F6` | `#1D5FD8` | `#DCE9FF` | film |

> `main` = teinte vive (fond carte) · `deep` = ombre 3D + texte sur clair · `tint` = fond doux (pastille de niveau).
> Les `path` d'icônes (viewBox 24×24, stroke 2.2) sont dans `reference/tokens.js → ICONS`. À convertir en `ImageVector`
> ou en `drawable` vectoriel. Icônes utilisées ici : `globe, column, flask, palette, trophy, film, crown, flame, play, chevL, home, users, star`.

### Typo, rayons, ombres
- **Display** = Baloo 2 (titres, scores, libellés de bouton, niveaux) · **Body** = Nunito (texte courant).
- Rayons : cartes `22dp`, pastilles `14–16dp`, héros `26dp`, petits boutons `13dp`, pills `20dp`.
- **Ombre « chunky 3D »** (signature) : une tranche pleine `deep` décalée vers le bas + une ombre douce diffuse.
  En CSS : `box-shadow: 0 7px 0 <deep>, 0 14px 24px <main>44`. En Compose → `drawBehind` (cf. Notes Compose §3,
  `ChunkyButton`). `44` = alpha hex ≈ 27%.

---

## 2. Système de NIVEAU par catégorie

> ⚠️ **La donnée existe déjà.** Le `GameViewModel` expose `state.categoryRatings: Map<Category, Int>` et
> `state.playerRating` (cf. `App.kt`, déjà passés à `ProfileScreen`). **Ne recrée pas** de source de rating — branche
> les écrans sur ce map. Il manque seulement l'échelle de rang partagée + les seuils des blocs de l'accueil.

```kotlin
// ui/theme/Rank.kt (à créer)
const val SIGNUP_RATING = 750            // niveau attribué à chaque catégorie à l'inscription

enum class Rank(val min: Int, val label: String) {
    NOVICE(800, "Novice"), APPRENTI(1000, "Apprenti"), CONFIRME(1200, "Confirmé"),
    EXPERT(1400, "Expert"), MAITRE(1600, "Maître");
    companion object { fun of(rating: Int) = entries.lastOrNull { rating >= it.min } ?: NOVICE }
}

// Seuils des blocs de l'Accueil (AJUSTABLES — ce sont mes valeurs par défaut)
const val STRENGTH_MIN = 1200            // « Tes points forts » : catégories au rating >= ce seuil
const val WEAKNESS_MAX = 1000            // « Tes axes d'amélioration » : catégories au rating <= ce seuil

fun Map<Category,Int>.strengths()  = entries.filter { it.value >= STRENGTH_MIN }.sortedByDescending { it.value }.take(3)
fun Map<Category,Int>.weaknesses() = entries.filter { it.value <= WEAKNESS_MAX }.sortedBy { it.value }.take(3)
```

- À l'inscription, **toutes** les catégories valent `SIGNUP_RATING = 750` (donc < Novice, et ≤ WEAKNESS_MAX → elles
  apparaissent d'abord dans « axes d'amélioration » tant qu'elles n'ont pas dépassé 1000).
- **Chaque bloc se masque** si aucune catégorie ne franchit son seuil (`if (strengths.isNotEmpty()) { … }`).
- Le **libellé de niveau** affiché partout (Accueil + carte Catégories) vient de `Rank.of(rating).label`.
- Valeurs de démo dans la maquette : GEO 1280 · HIST 1450 · SCI 1180 · ART 820 · SPORT 760 · FUN 1240.

---

## 3. Écran ACCUEIL — `HomeScreen.kt`

Conteneur : `Column`, fond `bg`, padding ~`14dp/18dp`. De haut en bas :

**a) En-tête joueur** (`Row`, space-between)
- Avatar `46dp` carré arrondi `16dp`, dégradé 135° `#7A5AF8→#EC4899`, initiale blanche Display 20.
- Colonne : salutation Body 13 `inkSoft` = **« Bonjour, » si heure < 17h, sinon « Bonsoir, »** ; prénom Display 19.
- À droite : pill blanche (icône `flame` `gold` + nombre de série Display 17), ombre douce.

**b) Carte « Niveau actuel » (héros)** — rayon `26dp`, dégradé 140° `#231C46 → #3A2A7A(55%) → #5B3FD6`.
- `Row` : à gauche **anneau** `84dp` (stroke 8, fraction = progression vers le rang suivant, couleur `gold`, track
  `#ffffff24`) avec icône `crown` dorée au centre.
- Colonne droite : sur-titre **« NIVEAU ACTUEL »** (uppercase, 12, `#C9BEFF`, letterSpacing 1.2) ; nom du rang Display 26
  blanc ; ligne rating = valeur `gold` Display 22 + `« pts · <N> pour <rang suivant> »` Body 12 `#C9BEFF`.
- Détail déco : 2 cercles `#ffffff12 / #ffffff0d` en débord (facultatif).

**c) CTA principal « Jouer »** — bouton pleine largeur, rayon `22dp`, padding `16dp/20dp`, dégradé 135° `#7A5AF8→#9168FF`,
ombre chunky `0 8px 0 #553BD0, 0 16px 30px #7A5AF855`. Titre Display 22 **« Jouer »**, sous-titre Body 13 « Solo · toutes
catégories ». À droite cercle `46dp` `#ffffff2e` avec icône `play`. → `onStartAllCategories()`.

**d) Bouton « Jouer une catégorie »** (noir) — **même forme** que l'ancien bouton « Toutes les catégories », **fond noir**,
**même hauteur que le CTA Jouer** (padding `16dp/20dp`, rayon `22dp`). Fond `#161320`, ombre `0 8px 0 #000, 0 16px 30px #00000055`.
- À gauche : **6 jetons** colorés (un par catégorie) qui se chevauchent — chaque jeton `16×34dp`, rayon `5dp`, bordure
  `2dp #ffffff55`, `marginLeft -7dp` (offset négatif).
- Centre : titre Display 20 **« Jouer une catégorie »**, sous-titre Body 13 (opacité .82) **« Au choix parmi 6 »**.
- Droite : cercle `46dp` `#ffffff2e` + `play`. → `onChooseCategory()`.

**e) « Tes points forts »** (afficher seulement si `strengths().isNotEmpty()`)
- Titre de section Display 15 `ink`.
- `Row` de **max 3** colonnes (les 3 meilleures catégories, rating ≥ `STRENGTH_MIN`). Chaque colonne :
  pastille catégorie `48dp` rayon `15dp` (fond `main`, icône blanche, ombre `0 6px 14px main44`) + nom court Body 11
  `ink` + **pill de niveau** (fond `tint`, icône `crown` couleur `deep`, libellé `Rank.of(rating).label` Body 10 `deep`).

**f) « Tes axes d'amélioration »** (afficher seulement si `weaknesses().isNotEmpty()`)
- Même structure que (e), mais catégories avec rating ≤ `WEAKNESS_MAX`, triées **croissant**, max 3.

**g) Barre de navigation basse** : Accueil · Multijoueur · Profil (le multijoueur vit **uniquement** ici, plus de bouton
sur l'accueil).

> Largeur de référence 412dp. La colonne peut être `verticalScroll` si le contenu dépasse selon la hauteur d'écran.

---

## 4. Écran CATÉGORIES — `CategoryScreen.kt`

- **En-tête** (`Row`) : bouton retour `40dp` carré arrondi `13dp` blanc + `chevL` ; colonne titre Display 22
  **« Choisis un thème »** + sous-titre Body 13 `inkFaint` « Sur quoi veux-tu briller ? ». → bouton retour = `onGoBack()`.
- **Grille 2 colonnes**, gap `13dp`, padding `12dp/18dp` (`LazyVerticalGrid` ou `Column`+`Row`).
- **Le bouton « Toutes les catégories » a été retiré** (il vit désormais sur l'Accueil = bouton noir « Jouer une catégorie »).
- **Carte catégorie** (× 6) : rayon `22dp`, padding `16dp/15dp`, fond `main`, texte blanc, `minHeight 128dp`,
  ombre chunky `0 7px 0 deep, 0 14px 24px main44`, layout `Column` space-between :
  - haut : tuile icône `46dp` rayon `14dp` `#ffffff2e` + icône catégorie blanche.
  - bas : nom complet Display 18 + pill `#ffffff2e` (icône `crown` blanche + `Rank.of(rating).label` Body 11).
  - → `onSelectCategory(category)`.

---

## 5. Comment travailler avec Claude Code (workflow conseillé)

1. **Dépose ce dossier** `design_handoff_accueil_categories/` à la racine de ton repo Android Studio (ou colle juste
   `README.md`). Garde aussi `Notes Compose.html` accessible (les recettes d'animation/thème y sont).
2. Ouvre **Claude Code** dans le projet et commence par les **fondations** :
   « Lis `design_handoff_accueil_categories/README.md` et `Notes Compose.html`. Implémente d'abord §1–2 du Notes
   (palette `CatColors`, typo Baloo 2 / Nunito) dans `ui/theme/`. »
3. Puis **un écran à la fois** :
   « Réécris `ui/home/HomeScreen.kt` selon la section 3 du handoff. Réutilise `ChunkyButton` (Notes §3). »
   puis « Restyle `ui/category/CategoryScreen.kt` selon la section 4, et retire le bouton ‹ Toutes les catégories ›. »
4. **Système de niveau** : « Crée `data/CategoryRating.kt` selon la section 2, branche-le sur le `ViewModel` qui
   alimente l'accueil ; pour l'instant, des valeurs de démo suffisent. »
5. Itère écran par écran en comparant au prototype (`reference/screens-a.jsx` ou l'aperçu live).

**Ordre d'intégration** : ① thème + typo · ② Accueil · ③ Catégories · ④ système de niveau (données réelles).

## Fichiers de référence
- `reference/tokens.js` — palette, catégories, échelle de rang, paths d'icônes (source de vérité des tokens).
- `reference/screens-a.jsx` — code React des écrans Accueil + Catégories (structure & valeurs exactes).
- `reference/atoms.jsx` — composants partagés (`CatBadge`, `Ring`, `BottomNav`, `Icon`).
- Aperçu interactif : les artboards **1 · Accueil** et **2 · Catégories** de `TriviaQuiz Concepts.html`.
- Recettes Compose (thème, animations, multijoueur) : `Notes Compose.html`.
