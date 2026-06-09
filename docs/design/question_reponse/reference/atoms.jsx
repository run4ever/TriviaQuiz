/* TriviaQuiz — atomes partagés (animations CSS injectées + composants) */
const { FONT_DISPLAY, FONT_BODY, C, ICONS, CAT, rankFor, rankProgress } = window.TQ;

// ── CSS global (keyframes d'animation montrées dans les maquettes) ──
if (!document.getElementById('tq-anim')) {
  const s = document.createElement('style');
  s.id = 'tq-anim';
  s.textContent = `
  @keyframes tq-rise { from { opacity:0; transform: translateY(16px) scale(.98); } to { opacity:1; transform:none; } }
  @keyframes tq-up   { from { transform: translateY(16px); } to { transform: translateY(0); } }
  @keyframes tq-pop  { 0%{transform:scale(1);} 45%{transform:scale(1.07);} 100%{transform:scale(1);} }
  @keyframes tq-shake{ 0%,100%{transform:translateX(0);} 20%{transform:translateX(-7px);} 40%{transform:translateX(6px);} 60%{transform:translateX(-4px);} 80%{transform:translateX(3px);} }
  @keyframes tq-pulse{ 0%,100%{transform:scale(1);} 50%{transform:scale(1.04);} }
  @keyframes tq-ring { to { stroke-dashoffset: var(--tq-off); } }
  @keyframes tq-bob  { 0%,100%{transform:translateY(0);} 50%{transform:translateY(-5px);} }
  @keyframes tq-conf { to { transform: translate(var(--dx), var(--dy)) rotate(var(--rz)); opacity:0; } }
  @keyframes tq-shine{ to { background-position: 200% 0; } }
  @keyframes tq-press{ 50%{ transform: translateY(2px) scale(.97);} }
  @keyframes tq-glow { 0%,100%{ box-shadow:0 8px 24px rgba(122,90,248,.35);} 50%{ box-shadow:0 12px 34px rgba(122,90,248,.55);} }
  .tq-stagger > * { animation: tq-rise .5s cubic-bezier(.2,.8,.25,1); }
  @media (prefers-reduced-motion: reduce){ .tq-stagger > *{ animation: none; } }
  .tq-stagger > *:nth-child(1){ animation-delay:.05s; }
  .tq-stagger > *:nth-child(2){ animation-delay:.14s; }
  .tq-stagger > *:nth-child(3){ animation-delay:.23s; }
  .tq-stagger > *:nth-child(4){ animation-delay:.32s; }
  .tq-stagger > *:nth-child(5){ animation-delay:.41s; }
  .tq-stagger > *:nth-child(6){ animation-delay:.50s; }
  .tq-press-fx:active { animation: tq-press .18s; }
  * { -webkit-tap-highlight-color: transparent; }
  `;
  document.head.appendChild(s);
}

function Icon({ name, size = 24, color = 'currentColor', sw = 2, fill = 'none', style }) {
  return (
    <svg width={size} height={size} viewBox="0 0 24 24" fill={fill} stroke={color}
      strokeWidth={sw} strokeLinecap="round" strokeLinejoin="round" style={style}>
      <path d={ICONS[name]} />
    </svg>
  );
}

// Bouton plein, "chunky" avec ombre portée colorée et enfoncement au tap
function Btn({ children, color = C.brand, deep, full, size = 'lg', icon, style, onClick }) {
  const d = deep || color;
  const h = size === 'lg' ? 60 : size === 'sm' ? 42 : 52;
  const fs = size === 'lg' ? 20 : size === 'sm' ? 15 : 18;
  return (
    <button className="tq-press-fx" onClick={onClick} style={{
      height: h, width: full ? '100%' : 'auto', padding: '0 26px', border: 'none',
      borderRadius: 18, background: color, color: '#fff', fontFamily: FONT_DISPLAY,
      fontWeight: 700, fontSize: fs, cursor: 'pointer', position: 'relative',
      boxShadow: `0 6px 0 ${d}, 0 12px 22px ${color}55`,
      display: 'inline-flex', alignItems: 'center', justifyContent: 'center', gap: 10,
      letterSpacing: .2, ...style,
    }}>
      {icon && <Icon name={icon} size={fs + 3} sw={2.6} />}
      {children}
    </button>
  );
}

// Pastille d'icône catégorie (carré arrondi coloré)
function CatBadge({ cat, size = 46, r = 14, on = '#fff', bg }) {
  return (
    <div style={{
      width: size, height: size, borderRadius: r, background: bg || cat.color,
      display: 'flex', alignItems: 'center', justifyContent: 'center', flexShrink: 0,
      boxShadow: `0 6px 14px ${cat.color}44`,
    }}>
      <Icon name={cat.icon} size={size * 0.5} color={on} sw={2.2} />
    </div>
  );
}

// Anneau de progression (timer / rang) animé via stroke-dashoffset
function Ring({ size = 64, sw = 7, pct = 0.7, color = C.brand, track = '#0000', children, animate = true }) {
  const r = (size - sw) / 2, c = 2 * Math.PI * r;
  const off = c * (1 - pct);
  return (
    <div style={{ position: 'relative', width: size, height: size }}>
      <svg width={size} height={size} style={{ transform: 'rotate(-90deg)' }}>
        <circle cx={size / 2} cy={size / 2} r={r} fill="none" stroke={track || '#00000014'} strokeWidth={sw} />
        <circle cx={size / 2} cy={size / 2} r={r} fill="none" stroke={color} strokeWidth={sw}
          strokeLinecap="round" strokeDasharray={c}
          strokeDashoffset={animate ? c : off}
          style={animate ? { animation: 'tq-ring 1s cubic-bezier(.3,.8,.3,1) .2s forwards', '--tq-off': off } : {}} />
      </svg>
      <div style={{ position: 'absolute', inset: 0, display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
        {children}
      </div>
    </div>
  );
}

// Petite étiquette stat (icône + valeur)
function Stat({ icon, value, label, color = C.ink }) {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 3 }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: 5, color }}>
        <Icon name={icon} size={17} sw={2.4} color={color} />
        <span style={{ fontFamily: FONT_DISPLAY, fontWeight: 800, fontSize: 18 }}>{value}</span>
      </div>
      <span style={{ fontFamily: FONT_BODY, fontWeight: 700, fontSize: 11, color: C.inkFaint, letterSpacing: .3 }}>{label}</span>
    </div>
  );
}

// Confettis — éclats colorés projetés depuis un point
function Confetti({ count = 36, origin = 'top', loop = true }) {
  const cols = ['#0FA697', '#E5890F', '#7A5AF8', '#EC4899', '#1FA84B', '#3B82F6', '#F5B716'];
  const pieces = React.useMemo(() => Array.from({ length: count }, (_, i) => {
    const ang = (Math.random() * 2 - 1) * Math.PI * 0.9;
    const dist = 90 + Math.random() * 190;
    return {
      dx: Math.sin(ang) * dist, dy: (origin === 'top' ? 1 : -1) * (Math.abs(Math.cos(ang)) * dist + 40),
      rz: (Math.random() * 720 - 360) + 'deg', col: cols[i % cols.length],
      w: 7 + Math.random() * 7, h: 9 + Math.random() * 9, delay: Math.random() * (loop ? 2.2 : 0.25),
      round: Math.random() > 0.6,
    };
  }), [count]);
  return (
    <div style={{ position: 'absolute', inset: 0, overflow: 'hidden', pointerEvents: 'none', zIndex: 5 }}>
      {pieces.map((p, i) => (
        <span key={i} style={{
          position: 'absolute', left: '50%', top: origin === 'top' ? '14%' : '78%',
          width: p.w, height: p.h, background: p.col, borderRadius: p.round ? '50%' : 2,
          '--dx': p.dx + 'px', '--dy': p.dy + 'px', '--rz': p.rz,
          animation: `tq-conf 1.5s cubic-bezier(.2,.6,.4,1) ${p.delay}s ${loop ? 'infinite' : 'forwards'}`,
        }} />
      ))}
    </div>
  );
}

// Barre de navigation basse
function BottomNav({ active = 'home' }) {
  const items = [
    { id: 'home', icon: 'home', label: 'Accueil' },
    { id: 'multi', icon: 'users', label: 'Multijoueur' },
    { id: 'me', icon: 'star', label: 'Profil' },
  ];
  return (
    <div style={{
      display: 'flex', justifyContent: 'space-around', alignItems: 'center',
      padding: '8px 12px 6px', background: '#fff', borderTop: `1.5px solid ${C.line}`,
    }}>
      {items.map(it => {
        const on = it.id === active;
        return (
          <div key={it.id} style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 3, padding: '4px 16px' }}>
            <Icon name={it.icon} size={24} sw={on ? 2.6 : 2.1} color={on ? C.brand : C.inkFaint} fill={on ? C.brand : 'none'} />
            <span style={{ fontFamily: FONT_BODY, fontWeight: 800, fontSize: 11, color: on ? C.brand : C.inkFaint }}>{it.label}</span>
          </div>
        );
      })}
    </div>
  );
}

// Conteneur "écran" (fond + colonne flex)
function Screen({ children, bg = C.bg, pad = 0, style }) {
  return (
    <div style={{
      height: '100%', background: bg, fontFamily: FONT_BODY, color: C.ink,
      display: 'flex', flexDirection: 'column', padding: pad, boxSizing: 'border-box', ...style,
    }}>{children}</div>
  );
}

Object.assign(window, { Icon, Btn, CatBadge, Ring, Stat, Confetti, BottomNav, Screen });
