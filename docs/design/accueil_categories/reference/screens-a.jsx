/* TriviaQuiz — Écrans : Accueil + Sélection de catégorie */
const { FONT_DISPLAY: FD, FONT_BODY: FB, C: K, CATS: ALLCATS, rankFor: rk, rankProgress: rkp } = window.TQ;

// ── Niveau (ELO) par catégorie ─────────────────────────────
// 750 = niveau attribué à chaque catégorie à l'inscription.
const SIGNUP_RATING = 750;
const CAT_RATINGS = { GEO: 1280, HIST: 1450, SCI: 1180, ART: 820, SPORT: 760, FUN: 1240 };
// Seuils ajustables des blocs de l'Accueil :
const STRENGTH_MIN = 1200; // « Tes points forts » : catégories au niveau ≥ ce seuil
const WEAKNESS_MAX = 1000; // « Tes axes d'amélioration » : catégories au niveau ≤ ce seuil

const catRating = (id) => CAT_RATINGS[id] ?? SIGNUP_RATING;
const catLevel = (id) => rk(catRating(id)).name;
const ratedCats = ALLCATS.map(c => ({ ...c, rating: catRating(c.id) }));
const STRENGTHS = ratedCats.filter(c => c.rating >= STRENGTH_MIN).sort((a, b) => b.rating - a.rating).slice(0, 3);
const WEAKNESSES = ratedCats.filter(c => c.rating <= WEAKNESS_MAX).sort((a, b) => a.rating - b.rating).slice(0, 3);

// Pastille « niveau » d'une catégorie sur fond clair (couronne + libellé teinté)
function LevelTag({ cat }) {
  return (
    <div style={{ display: 'inline-flex', alignItems: 'center', gap: 4, background: cat.tint, padding: '2px 9px', borderRadius: 20 }}>
      <Icon name="crown" size={11} color={cat.deep} fill={cat.deep} />
      <span style={{ fontFamily: FB, fontWeight: 800, fontSize: 10, color: cat.deep }}>{rk(cat.rating).name}</span>
    </div>
  );
}

// Ligne de 3 catégories (points forts / axes d'amélioration)
function CatPicks({ cats }) {
  return (
    <div style={{ display: 'flex', gap: 10 }}>
      {cats.map(c => (
        <div key={c.id} style={{ flex: '0 0 calc(33.333% - 7px)', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 6 }}>
          <CatBadge cat={c} size={48} r={15} />
          <span style={{ fontFamily: FB, fontWeight: 800, fontSize: 11, color: K.ink }}>{c.short}</span>
          <LevelTag cat={c} />
        </div>
      ))}
    </div>
  );
}

// ───────────────────────── ACCUEIL ─────────────────────────
function HomeScreen() {
  const rating = 1284;
  const rank = rk(rating);
  const prog = rkp(rating);
  const greeting = new Date().getHours() >= 17 ? 'Bonsoir,' : 'Bonjour,';
  return (
    <Screen bg={K.bg}>
      <div style={{ flex: 1, overflow: 'hidden', padding: '14px 18px 4px' }}>
        {/* En-tête joueur */}
        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 18 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 12 }}>
            <div style={{
              width: 46, height: 46, borderRadius: 16, background: 'linear-gradient(135deg,#7A5AF8,#EC4899)',
              display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#fff',
              fontFamily: FD, fontWeight: 800, fontSize: 20, boxShadow: '0 6px 16px #7A5AF855',
            }}>L</div>
            <div>
              <div style={{ fontFamily: FB, fontWeight: 700, fontSize: 13, color: K.inkSoft }}>{greeting}</div>
              <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 19, lineHeight: 1, marginTop: 2 }}>Léa</div>
            </div>
          </div>
          <div style={{
            display: 'flex', alignItems: 'center', gap: 6, background: '#fff', padding: '8px 13px',
            borderRadius: 14, boxShadow: '0 3px 10px #0000000d',
          }}>
            <Icon name="flame" size={19} color={K.gold} fill={K.gold} />
            <span style={{ fontFamily: FD, fontWeight: 800, fontSize: 17 }}>7</span>
          </div>
        </div>

        {/* Carte rang (héros) */}
        <div style={{
          borderRadius: 26, padding: '20px 20px 18px', position: 'relative', overflow: 'hidden',
          background: 'linear-gradient(140deg,#231C46 0%,#3A2A7A 55%,#5B3FD6 100%)',
          boxShadow: '0 16px 34px #2a1f5a44', marginBottom: 18,
        }}>
          <div style={{ position: 'absolute', right: -26, top: -26, width: 130, height: 130, borderRadius: '50%', background: '#ffffff12' }} />
          <div style={{ position: 'absolute', right: 22, bottom: -34, width: 90, height: 90, borderRadius: '50%', background: '#ffffff0d' }} />
          <div style={{ display: 'flex', alignItems: 'center', gap: 16, position: 'relative' }}>
            <Ring size={84} sw={8} pct={prog.pct} color={K.gold} track="#ffffff24">
              <Icon name="crown" size={34} color={K.gold} fill={K.gold} />
            </Ring>
            <div style={{ flex: 1 }}>
              <div style={{ fontFamily: FB, fontWeight: 800, fontSize: 12, color: '#C9BEFF', letterSpacing: 1.2, textTransform: 'uppercase' }}>Niveau actuel</div>
              <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 26, color: '#fff', lineHeight: 1.05, margin: '1px 0 4px' }}>{rank.name}</div>
              <div style={{ display: 'flex', alignItems: 'baseline', gap: 6 }}>
                <span style={{ fontFamily: FD, fontWeight: 800, fontSize: 22, color: K.gold }}>{rating}</span>
                <span style={{ fontFamily: FB, fontWeight: 700, fontSize: 12, color: '#C9BEFF' }}>pts · {prog.next ? `${prog.next.min - rating} pour ${prog.next.name}` : 'rang max'}</span>
              </div>
            </div>
          </div>
        </div>

        {/* CTA principal */}
        <button className="tq-press-fx" style={{
          width: '100%', border: 'none', borderRadius: 22, padding: '16px 20px', cursor: 'pointer',
          background: 'linear-gradient(135deg,#7A5AF8,#9168FF)', color: '#fff', textAlign: 'left',
          boxShadow: '0 8px 0 #553BD0, 0 16px 30px #7A5AF855', display: 'flex', alignItems: 'center',
          justifyContent: 'space-between', marginBottom: 12, animation: 'tq-glow 2.6s ease-in-out infinite',
        }}>
          <div>
            <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 22, lineHeight: 1 }}>Jouer</div>
            <div style={{ fontFamily: FB, fontWeight: 700, fontSize: 13, opacity: .9, marginTop: 4 }}>Solo · toutes catégories</div>
          </div>
          <div style={{ width: 46, height: 46, borderRadius: '50%', background: '#ffffff2e', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
            <Icon name="play" size={22} color="#fff" fill="#fff" />
          </div>
        </button>

        {/* Jouer une catégorie — pleine largeur, fond noir */}
        <button className="tq-press-fx" style={{
          width: '100%', border: 'none', borderRadius: 22, padding: '16px 20px', cursor: 'pointer',
          background: '#161320', color: '#fff', textAlign: 'left',
          boxShadow: '0 8px 0 #000000, 0 16px 30px #00000055', display: 'flex', alignItems: 'center',
          gap: 14, marginBottom: 18,
        }}>
          <div style={{ display: 'flex' }}>
            {ALLCATS.map((c, i) => (
              <div key={c.id} style={{ width: 16, height: 34, borderRadius: 5, background: c.color, marginLeft: i ? -7 : 0, border: '2px solid #ffffff55', boxShadow: '0 2px 5px #00000033' }} />
            ))}
          </div>
          <div style={{ flex: 1 }}>
            <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 20, lineHeight: 1.05 }}>Jouer une catégorie</div>
            <div style={{ fontFamily: FB, fontWeight: 700, fontSize: 13, opacity: .82, marginTop: 3 }}>Au choix parmi 6</div>
          </div>
          <div style={{ width: 46, height: 46, borderRadius: '50%', background: '#ffffff2e', display: 'flex', alignItems: 'center', justifyContent: 'center', flexShrink: 0 }}>
            <Icon name="play" size={20} color="#fff" fill="#fff" />
          </div>
        </button>

        {/* Tes points forts */}
        {STRENGTHS.length > 0 && (
          <div style={{ marginBottom: 16 }}>
            <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 15, color: K.ink, marginBottom: 10 }}>Tes points forts</div>
            <CatPicks cats={STRENGTHS} />
          </div>
        )}

        {/* Tes axes d'amélioration */}
        {WEAKNESSES.length > 0 && (
          <div>
            <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 15, color: K.ink, marginBottom: 10 }}>Tes axes d'amélioration</div>
            <CatPicks cats={WEAKNESSES} />
          </div>
        )}
      </div>
      <BottomNav active="home" />
    </Screen>
  );
}

// ───────────────────── SÉLECTION CATÉGORIE ─────────────────────
function CategoryScreen() {
  return (
    <Screen bg={K.bg}>
      {/* en-tête */}
      <div style={{ padding: '8px 18px 6px', display: 'flex', alignItems: 'center', gap: 12 }}>
        <button className="tq-press-fx" style={{ width: 40, height: 40, borderRadius: 13, border: 'none', background: '#fff', boxShadow: '0 3px 10px #0000000d', display: 'flex', alignItems: 'center', justifyContent: 'center', cursor: 'pointer' }}>
          <Icon name="chevL" size={22} color={K.ink} />
        </button>
        <div>
          <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 22, lineHeight: 1 }}>Choisis un thème</div>
          <div style={{ fontFamily: FB, fontWeight: 700, fontSize: 13, color: K.inkFaint, marginTop: 3 }}>Sur quoi veux-tu briller ?</div>
        </div>
      </div>

      <div className="tq-stagger" style={{ flex: 1, overflow: 'hidden', padding: '12px 18px 8px', display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 13, alignContent: 'start' }}>
        {ALLCATS.map(c => (
          <button key={c.id} className="tq-press-fx" style={{
            border: 'none', cursor: 'pointer', borderRadius: 22, padding: '16px 15px', textAlign: 'left',
            background: c.color, color: '#fff', position: 'relative', overflow: 'hidden',
            boxShadow: `0 7px 0 ${c.deep}, 0 14px 24px ${c.color}44`, minHeight: 128,
            display: 'flex', flexDirection: 'column', justifyContent: 'space-between',
          }}>
            <div style={{ position: 'absolute', right: -16, top: -16, width: 78, height: 78, borderRadius: '50%', background: '#ffffff1f' }} />
            <div style={{ width: 46, height: 46, borderRadius: 14, background: '#ffffff2e', display: 'flex', alignItems: 'center', justifyContent: 'center', position: 'relative' }}>
              <Icon name={c.icon} size={26} color="#fff" sw={2.3} />
            </div>
            <div style={{ position: 'relative' }}>
              <div style={{ fontFamily: FD, fontWeight: 800, fontSize: 18, lineHeight: 1.05 }}>{c.name}</div>
              <div style={{ display: 'inline-flex', alignItems: 'center', gap: 5, marginTop: 7, background: '#ffffff2e', padding: '3px 9px', borderRadius: 20 }}>
                <Icon name="crown" size={13} color="#fff" fill="#fff" />
                <span style={{ fontFamily: FB, fontWeight: 800, fontSize: 11 }}>{catLevel(c.id)}</span>
              </div>
            </div>
          </button>
        ))}
      </div>
    </Screen>
  );
}

Object.assign(window, { HomeScreen, CategoryScreen });
