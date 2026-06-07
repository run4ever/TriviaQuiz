package com.fabien.trivia.data

object QuestionRepository {
    val questions = listOf(

        // ===================== GÉOGRAPHIE =====================
        Question(
            text = "Quelle est la capitale de l'Australie ?",
            options = listOf("Canberra", "Sydney", "Melbourne", "Brisbane"),
            correctIndex = 0,
            rating = 1150,
            explanation = "La capitale de l'Australie est Canberra, et non Sydney comme beaucoup le croient. Canberra a été construite de toutes pièces comme capitale fédérale, inaugurée en 1913, suite au compromis entre Sydney et Melbourne qui se disputaient ce titre. La ville a été conçue par les architectes américains Walter Burley Griffin et Marion Mahony Griffin, lauréats d'un concours international en 1912.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel est le plus grand océan du monde ?",
            options = listOf("Atlantique", "Indien", "Arctique", "Pacifique"),
            correctIndex = 3,
            rating = 900,
            explanation = "L'océan Pacifique est le plus grand et le plus profond des océans, couvrant environ 165 millions de km², soit plus que toutes les terres émergées réunies. Son nom lui fut donné par l'explorateur Magellan qui le trouva calme lors de sa traversée en 1520. Il abrite la fosse des Mariannes, le point le plus profond de la Terre à 11 034 m.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Sur quel continent se trouve le désert du Sahara ?",
            options = listOf("Asie", "Australie", "Amérique du Sud", "Afrique"),
            correctIndex = 3,
            rating = 650,
            explanation = "Le désert du Sahara se trouve en Afrique du Nord. Avec environ 9 millions de km², c'est le plus grand désert chaud du monde. Contrairement aux idées reçues, seulement 25% de sa surface est couverte de dunes de sable ; le reste est principalement composé de roches et de gravier. Il s'étend sur onze pays africains, dont l'Algérie, l'Égypte, le Mali ou le Tchad.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel est le fleuve le plus long du monde ?",
            options = listOf("Amazone", "Mississippi", "Yangtsé", "Nil"),
            correctIndex = 3,
            rating = 1200,
            explanation = "Le Nil est traditionnellement considéré comme le fleuve le plus long du monde avec 6 650 km, devant l'Amazone (6 400 km). Cette classification est toutefois sujette à débat selon les critères de mesure utilisés — certaines études récentes accordent la première place à l'Amazone. Le Nil traverse onze pays africains et fut le berceau de la civilisation égyptienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est la monnaie officielle du Japon ?",
            options = listOf("Yuan", "Won", "Yen", "Ringgit"),
            correctIndex = 2,
            rating = 950,
            explanation = "Le yen est la monnaie officielle du Japon depuis 1871. Son symbole est ¥ et son code ISO est JPY. Le mot \"yen\" signifie \"objet rond\" en japonais, en référence aux anciennes pièces de monnaie. Le yen est l'une des trois monnaies les plus échangées au monde, après le dollar américain et l'euro.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est la capitale du Canada ?",
            options = listOf("Toronto", "Ottawa", "Vancouver", "Montréal"),
            correctIndex = 1,
            rating = 1000,
            explanation = "La capitale du Canada est Ottawa, située dans la province de l'Ontario, et non Toronto ou Montréal qui sont pourtant plus peuplées. Ottawa fut choisie en 1857 par la reine Victoria, notamment pour sa position à la frontière entre le Haut et le Bas-Canada, à la limite des zones anglophone et francophone. La ville abrite la colline du Parlement, siège du gouvernement fédéral.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel est le plus haut sommet du monde ?",
            options = listOf("K2", "Mont Blanc", "Everest", "Kilimandjaro"),
            correctIndex = 2,
            rating = 700,
            explanation = "L'Everest, situé dans la chaîne de l'Himalaya à la frontière entre le Népal et la Chine, culmine à 8 849 mètres, ce qui en fait le plus haut sommet du monde. Il fut gravi pour la première fois en 1953 par Edmund Hillary et le sherpa Tenzing Norgay. Son nom occidental rend hommage à George Everest, géographe britannique ; les Népalais l'appellent Sagarmatha.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Dans quel pays se trouve la ville de Marrakech ?",
            options = listOf("Tunisie", "Algérie", "Maroc", "Égypte"),
            correctIndex = 2,
            rating = 800,
            explanation = "Marrakech est l'une des grandes villes du Maroc, surnommée la \"ville rouge\" en raison de la couleur ocre de ses murailles et bâtiments. Fondée au XIe siècle, elle fut longtemps une capitale impériale. Sa place Jemaa el-Fna, animée jour et nuit, est inscrite au patrimoine immatériel de l'UNESCO, tout comme sa médina historique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel pays a la plus grande superficie du monde ?",
            options = listOf("Canada", "Chine", "États-Unis", "Russie"),
            correctIndex = 3,
            rating = 750,
            explanation = "La Russie est de loin le plus vaste pays du monde avec environ 17 millions de km², soit près du double du Canada qui occupe la deuxième place. Son territoire s'étend sur deux continents, l'Europe et l'Asie, et traverse onze fuseaux horaires. Malgré son immensité, une grande partie de son territoire, notamment la Sibérie, est peu peuplée.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est la capitale de l'Égypte ?",
            options = listOf("Alexandrie", "Le Caire", "Louxor", "Gizeh"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le Caire est la capitale de l'Égypte et la plus grande ville du monde arabe, avec une agglomération de plus de 20 millions d'habitants. Située sur les rives du Nil, elle est proche des célèbres pyramides de Gizeh. Son nom arabe, Al-Qāhira, signifie \"la Victorieuse\". La ville abrite un riche patrimoine islamique, copte et antique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel détroit sépare l'Europe de l'Afrique ?",
            options = listOf("Le Bosphore", "Gibraltar", "La Manche", "Le détroit de Béring"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Le détroit de Gibraltar sépare l'Espagne (Europe) du Maroc (Afrique) et relie la mer Méditerranée à l'océan Atlantique. Large d'environ 14 km à son point le plus étroit, il constitue un passage maritime stratégique majeur. Le célèbre rocher de Gibraltar, territoire britannique, en garde l'entrée nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel est le plus petit État du monde ?",
            options = listOf("Monaco", "Nauru", "Le Vatican", "Saint-Marin"),
            correctIndex = 2,
            rating = 900,
            explanation = "Le Vatican est le plus petit État indépendant du monde, avec une superficie d'à peine 0,44 km² et environ 800 habitants. Enclavé dans Rome, il est le siège de l'Église catholique et la résidence du pape. Créé en 1929 par les accords du Latran, il abrite la basilique Saint-Pierre et la chapelle Sixtine.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "À quel pays appartiennent les îles Galápagos ?",
            options = listOf("Pérou", "Chili", "Équateur", "Colombie"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Les îles Galápagos, situées dans l'océan Pacifique à environ 1 000 km des côtes, appartiennent à l'Équateur. C'est en observant la faune unique de cet archipel volcanique que Charles Darwin développa sa théorie de l'évolution en 1835. Les îles abritent des espèces endémiques comme les tortues géantes et les iguanes marins.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est la capitale de l'Espagne ?",
            options = listOf("Barcelone", "Madrid", "Séville", "Valence"),
            correctIndex = 1,
            rating = 600,
            explanation = "Madrid est la capitale et la plus grande ville de l'Espagne, située au cœur géographique du pays sur le plateau de la Meseta. Devenue capitale au XVIe siècle sous Philippe II, elle abrite la résidence du roi ainsi que le célèbre musée du Prado. Avec plus de 3 millions d'habitants, c'est l'une des plus grandes métropoles d'Europe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel fleuve traverse Paris ?",
            options = listOf("La Loire", "Le Rhône", "La Seine", "La Garonne"),
            correctIndex = 2,
            rating = 600,
            explanation = "La Seine traverse Paris d'est en ouest sur environ 13 km, séparant la rive gauche de la rive droite. Longue de 777 km, elle prend sa source en Bourgogne et se jette dans la Manche au Havre. Ses berges parisiennes sont inscrites au patrimoine mondial de l'UNESCO, et elle est traversée par 37 ponts dans la capitale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quel pays est le plus peuplé du monde en 2023 ?",
            options = listOf("Chine", "Inde", "États-Unis", "Indonésie"),
            correctIndex = 1,
            rating = 1150,
            explanation = "En 2023, l'Inde est devenue le pays le plus peuplé du monde, dépassant la Chine avec plus de 1,42 milliard d'habitants. Ce basculement historique s'explique par une croissance démographique indienne encore soutenue, alors que la population chinoise a commencé à décliner sous l'effet du vieillissement et de l'ancienne politique de l'enfant unique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle chaîne de montagnes sépare l'Europe de l'Asie ?",
            options = listOf("Les Alpes", "Le Caucase", "L'Oural", "Les Carpates"),
            correctIndex = 2,
            rating = 1000,
            explanation = "La chaîne de l'Oural, qui traverse la Russie du nord au sud sur environ 2 500 km, est traditionnellement considérée comme la frontière naturelle entre l'Europe et l'Asie. Relativement peu élevée (son point culminant dépasse à peine 1 900 m), elle est riche en ressources minières. La ville d'Iekaterinbourg est l'une des principales agglomérations situées à proximité.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est l'étendue d'eau la plus salée parmi les suivantes ?",
            options = listOf("La mer Rouge", "La mer Morte", "La mer Caspienne", "La mer Noire"),
            correctIndex = 1,
            rating = 950,
            explanation = "La mer Morte, située entre Israël, la Jordanie et la Cisjordanie, possède une salinité d'environ 34%, soit près de dix fois celle des océans. Cette concentration extrême en sel permet aux baigneurs de flotter sans effort et empêche presque toute vie aquatique, d'où son nom. Son niveau, le plus bas de la Terre, baisse chaque année.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Quelle est la capitale de la Norvège ?",
            options = listOf("Stockholm", "Helsinki", "Oslo", "Copenhague"),
            correctIndex = 2,
            rating = 850,
            explanation = "Oslo est la capitale de la Norvège, située au fond d'un fjord dans le sud du pays. Fondée vers l'an 1000, elle porta le nom de Christiania de 1624 à 1925 en hommage au roi Christian IV. C'est aujourd'hui le centre politique et économique du pays, ainsi que le lieu où est décerné chaque année le prix Nobel de la paix.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Sur quel continent se trouve le mont Kilimandjaro ?",
            options = listOf("Asie", "Afrique", "Amérique du Sud", "Océanie"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Kilimandjaro, situé en Tanzanie, est le plus haut sommet d'Afrique avec ses 5 895 mètres. Ce volcan endormi est aussi la plus haute montagne isolée du monde, s'élevant directement depuis la plaine environnante. Bien que situé près de l'équateur, son sommet était traditionnellement couvert de glaciers, qui fondent rapidement sous l'effet du réchauffement climatique.",
            category = Category.GEOGRAPHIE
        ),

        // ===================== HISTOIRE =====================
        Question(
            text = "En quelle année a eu lieu la Révolution française ?",
            options = listOf("1776", "1804", "1789", "1815"),
            correctIndex = 2,
            rating = 750,
            explanation = "La Révolution française débuta en 1789 avec la prise de la Bastille le 14 juillet, événement commémoré chaque année comme fête nationale en France. Elle mit fin à la monarchie absolue et aboutit à la Déclaration des droits de l'homme et du citoyen. Cette période bouleversa profondément la société française et influença durablement le monde entier.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Qui était le premier président des États-Unis ?",
            options = listOf("Benjamin Franklin", "Thomas Jefferson", "Abraham Lincoln", "George Washington"),
            correctIndex = 3,
            rating = 750,
            explanation = "George Washington fut le premier président des États-Unis, élu en 1789 et réélu en 1792. Général en chef des armées lors de la guerre d'Indépendance, il présida ensuite la Convention constitutionnelle de 1787. Il refusa un troisième mandat, établissant ainsi une tradition codifiée bien plus tard par le 22e amendement en 1951.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "En quelle année a eu lieu le débarquement en Normandie ?",
            options = listOf("1942", "1943", "1944", "1945"),
            correctIndex = 2,
            rating = 800,
            explanation = "Le débarquement en Normandie, nom de code Opération Overlord, eut lieu le 6 juin 1944 — le \"Jour J\". Il s'agit de la plus grande opération amphibie de l'histoire, mobilisant près de 156 000 soldats alliés sur cinq plages normandes : Utah, Omaha, Gold, Juno et Sword. Cette offensive marqua le début de la libération de l'Europe occidentale.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel empire a construit le Colisée de Rome ?",
            options = listOf("L'Empire grec", "L'Empire romain", "L'Empire ottoman", "L'Empire byzantin"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Colisée, ou amphithéâtre Flavien, fut construit sous l'Empire romain entre 70 et 80 apr. J.-C., sous les empereurs Vespasien et Titus. Il pouvait accueillir entre 50 000 et 80 000 spectateurs pour des combats de gladiateurs et des chasses aux animaux sauvages. C'est aujourd'hui le monument le plus visité d'Italie.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Dans quelle île est né Napoléon Bonaparte ?",
            options = listOf("Sardaigne", "Malte", "Corse", "Sicile"),
            correctIndex = 2,
            rating = 900,
            explanation = "Napoléon Bonaparte est né le 15 août 1769 à Ajaccio, en Corse, un an seulement après le rattachement de l'île à la France. D'abord officier d'artillerie, il s'illustra lors des guerres révolutionnaires avant de devenir Premier Consul en 1799, puis Empereur des Français en 1804. Son règne donna notamment naissance au Code civil, toujours en vigueur aujourd'hui.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "En quelle année a commencé la Première Guerre mondiale ?",
            options = listOf("1914", "1916", "1918", "1912"),
            correctIndex = 0,
            rating = 750,
            explanation = "La Première Guerre mondiale débuta en 1914, déclenchée par l'assassinat de l'archiduc François-Ferdinand à Sarajevo le 28 juin. Ce conflit opposa les puissances de l'Entente aux Empires centraux et fit environ 10 millions de morts militaires. Surnommée la \"Grande Guerre\", elle s'acheva le 11 novembre 1918 par l'armistice signé à Rethondes.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel mur est tombé en 1989 ?",
            options = listOf("Le mur d'Hadrien", "Le mur de Berlin", "La Grande Muraille", "Le mur des Lamentations"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le mur de Berlin, qui séparait la ville en deux depuis 1961, tomba le 9 novembre 1989. Érigé par la RDA communiste pour empêcher la fuite de ses habitants vers l'Ouest, il était devenu le symbole de la guerre froide et du rideau de fer. Sa chute précipita la réunification de l'Allemagne, officialisée le 3 octobre 1990.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quelle civilisation a construit les pyramides de Gizeh ?",
            options = listOf("Les Romains", "Les Grecs", "Les Égyptiens", "Les Mayas"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les pyramides de Gizeh furent construites par les anciens Égyptiens vers 2 500 av. J.-C., sous la IVe dynastie. La plus grande, la pyramide de Khéops, est la seule des sept merveilles du monde antique encore debout. Ces monuments colossaux servaient de tombeaux aux pharaons et témoignent d'une maîtrise architecturale exceptionnelle pour l'époque.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "En quelle année l'homme a-t-il marché sur la Lune pour la première fois ?",
            options = listOf("1965", "1969", "1972", "1959"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le 21 juillet 1969, l'astronaute américain Neil Armstrong devint le premier homme à poser le pied sur la Lune lors de la mission Apollo 11, prononçant la célèbre phrase \"un petit pas pour l'homme, un bond de géant pour l'humanité\". Buzz Aldrin le rejoignit, tandis que Michael Collins restait en orbite. L'exploit fut suivi en direct par des centaines de millions de téléspectateurs.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel navigateur a atteint l'Amérique en 1492 ?",
            options = listOf("Vasco de Gama", "Christophe Colomb", "Magellan", "Amerigo Vespucci"),
            correctIndex = 1,
            rating = 750,
            explanation = "Christophe Colomb, navigateur génois au service de la couronne d'Espagne, atteignit les Antilles en 1492 en cherchant une route maritime vers les Indes par l'ouest. Persuadé jusqu'à sa mort d'avoir atteint l'Asie, il ne sut jamais qu'il avait \"découvert\" un nouveau continent. Celui-ci fut finalement baptisé Amérique en référence à Amerigo Vespucci.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quelle reine d'Égypte s'est alliée à Jules César et Marc Antoine ?",
            options = listOf("Néfertiti", "Cléopâtre", "Hatchepsout", "Néfertari"),
            correctIndex = 1,
            rating = 900,
            explanation = "Cléopâtre VII, dernière souveraine de l'Égypte ptolémaïque, noua des alliances politiques et amoureuses avec les Romains Jules César puis Marc Antoine. Femme cultivée parlant plusieurs langues, elle chercha à préserver l'indépendance de son royaume. Après la défaite d'Actium en 31 av. J.-C., elle se serait suicidée, dit-on, par la morsure d'un aspic.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel roi de France était surnommé le \"Roi-Soleil\" ?",
            options = listOf("Louis XIV", "Louis XVI", "François Ier", "Henri IV"),
            correctIndex = 0,
            rating = 850,
            explanation = "Louis XIV, qui régna de 1643 à 1715, est surnommé le \"Roi-Soleil\" en référence à l'astre qu'il choisit comme emblème. Son règne de 72 ans, le plus long de l'histoire de France, incarna l'apogée de la monarchie absolue. Il fit construire le château de Versailles, où il concentra la noblesse pour mieux la contrôler.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "La guerre de Cent Ans a opposé la France à quel pays ?",
            options = listOf("L'Espagne", "L'Angleterre", "L'Allemagne", "L'Italie"),
            correctIndex = 1,
            rating = 950,
            explanation = "La guerre de Cent Ans (1337-1453) opposa le royaume de France à celui d'Angleterre, principalement pour des questions de succession au trône français. Malgré des défaites cuisantes comme Azincourt, la France finit par l'emporter, portée notamment par Jeanne d'Arc qui contribua à délivrer Orléans en 1429. Le conflit forgea le sentiment national des deux nations.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "En quelle année s'est terminée la Seconde Guerre mondiale ?",
            options = listOf("1944", "1945", "1946", "1943"),
            correctIndex = 1,
            rating = 700,
            explanation = "La Seconde Guerre mondiale s'acheva en 1945 : en Europe avec la capitulation de l'Allemagne nazie le 8 mai, puis dans le Pacifique avec la reddition du Japon le 2 septembre, après les bombardements atomiques d'Hiroshima et Nagasaki. Ce conflit, le plus meurtrier de l'histoire, fit environ 60 millions de morts et redessina l'ordre mondial.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel empereur français a été défait à Waterloo en 1815 ?",
            options = listOf("Louis XVIII", "Napoléon Ier", "Charles X", "Napoléon III"),
            correctIndex = 1,
            rating = 900,
            explanation = "Napoléon Ier subit sa défaite finale à la bataille de Waterloo, en Belgique, le 18 juin 1815, face aux armées britannique et prussienne commandées par Wellington et Blücher. Cette défaite mit fin aux Cent-Jours et à son règne. Exilé sur l'île de Sainte-Hélène, dans l'Atlantique Sud, il y mourut en 1821.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quelle cité grecque antique était la grande rivale militaire d'Athènes ?",
            options = listOf("Thèbes", "Corinthe", "Sparte", "Olympie"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Sparte, célèbre pour sa société militarisée et la discipline de fer de ses citoyens-soldats, fut la grande rivale d'Athènes durant l'Antiquité. Les deux cités s'affrontèrent notamment lors de la guerre du Péloponnèse (431-404 av. J.-C.), qui se solda par la victoire de Sparte. L'éducation spartiate, ou \"agogè\", est restée légendaire pour sa rigueur.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel président américain a aboli l'esclavage ?",
            options = listOf("George Washington", "Thomas Jefferson", "Abraham Lincoln", "Franklin Roosevelt"),
            correctIndex = 2,
            rating = 900,
            explanation = "Abraham Lincoln, 16e président des États-Unis, joua un rôle décisif dans l'abolition de l'esclavage avec la Proclamation d'émancipation de 1863, puis le 13e amendement de la Constitution en 1865. Sa présidence fut marquée par la guerre de Sécession qui déchira le pays. Il fut assassiné en avril 1865, quelques jours après la victoire de l'Union.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quel explorateur est associé à la première circumnavigation du globe ?",
            options = listOf("Christophe Colomb", "Vasco de Gama", "Fernand de Magellan", "Marco Polo"),
            correctIndex = 2,
            rating = 1100,
            explanation = "L'expédition lancée par le navigateur portugais Fernand de Magellan en 1519 réalisa le premier tour du monde maritime. Magellan mourut toutefois en chemin, aux Philippines en 1521, et c'est son second Juan Sebastián Elcano qui ramena en 1522 l'unique navire survivant en Espagne. Ce périple démontra concrètement la rotondité de la Terre.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Quelle catastrophe a détruit la cité de Pompéi en 79 apr. J.-C. ?",
            options = listOf("Un tremblement de terre", "L'éruption du Vésuve", "Une inondation", "Un grand incendie"),
            correctIndex = 1,
            rating = 1000,
            explanation = "En 79 apr. J.-C., l'éruption du Vésuve ensevelit la ville romaine de Pompéi sous plusieurs mètres de cendres et de pierres ponces, figeant la cité et ses habitants dans l'instant. Redécouvert au XVIIIe siècle, le site offre un témoignage exceptionnel de la vie quotidienne romaine. La proche ville d'Herculanum subit le même sort.",
            category = Category.HISTOIRE
        ),
        Question(
            text = "Qui était le chef de l'Allemagne durant la Seconde Guerre mondiale ?",
            options = listOf("Benito Mussolini", "Joseph Staline", "Adolf Hitler", "Francisco Franco"),
            correctIndex = 2,
            rating = 600,
            explanation = "Adolf Hitler dirigea l'Allemagne nazie de 1933 à 1945 en tant que chancelier puis Führer. Son idéologie raciste et expansionniste plongea le monde dans la Seconde Guerre mondiale et conduisit au génocide de six millions de Juifs lors de la Shoah. Acculé par la défaite, il se suicida dans son bunker à Berlin en avril 1945.",
            category = Category.HISTOIRE
        ),

        // ===================== SCIENCES & NATURE =====================
        Question(
            text = "Combien de côtés a un hexagone ?",
            options = listOf("6", "5", "7", "8"),
            correctIndex = 0,
            rating = 600,
            explanation = "Un hexagone est un polygone à 6 côtés et 6 angles. La France est d'ailleurs surnommée \"l'Hexagone\" en raison de la forme approximativement hexagonale de son territoire métropolitain. Un hexagone régulier possède tous ses côtés et angles égaux ; la somme de ses angles intérieurs est de 720°. On retrouve cette forme dans les alvéoles construites par les abeilles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel est l'élément chimique dont le symbole est \"Au\" ?",
            options = listOf("Argent", "Aluminium", "Or", "Azote"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le symbole chimique \"Au\" vient du latin \"aurum\", qui signifie or. L'or est un métal précieux de numéro atomique 79, résistant à la corrosion et à l'oxydation. Utilisé depuis l'Antiquité pour la joaillerie et la monnaie, il est aujourd'hui indispensable en électronique de précision. Chaque smartphone contient de petites quantités d'or dans ses circuits.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quelle planète est la plus proche du Soleil ?",
            options = listOf("Mercure", "Vénus", "Mars", "Terre"),
            correctIndex = 0,
            rating = 850,
            explanation = "Mercure est la planète la plus proche du Soleil, à une distance moyenne de 57,9 millions de km. Malgré cela, Mercure n'est pas la planète la plus chaude : c'est Vénus, dont l'épaisse atmosphère génère un fort effet de serre maintenant une température moyenne de 462°C. Mercure connaît quant à elle des extrêmes allant de −180°C la nuit à +430°C le jour.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Qui a inventé le téléphone ?",
            options = listOf("Thomas Edison", "Nikola Tesla", "Alexander Graham Bell", "Guglielmo Marconi"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Alexander Graham Bell obtint le premier brevet du téléphone en 1876. L'invention est néanmoins controversée : l'Italien Antonio Meucci avait déposé une pré-demande de brevet dès 1871, mais n'avait pas les moyens de la renouveler. En 2002, le Congrès américain a officiellement reconnu la contribution de Meucci à l'invention du téléphone.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quelle est la formule chimique de l'eau ?",
            options = listOf("H₂O", "CO₂", "NaCl", "O₂"),
            correctIndex = 0,
            rating = 650,
            explanation = "La molécule d'eau est composée de deux atomes d'hydrogène (H) et d'un atome d'oxygène (O), d'où la formule H₂O. L'eau est la seule substance naturelle présente en abondance dans les trois états de la matière sur Terre. Elle couvre environ 71% de la surface de notre planète, mais seulement 2,5% est de l'eau douce, dont la majeure partie est piégée dans les glaces polaires.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Qui a découvert la pénicilline ?",
            options = listOf("Louis Pasteur", "Alexander Fleming", "Marie Curie", "Albert Einstein"),
            correctIndex = 1,
            rating = 1050,
            explanation = "La pénicilline fut découverte par Alexander Fleming en 1928, par hasard, lorsqu'il observa qu'une moisissure (Penicillium notatum) inhibait la croissance de bactéries dans une boîte de Petri oubliée. Cette découverte révolutionna la médecine en permettant de traiter des infections jusque-là mortelles. Fleming, Howard Florey et Ernst Boris Chain reçurent le prix Nobel de médecine en 1945.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel organe pompe le sang dans le corps humain ?",
            options = listOf("Le foie", "Le cœur", "Les poumons", "Les reins"),
            correctIndex = 1,
            rating = 600,
            explanation = "Le cœur est un muscle creux qui propulse le sang dans tout l'organisme grâce à ses contractions régulières. Battant en moyenne 70 à 80 fois par minute, soit environ 100 000 fois par jour, il assure la circulation de l'oxygène et des nutriments. Il est divisé en quatre cavités : deux oreillettes et deux ventricules.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Combien de planètes compte le système solaire ?",
            options = listOf("7", "8", "9", "10"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le système solaire compte officiellement 8 planètes depuis 2006 : Mercure, Vénus, la Terre, Mars, Jupiter, Saturne, Uranus et Neptune. Pluton, longtemps considérée comme la neuvième, a été reclassée en \"planète naine\" par l'Union astronomique internationale en raison de sa petite taille et de son orbite particulière.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel gaz les plantes absorbent-elles pour réaliser la photosynthèse ?",
            options = listOf("L'oxygène", "L'azote", "Le dioxyde de carbone", "L'hydrogène"),
            correctIndex = 2,
            rating = 750,
            explanation = "Lors de la photosynthèse, les plantes absorbent le dioxyde de carbone (CO₂) de l'air et, grâce à l'énergie lumineuse, le transforment en glucose tout en rejetant de l'oxygène. Ce processus, à la base de presque toute la vie sur Terre, fait des forêts et du phytoplancton océanique de véritables \"poumons\" de la planète.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel est l'animal terrestre le plus rapide ?",
            options = listOf("Le lion", "Le guépard", "L'antilope", "Le lévrier"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le guépard est l'animal terrestre le plus rapide : il peut atteindre une pointe de vitesse d'environ 110 km/h sur de courtes distances. Son corps fin, ses longues pattes et sa colonne vertébrale très souple en font une machine de course exceptionnelle. Il ne peut toutefois maintenir cette allure que quelques centaines de mètres avant de s'épuiser.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quelle est approximativement la vitesse de la lumière dans le vide ?",
            options = listOf("300 000 km/s", "150 000 km/s", "1 000 km/s", "30 000 km/s"),
            correctIndex = 0,
            rating = 1000,
            explanation = "La lumière se déplace dans le vide à environ 300 000 km/s (précisément 299 792 458 m/s), une constante universelle notée \"c\". À cette vitesse, elle fait sept fois le tour de la Terre en une seconde. Selon la théorie de la relativité d'Einstein, rien ne peut dépasser cette vitesse, qui constitue une limite fondamentale de l'univers.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Combien d'os compte le corps humain adulte ?",
            options = listOf("186", "206", "226", "250"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le squelette d'un adulte compte 206 os. À la naissance, un bébé en possède environ 270, mais certains fusionnent au cours de la croissance, notamment au niveau du crâne et de la colonne vertébrale. Le plus long os du corps est le fémur, et le plus petit est l'étrier, situé dans l'oreille moyenne.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel métal est liquide à température ambiante ?",
            options = listOf("Le plomb", "Le mercure", "Le fer", "L'étain"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le mercure est le seul métal qui se présente à l'état liquide à température ambiante, avec un point de fusion de −39°C. Surnommé \"vif-argent\", il était autrefois utilisé dans les thermomètres et baromètres. En raison de sa forte toxicité, son usage est aujourd'hui strictement encadré. Son symbole chimique, Hg, vient du grec \"hydrargyros\".",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quelle planète est surnommée la \"planète rouge\" ?",
            options = listOf("Vénus", "Jupiter", "Mars", "Saturne"),
            correctIndex = 2,
            rating = 600,
            explanation = "Mars est surnommée la \"planète rouge\" en raison de la couleur de sa surface, riche en oxyde de fer (la rouille). Quatrième planète du système solaire, elle fait l'objet de nombreuses missions d'exploration robotisée, comme les rovers de la NASA. On y trouve le plus haut volcan connu du système solaire, Olympus Mons, qui culmine à environ 22 km.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel scientifique a formulé la théorie de l'évolution par sélection naturelle ?",
            options = listOf("Isaac Newton", "Charles Darwin", "Gregor Mendel", "Galilée"),
            correctIndex = 1,
            rating = 850,
            explanation = "Charles Darwin formula la théorie de l'évolution par sélection naturelle, exposée en 1859 dans son ouvrage \"De l'origine des espèces\". Selon cette théorie, les espèces évoluent au fil des générations en fonction de la survie des individus les mieux adaptés à leur environnement. Cette idée révolutionna la biologie et notre compréhension du vivant.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel est le plus grand organe du corps humain ?",
            options = listOf("Le foie", "Les intestins", "La peau", "Les poumons"),
            correctIndex = 2,
            rating = 900,
            explanation = "La peau est le plus grand organe du corps humain : chez un adulte, elle couvre environ 2 m² et pèse près de 4 kg. Elle joue un rôle essentiel de protection contre les agressions extérieures, de régulation de la température et de perception du toucher. Elle se compose de trois couches : l'épiderme, le derme et l'hypoderme.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quelle force nous maintient au sol ?",
            options = listOf("Le magnétisme", "La gravité", "L'électricité", "La pression"),
            correctIndex = 1,
            rating = 650,
            explanation = "La gravité, ou gravitation, est la force qui attire les corps les uns vers les autres et nous maintient à la surface de la Terre. Décrite par Isaac Newton puis approfondie par Einstein, elle dépend de la masse des objets. C'est cette même force qui maintient la Lune en orbite autour de la Terre et les planètes autour du Soleil.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel gaz compose majoritairement l'atmosphère terrestre ?",
            options = listOf("L'oxygène", "L'azote", "Le dioxyde de carbone", "L'hydrogène"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Contrairement à une idée répandue, ce n'est pas l'oxygène mais l'azote qui domine l'atmosphère terrestre, représentant environ 78% de l'air. L'oxygène n'en constitue que 21%, le reste étant composé d'argon, de dioxyde de carbone et de gaz divers. L'azote, peu réactif, joue un rôle stabilisateur essentiel pour la vie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Combien de chromosomes possède un être humain ?",
            options = listOf("23", "44", "46", "48"),
            correctIndex = 2,
            rating = 1000,
            explanation = "L'être humain possède 46 chromosomes, regroupés en 23 paires, dans le noyau de chacune de ses cellules. La 23e paire détermine le sexe : XX pour les femmes et XY pour les hommes. Ces chromosomes portent l'ADN, support de l'information génétique transmise de génération en génération.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Quel est l'élément chimique le plus abondant dans l'univers ?",
            options = listOf("L'oxygène", "L'hélium", "L'hydrogène", "Le carbone"),
            correctIndex = 2,
            rating = 1050,
            explanation = "L'hydrogène est l'élément le plus abondant de l'univers, constituant environ 75% de la matière ordinaire. C'est le carburant des étoiles : par fusion nucléaire, elles transforment l'hydrogène en hélium, libérant l'énergie qui les fait briller. Premier élément du tableau périodique, l'hydrogène est aussi le plus simple et le plus léger.",
            category = Category.SCIENCES_ET_NATURE
        ),

        // ===================== ART & CULTURE =====================
        Question(
            text = "Qui a peint la Joconde ?",
            options = listOf("Michel-Ange", "Léonard de Vinci", "Raphaël", "Botticelli"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Joconde, ou Mona Lisa, est un tableau peint par Léonard de Vinci entre 1503 et 1519. Il est exposé au musée du Louvre à Paris, protégé derrière une vitre blindée. Le modèle serait Lisa Gherardini, épouse d'un riche marchand florentin. C'est l'œuvre d'art la plus visitée au monde, attirant chaque année plusieurs millions de visiteurs.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a écrit \"Les Misérables\" ?",
            options = listOf("Émile Zola", "Victor Hugo", "Honoré de Balzac", "Gustave Flaubert"),
            correctIndex = 1,
            rating = 800,
            explanation = "Les Misérables est un roman de Victor Hugo publié en 1862. Il raconte l'histoire de Jean Valjean, un ancien forçat cherchant à se racheter dans une France du XIXe siècle marquée par la misère et l'injustice. L'œuvre a été adaptée en comédie musicale en 1980, devenue l'une des plus jouées au monde. Hugo l'écrivit en grande partie en exil, notamment à Guernesey.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a sculpté \"Le Penseur\" ?",
            options = listOf("Auguste Rodin", "Michel-Ange", "Donatello", "Lorenzo Bernini"),
            correctIndex = 0,
            rating = 900,
            explanation = "Le Penseur est une sculpture d'Auguste Rodin, créée en 1882. À l'origine conçue comme une figure de Dante pour les Portes de l'Enfer, elle est devenue l'une des sculptures les plus célèbres au monde. Le modèle original, en bronze, mesure 186 cm de haut. Des exemplaires sont exposés dans de nombreux musées, dont le musée Rodin à Paris.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel est le vrai nom de Molière ?",
            options = listOf("Pierre Corneille", "Jean-Baptiste Poquelin", "François-Marie Arouet", "Jean Racine"),
            correctIndex = 1,
            rating = 950,
            explanation = "Jean-Baptiste Poquelin, dit Molière, est né à Paris en 1622. Il adopta le pseudonyme de Molière dès 1643 lorsqu'il fonda la troupe de l'Illustre Théâtre. Auteur de comédies immortelles comme Le Misanthrope, Tartuffe ou L'Avare, il mourut en 1673 sur scène lors d'une représentation du Malade imaginaire.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Dans quel pays est né Pablo Picasso ?",
            options = listOf("France", "Italie", "Espagne", "Portugal"),
            correctIndex = 2,
            rating = 850,
            explanation = "Pablo Picasso est né à Málaga, en Espagne, en 1881. Cofondateur du cubisme avec Georges Braque, il est considéré comme l'un des artistes les plus influents du XXe siècle. Il passa une grande partie de sa vie en France, notamment à Paris. Son œuvre comprend plus de 20 000 créations : peintures, sculptures, céramiques et gravures.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel compositeur a écrit la \"Symphonie n°9\" et son \"Ode à la joie\" ?",
            options = listOf("Mozart", "Beethoven", "Bach", "Chopin"),
            correctIndex = 1,
            rating = 900,
            explanation = "La Symphonie n°9 de Ludwig van Beethoven, achevée en 1824, intègre dans son dernier mouvement l'\"Ode à la joie\", un poème de Schiller chanté par des solistes et un chœur — une innovation révolutionnaire pour l'époque. Beethoven était alors devenu presque totalement sourd. Cet hymne à la fraternité est aujourd'hui l'hymne officiel de l'Union européenne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Dans quelle ville se trouve le musée du Louvre ?",
            options = listOf("Londres", "Rome", "Paris", "Madrid"),
            correctIndex = 2,
            rating = 600,
            explanation = "Le musée du Louvre se trouve à Paris, installé dans un ancien palais royal au bord de la Seine. Inauguré comme musée en 1793, il est le plus grand musée d'art du monde et le plus visité, avec la Joconde parmi ses joyaux. Sa célèbre pyramide de verre, conçue par l'architecte Ieoh Ming Pei, fut inaugurée en 1989.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a peint \"La Nuit étoilée\" ?",
            options = listOf("Claude Monet", "Vincent van Gogh", "Paul Cézanne", "Paul Gauguin"),
            correctIndex = 1,
            rating = 850,
            explanation = "La Nuit étoilée fut peinte par Vincent van Gogh en 1889, alors qu'il séjournait dans un asile à Saint-Rémy-de-Provence. Ce tableau aux tourbillons célestes intenses est l'une des œuvres les plus célèbres de l'art occidental. Van Gogh, peu reconnu de son vivant, ne vendit presque aucune toile avant sa mort en 1890 ; il est aujourd'hui une icône mondiale.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel écrivain a créé le personnage de Sherlock Holmes ?",
            options = listOf("Agatha Christie", "Arthur Conan Doyle", "Edgar Allan Poe", "Jules Verne"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le célèbre détective Sherlock Holmes est né de l'imagination de l'écrivain écossais Arthur Conan Doyle, qui le fit apparaître pour la première fois en 1887. Doté d'un sens de la déduction extraordinaire et accompagné du fidèle docteur Watson, le personnage est devenu l'archétype du détective de fiction. Conan Doyle s'inspira d'un de ses professeurs de médecine.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel mouvement artistique Claude Monet a-t-il contribué à fonder ?",
            options = listOf("Le cubisme", "Le surréalisme", "L'impressionnisme", "Le fauvisme"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Claude Monet est l'un des pères fondateurs de l'impressionnisme : c'est d'ailleurs son tableau \"Impression, soleil levant\" (1872) qui donna son nom au mouvement. Ce courant privilégie la captation de la lumière et des impressions fugaces plutôt que le détail réaliste. Monet est célèbre pour ses séries des Nymphéas, peintes dans son jardin de Giverny.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a écrit la pièce \"Roméo et Juliette\" ?",
            options = listOf("William Shakespeare", "Molière", "Dante Alighieri", "Goethe"),
            correctIndex = 0,
            rating = 700,
            explanation = "Roméo et Juliette est une tragédie écrite par le dramaturge anglais William Shakespeare vers 1595. Elle raconte l'amour impossible entre deux jeunes gens issus de familles rivales, les Montaigu et les Capulet, à Vérone. Devenue le symbole universel de l'amour contrarié, la pièce a inspiré d'innombrables films, ballets et opéras.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel instrument de musique possède 88 touches ?",
            options = listOf("L'orgue", "Le piano", "L'accordéon", "Le clavecin"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le piano moderne compte 88 touches : 52 blanches et 36 noires, couvrant plus de sept octaves. Inventé vers 1700 par l'Italien Bartolomeo Cristofori, son nom complet, \"pianoforte\", désigne sa capacité à jouer aussi bien doucement (piano) que fort (forte) selon la pression exercée sur les touches. C'est l'un des instruments les plus polyvalents.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a sculpté le \"David\", chef-d'œuvre de la Renaissance ?",
            options = listOf("Donatello", "Léonard de Vinci", "Michel-Ange", "Raphaël"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Le \"David\" est une statue monumentale en marbre de plus de 5 mètres, sculptée par Michel-Ange entre 1501 et 1504 à Florence. Elle représente le héros biblique avant son combat contre Goliath et incarne l'idéal de beauté et de perfection de la Renaissance. L'œuvre est aujourd'hui conservée à la galerie de l'Académie de Florence.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "De quel pays l'écrivain William Shakespeare est-il originaire ?",
            options = listOf("L'Angleterre", "L'Irlande", "L'Écosse", "Les États-Unis"),
            correctIndex = 0,
            rating = 650,
            explanation = "William Shakespeare est né en 1564 à Stratford-upon-Avon, en Angleterre. Considéré comme le plus grand dramaturge de langue anglaise, il a écrit une trentaine de pièces et de nombreux sonnets. Ses œuvres, comme Hamlet, Macbeth ou Othello, sont jouées dans le monde entier depuis plus de quatre siècles et ont profondément marqué la littérature.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel peintre espagnol est célèbre pour ses montres molles dans \"La Persistance de la mémoire\" ?",
            options = listOf("Joan Miró", "Salvador Dalí", "Pablo Picasso", "Francisco Goya"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Salvador Dalí, figure majeure du surréalisme, peignit \"La Persistance de la mémoire\" en 1931, célèbre pour ses montres molles qui semblent fondre dans un paysage onirique. Connu autant pour son génie que pour son excentricité et sa moustache emblématique, Dalí explorait l'inconscient et les rêves. L'œuvre est conservée au MoMA de New York.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel compositeur autrichien, enfant prodige, a écrit \"La Flûte enchantée\" ?",
            options = listOf("Joseph Haydn", "Wolfgang Amadeus Mozart", "Franz Schubert", "Johann Strauss"),
            correctIndex = 1,
            rating = 950,
            explanation = "Wolfgang Amadeus Mozart composa l'opéra \"La Flûte enchantée\" en 1791, l'année de sa mort. Enfant prodige né à Salzbourg en 1756, il jouait du clavecin et composait dès l'âge de cinq ans. Au cours de sa courte vie de 35 ans, il laissa plus de 600 œuvres et révolutionna presque tous les genres musicaux de son époque.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel monument parisien a été construit pour l'Exposition universelle de 1889 ?",
            options = listOf("La tour Montparnasse", "La tour Eiffel", "L'Arc de Triomphe", "La Sainte-Chapelle"),
            correctIndex = 1,
            rating = 600,
            explanation = "La tour Eiffel fut construite par l'ingénieur Gustave Eiffel pour l'Exposition universelle de 1889, qui marquait le centenaire de la Révolution française. Haute de 330 mètres, elle devait à l'origine être démontée au bout de vingt ans, mais son utilité comme antenne radio la sauva. Devenue le symbole de Paris, elle est le monument payant le plus visité au monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Qui a écrit la tragédie \"Le Cid\" ?",
            options = listOf("Jean Racine", "Pierre Corneille", "Molière", "Voltaire"),
            correctIndex = 1,
            rating = 1100,
            explanation = "\"Le Cid\" est une tragi-comédie de Pierre Corneille, créée en 1637. Inspirée d'un héros espagnol médiéval, elle met en scène le dilemme de Rodrigue, déchiré entre son amour pour Chimène et son devoir d'honneur familial. Immense succès, la pièce déclencha une vive polémique littéraire connue sous le nom de \"querelle du Cid\".",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel ballet de Tchaïkovski met en scène un lac et un cygne ?",
            options = listOf("Casse-Noisette", "Le Lac des cygnes", "La Belle au bois dormant", "Giselle"),
            correctIndex = 1,
            rating = 1000,
            explanation = "\"Le Lac des cygnes\", composé par Piotr Ilitch Tchaïkovski en 1876, raconte l'histoire de la princesse Odette transformée en cygne par un sortilège. C'est l'un des ballets les plus célèbres et les plus représentés au monde. Boudé lors de sa création, il connut un triomphe posthume grâce à la chorégraphie révisée de Petipa et Ivanov en 1895.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "Quel artiste a peint le plafond de la chapelle Sixtine ?",
            options = listOf("Raphaël", "Michel-Ange", "Botticelli", "Le Caravage"),
            correctIndex = 1,
            rating = 900,
            explanation = "Michel-Ange peignit le plafond de la chapelle Sixtine, au Vatican, entre 1508 et 1512, à la demande du pape Jules II. Cette fresque monumentale, qui comprend la célèbre scène de la \"Création d'Adam\", couvre plus de 500 m². Michel-Ange, qui se considérait d'abord comme sculpteur, réalisa ce chef-d'œuvre en travaillant le plus souvent allongé sur des échafaudages.",
            category = Category.ART_ET_CULTURE
        ),

        // ===================== SPORTS =====================
        Question(
            text = "Combien de joueurs composent une équipe de football ?",
            options = listOf("9", "11", "13", "10"),
            correctIndex = 1,
            rating = 650,
            explanation = "Une équipe de football est composée de 11 joueurs sur le terrain : 1 gardien de but et 10 joueurs de champ. Le football est le sport le plus populaire au monde avec environ 4 milliards de fans et 265 millions de pratiquants. Les règles modernes du jeu ont été codifiées en Angleterre en 1863 par la Football Association.",
            category = Category.SPORTS
        ),
        Question(
            text = "Dans quel sport utilise-t-on un volant ?",
            options = listOf("Tennis de table", "Squash", "Badminton", "Padel"),
            correctIndex = 2,
            rating = 700,
            explanation = "Le volant, aussi appelé \"shuttlecock\" en anglais, est l'objet frappé au badminton. Composé d'une base en liège surmontée de 16 plumes d'oie, il peut atteindre des vitesses supérieures à 400 km/h lors de smashes professionnels. Le badminton est l'un des sports les plus pratiqués au monde, particulièrement populaire en Asie du Sud-Est.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quel pays a remporté la Coupe du Monde de football 2018 ?",
            options = listOf("Croatie", "Brésil", "Argentine", "France"),
            correctIndex = 3,
            rating = 800,
            explanation = "La France a remporté la Coupe du Monde 2018 en Russie en battant la Croatie 4-2 en finale. C'était le deuxième titre mondial des Bleus après celui de 1998. Kylian Mbappé, alors âgé de 19 ans, devint le deuxième joueur après Pelé à marquer en finale d'une Coupe du Monde avant 20 ans.",
            category = Category.SPORTS
        ),
        Question(
            text = "Combien de joueurs composent une équipe de basketball sur le terrain ?",
            options = listOf("4", "5", "6", "7"),
            correctIndex = 1,
            rating = 650,
            explanation = "Une équipe de basketball aligne 5 joueurs sur le terrain : un meneur, un arrière, un ailier, un ailier fort et un pivot. Le basketball a été inventé en 1891 par le Canadien James Naismith à Springfield, Massachusetts. La NBA, ligue professionnelle fondée en 1946, est aujourd'hui la compétition de basketball la plus regardée au monde.",
            category = Category.SPORTS
        ),
        Question(
            text = "Sur quelle surface se joue le tournoi de Roland-Garros ?",
            options = listOf("Gazon", "Dur", "Terre battue", "Moquette"),
            correctIndex = 2,
            rating = 750,
            explanation = "Roland-Garros, l'un des quatre tournois du Grand Chelem, se joue sur terre battue. Cette surface ocre ralentit la balle et favorise les échanges longs depuis le fond du court. Le stade, situé à Paris, porte le nom de l'aviateur Roland Garros, héros de la Première Guerre mondiale. Rafael Nadal y a remporté un record de 14 titres.",
            category = Category.SPORTS
        ),
        Question(
            text = "Combien de joueurs composent une équipe de handball sur le terrain ?",
            options = listOf("5", "6", "7", "8"),
            correctIndex = 2,
            rating = 700,
            explanation = "Une équipe de handball est composée de 7 joueurs sur le terrain : 1 gardien de but et 6 joueurs de champ. Le handball est né en Europe du Nord à la fin du XIXe siècle et est devenu sport olympique en 1972. La France est l'une des grandes puissances mondiales de ce sport, ayant remporté plusieurs titres olympiques et de nombreux championnats du monde.",
            category = Category.SPORTS
        ),
        Question(
            text = "Tous les combien d'années ont lieu les Jeux Olympiques d'été ?",
            options = listOf("2 ans", "3 ans", "4 ans", "5 ans"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les Jeux Olympiques d'été ont lieu tous les 4 ans, une période appelée \"olympiade\". Inspirés des Jeux de la Grèce antique, ils furent rénovés par le baron Pierre de Coubertin en 1896 à Athènes. Depuis 1994, les Jeux d'hiver se tiennent en décalage de deux ans, si bien qu'un événement olympique a lieu tous les deux ans en alternance.",
            category = Category.SPORTS
        ),
        Question(
            text = "Dans quel sport peut-on réaliser un \"strike\" ?",
            options = listOf("Le golf", "Le bowling", "Le curling", "Le billard"),
            correctIndex = 1,
            rating = 750,
            explanation = "Au bowling, un \"strike\" consiste à faire tomber les dix quilles d'un seul lancer. C'est le meilleur coup possible, qui rapporte un bonus de points sur les lancers suivants. Le bowling moderne à dix quilles s'est popularisé aux États-Unis au XXe siècle et compte aujourd'hui des millions de pratiquants à travers le monde.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quelle est la plus grande course cycliste française ?",
            options = listOf("Paris-Roubaix", "Le Tour de France", "La Vuelta", "Le Giro"),
            correctIndex = 1,
            rating = 600,
            explanation = "Le Tour de France est la plus grande course cycliste française et l'une des plus prestigieuses au monde. Créé en 1903, il se déroule chaque été sur environ trois semaines et plus de 3 000 km. Le leader du classement général porte le célèbre maillot jaune, dont la couleur rappelle celle du journal L'Auto qui créa l'épreuve.",
            category = Category.SPORTS
        ),
        Question(
            text = "Combien de trous compte un parcours de golf standard ?",
            options = listOf("9", "12", "18", "21"),
            correctIndex = 2,
            rating = 800,
            explanation = "Un parcours de golf standard compte 18 trous. Ce nombre s'est imposé au XVIIIe siècle au club de Saint Andrews, en Écosse, berceau du golf moderne. Chaque trou a un \"par\", c'est-à-dire un nombre de coups de référence ; l'objectif est de terminer le parcours avec le moins de coups possible.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quel nageur a remporté 23 médailles d'or olympiques ?",
            options = listOf("Mark Spitz", "Michael Phelps", "Ian Thorpe", "Caeleb Dressel"),
            correctIndex = 1,
            rating = 1000,
            explanation = "L'Américain Michael Phelps détient le record absolu avec 23 médailles d'or olympiques, sur un total de 28 médailles. Surnommé le \"requin de Baltimore\", il a notamment remporté huit titres lors des seuls Jeux de Pékin en 2008, un exploit inédit. Il est considéré comme le plus grand nageur de tous les temps.",
            category = Category.SPORTS
        ),
        Question(
            text = "Dans quel pays sont nés les Jeux Olympiques antiques ?",
            options = listOf("L'Italie", "La Grèce", "L'Égypte", "La Turquie"),
            correctIndex = 1,
            rating = 700,
            explanation = "Les Jeux Olympiques antiques sont nés en Grèce, à Olympie, où ils se tenaient dès 776 av. J.-C. en l'honneur du dieu Zeus. Ils réunissaient les cités grecques lors d'une trêve sacrée et comprenaient des épreuves comme la course, la lutte ou le pancrace. Interdits en 393 apr. J.-C., ils furent ressuscités sous forme moderne en 1896.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quel joueur argentin a soulevé la Coupe du Monde de football 2022 ?",
            options = listOf("Diego Maradona", "Lionel Messi", "Sergio Agüero", "Ángel Di María"),
            correctIndex = 1,
            rating = 750,
            explanation = "Lionel Messi a remporté la Coupe du Monde 2022 au Qatar en tant que capitaine de l'Argentine, qui s'est imposée face à la France lors d'une finale spectaculaire conclue aux tirs au but. Ce sacre, longtemps attendu, a parachevé la carrière de l'un des plus grands joueurs de l'histoire, multiple Ballon d'or.",
            category = Category.SPORTS
        ),
        Question(
            text = "Combien de pilotes composent une écurie de Formule 1 en course ?",
            options = listOf("1", "2", "3", "4"),
            correctIndex = 1,
            rating = 850,
            explanation = "Chaque écurie de Formule 1 aligne 2 pilotes en course, soit un total de 20 voitures sur la grille de départ avec dix équipes. Les coéquipiers partagent les mêmes données techniques mais restent rivaux pour le championnat. Des pilotes de réserve peuvent toutefois remplacer un titulaire en cas de besoin.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quelle distance parcourt-on lors d'un marathon ?",
            options = listOf("21 km", "42,195 km", "50 km", "100 km"),
            correctIndex = 1,
            rating = 900,
            explanation = "Un marathon couvre exactement 42,195 km. Cette distance commémore la légende du soldat grec Philippidès, qui aurait couru de la ville de Marathon jusqu'à Athènes pour annoncer la victoire avant de s'effondrer. La distance précise fut fixée lors des Jeux de Londres en 1908, pour que l'arrivée se fasse devant la tribune royale.",
            category = Category.SPORTS
        ),
        Question(
            text = "Dans quel sport utilise-t-on une crosse sur la glace ?",
            options = listOf("Le curling", "Le hockey sur glace", "Le patinage", "Le bobsleigh"),
            correctIndex = 1,
            rating = 650,
            explanation = "Le hockey sur glace se joue avec une crosse et un palet (ou \"puck\") en caoutchouc, sur une patinoire. Chaque équipe aligne six joueurs, dont un gardien, et tente d'envoyer le palet dans le but adverse. Très populaire au Canada, en Russie et dans les pays nordiques, ce sport rapide et physique est olympique depuis 1920.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quel pays est à l'origine du judo ?",
            options = listOf("La Chine", "La Corée", "Le Japon", "La Thaïlande"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le judo est un art martial créé au Japon en 1882 par Jigoro Kano, à partir des techniques de l'ancien ju-jitsu des samouraïs. Son nom signifie \"voie de la souplesse\". Devenu sport olympique en 1964, le judo met l'accent sur la technique et le respect plutôt que sur la force brute. La France compte parmi les nations les plus titrées.",
            category = Category.SPORTS
        ),
        Question(
            text = "Combien de points vaut un essai au rugby à XV ?",
            options = listOf("3", "4", "5", "7"),
            correctIndex = 2,
            rating = 950,
            explanation = "Au rugby à XV, un essai rapporte 5 points. Il est marqué en aplatissant le ballon dans l'en-but adverse. Il donne ensuite droit à une tentative de transformation au pied, qui peut ajouter 2 points. À l'origine, l'essai ne valait aucun point et donnait simplement le droit de \"tenter\" de marquer au pied, d'où son nom.",
            category = Category.SPORTS
        ),
        Question(
            text = "Quel tournoi de tennis du Grand Chelem se joue sur gazon à Londres ?",
            options = listOf("L'US Open", "Wimbledon", "L'Open d'Australie", "Roland-Garros"),
            correctIndex = 1,
            rating = 800,
            explanation = "Wimbledon, disputé à Londres, est le plus ancien tournoi de tennis du monde, créé en 1877, et le seul du Grand Chelem encore joué sur gazon. Réputé pour ses traditions, il impose aux joueurs une tenue entièrement blanche. Roger Federer y détient le record masculin avec huit titres en simple.",
            category = Category.SPORTS
        ),
        Question(
            text = "Dans quel sport Tiger Woods s'est-il illustré ?",
            options = listOf("Le tennis", "Le golf", "Le baseball", "Le basketball"),
            correctIndex = 1,
            rating = 700,
            explanation = "Tiger Woods est l'un des plus grands golfeurs de l'histoire. Professionnel dès 1996, il a remporté 15 tournois du Grand Chelem et dominé le golf mondial pendant de nombreuses années. Son talent précoce et son charisme ont largement contribué à populariser ce sport auprès d'un public plus large à travers le monde.",
            category = Category.SPORTS
        ),

        // ===================== DIVERTISSEMENT =====================
        Question(
            text = "Quel acteur incarne Iron Man dans les films Marvel ?",
            options = listOf("Chris Evans", "Chris Hemsworth", "Robert Downey Jr.", "Mark Ruffalo"),
            correctIndex = 2,
            rating = 750,
            explanation = "Robert Downey Jr. incarne Tony Stark / Iron Man depuis le premier film du MCU en 2008. Son interprétation charismatique a largement contribué au succès mondial de la franchise. Il apparaît dans 10 films Marvel, culminant avec Avengers : Endgame (2019), l'un des films les plus rentables de l'histoire avec plus de 2,79 milliards de dollars de recettes mondiales.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Dans quelle série retrouve-t-on les personnages de Ross et Rachel ?",
            options = listOf("Seinfeld", "How I Met Your Mother", "Friends", "The Big Bang Theory"),
            correctIndex = 2,
            rating = 700,
            explanation = "Ross Geller et Rachel Green sont deux des six personnages principaux de Friends, série américaine diffusée de 1994 à 2004 sur NBC. Leur relation amoureuse tumultueuse est l'un des fils rouges de la série. Friends reste l'une des séries télévisées les plus regardées de l'histoire, et la réunion des acteurs en 2021 a été vue par des dizaines de millions de spectateurs.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel jeu vidéo se déroule dans la ville fictive de \"Los Santos\" ?",
            options = listOf("Red Dead Redemption", "Cyberpunk 2077", "Grand Theft Auto V", "Watch Dogs"),
            correctIndex = 2,
            rating = 850,
            explanation = "Los Santos est la ville fictive inspirée de Los Angeles dans Grand Theft Auto V, sorti en 2013. Développé par Rockstar Games, GTA V est l'un des jeux vidéo les plus vendus de l'histoire avec plus de 195 millions d'exemplaires écoulés. Le jeu propose également GTA Online, régulièrement mis à jour depuis son lancement.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Qui a réalisé le film \"Inception\" (2010) ?",
            options = listOf("Steven Spielberg", "James Cameron", "Ridley Scott", "Christopher Nolan"),
            correctIndex = 3,
            rating = 900,
            explanation = "Inception est un film de science-fiction réalisé par Christopher Nolan, sorti en 2010. Il met en scène Leonardo DiCaprio dans le rôle d'un voleur capable de s'infiltrer dans les rêves. Le film a remporté quatre Oscars, dont celui de la meilleure photographie et des meilleurs effets visuels. Nolan est également connu pour la trilogie Batman et Oppenheimer (2023).",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel artiste a sorti l'album \"Thriller\" en 1982 ?",
            options = listOf("Prince", "Madonna", "Michael Jackson", "Whitney Houston"),
            correctIndex = 2,
            rating = 800,
            explanation = "Thriller est le sixième album studio de Michael Jackson, sorti en novembre 1982. Produit par Quincy Jones, il reste l'album le plus vendu de l'histoire avec plus de 70 millions d'exemplaires dans le monde. Il contient des titres emblématiques comme \"Billie Jean\", \"Beat It\" et \"Thriller\". Le clip de \"Thriller\", réalisé par John Landis, a révolutionné le format du clip musical.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel petit personnage vert enseigne la Force dans Star Wars ?",
            options = listOf("Chewbacca", "Yoda", "R2-D2", "Jabba"),
            correctIndex = 1,
            rating = 650,
            explanation = "Yoda est un maître Jedi de la saga Star Wars, reconnaissable à sa petite taille, sa peau verte et sa syntaxe inversée. Âgé de 900 ans, il incarne la sagesse et la maîtrise de la Force. Apparu pour la première fois dans L'Empire contre-attaque en 1980, il forme de nombreux Jedi, dont Luke Skywalker.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Comment s'appelle le jeune sorcier à lunettes créé par J.K. Rowling ?",
            options = listOf("Harry Potter", "Frodon", "Percy Jackson", "Gandalf"),
            correctIndex = 0,
            rating = 600,
            explanation = "Harry Potter est le héros de la saga littéraire écrite par la Britannique J.K. Rowling, dont le premier tome parut en 1997. Orphelin élevé chez son oncle et sa tante, il découvre à onze ans qu'il est un sorcier et intègre l'école de Poudlard. Les sept romans, traduits dans plus de 80 langues, ont donné lieu à une saga cinématographique mondialement célèbre.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel studio a produit le film d'animation \"Le Roi Lion\" ?",
            options = listOf("Pixar", "DreamWorks", "Disney", "Studio Ghibli"),
            correctIndex = 2,
            rating = 700,
            explanation = "\"Le Roi Lion\", sorti en 1994, est un film d'animation produit par les studios Disney. Racontant l'histoire du lionceau Simba, il est devenu l'un des plus grands succès de l'animation, salué pour sa musique signée Elton John et Hans Zimmer. Une adaptation en images de synthèse est sortie en 2019, ainsi qu'une comédie musicale jouée dans le monde entier.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Dans quel jeu vidéo affronte-t-on des créatures appelées \"Creepers\" ?",
            options = listOf("Fortnite", "Minecraft", "Roblox", "Terraria"),
            correctIndex = 1,
            rating = 800,
            explanation = "Les \"Creepers\", créatures vertes qui explosent à proximité du joueur, sont emblématiques de Minecraft. Ce jeu \"bac à sable\" créé par Markus Persson et sorti en 2011 permet de construire et d'explorer un monde fait de blocs. Avec plus de 300 millions d'exemplaires vendus, c'est le jeu vidéo le plus vendu de tous les temps.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quelle chanteuse est surnommée la \"Reine de la pop\" ?",
            options = listOf("Beyoncé", "Madonna", "Lady Gaga", "Britney Spears"),
            correctIndex = 1,
            rating = 750,
            explanation = "Madonna est mondialement surnommée la \"Reine de la pop\" pour son influence considérable sur la musique et la culture depuis les années 1980. Connue pour ses réinventions constantes et ses spectacles provocateurs, elle est l'artiste féminine ayant vendu le plus de disques de l'histoire, avec des tubes comme \"Like a Virgin\" ou \"Vogue\".",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel film de James Cameron, sorti en 2009, se déroule sur la planète Pandora ?",
            options = listOf("Avatar", "Interstellar", "Star Trek", "Gravity"),
            correctIndex = 0,
            rating = 800,
            explanation = "Avatar, réalisé par James Cameron en 2009, se déroule sur la lune luxuriante de Pandora, peuplée par les Na'vi. Révolutionnaire par ses effets visuels et sa 3D, il est devenu le film le plus rentable de l'histoire au box-office mondial. Une suite tant attendue, Avatar : La Voie de l'eau, est sortie en 2022.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Dans la saga Star Wars, qui est le père de Luke Skywalker ?",
            options = listOf("Obi-Wan Kenobi", "Dark Vador", "L'Empereur Palpatine", "Han Solo"),
            correctIndex = 1,
            rating = 750,
            explanation = "La révélation que Dark Vador est le père de Luke Skywalker, dans L'Empire contre-attaque (1980), est l'un des rebondissements les plus célèbres de l'histoire du cinéma. Dark Vador, autrefois le chevalier Jedi Anakin Skywalker, a basculé du côté obscur de la Force. La réplique \"Je suis ton père\" est souvent citée — et mal citée — à travers le monde.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quelle série met en scène le professeur de chimie devenu trafiquant Walter White ?",
            options = listOf("The Wire", "Breaking Bad", "Dexter", "Better Call Saul"),
            correctIndex = 1,
            rating = 900,
            explanation = "Breaking Bad, diffusée de 2008 à 2013, suit Walter White, un professeur de chimie atteint d'un cancer qui se lance dans la fabrication de méthamphétamine pour assurer l'avenir de sa famille. Portée par l'acteur Bryan Cranston, la série est unanimement considérée comme l'une des meilleures de l'histoire de la télévision et a donné naissance au spin-off Better Call Saul.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel chanteur britannique est l'auteur de la chanson \"Shape of You\" ?",
            options = listOf("Sam Smith", "Ed Sheeran", "Harry Styles", "Robbie Williams"),
            correctIndex = 1,
            rating = 850,
            explanation = "\"Shape of You\" est un titre du chanteur britannique Ed Sheeran, sorti en 2017 sur l'album ÷ (Divide). Devenu un phénomène mondial, il figure parmi les vidéos les plus visionnées de YouTube et les chansons les plus écoutées sur les plateformes de streaming. Ed Sheeran est connu pour ses ballades pop interprétées souvent en solo à la guitare.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel groupe britannique a chanté \"Bohemian Rhapsody\" ?",
            options = listOf("The Beatles", "The Rolling Stones", "Queen", "Led Zeppelin"),
            correctIndex = 2,
            rating = 800,
            explanation = "\"Bohemian Rhapsody\" est une chanson du groupe Queen, sortie en 1975 sur l'album A Night at the Opera. Composée par Freddie Mercury, elle mêle ballade, opéra et hard rock en près de six minutes, une audace inédite à l'époque. Le film biographique du même nom, sorti en 2018, a remporté plusieurs Oscars.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quelle franchise de films met en scène Dominic Toretto et des courses de voitures ?",
            options = listOf("Need for Speed", "Fast and Furious", "Rush", "Le Transporteur"),
            correctIndex = 1,
            rating = 750,
            explanation = "La saga Fast and Furious, lancée en 2001, suit Dominic Toretto, incarné par Vin Diesel, et sa \"famille\" d'as du volant. D'abord centrée sur les courses de rue illégales, la franchise a évolué vers des films d'action spectaculaires. Avec une dizaine d'opus, elle est l'une des séries de films les plus rentables de l'histoire du cinéma.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "De quelle couleur sont les Schtroumpfs ?",
            options = listOf("Verts", "Bleus", "Jaunes", "Rouges"),
            correctIndex = 1,
            rating = 600,
            explanation = "Les Schtroumpfs sont de petits êtres bleus coiffés d'un bonnet blanc, créés en 1958 par le dessinateur belge Peyo. Vivant dans des maisons en forme de champignons, ils sont menacés par le sorcier Gargamel et son chat Azraël. La bande dessinée, puis la série animée des années 1980, ont fait connaître ces personnages dans le monde entier.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel réalisateur est célèbre pour \"Pulp Fiction\" et \"Kill Bill\" ?",
            options = listOf("Martin Scorsese", "Quentin Tarantino", "Steven Spielberg", "Les frères Coen"),
            correctIndex = 1,
            rating = 950,
            explanation = "Quentin Tarantino est un réalisateur américain connu pour son style unique mêlant dialogues ciselés, violence stylisée et narration non linéaire. Pulp Fiction (1994) lui valut la Palme d'or à Cannes et l'Oscar du meilleur scénario. Cinéphile passionné, il a également signé Reservoir Dogs, Django Unchained et Inglourious Basterds.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quelle saga se déroule dans un univers appelé la \"Terre du Milieu\" ?",
            options = listOf("Game of Thrones", "Le Seigneur des Anneaux", "Le Monde de Narnia", "Harry Potter"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Terre du Milieu est l'univers imaginaire créé par l'écrivain britannique J.R.R. Tolkien, cadre du Seigneur des Anneaux et du Hobbit. Peuplée d'elfes, de nains, de hobbits et d'orques, elle est devenue une référence majeure de la fantasy. La trilogie de films de Peter Jackson, sortie entre 2001 et 2003, a remporté de nombreux Oscars.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            text = "Quel super-héros est surnommé \"l'homme chauve-souris\" ?",
            options = listOf("Superman", "Batman", "Spider-Man", "Hulk"),
            correctIndex = 1,
            rating = 600,
            explanation = "Batman, \"l'homme chauve-souris\", est un super-héros créé en 1939 pour DC Comics. Sous le masque se cache le milliardaire Bruce Wayne qui, traumatisé par le meurtre de ses parents, combat le crime à Gotham City. Dépourvu de super-pouvoirs, il compte sur son intelligence, sa fortune et ses gadgets. Le personnage a inspiré de nombreux films à succès.",
            category = Category.DIVERTISSEMENT
        ),
    )

    fun getByCategory(category: Category): List<Question> =
        questions.filter { it.category == category }
}
