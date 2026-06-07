package com.fabien.trivia.data

object QuestionRepository {
    val questions = listOf(
        Question(
            text = "Quelle est la capitale de l'Australie ?",
            options = listOf("Canberra", "Sydney", "Melbourne", "Brisbane"),
            correctIndex = 0,
            rating = 1150,
            explanation = "La capitale de l'Australie est Canberra, et non Sydney comme beaucoup le croient. Canberra a été construite de toutes pièces comme capitale fédérale, inaugurée en 1913, suite au compromis entre Sydney et Melbourne qui se disputaient ce titre. La ville a été conçue par les architectes américains Walter Burley Griffin et Marion Mahony Griffin, lauréats d'un concours international en 1912.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            text = "Qui a peint la Joconde ?",
            options = listOf("Michel-Ange", "Léonard de Vinci", "Raphaël", "Botticelli"),
            correctIndex = 1,
            rating = 800,
            explanation = "La Joconde, ou Mona Lisa, est un tableau peint par Léonard de Vinci entre 1503 et 1519. Il est exposé au musée du Louvre à Paris, protégé derrière une vitre blindée. Le modèle serait Lisa Gherardini, épouse d'un riche marchand florentin. C'est l'œuvre d'art la plus visitée au monde, attirant chaque année plusieurs millions de visiteurs.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            text = "En quelle année a eu lieu la Révolution française ?",
            options = listOf("1776", "1804", "1789", "1815"),
            correctIndex = 2,
            rating = 750,
            explanation = "La Révolution française débuta en 1789 avec la prise de la Bastille le 14 juillet, événement commémoré chaque année comme fête nationale en France. Elle mit fin à la monarchie absolue et aboutit à la Déclaration des droits de l'homme et du citoyen. Cette période bouleversa profondément la société française et influença durablement le monde entier.",
            category = Category.HISTOIRE
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
            text = "Combien de côtés a un hexagone ?",
            options = listOf("6", "5", "7", "8"),
            correctIndex = 0,
            rating = 600,
            explanation = "Un hexagone est un polygone à 6 côtés et 6 angles. La France est d'ailleurs surnommée \"l'Hexagone\" en raison de la forme approximativement hexagonale de son territoire métropolitain. Un hexagone régulier possède tous ses côtés et angles égaux ; la somme de ses angles intérieurs est de 720°. On retrouve cette forme dans les alvéoles construites par les abeilles.",
            category = Category.SCIENCES_ET_NATURE
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
            text = "Quel est l'élément chimique dont le symbole est \"Au\" ?",
            options = listOf("Argent", "Aluminium", "Or", "Azote"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le symbole chimique \"Au\" vient du latin \"aurum\", qui signifie or. L'or est un métal précieux de numéro atomique 79, résistant à la corrosion et à l'oxydation. Utilisé depuis l'Antiquité pour la joaillerie et la monnaie, il est aujourd'hui indispensable en électronique de précision. Chaque smartphone contient de petites quantités d'or dans ses circuits.",
            category = Category.SCIENCES_ET_NATURE
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
            text = "Quelle planète est la plus proche du Soleil ?",
            options = listOf("Mercure", "Vénus", "Mars", "Terre"),
            correctIndex = 0,
            rating = 850,
            explanation = "Mercure est la planète la plus proche du Soleil, à une distance moyenne de 57,9 millions de km. Malgré cela, Mercure n'est pas la planète la plus chaude : c'est Vénus, dont l'épaisse atmosphère génère un fort effet de serre maintenant une température moyenne de 462°C. Mercure connaît quant à elle des extrêmes allant de −180°C la nuit à +430°C le jour.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            text = "Combien de joueurs composent une équipe de football ?",
            options = listOf("9", "11", "13", "10"),
            correctIndex = 1,
            rating = 650,
            explanation = "Une équipe de football est composée de 11 joueurs sur le terrain : 1 gardien de but et 10 joueurs de champ. Le football est le sport le plus populaire au monde avec environ 4 milliards de fans et 265 millions de pratiquants. Les règles modernes du jeu ont été codifiées en Angleterre en 1863 par la Football Association.",
            category = Category.SPORTS
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
            text = "Quel est le fleuve le plus long du monde ?",
            options = listOf("Amazone", "Mississippi", "Yangtsé", "Nil"),
            correctIndex = 3,
            rating = 1200,
            explanation = "Le Nil est traditionnellement considéré comme le fleuve le plus long du monde avec 6 650 km, devant l'Amazone (6 400 km). Cette classification est toutefois sujette à débat selon les critères de mesure utilisés — certaines études récentes accordent la première place à l'Amazone. Le Nil traverse onze pays africains et fut le berceau de la civilisation égyptienne.",
            category = Category.GEOGRAPHIE
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
            text = "Quelle est la monnaie officielle du Japon ?",
            options = listOf("Yuan", "Won", "Yen", "Ringgit"),
            correctIndex = 2,
            rating = 950,
            explanation = "Le yen est la monnaie officielle du Japon depuis 1871. Son symbole est ¥ et son code ISO est JPY. Le mot \"yen\" signifie \"objet rond\" en japonais, en référence aux anciennes pièces de monnaie. Le yen est l'une des trois monnaies les plus échangées au monde, après le dollar américain et l'euro.",
            category = Category.GEOGRAPHIE
        ),

        // Art & Culture
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

        // Histoire
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

        // Sports
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

        // Divertissement
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
    )

    fun getByCategory(category: Category): List<Question> =
        questions.filter { it.category == category }
}