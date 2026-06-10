/* TriviaQuiz — Mode multijoueur : écrans de jeu + résultats */
const { FONT_DISPLAY: GFD2, FONT_BODY: GFB2, C: GC2 } = window.TQ;
const { Phone: MPhone, MScores } = window.MJ;

// "Toutes catégories" → couleur marque
const ALLCAT = { name: 'Toutes catégories', icon: 'sparkle', color: GC2.brand, deep: GC2.brandDeep };

// ── Écran de jeu générique ───────────────────────────────────────────
// state: 'q' | 'wrong' | 'correct'
function MultiGame({ state = 'q', data }) {
  const cat = ALLCAT;
  const reveal = state !== 'q';
  const letters = ['A', 'B', 'C', 'D'];

  function answerStyle(i) {
    const isCorrect = i === data.correct, isPicked = i === data.picked;
    let bg = '#fff', bd = GC2.line, fg = GC2.ink, badgeBg = `${cat.color}1c`, badgeFg = cat.deep, shadow = '0 3px 10px #0000000a', anim;
    if (reveal && isCorrect) { bg = GC2.goodTint; bd = GC2.good; fg = '#15723A'; badgeBg = GC2.good; badgeFg = '#fff'; shadow = `0 6px 16px ${GC2.good}33`; anim = state === 'correct' ? 'tq-pop .45s cubic-bezier(.2,.8,.25,1)' : undefined; }
    if (reveal && state === 'wrong' && isPicked && !isCorrect) { bg = GC2.badTint; bd = GC2.bad; fg = '#B42121'; badgeBg = GC2.bad; badgeFg = '#fff'; shadow = `0 6px 16px ${GC2.bad}33`; anim = 'tq-shake .45s'; }
    return { bg, bd, fg, badgeBg, badgeFg, shadow, anim, isCorrect, isPicked };
  }

  const pct = data.n / data.total;

  return (
    <MPhone h={data.tall || 940}>
      <Screen bg={GC2.bg} style={{ height: '100%' }}>
        {/* En-tête coloré */}
        <div style={{ background: cat.color, padding: '8px 18px 16px', flexShrink: 0 }}>
          <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
            <button className="tq-press-fx" style={{ border: 'none', background: '#ffffff2e', padding: '7px 14px', borderRadius: 13, display: 'inline-flex', alignItems: 'center', gap: 6, cursor: 'pointer' }}>
              <Icon name="x" size={17} color="#fff" sw={2.8} /><span style={{ fontFamily: GFD2, fontWeight: 700, fontSize: 14, color: '#fff' }}>Quitter</span>
            </button>
            <div style={{ display: 'flex', alignItems: 'center', gap: 7, background: '#ffffff2e', padding: '6px 12px', borderRadius: 20, flexShrink: 0 }}>
              <Icon name={cat.icon} size={15} color="#fff" sw={2.3} fill="#fff" />
              <span style={{ fontFamily: GFB2, fontWeight: 800, fontSize: 13, color: '#fff', whiteSpace: 'nowrap' }}>{cat.name}</span>
            </div>
            {state === 'q' ? (
              <Ring size={40} sw={5} pct={data.timerPct ?? 0.1} color="#fff" track="#ffffff33" animate={false}>
                <span style={{ fontFamily: GFD2, fontWeight: 800, fontSize: 13, color: '#fff' }}>{data.timer ?? 1}</span>
              </Ring>
            ) : <div style={{ width: 40 }} />}
          </div>
          {/* progression */}
          <div style={{ marginTop: 14, height: 6, borderRadius: 3, background: '#ffffff40', overflow: 'hidden' }}>
            <div style={{ width: `${Math.max(4, pct * 100)}%`, height: '100%', borderRadius: 3, background: '#fff' }} />
          </div>
          <div style={{ fontFamily: GFB2, fontWeight: 800, fontSize: 12, color: '#ffffffe6', marginTop: 7 }}>Question {data.n} / {data.total}</div>
        </div>

        {/* Carte question */}
        <div style={{ padding: '16px 18px 0', flexShrink: 0 }}>
          <div style={{ background: '#fff', borderRadius: 22, padding: '18px 20px', boxShadow: '0 8px 24px #0000000f' }}>
            <div style={{ fontFamily: GFD2, fontWeight: 700, fontSize: 20, lineHeight: 1.3, color: GC2.ink, textWrap: 'balance' }}>{data.text}</div>
          </div>
        </div>

        {/* Réponses */}
        <div style={{ padding: '13px 18px 6px', display: 'flex', flexDirection: 'column', gap: 10 }}>
          {data.answers.map((a, i) => {
            const s = answerStyle(i);
            return (
              <div key={i} style={{ display: 'flex', alignItems: 'center', gap: 12, padding: '13px 14px', borderRadius: 16, background: s.bg, border: `2px solid ${s.bd}`, boxShadow: s.shadow, animation: s.anim }}>
                <div style={{ width: 32, height: 32, borderRadius: 10, background: s.badgeBg, color: s.badgeFg, display: 'flex', alignItems: 'center', justifyContent: 'center', fontFamily: GFD2, fontWeight: 800, fontSize: 15, flexShrink: 0 }}>
                  {reveal && s.isCorrect ? <Icon name="check" size={19} color="#fff" sw={3} /> : (reveal && s.isPicked && state === 'wrong' ? <Icon name="x" size={17} color="#fff" sw={3} /> : letters[i])}
                </div>
                <span style={{ fontFamily: GFD2, fontWeight: 700, fontSize: 16.5, color: s.fg }}>{a}</span>
              </div>
            );
          })}
        </div>

        {/* Scores + action */}
        <div style={{ flex: 1, minHeight: 0 }} />
        <div style={{ padding: '4px 18px 16px', display: 'flex', flexDirection: 'column', gap: 11, flexShrink: 0 }}>
          {data.scores && <MScores rows={data.scores} />}
          <button className="tq-press-fx" style={{ height: 50, borderRadius: 16, border: `2px solid ${GC2.line}`, background: '#fff', fontFamily: GFD2, fontWeight: 700, fontSize: 15.5, color: GC2.inkSoft, cursor: 'pointer' }}>Terminer la partie</button>
        </div>
      </Screen>
    </MPhone>
  );
}

const GAME_Q = {
  n: 1, total: 120, timer: 1, timerPct: 0.08,
  text: 'Quel pays est à l\u2019origine du judo ?',
  answers: ['La Chine', 'La Corée', 'Le Japon', 'La Thaïlande'],
  correct: 2, picked: -1, scores: null,
};
const GAME_WRONG = {
  n: 4, total: 120, tall: 1010,
  text: 'Quel explorateur est associé à la première circumnavigation du globe ?',
  answers: ['Christophe Colomb', 'Vasco de Gama', 'Fernand de Magellan', 'Marco Polo'],
  correct: 2, picked: 0,
  scores: [
    { name: 'Fabien', col: '#7A5AF8', ok: false, pts: 1712, me: true },
    { name: 'Gabri', col: '#0FA697', ok: false, pts: 790 },
  ],
};
const GAME_CORRECT = {
  n: 5, total: 120, tall: 1010,
  text: 'Qui a sculpté "Le Penseur" ?',
  answers: ['Auguste Rodin', 'Michel-Ange', 'Donatello', 'Lorenzo Bernini'],
  correct: 0, picked: 0,
  scores: [
    { name: 'Fabien', col: '#7A5AF8', ok: true, delta: 918, pts: 2630, me: true },
    { name: 'Gabri', col: '#0FA697', ok: true, delta: 642, pts: 1592 },
  ],
};

const MultiGameQuestion = () => <MultiGame state="q" data={GAME_Q} />;
const MultiGameWrong = () => <MultiGame state="wrong" data={GAME_WRONG} />;
const MultiGameCorrect = () => <MultiGame state="correct" data={GAME_CORRECT} />;

// ════════════════════════════════════════════════════════════════════
// RÉSULTATS — podium festif (2 joueurs)
// ════════════════════════════════════════════════════════════════════
function MultiResults() {
  const podium = [
    { name: 'Gabri', av: 'G', col: '#0FA697', pts: 2271, rank: 2, h: 96, bar: '#C5CCD6', barDeep: '#9AA4B2' },
    { name: 'Fabien', av: 'F', col: '#7A5AF8', pts: 3410, rank: 1, h: 150, bar: '#F5B716', barDeep: '#E5890F', me: true },
  ];
  return (
    <MPhone h={940} dark bg={GC2.navy}>
      <Screen bg={GC2.navy} style={{ height: '100%', position: 'relative', overflow: 'hidden' }}>
        <Confetti count={40} origin="top" loop={true} />
        <div style={{ position: 'absolute', top: -70, left: '50%', transform: 'translateX(-50%)', width: 320, height: 320, borderRadius: '50%', background: 'radial-gradient(circle,#7A5AF855,transparent 65%)' }} />

        {/* En-tête */}
        <div style={{ padding: '8px 18px 0', flexShrink: 0, position: 'relative' }}>
          <button className="tq-press-fx" style={{ border: 'none', background: 'none', padding: '6px 4px', display: 'inline-flex', alignItems: 'center', gap: 3, cursor: 'pointer' }}>
            <Icon name="chevL" size={18} color="#B6ACDF" sw={2.8} /><span style={{ fontFamily: GFD2, fontWeight: 700, fontSize: 15, color: '#B6ACDF' }}>Quitter</span>
          </button>
        </div>
        <div style={{ textAlign: 'center', position: 'relative', flexShrink: 0, marginTop: 4 }}>
          <div style={{ width: 72, height: 72, margin: '0 auto', borderRadius: '50%', background: 'linear-gradient(135deg,#F5B716,#E5890F)', display: 'flex', alignItems: 'center', justifyContent: 'center', boxShadow: '0 12px 30px #f5b71655', animation: 'tq-bob 2.4s ease-in-out infinite' }}>
            <Icon name="trophy" size={38} color="#fff" fill="#ffffff22" sw={2} />
          </div>
          <div style={{ fontFamily: GFD2, fontWeight: 800, fontSize: 27, color: '#fff', marginTop: 10 }}>Résultats</div>
          <div style={{ fontFamily: GFB2, fontWeight: 700, fontSize: 13.5, color: '#B6ACDF', marginTop: 2 }}>Fabien remporte la partie 🎉</div>
        </div>

        {/* Podium */}
        <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'flex-end', gap: 16, padding: '22px 30px 0', flex: 1, minHeight: 0 }}>
          {podium.map(p => (
            <div key={p.rank} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', flex: 1, justifyContent: 'flex-end', height: '100%' }}>
              <div style={{ position: 'relative', marginBottom: 9 }}>
                {p.rank === 1 && <Icon name="crown" size={26} color="#F5B716" fill="#F5B716" style={{ position: 'absolute', top: -22, left: '50%', transform: 'translateX(-50%)' }} />}
                <div style={{ width: p.rank === 1 ? 60 : 50, height: p.rank === 1 ? 60 : 50, borderRadius: '50%', background: p.col, display: 'flex', alignItems: 'center', justifyContent: 'center', color: '#fff', fontFamily: GFD2, fontWeight: 800, fontSize: p.rank === 1 ? 25 : 21, border: '3px solid #fff', boxShadow: `0 6px 16px ${p.col}66` }}>{p.av}</div>
              </div>
              <div style={{ fontFamily: GFD2, fontWeight: 800, fontSize: 16, color: '#fff' }}>{p.name}</div>
              <div style={{ fontFamily: GFB2, fontWeight: 800, fontSize: 12.5, color: '#B6ACDF', marginBottom: 9 }}>{p.pts.toLocaleString('fr-FR')} pts</div>
              <div style={{ width: '100%', height: p.h, borderRadius: '16px 16px 0 0', background: `linear-gradient(180deg,${p.bar},${p.barDeep})`, display: 'flex', justifyContent: 'center', paddingTop: 12, color: '#fff', fontFamily: GFD2, fontWeight: 800, fontSize: 30, boxShadow: 'inset 0 2px 0 #ffffff66' }}>{p.rank}</div>
            </div>
          ))}
        </div>

        {/* Actions */}
        <div style={{ padding: '16px 20px 16px', display: 'flex', flexDirection: 'column', gap: 11, flexShrink: 0 }}>
          <Btn full color={GC2.brand} deep={GC2.brandDeep} icon="play">Rejouer</Btn>
          <button className="tq-press-fx" style={{ height: 54, borderRadius: 18, border: '2px solid #ffffff26', background: '#ffffff12', fontFamily: GFD2, fontWeight: 700, fontSize: 16.5, color: '#fff', cursor: 'pointer', display: 'flex', alignItems: 'center', justifyContent: 'center', gap: 9 }}>
            <Icon name="home" size={19} color="#fff" sw={2.4} />Revenir à l'accueil
          </button>
        </div>
      </Screen>
    </MPhone>
  );
}

Object.assign(window.MJ, { MultiGame, MultiGameQuestion, MultiGameWrong, MultiGameCorrect, MultiResults });
