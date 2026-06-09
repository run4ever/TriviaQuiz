/* TriviaQuiz — Écran : Mon Profil */
const { FONT_DISPLAY: PFD, FONT_BODY: PFB, C: PK, CAT: PCAT, CATS: PCATS, rankFor: prk, rankProgress: prkp } = window.TQ;

// Mois abrégés FR (≤ 4 lettres + point quand abrégé)
const PMONTHS = ['janv.', 'févr.', 'mars', 'avril', 'mai', 'juin', 'juil.', 'août', 'sept.', 'oct.', 'nov.', 'déc.'];
const pfmtDate = (dt) => `${dt.d} ${PMONTHS[dt.m - 1]} ${dt.y}`;

// Données de démo — rating + meilleure série (longueur) + date où elle a été atteinte
const PROFILE = {
  pseudo: 'Fabien',
  global: { rating: 1141, best: 14, last: { d: 8,  m: 6, y: 2026 } },
  cats: {
    GEO:   { rating: 1024, best: 9,  last: { d: 7,  m: 6, y: 2026 } },
    HIST:  { rating: 1187, best: 12, last: { d: 8,  m: 6, y: 2026 } },
    SCI:   { rating: 1099, best: 8,  last: { d: 5,  m: 6, y: 2026 } },
    ART:   { rating: 1062, best: 7,  last: { d: 2,  m: 6, y: 2026 } },
    SPORT: { rating: 1021, best: 6,  last: { d: 28, m: 5, y: 2026 } },
    FUN:   { rating: 976,  best: 5,  last: { d: 3,  m: 6, y: 2026 } },
  },
};

function ProfileScreen() {
  const g = PROFILE.global;
  const grank = prk(g.rating);
  const gprog = prkp(g.rating);

  return (
    <Screen bg={PK.bg}>
      {/* En-tête */}
      <div style={{ padding: '6px 18px 2px', textAlign: 'center', flexShrink: 0 }}>
        <div style={{ fontFamily: PFD, fontWeight: 800, fontSize: 21, color: PK.ink }}>Mon profil</div>
      </div>

      <div style={{ flex: 1, overflow: 'hidden', padding: '8px 18px 12px', display: 'flex', flexDirection: 'column', gap: 10 }}>
        {/* Carte compte — pseudo */}
        <button className="tq-press-fx" style={{
          width: '100%', border: 'none', cursor: 'pointer', textAlign: 'left', flexShrink: 0,
          background: '#fff', borderRadius: 18, padding: '11px 14px', display: 'flex', alignItems: 'center', gap: 12,
          boxShadow: '0 4px 14px #0000000a',
        }}>
          <div style={{ width: 44, height: 44, borderRadius: 14, background: 'linear-gradient(135deg,#7A5AF8,#EC4899)', display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#fff', fontFamily: PFD, fontWeight: 800, fontSize: 20, flexShrink: 0 }}>
            {PROFILE.pseudo[0]}
          </div>
          <div style={{ flex: 1, minWidth: 0 }}>
            <div style={{ fontFamily: PFB, fontWeight: 800, fontSize: 10.5, color: PK.inkFaint, letterSpacing: .5, textTransform: 'uppercase' }}>Pseudo</div>
            <div style={{ fontFamily: PFD, fontWeight: 800, fontSize: 18, color: PK.ink, lineHeight: 1.1 }}>{PROFILE.pseudo}</div>
          </div>
          <div style={{ display: 'flex', alignItems: 'center', gap: 4, color: PK.inkFaint }}>
            <Icon name="chevR" size={20} color={PK.inkFaint} sw={2.4} />
          </div>
        </button>

        {/* Niveau global (héros) */}
        <div style={{ borderRadius: 22, padding: '13px 18px', position: 'relative', overflow: 'hidden', flexShrink: 0, background: 'linear-gradient(140deg,#231C46 0%,#3A2A7A 52%,#5B3FD6 100%)', boxShadow: '0 12px 26px #2a1f5a3a' }}>
          <div style={{ position: 'absolute', top: -40, right: -30, width: 150, height: 150, borderRadius: '50%', background: '#ffffff12' }} />
          <div style={{ display: 'flex', alignItems: 'center', gap: 15, position: 'relative' }}>
            <Ring size={66} sw={8} pct={gprog.pct} color={PK.gold} track="#ffffff24" animate={false}>
              <Icon name="crown" size={22} color={PK.gold} fill={PK.gold} />
            </Ring>
            <div style={{ flex: 1, minWidth: 0 }}>
              <div style={{ fontFamily: PFB, fontWeight: 800, fontSize: 10.5, color: '#C9BEFF', letterSpacing: 1.1, textTransform: 'uppercase' }}>Niveau global</div>
              <div style={{ fontFamily: PFD, fontWeight: 800, fontSize: 24, color: '#fff', lineHeight: 1.1, margin: '1px 0 2px' }}>{grank.name}</div>
              <div style={{ display: 'flex', alignItems: 'baseline', gap: 7 }}>
                <span style={{ fontFamily: PFD, fontWeight: 800, fontSize: 21, color: PK.gold }}>{g.rating}</span>
                <span style={{ fontFamily: PFB, fontWeight: 700, fontSize: 11.5, color: '#C9BEFF' }}>pts{gprog.next ? ` · ${gprog.next.min - g.rating} pour ${gprog.next.name}` : ' · rang max'}</span>
              </div>
            </div>
          </div>
          <div style={{ marginTop: 11, paddingTop: 10, borderTop: '1px solid #ffffff22', display: 'flex', alignItems: 'center', gap: 8, whiteSpace: 'nowrap', position: 'relative' }}>
            <Icon name="flame" size={15} color="#fff" fill="#fff" />
            <span style={{ fontFamily: PFD, fontWeight: 800, fontSize: 14, color: '#fff' }}>{g.best}</span>
            <span style={{ fontFamily: PFB, fontWeight: 700, fontSize: 11.5, color: '#C9BEFF' }}>Meilleure série le {pfmtDate(g.last)}</span>
          </div>
        </div>

        {/* Par catégorie */}
        <div style={{ fontFamily: PFD, fontWeight: 800, fontSize: 15, color: PK.ink, flexShrink: 0 }}>Par catégorie</div>
        <div style={{ flex: 1, minHeight: 0, display: 'grid', gridTemplateColumns: '1fr 1fr', gridAutoRows: '1fr', gap: 11 }}>
          {PCATS.map(cat => {
            const d = PROFILE.cats[cat.id];
            const r = prk(d.rating);
            return (
              <div key={cat.id} style={{
                background: cat.color, borderRadius: 18, padding: '11px 13px', color: '#fff',
                boxShadow: `0 5px 0 ${cat.deep}, 0 10px 18px ${cat.color}40`,
                display: 'flex', flexDirection: 'column', minHeight: 0,
              }}>
                <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                  <div style={{ width: 30, height: 30, borderRadius: 10, background: '#ffffff2e', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                    <Icon name={cat.icon} size={17} color="#fff" sw={2.3} />
                  </div>
                  <div style={{ display: 'inline-flex', alignItems: 'center', gap: 4, background: '#ffffff2e', padding: '3px 8px', borderRadius: 20 }}>
                    <Icon name="crown" size={10} color="#fff" fill="#fff" />
                    <span style={{ fontFamily: PFB, fontWeight: 800, fontSize: 9.5, color: '#fff' }}>{r.name}</span>
                  </div>
                </div>
                <div style={{ fontFamily: PFD, fontWeight: 800, fontSize: 14.5, lineHeight: 1.05, marginTop: 5 }}>{cat.name}</div>
                <div style={{ display: 'flex', alignItems: 'baseline', gap: 6, marginTop: 1 }}>
                  <span style={{ fontFamily: PFD, fontWeight: 800, fontSize: 22, lineHeight: 1 }}>{d.rating}</span>
                  <span style={{ fontFamily: PFB, fontWeight: 700, fontSize: 10.5, color: '#ffffffcc' }}>pts</span>
                </div>
                <div style={{ flex: 1 }} />
                <div style={{ marginTop: 6, paddingTop: 7, borderTop: '1px solid #ffffff2e' }}>
                  <div style={{ fontFamily: PFB, fontWeight: 700, fontSize: 9.5, color: '#ffffffcc' }}>Meilleure série :</div>
                  <div style={{ display: 'flex', alignItems: 'center', gap: 5, marginTop: 2, whiteSpace: 'nowrap' }}>
                    <Icon name="flame" size={13} color="#fff" fill="#fff" />
                    <span style={{ fontFamily: PFB, fontWeight: 700, fontSize: 11, color: '#fff' }}>
                      <b style={{ fontFamily: PFD, fontWeight: 800, fontSize: 12.5 }}>{d.best}</b>, le {pfmtDate(d.last)}
                    </span>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </div>

      <BottomNav active="me" />
    </Screen>
  );
}

Object.assign(window, { ProfileScreen });
