/* TriviaQuiz — design tokens partagés (plain JS, chargé avant les scripts babel) */
(function () {
  // ── Fonts ──────────────────────────────────────────────
  if (!document.getElementById('tq-fonts')) {
    const l = document.createElement('link');
    l.id = 'tq-fonts';
    l.rel = 'stylesheet';
    l.href = 'https://fonts.googleapis.com/css2?family=Baloo+2:wght@500;600;700;800&family=Nunito:wght@400;600;700;800;900&display=swap';
    document.head.appendChild(l);
  }

  const FONT_DISPLAY = '"Baloo 2", system-ui, sans-serif';
  const FONT_BODY = '"Nunito", system-ui, sans-serif';

  // ── Catégories (multicolore) ───────────────────────────
  // color = teinte vive ; deep = texte/contraste ; tint = fond doux
  const CATS = [
    { id: 'GEO',  name: 'Géographie',       short: 'Géo',     color: '#0FA697', deep: '#0A6F63', tint: '#D6F4EF', icon: 'globe' },
    { id: 'HIST', name: 'Histoire',         short: 'Histoire', color: '#E5890F', deep: '#9C5A05', tint: '#FBEBCF', icon: 'column' },
    { id: 'SCI',  name: 'Sciences & Nature', short: 'Sciences', color: '#7A5AF8', deep: '#553BD0', tint: '#E7E1FF', icon: 'flask' },
    { id: 'ART',  name: 'Art & Culture',    short: 'Art',      color: '#EC4899', deep: '#C42B73', tint: '#FBDFEC', icon: 'palette' },
    { id: 'SPORT',name: 'Sports',           short: 'Sports',   color: '#1FA84B', deep: '#157A36', tint: '#D5F2DD', icon: 'trophy' },
    { id: 'FUN',  name: 'Divertissement',   short: 'Divert.',  color: '#3B82F6', deep: '#1D5FD8', tint: '#DCE9FF', icon: 'film' },
  ];
  const CAT = Object.fromEntries(CATS.map(c => [c.id, c]));

  // ── Rangs (ELO) ────────────────────────────────────────
  const RANKS = [
    { name: 'Novice',   min: 800 },
    { name: 'Apprenti', min: 1000 },
    { name: 'Confirmé', min: 1200 },
    { name: 'Expert',   min: 1400 },
    { name: 'Maître',   min: 1600 },
  ];
  function rankFor(rating) {
    let r = RANKS[0];
    for (const k of RANKS) if (rating >= k.min) r = k;
    return r;
  }
  function rankProgress(rating) {
    const i = RANKS.findIndex(r => r.name === rankFor(rating).name);
    const cur = RANKS[i], next = RANKS[i + 1];
    if (!next) return { pct: 1, next: null, cur };
    return { pct: (rating - cur.min) / (next.min - cur.min), next, cur };
  }

  // ── Palette neutre / surfaces ──────────────────────────
  const C = {
    bg: '#FBF7F2',          // fond chaud très clair
    bgCard: '#FFFFFF',
    ink: '#1E1B2E',         // texte principal (encre violacée)
    inkSoft: '#6B6680',
    inkFaint: '#A7A2B6',
    line: '#ECE6F0',
    good: '#1FA84B',
    goodTint: '#D5F2DD',
    bad: '#EF4444',
    badTint: '#FBE0E0',
    gold: '#F5B716',
    brand: '#7A5AF8',       // accent produit (violet)
    brandDeep: '#553BD0',
    navy: '#1B1733',        // fonds sombres festifs
  };

  // ── Icônes (paths sur viewBox 24×24, stroke-based) ─────
  const ICONS = {
    globe: 'M12 3a9 9 0 100 18 9 9 0 000-18zM3 12h18M12 3c2.5 2.4 2.5 15.6 0 18M12 3c-2.5 2.4-2.5 15.6 0 18',
    column: 'M5 21h14M6 21V9M18 21V9M4 9h16l-8-5-8 5zM9 21V12M15 21V12',
    flask: 'M9 3h6M10 3v6l-5 9a2 2 0 002 3h10a2 2 0 002-3l-5-9V3M7.5 15h9',
    palette: 'M12 3a9 9 0 00-1 17.9c1 .1 1.6-.8 1.2-1.7-.5-1.2.4-2.2 1.6-2.2H17a4 4 0 004-4 9 9 0 00-9-10zM7.5 13a1 1 0 100-2 1 1 0 000 2zM9.5 8.5a1 1 0 100-2 1 1 0 000 2zM14.5 8a1 1 0 100-2 1 1 0 000 2z',
    trophy: 'M7 4h10v4a5 5 0 01-10 0V4zM7 6H4v1a3 3 0 003 3M17 6h3v1a3 3 0 01-3 3M9 20h6M12 14v6M9 20l.5-2h5l.5 2',
    film: 'M4 4h16v16H4zM4 9h16M4 15h16M9 4v16M15 4v16',
    star: 'M12 3l2.6 5.3 5.9.9-4.3 4.1 1 5.8L12 16.9 6.8 19.2l1-5.8L3.5 9.2l5.9-.9z',
    bolt: 'M13 2L4.5 13.5H11l-1 8.5L18.5 10H12z',
    crown: 'M4 8l3.5 3L12 5l4.5 6L20 8l-1.5 10h-13L4 8z',
    flame: 'M12 3c1 3 4 4.5 4 8a4 4 0 01-8 0c0-1.2.5-2 1-2.7C9.2 9.8 10 8 12 3z',
    timer: 'M12 8v5l3 2M12 4a8 8 0 100 16 8 8 0 000-16zM9 2h6',
    check: 'M5 12.5l4.5 4.5L19 6',
    x: 'M6 6l12 12M18 6L6 18',
    chevR: 'M9 6l6 6-6 6',
    chevL: 'M15 6l-6 6 6 6',
    home: 'M4 11l8-7 8 7M6 10v9h12v-9',
    medal: 'M12 13a4 4 0 100-8 4 4 0 000 8zM9 12l-2 9 5-3 5 3-2-9M9 5l3-2 3 2',
    share: 'M16 6l-4-4-4 4M12 2v13M5 12v7a1 1 0 001 1h12a1 1 0 001-1v-7',
    play: 'M7 4l13 8-13 8V4z',
    users: 'M16 19v-1a4 4 0 00-4-4H6a4 4 0 00-4 4v1M9 11a3.5 3.5 0 100-7 3.5 3.5 0 000 7zM22 19v-1a4 4 0 00-3-3.8M16 4.2a4 4 0 010 7.6',
  };

  window.TQ = { FONT_DISPLAY, FONT_BODY, CATS, CAT, RANKS, rankFor, rankProgress, C, ICONS };
})();
