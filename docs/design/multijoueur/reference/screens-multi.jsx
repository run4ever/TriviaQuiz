/* TriviaQuiz — Mode multijoueur restylé « Vitamine »
   Écrans : Lancement · Créer une partie · Salon · Jeu (question / faux / bon) · Résultats */
const { FONT_DISPLAY: MFD, FONT_BODY: MFB, C: MC, CAT: MCAT, CATS: MCATS } = window.TQ;

// ── Cadre téléphone minimal (fond chaud, pas de tint vert) ───────────
function Phone({ children, h = 892, bg = MC.bg, dark = false }) {
  const ink = dark ? '#fff' : MC.ink;
  return (
    <div style={{
      width: 412, height: h, borderRadius: 44, overflow: 'hidden', position: 'relative',
      background: bg, border: `10px solid ${dark ? '#2A2350' : '#E7E1EE'}`, boxSizing: 'border-box',
      boxShadow: '0 30px 70px rgba(30,20,60,.22)', display: 'flex', flexDirection: 'column',
    }}>
      {/* status bar */}
      <div style={{ height: 44, flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'space-between', padding: '0 26px', position: 'relative' }}>
        <span style={{ fontFamily: MFB, fontWeight: 800, fontSize: 14, color: ink }}>9:30</span>
        <div style={{ position: 'absolute', left: '50%', top: 11, transform: 'translateX(-50%)', width: 92, height: 22, borderRadius: 14, background: dark ? '#1B1733' : '#2A2330' }} />
        <div style={{ display: 'flex', alignItems: 'center', gap: 6, color: ink }}>
          <svg width="17" height="12" viewBox="0 0 17 12" fill={ink}><rect x="0" y="7" width="3" height="5" rx="1"/><rect x="4.5" y="4.5" width="3" height="7.5" rx="1"/><rect x="9" y="2" width="3" height="10" rx="1"/><rect x="13.5" y="0" width="3" height="12" rx="1" opacity=".4"/></svg>
          <svg width="16" height="12" viewBox="0 0 16 12" fill={ink}><path d="M8 11.5L.7 4.2a10.3 10.3 0 0114.6 0L8 11.5z"/></svg>
          <svg width="24" height="12" viewBox="0 0 24 12"><rect x="1" y="1" width="20" height="10" rx="3" fill="none" stroke={ink} strokeWidth="1.2" opacity=".5"/><rect x="3" y="3" width="15" height="6" rx="1.5" fill={ink}/><rect x="22" y="4" width="1.6" height="4" rx=".8" fill={ink} opacity=".5"/></svg>
        </div>
      </div>
      <div style={{ flex: 1, minHeight: 0, display: 'flex', flexDirection: 'column' }}>{children}</div>
      {/* home indicator */}
      <div style={{ height: 26, flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
        <div style={{ width: 132, height: 5, borderRadius: 3, background: dark ? '#ffffff66' : '#1E1B2E40' }} />
      </div>
    </div>
  );
}

// ── En-tête : lien retour + titre centré ─────────────────────────────
function MHeader({ back = 'Retour', title }) {
  return (
    <div style={{ padding: '6px 18px 2px', flexShrink: 0 }}>
      <button className="tq-press-fx" style={{ border: 'none', background: 'none', padding: '6px 4px', display: 'inline-flex', alignItems: 'center', gap: 3, cursor: 'pointer' }}>
        <Icon name="chevL" size={18} color={MC.brand} sw={2.8} />
        <span style={{ fontFamily: MFD, fontWeight: 700, fontSize: 15, color: MC.brand }}>{back}</span>
      </button>
      <div style={{ textAlign: 'center', fontFamily: MFD, fontWeight: 800, fontSize: 23, color: MC.ink, marginTop: 2 }}>{title}</div>
    </div>
  );
}

// ── Champ libellé (pseudo) ───────────────────────────────────────────
function MField({ icon = 'user', label, value, focused = false }) {
  return (
    <div>
      <div style={{ fontFamily: MFB, fontWeight: 800, fontSize: 10.5, letterSpacing: .6, color: MC.inkFaint, marginBottom: 6, marginLeft: 2 }}>{label}</div>
      <div style={{
        display: 'flex', alignItems: 'center', gap: 10, height: 54, padding: '0 14px', borderRadius: 15, background: '#fff',
        border: `1.5px solid ${focused ? MC.brand : MC.line}`,
        boxShadow: focused ? `0 0 0 4px ${MC.brand}22` : '0 2px 8px #0000000a',
      }}>
        <Icon name={icon} size={19} color={focused ? MC.brand : MC.inkFaint} sw={2.2} />
        <span style={{ fontFamily: MFB, fontWeight: 800, fontSize: 16, color: MC.ink }}>{value}</span>
      </div>
    </div>
  );
}

// ── Contrôle segmenté ────────────────────────────────────────────────
function MSeg({ options, value }) {
  return (
    <div style={{ display: 'flex', gap: 0, background: '#fff', borderRadius: 16, padding: 4, border: `1.5px solid ${MC.line}` }}>
      {options.map(o => {
        const on = o === value;
        return (
          <div key={o} style={{
            flex: 1, textAlign: 'center', padding: '11px 4px', borderRadius: 12,
            fontFamily: MFD, fontWeight: 800, fontSize: 15,
            background: on ? MC.brand : 'transparent', color: on ? '#fff' : MC.inkSoft,
            boxShadow: on ? `0 4px 12px ${MC.brand}45` : 'none',
          }}>{o}</div>
        );
      })}
    </div>
  );
}

function MLabel({ children }) {
  return <div style={{ fontFamily: MFD, fontWeight: 800, fontSize: 15, color: MC.ink, margin: '2px 0 0 2px' }}>{children}</div>;
}

// ── Rangée catégorie ─────────────────────────────────────────────────
function MCatRow({ name, icon, color, deep, on = false, all = false }) {
  return (
    <div style={{
      display: 'flex', alignItems: 'center', gap: 12, padding: '11px 14px', borderRadius: 16,
      background: on ? `${MC.brand}16` : '#fff', border: `1.5px solid ${on ? MC.brand : MC.line}`,
      boxShadow: on ? 'none' : '0 2px 8px #0000000a',
    }}>
      <div style={{ width: 34, height: 34, borderRadius: 11, flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
        background: all ? `linear-gradient(135deg,${MC.brand},#9B7DFF)` : color, boxShadow: `0 4px 10px ${(all ? MC.brand : color)}44` }}>
        <Icon name={icon} size={18} color="#fff" sw={2.2} />
      </div>
      <span style={{ flex: 1, fontFamily: MFD, fontWeight: 700, fontSize: 16, color: on ? MC.brandDeep : MC.ink }}>{name}</span>
      {on && <Icon name="check" size={19} color={MC.brand} sw={2.8} />}
    </div>
  );
}

// ── Panneau de scores (bas de l'écran de jeu) ────────────────────────
function MScores({ rows }) {
  return (
    <div style={{ background: '#fff', borderRadius: 18, border: `1.5px solid ${MC.line}`, boxShadow: '0 4px 14px #0000000d', padding: '13px 16px' }}>
      <div style={{ fontFamily: MFB, fontWeight: 800, fontSize: 11, letterSpacing: .6, color: MC.inkFaint, marginBottom: 6 }}>SCORES</div>
      <div style={{ display: 'flex', flexDirection: 'column' }}>
        {rows.map((r, i) => (
          <div key={i} style={{ display: 'flex', alignItems: 'center', gap: 11, padding: '9px 0', borderTop: i ? `1px solid ${MC.line}` : 'none' }}>
            <div style={{ width: 24, height: 24, borderRadius: '50%', flexShrink: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
              background: r.ok == null ? '#EDEAF2' : (r.ok ? MC.goodTint : MC.badTint) }}>
              {r.ok == null ? <div style={{ width: 7, height: 7, borderRadius: '50%', background: MC.inkFaint }} />
                : <Icon name={r.ok ? 'check' : 'x'} size={15} color={r.ok ? MC.good : MC.bad} sw={3} />}
            </div>
            <div style={{ width: 28, height: 28, borderRadius: 9, flexShrink: 0, background: r.col, display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#fff', fontFamily: MFD, fontWeight: 800, fontSize: 14 }}>{r.name[0]}</div>
            <span style={{ flex: 1, fontFamily: MFD, fontWeight: 700, fontSize: 16, color: MC.ink }}>{r.name}{r.me && <span style={{ color: MC.inkFaint, fontWeight: 700 }}> · toi</span>}</span>
            {r.delta != null && <span style={{ fontFamily: MFD, fontWeight: 800, fontSize: 14, color: MC.good }}>+{r.delta}</span>}
            <span style={{ fontFamily: MFD, fontWeight: 800, fontSize: 16, color: MC.ink, minWidth: 48, textAlign: 'right', fontVariantNumeric: 'tabular-nums' }}>{r.pts.toLocaleString('fr-FR')}</span>
          </div>
        ))}
      </div>
    </div>
  );
}

// ════════════════════════════════════════════════════════════════════
// 1 · LANCEMENT
// ════════════════════════════════════════════════════════════════════
function MultiLaunch() {
  return (
    <Phone>
      <Screen bg={MC.bg} style={{ height: '100%' }}>
        <MHeader back="Accueil" title="Jouer à plusieurs" />
        <div style={{ flex: 1, display: 'flex', flexDirection: 'column', padding: '20px 20px 0', gap: 20 }}>
          <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 12, marginTop: 6 }}>
            <div style={{ width: 76, height: 76, borderRadius: 24, background: `linear-gradient(135deg,${MC.brand},#9B7DFF)`, display: 'flex', alignItems: 'center', justifyContent: 'center', boxShadow: `0 14px 30px ${MC.brand}50` }}>
              <Icon name="users" size={40} color="#fff" sw={2.2} />
            </div>
            <div style={{ fontFamily: MFB, fontWeight: 700, fontSize: 14.5, color: MC.inkSoft, textAlign: 'center', maxWidth: 280, lineHeight: 1.45 }}>
              Affronte tes amis en temps réel — crée un salon ou rejoins une partie avec un code.
            </div>
          </div>
          <MField label="PSEUDO" value="Fabien" />
          <div style={{ display: 'flex', flexDirection: 'column', gap: 12, marginTop: 2 }}>
            <Btn full color={MC.brand} deep={MC.brandDeep} icon="users">Créer une partie</Btn>
            <button className="tq-press-fx" style={{ height: 56, borderRadius: 18, border: `2px solid ${MC.line}`, background: '#fff', fontFamily: MFD, fontWeight: 700, fontSize: 17, color: MC.ink, cursor: 'pointer', display: 'flex', alignItems: 'center', justifyContent: 'center', gap: 9 }}>
              <Icon name="chevR" size={19} color={MC.brand} sw={2.6} />Rejoindre une partie
            </button>
          </div>
        </div>
        <BottomNav active="multi" />
      </Screen>
    </Phone>
  );
}

// ════════════════════════════════════════════════════════════════════
// 2 · CRÉER UNE PARTIE (écran long)
// ════════════════════════════════════════════════════════════════════
function MultiCreate() {
  const cats = [{ name: 'Toutes catégories', icon: 'sparkle', all: true, on: true },
    ...MCATS.map(c => ({ name: c.name, icon: c.icon, color: c.color, deep: c.deep }))];
  return (
    <Phone h={1240}>
      <Screen bg={MC.bg} style={{ height: '100%' }}>
        <MHeader back="Retour" title="Créer une partie" />
        <div style={{ flex: 1, display: 'flex', flexDirection: 'column', padding: '14px 20px 22px', gap: 18 }}>
          <MField label="PSEUDO" value="Fabien" focused />
          <div style={{ display: 'flex', flexDirection: 'column', gap: 9 }}>
            <MLabel>Score</MLabel>
            <MSeg options={['Simple', 'Rapidité']} value="Rapidité" />
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 9 }}>
            <MLabel>Nombre de questions</MLabel>
            <MSeg options={['Ouverte', '20', '40', '60']} value="20" />
          </div>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 9 }}>
            <MLabel>Catégorie</MLabel>
            <div style={{ display: 'flex', flexDirection: 'column', gap: 9 }}>
              {cats.map((c, i) => <MCatRow key={i} {...c} />)}
            </div>
          </div>
          <Btn full color={MC.brand} deep={MC.brandDeep} icon="play" style={{ marginTop: 4 }}>Créer la partie</Btn>
        </div>
      </Screen>
    </Phone>
  );
}

// ════════════════════════════════════════════════════════════════════
// 3 · SALON (code à partager)
// ════════════════════════════════════════════════════════════════════
function MultiLobby() {
  const players = [{ name: 'Fabien', col: MC.brand, host: true }];
  return (
    <Phone>
      <Screen bg={MC.bg} style={{ height: '100%' }}>
        <MHeader back="Retour" title="Salon" />
        <div style={{ flex: 1, display: 'flex', flexDirection: 'column', padding: '18px 20px 0', gap: 18 }}>
          {/* Carte code */}
          <div style={{ borderRadius: 22, padding: '20px 18px', background: `linear-gradient(135deg,#EFE9FF,#F7F3FF)`, border: `1.5px solid #E4DBFF`, boxShadow: `0 10px 26px ${MC.brand}1f`, textAlign: 'center', position: 'relative' }}>
            <div style={{ fontFamily: MFD, fontWeight: 800, fontSize: 13, letterSpacing: .5, color: MC.brandDeep, textTransform: 'uppercase' }}>Code de la partie</div>
            <div style={{ fontFamily: MFD, fontWeight: 800, fontSize: 52, letterSpacing: 8, color: MC.brand, lineHeight: 1.1, marginTop: 4 }}>WBWE</div>
            <button className="tq-press-fx" style={{ marginTop: 12, height: 42, borderRadius: 13, border: 'none', background: MC.brand, color: '#fff', fontFamily: MFD, fontWeight: 700, fontSize: 14, padding: '0 18px', display: 'inline-flex', alignItems: 'center', gap: 8, cursor: 'pointer', boxShadow: `0 6px 16px ${MC.brand}55` }}>
              <Icon name="share" size={17} color="#fff" sw={2.3} />Partager le code
            </button>
          </div>
          {/* Résumé paramètres */}
          <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8 }}>
            {['Toutes catégories', 'Partie ouverte', 'Score Rapidité'].map(t => (
              <span key={t} style={{ fontFamily: MFB, fontWeight: 800, fontSize: 12.5, color: MC.inkSoft, background: '#fff', border: `1.5px solid ${MC.line}`, borderRadius: 20, padding: '6px 12px' }}>{t}</span>
            ))}
          </div>
          {/* Joueurs */}
          <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
            <div style={{ fontFamily: MFD, fontWeight: 800, fontSize: 15, color: MC.ink }}>Joueurs <span style={{ color: MC.inkFaint }}>(1)</span></div>
            {players.map(p => (
              <div key={p.name} style={{ display: 'flex', alignItems: 'center', gap: 12, padding: '11px 14px', background: '#fff', borderRadius: 16, border: `1.5px solid ${MC.line}`, boxShadow: '0 2px 8px #0000000a' }}>
                <div style={{ width: 38, height: 38, borderRadius: 12, background: `linear-gradient(135deg,${MC.brand},#EC4899)`, display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#fff', fontFamily: MFD, fontWeight: 800, fontSize: 17 }}>{p.name[0]}</div>
                <span style={{ flex: 1, fontFamily: MFD, fontWeight: 700, fontSize: 17, color: MC.ink }}>{p.name}</span>
                {p.host && <span style={{ display: 'inline-flex', alignItems: 'center', gap: 5, fontFamily: MFB, fontWeight: 800, fontSize: 12, color: MC.gold, background: '#FDF3D6', borderRadius: 20, padding: '4px 11px' }}><Icon name="crown" size={13} color={MC.gold} fill={MC.gold} />Hôte</span>}
              </div>
            ))}
            <div style={{ display: 'flex', alignItems: 'center', gap: 10, padding: '11px 14px', borderRadius: 16, border: `1.5px dashed ${MC.line}`, color: MC.inkFaint }}>
              <div style={{ width: 38, height: 38, borderRadius: 12, border: `1.5px dashed #CFC8DE`, display: 'flex', alignItems: 'center', justifyContent: 'center' }}><Icon name="users" size={18} color={MC.inkFaint} sw={2.2} /></div>
              <span style={{ fontFamily: MFB, fontWeight: 700, fontSize: 14.5 }}>En attente d'autres joueurs…</span>
            </div>
          </div>
          <Btn full color={MC.brand} deep={MC.brandDeep} icon="play" style={{ marginTop: 2 }}>Démarrer la partie</Btn>
        </div>
        <BottomNav active="multi" />
      </Screen>
    </Phone>
  );
}

window.MJ = { Phone, MHeader, MField, MSeg, MLabel, MCatRow, MScores, MultiLaunch, MultiCreate, MultiLobby };
