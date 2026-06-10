# Handoff — Mode **Multijoueur** (style « Vitamine »)

Restylage des **7 écrans** du parcours multijoueur de TriviaQuiz, dans le même langage que les écrans
précédents (Compte, Profil, Jeu solo). Objectif : **recréer ces écrans en Compose Multiplatform**, fidélité **haute**.

> Pré-requis : avoir appliqué les **fondations** de `Notes Compose.html` (inclus) — §1 couleurs, §2 typo
> Baloo 2 / Nunito, §3 bouton « chunky » `ChunkyButton`. Ce document décrit ce qui est **spécifique au
> multijoueur** : champs, segmented controls, liste de catégories, carte « code de partie », écran de jeu
> avec panneau de scores, et podium de résultats.

Aperçu autonome : **`preview/Multijoueur Vitamine.html`** (ouvre dans un navigateur — molette = zoom, glisser = déplacer,
clic sur un écran = plein écran). Code React des écrans : `reference/screens-multi.jsx` + `reference/screens-game.jsx`.

---

## 0. Les 7 écrans
| # | Écran | Composable cible | Fichier réf. |
|---|---|---|---|
| 1 | Lancement (« Jouer à plusieurs ») | `MultiLaunchScreen` | screens-multi.jsx → `MultiLaunch` |
| 2 | Créer une partie (paramètres) | `MultiCreateScreen` | screens-multi.jsx → `MultiCreate` |
| 3 | Salon (code à partager) | `MultiLobbyScreen` | screens-multi.jsx → `MultiLobby` |
| 4 | Partie — question | `MultiGameScreen(state=Question)` | screens-game.jsx → `MultiGame` |
| 5 | Partie — réponse fausse | `MultiGameScreen(state=Wrong)` | screens-game.jsx → `MultiGame` |
| 6 | Partie — réponse bonne | `MultiGameScreen(state=Correct)` | screens-game.jsx → `MultiGame` |
| 7 | Résultats (podium) | `MultiResultsScreen` | screens-game.jsx → `MultiResults` |

> Tes deux captures « paramètres-partie » et « …-bas-écran » sont **un seul écran scrollable** (#2).
> Les écrans 4–6 sont **le même** `MultiGameScreen` dans 3 états (`Question` / `Wrong` / `Correct`).

---

## 1. Système commun (à implémenter une fois)

### a) Cadre & fond
Fond `bg #FBF7F2` partout (sauf Résultats, fond `navy #1B1733`). Largeur de réf. **412dp**.

### b) En-tête `MHeader(back, title)` — écrans 1/2/3
- Lien retour : icône `chevL` 18 + texte (« Accueil » / « Retour »), **couleur `brand #7A5AF8`**,
  Baloo 2 Bold 15sp, padding 6dp.
- Titre centré dessous : **Baloo 2 ExtraBold 23sp**, `ink #1E1B2E`.

### c) Champ `MField(icon, label, value, focused)`
Identique au handoff Compte : label uppercase Nunito ExtraBold 10.5sp `inkFaint` ; boîte blanche `h 54dp`,
rayon 15, bordure `1.5dp` (`line` au repos → `brand` + halo `brand22` en focus) ; icône de tête `user`.

### d) Segmented control `MSeg(options, value)`
Conteneur blanc, rayon 16, padding 4, bordure `1.5dp line`. Segments `flex:1`, padding vertical 11, rayon 12,
**Baloo 2 ExtraBold 15sp**. Actif : fond `brand`, texte blanc, ombre `0 4px 12px brand45`. Inactif : transparent,
texte `inkSoft`. Sert pour *Simple/Rapidité* (2 segments) et *Ouverte/20/40/60* (4 segments).

### e) Bouton « chunky » `ChunkyButton`
Cf. Notes §3. Primaire = `brand` + ombre portée `0 6px 0 brandDeep, 0 12px 22px brand55`. Hauteur 60.
Variante **contour** (Rejoindre / Terminer / Revenir) : blanc, bordure `2dp line`, texte `ink`/`inkSoft`,
**pas** d'ombre portée.

### f) `BottomNav(active)` — écrans 1/3/7
3 onglets Accueil / Multijoueur / Profil ; actif = `brand`, icône remplie. Cf. `reference/atoms.jsx`.

---

## 2. Écran **1 · Lancement**
`Column`, padding 20. De haut en bas :
1. `MHeader(back="Accueil", title="Jouer à plusieurs")`.
2. **Héros** centré : tuile `76dp` rayon 24, **dégradé 135° `brand → #9B7DFF`**, icône `users` 40 blanche,
   ombre `0 14px 30px brand50`. Sous-texte Nunito Bold 14.5sp `inkSoft`, centré, max 280dp :
   « Affronte tes amis en temps réel — crée un salon ou rejoins une partie avec un code. »
3. `MField(label="PSEUDO", value="Fabien")`.
4. `ChunkyButton(brand, icon=users)` **« Créer une partie »**.
5. Bouton **contour** (icône `chevR` brand) **« Rejoindre une partie »**.
6. `BottomNav(active=multi)`.

---

## 3. Écran **2 · Créer une partie** (scrollable)
`Column` scrollable, padding 14/20, `spacedBy(18.dp)` :
1. `MHeader(back="Retour", title="Créer une partie")`.
2. `MField(PSEUDO, "Fabien", focused=true)`.
3. **Score** : `MLabel("Score")` (Baloo 2 ExtraBold 15sp `ink`) + `MSeg(["Simple","Rapidité"], "Rapidité")`.
4. **Nombre de questions** : `MLabel` + `MSeg(["Ouverte","20","40","60"], "20")`.
5. **Catégorie** : `MLabel` + liste de `MCatRow` (voir §3a). Première = « Toutes catégories » (sélectionnée).
6. `ChunkyButton(brand, icon=play)` **« Créer la partie »**.

### a) `MCatRow(name, icon, color, on, all)`
`Row`, padding 11/14, rayon 16, `gap 12` :
- **Pastille** `34dp` rayon 11 : `all` → dégradé `brand→#9B7DFF` + icône `sparkle` ; sinon couleur de la catégorie
  + son icône (`globe/column/flask/palette/trophy/film`), ombre `0 4px 10px color44`.
- **Nom** Baloo 2 Bold 16sp, `flex:1`.
- **Sélectionnée** (`on`) : fond `brand16` (= brand 8–10% alpha), bordure `brand`, texte `brandDeep`, **coche** `check` brand à droite.
- **Non sélectionnée** : fond blanc, bordure `1.5dp line`, ombre `0 2px 8px #0000000a`.

Catégories (cf. `tokens.js → CATS`) : Géographie `#0FA697`, Histoire `#E5890F`, Sciences & Nature `#7A5AF8`,
Art & Culture `#EC4899`, Sports `#1FA84B`, Divertissement `#3B82F6`.

---

## 4. Écran **3 · Salon (code à partager)**
`Column`, padding 18/20, `spacedBy(18.dp)` :
1. `MHeader(back="Retour", title="Salon")`.
2. **Carte code** : rayon 22, padding 20/18, **dégradé 135° `#EFE9FF → #F7F3FF`**, bordure `1.5dp #E4DBFF`,
   ombre `0 10px 26px brand1f`, centré :
   - Sur-titre « CODE DE LA PARTIE » Baloo 2 ExtraBold 13sp `brandDeep`, uppercase.
   - **Code** « WBWE » **Baloo 2 ExtraBold 52sp**, `letterSpacing 8`, `brand`.
   - Bouton `brand` `h 42` rayon 13, icône `share` + « Partager le code ».
3. **Chips paramètres** (`FlowRow`, `gap 8`) : « Toutes catégories », « Partie ouverte », « Score Rapidité ».
   Chaque chip : Nunito ExtraBold 12.5sp `inkSoft`, blanc, bordure `1.5dp line`, rayon 20, padding 6/12.
4. **Joueurs** : titre « Joueurs (1) » (Baloo 2 ExtraBold 15sp, `(1)` en `inkFaint`). Puis lignes joueur :
   - `Row` blanche rayon 16, bordure `1.5dp line` : avatar `38dp` rayon 12 **dégradé `brand→#EC4899`** + initiale,
     nom Baloo 2 Bold 17sp, **badge « Hôte »** à droite (icône `crown` doré + texte, fond `#FDF3D6`, texte `gold`, rayon 20).
   - Ligne **slot vide** (bordure `dashed line`, icône `users` `inkFaint`) « En attente d'autres joueurs… ».
5. `ChunkyButton(brand, icon=play)` **« Démarrer la partie »**.
6. `BottomNav(active=multi)`.

---

## 5. Écrans **4–6 · Partie** — `MultiGameScreen(state)`

> **Reprend la présentation du mode solo** (`GameScreen`) : en-tête coloré, carte question, réponses lettrées
> A/B/C/D qui se colorent à la révélation. **Spécifique au multi** : barre de progression `n/120`, **panneau de
> scores** en bas, bouton « Terminer la partie ». Pas de bandeau d'explication (remplacé par les scores).

`state ∈ { Question, Wrong, Correct }`. Catégorie de démo = **« Toutes catégories » → couleur `brand`**
(`ALLCAT`). Une vraie partie passerait la catégorie courante (couleur/icône depuis `CAT`).

### a) En-tête coloré (`background = cat.color`)
padding 8/18/16. `Row` : bouton **« Quitter »** (icône `x` + texte, fond `#ffffff2e`, rayon 13) · chip catégorie
(icône + nom, `#ffffff2e`, rayon 20, `nowrap`) · **anneau timer** `Ring 40` (état `Question` seulement : valeur
`1`, sinon espace vide). Dessous : **barre de progression** `h 6` rayon 3 (track `#ffffff40`, remplissage blanc
= `n/total`) + « Question {n} / {total} » Nunito ExtraBold 12sp blanc.

### b) Carte question
Blanc, rayon 22, padding 18/20, ombre `0 8px 24px #0000000f`. Texte **Baloo 2 Bold 20sp**, `lineHeight 1.3`,
`text-wrap: balance`.

### c) Réponses (×4) — `answerStyle(i)`
`Row`, padding 13/14, rayon 16, bordure `2dp`, `gap 12`. Badge `32dp` rayon 10 (lettre A–D) + texte Baloo 2 Bold 16.5sp.
- **Repos** : fond blanc, bordure `line`, badge fond `brand1c` texte `brandDeep`.
- **Bonne réponse révélée** : fond `goodTint`, bordure `good`, texte `#15723A`, badge `good` + icône `check` blanche.
  Anim `tq-pop` si `state=Correct`.
- **Mauvaise réponse choisie** (`state=Wrong`) : fond `badTint`, bordure `bad`, texte `#B42121`, badge `bad` +
  icône `x`. Anim `tq-shake`.

### d) Panneau de scores `MScores(rows)` — **le différenciateur multijoueur**
Carte blanche rayon 18, bordure `1.5dp line`, padding 13/16. Titre « SCORES » Nunito ExtraBold 11sp `inkFaint`.
Une ligne par joueur (séparées par `1px line`) :
- **Pastille statut** `24dp` ronde : avant réponse `ok=null` → fond `#EDEAF2` + point `inkFaint` ;
  bonne → fond `goodTint` + `check` `good` ; mauvaise → fond `badTint` + `x` `bad`.
- **Avatar** `28dp` rayon 9 (couleur joueur) + initiale.
- **Nom** Baloo 2 Bold 16sp (`· toi` en `inkFaint` pour le joueur local).
- **Delta** `+918` Baloo 2 ExtraBold 14sp **`good`** (si la réponse rapporte des points).
- **Total** Baloo 2 ExtraBold 16sp `ink`, aligné à droite, `tabular-nums`.

États de démo : Q4 (Wrong) → Fabien 1712 ✗, Gabri 790 ✗ · Q5 (Correct) → Fabien **+918** 2630 ✓, Gabri **+642** 1592 ✓.
> ⚠️ Le delta de Gabri (`+642`) est une **valeur d'illustration** — à confirmer côté produit (dans ta capture
> seul le delta de Fabien apparaissait).

### e) Pied
Bouton **contour** « Terminer la partie » (`h 50`, bordure `2dp line`, texte `inkSoft`).

---

## 6. Écran **7 · Résultats** — `MultiResultsScreen`
Fond **`navy #1B1733`** (écran de célébration), `Confetti` en boucle, halo radial violet en haut.
1. Lien **« Quitter »** (chevL, `#B6ACDF`).
2. **Trophée** : disque `72dp` dégradé `#F5B716→#E5890F`, icône `trophy`, anim `tq-bob`. Titre **« Résultats »**
   Baloo 2 ExtraBold 27sp blanc + sous-titre « Fabien remporte la partie 🎉 » Nunito Bold 13.5sp `#B6ACDF`.
3. **Podium (2 joueurs)** : colonnes alignées en bas.
   - Chaque colonne : avatar (60dp pour le 1er avec **couronne** `crown` dorée au-dessus, 50dp sinon, bordure
     `3dp #fff`) + nom Baloo 2 ExtraBold 16sp + « {pts} pts » `#B6ACDF`.
   - **Barre** rayon `16/16/0/0` : 1er = dégradé `#F5B716→#E5890F` `h 150`, 2e = `#C5CCD6→#9AA4B2` `h 96` ;
     numéro de rang Baloo 2 ExtraBold 30sp blanc, `inset 0 2px 0 #ffffff66`.
   - Démo : **Fabien 3410 → 1er** (or), **Gabri 2271 → 2e** (argent).
4. **Actions** : `ChunkyButton(brand, icon=play)` **« Rejouer »** + bouton contour clair (`#ffffff12`, bordure
   `#ffffff26`, icône `home`) **« Revenir à l'accueil »**.

> Choix de design : fond nuit pour rester cohérent avec l'écran de célébration existant. Ta maquette d'origine
> était sur fond clair — si tu préfères, repasse `bg = C.bg` et adapte les textes en `ink`/`inkSoft`.

---

## 7. Données & branchements (décision produit)
- **Pseudo** : déjà prévu côté Compte (handoff précédent). Pré-rempli ici, réutilisé comme nom de joueur.
- **Salon** : `code` (4 lettres), `settings { categories, visibility, scoreMode }`, `players[]` (avec `isHost`).
  L'hôte voit « Démarrer la partie » ; les invités voient « En attente de l'hôte… ».
- **Partie** : `question { text, answers[], correctIndex }`, `progress { n, total }`, `timer`, et par joueur
  `{ name, color, answeredOk, delta, total }` → alimente `MScores`. `scoreMode` *Rapidité* = delta dépend du temps.
- **Résultats** : classement final (tri par `total` desc) → podium + actions Rejouer / Accueil.
- Tout est **statique** dans les maquettes (valeurs de démo) — câble progressivement sur ton state/temps réel.

## 8. Workflow Claude Code suggéré
1. « Lis `design_handoff_multijoueur/README.md` + `Notes Compose.html`, ouvre `preview/Multijoueur Vitamine.html`.
   Résume les composants partagés (`MHeader`, `MField`, `MSeg`, `MCatRow`, `MScores`, `ChunkyButton`) sans coder. »
2. « Implémente le système commun (§1) : en-tête, champ, segmented, bouton chunky + contour, BottomNav. »
3. « Écran 1 (Lancement), puis 2 (Créer une partie + `MCatRow`), puis 3 (Salon + carte code). »
4. « Écran de jeu `MultiGameScreen` (§5) en 3 états + `MScores`. »
5. « Écran Résultats (§6) : podium festif + actions. »
6. **Décisions produit** : delta de Gabri (§5d) · fond Résultats clair/nuit (§6). Compile et compare après chaque écran.

## Fichiers de référence
- `reference/screens-multi.jsx` — écrans 1–3 + atomes (`Phone`, `MHeader`, `MField`, `MSeg`, `MCatRow`, `MScores`).
- `reference/screens-game.jsx` — écrans 4–7 (`MultiGame`, `MultiResults`) + données de démo.
- `reference/atoms.jsx` — partagés : `Btn` (chunky), `BottomNav`, `Icon`, `Ring`, `Confetti`, `Screen`.
- `reference/tokens.js` — palette, catégories, icônes (paths viewBox 24×24).
- `preview/Multijoueur Vitamine.html` — **aperçu interactif autonome** des 7 écrans.
- `Notes Compose.html` — fondations Compose (thème, typo, bouton chunky) — §1, §2, §3.
