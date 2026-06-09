/* TriviaQuiz — Écran de jeu : Question + Feedback (correct / faux) */
const { FONT_DISPLAY: GFD, FONT_BODY: GFB, C: GK, CAT: GCAT } = window.TQ;

// state: 'q' (question) | 'correct' | 'wrong'
function GameScreen({ state = 'q', catId = 'HIST', mode = 'solo' }) {
  const multi = mode === 'multi';
  const cat = GCAT[catId];
  const q = {
    n: 4, total: 10,
    cat: cat.name,
    text: 'Quelle cité fut la capitale de l’Empire byzantin ?',
    answers: ['Constantinople', 'Rome', 'Athènes', 'Alexandrie'],
    correct: 0, picked: state === 'wrong' ? 2 : 0,
    why: 'Fondée par Constantin Ier en 330, Constantinople resta capitale impériale plus de 1100 ans.',
  };
  const letters = ['A', 'B', 'C', 'D'];
  const reveal = state !== 'q';

  function answerStyle(i) {
    const isCorrect = i === q.correct, isPicked = i === q.picked;
    let bg = '#fff', bd = GK.line, fg = GK.ink, badgeBg = cat.tint, badgeFg = cat.deep, shadow = '0 3px 10px #0000000a', anim = undefined;
    if (reveal && isCorrect) { bg = GK.goodTint; bd = GK.good; fg = GK.deep || GK.ink; badgeBg = GK.good; badgeFg = '#fff'; shadow = `0 6px 16px ${GK.good}33`; anim = state === 'correct' ? 'tq-pop .45s cubic-bezier(.2,.8,.25,1)' : undefined; }
    if (reveal && state === 'wrong' && isPicked && !isCorrect) { bg = GK.badTint; bd = GK.bad; fg = '#B42121'; badgeBg = GK.bad; badgeFg = '#fff'; shadow = `0 6px 16px ${GK.bad}33`; anim = 'tq-shake .45s'; }
    return { bg, bd, fg, badgeBg, badgeFg, shadow, anim, isCorrect, isPicked };
  }

  return (
    <Screen bg={GK.bg}>
      {/* En-tête coloré catégorie */}
      <div style={{ background: cat.color, padding: '6px 18px 18px', position: 'relative' }}>
        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
          <button className="tq-press-fx" style={{ width: 38, height: 38, borderRadius: 12, border: 'none', background: '#ffffff2e', display: 'flex', alignItems: 'center', justifyContent: 'center', cursor: 'pointer' }}>
            <Icon name="x" size={20} color="#fff" sw={2.6} />
          </button>
          <div style={{ display: 'flex', alignItems: 'center', gap: 7, background: '#ffffff2e', padding: '6px 12px', borderRadius: 20 }}>
            <Icon name={cat.icon} size={16} color="#fff" sw={2.3} />
            <span style={{ fontFamily: GFB, fontWeight: 800, fontSize: 13, color: '#fff' }}>{q.cat}</span>
          </div>
          <Ring size={40} sw={5} pct={0.62} color="#fff" track="#ffffff33" animate={false}>
            <span style={{ fontFamily: GFD, fontWeight: 800, fontSize: 14, color: '#fff' }}>14</span>
          </Ring>
        </div>
        {/* Sous-en-tête : solo = série/rang (sans fin) · multi = progression x/N */}
        {multi ? (
          <>
            <div style={{ display: 'flex', gap: 5, marginTop: 16 }}>
              {Array.from({ length: q.total }).map((_, i) => (
                <div key={i} style={{ flex: 1, height: 6, borderRadius: 3, background: i < q.n ? '#fff' : '#ffffff45' }} />
              ))}
            </div>
            <div style={{ fontFamily: GFB, fontWeight: 800, fontSize: 12, color: '#ffffffdd', marginTop: 8 }}>Question {q.n} / {q.total}</div>
          </>
        ) : (
          <div style={{ display: 'flex', alignItems: 'center', gap: 9, marginTop: 16 }}>
            <div style={{ display: 'flex', alignItems: 'center', gap: 6, background: '#ffffff2e', padding: '6px 12px', borderRadius: 20 }}>
              <Icon name="flame" size={16} color="#fff" fill="#fff" />
              <span style={{ fontFamily: GFD, fontWeight: 800, fontSize: 14, color: '#fff' }}>7</span>
              <span style={{ fontFamily: GFB, fontWeight: 700, fontSize: 12, color: '#ffffffdd' }}>d'affilée</span>
            </div>
            <div style={{ display: 'flex', alignItems: 'center', gap: 6, background: '#ffffff2e', padding: '6px 12px', borderRadius: 20 }}>
              <Icon name="crown" size={15} color="#fff" fill="#fff" />
              <span style={{ fontFamily: GFD, fontWeight: 800, fontSize: 13, color: '#fff' }}>Confirmé</span>
            </div>
            <div style={{ flex: 1 }} />
            <span style={{ fontFamily: GFB, fontWeight: 800, fontSize: 12, color: '#ffffffcc' }}>Sans fin</span>
          </div>
        )}
      </div>

      {/* Carte question */}
      <div style={{ padding: '18px 18px 0' }}>
        <div style={{
          background: '#fff', borderRadius: 22, padding: '20px 20px', marginTop: -2,
          boxShadow: '0 8px 24px #0000000f', animation: state === 'q' ? 'tq-up .5s cubic-bezier(.2,.8,.25,1)' : 'none',
        }}>
          <div style={{ fontFamily: GFD, fontWeight: 700, fontSize: 21, lineHeight: 1.28, color: GK.ink, textWrap: 'balance' }}>{q.text}</div>
        </div>
      </div>

      {/* Réponses */}
      <div className={state === 'q' ? 'tq-stagger' : ''} style={{ flex: 1, padding: '14px 18px 8px', display: 'flex', flexDirection: 'column', gap: 11, overflow: 'hidden' }}>
        {q.answers.map((a, i) => {
          const s = answerStyle(i);
          return (
            <div key={i} className={state === 'q' ? 'tq-press-fx' : ''} style={{
              display: 'flex', alignItems: 'center', gap: 13, padding: '14px 15px', borderRadius: 18,
              background: s.bg, border: `2px solid ${s.bd}`, boxShadow: s.shadow, cursor: 'pointer',
              animation: s.anim, position: 'relative',
            }}>
              <div style={{ width: 34, height: 34, borderRadius: 11, background: s.badgeBg, color: s.badgeFg, display: 'flex', alignItems: 'center', justifyContent: 'center', fontFamily: GFD, fontWeight: 800, fontSize: 16, flexShrink: 0 }}>
                {reveal && s.isCorrect ? <Icon name="check" size={20} color="#fff" sw={3} /> : (reveal && s.isPicked && state === 'wrong' ? <Icon name="x" size={18} color="#fff" sw={3} /> : letters[i])}
              </div>
              <span style={{ fontFamily: GFD, fontWeight: 700, fontSize: 17, color: s.fg }}>{a}</span>
            </div>
          );
        })}
      </div>

      {/* Bandeau feedback (slide-up) */}
      {reveal && (
        <div style={{ position: 'relative' }}>
          {state === 'correct' && <Confetti count={30} origin="bottom" loop={true} />}
          <div style={{
            background: state === 'correct' ? GK.goodTint : GK.badTint, borderTopLeftRadius: 26, borderTopRightRadius: 26,
            padding: '16px 18px 16px', boxShadow: '0 -8px 24px #00000010', animation: 'tq-up .4s cubic-bezier(.2,.8,.25,1)',
          }}>
            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 8 }}>
              <div style={{ display: 'flex', alignItems: 'center', gap: 9 }}>
                <div style={{ width: 30, height: 30, borderRadius: '50%', background: state === 'correct' ? GK.good : GK.bad, display: 'flex', alignItems: 'center', justifyContent: 'center', animation: 'tq-pop .4s' }}>
                  <Icon name={state === 'correct' ? 'check' : 'x'} size={18} color="#fff" sw={3} />
                </div>
                <span style={{ fontFamily: GFD, fontWeight: 800, fontSize: 19, color: state === 'correct' ? GK.good : '#B42121' }}>{state === 'correct' ? 'Bravo !' : 'Raté…'}</span>
              </div>
              <div style={{ display: 'flex', alignItems: 'center', gap: 5, background: '#fff', padding: '6px 12px', borderRadius: 20 }}>
                <Icon name="bolt" size={15} color={state === 'correct' ? GK.good : GK.bad} fill={state === 'correct' ? GK.good : GK.bad} />
                <span style={{ fontFamily: GFD, fontWeight: 800, fontSize: 14, color: state === 'correct' ? GK.good : GK.bad }}>{state === 'correct' ? '+12' : '−8'}</span>
              </div>
            </div>
            <div style={{ fontFamily: GFB, fontWeight: 700, fontSize: 13.5, color: GK.inkSoft, lineHeight: 1.4, marginBottom: 14 }}>{q.why}</div>
            <Btn full color={cat.color} deep={cat.deep} icon="chevR" style={{ flexDirection: 'row-reverse' }}>Continuer</Btn>
          </div>
        </div>
      )}
    </Screen>
  );
}

Object.assign(window, { GameScreen });
