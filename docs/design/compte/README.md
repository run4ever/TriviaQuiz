# Handoff — Écran « Compte » (maquettes 8 & 9)

## Ce que c'est
Le **module Compte** de TriviaQuiz, en deux états d'un **même écran** (`AccountScreen`) :

- **8 · Connexion / inscription** — état **déconnecté / invité fusionnés** : carte « mode invité », bascule
  *Se connecter / S'inscrire*, puis formulaire **email → pseudo → mot de passe** et CTA « Créer un compte ».
- **9 · Mon compte (connecté)** — carte compte (email + badge « Connecté »), **pseudo éditable** + bouton
  « Enregistrer le pseudo », note de synchro, et bouton **« Se déconnecter »**.

Réf. : artboards **8** & **9** (section *Compte*) de `TriviaQuiz Concepts.html`, code dans `reference/screens-e.jsx`.
Aperçu autonome inclus : **`preview/Ecrans Compte (8-9).html`** (ouvre dans un navigateur — clique dans un écran).
Objectif : **recréer cet écran en Compose Multiplatform** dans le code existant, fidélité **haute** (hi-fi).

> Pré-requis : avoir appliqué les **fondations** de `Notes Compose.html` (inclus) — §1 couleurs, §2 typo Baloo 2 /
> Nunito, §3 bouton « chunky » `ChunkyButton`. Ce document **ne ré-explique pas** ces recettes ; il décrit ce qui est
> **spécifique au Compte** : champs de saisie, segmented control, états connecté/déconnecté, et la **donnée pseudo**.

## Où ça s'insère
| Élément | Fichier cible | État actuel |
|---|---|---|
| Écran Compte | `ui/account/AccountScreen.kt` | à créer / restyler — un écran, **2 branches** selon `isSignedIn` |
| Navigation | `App.kt` | l'écran s'ouvre depuis **Profil** (`onOpenAccount`, déjà câblé) → bouton retour « ‹ Profil » |
| Auth (email/mdp) | `…/auth/` (ViewModel) | **à brancher** — décision produit (voir §5) |
| Pseudo (nom multi) | `GameState` / `ViewModel` | **manquant** dans l'état → à ajouter (voir §5) |

Signature suggérée (un seul composable, piloté par l'état d'auth) :
```kotlin
@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    isSignedIn: Boolean,            // false → maquette 8 ; true → maquette 9
    email: String,                  // affiché (9) / pré-rempli (8)
    pseudo: String,                 // nom affiché en multijoueur
    onBack: () -> Unit,             // ‹ Profil
    onSignUp: (email, pseudo, pw: String) -> Unit,
    onSignIn: (email, pw: String) -> Unit,
    onSavePseudo: (String) -> Unit,
    onSignOut: () -> Unit,
)
```

---

## 1. Anatomie — écran **8 · Connexion / inscription** (haut → bas)

Largeur de référence **412dp**, fond `bg #FBF7F2`. `Column` plein écran, **sans scroll** (un `Spacer(weight=1f)`
pousse le CTA en bas). Contenu : padding `12dp` (haut) / `18dp` (côtés) / `6dp` (bas), `Arrangement.spacedBy(14.dp)`.

```
┌─────────────────────────────┐
│ ‹ Profil                    │  en-tête : retour brand + titre centré
│           Compte            │
│  ┌───────────────────────┐  │
│  │ ☁  Vous jouez en mode │  │  carte « invité » (dégradé lilas)
│  │    invité — créez un… │  │
│  └───────────────────────┘  │
│  ┌──────────┬────────────┐  │  segmented : Se connecter | S'inscrire
│  │Se conn.  │  S'inscrire │  │  (onglet actif = pill violette)
│  └──────────┴────────────┘  │
│  EMAIL                       │
│  ┌───────────────────────┐  │  champ email (focus)
│  │ ✉  fabien@email.com   │  │
│  EMAIL → PSEUDO → MOT DE PASSE
│  ┌───────────────────────┐  │  champ pseudo (+ ligne d'aide ✦)
│  ┌───────────────────────┐  │  champ mot de passe (•••• + œil)
│        (espace flexible)     │
│  [   ✦  Créer un compte  ]  │  CTA chunky violet pleine largeur
│  [ Accueil  Multi  Profil ] │  bottom nav (Profil actif)
└─────────────────────────────┘
```

### a) En-tête `AcctHeader` (commun aux 2 écrans)
- Bouton retour **« ‹ Profil »** : icône `chevL` 18 + texte, `brand #7A5AF8`, **Baloo 2 Bold 15sp**, padding `6dp`.
- Sous lui, titre **« Compte »** centré, **Baloo 2 ExtraBold 23sp**, `ink #1E1B2E`.

### b) Carte « mode invité » `GuestCard`
Rayon `20dp`, padding `14dp/15dp`, **dégradé 135° `#EFE9FF → #F7F3FF`**, bordure `1.5dp #E4DBFF`,
ombre `0 8px 20px #7A5AF81f`. À gauche tuile `42dp` rayon `13dp`, **dégradé 135° `#7A5AF8 → #9B7DFF`**,
icône `cloud` blanche `22dp`. À droite : titre **« Vous jouez en mode invité »** Baloo 2 ExtraBold 15.5sp + sous-texte
Nunito Bold 12.5sp `inkSoft #6B6680` (« Créez un compte pour sauvegarder votre progression… »).

### c) Segmented *Se connecter / S'inscrire*
Conteneur `Row` blanc, rayon `16dp`, padding `4dp`, bordure `1.5dp line #ECE6F0`. Deux segments `flex:1`, padding
vertical `11dp`, rayon `12dp`, **Baloo 2 ExtraBold 15sp**. **Actif** : fond `brand`, texte blanc, ombre
`0 4px 12px brand45`. **Inactif** : transparent, texte `inkSoft`. *(Maquette : onglet « S'inscrire » actif.)*

### d) Champs `AcctField` (voir §3) — ordre **email → pseudo → mot de passe**
- **Email** (`mail`) en **focus** (anneau violet), valeur `fabien@email.com`.
- **Pseudo** via `PseudoField` (voir §4) : champ `user` + ligne d'aide ✦ « Pré-rempli depuis ton email — modifiable. »
- **Mot de passe** (`lock`), valeur masquée `••••••••` (`letterSpacing 3`), **œil** `eye` à droite (toggle visibilité).

### e) CTA
`ChunkyButton` (§3 Notes) **violet** pleine largeur, icône `sparkle`, libellé **« Créer un compte »** → `onSignUp(...)`.
*(Onglet « Se connecter » : mêmes champs sans pseudo + CTA « Se connecter » → `onSignIn(...)`.)*

### f) Bottom nav — onglet **Profil actif** (`BottomNav active="me"`, cf. `reference/atoms.jsx`).

---

## 2. Anatomie — écran **9 · Mon compte (connecté)** (haut → bas)

Même en-tête `AcctHeader title="Compte"`. Contenu : padding `14/18/6`, `Arrangement.spacedBy(16.dp)`.

```
┌─────────────────────────────┐
│ ‹ Profil      Compte        │
│  ┌───────────────────────┐  │
│  │ [F] ✓Connecté         │  │  carte compte (blanche)
│  │     fabien@email.com  │  │
│  └───────────────────────┘  │
│  PSEUDO                      │
│  ┌───────────────────────┐  │  pseudo éditable (focus)
│  │ 👤 RenardMalin42      │  │
│  ✦ Ton nom affiché en multi. │
│  [   ✓  Enregistrer…     ]  │  bouton md, chunky violet
│  ┌───────────────────────┐  │  note synchro (🛡)
│        (espace flexible)     │
│  [   ⮐  Se déconnecter   ]  │  bouton contour, texte rouge
│  [ Accueil  Multi  Profil ] │
└─────────────────────────────┘
```

### a) Carte compte connecté
`Row` blanche, rayon `20dp`, padding `15dp/16dp`, bordure `1.5dp line`, ombre `0 6px 18px #0000000d`, `gap 13dp` :
- **Avatar** `48dp` rayon `15dp`, **dégradé 135° `#7A5AF8 → #EC4899`**, initiale du pseudo blanche Baloo 2 ExtraBold 22sp.
- Colonne : **pill « ✓ Connecté »** (fond `goodTint #D5F2DD`, padding `3dp/9dp`, rayon `20dp`, icône `check` 12 `good #1FA84B`
  + libellé Nunito ExtraBold 10.5sp `good`), puis **email** Nunito ExtraBold 15sp `ink` (`ellipsis`).

### b) Pseudo éditable
`PseudoField` (§4) **en focus**, valeur `RenardMalin42`, aide « Ton nom affiché en multijoueur. » + juste dessous
`ChunkyButton` **taille `md`** (rayon `15dp`), icône `check`, **« Enregistrer le pseudo »** → `onSavePseudo`.

### c) Note synchro
`Row` blanche, rayon `15dp`, padding `12dp/14dp`, bordure `1.5dp line` : icône `shield` 18 `brand` +
texte Nunito Bold 12.5sp `inkSoft` « Ta progression et tes niveaux sont sauvegardés sur ce compte. »

### d) Déconnexion (pied)
Bouton **contour** (pas chunky) : hauteur `54dp`, fond blanc, bordure `2dp line`, rayon `16dp`, icône `logout` +
**« Se déconnecter »** Baloo 2 Bold 16sp, **couleur `bad #EF4444`** → `onSignOut`.

---

## 3. Champ de saisie — `AccountField`

`reference/screens-e.jsx → AcctField`. En Compose, un `OutlinedTextField` custom **ou** un `Row` cliquable :

- **Label** au-dessus : uppercase, **Nunito ExtraBold 10.5sp**, `inkFaint #A7A2B6`, letterSpacing .6, marginBottom 6.
- **Boîte** : `Row`, fond `#fff`, rayon `15dp`, **hauteur fixe `52dp`**, padding `0 10dp 0 13dp`, `gap 10dp`,
  bordure `1.5dp` :
  - **repos** : bordure `line #ECE6F0`, ombre `0 2px 8px #0000000a`.
  - **focus** : bordure `accent` (= `brand`), **halo `0 0 0 4dp accent22`** (≈ `Modifier.border` + `shadow`/`drawBehind`).
- Icône de tête (`mail`/`user`/`lock`) `19dp` : `inkFaint` au repos, `accent` en focus.
- **Valeur** : Nunito **800** `ink` si remplie, **700** `inkFaint` si placeholder ; `15.5sp` ; `ellipsis` sur une ligne.
  Mot de passe → `letterSpacing 3`.
- **`trailing`** optionnel (œil mot de passe : bouton `eye` 19 `inkFaint`).

```kotlin
@Composable
fun AccountField(
    icon: ImageVector, label: String, value: String,
    focused: Boolean = false, accent: Color = Brand,
    trailing: (@Composable () -> Unit)? = null,
) {
    Column {
        Text(label.uppercase(), fontFamily = Nunito, fontWeight = FontWeight.ExtraBold,
            fontSize = 10.5.sp, letterSpacing = 0.6.sp, color = InkFaint,
            modifier = Modifier.padding(start = 2.dp, bottom = 6.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth().height(52.dp)
                .then(if (focused) Modifier.border(4.dp, accent.copy(alpha = .13f), RoundedCornerShape(15.dp)) else Modifier)
                .background(Color.White, RoundedCornerShape(15.dp))
                .border(1.5.dp, if (focused) accent else Line, RoundedCornerShape(15.dp))
                .padding(start = 13.dp, end = 10.dp),
        ) {
            Icon(icon, null, tint = if (focused) accent else InkFaint, modifier = Modifier.size(19.dp))
            Text(value, fontFamily = Nunito, fontWeight = FontWeight.ExtraBold, fontSize = 15.5.sp,
                color = Ink, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
            trailing?.invoke()
        }
    }
}
```

> Maquette = **statique** (valeurs en dur pour montrer l'état rempli/focus). En vrai, remplace `value: String` par un
> `TextFieldValue` + `onValueChange`, et pilote `focused` via `interactionSource.collectIsFocusedAsState()`.

---

## 4. Pseudo `PseudoField` + sa ligne d'aide

`AccountField(icon = user, label = "Pseudo", …)` **plus**, dessous (marginTop 7, `gap 6`) une ligne d'aide :
icône **`sparkle`** 13 `brand` (remplie) + texte **Nunito Bold 11.5sp `inkSoft`**. Le helper change selon l'écran :
- Écran 8 : « **Pré-rempli depuis ton email — modifiable.** »
- Écran 9 : « **Ton nom affiché en multijoueur.** »

---

## 5. Données & auth (décision produit)

> ⚠️ Ni l'**authentification** (email/mot de passe) ni le **pseudo** ne sont dans l'état actuel. À décider/brancher.

- **Pseudo (nom affiché en multijoueur)** — *prévu mais pas encore câblé*. Ajoute-le à l'état exposé :
  ```kotlin
  // dans GameState / un AccountState
  val pseudo: String          // vide tant que non défini
  // à l'inscription : pseudo = email.substringBefore('@')   ← pré-remplissage (écran 8)
  ```
  C'est ce champ que le **multijoueur** affichera comme nom de joueur.
- **Auth** — l'écran ne fait que **collecter** email / pseudo / mot de passe et appeler `onSignUp` / `onSignIn`.
  Le backend (Firebase Auth, ton API, etc.) est **hors périmètre de cette maquette** : branche `isSignedIn`, `email`
  et `onSignOut` sur ta couche existante.
- **Si rien n'est encore branché** : garde l'écran **statique** avec les valeurs de démo de `screens-e.jsx`
  (`fabien@email.com`, pseudo `RenardMalin42`) pour valider le style, puis câble l'état progressivement.

---

## 6. Tokens utilisés ici (rappel)
- Neutres : `bg #FBF7F2`, `card #FFFFFF`, `ink #1E1B2E`, `inkSoft #6B6680`, `inkFaint #A7A2B6`, `line #ECE6F0`.
- Brand : `brand #7A5AF8`, `brandDeep #553BD0` ; halo focus `brand22` (≈ 13% alpha).
- États : `good #1FA84B` + `goodTint #D5F2DD` (badge Connecté) ; `bad #EF4444` (déconnexion).
- Dégradés : invité tuile `#7A5AF8 → #9B7DFF`, carte invité `#EFE9FF → #F7F3FF` (bordure `#E4DBFF`) ;
  avatar connecté `#7A5AF8 → #EC4899`.
- Icônes : `chevL, cloud, mail, user, lock, eye, sparkle, check, shield, logout`. Paths dans
  `reference/tokens.js → ICONS` (viewBox 24×24, stroke 2.1–2.6) → `ImageVector`/drawable vectoriel.
- Rayons : carte invité/compte `20` · champ `15` · segmented `16`/segment `12` · tuile invité `13` · avatar `15` ·
  CTA chunky `18` (md `15`) · déconnexion `16` · pills `20`.
- Typo : **Display = Baloo 2**, **Body = Nunito** (cf. Notes §2).

---

## 7. Workflow Claude Code suggéré
1. « Lis `design_handoff_compte/README.md` + `Notes Compose.html`, et ouvre `preview/Ecrans Compte (8-9).html`.
   Résume la structure de `AccountScreen.kt` (1 écran, 2 branches `isSignedIn`) sans coder. »
2. « Implémente `AccountField` (§3) + `PseudoField` (§4) + l'en-tête `AcctHeader`. »
3. « Construis la branche **déconnectée** (maquette 8) : `GuestCard`, segmented, champs, CTA chunky (§3 Notes). »
4. « Construis la branche **connectée** (maquette 9) : carte compte, pseudo éditable + Enregistrer, note, déconnexion. »
5. **Décision produit** : « Ajoute `pseudo` à l'état + pré-remplissage email (§5) » **ou** garde des valeurs de démo.
6. « Branche `BottomNav` (Profil actif) + le retour `onBack`. » Compile + compare aux artboards 8 & 9 après chaque étape.

## Fichiers de référence
- `reference/screens-e.jsx` — code React des 2 écrans (structure, tailles, couleurs exactes).
- `reference/atoms.jsx` — composants partagés : `Btn` (chunky), `BottomNav`, `Icon`, `Screen`.
- `reference/tokens.js` — palette, échelle de rang, paths d'icônes.
- `preview/Ecrans Compte (8-9).html` — **aperçu interactif autonome** des artboards 8 & 9.
- Recettes Compose (thème, typo, bouton chunky) : **`Notes Compose.html`** (inclus) — §1, §2, §3.
