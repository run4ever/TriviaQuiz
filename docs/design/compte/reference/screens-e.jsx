/* TriviaQuiz — Écrans Compte (style Vitamine)
   8 · Compte — connexion / inscription (état déconnecté + invité fusionnés)
   9 · Mon compte (connecté)
   Le pseudo (nom affiché en multijoueur) est PRÉVU bien qu'il ne soit pas encore
   branché côté code. À l'inscription il est pré-rempli avec la 1ʳᵉ partie de l'email. */
const { FONT_DISPLAY: EFD, FONT_BODY: EFB, C: EK } = window.TQ;

// ── En-tête commun : « ‹ Profil » + titre centré ──────────────────────
function AcctHeader({ title }) {
  return (
    <div style={{ flexShrink: 0, padding: '4px 14px 0' }}>
      <button className="tq-press-fx" style={{
        display: 'inline-flex', alignItems: 'center', gap: 2, border: 'none', background: 'none',
        cursor: 'pointer', padding: '6px 6px', color: EK.brand, fontFamily: EFD, fontWeight: 700, fontSize: 15,
      }}>
        <Icon name="chevL" size={18} color={EK.brand} sw={2.6} /> Profil
      </button>
      <div style={{ textAlign: 'center', marginTop: 2 }}>
        <div style={{ fontFamily: EFD, fontWeight: 800, fontSize: 23, color: EK.ink }}>{title}</div>
      </div>
    </div>
  );
}

// ── Champ de saisie (icône + label + valeur/placeholder + élément à droite) ──
function AcctField({ icon, label, value, placeholder, mono, trailing, accent = EK.brand, focus = false }) {
  const filled = !!value;
  return (
    <div>
      <div style={{ marginBottom: 6, padding: '0 2px' }}>
        <span style={{ fontFamily: EFB, fontWeight: 800, fontSize: 10.5, letterSpacing: .6, textTransform: 'uppercase', color: EK.inkFaint }}>{label}</span>
      </div>
      <div style={{
        display: 'flex', alignItems: 'center', gap: 10, background: '#fff', borderRadius: 15, height: 52,
        border: `1.5px solid ${focus ? accent : EK.line}`, padding: '0 10px 0 13px',
        boxShadow: focus ? `0 0 0 4px ${accent}22` : '0 2px 8px #0000000a',
      }}>
        <Icon name={icon} size={19} color={focus ? accent : EK.inkFaint} sw={2.2} />
        <span style={{ flex: 1, minWidth: 0, fontFamily: EFB, fontWeight: filled ? 800 : 700, fontSize: 15.5,
          color: filled ? EK.ink : EK.inkFaint, letterSpacing: mono ? 3 : .1, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
          {value || placeholder}
        </span>
        {trailing}
      </div>
    </div>
  );
}

// Œil (visibilité mot de passe)
const EyeBtn = () => (
  <button className="tq-press-fx" style={{ border: 'none', background: 'none', cursor: 'pointer', padding: 6, flexShrink: 0, display: 'flex' }}>
    <Icon name="eye" size={19} color={EK.inkFaint} sw={2.1} />
  </button>
);

// Pseudo : champ + ligne d'aide
function PseudoField({ value, focus = false, helper, trailing = null }) {
  return (
    <div>
      <AcctField icon="user" label="Pseudo" value={value} focus={focus} trailing={trailing} />
      <div style={{ display: 'flex', alignItems: 'center', gap: 6, marginTop: 7, padding: '0 2px' }}>
        <Icon name="sparkle" size={13} color={EK.brand} fill={EK.brand} />
        <span style={{ fontFamily: EFB, fontWeight: 700, fontSize: 11.5, color: EK.inkSoft }}>{helper}</span>
      </div>
    </div>
  );
}

// Carte « mode invité » (Vitamine)
function GuestCard() {
  return (
    <div style={{
      borderRadius: 20, padding: '14px 15px', display: 'flex', gap: 13, alignItems: 'flex-start', flexShrink: 0,
      background: 'linear-gradient(135deg,#EFE9FF,#F7F3FF)', border: '1.5px solid #E4DBFF',
      boxShadow: '0 8px 20px #7A5AF81f',
    }}>
      <div style={{ width: 42, height: 42, borderRadius: 13, flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
        background: 'linear-gradient(135deg,#7A5AF8,#9B7DFF)', boxShadow: '0 6px 14px #7A5AF855' }}>
        <Icon name="cloud" size={22} color="#fff" sw={2.2} />
      </div>
      <div style={{ flex: 1 }}>
        <div style={{ fontFamily: EFD, fontWeight: 800, fontSize: 15.5, color: EK.ink, lineHeight: 1.15 }}>Vous jouez en mode invité</div>
        <div style={{ fontFamily: EFB, fontWeight: 700, fontSize: 12.5, color: EK.inkSoft, lineHeight: 1.4, marginTop: 3 }}>
          Créez un compte pour sauvegarder votre progression et la retrouver sur tous vos appareils.
        </div>
      </div>
    </div>
  );
}

// ════════════════════════════════════════════════════════════════════════
// 8 · Compte — Connexion / Inscription (onglet Inscription actif)
// Pseudo pré-rempli depuis la 1ʳᵉ partie de l'email saisi.
// ════════════════════════════════════════════════════════════════════════
function AccountAuthScreen() {
  const tabs = [['signin', 'Se connecter'], ['signup', "S'inscrire"]];
  const active = 'signup';
  return (
    <Screen bg={EK.bg}>
      <AcctHeader title="Compte" />
      <div style={{ flex: 1, overflow: 'hidden', padding: '12px 18px 6px', display: 'flex', flexDirection: 'column', gap: 14 }}>

        <GuestCard />

        {/* Segmented connexion / inscription */}
        <div style={{ display: 'flex', gap: 4, background: '#fff', borderRadius: 16, padding: 4, flexShrink: 0,
          border: `1.5px solid ${EK.line}`, boxShadow: '0 2px 8px #0000000a' }}>
          {tabs.map(([id, lbl]) => {
            const on = id === active;
            return (
              <div key={id} style={{
                flex: 1, textAlign: 'center', padding: '11px 0', borderRadius: 12, cursor: 'pointer',
                fontFamily: EFD, fontWeight: 800, fontSize: 15,
                background: on ? EK.brand : 'transparent', color: on ? '#fff' : EK.inkSoft,
                boxShadow: on ? `0 4px 12px ${EK.brand}45` : 'none',
              }}>{lbl}</div>
            );
          })}
        </div>

        {/* Formulaire : email → pseudo (pré-rempli) → mot de passe */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 13 }}>
          <AcctField icon="mail" label="Email" value="fabien@email.com" focus />
          <PseudoField value="fabien" helper="Pré-rempli depuis ton email — modifiable." />
          <AcctField icon="lock" label="Mot de passe" value="••••••••" mono trailing={<EyeBtn />} />
        </div>

        <div style={{ flex: 1 }} />

        <div style={{ flexShrink: 0 }}>
          <Btn full color={EK.brand} deep={EK.brandDeep} icon="sparkle">Créer un compte</Btn>
        </div>
      </div>
      <BottomNav active="me" />
    </Screen>
  );
}

// ════════════════════════════════════════════════════════════════════════
// 9 · CONNECTÉ → Mon compte (email + pseudo éditable + déconnexion)
// ════════════════════════════════════════════════════════════════════════
function AccountSignedInScreen() {
  return (
    <Screen bg={EK.bg}>
      <AcctHeader title="Compte" />
      <div style={{ flex: 1, overflow: 'hidden', padding: '14px 18px 6px', display: 'flex', flexDirection: 'column', gap: 16 }}>

        {/* Carte compte connecté */}
        <div style={{ borderRadius: 20, padding: '15px 16px', display: 'flex', alignItems: 'center', gap: 13, flexShrink: 0,
          background: '#fff', border: `1.5px solid ${EK.line}`, boxShadow: '0 6px 18px #0000000d' }}>
          <div style={{ width: 48, height: 48, borderRadius: 15, flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
            background: 'linear-gradient(135deg,#7A5AF8,#EC4899)', color: '#fff', fontFamily: EFD, fontWeight: 800, fontSize: 22 }}>
            F
          </div>
          <div style={{ flex: 1, minWidth: 0 }}>
            <div style={{ display: 'inline-flex', alignItems: 'center', gap: 5, background: EK.goodTint, padding: '3px 9px', borderRadius: 20, marginBottom: 3 }}>
              <Icon name="check" size={12} color={EK.good} sw={3} />
              <span style={{ fontFamily: EFB, fontWeight: 800, fontSize: 10.5, color: EK.good, letterSpacing: .3 }}>Connecté</span>
            </div>
            <div style={{ fontFamily: EFB, fontWeight: 800, fontSize: 15, color: EK.ink, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>fabien@email.com</div>
          </div>
        </div>

        {/* Pseudo éditable */}
        <div style={{ display: 'flex', flexDirection: 'column', gap: 9 }}>
          <PseudoField value="RenardMalin42" focus helper="Ton nom affiché en multijoueur." />
          <Btn full size="md" color={EK.brand} deep={EK.brandDeep} icon="check"
            style={{ borderRadius: 15 }}>Enregistrer le pseudo</Btn>
        </div>

        {/* Note synchro */}
        <div style={{ display: 'flex', alignItems: 'flex-start', gap: 9, background: '#fff', borderRadius: 15, padding: '12px 14px',
          border: `1.5px solid ${EK.line}` }}>
          <Icon name="shield" size={18} color={EK.brand} sw={2.1} style={{ flexShrink: 0, marginTop: 1 }} />
          <span style={{ fontFamily: EFB, fontWeight: 700, fontSize: 12.5, color: EK.inkSoft, lineHeight: 1.4 }}>
            Ta progression et tes niveaux sont sauvegardés sur ce compte.
          </span>
        </div>

        <div style={{ flex: 1 }} />

        {/* Déconnexion */}
        <button className="tq-press-fx" style={{
          height: 54, width: '100%', cursor: 'pointer', borderRadius: 16, background: '#fff', flexShrink: 0,
          border: `2px solid ${EK.line}`, color: EK.bad, fontFamily: EFD, fontWeight: 700, fontSize: 16,
          display: 'inline-flex', alignItems: 'center', justifyContent: 'center', gap: 9,
        }}>
          <Icon name="logout" size={18} color={EK.bad} sw={2.3} /> Se déconnecter
        </button>
      </div>
      <BottomNav active="me" />
    </Screen>
  );
}

Object.assign(window, { AccountAuthScreen, AccountSignedInScreen });
