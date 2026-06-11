package com.fabien.trivia.data

object QuestionRepository {
    val questions = listOf(

        // ===================== GÉOGRAPHIE =====================
        Question(
            id = "geo_australie_capitale",
            title = "Capitale de l'Australie",
            text = "Quelle est la capitale de l'Australie ?",
            options = listOf("Canberra", "Sydney", "Melbourne", "Brisbane"),
            correctIndex = 0,
            rating = 1150,
            explanation = "La capitale de l'Australie est Canberra, et non Sydney comme beaucoup le croient. Canberra a été construite de toutes pièces comme capitale fédérale, inaugurée en 1913, suite au compromis entre Sydney et Melbourne qui se disputaient ce titre. La ville a été conçue par les architectes américains Walter Burley Griffin et Marion Mahony Griffin, lauréats d'un concours international en 1912.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_ocean",
            title = "Le plus grand océan",
            text = "Quel est le plus grand océan du monde ?",
            options = listOf("Atlantique", "Indien", "Arctique", "Pacifique"),
            correctIndex = 3,
            rating = 900,
            explanation = "L'océan Pacifique est le plus grand et le plus profond des océans, couvrant environ 165 millions de km², soit plus que toutes les terres émergées réunies. Son nom lui fut donné par l'explorateur Magellan qui le trouva calme lors de sa traversée en 1520. Il abrite la fosse des Mariannes, le point le plus profond de la Terre à 11 034 m.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_sahara_continent",
            title = "Continent du Sahara",
            text = "Sur quel continent se trouve le désert du Sahara ?",
            options = listOf("Asie", "Australie", "Amérique du Sud", "Afrique"),
            correctIndex = 3,
            rating = 650,
            explanation = "Le désert du Sahara se trouve en Afrique du Nord. Avec environ 9 millions de km², c'est le plus grand désert chaud du monde. Contrairement aux idées reçues, seulement 25% de sa surface est couverte de dunes de sable ; le reste est principalement composé de roches et de gravier. Il s'étend sur onze pays africains, dont l'Algérie, l'Égypte, le Mali ou le Tchad.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_long_fleuve",
            title = "Le plus long fleuve",
            text = "Quel est le fleuve le plus long du monde ?",
            options = listOf("Amazone", "Mississippi", "Yangtsé", "Nil"),
            correctIndex = 3,
            rating = 1200,
            explanation = "Le Nil est traditionnellement considéré comme le fleuve le plus long du monde avec 6 650 km, devant l'Amazone (6 400 km). Cette classification est toutefois sujette à débat selon les critères de mesure utilisés — certaines études récentes accordent la première place à l'Amazone. Le Nil traverse onze pays africains et fut le berceau de la civilisation égyptienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_japon_monnaie",
            title = "Monnaie du Japon",
            text = "Quelle est la monnaie officielle du Japon ?",
            options = listOf("Yuan", "Won", "Yen", "Ringgit"),
            correctIndex = 2,
            rating = 950,
            explanation = "Le yen est la monnaie officielle du Japon depuis 1871. Son symbole est ¥ et son code ISO est JPY. Le mot \"yen\" signifie \"objet rond\" en japonais, en référence aux anciennes pièces de monnaie. Le yen est l'une des trois monnaies les plus échangées au monde, après le dollar américain et l'euro.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_canada_capitale",
            title = "Capitale du Canada",
            text = "Quelle est la capitale du Canada ?",
            options = listOf("Toronto", "Ottawa", "Vancouver", "Montréal"),
            correctIndex = 1,
            rating = 1000,
            explanation = "La capitale du Canada est Ottawa, située dans la province de l'Ontario, et non Toronto ou Montréal qui sont pourtant plus peuplées. Ottawa fut choisie en 1857 par la reine Victoria, notamment pour sa position à la frontière entre le Haut et le Bas-Canada, à la limite des zones anglophone et francophone. La ville abrite la colline du Parlement, siège du gouvernement fédéral.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_haut_sommet",
            title = "Le plus haut sommet",
            text = "Quel est le plus haut sommet du monde ?",
            options = listOf("K2", "Mont Blanc", "Everest", "Kilimandjaro"),
            correctIndex = 2,
            rating = 700,
            explanation = "L'Everest, situé dans la chaîne de l'Himalaya à la frontière entre le Népal et la Chine, culmine à 8 849 mètres, ce qui en fait le plus haut sommet du monde. Il fut gravi pour la première fois en 1953 par Edmund Hillary et le sherpa Tenzing Norgay. Son nom occidental rend hommage à George Everest, géographe britannique ; les Népalais l'appellent Sagarmatha.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_marrakech_pays",
            title = "Pays de Marrakech",
            text = "Dans quel pays se trouve la ville de Marrakech ?",
            options = listOf("Tunisie", "Algérie", "Maroc", "Égypte"),
            correctIndex = 2,
            rating = 800,
            explanation = "Marrakech est l'une des grandes villes du Maroc, surnommée la \"ville rouge\" en raison de la couleur ocre de ses murailles et bâtiments. Fondée au XIe siècle, elle fut longtemps une capitale impériale. Sa place Jemaa el-Fna, animée jour et nuit, est inscrite au patrimoine immatériel de l'UNESCO, tout comme sa médina historique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_pays",
            title = "Le plus grand pays",
            text = "Quel pays a la plus grande superficie du monde ?",
            options = listOf("Canada", "Chine", "États-Unis", "Russie"),
            correctIndex = 3,
            rating = 750,
            explanation = "La Russie est de loin le plus vaste pays du monde avec environ 17 millions de km², soit près du double du Canada qui occupe la deuxième place. Son territoire s'étend sur deux continents, l'Europe et l'Asie, et traverse onze fuseaux horaires. Malgré son immensité, une grande partie de son territoire, notamment la Sibérie, est peu peuplée.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_egypte_capitale",
            title = "Capitale de l'Égypte",
            text = "Quelle est la capitale de l'Égypte ?",
            options = listOf("Alexandrie", "Le Caire", "Louxor", "Gizeh"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le Caire est la capitale de l'Égypte et la plus grande ville du monde arabe, avec une agglomération de plus de 20 millions d'habitants. Située sur les rives du Nil, elle est proche des célèbres pyramides de Gizeh. Son nom arabe, Al-Qāhira, signifie \"la Victorieuse\". La ville abrite un riche patrimoine islamique, copte et antique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_detroit_gibraltar",
            title = "Détroit entre Europe et Afrique",
            text = "Quel détroit sépare l'Europe de l'Afrique ?",
            options = listOf("Le Bosphore", "Gibraltar", "La Manche", "Le détroit de Béring"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Le détroit de Gibraltar sépare l'Espagne (Europe) du Maroc (Afrique) et relie la mer Méditerranée à l'océan Atlantique. Large d'environ 14 km à son point le plus étroit, il constitue un passage maritime stratégique majeur. Le célèbre rocher de Gibraltar, territoire britannique, en garde l'entrée nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_petit_etat",
            title = "Le plus petit État",
            text = "Quel est le plus petit État du monde ?",
            options = listOf("Monaco", "Nauru", "Le Vatican", "Saint-Marin"),
            correctIndex = 2,
            rating = 900,
            explanation = "Le Vatican est le plus petit État indépendant du monde, avec une superficie d'à peine 0,44 km² et environ 800 habitants. Enclavé dans Rome, il est le siège de l'Église catholique et la résidence du pape. Créé en 1929 par les accords du Latran, il abrite la basilique Saint-Pierre et la chapelle Sixtine.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_galapagos_pays",
            title = "Pays des Galápagos",
            text = "À quel pays appartiennent les îles Galápagos ?",
            options = listOf("Pérou", "Chili", "Équateur", "Colombie"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Les îles Galápagos, situées dans l'océan Pacifique à environ 1 000 km des côtes, appartiennent à l'Équateur. C'est en observant la faune unique de cet archipel volcanique que Charles Darwin développa sa théorie de l'évolution en 1835. Les îles abritent des espèces endémiques comme les tortues géantes et les iguanes marins.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_espagne_capitale",
            title = "Capitale de l'Espagne",
            text = "Quelle est la capitale de l'Espagne ?",
            options = listOf("Barcelone", "Madrid", "Séville", "Valence"),
            correctIndex = 1,
            rating = 600,
            explanation = "Madrid est la capitale et la plus grande ville de l'Espagne, située au cœur géographique du pays sur le plateau de la Meseta. Devenue capitale au XVIe siècle sous Philippe II, elle abrite la résidence du roi ainsi que le célèbre musée du Prado. Avec plus de 3 millions d'habitants, c'est l'une des plus grandes métropoles d'Europe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_paris_fleuve",
            title = "Fleuve de Paris",
            text = "Quel fleuve traverse Paris ?",
            options = listOf("La Loire", "Le Rhône", "La Seine", "La Garonne"),
            correctIndex = 2,
            rating = 600,
            explanation = "La Seine traverse Paris d'est en ouest sur environ 13 km, séparant la rive gauche de la rive droite. Longue de 777 km, elle prend sa source en Bourgogne et se jette dans la Manche au Havre. Ses berges parisiennes sont inscrites au patrimoine mondial de l'UNESCO, et elle est traversée par 37 ponts dans la capitale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_pays_plus_peuple",
            title = "Le pays le plus peuplé",
            text = "Quel pays est le plus peuplé du monde en 2023 ?",
            options = listOf("Chine", "Inde", "États-Unis", "Indonésie"),
            correctIndex = 1,
            rating = 1150,
            explanation = "En 2023, l'Inde est devenue le pays le plus peuplé du monde, dépassant la Chine avec plus de 1,42 milliard d'habitants. Ce basculement historique s'explique par une croissance démographique indienne encore soutenue, alors que la population chinoise a commencé à décliner sous l'effet du vieillissement et de l'ancienne politique de l'enfant unique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_oural_europe_asie",
            title = "Frontière Europe-Asie",
            text = "Quelle chaîne de montagnes sépare l'Europe de l'Asie ?",
            options = listOf("Les Alpes", "Le Caucase", "L'Oural", "Les Carpates"),
            correctIndex = 2,
            rating = 1000,
            explanation = "La chaîne de l'Oural, qui traverse la Russie du nord au sud sur environ 2 500 km, est traditionnellement considérée comme la frontière naturelle entre l'Europe et l'Asie. Relativement peu élevée (son point culminant dépasse à peine 1 900 m), elle est riche en ressources minières. La ville d'Iekaterinbourg est l'une des principales agglomérations situées à proximité.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mer_morte",
            title = "L'étendue d'eau la plus salée",
            text = "Quelle est l'étendue d'eau la plus salée parmi les suivantes ?",
            options = listOf("La mer Rouge", "La mer Morte", "La mer Caspienne", "La mer Noire"),
            correctIndex = 1,
            rating = 950,
            explanation = "La mer Morte, située entre Israël, la Jordanie et la Cisjordanie, possède une salinité d'environ 34%, soit près de dix fois celle des océans. Cette concentration extrême en sel permet aux baigneurs de flotter sans effort et empêche presque toute vie aquatique, d'où son nom. Son niveau, le plus bas de la Terre, baisse chaque année.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_norvege_capitale",
            title = "Capitale de la Norvège",
            text = "Quelle est la capitale de la Norvège ?",
            options = listOf("Stockholm", "Helsinki", "Oslo", "Copenhague"),
            correctIndex = 2,
            rating = 850,
            explanation = "Oslo est la capitale de la Norvège, située au fond d'un fjord dans le sud du pays. Fondée vers l'an 1000, elle porta le nom de Christiania de 1624 à 1925 en hommage au roi Christian IV. C'est aujourd'hui le centre politique et économique du pays, ainsi que le lieu où est décerné chaque année le prix Nobel de la paix.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_kilimandjaro_continent",
            title = "Continent du Kilimandjaro",
            text = "Sur quel continent se trouve le mont Kilimandjaro ?",
            options = listOf("Asie", "Afrique", "Amérique du Sud", "Océanie"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Kilimandjaro, situé en Tanzanie, est le plus haut sommet d'Afrique avec ses 5 895 mètres. Ce volcan endormi est aussi la plus haute montagne isolée du monde, s'élevant directement depuis la plaine environnante. Bien que situé près de l'équateur, son sommet était traditionnellement couvert de glaciers, qui fondent rapidement sous l'effet du réchauffement climatique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_ouagadougou_pays",
            title = "Capitale du Burkina Faso",
            text = "Ouagadougou est la capitale de quel pays ?",
            options = listOf("Mali", "Niger", "Burkina Faso", "Tchad"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Ouagadougou est la capitale du Burkina Faso. Son nom est souvent cité parmi les capitales les plus difficiles à orthographier pour les francophones.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_volga_pays",
            title = "Le fleuve Volga",
            text = "Dans quel pays coule intégralement la Volga ?",
            options = listOf("Ukraine", "Russie", "Kazakhstan", "Biélorussie"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La Volga est le plus long fleuve d'Europe avec environ 3 500 km. Elle traverse entièrement la Russie avant de se jeter dans la mer Caspienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_pamir_region",
            title = "Le toit du monde",
            text = "Le massif du Pamir se situe principalement dans quel pays ?",
            options = listOf("Tadjikistan", "Inde", "Mongolie", "Turquie"),
            correctIndex = 0,
            rating = 1650,
            explanation = "Le Pamir est un haut massif montagneux d'Asie centrale, principalement situé au Tadjikistan. Il est parfois surnommé le « toit du monde ».",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_reunion_ocean",
            title = "Océan de La Réunion",
            text = "Dans quel océan se trouve l'île de La Réunion ?",
            options = listOf("Pacifique", "Atlantique", "Indien", "Arctique"),
            correctIndex = 2,
            rating = 900,
            explanation = "La Réunion est un département français situé dans l'océan Indien, à l'est de Madagascar.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_amazonie_pays",
            title = "Pays de l'Amazonie",
            text = "Quel pays abrite la plus grande partie de la forêt amazonienne ?",
            options = listOf("Pérou", "Colombie", "Brésil", "Bolivie"),
            correctIndex = 2,
            rating = 950,
            explanation = "Près de 60 % de la forêt amazonienne se trouve au Brésil. Cette forêt tropicale est la plus vaste du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_cap_horn",
            title = "Le cap Horn",
            text = "Le cap Horn se situe à l'extrémité de quel continent ?",
            options = listOf("Afrique", "Amérique du Nord", "Océanie", "Amérique du Sud"),
            correctIndex = 3,
            rating = 1250,
            explanation = "Le cap Horn marque l'extrémité méridionale de l'archipel de la Terre de Feu, au sud de l'Amérique du Sud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_luxembourg_frontiere",
            title = "Voisin du Luxembourg",
            text = "Lequel de ces pays ne possède pas de frontière avec le Luxembourg ?",
            options = listOf("Belgique", "France", "Allemagne", "Pays-Bas"),
            correctIndex = 3,
            rating = 1300,
            explanation = "Le Luxembourg partage ses frontières avec la France, la Belgique et l'Allemagne, mais pas avec les Pays-Bas.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_everglades_etat",
            title = "Les Everglades",
            text = "Dans quel État américain se trouvent les Everglades ?",
            options = listOf("Texas", "Floride", "Louisiane", "Californie"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Les Everglades sont une vaste région marécageuse subtropicale située dans le sud de la Floride.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_singapour_statut",
            title = "Singapour",
            text = "Singapour est principalement considéré comme quoi ?",
            options = listOf("Une province", "Une île dépendante", "Une cité-État", "Une région autonome"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Singapour est une cité-État souveraine d'Asie du Sud-Est, composée d'une île principale et de plusieurs îlots.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_nil_blanc_source",
            title = "Source du Nil Blanc",
            text = "Le Nil Blanc est généralement considéré comme prenant sa source dans quel grand lac africain ?",
            options = listOf("Lac Victoria", "Lac Tchad", "Lac Malawi", "Lac Turkana"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Le Nil Blanc est traditionnellement associé au lac Victoria, même si ses sources les plus lointaines font encore l'objet de discussions géographiques.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_macao_statut",
            title = "Statut de Macao",
            text = "Macao est une région administrative spéciale de quel pays ?",
            options = listOf("Japon", "Chine", "Corée du Sud", "Vietnam"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Macao est revenue sous souveraineté chinoise en 1999 après plus de quatre siècles d'administration portugaise.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_karakoram",
            title = "Massif du K2",
            text = "Dans quelle chaîne de montagnes se situe le K2 ?",
            options = listOf("Himalaya", "Andes", "Karakoram", "Caucase"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Le K2, deuxième sommet du monde, culmine à 8 611 mètres dans la chaîne du Karakoram.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_copenhague_detroit",
            title = "Capitale du Danemark",
            text = "Sur quelle île se trouve principalement Copenhague ?",
            options = listOf("Fionie", "Bornholm", "Seeland", "Lolland"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Copenhague est située principalement sur l'île de Seeland, la plus grande île du Danemark.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_suriname_capitale",
            title = "Capitale du Suriname",
            text = "Quelle est la capitale du Suriname ?",
            options = listOf("Paramaribo", "Georgetown", "Cayenne", "Belmopan"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Paramaribo est la capitale du Suriname, petit État situé sur la côte nord de l'Amérique du Sud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_gobi_continent",
            title = "Le désert de Gobi",
            text = "Sur quel continent se trouve le désert de Gobi ?",
            options = listOf("Afrique", "Asie", "Océanie", "Europe"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le désert de Gobi s'étend entre la Mongolie et la Chine. C'est l'un des plus grands déserts du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_madere_pays",
            title = "Archipel de Madère",
            text = "À quel pays appartient l'archipel de Madère ?",
            options = listOf("Espagne", "Portugal", "Maroc", "France"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Madère est une région autonome du Portugal située dans l'océan Atlantique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_tasmanie_pays",
            title = "Île de Tasmanie",
            text = "La Tasmanie appartient à quel pays ?",
            options = listOf("Nouvelle-Zélande", "Australie", "Papouasie-Nouvelle-Guinée", "Indonésie"),
            correctIndex = 1,
            rating = 1000,
            explanation = "La Tasmanie est un État australien situé au sud du continent, séparé par le détroit de Bass.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_zambeze_chute",
            title = "Fleuve des chutes Victoria",
            text = "Quel fleuve forme les chutes Victoria ?",
            options = listOf("Congo", "Orange", "Zambèze", "Limpopo"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Les impressionnantes chutes Victoria, situées entre la Zambie et le Zimbabwe, sont formées par le fleuve Zambèze.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_bosphore_villes",
            title = "Le Bosphore",
            text = "Quelle grande ville est traversée par le détroit du Bosphore ?",
            options = listOf("Athènes", "Istanbul", "Le Caire", "Beyrouth"),
            correctIndex = 1,
            rating = 900,
            explanation = "Istanbul est la seule grande métropole située à cheval sur deux continents : l'Europe et l'Asie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_antarctique_population",
            title = "Habitants de l'Antarctique",
            text = "Quelle est la population permanente de l'Antarctique ?",
            options = listOf("Environ 10 000 habitants", "Environ 100 000 habitants", "Aucune", "Environ 1 million d'habitants"),
            correctIndex = 2,
            rating = 1100,
            explanation = "L'Antarctique ne possède aucune population permanente. Seuls des chercheurs y séjournent temporairement dans des bases scientifiques.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_svalbard_pays",
            title = "Archipel du Svalbard",
            text = "Le Svalbard est un archipel placé sous la souveraineté de quel pays ?",
            options = listOf("Islande", "Norvège", "Danemark", "Finlande"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le Svalbard est un archipel arctique sous souveraineté norvégienne. Il est connu pour ses glaciers, ses ours polaires et la réserve mondiale de semences installée près de Longyearbyen.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_orenoque_pays",
            title = "Le fleuve Orénoque",
            text = "Le fleuve Orénoque traverse principalement quel pays ?",
            options = listOf("Colombie", "Pérou", "Venezuela", "Équateur"),
            correctIndex = 2,
            rating = 1300,
            explanation = "L'Orénoque est l'un des plus grands fleuves d'Amérique du Sud. Il traverse principalement le Venezuela avant de se jeter dans l'océan Atlantique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_maldives_point_haut",
            title = "Pays le moins élevé",
            text = "Quel pays possède l'altitude moyenne la plus basse du monde ?",
            options = listOf("Bahreïn", "Maldives", "Singapour", "Qatar"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Les Maldives possèdent une altitude moyenne d'environ 1,5 mètre au-dessus du niveau de la mer, ce qui en fait le pays le plus vulnérable à la montée des océans.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_lac_geneve_nom",
            title = "Autre nom du lac Léman",
            text = "Sous quel autre nom le lac Léman est-il souvent connu ?",
            options = listOf("Lac de Genève", "Lac de Zurich", "Lac de Constance", "Lac Majeur"),
            correctIndex = 0,
            rating = 950,
            explanation = "Le lac Léman est souvent appelé lac de Genève à l'international, bien qu'il soit partagé entre la Suisse et la France.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_timor_oriental_capitale",
            title = "Capitale du Timor oriental",
            text = "Quelle est la capitale du Timor oriental ?",
            options = listOf("Dili", "Manille", "Bandar Seri Begawan", "Port Moresby"),
            correctIndex = 0,
            rating = 1750,
            explanation = "Dili est la capitale du Timor oriental, l'un des plus jeunes États indépendants du monde, devenu souverain en 2002.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_iles_canaries_pays",
            title = "Souveraineté des Canaries",
            text = "Les îles Canaries appartiennent à quel pays ?",
            options = listOf("Portugal", "Maroc", "Espagne", "Cap-Vert"),
            correctIndex = 2,
            rating = 900,
            explanation = "Les îles Canaries sont une communauté autonome espagnole située dans l'océan Atlantique au large des côtes africaines.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_detroit_malacca",
            title = "Le détroit de Malacca",
            text = "Le détroit de Malacca sépare la péninsule Malaise de quelle grande île ?",
            options = listOf("Bornéo", "Java", "Sumatra", "Sulawesi"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Le détroit de Malacca sépare la péninsule Malaise de l'île indonésienne de Sumatra. C'est l'une des voies maritimes les plus fréquentées du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_athabasca_lac",
            title = "Lac Athabasca",
            text = "Dans quel pays se trouve le lac Athabasca ?",
            options = listOf("États-Unis", "Canada", "Russie", "Suède"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Le lac Athabasca est situé dans l'ouest du Canada, à cheval sur les provinces de l'Alberta et de la Saskatchewan.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_fleuve_rhin_source",
            title = "Source du Rhin",
            text = "Dans quel pays se situe la source du Rhin ?",
            options = listOf("Allemagne", "Autriche", "Suisse", "France"),
            correctIndex = 2,
            rating = 1400,
            explanation = "Le Rhin prend sa source dans les Alpes suisses avant de traverser plusieurs pays européens et de se jeter dans la mer du Nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_k2_frontiere",
            title = "Frontière du K2",
            text = "Le K2 se situe à la frontière entre le Pakistan et quel autre pays ?",
            options = listOf("Népal", "Chine", "Inde", "Afghanistan"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Le K2 se trouve dans le massif du Karakoram, à la frontière entre le Pakistan et la Chine. Il est considéré comme l'un des sommets les plus difficiles au monde.",
            category = Category.GEOGRAPHIE
        ),

        // ===================== HISTOIRE =====================
        Question(
            id = "hist_revolution_francaise",
            title = "Année de la Révolution française",
            text = "En quelle année a eu lieu la Révolution française ?",
            options = listOf("1776", "1804", "1789", "1815"),
            correctIndex = 2,
            rating = 750,
            explanation = "La Révolution française débuta en 1789 avec la prise de la Bastille le 14 juillet, événement commémoré chaque année comme fête nationale en France. Elle mit fin à la monarchie absolue et aboutit à la Déclaration des droits de l'homme et du citoyen. Cette période bouleversa profondément la société française et influença durablement le monde entier.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premier_president_us",
            title = "Premier président des États-Unis",
            text = "Qui était le premier président des États-Unis ?",
            options = listOf("Benjamin Franklin", "Thomas Jefferson", "Abraham Lincoln", "George Washington"),
            correctIndex = 3,
            rating = 750,
            explanation = "George Washington fut le premier président des États-Unis, élu en 1789 et réélu en 1792. Général en chef des armées lors de la guerre d'Indépendance, il présida ensuite la Convention constitutionnelle de 1787. Il refusa un troisième mandat, établissant ainsi une tradition codifiée bien plus tard par le 22e amendement en 1951.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_debarquement_normandie",
            title = "Année du débarquement en Normandie",
            text = "En quelle année a eu lieu le débarquement en Normandie ?",
            options = listOf("1942", "1943", "1944", "1945"),
            correctIndex = 2,
            rating = 800,
            explanation = "Le débarquement en Normandie, nom de code Opération Overlord, eut lieu le 6 juin 1944 — le \"Jour J\". Il s'agit de la plus grande opération amphibie de l'histoire, mobilisant près de 156 000 soldats alliés sur cinq plages normandes : Utah, Omaha, Gold, Juno et Sword. Cette offensive marqua le début de la libération de l'Europe occidentale.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_colisee_empire",
            title = "Empire bâtisseur du Colisée",
            text = "Quel empire a construit le Colisée de Rome ?",
            options = listOf("L'Empire grec", "L'Empire romain", "L'Empire ottoman", "L'Empire byzantin"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Colisée, ou amphithéâtre Flavien, fut construit sous l'Empire romain entre 70 et 80 apr. J.-C., sous les empereurs Vespasien et Titus. Il pouvait accueillir entre 50 000 et 80 000 spectateurs pour des combats de gladiateurs et des chasses aux animaux sauvages. C'est aujourd'hui le monument le plus visité d'Italie.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_napoleon_naissance",
            title = "Île natale de Napoléon",
            text = "Dans quelle île est né Napoléon Bonaparte ?",
            options = listOf("Sardaigne", "Malte", "Corse", "Sicile"),
            correctIndex = 2,
            rating = 900,
            explanation = "Napoléon Bonaparte est né le 15 août 1769 à Ajaccio, en Corse, un an seulement après le rattachement de l'île à la France. D'abord officier d'artillerie, il s'illustra lors des guerres révolutionnaires avant de devenir Premier Consul en 1799, puis Empereur des Français en 1804. Son règne donna notamment naissance au Code civil, toujours en vigueur aujourd'hui.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premiere_guerre_mondiale",
            title = "Début de la Première Guerre mondiale",
            text = "En quelle année a commencé la Première Guerre mondiale ?",
            options = listOf("1914", "1916", "1918", "1912"),
            correctIndex = 0,
            rating = 750,
            explanation = "La Première Guerre mondiale débuta en 1914, déclenchée par l'assassinat de l'archiduc François-Ferdinand à Sarajevo le 28 juin. Ce conflit opposa les puissances de l'Entente aux Empires centraux et fit environ 10 millions de morts militaires. Surnommée la \"Grande Guerre\", elle s'acheva le 11 novembre 1918 par l'armistice signé à Rethondes.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_mur_berlin",
            title = "Le mur tombé en 1989",
            text = "Quel mur est tombé en 1989 ?",
            options = listOf("Le mur d'Hadrien", "Le mur de Berlin", "La Grande Muraille", "Le mur des Lamentations"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le mur de Berlin, qui séparait la ville en deux depuis 1961, tomba le 9 novembre 1989. Érigé par la RDA communiste pour empêcher la fuite de ses habitants vers l'Ouest, il était devenu le symbole de la guerre froide et du rideau de fer. Sa chute précipita la réunification de l'Allemagne, officialisée le 3 octobre 1990.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_pyramides_gizeh",
            title = "Bâtisseurs des pyramides de Gizeh",
            text = "Quelle civilisation a construit les pyramides de Gizeh ?",
            options = listOf("Les Romains", "Les Grecs", "Les Égyptiens", "Les Mayas"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les pyramides de Gizeh furent construites par les anciens Égyptiens vers 2 500 av. J.-C., sous la IVe dynastie. La plus grande, la pyramide de Khéops, est la seule des sept merveilles du monde antique encore debout. Ces monuments colossaux servaient de tombeaux aux pharaons et témoignent d'une maîtrise architecturale exceptionnelle pour l'époque.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premier_homme_lune",
            title = "Premier homme sur la Lune",
            text = "En quelle année l'homme a-t-il marché sur la Lune pour la première fois ?",
            options = listOf("1965", "1969", "1972", "1959"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le 21 juillet 1969, l'astronaute américain Neil Armstrong devint le premier homme à poser le pied sur la Lune lors de la mission Apollo 11, prononçant la célèbre phrase \"un petit pas pour l'homme, un bond de géant pour l'humanité\". Buzz Aldrin le rejoignit, tandis que Michael Collins restait en orbite. L'exploit fut suivi en direct par des centaines de millions de téléspectateurs.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_colomb_amerique",
            title = "Le navigateur de 1492",
            text = "Quel navigateur a atteint l'Amérique en 1492 ?",
            options = listOf("Vasco de Gama", "Christophe Colomb", "Magellan", "Amerigo Vespucci"),
            correctIndex = 1,
            rating = 750,
            explanation = "Christophe Colomb, navigateur génois au service de la couronne d'Espagne, atteignit les Antilles en 1492 en cherchant une route maritime vers les Indes par l'ouest. Persuadé jusqu'à sa mort d'avoir atteint l'Asie, il ne sut jamais qu'il avait \"découvert\" un nouveau continent. Celui-ci fut finalement baptisé Amérique en référence à Amerigo Vespucci.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_cleopatre",
            title = "Reine d'Égypte de César et Marc Antoine",
            text = "Quelle reine d'Égypte s'est alliée à Jules César et Marc Antoine ?",
            options = listOf("Néfertiti", "Cléopâtre", "Hatchepsout", "Néfertari"),
            correctIndex = 1,
            rating = 900,
            explanation = "Cléopâtre VII, dernière souveraine de l'Égypte ptolémaïque, noua des alliances politiques et amoureuses avec les Romains Jules César puis Marc Antoine. Femme cultivée parlant plusieurs langues, elle chercha à préserver l'indépendance de son royaume. Après la défaite d'Actium en 31 av. J.-C., elle se serait suicidée, dit-on, par la morsure d'un aspic.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_roi_soleil",
            title = "Le « Roi-Soleil »",
            text = "Quel roi de France était surnommé le \"Roi-Soleil\" ?",
            options = listOf("Louis XIV", "Louis XVI", "François Ier", "Henri IV"),
            correctIndex = 0,
            rating = 850,
            explanation = "Louis XIV, qui régna de 1643 à 1715, est surnommé le \"Roi-Soleil\" en référence à l'astre qu'il choisit comme emblème. Son règne de 72 ans, le plus long de l'histoire de France, incarna l'apogée de la monarchie absolue. Il fit construire le château de Versailles, où il concentra la noblesse pour mieux la contrôler.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_guerre_cent_ans",
            title = "Adversaire de la guerre de Cent Ans",
            text = "La guerre de Cent Ans a opposé la France à quel pays ?",
            options = listOf("L'Espagne", "L'Angleterre", "L'Allemagne", "L'Italie"),
            correctIndex = 1,
            rating = 950,
            explanation = "La guerre de Cent Ans (1337-1453) opposa le royaume de France à celui d'Angleterre, principalement pour des questions de succession au trône français. Malgré des défaites cuisantes comme Azincourt, la France finit par l'emporter, portée notamment par Jeanne d'Arc qui contribua à délivrer Orléans en 1429. Le conflit forgea le sentiment national des deux nations.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_fin_seconde_guerre",
            title = "Fin de la Seconde Guerre mondiale",
            text = "En quelle année s'est terminée la Seconde Guerre mondiale ?",
            options = listOf("1944", "1945", "1946", "1943"),
            correctIndex = 1,
            rating = 700,
            explanation = "La Seconde Guerre mondiale s'acheva en 1945 : en Europe avec la capitulation de l'Allemagne nazie le 8 mai, puis dans le Pacifique avec la reddition du Japon le 2 septembre, après les bombardements atomiques d'Hiroshima et Nagasaki. Ce conflit, le plus meurtrier de l'histoire, fit environ 60 millions de morts et redessina l'ordre mondial.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_waterloo",
            title = "Empereur défait à Waterloo",
            text = "Quel empereur français a été défait à Waterloo en 1815 ?",
            options = listOf("Louis XVIII", "Napoléon Ier", "Charles X", "Napoléon III"),
            correctIndex = 1,
            rating = 900,
            explanation = "Napoléon Ier subit sa défaite finale à la bataille de Waterloo, en Belgique, le 18 juin 1815, face aux armées britannique et prussienne commandées par Wellington et Blücher. Cette défaite mit fin aux Cent-Jours et à son règne. Exilé sur l'île de Sainte-Hélène, dans l'Atlantique Sud, il y mourut en 1821.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_sparte_athenes",
            title = "Rivale militaire d'Athènes",
            text = "Quelle cité grecque antique était la grande rivale militaire d'Athènes ?",
            options = listOf("Thèbes", "Corinthe", "Sparte", "Olympie"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Sparte, célèbre pour sa société militarisée et la discipline de fer de ses citoyens-soldats, fut la grande rivale d'Athènes durant l'Antiquité. Les deux cités s'affrontèrent notamment lors de la guerre du Péloponnèse (431-404 av. J.-C.), qui se solda par la victoire de Sparte. L'éducation spartiate, ou \"agogè\", est restée légendaire pour sa rigueur.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_lincoln_esclavage",
            title = "Président abolitionniste de l'esclavage",
            text = "Quel président américain a aboli l'esclavage ?",
            options = listOf("George Washington", "Thomas Jefferson", "Abraham Lincoln", "Franklin Roosevelt"),
            correctIndex = 2,
            rating = 900,
            explanation = "Abraham Lincoln, 16e président des États-Unis, joua un rôle décisif dans l'abolition de l'esclavage avec la Proclamation d'émancipation de 1863, puis le 13e amendement de la Constitution en 1865. Sa présidence fut marquée par la guerre de Sécession qui déchira le pays. Il fut assassiné en avril 1865, quelques jours après la victoire de l'Union.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_magellan_tour_monde",
            title = "Premier tour du monde maritime",
            text = "Quel explorateur est associé au premier tour du monde maritime ?",
            options = listOf("Christophe Colomb", "Vasco de Gama", "Fernand de Magellan", "Marco Polo"),
            correctIndex = 2,
            rating = 1100,
            explanation = "L'expédition lancée par le navigateur portugais Fernand de Magellan en 1519 réalisa le premier tour du monde maritime. Magellan mourut toutefois en chemin, aux Philippines en 1521, et c'est son second Juan Sebastián Elcano qui ramena en 1522 l'unique navire survivant en Espagne. Ce périple démontra concrètement la rotondité de la Terre.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_pompei_vesuve",
            title = "Catastrophe de Pompéi",
            text = "Quelle catastrophe a détruit la cité de Pompéi en 79 apr. J.-C. ?",
            options = listOf("Un tremblement de terre", "L'éruption du Vésuve", "Une inondation", "Un grand incendie"),
            correctIndex = 1,
            rating = 1000,
            explanation = "En 79 apr. J.-C., l'éruption du Vésuve ensevelit la ville romaine de Pompéi sous plusieurs mètres de cendres et de pierres ponces, figeant la cité et ses habitants dans l'instant. Redécouvert au XVIIIe siècle, le site offre un témoignage exceptionnel de la vie quotidienne romaine. La proche ville d'Herculanum subit le même sort.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_hitler_allemagne",
            title = "Chef de l'Allemagne en 39-45",
            text = "Qui était le chef de l'Allemagne durant la Seconde Guerre mondiale ?",
            options = listOf("Benito Mussolini", "Joseph Staline", "Adolf Hitler", "Francisco Franco"),
            correctIndex = 2,
            rating = 600,
            explanation = "Adolf Hitler dirigea l'Allemagne nazie de 1933 à 1945 en tant que chancelier puis Führer. Son idéologie raciste et expansionniste plongea le monde dans la Seconde Guerre mondiale et conduisit au génocide de six millions de Juifs lors de la Shoah. Acculé par la défaite, il se suicida dans son bunker à Berlin en avril 1945.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_hammurabi_code",
            title = "Le code d'Hammurabi",
            text = "Dans quelle civilisation le code d'Hammurabi a-t-il été rédigé ?",
            options = listOf("Égypte antique", "Babylone", "Empire perse", "Grèce antique"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le code d'Hammurabi est l'un des plus anciens recueils de lois connus. Il fut rédigé vers 1750 av. J.-C. sous le règne du roi Hammurabi de Babylone, en Mésopotamie.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_constantinople_prise",
            title = "Chute de Constantinople",
            text = "En quelle année Constantinople est-elle tombée aux mains des Ottomans ?",
            options = listOf("1453", "1492", "1415", "1520"),
            correctIndex = 0,
            rating = 1350,
            explanation = "La prise de Constantinople par les Ottomans en 1453 marque traditionnellement la fin du Moyen Âge et la disparition de l'Empire byzantin.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_charlemagne_empereur",
            title = "Couronnement de Charlemagne",
            text = "Qui a couronné Charlemagne empereur en l'an 800 ?",
            options = listOf("Le pape Léon III", "Le pape Urbain II", "Saint Benoît", "Clovis"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Le pape Léon III couronna Charlemagne empereur d'Occident à Rome le jour de Noël de l'an 800.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_magna_carta",
            title = "La Magna Carta",
            text = "Dans quel pays la Magna Carta a-t-elle été signée en 1215 ?",
            options = listOf("France", "Angleterre", "Écosse", "Irlande"),
            correctIndex = 1,
            rating = 1300,
            explanation = "La Magna Carta fut signée par le roi Jean sans Terre en Angleterre. Elle est considérée comme un texte fondateur des libertés publiques.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_gutenberg_imprimerie",
            title = "Inventeur de l'imprimerie moderne",
            text = "Quel inventeur est associé à l'imprimerie à caractères mobiles en Europe ?",
            options = listOf("Léonard de Vinci", "Johannes Gutenberg", "Galilée", "Nicolas Copernic"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Johannes Gutenberg développa l'imprimerie à caractères mobiles vers 1450, révolutionnant la diffusion du savoir en Europe.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_boston_tea_party",
            title = "La Boston Tea Party",
            text = "La Boston Tea Party de 1773 est un événement marquant de l'histoire de quel pays ?",
            options = listOf("Canada", "Royaume-Uni", "États-Unis", "Australie"),
            correctIndex = 2,
            rating = 1250,
            explanation = "La Boston Tea Party fut une protestation contre les taxes britanniques et contribua au déclenchement de la guerre d'indépendance américaine.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_versailles_traite",
            title = "Traité de Versailles",
            text = "Quel conflit prend officiellement fin avec le traité de Versailles de 1919 ?",
            options = listOf("Guerre de Crimée", "Première Guerre mondiale", "Seconde Guerre mondiale", "Guerre franco-prussienne"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le traité de Versailles fut signé en 1919 et imposa de lourdes réparations à l'Allemagne après la Première Guerre mondiale.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_louisiane_vente",
            title = "Achat de la Louisiane",
            text = "Quel pays a vendu la Louisiane aux États-Unis en 1803 ?",
            options = listOf("Espagne", "France", "Royaume-Uni", "Mexique"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Napoléon Bonaparte vendit la Louisiane aux États-Unis en 1803, doublant presque la superficie du jeune pays.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_jeanne_arc_ville",
            title = "Jeanne d'Arc",
            text = "Quelle ville Jeanne d'Arc a-t-elle contribué à libérer en 1429 ?",
            options = listOf("Paris", "Rouen", "Orléans", "Reims"),
            correctIndex = 2,
            rating = 950,
            explanation = "Jeanne d'Arc joua un rôle décisif dans la levée du siège d'Orléans pendant la guerre de Cent Ans.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_suez_ouverture",
            title = "Canal de Suez",
            text = "En quelle année le canal de Suez a-t-il été inauguré ?",
            options = listOf("1869", "1815", "1905", "1920"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Le canal de Suez fut inauguré en 1869. Il relie la Méditerranée à la mer Rouge et raccourcit considérablement les routes maritimes.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_spoutnik",
            title = "Premier satellite artificiel",
            text = "Quel pays a lancé Spoutnik 1 en 1957 ?",
            options = listOf("États-Unis", "URSS", "France", "Royaume-Uni"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Spoutnik 1, lancé par l'Union soviétique en 1957, fut le premier satellite artificiel de l'histoire.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_alexandre_empire",
            title = "Alexandre le Grand",
            text = "Alexandre le Grand était roi de quel royaume ?",
            options = listOf("Macédoine", "Perse", "Égypte", "Sparte"),
            correctIndex = 0,
            rating = 1000,
            explanation = "Alexandre le Grand était roi de Macédoine. Ses conquêtes créèrent l'un des plus vastes empires du monde antique.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_rosa_parks",
            title = "Rosa Parks",
            text = "Dans quel pays Rosa Parks est-elle devenue une figure des droits civiques ?",
            options = listOf("Afrique du Sud", "Canada", "États-Unis", "Royaume-Uni"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Rosa Parks refusa de céder sa place dans un bus en 1955, devenant un symbole du mouvement américain des droits civiques.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_muraille_chine",
            title = "La Grande Muraille",
            text = "La Grande Muraille a été construite pour protéger la Chine principalement contre quels peuples ?",
            options = listOf("Les Vikings", "Les Mongols", "Les Romains", "Les Perses"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La Grande Muraille visait notamment à protéger les territoires chinois contre les incursions des peuples nomades du nord, dont les Mongols.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_titanic_annee",
            title = "Naufrage du Titanic",
            text = "En quelle année le Titanic a-t-il sombré ?",
            options = listOf("1905", "1912", "1918", "1923"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Titanic heurta un iceberg dans l'Atlantique Nord et coula dans la nuit du 14 au 15 avril 1912.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_yalta_conference",
            title = "Conférence de Yalta",
            text = "Quels dirigeants participèrent à la conférence de Yalta en 1945 ?",
            options = listOf("Churchill, Roosevelt et Staline", "Hitler, Mussolini et Franco", "Kennedy, Khrouchtchev et De Gaulle", "Wilson, Clemenceau et Lloyd George"),
            correctIndex = 0,
            rating = 1500,
            explanation = "La conférence de Yalta réunit Churchill, Roosevelt et Staline afin de préparer l'organisation du monde après la Seconde Guerre mondiale.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_canal_panama",
            title = "Canal de Panama",
            text = "Quel océan le canal de Panama permet-il de rejoindre depuis l'Atlantique ?",
            options = listOf("Arctique", "Indien", "Pacifique", "Austral"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le canal de Panama relie l'océan Atlantique (via la mer des Caraïbes) à l'océan Pacifique.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_bastille_prison",
            title = "Prise de la Bastille",
            text = "La Bastille prise le 14 juillet 1789 était principalement quoi ?",
            options = listOf("Un palais royal", "Une prison fortifiée", "Une cathédrale", "Une caserne navale"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Bastille était une forteresse servant notamment de prison d'État. Sa prise symbolisa la chute de l'absolutisme royal.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_inde_independance",
            title = "Indépendance de l'Inde",
            text = "En quelle année l'Inde a-t-elle obtenu son indépendance du Royaume-Uni ?",
            options = listOf("1947", "1935", "1955", "1962"),
            correctIndex = 0,
            rating = 1150,
            explanation = "L'Inde est devenue indépendante le 15 août 1947, après des décennies de revendications menées notamment par Gandhi.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_bering_explorateur",
            title = "Le détroit de Béring",
            text = "Le détroit de Béring doit son nom à quel explorateur ?",
            options = listOf("Vitus Béring", "James Cook", "Amerigo Vespucci", "Abel Tasman"),
            correctIndex = 0,
            rating = 1650,
            explanation = "Le navigateur danois Vitus Béring explora cette région au XVIIIe siècle au service de l'Empire russe. Le détroit séparant l'Asie de l'Amérique porte aujourd'hui son nom.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_bataille_hastings",
            title = "Bataille d'Hastings",
            text = "Quelle bataille de 1066 permit à Guillaume le Conquérant de devenir roi d'Angleterre ?",
            options = listOf("Azincourt", "Hastings", "Poitiers", "Bouvines"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La bataille d'Hastings, remportée par Guillaume de Normandie en 1066, marque le début de la conquête normande de l'Angleterre et transforma durablement l'histoire du pays.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_marco_polo_destination",
            title = "Voyage de Marco Polo",
            text = "Quelle cour impériale Marco Polo affirme-t-il avoir fréquentée au XIIIe siècle ?",
            options = listOf("Charlemagne", "Gengis Khan", "Kubilaï Khan", "Soliman le Magnifique"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Selon son célèbre récit de voyage, Marco Polo séjourna à la cour de Kubilaï Khan, souverain mongol et fondateur de la dynastie Yuan en Chine.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_louis_xvi_execution",
            title = "Exécution de Louis XVI",
            text = "Par quel moyen Louis XVI fut-il exécuté en 1793 ?",
            options = listOf("Pendaison", "Fusillade", "Guillotine", "Décapitation à l'épée"),
            correctIndex = 2,
            rating = 850,
            explanation = "Louis XVI fut guillotiné le 21 janvier 1793 sur la place de la Révolution à Paris, aujourd'hui place de la Concorde.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_carthage_general",
            title = "Le général carthaginois",
            text = "Quel chef militaire carthaginois traversa les Alpes avec des éléphants ?",
            options = listOf("Scipion", "Hannibal", "Jules César", "Périclès"),
            correctIndex = 1,
            rating = 950,
            explanation = "Hannibal mena une spectaculaire expédition à travers les Alpes pendant la deuxième guerre punique afin d'attaquer Rome par surprise.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_rideau_fer",
            title = "Le rideau de fer",
            text = "Quelle période historique est associée à l'expression « rideau de fer » ?",
            options = listOf("La Renaissance", "La guerre froide", "Les Croisades", "La Révolution industrielle"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Le rideau de fer désignait la séparation politique, idéologique et militaire entre l'Europe de l'Est et l'Europe de l'Ouest durant la guerre froide.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_pizarro_empire",
            title = "Conquête des Incas",
            text = "Quel conquistador espagnol renversa l'Empire inca au XVIe siècle ?",
            options = listOf("Hernán Cortés", "Francisco Pizarro", "Vasco de Gama", "Fernand de Magellan"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Francisco Pizarro captura l'empereur Atahualpa en 1532 et participa à la conquête de l'Empire inca dans l'actuel Pérou.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_trafalgar_bataille",
            title = "Victoire de Trafalgar",
            text = "Quelle marine remporta la bataille de Trafalgar en 1805 ?",
            options = listOf("Espagnole", "Française", "Britannique", "Prussienne"),
            correctIndex = 2,
            rating = 1450,
            explanation = "La Royal Navy britannique, commandée par l'amiral Nelson, remporta une victoire décisive contre les flottes française et espagnole.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_peste_noire",
            title = "La peste noire",
            text = "Au cours de quel siècle la peste noire a-t-elle ravagé l'Europe ?",
            options = listOf("XIe siècle", "XIIIe siècle", "XIVe siècle", "XVIe siècle"),
            correctIndex = 2,
            rating = 1100,
            explanation = "La peste noire frappa l'Europe à partir de 1347 et provoqua la mort de plusieurs dizaines de millions de personnes.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_suffrage_femmes_france",
            title = "Vote des femmes en France",
            text = "En quelle année les femmes ont-elles obtenu le droit de vote en France ?",
            options = listOf("1918", "1936", "1944", "1958"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Les femmes obtinrent le droit de vote en France en 1944 et participèrent pour la première fois à des élections nationales en 1945.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_apollo11_nom",
            title = "Mission Apollo 11",
            text = "Comment s'appelait le module lunaire d'Apollo 11 ?",
            options = listOf("Columbia", "Eagle", "Discovery", "Atlantis"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Le module lunaire Eagle transporta Neil Armstrong et Buzz Aldrin jusqu'à la surface de la Lune en juillet 1969, tandis que Columbia restait en orbite lunaire.",
            category = Category.HISTOIRE
        ),

        // ===================== SCIENCES & NATURE =====================
        Question(
            id = "sci_hexagone_cotes",
            title = "Côtés d'un hexagone",
            text = "Combien de côtés a un hexagone ?",
            options = listOf("6", "5", "7", "8"),
            correctIndex = 0,
            rating = 600,
            explanation = "Un hexagone est un polygone à 6 côtés et 6 angles. La France est d'ailleurs surnommée \"l'Hexagone\" en raison de la forme approximativement hexagonale de son territoire métropolitain. Un hexagone régulier possède tous ses côtés et angles égaux ; la somme de ses angles intérieurs est de 720°. On retrouve cette forme dans les alvéoles construites par les abeilles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_symbole_or",
            title = "Élément de symbole « Au »",
            text = "Quel est l'élément chimique dont le symbole est \"Au\" ?",
            options = listOf("Argent", "Aluminium", "Or", "Azote"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le symbole chimique \"Au\" vient du latin \"aurum\", qui signifie or. L'or est un métal précieux de numéro atomique 79, résistant à la corrosion et à l'oxydation. Utilisé depuis l'Antiquité pour la joaillerie et la monnaie, il est aujourd'hui indispensable en électronique de précision. Chaque smartphone contient de petites quantités d'or dans ses circuits.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_planete_proche_soleil",
            title = "Planète la plus proche du Soleil",
            text = "Quelle planète est la plus proche du Soleil ?",
            options = listOf("Mercure", "Vénus", "Mars", "Terre"),
            correctIndex = 0,
            rating = 850,
            explanation = "Mercure est la planète la plus proche du Soleil, à une distance moyenne de 57,9 millions de km. Malgré cela, Mercure n'est pas la planète la plus chaude : c'est Vénus, dont l'épaisse atmosphère génère un fort effet de serre maintenant une température moyenne de 462°C. Mercure connaît quant à elle des extrêmes allant de −180°C la nuit à +430°C le jour.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_inventeur_telephone",
            title = "Inventeur du téléphone",
            text = "Qui a inventé le téléphone ?",
            options = listOf("Thomas Edison", "Nikola Tesla", "Alexander Graham Bell", "Guglielmo Marconi"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Alexander Graham Bell obtint le premier brevet du téléphone en 1876. L'invention est néanmoins controversée : l'Italien Antonio Meucci avait déposé une pré-demande de brevet dès 1871, mais n'avait pas les moyens de la renouveler. En 2002, le Congrès américain a officiellement reconnu la contribution de Meucci à l'invention du téléphone.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_formule_eau",
            title = "Formule chimique de l'eau",
            text = "Quelle est la formule chimique de l'eau ?",
            options = listOf("H₂O", "CO₂", "NaCl", "O₂"),
            correctIndex = 0,
            rating = 650,
            explanation = "La molécule d'eau est composée de deux atomes d'hydrogène (H) et d'un atome d'oxygène (O), d'où la formule H₂O. L'eau est la seule substance naturelle présente en abondance dans les trois états de la matière sur Terre. Elle couvre environ 71% de la surface de notre planète, mais seulement 2,5% est de l'eau douce, dont la majeure partie est piégée dans les glaces polaires.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_penicilline_fleming",
            title = "Découvreur de la pénicilline",
            text = "Qui a découvert la pénicilline ?",
            options = listOf("Louis Pasteur", "Alexander Fleming", "Marie Curie", "Albert Einstein"),
            correctIndex = 1,
            rating = 1050,
            explanation = "La pénicilline fut découverte par Alexander Fleming en 1928, par hasard, lorsqu'il observa qu'une moisissure (Penicillium notatum) inhibait la croissance de bactéries dans une boîte de Petri oubliée. Cette découverte révolutionna la médecine en permettant de traiter des infections jusque-là mortelles. Fleming, Howard Florey et Ernst Boris Chain reçurent le prix Nobel de médecine en 1945.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_coeur_sang",
            title = "Organe qui pompe le sang",
            text = "Quel organe pompe le sang dans le corps humain ?",
            options = listOf("Le foie", "Le cœur", "Les poumons", "Les reins"),
            correctIndex = 1,
            rating = 600,
            explanation = "Le cœur est un muscle creux qui propulse le sang dans tout l'organisme grâce à ses contractions régulières. Battant en moyenne 70 à 80 fois par minute, soit environ 100 000 fois par jour, il assure la circulation de l'oxygène et des nutriments. Il est divisé en quatre cavités : deux oreillettes et deux ventricules.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_nombre_planetes",
            title = "Nombre de planètes du système solaire",
            text = "Combien de planètes compte le système solaire ?",
            options = listOf("7", "8", "9", "10"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le système solaire compte officiellement 8 planètes depuis 2006 : Mercure, Vénus, la Terre, Mars, Jupiter, Saturne, Uranus et Neptune. Pluton, longtemps considérée comme la neuvième, a été reclassée en \"planète naine\" par l'Union astronomique internationale en raison de sa petite taille et de son orbite particulière.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_photosynthese_co2",
            title = "Gaz absorbé par la photosynthèse",
            text = "Quel gaz les plantes absorbent-elles pour réaliser la photosynthèse ?",
            options = listOf("L'oxygène", "L'azote", "Le dioxyde de carbone", "L'hydrogène"),
            correctIndex = 2,
            rating = 750,
            explanation = "Lors de la photosynthèse, les plantes absorbent le dioxyde de carbone (CO₂) de l'air et, grâce à l'énergie lumineuse, le transforment en glucose tout en rejetant de l'oxygène. Ce processus, à la base de presque toute la vie sur Terre, fait des forêts et du phytoplancton océanique de véritables \"poumons\" de la planète.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_animal_plus_rapide",
            title = "L'animal terrestre le plus rapide",
            text = "Quel est l'animal terrestre le plus rapide ?",
            options = listOf("Le lion", "Le guépard", "L'antilope", "Le lévrier"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le guépard est l'animal terrestre le plus rapide : il peut atteindre une pointe de vitesse d'environ 110 km/h sur de courtes distances. Son corps fin, ses longues pattes et sa colonne vertébrale très souple en font une machine de course exceptionnelle. Il ne peut toutefois maintenir cette allure que quelques centaines de mètres avant de s'épuiser.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_vitesse_lumiere",
            title = "Vitesse de la lumière",
            text = "Quelle est approximativement la vitesse de la lumière dans le vide ?",
            options = listOf("300 000 km/s", "150 000 km/s", "1 000 km/s", "30 000 km/s"),
            correctIndex = 0,
            rating = 1000,
            explanation = "La lumière se déplace dans le vide à environ 300 000 km/s (précisément 299 792 458 m/s), une constante universelle notée \"c\". À cette vitesse, elle fait sept fois le tour de la Terre en une seconde. Selon la théorie de la relativité d'Einstein, rien ne peut dépasser cette vitesse, qui constitue une limite fondamentale de l'univers.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_nombre_os",
            title = "Nombre d'os du corps humain",
            text = "Combien d'os compte le corps humain adulte ?",
            options = listOf("186", "206", "226", "250"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le squelette d'un adulte compte 206 os. À la naissance, un bébé en possède environ 270, mais certains fusionnent au cours de la croissance, notamment au niveau du crâne et de la colonne vertébrale. Le plus long os du corps est le fémur, et le plus petit est l'étrier, situé dans l'oreille moyenne.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_metal_liquide_mercure",
            title = "Métal liquide à température ambiante",
            text = "Quel métal est liquide à température ambiante ?",
            options = listOf("Le plomb", "Le mercure", "Le fer", "L'étain"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le mercure est le seul métal qui se présente à l'état liquide à température ambiante, avec un point de fusion de −39°C. Surnommé \"vif-argent\", il était autrefois utilisé dans les thermomètres et baromètres. En raison de sa forte toxicité, son usage est aujourd'hui strictement encadré. Son symbole chimique, Hg, vient du grec \"hydrargyros\".",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_planete_rouge",
            title = "La « planète rouge »",
            text = "Quelle planète est surnommée la \"planète rouge\" ?",
            options = listOf("Vénus", "Jupiter", "Mars", "Saturne"),
            correctIndex = 2,
            rating = 600,
            explanation = "Mars est surnommée la \"planète rouge\" en raison de la couleur de sa surface, riche en oxyde de fer (la rouille). Quatrième planète du système solaire, elle fait l'objet de nombreuses missions d'exploration robotisée, comme les rovers de la NASA. On y trouve le plus haut volcan connu du système solaire, Olympus Mons, qui culmine à environ 22 km.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_darwin_evolution",
            title = "Auteur de la théorie de l'évolution",
            text = "Quel scientifique a formulé la théorie de l'évolution par sélection naturelle ?",
            options = listOf("Isaac Newton", "Charles Darwin", "Gregor Mendel", "Galilée"),
            correctIndex = 1,
            rating = 850,
            explanation = "Charles Darwin formula la théorie de l'évolution par sélection naturelle, exposée en 1859 dans son ouvrage \"De l'origine des espèces\". Selon cette théorie, les espèces évoluent au fil des générations en fonction de la survie des individus les mieux adaptés à leur environnement. Cette idée révolutionna la biologie et notre compréhension du vivant.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_plus_grand_organe_peau",
            title = "Le plus grand organe du corps",
            text = "Quel est le plus grand organe du corps humain ?",
            options = listOf("Le foie", "Les intestins", "La peau", "Les poumons"),
            correctIndex = 2,
            rating = 900,
            explanation = "La peau est le plus grand organe du corps humain : chez un adulte, elle couvre environ 2 m² et pèse près de 4 kg. Elle joue un rôle essentiel de protection contre les agressions extérieures, de régulation de la température et de perception du toucher. Elle se compose de trois couches : l'épiderme, le derme et l'hypoderme.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_gravite",
            title = "Force qui nous maintient au sol",
            text = "Quelle force nous maintient au sol ?",
            options = listOf("Le magnétisme", "La gravité", "L'électricité", "La pression"),
            correctIndex = 1,
            rating = 650,
            explanation = "La gravité, ou gravitation, est la force qui attire les corps les uns vers les autres et nous maintient à la surface de la Terre. Décrite par Isaac Newton puis approfondie par Einstein, elle dépend de la masse des objets. C'est cette même force qui maintient la Lune en orbite autour de la Terre et les planètes autour du Soleil.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_atmosphere_azote",
            title = "Gaz majoritaire de l'atmosphère",
            text = "Quel gaz compose majoritairement l'atmosphère terrestre ?",
            options = listOf("L'oxygène", "L'azote", "Le dioxyde de carbone", "L'hydrogène"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Contrairement à une idée répandue, ce n'est pas l'oxygène mais l'azote qui domine l'atmosphère terrestre, représentant environ 78% de l'air. L'oxygène n'en constitue que 21%, le reste étant composé d'argon, de dioxyde de carbone et de gaz divers. L'azote, peu réactif, joue un rôle stabilisateur essentiel pour la vie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_nombre_chromosomes",
            title = "Nombre de chromosomes humains",
            text = "Combien de chromosomes possède un être humain ?",
            options = listOf("23", "44", "46", "48"),
            correctIndex = 2,
            rating = 1000,
            explanation = "L'être humain possède 46 chromosomes, regroupés en 23 paires, dans le noyau de chacune de ses cellules. La 23e paire détermine le sexe : XX pour les femmes et XY pour les hommes. Ces chromosomes portent l'ADN, support de l'information génétique transmise de génération en génération.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_element_abondant_hydrogene",
            title = "Élément le plus abondant de l'univers",
            text = "Quel est l'élément chimique le plus abondant dans l'univers ?",
            options = listOf("L'oxygène", "L'hélium", "L'hydrogène", "Le carbone"),
            correctIndex = 2,
            rating = 1050,
            explanation = "L'hydrogène est l'élément le plus abondant de l'univers, constituant environ 75% de la matière ordinaire. C'est le carburant des étoiles : par fusion nucléaire, elles transforment l'hydrogène en hélium, libérant l'énergie qui les fait briller. Premier élément du tableau périodique, l'hydrogène est aussi le plus simple et le plus léger.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_adn_double_helice",
            title = "Découvreurs de la double hélice",
            text = "Quels scientifiques sont principalement associés à la découverte de la structure en double hélice de l'ADN ?",
            options = listOf("Watson et Crick", "Pasteur et Koch", "Curie et Curie", "Darwin et Wallace"),
            correctIndex = 0,
            rating = 1350,
            explanation = "James Watson et Francis Crick ont proposé en 1953 le modèle de la double hélice de l'ADN, en s'appuyant notamment sur les travaux expérimentaux de Rosalind Franklin et Maurice Wilkins.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_planete_geante_gazeuse",
            title = "Plus grande planète",
            text = "Quelle est la plus grande planète du système solaire ?",
            options = listOf("Saturne", "Neptune", "Jupiter", "Uranus"),
            correctIndex = 2,
            rating = 850,
            explanation = "Jupiter est la plus grande planète du système solaire. Son diamètre est d'environ 143 000 km, soit plus de 11 fois celui de la Terre.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_baleine_mammifere",
            title = "Nature de la baleine",
            text = "La baleine est classée dans quel groupe d'animaux ?",
            options = listOf("Poissons", "Mammifères", "Amphibiens", "Reptiles"),
            correctIndex = 1,
            rating = 700,
            explanation = "La baleine est un mammifère marin : elle respire de l'air avec des poumons, met bas des petits vivants et les allaite.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_unite_courant",
            title = "Unité du courant électrique",
            text = "Quelle est l'unité de mesure de l'intensité du courant électrique ?",
            options = listOf("Volt", "Watt", "Ampère", "Ohm"),
            correctIndex = 2,
            rating = 950,
            explanation = "L'intensité du courant électrique se mesure en ampères (A), du nom du physicien français André-Marie Ampère.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_couche_ozone_role",
            title = "Rôle de la couche d'ozone",
            text = "La couche d'ozone protège principalement la Terre contre quel type de rayonnement ?",
            options = listOf("Rayons ultraviolets", "Rayons X", "Ondes radio", "Infrarouges"),
            correctIndex = 0,
            rating = 1050,
            explanation = "La couche d'ozone absorbe une grande partie des rayonnements ultraviolets émis par le Soleil, limitant leurs effets nocifs sur les êtres vivants.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_vitesse_son_air",
            title = "Vitesse du son",
            text = "Quelle est approximativement la vitesse du son dans l'air à température ambiante ?",
            options = listOf("340 m/s", "34 m/s", "3 400 m/s", "30 000 m/s"),
            correctIndex = 0,
            rating = 1150,
            explanation = "Dans l'air à environ 20°C, le son se propage à une vitesse d'environ 340 mètres par seconde.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_eruption_magma",
            title = "Roche en fusion",
            text = "Comment appelle-t-on la roche en fusion lorsqu'elle se trouve sous la surface terrestre ?",
            options = listOf("Lave", "Magma", "Basalte", "Granite"),
            correctIndex = 1,
            rating = 850,
            explanation = "Sous la surface, la roche en fusion est appelée magma. Lorsqu'elle atteint la surface lors d'une éruption volcanique, on parle alors de lave.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_girafe_coeur",
            title = "Cœur de la girafe",
            text = "Pourquoi le cœur de la girafe est-il particulièrement puissant ?",
            options = listOf("Pour courir vite", "Pour produire de la chaleur", "Pour alimenter son long cou en sang", "Pour respirer sous l'eau"),
            correctIndex = 2,
            rating = 1400,
            explanation = "Le cœur de la girafe doit générer une pression élevée afin d'envoyer le sang jusqu'à son cerveau situé plusieurs mètres au-dessus du sol.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_saturne_anneaux",
            title = "Les anneaux de Saturne",
            text = "Les anneaux de Saturne sont principalement composés de quoi ?",
            options = listOf("Glace et roches", "Gaz", "Métal", "Poussière volcanique"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Les anneaux de Saturne sont constitués de milliards de fragments de glace, de poussière et de roche orbitant autour de la planète.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_chauve_souris_orientation",
            title = "Orientation des chauves-souris",
            text = "Quel système les chauves-souris utilisent-elles principalement pour se repérer dans l'obscurité ?",
            options = listOf("Vision infrarouge", "Écholocalisation", "Magnétisme", "Bioluminescence"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Les chauves-souris émettent des ultrasons et analysent leur écho pour détecter les obstacles et localiser leurs proies.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_pH_neutre",
            title = "Le pH neutre",
            text = "Quelle valeur correspond à un pH neutre ?",
            options = listOf("0", "7", "10", "14"),
            correctIndex = 1,
            rating = 800,
            explanation = "Un pH de 7 est considéré comme neutre. Les valeurs inférieures indiquent une solution acide et les valeurs supérieures une solution basique.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_neurone_fonction",
            title = "Rôle du neurone",
            text = "Quelle est la fonction principale d'un neurone ?",
            options = listOf("Produire du sang", "Stocker les graisses", "Transmettre des informations", "Filtrer les toxines"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Les neurones sont les cellules spécialisées du système nerveux chargées de transmettre des signaux électriques et chimiques.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_comete_queue",
            title = "Queue des comètes",
            text = "Pourquoi les comètes développent-elles une queue lorsqu'elles s'approchent du Soleil ?",
            options = listOf("À cause du vent solaire", "À cause de la gravité terrestre", "À cause des marées", "À cause du champ magnétique lunaire"),
            correctIndex = 0,
            rating = 1450,
            explanation = "La chaleur du Soleil vaporise une partie de la glace de la comète, et le vent solaire repousse ces particules pour former une queue lumineuse.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_fossile_definition",
            title = "Qu'est-ce qu'un fossile ?",
            text = "Un fossile est principalement :",
            options = listOf("Une roche volcanique", "Une trace ou un reste d'être vivant ancien", "Un minéral rare", "Une météorite"),
            correctIndex = 1,
            rating = 750,
            explanation = "Les fossiles sont des restes ou des traces d'organismes anciens conservés dans les roches sédimentaires.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_plancton_oceans",
            title = "Importance du plancton",
            text = "Le phytoplancton océanique produit approximativement quelle part de l'oxygène terrestre ?",
            options = listOf("Moins de 5 %", "Environ 20 %", "Environ 50 %", "Près de 90 %"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Le phytoplancton réalise une part considérable de la photosynthèse mondiale et produit environ la moitié de l'oxygène présent dans l'atmosphère.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_lune_rotation",
            title = "Toujours la même face",
            text = "Pourquoi voyons-nous toujours la même face de la Lune depuis la Terre ?",
            options = listOf("Elle ne tourne pas", "Sa rotation est synchronisée avec sa révolution", "Elle est immobile", "La Terre masque l'autre face"),
            correctIndex = 1,
            rating = 1250,
            explanation = "La Lune met le même temps pour tourner sur elle-même que pour effectuer une révolution autour de la Terre, ce qui nous montre toujours la même face.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_abeilles_pollinisation",
            title = "Mission des abeilles",
            text = "Quel rôle écologique majeur jouent les abeilles ?",
            options = listOf("Décomposer les déchets", "Polliniser les plantes", "Fixer l'azote", "Produire de l'oxygène"),
            correctIndex = 1,
            rating = 850,
            explanation = "Les abeilles participent à la pollinisation de nombreuses plantes cultivées et sauvages, essentielle à leur reproduction.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_tectonique_plaques",
            title = "Origine des séismes",
            text = "Les séismes sont le plus souvent provoqués par quoi ?",
            options = listOf("Les marées", "Les déplacements des plaques tectoniques", "Les tempêtes", "Les variations de température"),
            correctIndex = 1,
            rating = 950,
            explanation = "La majorité des tremblements de terre résultent des mouvements et des contraintes accumulées entre les plaques tectoniques.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_helium_ballon",
            title = "Gaz des ballons",
            text = "Pourquoi l'hélium permet-il à un ballon de s'élever dans l'air ?",
            options = listOf("Il est chaud", "Il est magnétique", "Il est plus léger que l'air", "Il produit de l'électricité"),
            correctIndex = 2,
            rating = 900,
            explanation = "L'hélium est moins dense que l'air ambiant, ce qui permet au ballon de flotter grâce à la poussée d'Archimède.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_pieuvre_coeurs",
            title = "Les cœurs de la pieuvre",
            text = "Combien de cœurs possède une pieuvre ?",
            options = listOf("1", "2", "3", "4"),
            correctIndex = 2,
            rating = 1350,
            explanation = "La pieuvre possède trois cœurs : deux envoient le sang vers les branchies et un troisième alimente le reste du corps.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_banane_radioactive",
            title = "Radioactivité de la banane",
            text = "Pourquoi une banane présente-t-elle une très légère radioactivité naturelle ?",
            options = listOf("À cause de son sucre", "À cause du potassium qu'elle contient", "À cause de sa couleur jaune", "À cause de sa peau"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Les bananes contiennent du potassium, dont une petite partie est constituée de l'isotope radioactif naturel potassium-40. Cette radioactivité est extrêmement faible et sans danger.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_fourmis_force",
            title = "Force des fourmis",
            text = "Une fourmi peut généralement porter une charge représentant environ combien de fois son propre poids ?",
            options = listOf("2 fois", "10 fois", "50 fois", "100 fois"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Selon les espèces, certaines fourmis peuvent transporter jusqu'à 50 fois leur poids grâce à leur petite taille et à la structure de leur exosquelette.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_venus_rotation",
            title = "Rotation de Vénus",
            text = "Quelle particularité possède la rotation de la planète Vénus ?",
            options = listOf("Elle ne tourne pas", "Elle tourne en sens inverse de la plupart des planètes", "Elle tourne deux fois plus vite que Jupiter", "Elle possède deux axes de rotation"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Vénus effectue une rotation rétrograde : le Soleil semble s'y lever à l'ouest et se coucher à l'est.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_sang_bleu_crustaces",
            title = "Sang bleu",
            text = "Pourquoi certains animaux comme le limule ont-ils un sang de couleur bleue ?",
            options = listOf("À cause du cuivre", "À cause du fer", "À cause du calcium", "À cause du magnésium"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Contrairement à l'hémoglobine humaine basée sur le fer, leur pigment respiratoire est l'hémocyanine, qui contient du cuivre et devient bleue lorsqu'elle est oxygénée.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_cameleon_couleur",
            title = "Couleurs du caméléon",
            text = "Pourquoi les caméléons changent-ils principalement de couleur ?",
            options = listOf("Uniquement pour se camoufler", "Pour communiquer et réguler leur température", "Pour attirer la pluie", "Pour améliorer leur vision"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Le changement de couleur sert notamment à communiquer avec les autres caméléons, à exprimer leur humeur et à participer à la régulation thermique.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_aurore_boreale",
            title = "Origine des aurores boréales",
            text = "Les aurores boréales sont principalement provoquées par l'interaction de particules solaires avec quoi ?",
            options = listOf("Les océans", "L'atmosphère terrestre", "La croûte terrestre", "La Lune"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Les particules chargées émises par le Soleil interagissent avec les gaz de la haute atmosphère terrestre, produisant les magnifiques lumières colorées observées près des pôles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_tardigrade",
            title = "Champion de la survie",
            text = "Quel minuscule animal est célèbre pour sa capacité à survivre à des conditions extrêmes, y compris dans l'espace ?",
            options = listOf("Le rotifère", "Le tardigrade", "L'artémie", "Le plancton"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le tardigrade, parfois surnommé « ourson d'eau », peut survivre à des températures, radiations et pressions extrêmes grâce à un état de cryptobiose.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_eclair_temperature",
            title = "Température d'un éclair",
            text = "La température au cœur d'un éclair peut atteindre environ :",
            options = listOf("3 000 °C", "10 000 °C", "30 000 °C", "100 000 °C"),
            correctIndex = 2,
            rating = 1500,
            explanation = "La température d'un éclair peut atteindre environ 30 000 °C, soit plusieurs fois la température de surface du Soleil.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_sequoia_geant",
            title = "Les séquoias géants",
            text = "Dans quel pays trouve-t-on naturellement les célèbres séquoias géants ?",
            options = listOf("Canada", "États-Unis", "Australie", "Chili"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Les séquoias géants poussent naturellement dans la Sierra Nevada, en Californie. Certains comptent parmi les organismes vivants les plus massifs de la planète.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_matiere_noire",
            title = "La matière noire",
            text = "Selon les modèles actuels, la matière noire est principalement détectée grâce à quoi ?",
            options = listOf("Sa lumière", "Sa chaleur", "Ses effets gravitationnels", "Ses émissions radio"),
            correctIndex = 2,
            rating = 1750,
            explanation = "La matière noire n'émet pas de lumière détectable. Les astronomes déduisent son existence grâce à son influence gravitationnelle sur les galaxies et les amas de galaxies.",
            category = Category.SCIENCES_ET_NATURE
        ),

        // ===================== ART & CULTURE =====================
        Question(
            id = "art_joconde_peintre",
            title = "Peintre de la Joconde",
            text = "Qui a peint la Joconde ?",
            options = listOf("Michel-Ange", "Léonard de Vinci", "Raphaël", "Botticelli"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Joconde, ou Mona Lisa, est un tableau peint par Léonard de Vinci entre 1503 et 1519. Il est exposé au musée du Louvre à Paris, protégé derrière une vitre blindée. Le modèle serait Lisa Gherardini, épouse d'un riche marchand florentin. C'est l'œuvre d'art la plus visitée au monde, attirant chaque année plusieurs millions de visiteurs.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_miserables_auteur",
            title = "Auteur des Misérables",
            text = "Qui a écrit \"Les Misérables\" ?",
            options = listOf("Émile Zola", "Victor Hugo", "Honoré de Balzac", "Gustave Flaubert"),
            correctIndex = 1,
            rating = 800,
            explanation = "Les Misérables est un roman de Victor Hugo publié en 1862. Il raconte l'histoire de Jean Valjean, un ancien forçat cherchant à se racheter dans une France du XIXe siècle marquée par la misère et l'injustice. L'œuvre a été adaptée en comédie musicale en 1980, devenue l'une des plus jouées au monde. Hugo l'écrivit en grande partie en exil, notamment à Guernesey.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_penseur_sculpteur",
            title = "Sculpteur du Penseur",
            text = "Qui a sculpté \"Le Penseur\" ?",
            options = listOf("Auguste Rodin", "Michel-Ange", "Donatello", "Lorenzo Bernini"),
            correctIndex = 0,
            rating = 900,
            explanation = "Le Penseur est une sculpture d'Auguste Rodin, créée en 1882. À l'origine conçue comme une figure de Dante pour les Portes de l'Enfer, elle est devenue l'une des sculptures les plus célèbres au monde. Le modèle original, en bronze, mesure 186 cm de haut. Des exemplaires sont exposés dans de nombreux musées, dont le musée Rodin à Paris.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_moliere_vrai_nom",
            title = "Vrai nom de Molière",
            text = "Quel est le vrai nom de Molière ?",
            options = listOf("Pierre Corneille", "Jean-Baptiste Poquelin", "François-Marie Arouet", "Jean Racine"),
            correctIndex = 1,
            rating = 950,
            explanation = "Jean-Baptiste Poquelin, dit Molière, est né à Paris en 1622. Il adopta le pseudonyme de Molière dès 1643 lorsqu'il fonda la troupe de l'Illustre Théâtre. Auteur de comédies immortelles comme Le Misanthrope, Tartuffe ou L'Avare, il mourut en 1673 sur scène lors d'une représentation du Malade imaginaire.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_picasso_pays",
            title = "Pays natal de Picasso",
            text = "Dans quel pays est né Pablo Picasso ?",
            options = listOf("France", "Italie", "Espagne", "Portugal"),
            correctIndex = 2,
            rating = 850,
            explanation = "Pablo Picasso est né à Málaga, en Espagne, en 1881. Cofondateur du cubisme avec Georges Braque, il est considéré comme l'un des artistes les plus influents du XXe siècle. Il passa une grande partie de sa vie en France, notamment à Paris. Son œuvre comprend plus de 20 000 créations : peintures, sculptures, céramiques et gravures.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_symphonie_9_beethoven",
            title = "Compositeur de l'Ode à la joie",
            text = "Quel compositeur a écrit la \"Symphonie n°9\" et son \"Ode à la joie\" ?",
            options = listOf("Mozart", "Beethoven", "Bach", "Chopin"),
            correctIndex = 1,
            rating = 900,
            explanation = "La Symphonie n°9 de Ludwig van Beethoven, achevée en 1824, intègre dans son dernier mouvement l'\"Ode à la joie\", un poème de Schiller chanté par des solistes et un chœur — une innovation révolutionnaire pour l'époque. Beethoven était alors devenu presque totalement sourd. Cet hymne à la fraternité est aujourd'hui l'hymne officiel de l'Union européenne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_louvre_ville",
            title = "Ville du musée du Louvre",
            text = "Dans quelle ville se trouve le musée du Louvre ?",
            options = listOf("Londres", "Rome", "Paris", "Madrid"),
            correctIndex = 2,
            rating = 600,
            explanation = "Le musée du Louvre se trouve à Paris, installé dans un ancien palais royal au bord de la Seine. Inauguré comme musée en 1793, il est le plus grand musée d'art du monde et le plus visité, avec la Joconde parmi ses joyaux. Sa célèbre pyramide de verre, conçue par l'architecte Ieoh Ming Pei, fut inaugurée en 1989.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_nuit_etoilee_vangogh",
            title = "Peintre de La Nuit étoilée",
            text = "Qui a peint \"La Nuit étoilée\" ?",
            options = listOf("Claude Monet", "Vincent van Gogh", "Paul Cézanne", "Paul Gauguin"),
            correctIndex = 1,
            rating = 850,
            explanation = "La Nuit étoilée fut peinte par Vincent van Gogh en 1889, alors qu'il séjournait dans un asile à Saint-Rémy-de-Provence. Ce tableau aux tourbillons célestes intenses est l'une des œuvres les plus célèbres de l'art occidental. Van Gogh, peu reconnu de son vivant, ne vendit presque aucune toile avant sa mort en 1890 ; il est aujourd'hui une icône mondiale.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_sherlock_holmes_auteur",
            title = "Créateur de Sherlock Holmes",
            text = "Quel écrivain a créé le personnage de Sherlock Holmes ?",
            options = listOf("Agatha Christie", "Arthur Conan Doyle", "Edgar Allan Poe", "Jules Verne"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le célèbre détective Sherlock Holmes est né de l'imagination de l'écrivain écossais Arthur Conan Doyle, qui le fit apparaître pour la première fois en 1887. Doté d'un sens de la déduction extraordinaire et accompagné du fidèle docteur Watson, le personnage est devenu l'archétype du détective de fiction. Conan Doyle s'inspira d'un de ses professeurs de médecine.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_monet_impressionnisme",
            title = "Mouvement fondé par Monet",
            text = "Quel mouvement artistique Claude Monet a-t-il contribué à fonder ?",
            options = listOf("Le cubisme", "Le surréalisme", "L'impressionnisme", "Le fauvisme"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Claude Monet est l'un des pères fondateurs de l'impressionnisme : c'est d'ailleurs son tableau \"Impression, soleil levant\" (1872) qui donna son nom au mouvement. Ce courant privilégie la captation de la lumière et des impressions fugaces plutôt que le détail réaliste. Monet est célèbre pour ses séries des Nymphéas, peintes dans son jardin de Giverny.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_romeo_juliette_auteur",
            title = "Auteur de Roméo et Juliette",
            text = "Qui a écrit la pièce \"Roméo et Juliette\" ?",
            options = listOf("William Shakespeare", "Molière", "Dante Alighieri", "Goethe"),
            correctIndex = 0,
            rating = 700,
            explanation = "Roméo et Juliette est une tragédie écrite par le dramaturge anglais William Shakespeare vers 1595. Elle raconte l'amour impossible entre deux jeunes gens issus de familles rivales, les Montaigu et les Capulet, à Vérone. Devenue le symbole universel de l'amour contrarié, la pièce a inspiré d'innombrables films, ballets et opéras.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_piano_88_touches",
            title = "Instrument à 88 touches",
            text = "Quel instrument de musique possède 88 touches ?",
            options = listOf("L'orgue", "Le piano", "L'accordéon", "Le clavecin"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le piano moderne compte 88 touches : 52 blanches et 36 noires, couvrant plus de sept octaves. Inventé vers 1700 par l'Italien Bartolomeo Cristofori, son nom complet, \"pianoforte\", désigne sa capacité à jouer aussi bien doucement (piano) que fort (forte) selon la pression exercée sur les touches. C'est l'un des instruments les plus polyvalents.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_david_michelange",
            title = "Sculpteur du David",
            text = "Qui a sculpté le \"David\", chef-d'œuvre de la Renaissance ?",
            options = listOf("Donatello", "Léonard de Vinci", "Michel-Ange", "Raphaël"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Le \"David\" est une statue monumentale en marbre de plus de 5 mètres, sculptée par Michel-Ange entre 1501 et 1504 à Florence. Elle représente le héros biblique avant son combat contre Goliath et incarne l'idéal de beauté et de perfection de la Renaissance. L'œuvre est aujourd'hui conservée à la galerie de l'Académie de Florence.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_shakespeare_pays",
            title = "Pays de Shakespeare",
            text = "De quel pays l'écrivain William Shakespeare est-il originaire ?",
            options = listOf("L'Angleterre", "L'Irlande", "L'Écosse", "Les États-Unis"),
            correctIndex = 0,
            rating = 650,
            explanation = "William Shakespeare est né en 1564 à Stratford-upon-Avon, en Angleterre. Considéré comme le plus grand dramaturge de langue anglaise, il a écrit une trentaine de pièces et de nombreux sonnets. Ses œuvres, comme Hamlet, Macbeth ou Othello, sont jouées dans le monde entier depuis plus de quatre siècles et ont profondément marqué la littérature.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_dali_montres_molles",
            title = "Peintre des montres molles",
            text = "Quel peintre espagnol est célèbre pour ses montres molles dans \"La Persistance de la mémoire\" ?",
            options = listOf("Joan Miró", "Salvador Dalí", "Pablo Picasso", "Francisco Goya"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Salvador Dalí, figure majeure du surréalisme, peignit \"La Persistance de la mémoire\" en 1931, célèbre pour ses montres molles qui semblent fondre dans un paysage onirique. Connu autant pour son génie que pour son excentricité et sa moustache emblématique, Dalí explorait l'inconscient et les rêves. L'œuvre est conservée au MoMA de New York.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_flute_enchantee_mozart",
            title = "Compositeur de La Flûte enchantée",
            text = "Quel compositeur autrichien, enfant prodige, a écrit \"La Flûte enchantée\" ?",
            options = listOf("Joseph Haydn", "Wolfgang Amadeus Mozart", "Franz Schubert", "Johann Strauss"),
            correctIndex = 1,
            rating = 950,
            explanation = "Wolfgang Amadeus Mozart composa l'opéra \"La Flûte enchantée\" en 1791, l'année de sa mort. Enfant prodige né à Salzbourg en 1756, il jouait du clavecin et composait dès l'âge de cinq ans. Au cours de sa courte vie de 35 ans, il laissa plus de 600 œuvres et révolutionna presque tous les genres musicaux de son époque.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_tour_eiffel_1889",
            title = "Monument de l'Exposition de 1889",
            text = "Quel monument parisien a été construit pour l'Exposition universelle de 1889 ?",
            options = listOf("La tour Montparnasse", "La tour Eiffel", "L'Arc de Triomphe", "La Sainte-Chapelle"),
            correctIndex = 1,
            rating = 600,
            explanation = "La tour Eiffel fut construite par l'ingénieur Gustave Eiffel pour l'Exposition universelle de 1889, qui marquait le centenaire de la Révolution française. Haute de 330 mètres, elle devait à l'origine être démontée au bout de vingt ans, mais son utilité comme antenne radio la sauva. Devenue le symbole de Paris, elle est le monument payant le plus visité au monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_le_cid_corneille",
            title = "Auteur du Cid",
            text = "Qui a écrit la tragédie \"Le Cid\" ?",
            options = listOf("Jean Racine", "Pierre Corneille", "Molière", "Voltaire"),
            correctIndex = 1,
            rating = 1100,
            explanation = "\"Le Cid\" est une tragi-comédie de Pierre Corneille, créée en 1637. Inspirée d'un héros espagnol médiéval, elle met en scène le dilemme de Rodrigue, déchiré entre son amour pour Chimène et son devoir d'honneur familial. Immense succès, la pièce déclencha une vive polémique littéraire connue sous le nom de \"querelle du Cid\".",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_lac_des_cygnes",
            title = "Ballet du lac et du cygne",
            text = "Quel ballet de Tchaïkovski met en scène un lac et un cygne ?",
            options = listOf("Casse-Noisette", "Le Lac des cygnes", "La Belle au bois dormant", "Giselle"),
            correctIndex = 1,
            rating = 1000,
            explanation = "\"Le Lac des cygnes\", composé par Piotr Ilitch Tchaïkovski en 1876, raconte l'histoire de la princesse Odette transformée en cygne par un sortilège. C'est l'un des ballets les plus célèbres et les plus représentés au monde. Boudé lors de sa création, il connut un triomphe posthume grâce à la chorégraphie révisée de Petipa et Ivanov en 1895.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_chapelle_sixtine",
            title = "Peintre de la chapelle Sixtine",
            text = "Quel artiste a peint le plafond de la chapelle Sixtine ?",
            options = listOf("Raphaël", "Michel-Ange", "Botticelli", "Le Caravage"),
            correctIndex = 1,
            rating = 900,
            explanation = "Michel-Ange peignit le plafond de la chapelle Sixtine, au Vatican, entre 1508 et 1512, à la demande du pape Jules II. Cette fresque monumentale, qui comprend la célèbre scène de la \"Création d'Adam\", couvre plus de 500 m². Michel-Ange, qui se considérait d'abord comme sculpteur, réalisa ce chef-d'œuvre en travaillant le plus souvent allongé sur des échafaudages.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_guernica_peintre",
            title = "Peintre de Guernica",
            text = "Quel artiste a peint le célèbre tableau « Guernica » ?",
            options = listOf("Salvador Dalí", "Pablo Picasso", "Joan Miró", "Diego Velázquez"),
            correctIndex = 1,
            rating = 950,
            explanation = "Guernica est une œuvre monumentale peinte par Pablo Picasso en 1937. Elle dénonce le bombardement de la ville basque de Guernica pendant la guerre civile espagnole.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_carmen_compositeur",
            title = "Compositeur de Carmen",
            text = "Quel compositeur a écrit l'opéra « Carmen » ?",
            options = listOf("Georges Bizet", "Jules Massenet", "Charles Gounod", "Jacques Offenbach"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Créé en 1875, Carmen de Georges Bizet est aujourd'hui l'un des opéras les plus joués au monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_harry_potter_auteur",
            title = "Créatrice de Harry Potter",
            text = "Qui a écrit la série de romans Harry Potter ?",
            options = listOf("J. K. Rowling", "Suzanne Collins", "Stephenie Meyer", "Philip Pullman"),
            correctIndex = 0,
            rating = 700,
            explanation = "La romancière britannique J. K. Rowling a publié le premier tome de Harry Potter en 1997, lançant un phénomène mondial.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_cubisme_mouvement",
            title = "Principe du cubisme",
            text = "Quel mouvement artistique représente les sujets sous plusieurs angles simultanément ?",
            options = listOf("Impressionnisme", "Surréalisme", "Cubisme", "Baroque"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le cubisme, développé notamment par Picasso et Braque, décompose les formes en figures géométriques et multiplie les points de vue.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_1984_auteur",
            title = "Auteur de 1984",
            text = "Qui a écrit le roman dystopique « 1984 » ?",
            options = listOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "H. G. Wells"),
            correctIndex = 0,
            rating = 1000,
            explanation = "Publié en 1949, 1984 de George Orwell décrit une société totalitaire dominée par la surveillance et le contrôle de l'information.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_bolero_ravel",
            title = "Compositeur du Boléro",
            text = "Qui a composé le célèbre « Boléro » ?",
            options = listOf("Claude Debussy", "Maurice Ravel", "Erik Satie", "Camille Saint-Saëns"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le Boléro de Maurice Ravel, créé en 1928, est fondé sur une mélodie répétée et un long crescendo orchestral.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_guerre_paix_auteur",
            title = "Auteur de Guerre et Paix",
            text = "Qui a écrit le roman « Guerre et Paix » ?",
            options = listOf("Fiodor Dostoïevski", "Anton Tchekhov", "Léon Tolstoï", "Ivan Tourgueniev"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Léon Tolstoï publia Guerre et Paix entre 1865 et 1869. Ce roman est considéré comme l'un des chefs-d'œuvre de la littérature mondiale.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_opera_sydney",
            title = "Architecte de l'Opéra de Sydney",
            text = "Quel architecte a conçu l'Opéra de Sydney ?",
            options = listOf("Frank Gehry", "Le Corbusier", "Jørn Utzon", "Oscar Niemeyer"),
            correctIndex = 2,
            rating = 1450,
            explanation = "L'architecte danois Jørn Utzon a imaginé les célèbres voiles de l'Opéra de Sydney, inauguré en 1973.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_fables_auteur",
            title = "Auteur des Fables",
            text = "Qui a écrit les célèbres « Fables » étudiées dans les écoles françaises ?",
            options = listOf("Jean de La Fontaine", "Molière", "Victor Hugo", "Jean Racine"),
            correctIndex = 0,
            rating = 800,
            explanation = "Jean de La Fontaine publia ses Fables à partir de 1668, s'inspirant notamment d'Ésope pour transmettre des leçons morales.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_nabucco_compositeur",
            title = "Compositeur de Nabucco",
            text = "Quel compositeur italien a écrit l'opéra « Nabucco » ?",
            options = listOf("Rossini", "Puccini", "Verdi", "Donizetti"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Giuseppe Verdi connut un immense succès avec Nabucco en 1842, notamment grâce au célèbre chœur « Va, pensiero ».",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_seigneur_anneaux_auteur",
            title = "Créateur du Seigneur des Anneaux",
            text = "Qui est l'auteur du « Seigneur des Anneaux » ?",
            options = listOf("C. S. Lewis", "J. R. R. Tolkien", "Terry Pratchett", "Robert Jordan"),
            correctIndex = 1,
            rating = 850,
            explanation = "J. R. R. Tolkien publia Le Seigneur des Anneaux dans les années 1950. Son univers a profondément marqué la fantasy moderne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_baroque_epoque",
            title = "Le style baroque",
            text = "Le style baroque est particulièrement associé à quelle période ?",
            options = listOf("XVIIe siècle", "XIIIe siècle", "XXe siècle", "Antiquité"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Le baroque se développe principalement aux XVIIe et début XVIIIe siècles, avec un goût marqué pour le mouvement et l'ornementation.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_don_quichotte_auteur",
            title = "Auteur de Don Quichotte",
            text = "Qui a écrit « Don Quichotte » ?",
            options = listOf("Miguel de Cervantes", "Federico García Lorca", "Lope de Vega", "Benito Pérez Galdós"),
            correctIndex = 0,
            rating = 1100,
            explanation = "Publié au début du XVIIe siècle, Don Quichotte de Cervantes est souvent considéré comme le premier roman moderne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_madame_bovary_auteur",
            title = "Auteur de Madame Bovary",
            text = "Qui a écrit « Madame Bovary » ?",
            options = listOf("Émile Zola", "Honoré de Balzac", "Gustave Flaubert", "Guy de Maupassant"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Publié en 1857, Madame Bovary de Gustave Flaubert est un classique du réalisme littéraire français.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_requiem_mozart",
            title = "Œuvre inachevée de Mozart",
            text = "Quelle célèbre œuvre Mozart a-t-il laissée inachevée à sa mort ?",
            options = listOf("Don Giovanni", "Le Requiem", "La Flûte enchantée", "Une petite musique de nuit"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Le Requiem de Mozart resta inachevé lors de sa mort en 1791 et fut complété par son élève Franz Xaver Süssmayr.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_expressionnisme_cri",
            title = "Le Cri",
            text = "Quel artiste a peint « Le Cri » ?",
            options = listOf("Edvard Munch", "Paul Klee", "Wassily Kandinsky", "Gustav Klimt"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Le Cri, réalisé par Edvard Munch en 1893, est devenu l'une des œuvres les plus célèbres de l'expressionnisme.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_metro_novels",
            title = "Prix Nobel de littérature",
            text = "Quel écrivain français a reçu le prix Nobel de littérature en 1957 ?",
            options = listOf("Albert Camus", "Jean-Paul Sartre", "André Malraux", "Marcel Pagnol"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Albert Camus reçut le prix Nobel de littérature en 1957 pour l'ensemble de son œuvre, notamment L'Étranger et La Peste.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_notre_dame_roman",
            title = "Notre-Dame de Paris",
            text = "Quel écrivain a publié le roman « Notre-Dame de Paris » en 1831 ?",
            options = listOf("Victor Hugo", "Alexandre Dumas", "Honoré de Balzac", "Jules Verne"),
            correctIndex = 0,
            rating = 850,
            explanation = "Victor Hugo publia Notre-Dame de Paris en 1831. Le roman contribua à la sauvegarde de la cathédrale parisienne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_rodin_portes_enfer",
            title = "Les Portes de l'Enfer",
            text = "Quel sculpteur a réalisé « Les Portes de l'Enfer » ?",
            options = listOf("Auguste Rodin", "Camille Claudel", "Antoine Bourdelle", "Aristide Maillol"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Les Portes de l'Enfer constituent l'une des œuvres majeures d'Auguste Rodin et ont inspiré plusieurs de ses sculptures célèbres.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_de_stijl_mondrian",
            title = "Mondrian et De Stijl",
            text = "Quel peintre est célèbre pour ses compositions géométriques de lignes noires et de couleurs primaires ?",
            options = listOf("Paul Klee", "Piet Mondrian", "Marc Chagall", "René Magritte"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Piet Mondrian est l'une des figures majeures du mouvement De Stijl, caractérisé par l'utilisation de formes géométriques simples et de couleurs primaires.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_lettre_persanes_auteur",
            title = "Auteur des Lettres persanes",
            text = "Qui a écrit le roman épistolaire « Lettres persanes » ?",
            options = listOf("Montesquieu", "Voltaire", "Diderot", "Rousseau"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Publié en 1721, les Lettres persanes de Montesquieu utilisent le regard de voyageurs persans pour critiquer la société française de son époque.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_magritte_pipe",
            title = "La pipe de Magritte",
            text = "Quel peintre a réalisé l'œuvre « La Trahison des images » contenant la phrase « Ceci n'est pas une pipe » ?",
            options = listOf("Salvador Dalí", "René Magritte", "Max Ernst", "Paul Delvaux"),
            correctIndex = 1,
            rating = 1100,
            explanation = "René Magritte a peint cette œuvre en 1929 pour rappeler qu'une image n'est pas l'objet réel qu'elle représente.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_casse_noisette_compositeur",
            title = "Compositeur de Casse-Noisette",
            text = "Quel compositeur a écrit le ballet « Casse-Noisette » ?",
            options = listOf("Tchaïkovski", "Stravinsky", "Rimski-Korsakov", "Prokofiev"),
            correctIndex = 0,
            rating = 950,
            explanation = "Piotr Ilitch Tchaïkovski composa Casse-Noisette en 1892. Le ballet est aujourd'hui associé aux fêtes de fin d'année dans de nombreux pays.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_musee_orsay_gare",
            title = "Origine du musée d'Orsay",
            text = "Le musée d'Orsay à Paris est installé dans quel type de bâtiment d'origine ?",
            options = listOf("Un palais", "Une gare", "Une usine", "Une caserne"),
            correctIndex = 1,
            rating = 900,
            explanation = "Le musée d'Orsay occupe l'ancienne gare d'Orsay, construite pour l'Exposition universelle de 1900.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_ulysse_auteur",
            title = "Auteur d'Ulysse",
            text = "Qui a écrit le roman « Ulysse » publié en 1922 ?",
            options = listOf("Oscar Wilde", "James Joyce", "Samuel Beckett", "William Yeats"),
            correctIndex = 1,
            rating = 1650,
            explanation = "Ulysse de James Joyce est considéré comme l'un des romans les plus influents et les plus novateurs du XXe siècle.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_egyptien_hieroglyphes",
            title = "Écriture hiéroglyphique",
            text = "Sur quelle pierre célèbre Jean-François Champollion s'est-il appuyé pour déchiffrer les hiéroglyphes égyptiens ?",
            options = listOf("Pierre de Rosette", "Pierre noire", "Pierre de Memphis", "Pierre d'Alexandrie"),
            correctIndex = 0,
            rating = 1250,
            explanation = "La pierre de Rosette comportait le même texte en hiéroglyphes, en démotique et en grec ancien, ce qui permit son déchiffrement.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_chagall_origine",
            title = "Origine de Chagall",
            text = "Dans quel pays actuel est né le peintre Marc Chagall ?",
            options = listOf("France", "Ukraine", "Biélorussie", "Pologne"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Marc Chagall est né à Vitebsk, aujourd'hui en Biélorussie. Son œuvre est marquée par des couleurs vives et un univers poétique.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_sagrada_familia_architecte",
            title = "Architecte de la Sagrada Família",
            text = "Quel architecte a conçu la basilique de la Sagrada Família à Barcelone ?",
            options = listOf("Antoni Gaudí", "Santiago Calatrava", "Ricardo Bofill", "Le Corbusier"),
            correctIndex = 0,
            rating = 850,
            explanation = "Antoni Gaudí consacra une grande partie de sa vie à la Sagrada Família, dont la construction a débuté en 1882 et se poursuit encore aujourd'hui.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_baudelaire_recueil",
            title = "Recueil de Baudelaire",
            text = "Quel est le recueil de poésie le plus célèbre de Charles Baudelaire ?",
            options = listOf("Les Contemplations", "Les Fleurs du mal", "Alcools", "Poèmes saturniens"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Les Fleurs du mal, publiées en 1857, constituent l'œuvre majeure de Baudelaire et ont profondément influencé la poésie moderne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_murakami_pays",
            title = "Pays de Murakami",
            text = "De quel pays est originaire l'écrivain Haruki Murakami ?",
            options = listOf("Corée du Sud", "Chine", "Japon", "Singapour"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Haruki Murakami est un écrivain japonais contemporain connu pour des romans comme Kafka sur le rivage ou 1Q84.",
            category = Category.ART_ET_CULTURE
        ),

        // ===================== SPORTS =====================
        Question(
            id = "spo_foot_nb_joueurs",
            title = "Joueurs d'une équipe de football",
            text = "Combien de joueurs composent une équipe de football ?",
            options = listOf("9", "11", "13", "10"),
            correctIndex = 1,
            rating = 650,
            explanation = "Une équipe de football est composée de 11 joueurs sur le terrain : 1 gardien de but et 10 joueurs de champ. Le football est le sport le plus populaire au monde avec environ 4 milliards de fans et 265 millions de pratiquants. Les règles modernes du jeu ont été codifiées en Angleterre en 1863 par la Football Association.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_volant_badminton",
            title = "Sport avec un volant",
            text = "Dans quel sport utilise-t-on un volant ?",
            options = listOf("Tennis de table", "Squash", "Badminton", "Padel"),
            correctIndex = 2,
            rating = 700,
            explanation = "Le volant, aussi appelé \"shuttlecock\" en anglais, est l'objet frappé au badminton. Composé d'une base en liège surmontée de 16 plumes d'oie, il peut atteindre des vitesses supérieures à 400 km/h lors de smashes professionnels. Le badminton est l'un des sports les plus pratiqués au monde, particulièrement populaire en Asie du Sud-Est.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_cdm_2018",
            title = "Vainqueur de la Coupe du Monde 2018",
            text = "Quel pays a remporté la Coupe du Monde de football 2018 ?",
            options = listOf("Croatie", "Brésil", "Argentine", "France"),
            correctIndex = 3,
            rating = 800,
            explanation = "La France a remporté la Coupe du Monde 2018 en Russie en battant la Croatie 4-2 en finale. C'était le deuxième titre mondial des Bleus après celui de 1998. Kylian Mbappé, alors âgé de 19 ans, devint le deuxième joueur après Pelé à marquer en finale d'une Coupe du Monde avant 20 ans.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_basket_nb_joueurs",
            title = "Joueurs au basket sur le terrain",
            text = "Combien de joueurs composent une équipe de basketball sur le terrain ?",
            options = listOf("4", "5", "6", "7"),
            correctIndex = 1,
            rating = 650,
            explanation = "Une équipe de basketball aligne 5 joueurs sur le terrain : un meneur, un arrière, un ailier, un ailier fort et un pivot. Le basketball a été inventé en 1891 par le Canadien James Naismith à Springfield, Massachusetts. La NBA, ligue professionnelle fondée en 1946, est aujourd'hui la compétition de basketball la plus regardée au monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_roland_garros_surface",
            title = "Surface de Roland-Garros",
            text = "Sur quelle surface se joue le tournoi de Roland-Garros ?",
            options = listOf("Gazon", "Dur", "Terre battue", "Moquette"),
            correctIndex = 2,
            rating = 750,
            explanation = "Roland-Garros, l'un des quatre tournois du Grand Chelem, se joue sur terre battue. Cette surface ocre ralentit la balle et favorise les échanges longs depuis le fond du court. Le stade, situé à Paris, porte le nom de l'aviateur Roland Garros, héros de la Première Guerre mondiale. Rafael Nadal y a remporté un record de 14 titres.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_hand_nb_joueurs",
            title = "Joueurs au handball sur le terrain",
            text = "Combien de joueurs composent une équipe de handball sur le terrain ?",
            options = listOf("5", "6", "7", "8"),
            correctIndex = 2,
            rating = 700,
            explanation = "Une équipe de handball est composée de 7 joueurs sur le terrain : 1 gardien de but et 6 joueurs de champ. Le handball est né en Europe du Nord à la fin du XIXe siècle et est devenu sport olympique en 1972. La France est l'une des grandes puissances mondiales de ce sport, ayant remporté plusieurs titres olympiques et de nombreux championnats du monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_jo_frequence",
            title = "Fréquence des Jeux Olympiques d'été",
            text = "Tous les combien d'années ont lieu les Jeux Olympiques d'été ?",
            options = listOf("2 ans", "3 ans", "4 ans", "5 ans"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les Jeux Olympiques d'été ont lieu tous les 4 ans, une période appelée \"olympiade\". Inspirés des Jeux de la Grèce antique, ils furent rénovés par le baron Pierre de Coubertin en 1896 à Athènes. Depuis 1994, les Jeux d'hiver se tiennent en décalage de deux ans, si bien qu'un événement olympique a lieu tous les deux ans en alternance.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_strike_bowling",
            title = "Sport où l'on fait un « strike »",
            text = "Dans quel sport peut-on réaliser un \"strike\" ?",
            options = listOf("Le golf", "Le bowling", "Le curling", "Le billard"),
            correctIndex = 1,
            rating = 750,
            explanation = "Au bowling, un \"strike\" consiste à faire tomber les dix quilles d'un seul lancer. C'est le meilleur coup possible, qui rapporte un bonus de points sur les lancers suivants. Le bowling moderne à dix quilles s'est popularisé aux États-Unis au XXe siècle et compte aujourd'hui des millions de pratiquants à travers le monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tour_de_france",
            title = "La plus grande course cycliste française",
            text = "Quelle est la plus grande course cycliste française ?",
            options = listOf("Paris-Roubaix", "Le Tour de France", "La Vuelta", "Le Giro"),
            correctIndex = 1,
            rating = 600,
            explanation = "Le Tour de France est la plus grande course cycliste française et l'une des plus prestigieuses au monde. Créé en 1903, il se déroule chaque été sur environ trois semaines et plus de 3 000 km. Le leader du classement général porte le célèbre maillot jaune, dont la couleur rappelle celle du journal L'Auto qui créa l'épreuve.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_golf_nb_trous",
            title = "Trous d'un parcours de golf",
            text = "Combien de trous compte un parcours de golf standard ?",
            options = listOf("9", "12", "18", "21"),
            correctIndex = 2,
            rating = 800,
            explanation = "Un parcours de golf standard compte 18 trous. Ce nombre s'est imposé au XVIIIe siècle au club de Saint Andrews, en Écosse, berceau du golf moderne. Chaque trou a un \"par\", c'est-à-dire un nombre de coups de référence ; l'objectif est de terminer le parcours avec le moins de coups possible.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_phelps_medailles",
            title = "Nageur aux 23 titres olympiques",
            text = "Quel nageur a remporté 23 médailles d'or olympiques ?",
            options = listOf("Mark Spitz", "Michael Phelps", "Ian Thorpe", "Caeleb Dressel"),
            correctIndex = 1,
            rating = 1000,
            explanation = "L'Américain Michael Phelps détient le record absolu avec 23 médailles d'or olympiques, sur un total de 28 médailles. Surnommé le \"requin de Baltimore\", il a notamment remporté huit titres lors des seuls Jeux de Pékin en 2008, un exploit inédit. Il est considéré comme le plus grand nageur de tous les temps.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_jo_antiques_grece",
            title = "Berceau des Jeux Olympiques antiques",
            text = "Dans quel pays sont nés les Jeux Olympiques antiques ?",
            options = listOf("L'Italie", "La Grèce", "L'Égypte", "La Turquie"),
            correctIndex = 1,
            rating = 700,
            explanation = "Les Jeux Olympiques antiques sont nés en Grèce, à Olympie, où ils se tenaient dès 776 av. J.-C. en l'honneur du dieu Zeus. Ils réunissaient les cités grecques lors d'une trêve sacrée et comprenaient des épreuves comme la course, la lutte ou le pancrace. Interdits en 393 apr. J.-C., ils furent ressuscités sous forme moderne en 1896.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_cdm_2022_messi",
            title = "Capitaine argentin sacré en 2022",
            text = "Quel joueur argentin a soulevé la Coupe du Monde de football 2022 ?",
            options = listOf("Diego Maradona", "Lionel Messi", "Sergio Agüero", "Ángel Di María"),
            correctIndex = 1,
            rating = 750,
            explanation = "Lionel Messi a remporté la Coupe du Monde 2022 au Qatar en tant que capitaine de l'Argentine, qui s'est imposée face à la France lors d'une finale spectaculaire conclue aux tirs au but. Ce sacre, longtemps attendu, a parachevé la carrière de l'un des plus grands joueurs de l'histoire, multiple Ballon d'or.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_f1_nb_pilotes",
            title = "Pilotes par écurie de Formule 1",
            text = "Combien de pilotes composent une écurie de Formule 1 en course ?",
            options = listOf("1", "2", "3", "4"),
            correctIndex = 1,
            rating = 850,
            explanation = "Chaque écurie de Formule 1 aligne 2 pilotes en course, soit un total de 20 voitures sur la grille de départ avec dix équipes. Les coéquipiers partagent les mêmes données techniques mais restent rivaux pour le championnat. Des pilotes de réserve peuvent toutefois remplacer un titulaire en cas de besoin.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_marathon_distance",
            title = "Distance d'un marathon",
            text = "Quelle distance parcourt-on lors d'un marathon ?",
            options = listOf("21 km", "42,195 km", "50 km", "100 km"),
            correctIndex = 1,
            rating = 900,
            explanation = "Un marathon couvre exactement 42,195 km. Cette distance commémore la légende du soldat grec Philippidès, qui aurait couru de la ville de Marathon jusqu'à Athènes pour annoncer la victoire avant de s'effondrer. La distance précise fut fixée lors des Jeux de Londres en 1908, pour que l'arrivée se fasse devant la tribune royale.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_hockey_glace",
            title = "Sport de crosse sur glace",
            text = "Dans quel sport utilise-t-on une crosse sur la glace ?",
            options = listOf("Le curling", "Le hockey sur glace", "Le patinage", "Le bobsleigh"),
            correctIndex = 1,
            rating = 650,
            explanation = "Le hockey sur glace se joue avec une crosse et un palet (ou \"puck\") en caoutchouc, sur une patinoire. Chaque équipe aligne six joueurs, dont un gardien, et tente d'envoyer le palet dans le but adverse. Très populaire au Canada, en Russie et dans les pays nordiques, ce sport rapide et physique est olympique depuis 1920.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_judo_japon",
            title = "Pays d'origine du judo",
            text = "Quel pays est à l'origine du judo ?",
            options = listOf("La Chine", "La Corée", "Le Japon", "La Thaïlande"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le judo est un art martial créé au Japon en 1882 par Jigoro Kano, à partir des techniques de l'ancien ju-jitsu des samouraïs. Son nom signifie \"voie de la souplesse\". Devenu sport olympique en 1964, le judo met l'accent sur la technique et le respect plutôt que sur la force brute. La France compte parmi les nations les plus titrées.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_rugby_essai_points",
            title = "Points d'un essai au rugby",
            text = "Combien de points vaut un essai au rugby à XV ?",
            options = listOf("3", "4", "5", "7"),
            correctIndex = 2,
            rating = 950,
            explanation = "Au rugby à XV, un essai rapporte 5 points. Il est marqué en aplatissant le ballon dans l'en-but adverse. Il donne ensuite droit à une tentative de transformation au pied, qui peut ajouter 2 points. À l'origine, l'essai ne valait aucun point et donnait simplement le droit de \"tenter\" de marquer au pied, d'où son nom.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_wimbledon",
            title = "Tournoi sur gazon à Londres",
            text = "Quel tournoi de tennis du Grand Chelem se joue sur gazon à Londres ?",
            options = listOf("L'US Open", "Wimbledon", "L'Open d'Australie", "Roland-Garros"),
            correctIndex = 1,
            rating = 800,
            explanation = "Wimbledon, disputé à Londres, est le plus ancien tournoi de tennis du monde, créé en 1877, et le seul du Grand Chelem encore joué sur gazon. Réputé pour ses traditions, il impose aux joueurs une tenue entièrement blanche. Roger Federer y détient le record masculin avec huit titres en simple.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tiger_woods_golf",
            title = "Sport de Tiger Woods",
            text = "Dans quel sport Tiger Woods s'est-il illustré ?",
            options = listOf("Le tennis", "Le golf", "Le baseball", "Le basketball"),
            correctIndex = 1,
            rating = 700,
            explanation = "Tiger Woods est l'un des plus grands golfeurs de l'histoire. Professionnel dès 1996, il a remporté 15 tournois du Grand Chelem et dominé le golf mondial pendant de nombreuses années. Son talent précoce et son charisme ont largement contribué à populariser ce sport auprès d'un public plus large à travers le monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_wimbledon_surface",
            title = "Surface de Wimbledon",
            text = "Sur quelle surface se joue le tournoi de Wimbledon ?",
            options = listOf("Terre battue", "Dur", "Gazon", "Moquette"),
            correctIndex = 2,
            rating = 850,
            explanation = "Wimbledon est le plus ancien tournoi du Grand Chelem et le seul disputé sur gazon. Cette surface favorise traditionnellement un jeu rapide.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_rugby_essai_points",
            title = "Valeur d'un essai",
            text = "Combien de points rapporte un essai en rugby à XV ?",
            options = listOf("3", "4", "5", "6"),
            correctIndex = 2,
            rating = 950,
            explanation = "Depuis 1992, un essai vaut 5 points au rugby à XV. Une transformation réussie permet ensuite d'ajouter 2 points supplémentaires.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_natation_papillon",
            title = "Nage papillon",
            text = "Quelle nage est généralement considérée comme la plus exigeante physiquement ?",
            options = listOf("Dos crawlé", "Brasse", "Papillon", "Nage libre"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Le papillon demande une excellente coordination et une importante dépense énergétique, ce qui en fait l'une des nages les plus difficiles.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tour_france_maillot_vert",
            title = "Maillot vert",
            text = "Que récompense principalement le maillot vert du Tour de France ?",
            options = listOf("Le meilleur grimpeur", "Le leader du classement général", "Le meilleur jeune", "Le classement par points"),
            correctIndex = 3,
            rating = 1000,
            explanation = "Le maillot vert distingue le leader du classement par points, généralement dominé par les sprinteurs.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_baseball_manches",
            title = "Manches au baseball",
            text = "Combien de manches comporte normalement un match de baseball professionnel ?",
            options = listOf("7", "8", "9", "10"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Un match de baseball se dispute généralement en 9 manches. Des manches supplémentaires peuvent être jouées en cas d'égalité.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_judo_ippon",
            title = "L'ippon au judo",
            text = "Que signifie obtenir un ippon au judo ?",
            options = listOf("Un avertissement", "La victoire immédiate", "Un point partiel", "Une prolongation"),
            correctIndex = 1,
            rating = 1100,
            explanation = "L'ippon est la meilleure action possible au judo. Il met immédiatement fin au combat et donne la victoire.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_marathon_distance",
            title = "Distance du marathon",
            text = "Quelle est la distance officielle d'un marathon ?",
            options = listOf("40,195 km", "41,195 km", "42,195 km", "43,195 km"),
            correctIndex = 2,
            rating = 700,
            explanation = "La distance officielle du marathon est de 42,195 km. Elle fut fixée lors des Jeux olympiques de Londres en 1908.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_cricket_wicket",
            title = "Le wicket",
            text = "Au cricket, qu'est-ce qu'un wicket ?",
            options = listOf("Une balle spéciale", "Un ensemble de piquets", "Une zone du terrain", "Un arbitre"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Le wicket est constitué de trois piquets surmontés de deux petites traverses. Il joue un rôle central dans les règles du cricket.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_escrime_fleuret",
            title = "Arme du fleuret",
            text = "Le fleuret est une discipline de quel sport ?",
            options = listOf("Pentathlon moderne", "Escrime", "Tir sportif", "Hockey"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le fleuret est l'une des trois armes de l'escrime avec l'épée et le sabre.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_golf_trou_un",
            title = "Trou en un",
            text = "Au golf, que signifie réaliser un « trou en un » ?",
            options = listOf("Jouer un parcours complet", "Mettre la balle dans le trou en un seul coup", "Terminer sous le par", "Gagner un tournoi"),
            correctIndex = 1,
            rating = 900,
            explanation = "Un trou en un consiste à envoyer directement la balle dans le trou depuis l'aire de départ en un seul coup.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_handball_joueurs",
            title = "Joueurs au handball",
            text = "Combien de joueurs une équipe de handball compte-t-elle sur le terrain ?",
            options = listOf("6", "7", "8", "9"),
            correctIndex = 1,
            rating = 850,
            explanation = "Une équipe de handball joue avec 7 joueurs sur le terrain : 6 joueurs de champ et 1 gardien.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_nba_panier_trois_points",
            title = "Tir à trois points",
            text = "Au basketball, combien vaut un panier marqué derrière la ligne à trois points ?",
            options = listOf("2 points", "3 points", "4 points", "5 points"),
            correctIndex = 1,
            rating = 650,
            explanation = "Un tir réussi derrière la ligne à trois points rapporte 3 points à l'équipe.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_biathlon_disciplines",
            title = "Le biathlon",
            text = "Quelles disciplines sont combinées dans le biathlon ?",
            options = listOf("Ski de fond et tir", "Ski alpin et saut", "Course et natation", "Patinage et tir"),
            correctIndex = 0,
            rating = 900,
            explanation = "Le biathlon associe le ski de fond et le tir à la carabine. Les erreurs au tir entraînent des pénalités.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_boxe_poids_lourd",
            title = "Poids lourds",
            text = "Dans quel sport trouve-t-on la catégorie des poids lourds ?",
            options = listOf("Tennis", "Boxe", "Cyclisme", "Aviron"),
            correctIndex = 1,
            rating = 700,
            explanation = "Les poids lourds constituent l'une des catégories les plus prestigieuses en boxe professionnelle.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_voile_coupe_america",
            title = "Coupe de l'America",
            text = "La Coupe de l'America est une compétition de quel sport ?",
            options = listOf("Aviron", "Surf", "Voile", "Canoë-kayak"),
            correctIndex = 2,
            rating = 1200,
            explanation = "La Coupe de l'America est la plus ancienne compétition sportive internationale encore disputée. Elle concerne la voile.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_saut_perche_record",
            title = "Saut à la perche",
            text = "Dans quelle discipline sportive utilise-t-on une longue perche flexible ?",
            options = listOf("Lancer du javelot", "Saut à la perche", "Saut en longueur", "Triple saut"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le saut à la perche consiste à franchir une barre horizontale grâce à une perche qui emmagasine l'énergie du saut.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_dakar_origine",
            title = "Origine du Dakar",
            text = "Le rallye Dakar reliait historiquement Paris à quelle ville africaine ?",
            options = listOf("Le Caire", "Casablanca", "Dakar", "Tunis"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Le rallye Paris-Dakar tirait son nom de son arrivée historique à Dakar, capitale du Sénégal.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_aviron_huit_barreur",
            title = "Le huit en aviron",
            text = "Dans l'épreuve du huit en aviron, combien de rameurs sont présents dans le bateau ?",
            options = listOf("6", "7", "8", "9"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Le huit est composé de 8 rameurs auxquels s'ajoute généralement un barreur chargé de diriger l'embarcation.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tennis_grand_chelem",
            title = "Tournois du Grand Chelem",
            text = "Combien de tournois composent le Grand Chelem de tennis ?",
            options = listOf("3", "4", "5", "6"),
            correctIndex = 1,
            rating = 750,
            explanation = "Le Grand Chelem comprend l'Open d'Australie, Roland-Garros, Wimbledon et l'US Open.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_triathlon_ordre",
            title = "Ordre du triathlon",
            text = "Quel est l'ordre correct des disciplines dans un triathlon classique ?",
            options = listOf("Natation, vélo, course à pied", "Vélo, natation, course à pied", "Course à pied, vélo, natation", "Natation, course à pied, vélo"),
            correctIndex = 0,
            rating = 950,
            explanation = "Le triathlon débute par la natation, se poursuit à vélo puis se termine par la course à pied.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_snooker_billes",
            title = "Nombre de billes au snooker",
            text = "Combien de billes rouges sont utilisées au début d'une partie de snooker ?",
            options = listOf("10", "12", "15", "18"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Le snooker se joue avec 15 billes rouges, 6 billes de couleur et une bille blanche. Les joueurs alternent entre les rouges et les couleurs pour marquer des points.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_water_polo_joueurs",
            title = "Équipe de water-polo",
            text = "Combien de joueurs une équipe de water-polo compte-t-elle dans l'eau en même temps ?",
            options = listOf("6", "7", "8", "9"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Une équipe de water-polo aligne 7 joueurs dans l'eau : 6 joueurs de champ et 1 gardien de but.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_montgolfiere_sport",
            title = "Compétition en montgolfière",
            text = "Comment appelle-t-on le sport consistant à piloter une montgolfière en compétition ?",
            options = listOf("Ballonisme", "Aérostation", "Vol libre", "Aéroglisse"),
            correctIndex = 1,
            rating = 1700,
            explanation = "L'aérostation désigne la pratique des aéronefs plus légers que l'air, notamment les montgolfières utilisées lors de compétitions de précision.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_hockey_palet",
            title = "Objet du hockey sur glace",
            text = "Comment appelle-t-on l'objet que les joueurs frappent au hockey sur glace ?",
            options = listOf("Balle", "Disque", "Palet", "Galet"),
            correctIndex = 2,
            rating = 700,
            explanation = "Le hockey sur glace se joue avec un palet en caoutchouc vulcanisé pesant environ 170 grammes.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_decathlon_epreuves",
            title = "Le décathlon",
            text = "Combien d'épreuves composent un décathlon ?",
            options = listOf("8", "10", "12", "14"),
            correctIndex = 1,
            rating = 800,
            explanation = "Comme son nom l'indique, le décathlon comprend 10 disciplines d'athlétisme réparties sur deux journées.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_curling_balais",
            title = "Balayage au curling",
            text = "Pourquoi les joueurs balaient-ils la glace devant la pierre au curling ?",
            options = listOf("Pour la ralentir", "Pour la réchauffer et modifier sa trajectoire", "Pour la nettoyer", "Pour marquer des points"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Le balayage réchauffe légèrement la surface de la glace, réduisant les frottements et influençant la distance ainsi que la trajectoire de la pierre.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_escalade_vitesse_record",
            title = "Escalade de vitesse",
            text = "Lors des compétitions internationales d'escalade de vitesse, quelle est la hauteur du mur ?",
            options = listOf("10 mètres", "12 mètres", "15 mètres", "20 mètres"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Les compétitions officielles d'escalade de vitesse utilisent un mur standardisé de 15 mètres de haut dans le monde entier.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_badminton_volant",
            title = "Le volant de badminton",
            text = "Traditionnellement, de quoi sont faites les plumes d'un volant de compétition ?",
            options = listOf("Canard", "Oie", "Paon", "Dinde"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Les meilleurs volants de badminton sont fabriqués à partir de plumes d'oie soigneusement sélectionnées pour garantir une trajectoire régulière.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_luge_position",
            title = "Position en luge",
            text = "Dans quelle position les athlètes pratiquent-ils la luge de compétition ?",
            options = listOf("Debout", "Assis", "Allongés sur le dos", "À genoux"),
            correctIndex = 2,
            rating = 950,
            explanation = "Les lugeurs sont allongés sur le dos, les pieds en avant, ce qui leur permet d'atteindre des vitesses supérieures à 130 km/h.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_petanque_cochonnet",
            title = "Nom du but à la pétanque",
            text = "Comment appelle-t-on la petite boule servant de cible à la pétanque ?",
            options = listOf("Le pion", "Le bouchon", "Le cochonnet", "Le témoin"),
            correctIndex = 2,
            rating = 750,
            explanation = "Le cochonnet, également appelé bouchon dans certaines régions, sert de cible aux joueurs de pétanque pour marquer des points.",
            category = Category.SPORTS
        ),

        // ===================== DIVERTISSEMENT =====================
        Question(
            id = "div_ironman_acteur",
            title = "Acteur d'Iron Man",
            text = "Quel acteur incarne Iron Man dans les films Marvel ?",
            options = listOf("Chris Evans", "Chris Hemsworth", "Robert Downey Jr.", "Mark Ruffalo"),
            correctIndex = 2,
            rating = 750,
            explanation = "Robert Downey Jr. incarne Tony Stark / Iron Man depuis le premier film du MCU en 2008. Son interprétation charismatique a largement contribué au succès mondial de la franchise. Il apparaît dans 10 films Marvel, culminant avec Avengers : Endgame (2019), l'un des films les plus rentables de l'histoire avec plus de 2,79 milliards de dollars de recettes mondiales.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_ross_rachel_friends",
            title = "Série de Ross et Rachel",
            text = "Dans quelle série retrouve-t-on les personnages de Ross et Rachel ?",
            options = listOf("Seinfeld", "How I Met Your Mother", "Friends", "The Big Bang Theory"),
            correctIndex = 2,
            rating = 700,
            explanation = "Ross Geller et Rachel Green sont deux des six personnages principaux de Friends, série américaine diffusée de 1994 à 2004 sur NBC. Leur relation amoureuse tumultueuse est l'un des fils rouges de la série. Friends reste l'une des séries télévisées les plus regardées de l'histoire, et la réunion des acteurs en 2021 a été vue par des dizaines de millions de spectateurs.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_los_santos_gta",
            title = "Jeu situé à Los Santos",
            text = "Quel jeu vidéo se déroule dans la ville fictive de \"Los Santos\" ?",
            options = listOf("Red Dead Redemption", "Cyberpunk 2077", "Grand Theft Auto V", "Watch Dogs"),
            correctIndex = 2,
            rating = 850,
            explanation = "Los Santos est la ville fictive inspirée de Los Angeles dans Grand Theft Auto V, sorti en 2013. Développé par Rockstar Games, GTA V est l'un des jeux vidéo les plus vendus de l'histoire avec plus de 195 millions d'exemplaires écoulés. Le jeu propose également GTA Online, régulièrement mis à jour depuis son lancement.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_inception_nolan",
            title = "Réalisateur d'Inception",
            text = "Qui a réalisé le film \"Inception\" (2010) ?",
            options = listOf("Steven Spielberg", "James Cameron", "Ridley Scott", "Christopher Nolan"),
            correctIndex = 3,
            rating = 900,
            explanation = "Inception est un film de science-fiction réalisé par Christopher Nolan, sorti en 2010. Il met en scène Leonardo DiCaprio dans le rôle d'un voleur capable de s'infiltrer dans les rêves. Le film a remporté quatre Oscars, dont celui de la meilleure photographie et des meilleurs effets visuels. Nolan est également connu pour la trilogie Batman et Oppenheimer (2023).",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_thriller_jackson",
            title = "Artiste de l'album Thriller",
            text = "Quel artiste a sorti l'album \"Thriller\" en 1982 ?",
            options = listOf("Prince", "Madonna", "Michael Jackson", "Whitney Houston"),
            correctIndex = 2,
            rating = 800,
            explanation = "Thriller est le sixième album studio de Michael Jackson, sorti en novembre 1982. Produit par Quincy Jones, il reste l'album le plus vendu de l'histoire avec plus de 70 millions d'exemplaires dans le monde. Il contient des titres emblématiques comme \"Billie Jean\", \"Beat It\" et \"Thriller\". Le clip de \"Thriller\", réalisé par John Landis, a révolutionné le format du clip musical.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_yoda_starwars",
            title = "Maître vert de la Force",
            text = "Quel petit personnage vert enseigne la Force dans Star Wars ?",
            options = listOf("Chewbacca", "Yoda", "R2-D2", "Jabba"),
            correctIndex = 1,
            rating = 650,
            explanation = "Yoda est un maître Jedi de la saga Star Wars, reconnaissable à sa petite taille, sa peau verte et sa syntaxe inversée. Âgé de 900 ans, il incarne la sagesse et la maîtrise de la Force. Apparu pour la première fois dans L'Empire contre-attaque en 1980, il forme de nombreux Jedi, dont Luke Skywalker.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_harry_potter",
            title = "Jeune sorcier de J.K. Rowling",
            text = "Comment s'appelle le jeune sorcier à lunettes créé par J.K. Rowling ?",
            options = listOf("Harry Potter", "Frodon", "Percy Jackson", "Gandalf"),
            correctIndex = 0,
            rating = 600,
            explanation = "Harry Potter est le héros de la saga littéraire écrite par la Britannique J.K. Rowling, dont le premier tome parut en 1997. Orphelin élevé chez son oncle et sa tante, il découvre à onze ans qu'il est un sorcier et intègre l'école de Poudlard. Les sept romans, traduits dans plus de 80 langues, ont donné lieu à une saga cinématographique mondialement célèbre.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_roi_lion_disney",
            title = "Studio du Roi Lion",
            text = "Quel studio a produit le film d'animation \"Le Roi Lion\" ?",
            options = listOf("Pixar", "DreamWorks", "Disney", "Studio Ghibli"),
            correctIndex = 2,
            rating = 700,
            explanation = "\"Le Roi Lion\", sorti en 1994, est un film d'animation produit par les studios Disney. Racontant l'histoire du lionceau Simba, il est devenu l'un des plus grands succès de l'animation, salué pour sa musique signée Elton John et Hans Zimmer. Une adaptation en images de synthèse est sortie en 2019, ainsi qu'une comédie musicale jouée dans le monde entier.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_creepers_minecraft",
            title = "Jeu des « Creepers »",
            text = "Dans quel jeu vidéo affronte-t-on des créatures appelées \"Creepers\" ?",
            options = listOf("Fortnite", "Minecraft", "Roblox", "Terraria"),
            correctIndex = 1,
            rating = 800,
            explanation = "Les \"Creepers\", créatures vertes qui explosent à proximité du joueur, sont emblématiques de Minecraft. Ce jeu \"bac à sable\" créé par Markus Persson et sorti en 2011 permet de construire et d'explorer un monde fait de blocs. Avec plus de 300 millions d'exemplaires vendus, c'est le jeu vidéo le plus vendu de tous les temps.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_reine_pop_madonna",
            title = "La « Reine de la pop »",
            text = "Quelle chanteuse est surnommée la \"Reine de la pop\" ?",
            options = listOf("Beyoncé", "Madonna", "Lady Gaga", "Britney Spears"),
            correctIndex = 1,
            rating = 750,
            explanation = "Madonna est mondialement surnommée la \"Reine de la pop\" pour son influence considérable sur la musique et la culture depuis les années 1980. Connue pour ses réinventions constantes et ses spectacles provocateurs, elle est l'artiste féminine ayant vendu le plus de disques de l'histoire, avec des tubes comme \"Like a Virgin\" ou \"Vogue\".",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_avatar_pandora",
            title = "Film sur la planète Pandora",
            text = "Quel film de James Cameron, sorti en 2009, se déroule sur la planète Pandora ?",
            options = listOf("Avatar", "Interstellar", "Star Trek", "Gravity"),
            correctIndex = 0,
            rating = 800,
            explanation = "Avatar, réalisé par James Cameron en 2009, se déroule sur la lune luxuriante de Pandora, peuplée par les Na'vi. Révolutionnaire par ses effets visuels et sa 3D, il est devenu le film le plus rentable de l'histoire au box-office mondial. Une suite tant attendue, Avatar : La Voie de l'eau, est sortie en 2022.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_dark_vador_pere",
            title = "Père de Luke Skywalker",
            text = "Dans la saga Star Wars, qui est le père de Luke Skywalker ?",
            options = listOf("Obi-Wan Kenobi", "Dark Vador", "L'Empereur Palpatine", "Han Solo"),
            correctIndex = 1,
            rating = 750,
            explanation = "La révélation que Dark Vador est le père de Luke Skywalker, dans L'Empire contre-attaque (1980), est l'un des rebondissements les plus célèbres de l'histoire du cinéma. Dark Vador, autrefois le chevalier Jedi Anakin Skywalker, a basculé du côté obscur de la Force. La réplique \"Je suis ton père\" est souvent citée — et mal citée — à travers le monde.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_walter_white_breakingbad",
            title = "Série de Walter White",
            text = "Quelle série met en scène le professeur de chimie devenu trafiquant Walter White ?",
            options = listOf("The Wire", "Breaking Bad", "Dexter", "Better Call Saul"),
            correctIndex = 1,
            rating = 900,
            explanation = "Breaking Bad, diffusée de 2008 à 2013, suit Walter White, un professeur de chimie atteint d'un cancer qui se lance dans la fabrication de méthamphétamine pour assurer l'avenir de sa famille. Portée par l'acteur Bryan Cranston, la série est unanimement considérée comme l'une des meilleures de l'histoire de la télévision et a donné naissance au spin-off Better Call Saul.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_shape_of_you_sheeran",
            title = "Chanteur de « Shape of You »",
            text = "Quel chanteur britannique est l'auteur de la chanson \"Shape of You\" ?",
            options = listOf("Sam Smith", "Ed Sheeran", "Harry Styles", "Robbie Williams"),
            correctIndex = 1,
            rating = 850,
            explanation = "\"Shape of You\" est un titre du chanteur britannique Ed Sheeran, sorti en 2017 sur l'album ÷ (Divide). Devenu un phénomène mondial, il figure parmi les vidéos les plus visionnées de YouTube et les chansons les plus écoutées sur les plateformes de streaming. Ed Sheeran est connu pour ses ballades pop interprétées souvent en solo à la guitare.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_bohemian_rhapsody_queen",
            title = "Groupe de « Bohemian Rhapsody »",
            text = "Quel groupe britannique a chanté \"Bohemian Rhapsody\" ?",
            options = listOf("The Beatles", "The Rolling Stones", "Queen", "Led Zeppelin"),
            correctIndex = 2,
            rating = 800,
            explanation = "\"Bohemian Rhapsody\" est une chanson du groupe Queen, sortie en 1975 sur l'album A Night at the Opera. Composée par Freddie Mercury, elle mêle ballade, opéra et hard rock en près de six minutes, une audace inédite à l'époque. Le film biographique du même nom, sorti en 2018, a remporté plusieurs Oscars.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_fast_furious_toretto",
            title = "Franchise de Dominic Toretto",
            text = "Quelle franchise de films met en scène Dominic Toretto et des courses de voitures ?",
            options = listOf("Need for Speed", "Fast and Furious", "Rush", "Le Transporteur"),
            correctIndex = 1,
            rating = 750,
            explanation = "La saga Fast and Furious, lancée en 2001, suit Dominic Toretto, incarné par Vin Diesel, et sa \"famille\" d'as du volant. D'abord centrée sur les courses de rue illégales, la franchise a évolué vers des films d'action spectaculaires. Avec une dizaine d'opus, elle est l'une des séries de films les plus rentables de l'histoire du cinéma.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_schtroumpfs_couleur",
            title = "Couleur des Schtroumpfs",
            text = "De quelle couleur sont les Schtroumpfs ?",
            options = listOf("Verts", "Bleus", "Jaunes", "Rouges"),
            correctIndex = 1,
            rating = 600,
            explanation = "Les Schtroumpfs sont de petits êtres bleus coiffés d'un bonnet blanc, créés en 1958 par le dessinateur belge Peyo. Vivant dans des maisons en forme de champignons, ils sont menacés par le sorcier Gargamel et son chat Azraël. La bande dessinée, puis la série animée des années 1980, ont fait connaître ces personnages dans le monde entier.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pulp_fiction_tarantino",
            title = "Réalisateur de Pulp Fiction",
            text = "Quel réalisateur est célèbre pour \"Pulp Fiction\" et \"Kill Bill\" ?",
            options = listOf("Martin Scorsese", "Quentin Tarantino", "Steven Spielberg", "Les frères Coen"),
            correctIndex = 1,
            rating = 950,
            explanation = "Quentin Tarantino est un réalisateur américain connu pour son style unique mêlant dialogues ciselés, violence stylisée et narration non linéaire. Pulp Fiction (1994) lui valut la Palme d'or à Cannes et l'Oscar du meilleur scénario. Cinéphile passionné, il a également signé Reservoir Dogs, Django Unchained et Inglourious Basterds.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_seigneur_anneaux",
            title = "Saga de la Terre du Milieu",
            text = "Quelle saga se déroule dans un univers appelé la \"Terre du Milieu\" ?",
            options = listOf("Game of Thrones", "Le Seigneur des Anneaux", "Le Monde de Narnia", "Harry Potter"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Terre du Milieu est l'univers imaginaire créé par l'écrivain britannique J.R.R. Tolkien, cadre du Seigneur des Anneaux et du Hobbit. Peuplée d'elfes, de nains, de hobbits et d'orques, elle est devenue une référence majeure de la fantasy. La trilogie de films de Peter Jackson, sortie entre 2001 et 2003, a remporté de nombreux Oscars.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_batman",
            title = "Le super-héros chauve-souris",
            text = "Quel super-héros est surnommé \"l'homme chauve-souris\" ?",
            options = listOf("Superman", "Batman", "Spider-Man", "Hulk"),
            correctIndex = 1,
            rating = 600,
            explanation = "Batman, \"l'homme chauve-souris\", est un super-héros créé en 1939 pour DC Comics. Sous le masque se cache le milliardaire Bruce Wayne qui, traumatisé par le meurtre de ses parents, combat le crime à Gotham City. Dépourvu de super-pouvoirs, il compte sur son intelligence, sa fortune et ses gadgets. Le personnage a inspiré de nombreux films à succès.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pixar_lampe",
            title = "Mascotte de Pixar",
            text = "Quel objet est devenu l'un des symboles du studio Pixar ?",
            options = listOf("Une lampe de bureau", "Une voiture rouge", "Une fusée", "Un ballon"),
            correctIndex = 0,
            rating = 800,
            explanation = "La lampe Luxo Jr., apparue dans un court-métrage de Pixar en 1986, est devenue l'emblème du studio et figure dans son logo animé.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_simpson_ville",
            title = "Ville des Simpson",
            text = "Comment s'appelle la ville où vivent les Simpson ?",
            options = listOf("Shelbyville", "Springfield", "Quahog", "South Park"),
            correctIndex = 1,
            rating = 850,
            explanation = "La famille Simpson vit à Springfield. Les créateurs ont volontairement choisi un nom très répandu afin que chacun puisse s'identifier à la ville.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_mario_createur",
            title = "Créateur de Mario",
            text = "Quel concepteur de jeux vidéo est à l'origine du personnage de Mario ?",
            options = listOf("Hideo Kojima", "Shigeru Miyamoto", "Yu Suzuki", "Satoru Iwata"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Shigeru Miyamoto a créé Mario au début des années 1980 pour Nintendo. Le personnage est devenu l'une des icônes du jeu vidéo.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_friends_cafe",
            title = "Café de Friends",
            text = "Comment s'appelle le café où se retrouvent souvent les personnages de Friends ?",
            options = listOf("Central Perk", "Coffee House", "Monk's Café", "The Peach Pit"),
            correctIndex = 0,
            rating = 900,
            explanation = "Le Central Perk est le lieu emblématique de la série Friends, où les six amis passent une grande partie de leur temps.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pacman_fantomes",
            title = "Les ennemis de Pac-Man",
            text = "Dans Pac-Man, quels adversaires poursuivent le joueur ?",
            options = listOf("Des robots", "Des fantômes", "Des monstres marins", "Des dragons"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le but de Pac-Man est d'éviter les fantômes tout en mangeant les pastilles du labyrinthe.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_hobbit_maison",
            title = "Maison de Bilbon",
            text = "Comment s'appelle la demeure de Bilbon Sacquet dans Le Hobbit ?",
            options = listOf("Fondcombe", "Cul-de-Sac", "Minas Tirith", "La Comté Royale"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Bilbon habite Cul-de-Sac, une confortable maison de hobbit située dans la Comté.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_disney_reine_neiges",
            title = "Pouvoir d'Elsa",
            text = "Quel pouvoir possède Elsa dans La Reine des Neiges ?",
            options = listOf("Contrôler le feu", "Contrôler la glace et la neige", "Lire dans les pensées", "Voler"),
            correctIndex = 1,
            rating = 700,
            explanation = "Elsa possède le pouvoir magique de créer et contrôler la glace et la neige, au cœur de l'intrigue du film.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_starwars_wookiee",
            title = "Espèce de Chewbacca",
            text = "À quelle espèce appartient Chewbacca dans Star Wars ?",
            options = listOf("Ewok", "Wookiee", "Jawa", "Twi'lek"),
            correctIndex = 1,
            rating = 950,
            explanation = "Chewbacca est un Wookiee originaire de la planète Kashyyyk et le fidèle compagnon de Han Solo.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_tetris_origine",
            title = "Origine de Tetris",
            text = "Dans quel pays Tetris a-t-il été créé ?",
            options = listOf("États-Unis", "Japon", "URSS", "France"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Tetris a été créé en 1984 par Alexeï Pajitnov en Union soviétique. Il est devenu l'un des jeux vidéo les plus célèbres au monde.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pokemon_pikachu_type",
            title = "Type de Pikachu",
            text = "Quel est le type principal de Pikachu dans Pokémon ?",
            options = listOf("Feu", "Électrik", "Psy", "Combat"),
            correctIndex = 1,
            rating = 650,
            explanation = "Pikachu est un Pokémon de type Électrik et la mascotte officielle de la franchise Pokémon.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_james_bond_matricule",
            title = "Agent 007",
            text = "Quel est le matricule de James Bond ?",
            options = listOf("006", "007", "008", "009"),
            correctIndex = 1,
            rating = 700,
            explanation = "James Bond est l'agent secret 007 du MI6 britannique, créé par l'écrivain Ian Fleming.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_netflix_mercredi",
            title = "Famille de Mercredi",
            text = "Dans quelle famille fictive évolue le personnage de Mercredi Addams ?",
            options = listOf("La famille Pierrafeu", "La famille Addams", "La famille Munster", "La famille Simpson"),
            correctIndex = 1,
            rating = 850,
            explanation = "Mercredi Addams est l'un des personnages les plus célèbres de la famille Addams, popularisée par les bandes dessinées, films et séries.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_minecraft_blocs",
            title = "Principe de Minecraft",
            text = "Quel élément caractérise principalement l'univers de Minecraft ?",
            options = listOf("Des mondes cubiques composés de blocs", "Des circuits automobiles", "Des combats spatiaux", "Des cartes à collectionner"),
            correctIndex = 0,
            rating = 700,
            explanation = "Minecraft repose sur un univers généré procéduralement où presque tout est construit à partir de blocs.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_avatar_pandora",
            title = "Monde d'Avatar",
            text = "Comment s'appelle la lune sur laquelle se déroule l'histoire d'Avatar ?",
            options = listOf("Pandora", "Titan", "Endor", "Arrakis"),
            correctIndex = 0,
            rating = 950,
            explanation = "L'univers d'Avatar se déroule principalement sur Pandora, une lune luxuriante peuplée des Na'vi.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_sonic_animal",
            title = "Animal de Sonic",
            text = "Quel animal est Sonic ?",
            options = listOf("Renard", "Hérisson", "Lapin", "Écureuil"),
            correctIndex = 1,
            rating = 650,
            explanation = "Sonic the Hedgehog est un hérisson bleu créé par Sega en 1991 pour concurrencer Mario.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_hunger_games_heroine",
            title = "Héroïne de Hunger Games",
            text = "Comment s'appelle l'héroïne principale de Hunger Games ?",
            options = listOf("Tris Prior", "Katniss Everdeen", "Bella Swan", "Clary Fray"),
            correctIndex = 1,
            rating = 850,
            explanation = "Katniss Everdeen est l'héroïne de la trilogie Hunger Games écrite par Suzanne Collins.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_zelda_princesse",
            title = "La princesse Zelda",
            text = "Dans la série The Legend of Zelda, quel personnage est généralement le héros jouable ?",
            options = listOf("Ganondorf", "Link", "Zelda", "Impa"),
            correctIndex = 1,
            rating = 900,
            explanation = "Malgré le titre de la série, le personnage principal contrôlé par le joueur est généralement Link.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_jurassic_parc_createur",
            title = "Auteur de Jurassic Park",
            text = "Qui a écrit le roman Jurassic Park à l'origine des films ?",
            options = listOf("Michael Crichton", "Stephen King", "Tom Clancy", "Dan Brown"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Michael Crichton a publié Jurassic Park en 1990. Steven Spielberg en a réalisé l'adaptation cinématographique en 1993.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_fortnite_tempete",
            title = "Mécanique de Fortnite",
            text = "Dans Fortnite, quel phénomène réduit progressivement la zone de jeu ?",
            options = listOf("Une tempête", "Un volcan", "Un séisme", "Une inondation"),
            correctIndex = 0,
            rating = 850,
            explanation = "La tempête force les joueurs à se rapprocher progressivement, rendant les affrontements inévitables.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_oscar_trophee",
            title = "Récompense du cinéma",
            text = "Quelle statuette est remise lors des Oscars du cinéma ?",
            options = listOf("Le Lion d'or", "L'Ours d'or", "L'Oscar", "La Palme d'or"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les Oscars, décernés par l'Academy of Motion Picture Arts and Sciences, sont les récompenses cinématographiques les plus prestigieuses des États-Unis.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_studio_ghibli_fondateur",
            title = "Fondateur du Studio Ghibli",
            text = "Quel réalisateur est l'un des fondateurs du Studio Ghibli ?",
            options = listOf("Mamoru Hosoda", "Hayao Miyazaki", "Makoto Shinkai", "Satoshi Kon"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Hayao Miyazaki a cofondé le Studio Ghibli en 1985 avec Isao Takahata. Le studio est à l'origine de films comme Mon Voisin Totoro et Le Voyage de Chihiro.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_monopoly_rue_chere",
            title = "Rue la plus chère du Monopoly",
            text = "Dans la version française classique du Monopoly, quelle est la propriété la plus chère ?",
            options = listOf("Rue de la Paix", "Avenue Foch", "Boulevard des Capucines", "Avenue Henri-Martin"),
            correctIndex = 0,
            rating = 850,
            explanation = "Dans le Monopoly français, la Rue de la Paix est la propriété la plus prestigieuse et la plus coûteuse du plateau.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_docteur_who_planete",
            title = "Origine du Docteur",
            text = "De quelle planète est originaire le Docteur dans la série Doctor Who ?",
            options = listOf("Skaro", "Gallifrey", "Trenzalore", "Mondas"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le Docteur est un Seigneur du Temps originaire de Gallifrey, une planète fictive au cœur de la mythologie de la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_lara_croft_metier",
            title = "Profession de Lara Croft",
            text = "Quelle est la profession de Lara Croft dans la série Tomb Raider ?",
            options = listOf("Archéologue", "Journaliste", "Pilote", "Scientifique"),
            correctIndex = 0,
            rating = 800,
            explanation = "Lara Croft est une aventurière et archéologue britannique parcourant le monde à la recherche de trésors et d'artefacts anciens.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_shrek_compagnon",
            title = "Compagnon de Shrek",
            text = "Quel personnage accompagne fréquemment Shrek dans ses aventures ?",
            options = listOf("Le Chat Potté", "Pinocchio", "L'Âne", "Le Grand Méchant Loup"),
            correctIndex = 2,
            rating = 700,
            explanation = "L'Âne est le compagnon le plus fidèle de Shrek. Son enthousiasme contraste souvent avec le caractère solitaire de l'ogre.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_batman_ville",
            title = "Ville de Batman",
            text = "Dans quelle ville fictive Batman combat-il le crime ?",
            options = listOf("Metropolis", "Central City", "Star City", "Gotham City"),
            correctIndex = 3,
            rating = 750,
            explanation = "Batman protège Gotham City, une métropole sombre inspirée notamment de New York et Chicago.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_stranger_things_dimension",
            title = "Dimension de Stranger Things",
            text = "Comment est appelée la dimension parallèle dans Stranger Things ?",
            options = listOf("Le Monde Noir", "L'Upside Down", "Le Nexus", "La Zone"),
            correctIndex = 1,
            rating = 1200,
            explanation = "L'Upside Down, traduit parfois par « le Monde à l'envers », est une dimension sombre et dangereuse au cœur de la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_mario_donkey_kong_origine",
            title = "Première apparition de Mario",
            text = "Dans quel jeu vidéo Mario est-il apparu pour la première fois ?",
            options = listOf("Super Mario Bros.", "Mario Bros.", "Donkey Kong", "Wrecking Crew"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Mario apparaît pour la première fois en 1981 dans Donkey Kong. Il était alors connu sous le nom de « Jumpman ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_astroboy_createur",
            title = "Créateur d'Astro Boy",
            text = "Quel mangaka est à l'origine d'Astro Boy ?",
            options = listOf("Akira Toriyama", "Naoki Urasawa", "Osamu Tezuka", "Rumiko Takahashi"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Osamu Tezuka, souvent surnommé le « dieu du manga », a créé Astro Boy dans les années 1950.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_lotr_gollum_nom",
            title = "Nom d'origine de Gollum",
            text = "Quel était le nom de Gollum avant qu'il ne trouve l'Anneau Unique ?",
            options = listOf("Déagol", "Sméagol", "Frodon", "Bilbon"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Avant sa corruption par l'Anneau Unique, Gollum s'appelait Sméagol. L'influence de l'Anneau transforma progressivement sa personnalité et son apparence.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "geo_kilimandjaro_pays",
            title = "Pays du Kilimandjaro",
            text = "Dans quel pays se situe le mont Kilimandjaro ?",
            options = listOf("Kenya", "Tanzanie", "Ouganda", "Éthiopie"),
            correctIndex = 1,
            rating = 900,
            explanation = "Le Kilimandjaro est situé en Tanzanie. Avec ses 5 895 mètres d'altitude, il constitue le point culminant de l'Afrique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_baltique_capitale",
            title = "Capitale de l'Estonie",
            text = "Quelle est la capitale de l'Estonie ?",
            options = listOf("Riga", "Vilnius", "Tallinn", "Helsinki"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Tallinn est la capitale de l'Estonie. Son centre historique médiéval est classé au patrimoine mondial de l'UNESCO.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mississippi_embouchure",
            title = "Embouchure du Mississippi",
            text = "Dans quel golfe se jette le Mississippi ?",
            options = listOf("Golfe du Mexique", "Golfe de Californie", "Golfe du Saint-Laurent", "Golfe du Bengale"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Le Mississippi traverse les États-Unis du nord au sud avant de se jeter dans le golfe du Mexique près de La Nouvelle-Orléans.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_bamako_pays",
            title = "Capitale du Mali",
            text = "Bamako est la capitale de quel pays ?",
            options = listOf("Mali", "Niger", "Burkina Faso", "Sénégal"),
            correctIndex = 0,
            rating = 800,
            explanation = "Bamako est la capitale et la plus grande ville du Mali. Elle est située sur les rives du fleuve Niger.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_falkland_souverainete",
            title = "Îles Falkland",
            text = "Les îles Falkland sont administrées par quel pays ?",
            options = listOf("Argentine", "Chili", "Royaume-Uni", "Uruguay"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Les îles Falkland, appelées Malouines en Argentine, sont un territoire britannique d'outre-mer au cœur d'un différend de souveraineté.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_lac_tanganyika",
            title = "Le lac Tanganyika",
            text = "Le lac Tanganyika se trouve sur quel continent ?",
            options = listOf("Asie", "Afrique", "Amérique du Sud", "Océanie"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le lac Tanganyika est situé en Afrique de l'Est. C'est l'un des lacs les plus profonds du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_alpes_pays_nombre",
            title = "Pays des Alpes",
            text = "Les Alpes s'étendent sur combien de pays européens ?",
            options = listOf("5", "6", "8", "10"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Les Alpes traversent 8 pays : France, Monaco, Italie, Suisse, Liechtenstein, Allemagne, Autriche et Slovénie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_nouvelle_zelande_capitale",
            title = "Capitale de la Nouvelle-Zélande",
            text = "Quelle est la capitale de la Nouvelle-Zélande ?",
            options = listOf("Auckland", "Christchurch", "Wellington", "Hamilton"),
            correctIndex = 2,
            rating = 950,
            explanation = "Wellington est la capitale de la Nouvelle-Zélande depuis 1865. Auckland est cependant la plus grande ville du pays.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_bosphore_mers",
            title = "Les deux mers du Bosphore",
            text = "Le Bosphore relie la mer Noire à quelle autre mer ?",
            options = listOf("Mer Égée", "Mer Adriatique", "Mer de Marmara", "Mer Caspienne"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Le Bosphore relie la mer Noire à la mer de Marmara, qui communique ensuite avec la mer Égée via les Dardanelles.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_namib_desert",
            title = "Le désert du Namib",
            text = "Dans quel pays se situe principalement le désert du Namib ?",
            options = listOf("Botswana", "Afrique du Sud", "Namibie", "Zimbabwe"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le désert du Namib est l'un des plus anciens déserts du monde. Il longe principalement la côte de la Namibie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_brunei_capitale",
            title = "Capitale du Brunei",
            text = "Quelle est la capitale du Brunei ?",
            options = listOf("Bandar Seri Begawan", "Kuala Lumpur", "Dili", "Manille"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Bandar Seri Begawan est la capitale du Brunei, petit sultanat riche en pétrole situé sur l'île de Bornéo.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_okavango_delta",
            title = "Le delta de l'Okavango",
            text = "Dans quel pays se trouve le célèbre delta de l'Okavango ?",
            options = listOf("Botswana", "Namibie", "Zambie", "Mozambique"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Le delta de l'Okavango est un immense delta intérieur situé au Botswana. Ses eaux ne rejoignent jamais la mer mais se perdent dans le désert du Kalahari.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_caucase_mer",
            title = "Le Caucase",
            text = "La chaîne du Caucase s'étend entre quelles deux mers ?",
            options = listOf("Mer Noire et mer Caspienne", "Mer Adriatique et mer Égée", "Mer Baltique et mer du Nord", "Mer Rouge et mer Méditerranée"),
            correctIndex = 0,
            rating = 1700,
            explanation = "Le Caucase forme une frontière naturelle entre l'Europe et l'Asie et s'étend entre la mer Noire et la mer Caspienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_maputo_capitale",
            title = "Capitale du Mozambique",
            text = "Quelle est la capitale du Mozambique ?",
            options = listOf("Maputo", "Luanda", "Harare", "Lusaka"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Maputo est la capitale et la plus grande ville du Mozambique. Elle est située sur la côte de l'océan Indien.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_yukon_territoire",
            title = "Le Yukon",
            text = "Le Yukon est un territoire de quel pays ?",
            options = listOf("Russie", "Canada", "États-Unis", "Norvège"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le Yukon est l'un des trois territoires du Canada. Il est célèbre pour la ruée vers l'or du Klondike à la fin du XIXe siècle.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mer_aral",
            title = "La mer d'Aral",
            text = "La mer d'Aral est devenue célèbre pour quel phénomène ?",
            options = listOf("Son expansion rapide", "Son assèchement spectaculaire", "Son activité volcanique", "La découverte de pétrole"),
            correctIndex = 1,
            rating = 1450,
            explanation = "La mer d'Aral a perdu l'essentiel de sa superficie depuis les années 1960 à cause des détournements de fleuves pour l'irrigation.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_himalaya_huitmille",
            title = "Les sommets de plus de 8000 m",
            text = "Combien de sommets de plus de 8 000 mètres compte la planète ?",
            options = listOf("10", "12", "14", "16"),
            correctIndex = 2,
            rating = 1750,
            explanation = "La Terre compte 14 sommets dépassant les 8 000 mètres d'altitude. Ils sont tous situés dans l'Himalaya ou le Karakoram.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_saint_laurent_fleuve",
            title = "Le Saint-Laurent",
            text = "Le fleuve Saint-Laurent relie les Grands Lacs à quel océan ?",
            options = listOf("Pacifique", "Atlantique", "Arctique", "Indien"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Le Saint-Laurent constitue une importante voie navigable reliant les Grands Lacs nord-américains à l'océan Atlantique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_micronesie_capitale",
            title = "Capitale des États fédérés de Micronésie",
            text = "Quelle est la capitale des États fédérés de Micronésie ?",
            options = listOf("Majuro", "Palikir", "Yaren", "Tarawa"),
            correctIndex = 1,
            rating = 1800,
            explanation = "Palikir est la capitale des États fédérés de Micronésie, un État insulaire du Pacifique occidental composé de centaines d'îles.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_oural_frontiere",
            title = "Monts Oural",
            text = "Les monts Oural sont traditionnellement considérés comme une frontière entre quels deux continents ?",
            options = listOf("Europe et Afrique", "Asie et Océanie", "Europe et Asie", "Asie et Amérique"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Les monts Oural, situés en Russie, sont généralement considérés comme l'une des limites géographiques entre l'Europe et l'Asie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_cyrus_grand_empire",
            title = "Fondateur de l'Empire perse",
            text = "Quel souverain est considéré comme le fondateur de l'Empire perse achéménide ?",
            options = listOf("Darius Ier", "Xerxès Ier", "Cyrus le Grand", "Artaxerxès Ier"),
            correctIndex = 2,
            rating = 1400,
            explanation = "Cyrus le Grand fonda l'Empire achéménide au VIe siècle av. J.-C. Son empire s'étendait de l'Asie centrale à la Méditerranée.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_pompei_volcan",
            title = "Destruction de Pompéi",
            text = "Quel volcan est responsable de la destruction de Pompéi en 79 apr. J.-C. ?",
            options = listOf("Etna", "Stromboli", "Vésuve", "Vulcano"),
            correctIndex = 2,
            rating = 850,
            explanation = "L'éruption du Vésuve en 79 ensevelit Pompéi sous les cendres, permettant une conservation exceptionnelle de la ville antique.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_clovis_bapteme_ville",
            title = "Baptême de Clovis",
            text = "Dans quelle ville Clovis fut-il baptisé selon la tradition ?",
            options = listOf("Paris", "Lyon", "Tours", "Reims"),
            correctIndex = 3,
            rating = 1200,
            explanation = "Le baptême de Clovis à Reims vers l'an 496 constitue un événement majeur de l'histoire des Francs et du christianisme en Gaule.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_magna_grece",
            title = "Grande-Grèce",
            text = "Comment appelait-on les colonies grecques établies dans le sud de l'Italie durant l'Antiquité ?",
            options = listOf("Hellade", "Grande-Grèce", "Ionie", "Péloponnèse"),
            correctIndex = 1,
            rating = 1650,
            explanation = "La Grande-Grèce désigne l'ensemble des colonies fondées par les Grecs dans le sud de la péninsule italienne à partir du VIIIe siècle av. J.-C.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_leonard_vinci_patron",
            title = "Dernière résidence de Léonard",
            text = "Quel roi de France accueillit Léonard de Vinci à la fin de sa vie ?",
            options = listOf("Louis XII", "François Ier", "Henri II", "Charles VIII"),
            correctIndex = 1,
            rating = 1300,
            explanation = "François Ier invita Léonard de Vinci à s'installer au Clos Lucé près d'Amboise, où il mourut en 1519.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_boston_massacre",
            title = "Massacre de Boston",
            text = "Le massacre de Boston de 1770 opposa des colons américains à quels soldats ?",
            options = listOf("Français", "Espagnols", "Britanniques", "Prussiens"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Le massacre de Boston renforça les tensions entre les colonies américaines et la Grande-Bretagne avant la guerre d'indépendance.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_congres_vienne",
            title = "Congrès de Vienne",
            text = "Quel événement majeur suivit immédiatement les guerres napoléoniennes en Europe ?",
            options = listOf("Le Congrès de Vienne", "La guerre de Crimée", "La Commune de Paris", "Le Printemps des peuples"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Le Congrès de Vienne (1814-1815) redessina la carte de l'Europe après la chute de Napoléon et chercha à rétablir un équilibre des puissances.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_transcontinental_railroad",
            title = "Premier chemin de fer transcontinental",
            text = "Dans quel pays fut achevé le premier chemin de fer transcontinental en 1869 ?",
            options = listOf("Russie", "Canada", "États-Unis", "Australie"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Le premier chemin de fer transcontinental américain fut achevé à Promontory Summit dans l'Utah, reliant l'est et l'ouest du pays.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_dreyfus_grade",
            title = "Affaire Dreyfus",
            text = "Quel était le grade d'Alfred Dreyfus lorsqu'il fut condamné en 1894 ?",
            options = listOf("Capitaine", "Commandant", "Colonel", "Lieutenant"),
            correctIndex = 0,
            rating = 1500,
            explanation = "Le capitaine Alfred Dreyfus fut accusé à tort de trahison dans une affaire qui divisa profondément la société française.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_blocus_berlin",
            title = "Blocus de Berlin",
            text = "En quelle année débuta le blocus de Berlin par l'Union soviétique ?",
            options = listOf("1945", "1948", "1953", "1961"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Le blocus de Berlin débuta en 1948. Les Alliés occidentaux organisèrent alors un immense pont aérien pour ravitailler Berlin-Ouest.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_sparte_thermopyles",
            title = "Les Thermopyles",
            text = "Quel roi spartiate commandait les Grecs lors de la bataille des Thermopyles ?",
            options = listOf("Léonidas", "Périclès", "Alexandre", "Agésilas"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Léonidas Ier dirigeait les Spartiates lors de la bataille des Thermopyles en 480 av. J.-C. face à l'armée perse de Xerxès.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_hanse_ligue",
            title = "La Ligue hanséatique",
            text = "La Ligue hanséatique était principalement une alliance de quoi ?",
            options = listOf("Royaumes", "Universités", "Villes marchandes", "Ordres religieux"),
            correctIndex = 2,
            rating = 1600,
            explanation = "La Ligue hanséatique regroupait des villes commerçantes du nord de l'Europe afin de protéger et développer leurs échanges commerciaux.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_cortes_empire",
            title = "Conquête du Mexique",
            text = "Quel empire Hernán Cortés a-t-il conquis au XVIe siècle ?",
            options = listOf("Inca", "Maya", "Aztèque", "Muisca"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Hernán Cortés mena la conquête de l'Empire aztèque à partir de 1519 et s'empara de sa capitale Tenochtitlan en 1521.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_lisbonne_tremblement",
            title = "Séisme de Lisbonne",
            text = "En quelle année le grand tremblement de terre de Lisbonne a-t-il eu lieu ?",
            options = listOf("1666", "1755", "1812", "1883"),
            correctIndex = 1,
            rating = 1700,
            explanation = "Le séisme de Lisbonne de 1755 fut suivi d'un tsunami et d'incendies dévastateurs. Il marqua profondément la pensée européenne des Lumières.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_waterloo_pays",
            title = "Le champ de Waterloo",
            text = "Dans quel pays actuel se situe le champ de bataille de Waterloo ?",
            options = listOf("France", "Belgique", "Pays-Bas", "Luxembourg"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La bataille de Waterloo eut lieu en 1815 sur le territoire de l'actuelle Belgique et marqua la défaite définitive de Napoléon.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_telegramme_zimmermann",
            title = "Télégramme Zimmermann",
            text = "Le télégramme Zimmermann contribua à l'entrée en guerre de quel pays en 1917 ?",
            options = listOf("Canada", "Italie", "États-Unis", "Japon"),
            correctIndex = 2,
            rating = 1750,
            explanation = "Le télégramme Zimmermann était un message allemand proposant une alliance au Mexique contre les États-Unis. Sa divulgation favorisa l'entrée en guerre américaine.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_suffragettes_pays",
            title = "Les suffragettes",
            text = "Le mouvement des suffragettes est principalement né dans quel pays ?",
            options = listOf("France", "Royaume-Uni", "États-Unis", "Allemagne"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Les suffragettes britanniques menèrent une campagne active au début du XXe siècle pour obtenir le droit de vote des femmes.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_normandie_operation",
            title = "Nom du débarquement",
            text = "Quel nom de code portait l'opération alliée du débarquement en Normandie ?",
            options = listOf("Torch", "Market Garden", "Overlord", "Husky"),
            correctIndex = 2,
            rating = 1050,
            explanation = "L'opération Overlord débuta le 6 juin 1944 avec le débarquement allié sur les plages de Normandie.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_apartheid_fin",
            title = "Fin de l'apartheid",
            text = "Dans quel pays le régime de l'apartheid a-t-il pris fin au début des années 1990 ?",
            options = listOf("Namibie", "Zimbabwe", "Afrique du Sud", "Botswana"),
            correctIndex = 2,
            rating = 950,
            explanation = "L'apartheid était un système de ségrégation raciale institutionnalisé en Afrique du Sud. Il fut progressivement démantelé entre 1990 et 1994.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_spoutnik_chien",
            title = "Laïka dans l'espace",
            text = "Comment s'appelait la chienne envoyée dans l'espace par l'URSS en 1957 ?",
            options = listOf("Belka", "Laïka", "Strelka", "Zvezdochka"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Laïka fut le premier être vivant à être placé en orbite autour de la Terre à bord de Spoutnik 2 en novembre 1957.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_corail_animal",
            title = "Nature du corail",
            text = "Les coraux qui construisent les récifs sont-ils des plantes ou des animaux ?",
            options = listOf("Des plantes", "Des animaux", "Des champignons", "Des algues"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Les coraux sont des animaux marins appartenant au groupe des cnidaires. Ils vivent souvent en symbiose avec des algues microscopiques qui leur fournissent une partie de leur énergie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_mercure_metal_liquide",
            title = "Métal liquide",
            text = "Quel métal est liquide à température ambiante ?",
            options = listOf("Aluminium", "Mercure", "Argent", "Platine"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le mercure est l'un des rares métaux liquides à température ambiante. Il a longtemps été utilisé dans les thermomètres avant d'être progressivement abandonné pour des raisons de toxicité.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_orque_famille",
            title = "Famille de l'orque",
            text = "L'orque appartient à quelle famille animale ?",
            options = listOf("Les requins", "Les dauphins", "Les phoques", "Les morses"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Malgré son surnom d'« épaulard », l'orque appartient à la famille des dauphins. C'est le plus grand représentant de cette famille.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_planete_plus_lune",
            title = "Championne des lunes",
            text = "Quelle planète possède actuellement le plus grand nombre de lunes connues ?",
            options = listOf("Jupiter", "Saturne", "Uranus", "Neptune"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Les découvertes récentes ont permis à Saturne de dépasser Jupiter en nombre de satellites naturels officiellement recensés.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_adaptation_mimetisme",
            title = "Le mimétisme",
            text = "Comment appelle-t-on la capacité d'un organisme à imiter l'apparence d'une autre espèce ?",
            options = listOf("Hybridation", "Photosynthèse", "Mimétisme", "Mutation"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le mimétisme est une stratégie évolutive permettant à certaines espèces de se protéger ou de mieux capturer leurs proies.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_brouillard_formation",
            title = "Formation du brouillard",
            text = "Le brouillard est constitué principalement de quoi ?",
            options = listOf("Cristaux de glace", "Poussières", "Gouttelettes d'eau en suspension", "Gaz carbonique"),
            correctIndex = 2,
            rating = 800,
            explanation = "Le brouillard est un nuage au contact du sol composé de minuscules gouttelettes d'eau en suspension dans l'air.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_koala_regime",
            title = "Alimentation du koala",
            text = "De quoi se nourrit principalement le koala ?",
            options = listOf("Bambou", "Feuilles d'eucalyptus", "Fruits tropicaux", "Insectes"),
            correctIndex = 1,
            rating = 750,
            explanation = "Le koala se nourrit presque exclusivement de feuilles d'eucalyptus, dont peu d'animaux peuvent digérer les substances toxiques.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_venus_temperature",
            title = "La planète la plus chaude",
            text = "Quelle est la planète la plus chaude du système solaire ?",
            options = listOf("Mercure", "Vénus", "Mars", "Jupiter"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Bien que Mercure soit plus proche du Soleil, Vénus est plus chaude à cause de son intense effet de serre qui piège la chaleur.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_ecosysteme_biodiversite",
            title = "Biodiversité",
            text = "Que désigne principalement le terme biodiversité ?",
            options = listOf("La diversité des climats", "La diversité du vivant", "La diversité des océans", "La diversité des roches"),
            correctIndex = 1,
            rating = 700,
            explanation = "La biodiversité englobe la diversité des espèces, des gènes et des écosystèmes présents sur Terre.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_tsunami_origine",
            title = "Origine d'un tsunami",
            text = "Quelle est la cause la plus fréquente des tsunamis ?",
            options = listOf("Les ouragans", "Les séismes sous-marins", "Les marées", "Les éruptions solaires"),
            correctIndex = 1,
            rating = 950,
            explanation = "La plupart des tsunamis sont provoqués par des séismes sous-marins qui déplacent brutalement d'importantes masses d'eau.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_pangolin_ecaille",
            title = "Les écailles du pangolin",
            text = "Les écailles du pangolin sont principalement constituées de quelle substance ?",
            options = listOf("Calcium", "Kératine", "Silice", "Chitine"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Les écailles du pangolin sont composées de kératine, la même protéine que celle qui constitue les ongles, les cheveux et les cornes de nombreux animaux.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_venus_jour_annee",
            title = "Jour plus long qu'une année",
            text = "Sur quelle planète un jour dure-t-il plus longtemps qu'une année ?",
            options = listOf("Mercure", "Mars", "Vénus", "Neptune"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Vénus met environ 243 jours terrestres pour tourner sur elle-même, mais seulement 225 jours pour faire le tour du Soleil.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_bois_flotte",
            title = "Pourquoi le bois flotte",
            text = "Pourquoi la plupart des morceaux de bois flottent-ils sur l'eau ?",
            options = listOf("Ils contiennent du sel", "Ils sont imperméables", "Ils sont moins denses que l'eau", "Ils produisent de l'air"),
            correctIndex = 2,
            rating = 750,
            explanation = "La densité du bois est généralement inférieure à celle de l'eau, ce qui lui permet de flotter grâce à la poussée d'Archimède.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_mangrove_ecosysteme",
            title = "Les mangroves",
            text = "Dans quel environnement trouve-t-on principalement les mangroves ?",
            options = listOf("Déserts", "Zones côtières tropicales", "Toundras", "Haute montagne"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Les mangroves sont des écosystèmes côtiers tropicaux composés d'arbres capables de vivre dans l'eau saumâtre.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_salamandre_amphibien",
            title = "La salamandre",
            text = "À quel groupe d'animaux appartient la salamandre ?",
            options = listOf("Reptiles", "Poissons", "Amphibiens", "Mammifères"),
            correctIndex = 2,
            rating = 850,
            explanation = "Les salamandres sont des amphibiens. Comme les grenouilles, elles passent généralement une partie de leur vie dans l'eau.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_phobos_planete",
            title = "Phobos",
            text = "Phobos est une lune de quelle planète ?",
            options = listOf("Mars", "Jupiter", "Saturne", "Mercure"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Phobos et Deimos sont les deux petites lunes naturelles de Mars. Phobos se rapproche lentement de la planète et finira probablement par se désintégrer.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_azote_atmosphere",
            title = "Gaz principal de l'atmosphère",
            text = "Quel gaz est le plus abondant dans l'atmosphère terrestre ?",
            options = listOf("Oxygène", "Dioxyde de carbone", "Argon", "Azote"),
            correctIndex = 3,
            rating = 800,
            explanation = "L'azote représente environ 78 % de l'atmosphère terrestre, contre environ 21 % pour l'oxygène.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_lave_basaltique",
            title = "Le basalte",
            text = "Le basalte est une roche généralement associée à quel phénomène ?",
            options = listOf("Métamorphisme", "Volcanisme", "Érosion glaciaire", "Sédimentation marine"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Le basalte est une roche volcanique très répandue, formée par le refroidissement rapide de laves fluides.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_bioluminescence",
            title = "La bioluminescence",
            text = "Que désigne le phénomène de bioluminescence ?",
            options = listOf("La capacité à produire de la lumière", "La capacité à changer de couleur", "La capacité à détecter les ultrasons", "La capacité à vivre sans oxygène"),
            correctIndex = 0,
            rating = 1100,
            explanation = "La bioluminescence est la production de lumière par un organisme vivant grâce à une réaction chimique. On la rencontre notamment chez certaines méduses et lucioles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_glacier_eau_douce",
            title = "Réserve d'eau douce",
            text = "Où se trouve la plus grande partie de l'eau douce de la planète ?",
            options = listOf("Dans les rivières", "Dans les lacs", "Dans les glaciers et calottes polaires", "Dans l'atmosphère"),
            correctIndex = 2,
            rating = 1300,
            explanation = "La majorité de l'eau douce terrestre est stockée dans les glaciers, les calottes polaires et les nappes souterraines profondes.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_vermeer_fille_perle",
            title = "La Jeune Fille à la perle",
            text = "Quel peintre a réalisé « La Jeune Fille à la perle » ?",
            options = listOf("Rembrandt", "Johannes Vermeer", "Frans Hals", "Jan Steen"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Johannes Vermeer peignit cette œuvre vers 1665. Souvent surnommée la « Joconde du Nord », elle est conservée au Mauritshuis de La Haye.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_haiku_origine",
            title = "Origine du haïku",
            text = "Le haïku est une forme poétique originaire de quel pays ?",
            options = listOf("Chine", "Corée", "Japon", "Vietnam"),
            correctIndex = 2,
            rating = 950,
            explanation = "Le haïku est une forme poétique japonaise très brève, traditionnellement composée de 17 syllabes réparties en trois vers.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_caravage_clair_obscur",
            title = "Maître du clair-obscur",
            text = "Quel peintre italien est célèbre pour son utilisation spectaculaire du clair-obscur ?",
            options = listOf("Raphaël", "Le Caravage", "Titien", "Le Tintoret"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Le Caravage révolutionna la peinture au tournant du XVIIe siècle grâce à ses contrastes lumineux saisissants et son réalisme.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_odyssee_auteur",
            title = "Auteur de l'Odyssée",
            text = "À quel auteur antique attribue-t-on traditionnellement l'Odyssée ?",
            options = listOf("Homère", "Sophocle", "Hésiode", "Euripide"),
            correctIndex = 0,
            rating = 850,
            explanation = "L'Odyssée raconte le long retour d'Ulysse après la guerre de Troie. Elle est traditionnellement attribuée à Homère.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_opera_carmen_ville",
            title = "Cadre de Carmen",
            text = "Dans quelle ville se déroule principalement l'opéra Carmen ?",
            options = listOf("Madrid", "Barcelone", "Séville", "Valence"),
            correctIndex = 2,
            rating = 1350,
            explanation = "L'action de Carmen se déroule principalement à Séville, en Andalousie, dans le sud de l'Espagne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_monet_nympheas",
            title = "Les Nymphéas",
            text = "Dans quelle localité Claude Monet a-t-il créé les jardins qui inspirèrent les Nymphéas ?",
            options = listOf("Giverny", "Honfleur", "Étretat", "Barbizon"),
            correctIndex = 0,
            rating = 1150,
            explanation = "Claude Monet aménagea ses célèbres jardins à Giverny. Les bassins et les nymphéas devinrent une source d'inspiration majeure pour ses dernières œuvres.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_boccace_decameron",
            title = "Le Décaméron",
            text = "Qui a écrit le recueil de nouvelles intitulé « Le Décaméron » ?",
            options = listOf("Dante", "Pétrarque", "Boccace", "Machiavel"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Giovanni Boccace écrivit Le Décaméron au XIVe siècle. L'œuvre rassemble cent récits racontés par de jeunes Florentins fuyant la peste.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_gershwin_rhapsody",
            title = "Rhapsody in Blue",
            text = "Quel compositeur a créé « Rhapsody in Blue » ?",
            options = listOf("George Gershwin", "Aaron Copland", "Duke Ellington", "Leonard Bernstein"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Créée en 1924, Rhapsody in Blue mêle musique classique et jazz. Elle est l'une des œuvres les plus célèbres de George Gershwin.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_ukiyoe_estampe",
            title = "Les estampes ukiyo-e",
            text = "Les estampes ukiyo-e sont associées à quel pays ?",
            options = listOf("Chine", "Japon", "Corée", "Thaïlande"),
            correctIndex = 1,
            rating = 1250,
            explanation = "L'ukiyo-e est un genre artistique japonais qui connut son apogée entre le XVIIe et le XIXe siècle, avec des artistes comme Hokusai et Hiroshige.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_moby_dick_auteur",
            title = "Auteur de Moby Dick",
            text = "Qui a écrit le roman « Moby Dick » ?",
            options = listOf("Mark Twain", "Nathaniel Hawthorne", "Herman Melville", "Jack London"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Publié en 1851, Moby Dick raconte la quête obsessionnelle du capitaine Achab contre une gigantesque baleine blanche.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_bauhaus_fondation",
            title = "L'école du Bauhaus",
            text = "Dans quel pays l'école du Bauhaus a-t-elle été fondée en 1919 ?",
            options = listOf("Autriche", "Allemagne", "Suisse", "Pays-Bas"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Fondée par Walter Gropius à Weimar, en Allemagne, l'école du Bauhaus a profondément influencé l'architecture, le design et les arts appliqués du XXe siècle.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_hokusai_vague",
            title = "La Grande Vague",
            text = "Quel artiste a réalisé l'estampe « La Grande Vague de Kanagawa » ?",
            options = listOf("Hiroshige", "Utamaro", "Hokusai", "Sesshū"),
            correctIndex = 2,
            rating = 950,
            explanation = "Katsushika Hokusai réalisa cette célèbre estampe vers 1831. Elle est devenue l'une des œuvres japonaises les plus reconnues dans le monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_cyrano_auteur",
            title = "Auteur de Cyrano",
            text = "Qui a écrit la pièce « Cyrano de Bergerac » ?",
            options = listOf("Edmond Rostand", "Alfred de Musset", "Jean Anouilh", "Paul Claudel"),
            correctIndex = 0,
            rating = 900,
            explanation = "Edmond Rostand publia Cyrano de Bergerac en 1897. La pièce est célèbre pour son panache et ses tirades en vers.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_kandinsky_abstraction",
            title = "Pionnier de l'abstraction",
            text = "Quel peintre est considéré comme l'un des pionniers de l'art abstrait ?",
            options = listOf("Wassily Kandinsky", "Edgar Degas", "Gustave Courbet", "Paul Cézanne"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Wassily Kandinsky est l'une des figures majeures de la peinture abstraite du début du XXe siècle.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_en_attendant_godot",
            title = "En attendant Godot",
            text = "Qui a écrit la pièce « En attendant Godot » ?",
            options = listOf("Jean-Paul Sartre", "Eugène Ionesco", "Samuel Beckett", "Arthur Adamov"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Publiée en 1952, cette pièce de Samuel Beckett est l'une des œuvres majeures du théâtre de l'absurde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_flamenco_origine",
            title = "Origine du flamenco",
            text = "Dans quelle région d'Espagne le flamenco est-il né ?",
            options = listOf("Catalogne", "Andalousie", "Galice", "Castille"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le flamenco est né en Andalousie, où il s'est développé à partir d'influences gitanes, arabes, juives et espagnoles.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_brunelleschi_dome",
            title = "Dôme de Florence",
            text = "Quel architecte a conçu le célèbre dôme de la cathédrale de Florence ?",
            options = listOf("Donatello", "Brunelleschi", "Alberti", "Michel-Ange"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Filippo Brunelleschi réalisa au XVe siècle le remarquable dôme de Santa Maria del Fiore, considéré comme un chef-d'œuvre de la Renaissance.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_poeme_corbeau",
            title = "Le Corbeau",
            text = "Quel écrivain a composé le célèbre poème « Le Corbeau » ?",
            options = listOf("Walt Whitman", "Emily Dickinson", "Edgar Allan Poe", "Henry Longfellow"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Publié en 1845, Le Corbeau est l'un des poèmes les plus célèbres d'Edgar Allan Poe et un classique de la littérature américaine.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_vitruve_homme",
            title = "L'Homme de Vitruve",
            text = "Quel artiste a réalisé le dessin connu sous le nom de « L'Homme de Vitruve » ?",
            options = listOf("Raphaël", "Michel-Ange", "Léonard de Vinci", "Dürer"),
            correctIndex = 2,
            rating = 850,
            explanation = "L'Homme de Vitruve est un dessin de Léonard de Vinci illustrant les proportions idéales du corps humain selon l'architecte romain Vitruve.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_opera_pekin",
            title = "L'opéra de Pékin",
            text = "L'opéra de Pékin est une forme traditionnelle de spectacle originaire de quel pays ?",
            options = listOf("Corée du Sud", "Japon", "Mongolie", "Chine"),
            correctIndex = 3,
            rating = 1400,
            explanation = "L'opéra de Pékin combine chant, théâtre, danse, acrobaties et costumes élaborés. Il constitue l'une des formes les plus célèbres des arts de la scène chinois.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_tir_arc_distance_olympique",
            title = "Distance olympique au tir à l'arc",
            text = "À quelle distance les archers tirent-ils lors de l'épreuve olympique individuelle ?",
            options = listOf("30 mètres", "50 mètres", "70 mètres", "90 mètres"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Lors des compétitions olympiques de tir à l'arc, les archers tirent à 70 mètres sur une cible de 122 cm de diamètre.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_f1_drapeau_damier",
            title = "Le drapeau à damier",
            text = "Que signifie le drapeau à damier en Formule 1 ?",
            options = listOf("Neutralisation de la course", "Départ de la course", "Fin de la course", "Pénalité immédiate"),
            correctIndex = 2,
            rating = 750,
            explanation = "Le drapeau à damier est agité pour signaler la fin de la course et l'arrivée des pilotes.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_lutte_greco_romaine",
            title = "Particularité de la lutte gréco-romaine",
            text = "Quelle action est interdite en lutte gréco-romaine ?",
            options = listOf("Les projections", "Les prises au-dessus de la taille", "Les attaques des jambes", "Les immobilisations"),
            correctIndex = 2,
            rating = 1400,
            explanation = "En lutte gréco-romaine, les prises et attaques impliquant les jambes sont interdites. Les actions doivent se concentrer sur le haut du corps.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_volleyball_rotation",
            title = "Rotation au volley-ball",
            text = "Quand une équipe effectue-t-elle une rotation au volley-ball ?",
            options = listOf("Après chaque point", "Lorsqu'elle récupère le service", "À chaque temps mort", "À chaque set"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Les joueurs tournent d'une position dans le sens des aiguilles d'une montre lorsque leur équipe récupère le droit de servir.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_moto_gp_cylindree",
            title = "Nom de la catégorie reine",
            text = "Quelle est la catégorie principale du championnat du monde de vitesse moto ?",
            options = listOf("Moto2", "Superbike", "MotoGP", "MotoE"),
            correctIndex = 2,
            rating = 850,
            explanation = "MotoGP représente la catégorie reine des courses de vitesse moto et regroupe les prototypes les plus performants.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_ski_fond_style_libre",
            title = "Technique du skating",
            text = "Dans quel sport utilise-t-on la technique du skating ?",
            options = listOf("Ski alpin", "Biathlon uniquement", "Ski de fond", "Saut à ski"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Le skating est une technique du ski de fond inspirée du patinage, permettant d'atteindre des vitesses élevées.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_baseball_home_run",
            title = "Le home run",
            text = "Au baseball, qu'est-ce qu'un home run ?",
            options = listOf("Un lancer rapide", "Un retrait du batteur", "Un coup permettant généralement de faire le tour des bases", "Une manche parfaite"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Un home run est réalisé lorsque le frappeur envoie la balle hors du terrain réglementaire ou réussit à parcourir toutes les bases sans être éliminé.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_sumo_cercle",
            title = "Le dohyo",
            text = "Comment s'appelle le cercle dans lequel se déroule un combat de sumo ?",
            options = listOf("Tatami", "Dohyo", "Kokugikan", "Yokozuna"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Le dohyo est l'aire circulaire en terre battue où s'affrontent les lutteurs de sumo.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_padel_origine",
            title = "Origine du padel",
            text = "Dans quel pays le padel moderne a-t-il été créé dans les années 1960 ?",
            options = listOf("Espagne", "Argentine", "Mexique", "Portugal"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Le padel a été inventé au Mexique par Enrique Corcuera avant de connaître un immense succès en Espagne et en Amérique latine.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_ironman_distance_natation",
            title = "Natation de l'Ironman",
            text = "Quelle distance de natation compose un triathlon Ironman complet ?",
            options = listOf("1,5 km", "2,4 km", "3,8 km", "5 km"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Un Ironman comprend 3,8 km de natation, 180 km de vélo puis un marathon de 42,195 km.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_aviron_couple_pointe",
            title = "Couple ou pointe",
            text = "En aviron, quelle est la différence entre le couple et la pointe ?",
            options = listOf("La longueur du bateau", "Le nombre de rameurs", "Le nombre de rames utilisées par chaque rameur", "Le type d'eau utilisée"),
            correctIndex = 2,
            rating = 1650,
            explanation = "En couple, chaque rameur utilise deux rames. En pointe, chaque rameur n'utilise qu'une seule rame, placée à bâbord ou à tribord.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_halterophilie_epaule_jetee",
            title = "L'épaulé-jeté",
            text = "L'épaulé-jeté est un mouvement pratiqué dans quel sport ?",
            options = listOf("CrossFit", "Lutte", "Haltérophilie", "Gymnastique"),
            correctIndex = 2,
            rating = 900,
            explanation = "L'haltérophilie olympique comprend deux mouvements : l'arraché et l'épaulé-jeté.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_cyclisme_monospace",
            title = "Le contre-la-montre",
            text = "Dans une course cycliste contre-la-montre individuelle, quel est l'objectif principal ?",
            options = listOf("Gagner des sprints intermédiaires", "Rouler seul le plus vite possible", "Rester dans le peloton", "Éliminer des adversaires"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le contre-la-montre est une épreuve où les coureurs partent séparément et cherchent à réaliser le meilleur temps sur un parcours donné.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_bmx_signification",
            title = "Signification de BMX",
            text = "Que signifient les lettres BMX ?",
            options = listOf("Bike Moto Xtreme", "Bicycle Moto Cross", "Bike Maximum Cross", "Bicycle Mountain X"),
            correctIndex = 1,
            rating = 1400,
            explanation = "BMX signifie Bicycle Moto Cross. Cette discipline est née aux États-Unis en s'inspirant du motocross.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_hockey_gazon_surface",
            title = "Hockey sur gazon",
            text = "Avec quel objet les joueurs frappent-ils la balle au hockey sur gazon ?",
            options = listOf("Une crosse", "Une raquette", "Un bâton droit", "Une palette"),
            correctIndex = 0,
            rating = 750,
            explanation = "Le hockey sur gazon se joue avec une crosse recourbée servant à contrôler et frapper la balle.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_flechettes_centre",
            title = "Le bullseye",
            text = "Aux fléchettes, comment appelle-t-on le centre de la cible ?",
            options = listOf("Strike", "Bullseye", "Jackpot", "Target"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le bullseye correspond au centre de la cible. Dans les compétitions, le centre rouge rapporte généralement 50 points.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_pentathlon_moderne_disciplines",
            title = "Pentathlon moderne",
            text = "Combien de disciplines compose le pentathlon moderne ?",
            options = listOf("4", "5", "6", "7"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Le pentathlon moderne comprend cinq disciplines : escrime, natation, équitation (ou son remplaçant moderne selon les évolutions du règlement), tir et course à pied combinés.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_skeleton_position",
            title = "Le skeleton",
            text = "Dans quelle position les athlètes descendent-ils la piste en skeleton ?",
            options = listOf("Sur le dos", "Assis", "Debout", "À plat ventre tête en avant"),
            correctIndex = 3,
            rating = 1250,
            explanation = "En skeleton, les athlètes descendent à très grande vitesse allongés à plat ventre, la tête en avant.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_taekwondo_origine",
            title = "Origine du taekwondo",
            text = "Dans quel pays le taekwondo est-il né ?",
            options = listOf("Japon", "Chine", "Corée du Sud", "Thaïlande"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le taekwondo est un art martial coréen devenu sport olympique. Il est particulièrement connu pour ses techniques de coups de pied.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_echecs_roque",
            title = "Le roque aux échecs",
            text = "Quelle pièce est déplacée en même temps que le roi lors d'un roque ?",
            options = listOf("La dame", "Un cavalier", "Une tour", "Un fou"),
            correctIndex = 2,
            rating = 900,
            explanation = "Le roque est un coup spécial des échecs où le roi et une tour sont déplacés simultanément afin de mieux protéger le roi.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_matrix_pilule",
            title = "La pilule de Matrix",
            text = "Dans Matrix, quelle couleur de pilule permet à Neo de découvrir la vérité ?",
            options = listOf("Bleue", "Rouge", "Verte", "Jaune"),
            correctIndex = 1,
            rating = 850,
            explanation = "Morpheus propose à Neo le choix entre la pilule bleue, qui lui permet de rester dans l'illusion, et la pilule rouge, qui lui révèle la réalité.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_nintendo_triforce",
            title = "La Triforce",
            text = "Dans la série The Legend of Zelda, combien de parties composent la Triforce ?",
            options = listOf("2", "3", "4", "5"),
            correctIndex = 1,
            rating = 1000,
            explanation = "La Triforce est composée de trois fragments représentant la Force, la Sagesse et le Courage.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_inception_totem",
            title = "Le totem d'Inception",
            text = "Quel objet Cobb utilise-t-il comme totem dans le film Inception ?",
            options = listOf("Une pièce", "Une montre", "Une toupie", "Un dé"),
            correctIndex = 2,
            rating = 1250,
            explanation = "La toupie permet à Cobb de distinguer les rêves de la réalité. Elle est devenue l'un des symboles du film.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_scooby_doo_chien",
            title = "Nom complet de Scooby-Doo",
            text = "Quel est le nom complet de Scooby-Doo ?",
            options = listOf("Scoobert Doo", "Scooter Doo", "Scooby Rogers", "Scoobius Doo"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Le célèbre chien détective s'appelle officiellement Scoobert Doo, même si ce nom est rarement utilisé dans la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pacman_createur",
            title = "Origine de Pac-Man",
            text = "Dans quel pays le jeu Pac-Man a-t-il été créé ?",
            options = listOf("États-Unis", "Japon", "Corée du Sud", "Taïwan"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Pac-Man a été créé au Japon par Toru Iwatani pour l'entreprise Namco en 1980.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_ghostbusters_voiture",
            title = "Voiture des Ghostbusters",
            text = "Comment est surnommée la célèbre voiture des Ghostbusters ?",
            options = listOf("Ecto-1", "Phantom-1", "Ghostmobile", "Specter"),
            correctIndex = 0,
            rating = 1350,
            explanation = "L'Ecto-1 est l'ambulance transformée utilisée par les chasseurs de fantômes dans la saga Ghostbusters.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pixar_ratatouille_ville",
            title = "Cadre de Ratatouille",
            text = "Dans quelle ville se déroule principalement le film Ratatouille ?",
            options = listOf("Lyon", "Paris", "Marseille", "Bruxelles"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le film Ratatouille de Pixar se déroule à Paris, notamment dans les cuisines d'un grand restaurant inspiré de la gastronomie française.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_doom_annee",
            title = "Révolution du FPS",
            text = "En quelle décennie le jeu Doom a-t-il révolutionné le genre du tir à la première personne ?",
            options = listOf("1970", "1980", "1990", "2000"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Sorti en 1993, Doom a fortement popularisé le genre FPS et marqué l'histoire du jeu vidéo.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_loki_frere",
            title = "Frère de Loki",
            text = "Dans l'univers Marvel, de quel personnage Loki est-il le frère adoptif ?",
            options = listOf("Iron Man", "Thor", "Hulk", "Doctor Strange"),
            correctIndex = 1,
            rating = 750,
            explanation = "Dans la mythologie Marvel inspirée des légendes nordiques, Loki est le frère adoptif de Thor.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_jurassic_moustique",
            title = "ADN des dinosaures",
            text = "Dans Jurassic Park, dans quel animal l'ADN des dinosaures est-il retrouvé ?",
            options = listOf("Araignée", "Scarabée", "Moustique", "Libellule"),
            correctIndex = 2,
            rating = 850,
            explanation = "L'histoire imagine que des moustiques fossilisés dans l'ambre ont conservé du sang de dinosaures permettant d'en extraire leur ADN.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_alien_vaisseau",
            title = "Le Nostromo",
            text = "Comment s'appelle le vaisseau spatial principal dans le film Alien (1979) ?",
            options = listOf("Sulaco", "Nostromo", "Prometheus", "Auriga"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Le Nostromo est le vaisseau commercial à bord duquel l'équipage rencontre le xénomorphe dans le premier film Alien réalisé par Ridley Scott.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_tintin_chien",
            title = "Le chien de Tintin",
            text = "Comment s'appelle le fidèle compagnon canin de Tintin ?",
            options = listOf("Milou", "Idéfix", "Rantanplan", "Kador"),
            correctIndex = 0,
            rating = 700,
            explanation = "Milou accompagne Tintin depuis les premières aventures publiées par Hergé. Son humour et ses réflexions sont devenus emblématiques de la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_street_fighter_hadouken",
            title = "Le Hadouken",
            text = "Quel personnage de Street Fighter est particulièrement associé au coup spécial « Hadouken » ?",
            options = listOf("Guile", "Zangief", "Ryu", "Blanka"),
            correctIndex = 2,
            rating = 950,
            explanation = "Ryu est le personnage le plus emblématique du Hadouken, une technique consistant à projeter une boule d'énergie.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_breaking_bad_metier",
            title = "Profession de Walter White",
            text = "Quel métier exerce Walter White au début de la série Breaking Bad ?",
            options = listOf("Policier", "Professeur de chimie", "Médecin", "Avocat"),
            correctIndex = 1,
            rating = 850,
            explanation = "Walter White est professeur de chimie dans un lycée d'Albuquerque avant que sa vie ne bascule après son diagnostic de cancer.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_disney_genie",
            title = "Le Génie d'Aladdin",
            text = "Dans la version originale du film Aladdin de 1992, quel acteur prête sa voix au Génie ?",
            options = listOf("Tom Hanks", "Robin Williams", "Billy Crystal", "Eddie Murphy"),
            correctIndex = 1,
            rating = 1450,
            explanation = "La prestation de Robin Williams dans le rôle du Génie est considérée comme l'une des plus marquantes de l'histoire de l'animation Disney.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_mario_bowser_espece",
            title = "L'espèce de Bowser",
            text = "Dans l'univers de Mario, à quelle espèce appartient Bowser ?",
            options = listOf("Dragon", "Tortue", "Crocodile", "Dinosaure"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Bowser est le roi des Koopas, une espèce inspirée des tortues. Il est le principal adversaire de Mario depuis les débuts de la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_star_trek_vaisseau",
            title = "Vaisseau de Star Trek",
            text = "Quel est le nom du vaisseau commandé par le capitaine Kirk dans la série originale Star Trek ?",
            options = listOf("Voyager", "Defiant", "Enterprise", "Discovery"),
            correctIndex = 2,
            rating = 1000,
            explanation = "L'USS Enterprise est devenu l'un des vaisseaux spatiaux les plus célèbres de la culture populaire.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_game_of_thrones_trone",
            title = "Le Trône de Fer",
            text = "De quoi est principalement constitué le Trône de Fer dans Game of Thrones ?",
            options = listOf("Lances", "Boucliers", "Épées fondues", "Haches"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Selon la légende, le Trône de Fer a été forgé à partir des épées des ennemis vaincus par Aegon le Conquérant.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_sims_langue",
            title = "La langue des Sims",
            text = "Comment s'appelle la langue fictive parlée dans les jeux Les Sims ?",
            options = listOf("Simlish", "Simian", "Simtong", "Simero"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Le Simlish a été créé pour éviter les problèmes de traduction et permettre aux joueurs du monde entier de comprendre les émotions des personnages.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_back_future_voiture",
            title = "Voiture de Retour vers le futur",
            text = "Quel modèle de voiture sert de machine à voyager dans le temps dans Retour vers le futur ?",
            options = listOf("Ford Mustang", "Chevrolet Camaro", "DeLorean DMC-12", "Pontiac Firebird"),
            correctIndex = 2,
            rating = 900,
            explanation = "La DeLorean DMC-12 est devenue une icône du cinéma grâce à son rôle central dans la trilogie Retour vers le futur.",
            category = Category.DIVERTISSEMENT
        ),
    )

    fun getByCategory(category: Category): List<Question> =
        questions.filter { it.category == category }
}
