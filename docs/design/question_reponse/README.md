# Handoff — Écran de jeu (maquettes 3 · 4 · 5)

## Ce que c'est
Les maquettes **3 · Question**, **4 · Bonne réponse** et **5 · Mauvaise réponse** sont **un seul composant**
dans trois états (`q` / `correct` / `wrong`). Réf. : artboards 3–5 de `TriviaQuiz Concepts.html`, code dans
`reference/screens-b.jsx`. Objectif : **recréer cet écran en Compose**, fidélité haute.

> Pré-requis : avoir déjà appliqué les **fondations** de `Notes Compose.html` (inclus dans ce dossier) — §1 couleurs par
> catégorie `CatColors`, §2 typo Baloo 2 / Nunito — et idéalement le `ChunkyButton` (§3). Ce document **ne ré-explique pas**
> ces recettes : il décrit l'écran de jeu et renvoie aux recettes d'animation par leur numéro.

## Où ça s'insère
| Élément | Fichier cible | État actuel |
|---|---|---|
| Écran de jeu | `ui/game/GameScreen.kt` | fonctionnel mais style Material brut → **à restyler** |
| Logique de jeu | `ui/game/GameViewModel.kt` | **complète** (ELO, anti-grind, enchaînement) → ne pas toucher, sauf chrono/série (voir §5) |

> ⚠️ **La logique existe déjà.** `GameViewModel` gère le tirage des questions, la confirmation de réponse, le calcul ELO
> et l'enchaînement **sans fin** (solo). `GameState` expose tout ce dont l'UI a besoin :
> `questions`, `currentIndex`, `selectedAnswerIndex`, `answerConfirmed`, `lastRatingDelta`, `displayedRating`,
> `selectedCategory`. **C'est un travail de présentation**, pas de logique — sauf les 2 nouveautés du §5.

---

## 1. Anatomie de l'écran (haut → bas)

Une `Column` plein écran. La question courante = `state.questions[state.currentIndex]`.
Couleur d'accent = celle de **la catégorie de la question** : `categoryColors.getValue(question.category)`
(en solo « toutes catégories », elle change donc à chaque question).

**a) En-tête coloré** (fond `cat.main`, padding `6/18/18`) — `Row` space-between :
- bouton **fermer** (croix) `38dp` carré arrondi `12dp`, fond `#ffffff2e` → `onGoHome()`.
- **pill catégorie** au centre : icône catégorie + `question.category.displayName` (blanc).
- **anneau chrono** `40dp` (`ProgressRing` §8, stroke 5, track `#ffffff33`) avec les **secondes restantes** au centre. ➜ voir §5.

**b) Sous-en-tête solo** (`Row`, marginTop 16) — pills sur fond `#ffffff2e` :
- **série** : flamme + nombre + « d'affilée » ➜ voir §5.
- **rang** : couronne + `Rank.of(displayedRating).label` (réutilise `Rank` du handoff Accueil).
- à droite, libellé **« Sans fin »** (le solo ne se termine jamais).
> La barre de progression `x / N` du `reference/screens-b.jsx` (`mode === 'multi'`) concerne l'écran **6 · Multijoueur**,
> pas le solo. Ne pas l'utiliser ici.

**c) Carte question** (fond blanc, rayon `22dp`, ombre douce, padding `20dp`, `marginTop -2dp` pour chevaucher l'en-tête) :
`question.text` en Baloo 2 Bold ~21sp, `lineHeight 1.28`, `textAlign` équilibré. Entrée animée `slideInVertically + fadeIn`
quand l'état passe à `q` (cf. §4/§5 Notes).

**d) Liste de réponses** (`Column`, gap `11dp`, padding `14/18/8`) — une carte par option, voir §2.

**e) Bandeau feedback** (seulement si `answerConfirmed`) — voir §3.

---

## 2. Carte réponse — `AnswerCard`

`Row` rayon `18dp`, bordure `2dp`, padding `14/15`, ombre douce. À gauche un **badge** `34dp` rayon `11dp`
(lettre A/B/C/D en Baloo 2), puis le texte de l'option (Baloo 2 ~17sp). Couleurs selon l'état :

| Cas | fond | bordure | badge | texte |
|---|---|---|---|---|
| repos (pas confirmé) | `#fff` | `line #ECE6F0` | `cat.tint` / `cat.deep`, **lettre** | `ink` |
| **bonne** (révélée) | `goodTint #D5F2DD` | `good #1FA84B` | `good`, **icône check** | `good`/`ink` |
| **choisie & fausse** | `badTint #FBE0E0` | `bad #EF4444` | `bad`, **icône croix** | `#B42121` |
| autres options révélées | repos (inchangé) | | | |

- **révélé** = `state.answerConfirmed`. Bonne option = `index == question.correctIndex`. Choisie = `index == state.selectedAnswerIndex`.
- Animations à la révélation (recette §6 Notes) : **pop** (scale bouncy) sur la bonne réponse, **shake** (offset X qui oscille) sur la mauvaise.
- En entrée de question, les cartes apparaissent **en cascade** (stagger §5 Notes).
- Tap : si `!answerConfirmed` → `onSelectAnswer(index)` ; si déjà confirmé → `onNextQuestion()` (déjà câblé ainsi).

> Couleurs `animateColorAsState(tween(280))` pour une transition douce repos → révélé (recette §6).

---

## 3. Bandeau feedback (états 4 & 5)

Apparaît en **slide-up** depuis le bas (`tq-up` ≈ `slideInVertically{it} + fadeIn`, recette §4/§6). Fond
`goodTint` (correct) ou `badTint` (faux), coins haut arrondis `26dp`.
- **Ligne titre** : pastille ronde `30dp` (`good`/`bad`) avec check/croix (animée `pop`) + libellé **« Bravo ! »** / **« Raté… »**
  (Baloo 2 ExtraBold ~19sp) ; à droite, pill blanche avec éclair + **delta ELO** = `state.lastRatingDelta`
  (`"+12"` / `"−8"` — déjà calculé, signe inclus).
- **Explication** : `question.explanation` (Nunito ~13.5sp, `inkSoft`).
- **Bouton « Continuer »** : `ChunkyButton` (§3) teinté `cat.main` / `cat.deep`, icône flèche → `onNextQuestion()`.
- **Confettis** sur **correct** uniquement : `Confetti(palette)` (recette §9, 100 % commonMain) au-dessus du bandeau.

> Le tap « n'importe où pour continuer » est déjà géré dans `GameScreen.kt` (clickable parent). Garde-le ; le bouton
> « Continuer » est un raccourci explicite, les deux appellent `onNextQuestion()`.

---

## 4. Correspondance maquette → état (récap)

| Maquette | `state.answerConfirmed` | `state.selectedAnswerIndex` | rendu |
|---|---|---|---|
| **3 · Question** | `false` | `null` | cartes au repos, bandeau masqué, chrono qui tourne |
| **4 · Bonne réponse** | `true` | = `correctIndex` | bonne carte verte + pop, bandeau « Bravo ! », confettis |
| **5 · Mauvaise réponse** | `true` | ≠ `correctIndex` | carte choisie rouge + shake, bonne carte verte, bandeau « Raté… » |

Aucune nouvelle donnée nécessaire pour ces trois états : tout vient de `GameState`.

---

## 5. Les 2 éléments visuels SANS logique (décisions à prendre)

Ces deux pastilles sont **présentes dans la maquette mais pas dans `GameViewModel`**. À toi de décider si tu les
implémentes maintenant, plus tard, ou si tu les retires de l'écran.

### a) Le chrono (« 14 » dans l'anneau)
Un compte à rebours en secondes par question. **Non implémenté** côté état. Pour l'ajouter :
- choisir une **durée** (p. ex. 15 s) ;
- décider ce qui se passe **à 0** (réponse comptée fausse via `onSelectAnswer(-1)`/auto-confirm, ou question passée) ;
- l'UI = `ProgressRing` (§8) animé de `1f` → `0f` sur la durée, secondes au centre ; un `LaunchedEffect(currentIndex)`
  relance le timer à chaque question.
- **Si tu n'en veux pas pour l'instant** : masque l'anneau, ou affiche-le statique sans compte à rebours.

### b) La série (« 7 d'affilée »)
Nombre de bonnes réponses consécutives. **Non présent** dans `GameState`. Pour l'ajouter :
- un champ `streak: Int` dans `GameState`, incrémenté sur bonne réponse et remis à 0 sur erreur, dans `selectAnswer`.
- **Si tu n'en veux pas** : retire la pill « d'affilée » de l'en-tête (garde rang + « Sans fin »).

> Ces deux ajouts sont les **seules** modifications de logique pour cet écran. Tout le reste est du style.

---

## 6. Workflow Claude Code suggéré
1. « Lis `design_handoff_jeu/README.md` + `Notes Compose.html`. Résume le plan de restyle de `GameScreen.kt`, sans coder. »
2. « Restyle l'**en-tête + carte question** (§1) en gardant la signature et les callbacks actuels de `GameScreen`. »
3. « Implémente `AnswerCard` (§2) avec les couleurs d'état et les animations pop/shake (§6 Notes). »
4. « Implémente le **bandeau feedback** (§3) + confettis (§9 Notes). »
5. **Décisions produit** : « Ajoute le chrono (§5a, durée = … s, à 0 = …) » et/ou « Ajoute `streak` (§5b) » — ou indique-lui de les masquer.
6. Compile + compare aux artboards 3/4/5 après chaque étape.

## Fichiers de référence
- `reference/screens-b.jsx` — code React de l'écran (structure, couleurs, animations exactes).
- `reference/atoms.jsx` — composants partagés : `Ring` (chrono), `Confetti`, `Btn` (chunky), `Icon`, `Screen`.
- `reference/tokens.js` — palette, catégories, paths d'icônes (`x, check, flame, crown, bolt, chevR` + icônes catégories).
- Recettes Compose (animations, thème) : **`Notes Compose.html`** (inclus dans ce dossier) — voir §3 (chunky), §5 (stagger), §6 (feedback pop/shake/couleur), §8 (anneau/chrono), §9 (confettis).
- Échelle de rang `Rank` : définie dans le handoff Accueil (`ui/theme/Rank.kt`).
