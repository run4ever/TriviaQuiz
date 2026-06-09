# Handoff — Écran « Mon profil » (maquette 7)

## Ce que c'est
La maquette **7 · Mon profil** est un écran de profil joueur : pseudo, **niveau global** et **niveau par catégorie**,
chaque tuile catégorie affichant en plus la **meilleure série** et la **date** à laquelle elle a été atteinte.
Réf. : artboard **7 · Mon profil** de `TriviaQuiz Concepts.html`, code dans `reference/screens-d.jsx`.
Objectif : **recréer cet écran en Compose Multiplatform** dans le code existant, fidélité **haute** (hi-fi).

> Pré-requis : avoir appliqué les **fondations** de `Notes Compose.html` (inclus dans ce dossier) — §1 couleurs par
> catégorie `CatColors`, §2 typo Baloo 2 / Nunito, §8 anneau `ProgressRing` — ainsi que l'échelle de rang `Rank`
> définie dans le **handoff Accueil** (`ui/theme/Rank.kt`). Ce document **ne ré-explique pas** ces recettes.

## Où ça s'insère
| Élément | Fichier cible | État actuel |
|---|---|---|
| Écran profil | `ui/profile/ProfileScreen.kt` | fonctionnel mais **style Material brut** → à restyler entièrement |
| Échelle de niveau | `ui/theme/Rank.kt` (handoff Accueil) | **remplacer** le `levelName()` local par `Rank.of()` (voir ⚠️ ci-dessous) |
| Données série/date | `GameState` / `ViewModel` | **manquantes** → décision produit (voir §4) |

Signature actuelle (à conserver, à enrichir au §4) :
```kotlin
fun ProfileScreen(
    modifier: Modifier = Modifier,
    playerRating: Int,                      // → niveau global
    categoryRatings: Map<Category, Int>,    // → niveau par catégorie (existe déjà)
    accountStatus: String,                  // → sert de "pseudo" affiché
    onOpenAccount: () -> Unit               // → tap sur la carte pseudo
)
```

> ⚠️ **Cohérence des rangs.** Le fichier actuel définit un `Int.levelName()` privé avec des seuils **différents**
> (Débutant/Amateur/Intermédiaire… à 500/800/1100…). **Supprime-le** et utilise partout `Rank.of(rating).label`
> (Novice 800 · Apprenti 1000 · Confirmé 1200 · Expert 1400 · Maître 1600), comme l'Accueil et l'écran de jeu.
> La progression de l'anneau global = fraction entre le seuil du rang courant et celui du rang suivant.

---

## 1. Anatomie de l'écran (haut → bas)

Largeur de référence **412dp**. Une `Column` plein écran, fond `bg #FBF7F2`. **Tout tient sans scroll** sur un
écran ~892dp ; si l'écran est plus court, la zone centrale peut devenir `verticalScroll`.

```
┌─────────────────────────────┐
│        Mon profil           │  en-tête centré
│  ┌───────────────────────┐  │
│  │ [F]  PSEUDO           >│  │  carte pseudo (blanche)
│  │      Fabien            │  │
│  └───────────────────────┘  │
│  ┌───────────────────────┐  │
│  │ (◔) NIVEAU GLOBAL      │  │  héros (dégradé violet foncé)
│  │     Apprenti           │  │
│  │     1141 pts · 59 …    │  │
│  │ ─────────────────────  │  │
│  │ 🔥 14 Meilleure série… │  │
│  └───────────────────────┘  │
│  Par catégorie              │
│  ┌─────────┐ ┌─────────┐    │  grille 2 col. (6 tuiles colorées)
│  │ Géo  …  │ │ Hist …  │    │
│  └─────────┘ └─────────┘    │
│        … (3 lignes) …       │
│  [ Accueil  Multi  Profil ] │  bottom nav (Profil actif)
└─────────────────────────────┘
```

**Conteneur de contenu** : padding `8dp` (haut) / `18dp` (côtés) / `12dp` (bas), `Arrangement.spacedBy(10.dp)`.

### a) En-tête
`Text` **« Mon profil »** centré horizontalement, **Baloo 2 ExtraBold ~21sp**, couleur `ink #1E1B2E`,
padding `6dp` haut / `18dp` côtés.

### b) Carte pseudo (cliquable → `onOpenAccount`)
`Card`/`Row` blanche, rayon `18dp`, padding `11dp/14dp`, ombre douce (`0 4px 14px #0000000a`), `gap 12dp`, `alignItems center` :
- **Avatar** `44dp` carré rayon `14dp`, **dégradé 135° `#7A5AF8 → #EC4899`**, initiale (1ʳᵉ lettre du pseudo) blanche **Baloo 2 ExtraBold 20sp**.
- Colonne : sur-titre **« PSEUDO »** (uppercase, **Nunito ExtraBold 10.5sp**, `inkFaint #A7A2B6`, letterSpacing .5) ;
  pseudo (= `accountStatus`) **Baloo 2 ExtraBold 18sp**, `ink`.
- À droite : chevron `chevR` `20dp`, `inkFaint`.

### c) Carte « Niveau global » (héros)
Rayon `22dp`, padding `13dp/18dp`, **dégradé 140° `#231C46 0% → #3A2A7A 52% → #5B3FD6 100%`**,
ombre `0 12px 26px #2a1f5a3a`. Cercle décoratif `#ffffff12` en débord coin haut-droit (facultatif).
- `Row` (gap 15) : **anneau** `66dp` (`ProgressRing` §8 Notes, stroke 8, fraction = progression vers rang suivant,
  couleur `gold #F5B716`, track `#ffffff24`) avec icône **`crown`** dorée `22dp` au centre — **statique** (pas d'anim ici).
- Colonne droite :
  - sur-titre **« NIVEAU GLOBAL »** uppercase, Nunito ExtraBold 10.5sp, `#C9BEFF`, letterSpacing 1.1.
  - nom du rang `Rank.of(playerRating).label` **Baloo 2 ExtraBold 24sp** blanc.
  - ligne rating (`alignBaseline`, gap 7) : `playerRating` **Baloo 2 ExtraBold 21sp `gold`** + `« pts · <N> pour <rang suivant> »`
    Nunito Bold 11.5sp `#C9BEFF` (`<N>` = points restants jusqu'au prochain rang ; si rang max → `« pts · rang max »`).
- **Pied** (séparateur `1dp #ffffff22`, marginTop 11 / paddingTop 10) — **une seule ligne, `nowrap`** :
  icône **`flame`** blanche 15 + meilleure série globale **Baloo 2 ExtraBold 14sp** blanc +
  **« Meilleure série le <date> »** Nunito Bold 11.5sp `#C9BEFF`. **Pas de coche.**

### d) Section « Par catégorie »
`Text` **« Par catégorie »** Baloo 2 ExtraBold 15sp `ink`. Puis **grille 2 colonnes**, gap `11dp`,
**lignes de hauteur égale** (`GridCells.Fixed(2)` ; les 3 lignes se partagent l'espace restant — `gridAutoRows: 1fr`).
6 tuiles, ordre de l'enum `Category`.

### e) Tuile catégorie (× 6) — voir §2

### f) Barre de navigation basse
`Accueil · Multijoueur · Profil`, onglet **Profil actif** (icône `star` + libellé en `brand #7A5AF8`).
Réutilise le `BottomNav` commun (cf. `reference/atoms.jsx`).

---

## 2. Tuile catégorie — `CategoryStatTile`

`Column`, fond **`cat.main`** (couleur vive de la catégorie), texte **blanc**, rayon `18dp`, padding `11dp/13dp`,
**ombre chunky** `0 5px 0 cat.deep, 0 10px 18px cat.main40` (recette §3 Notes ; `40` = alpha ≈ 25%).

1. **Ligne haute** (`Row` space-between) :
   - tuile icône `30dp` rayon `10dp`, fond `#ffffff2e`, **icône catégorie** blanche `17dp` (stroke 2.3).
   - **pill de rang** : fond `#ffffff2e`, padding `3dp/8dp`, rayon `20dp`, icône **`crown`** blanche `10dp` +
     `Rank.of(rating).label` Nunito ExtraBold **9.5sp** blanc.
2. **Nom complet** de la catégorie (`category.displayName`) **Baloo 2 ExtraBold 14.5sp**, marginTop 5.
3. **Ligne rating** (`alignBaseline`, gap 6, marginTop 1) : `rating` **Baloo 2 ExtraBold 22sp** + **« pts »** Nunito Bold 10.5sp `#ffffffcc`.
4. `Spacer(weight = 1f)` (pousse le pied en bas).
5. **Pied** (séparateur `1dp #ffffff2e`, marginTop 6 / paddingTop 7), **deux lignes** :
   - **Ligne 1** : **« Meilleure série : »** Nunito Bold **9.5sp** `#ffffffcc`.
   - **Ligne 2** (`Row`, `alignCenter`, gap 5, `nowrap`, marginTop 2) : icône **`flame`** blanche `13dp` +
     un texte **« <best>, le <date> »** où **`<best>`** est en **Baloo 2 ExtraBold 12.5sp blanc** et le reste
     (`« , le <date> »`) en **Nunito Bold 11sp blanc**.

> `rating = categoryRatings[category] ?: SIGNUP_RATING`. La couleur de tuile vient de `CatColors.getValue(category)`
> (`main` / `deep`), cf. Notes §1.

---

## 3. Format de date (mois FR abrégé)

Les dates s'affichent **« <jour> <mois> <année> »**, le mois **abrégé** (≤ 4 lettres + point quand abrégé) :

```kotlin
private val MONTHS_FR = listOf(
    "janv.", "févr.", "mars", "avril", "mai", "juin",
    "juil.", "août", "sept.", "oct.", "nov.", "déc."
)
// ex. LocalDate(2026, 6, 7) -> "7 juin 2026" ; (2026, 5, 28) -> "28 mai 2026"
fun formatStreakDate(d: LocalDate) = "${d.dayOfMonth} ${MONTHS_FR[d.monthNumber - 1]} ${d.year}"
```

Exemples rendus dans la maquette : `8 juin 2026` (global), `7 juin 2026`, `28 mai 2026`, `3 juin 2026`…

---

## 4. Données SÉRIE + DATE (décision produit)

> ⚠️ Le **niveau** (global et par catégorie) existe déjà (`playerRating`, `categoryRatings`). En revanche la
> **meilleure série** (longueur) et la **date** où elle a été atteinte **ne sont pas dans l'état actuel**.

Pour les afficher pour de vrai, ajoute un modèle, p. ex. :
```kotlin
data class BestStreak(val length: Int, val achievedOn: LocalDate)
// dans l'état exposé à ProfileScreen :
//   globalBestStreak: BestStreak
//   categoryBestStreaks: Map<Category, BestStreak>
```
- À alimenter par le `GameViewModel` (mémoriser la plus longue série de bonnes réponses + sa date, global et par catégorie).
- **kotlinx-datetime** (`LocalDate`) recommandé pour rester en `commonMain`.
- **Si tu ne veux pas encore brancher cette donnée** : passe des valeurs de démo (cf. `PROFILE` dans
  `reference/screens-d.jsx` : global série 14 le 8 juin 2026 ; GEO 9/7 juin, HIST 12/8 juin, SCI 8/5 juin,
  ART 7/2 juin, SPORT 6/28 mai, FUN 5/3 juin), **ou** masque le pied des tuiles + le pied du héros.

---

## 5. Tokens utilisés ici (rappel)
- Neutres : `bg #FBF7F2`, `ink #1E1B2E`, `inkFaint #A7A2B6`, `gold #F5B716`, `brand #7A5AF8`.
- Héros : dégradé `#231C46 / #3A2A7A / #5B3FD6`, texte d'appoint `#C9BEFF`, voiles `#ffffff12/22/24`.
- Avatar : dégradé `#7A5AF8 → #EC4899`.
- Tuiles : `CatColors[category].main / .deep`, voiles internes `#ffffff2e`, textes `#ffffffcc`.
- Icônes : `crown, flame, chevR, star` + les 6 icônes catégories (`globe, column, flask, palette, trophy, film`).
  Paths dans `reference/tokens.js → ICONS` (viewBox 24×24, stroke 2.2–2.3) → `ImageVector`/drawable vectoriel.
- Rayons : pseudo `18` · héros `22` · tuiles `18` · pills `20` · avatar/anneau interne `14/10`.
- Typo : **Display = Baloo 2**, **Body = Nunito** (cf. Notes §2).

---

## 6. Workflow Claude Code suggéré
1. « Lis `design_handoff_profil/README.md` + `Notes Compose.html`. Résume le restyle de `ProfileScreen.kt` sans coder. »
2. « Remplace le `levelName()` local par `Rank.of()` (`ui/theme/Rank.kt`) partout dans l'écran. »
3. « Restyle l'**en-tête + carte pseudo + héros** (§1) en gardant la signature et `onOpenAccount`. »
4. « Implémente la **tuile catégorie** `CategoryStatTile` (§2) avec l'ombre chunky (§3 Notes) et le format de date (§3). »
5. **Décision produit** : « Ajoute `BestStreak` (§4) au `ViewModel` » **ou** « utilise des valeurs de démo / masque le pied ».
6. « Branche le `BottomNav` (Profil actif). » Compile + compare à l'artboard 7 après chaque étape.

## Fichiers de référence
- `reference/screens-d.jsx` — code React de l'écran (structure, tailles, couleurs, format de date exacts).
- `reference/atoms.jsx` — composants partagés : `Ring` (anneau), `BottomNav`, `Icon`, `Screen`.
- `reference/tokens.js` — palette, catégories, échelle de rang, paths d'icônes.
- Aperçu interactif : artboard **7 · Mon profil** de `TriviaQuiz Concepts.html`.
- Recettes Compose (thème, typo, anneau, ombre chunky) : **`Notes Compose.html`** (inclus) — §1, §2, §3, §8.
- Échelle de rang `Rank` + `SIGNUP_RATING` : handoff Accueil (`ui/theme/Rank.kt`).
