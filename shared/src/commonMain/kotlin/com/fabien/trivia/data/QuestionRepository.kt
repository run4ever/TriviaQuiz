package com.fabien.trivia.data

object QuestionRepository {
    val questions = listOf(
        Question(
            id = "geo_choucroute_alsace",
            title = "Origine de la choucroute",
            text = "De quelle région française la choucroute est-elle la spécialité emblématique ?",
            options = listOf("Alsace", "Bretagne", "Provence", "Savoie"),
            correctIndex = 0,
            rating = 1000,
            explanation = "La choucroute (chou finement émincé puis fermenté) est la spécialité emblématique de l'Alsace, même si la technique de fermentation du chou est bien plus ancienne et venue d'Asie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_lesotho_enclave",
            title = "Pays enclavé dans l'Afrique du Sud",
            text = "Quel pays est entièrement entouré par l'Afrique du Sud ?",
            options = listOf("Lesotho", "Eswatini", "Botswana", "Namibie"),
            correctIndex = 0,
            rating = 1500,
            explanation = "Le Lesotho est l'un des rares pays au monde entièrement enclavé dans un seul autre État : il est totalement entouré par l'Afrique du Sud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_pyrenees_frontiere",
            title = "Frontière France-Espagne",
            text = "Quelle chaîne de montagnes marque la frontière entre la France et l'Espagne ?",
            options = listOf("Les Pyrénées", "Les Alpes", "Le Jura", "Les Vosges"),
            correctIndex = 0,
            rating = 950,
            explanation = "Les Pyrénées forment une frontière naturelle d'environ 430 km entre la France et l'Espagne, de l'océan Atlantique à la mer Méditerranée.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_chine",
            tags = listOf("capitale"),
            title = "Capitale de la Chine",
            text = "Quelle est la capitale de la Chine ?",
            options = listOf("Pékin", "Shanghai", "Hong Kong", "Canton"),
            correctIndex = 0,
            rating = 1100,
            explanation = "La capitale de la Chine est Pékin (Beijing). Shanghai, plus peuplée, est la capitale économique mais pas politique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_inde",
            tags = listOf("capitale"),
            title = "Capitale de l'Inde",
            text = "Quelle est la capitale de l'Inde ?",
            options = listOf("New Delhi", "Bombay", "Calcutta", "Bangalore"),
            correctIndex = 0,
            rating = 1100,
            explanation = "La capitale de l'Inde est New Delhi. Bombay (Mumbai) est la plus grande ville mais n'est pas la capitale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_japon",
            tags = listOf("capitale"),
            title = "Capitale du Japon",
            text = "Quelle est la capitale du Japon ?",
            options = listOf("Tokyo", "Osaka", "Kyoto", "Yokohama"),
            correctIndex = 0,
            rating = 950,
            explanation = "Tokyo est la capitale du Japon depuis 1868, remplaçant Kyoto, l'ancienne capitale impériale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_russie",
            tags = listOf("capitale"),
            title = "Capitale de la Russie",
            text = "Quelle est la capitale de la Russie ?",
            options = listOf("Moscou", "Saint-Pétersbourg", "Novossibirsk", "Kazan"),
            correctIndex = 0,
            rating = 950,
            explanation = "Moscou est la capitale de la Russie. Saint-Pétersbourg, ancienne capitale impériale, en est la deuxième ville.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_indonesie",
            tags = listOf("capitale"),
            title = "Capitale de l'Indonésie",
            text = "Quelle est la capitale de l'Indonésie ?",
            options = listOf("Jakarta", "Surabaya", "Bandung", "Medan"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Jakarta est la capitale de l'Indonésie. Le pays construit toutefois une nouvelle capitale, Nusantara, sur l'île de Bornéo.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_royaume_uni",
            tags = listOf("capitale"),
            title = "Capitale du Royaume-Uni",
            text = "Quelle est la capitale du Royaume-Uni ?",
            options = listOf("Londres", "Manchester", "Édimbourg", "Birmingham"),
            correctIndex = 0,
            rating = 900,
            explanation = "Londres, traversée par la Tamise, est la capitale du Royaume-Uni.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_mexique",
            tags = listOf("capitale"),
            title = "Capitale du Mexique",
            text = "Quelle est la capitale du Mexique ?",
            options = listOf("Mexico", "Guadalajara", "Monterrey", "Cancún"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Mexico, bâtie sur le site de l'ancienne Tenochtitlan aztèque, est la capitale du Mexique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_bangladesh",
            tags = listOf("capitale"),
            title = "Capitale du Bangladesh",
            text = "Quelle est la capitale du Bangladesh ?",
            options = listOf("Dacca", "Chittagong", "Khulna", "Rajshahi"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Dacca (Dhaka) est la capitale du Bangladesh, l'une des villes les plus densément peuplées du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_iran",
            tags = listOf("capitale"),
            title = "Capitale de l'Iran",
            text = "Quelle est la capitale de l'Iran ?",
            options = listOf("Téhéran", "Ispahan", "Chiraz", "Tabriz"),
            correctIndex = 0,
            rating = 1150,
            explanation = "Téhéran est la capitale de l'Iran depuis la fin du XVIIIe siècle.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_thailande",
            tags = listOf("capitale"),
            title = "Capitale de la Thaïlande",
            text = "Quelle est la capitale de la Thaïlande ?",
            options = listOf("Bangkok", "Chiang Mai", "Phuket", "Pattaya"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Bangkok est la capitale de la Thaïlande ; son nom cérémoniel thaï est l'un des plus longs du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_colombie",
            tags = listOf("capitale"),
            title = "Capitale de la Colombie",
            text = "Quelle est la capitale de la Colombie ?",
            options = listOf("Bogota", "Medellín", "Cali", "Carthagène"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Bogota, perchée à plus de 2 600 m d'altitude dans les Andes, est la capitale de la Colombie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_irak",
            tags = listOf("capitale"),
            title = "Capitale de l'Irak",
            text = "Quelle est la capitale de l'Irak ?",
            options = listOf("Bagdad", "Bassora", "Mossoul", "Erbil"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Bagdad, fondée au VIIIe siècle sur le Tigre, est la capitale de l'Irak.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_singapour",
            tags = listOf("capitale"),
            title = "Capitale de Singapour",
            text = "Quelle est la capitale de Singapour ?",
            options = listOf("Singapour", "Kuala Lumpur", "Jakarta", "Bandar Seri Begawan"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Singapour est une cité-État : la ville constitue à elle seule le pays et sa capitale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_chili",
            tags = listOf("capitale"),
            title = "Capitale du Chili",
            text = "Quelle est la capitale du Chili ?",
            options = listOf("Santiago", "Valparaíso", "Concepción", "Antofagasta"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Santiago, au pied de la cordillère des Andes, est la capitale du Chili.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_arabie_saoudite",
            tags = listOf("capitale"),
            title = "Capitale de l'Arabie saoudite",
            text = "Quelle est la capitale de l'Arabie saoudite ?",
            options = listOf("Riyad", "Djeddah", "La Mecque", "Médine"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Riyad est la capitale de l'Arabie saoudite ; Djeddah et La Mecque sont d'autres grandes villes du royaume.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_afghanistan",
            tags = listOf("capitale"),
            title = "Capitale de l'Afghanistan",
            text = "Quelle est la capitale de l'Afghanistan ?",
            options = listOf("Kaboul", "Kandahar", "Hérat", "Mazar-e Charif"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Kaboul, dans une vallée à 1 800 m d'altitude, est la capitale de l'Afghanistan.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_kenya",
            tags = listOf("capitale"),
            title = "Capitale du Kenya",
            text = "Quelle est la capitale du Kenya ?",
            options = listOf("Nairobi", "Mombasa", "Kisumu", "Nakuru"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Nairobi est la capitale du Kenya ; un parc national jouxte la ville.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_algerie",
            tags = listOf("capitale"),
            title = "Capitale de l'Algérie",
            text = "Quelle est la capitale de l'Algérie ?",
            options = listOf("Alger", "Oran", "Constantine", "Annaba"),
            correctIndex = 0,
            rating = 1100,
            explanation = "Alger, surnommée « Alger la Blanche », est la capitale de l'Algérie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_allemagne",
            tags = listOf("capitale"),
            title = "Capitale de l'Allemagne",
            text = "Quelle est la capitale de l'Allemagne ?",
            options = listOf("Berlin", "Munich", "Hambourg", "Francfort"),
            correctIndex = 0,
            rating = 950,
            explanation = "Berlin est la capitale de l'Allemagne, redevenue siège du gouvernement après la réunification de 1990.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_vietnam",
            tags = listOf("capitale"),
            title = "Capitale du Vietnam",
            text = "Quelle est la capitale du Vietnam ?",
            options = listOf("Hanoï", "Hô Chi Minh-Ville", "Da Nang", "Huê"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Hanoï est la capitale du Vietnam ; Hô Chi Minh-Ville (ex-Saïgon) en est la plus grande ville.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_madagascar",
            tags = listOf("capitale"),
            title = "Capitale de Madagascar",
            text = "Quelle est la capitale de Madagascar ?",
            options = listOf("Antananarivo", "Toamasina", "Mahajanga", "Antsirabe"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Antananarivo, souvent abrégée « Tana », est la capitale de Madagascar, sur les hauts plateaux.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_ethiopie",
            tags = listOf("capitale"),
            title = "Capitale de l'Éthiopie",
            text = "Quelle est la capitale de l'Éthiopie ?",
            options = listOf("Addis-Abeba", "Dire Dawa", "Gondar", "Mekele"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Addis-Abeba est la capitale de l'Éthiopie et le siège de l'Union africaine.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_argentine",
            tags = listOf("capitale"),
            title = "Capitale de l'Argentine",
            text = "Quelle est la capitale de l'Argentine ?",
            options = listOf("Buenos Aires", "Córdoba", "Rosario", "Mendoza"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Buenos Aires, sur le Río de la Plata, est la capitale de l'Argentine.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_coree_nord",
            tags = listOf("capitale"),
            title = "Capitale de la Corée du Nord",
            text = "Quelle est la capitale de la Corée du Nord ?",
            options = listOf("Pyongyang", "Hamhung", "Kaesong", "Wonsan"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Pyongyang, sur le fleuve Taedong, est la capitale de la Corée du Nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_ukraine",
            tags = listOf("capitale"),
            title = "Capitale de l'Ukraine",
            text = "Quelle est la capitale de l'Ukraine ?",
            options = listOf("Kiev", "Kharkiv", "Odessa", "Lviv"),
            correctIndex = 0,
            rating = 1100,
            explanation = "Kiev (Kyiv), sur le Dniepr, est la capitale de l'Ukraine.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_italie",
            tags = listOf("capitale"),
            title = "Capitale de l'Italie",
            text = "Quelle est la capitale de l'Italie ?",
            options = listOf("Rome", "Milan", "Naples", "Turin"),
            correctIndex = 0,
            rating = 900,
            explanation = "Rome, la « Ville éternelle », est la capitale de l'Italie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_taiwan",
            tags = listOf("capitale"),
            title = "Capitale de Taïwan",
            text = "Quelle est la capitale de Taïwan ?",
            options = listOf("Taipei", "Kaohsiung", "Taichung", "Tainan"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Taipei, au nord de l'île, est la capitale de Taïwan.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_angola",
            tags = listOf("capitale"),
            title = "Capitale de l'Angola",
            text = "Quelle est la capitale de l'Angola ?",
            options = listOf("Luanda", "Huambo", "Benguela", "Lobito"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Luanda, port sur l'océan Atlantique, est la capitale de l'Angola.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_yemen",
            tags = listOf("capitale"),
            title = "Capitale du Yémen",
            text = "Quelle est la capitale du Yémen ?",
            options = listOf("Sanaa", "Aden", "Taïz", "Hodeida"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Sanaa, l'une des plus anciennes villes habitées du monde, est la capitale du Yémen.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_ouzbekistan",
            tags = listOf("capitale"),
            title = "Capitale de l'Ouzbékistan",
            text = "Quelle est la capitale de l'Ouzbékistan ?",
            options = listOf("Tachkent", "Samarcande", "Boukhara", "Namangan"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Tachkent est la capitale de l'Ouzbékistan ; Samarcande, sur la route de la soie, est plus célèbre historiquement.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_rd_congo",
            tags = listOf("capitale"),
            title = "Capitale de la RD Congo",
            text = "Quelle est la capitale de la République démocratique du Congo ?",
            options = listOf("Kinshasa", "Lubumbashi", "Goma", "Kisangani"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Kinshasa est la capitale de la République démocratique du Congo, face à Brazzaville sur le fleuve Congo.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_azerbaidjan",
            tags = listOf("capitale"),
            title = "Capitale de l'Azerbaïdjan",
            text = "Quelle est la capitale de l'Azerbaïdjan ?",
            options = listOf("Bakou", "Gandja", "Soumgaït", "Lankaran"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Bakou, sur la mer Caspienne, est la capitale de l'Azerbaïdjan.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_jordanie",
            tags = listOf("capitale"),
            title = "Capitale de la Jordanie",
            text = "Quelle est la capitale de la Jordanie ?",
            options = listOf("Amman", "Zarqa", "Irbid", "Aqaba"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Amman est la capitale de la Jordanie ; Petra est un site archéologique, pas la capitale.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_cuba",
            tags = listOf("capitale"),
            title = "Capitale de Cuba",
            text = "Quelle est la capitale de Cuba ?",
            options = listOf("La Havane", "Santiago de Cuba", "Camagüey", "Holguín"),
            correctIndex = 0,
            rating = 1100,
            explanation = "La Havane est la capitale de Cuba, sur la côte nord de l'île.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_france",
            tags = listOf("capitale"),
            title = "Capitale de la France",
            text = "Quelle est la capitale de la France ?",
            options = listOf("Paris", "Lyon", "Marseille", "Bordeaux"),
            correctIndex = 0,
            rating = 850,
            explanation = "Paris, traversée par la Seine, est la capitale de la France.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_venezuela",
            tags = listOf("capitale"),
            title = "Capitale du Venezuela",
            text = "Quelle est la capitale du Venezuela ?",
            options = listOf("Caracas", "Maracaibo", "Valencia", "Barquisimeto"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Caracas est la capitale du Venezuela, dans une vallée proche de la côte caraïbe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_syrie",
            tags = listOf("capitale"),
            title = "Capitale de la Syrie",
            text = "Quelle est la capitale de la Syrie ?",
            options = listOf("Damas", "Alep", "Homs", "Lattaquié"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Damas, parmi les plus anciennes capitales du monde, est la capitale de la Syrie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_bielorussie",
            tags = listOf("capitale"),
            title = "Capitale de la Biélorussie",
            text = "Quelle est la capitale de la Biélorussie ?",
            options = listOf("Minsk", "Gomel", "Brest", "Vitebsk"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Minsk est la capitale de la Biélorussie (Bélarus).",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_roumanie",
            tags = listOf("capitale"),
            title = "Capitale de la Roumanie",
            text = "Quelle est la capitale de la Roumanie ?",
            options = listOf("Bucarest", "Cluj-Napoca", "Timișoara", "Iași"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Bucarest est la capitale de la Roumanie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_autriche",
            tags = listOf("capitale"),
            title = "Capitale de l'Autriche",
            text = "Quelle est la capitale de l'Autriche ?",
            options = listOf("Vienne", "Salzbourg", "Graz", "Innsbruck"),
            correctIndex = 0,
            rating = 1050,
            explanation = "Vienne, sur le Danube, est la capitale de l'Autriche.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_philippines",
            tags = listOf("capitale"),
            title = "Capitale des Philippines",
            text = "Quelle est la capitale des Philippines ?",
            options = listOf("Manille", "Quezon City", "Cebu", "Davao"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Manille est la capitale des Philippines ; Quezon City, voisine, l'a été un temps.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_ouganda",
            tags = listOf("capitale"),
            title = "Capitale de l'Ouganda",
            text = "Quelle est la capitale de l'Ouganda ?",
            options = listOf("Kampala", "Entebbe", "Gulu", "Jinja"),
            correctIndex = 0,
            rating = 1500,
            explanation = "Kampala est la capitale de l'Ouganda, près du lac Victoria ; Entebbe abrite l'aéroport international.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_ghana",
            tags = listOf("capitale"),
            title = "Capitale du Ghana",
            text = "Quelle est la capitale du Ghana ?",
            options = listOf("Accra", "Kumasi", "Tamale", "Takoradi"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Accra, sur le golfe de Guinée, est la capitale du Ghana.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_cameroun",
            tags = listOf("capitale"),
            title = "Capitale du Cameroun",
            text = "Quelle est la capitale du Cameroun ?",
            options = listOf("Yaoundé", "Douala", "Garoua", "Bamenda"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Yaoundé est la capitale du Cameroun ; Douala en est la plus grande ville et le port principal.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_zimbabwe",
            tags = listOf("capitale"),
            title = "Capitale du Zimbabwe",
            text = "Quelle est la capitale du Zimbabwe ?",
            options = listOf("Harare", "Bulawayo", "Mutare", "Gweru"),
            correctIndex = 0,
            rating = 1500,
            explanation = "Harare est la capitale du Zimbabwe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_qatar",
            tags = listOf("capitale"),
            title = "Capitale du Qatar",
            text = "Quelle est la capitale du Qatar ?",
            options = listOf("Doha", "Al Rayyan", "Al Wakrah", "Lusail"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Doha, sur le golfe Persique, est la capitale du Qatar.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_guinee",
            tags = listOf("capitale"),
            title = "Capitale de la Guinée",
            text = "Quelle est la capitale de la Guinée ?",
            options = listOf("Conakry", "Kankan", "Nzérékoré", "Labé"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Conakry, port atlantique, est la capitale de la Guinée.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_soudan",
            tags = listOf("capitale"),
            title = "Capitale du Soudan",
            text = "Quelle est la capitale du Soudan ?",
            options = listOf("Khartoum", "Omdurman", "Port-Soudan", "Nyala"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Khartoum, au confluent du Nil Blanc et du Nil Bleu, est la capitale du Soudan.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_malaisie",
            tags = listOf("capitale"),
            title = "Capitale de la Malaisie",
            text = "Quelle est la capitale de la Malaisie ?",
            options = listOf("Kuala Lumpur", "Putrajaya", "George Town", "Johor Bahru"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Kuala Lumpur est la capitale de la Malaisie ; Putrajaya n'en est que le centre administratif.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_congo",
            tags = listOf("capitale"),
            title = "Capitale du Congo (Brazzaville)",
            text = "Quelle est la capitale de la République du Congo (Congo-Brazzaville) ?",
            options = listOf("Brazzaville", "Pointe-Noire", "Dolisie", "Owando"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Brazzaville est la capitale de la République du Congo, à ne pas confondre avec la RD Congo (capitale Kinshasa).",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_zambie",
            tags = listOf("capitale"),
            title = "Capitale de la Zambie",
            text = "Quelle est la capitale de la Zambie ?",
            options = listOf("Lusaka", "Kitwe", "Ndola", "Livingstone"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Lusaka est la capitale de la Zambie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_tchequie",
            tags = listOf("capitale"),
            title = "Capitale de la Tchéquie",
            text = "Quelle est la capitale de la Tchéquie (République tchèque) ?",
            options = listOf("Prague", "Brno", "Ostrava", "Plzeň"),
            correctIndex = 0,
            rating = 1100,
            explanation = "Prague, sur la Vltava, est la capitale de la Tchéquie (République tchèque).",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_libye",
            tags = listOf("capitale"),
            title = "Capitale de la Libye",
            text = "Quelle est la capitale de la Libye ?",
            options = listOf("Tripoli", "Benghazi", "Misrata", "Syrte"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Tripoli, sur la côte méditerranéenne, est la capitale de la Libye.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_koweit",
            tags = listOf("capitale"),
            title = "Capitale du Koweït",
            text = "Quelle est la capitale du Koweït ?",
            options = listOf("Koweït", "Doha", "Manama", "Mascate"),
            correctIndex = 0,
            rating = 1450,
            explanation = "La capitale du Koweït est la ville de Koweït (Koweït City), qui porte le même nom que le pays.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_serbie",
            tags = listOf("capitale"),
            title = "Capitale de la Serbie",
            text = "Quelle est la capitale de la Serbie ?",
            options = listOf("Belgrade", "Novi Sad", "Niš", "Kragujevac"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Belgrade, au confluent de la Save et du Danube, est la capitale de la Serbie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_somalie",
            tags = listOf("capitale"),
            title = "Capitale de la Somalie",
            text = "Quelle est la capitale de la Somalie ?",
            options = listOf("Mogadiscio", "Hargeisa", "Kismaayo", "Berbera"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Mogadiscio, sur l'océan Indien, est la capitale de la Somalie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_burundi",
            tags = listOf("capitale"),
            title = "Capitale du Burundi",
            text = "Quelle est la capitale du Burundi ?",
            options = listOf("Gitega", "Bujumbura", "Ngozi", "Ruyigi"),
            correctIndex = 0,
            rating = 1700,
            explanation = "Depuis 2019, la capitale politique du Burundi est Gitega ; Bujumbura, l'ancienne capitale, reste la plus grande ville.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_australie",
            tags = listOf("capitale"),
            title = "Capitale de l'Australie",
            text = "Quelle est la capitale de l'Australie ?",
            options = listOf("Canberra", "Sydney", "Melbourne", "Brisbane"),
            correctIndex = 0,
            rating = 1150,
            explanation = "La capitale de l'Australie est Canberra, et non Sydney comme beaucoup le croient. Canberra a été construite de toutes pièces comme capitale fédérale, inaugurée en 1913, suite au compromis entre Sydney et Melbourne qui se disputaient ce titre.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_ocean",
            title = "Le plus grand océan",
            text = "Quel est le plus grand océan du monde ?",
            options = listOf("Atlantique", "Indien", "Arctique", "Pacifique"),
            correctIndex = 3,
            rating = 900,
            explanation = "L'océan Pacifique est le plus grand et le plus profond des océans, couvrant environ 165 millions de km², soit plus que toutes les terres émergées réunies. Son nom lui fut donné par l'explorateur Magellan qui le trouva calme lors de sa traversée en 1520.",
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
            id = "geo_capitale_canada",
            tags = listOf("capitale"),
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
            id = "geo_capitale_egypte",
            tags = listOf("capitale"),
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
            id = "geo_capitale_espagne",
            tags = listOf("capitale"),
            title = "Capitale de l'Espagne",
            text = "Quelle est la capitale de l'Espagne ?",
            options = listOf("Barcelone", "Madrid", "Séville", "Valence"),
            correctIndex = 1,
            rating = 600,
            explanation = "Madrid est la capitale et la plus grande ville de l'Espagne, située au cœur géographique du pays. Avec plus de 3 millions d'habitants, c'est l'une des plus grandes métropoles d'Europe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_paris_fleuve",
            title = "Fleuve de Paris",
            text = "Quel fleuve traverse Paris ?",
            options = listOf("La Loire", "Le Rhône", "La Seine", "La Garonne"),
            correctIndex = 2,
            rating = 600,
            explanation = "La Seine traverse Paris d'est en ouest sur environ 13 km, séparant la rive gauche de la rive droite. Longue de 777 km, elle prend sa source en Bourgogne et se jette dans la Manche au Havre.",
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
            id = "geo_capitale_norvege",
            tags = listOf("capitale"),
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
            id = "geo_capitale_burkina_faso",
            tags = listOf("capitale"),
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
            explanation = "Le cap Horn marque l'extrémité méridionale de l'archipel de la Terre de Feu, au sud de l'Amérique du Sud. C'est l'un des passages maritimes les plus redoutés au monde.",
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
            title = "Ile de Copenhague",
            text = "Sur quelle île se trouve principalement Copenhague ?",
            options = listOf("Fionie", "Bornholm", "Seeland", "Lolland"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Copenhague est située principalement sur l'île de Seeland, la plus grande île du Danemark.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_suriname",
            tags = listOf("capitale"),
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
            id = "geo_capitale_timor_oriental",
            tags = listOf("capitale"),
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
            explanation = "Le squelette d'un adulte compte 206 os. À la naissance, un bébé en possède environ 270, mais certains fusionnent au cours de la croissance, notamment au niveau du crâne et de la colonne vertébrale.",
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
            explanation = "Contrairement à une idée répandue, ce n'est pas l'oxygène mais l'azote qui domine l'atmosphère terrestre, représentant environ 78 % de l'air. L'oxygène n'en constitue que 21%, le reste étant composé d'argon, de dioxyde de carbone et de gaz divers.",
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
            explanation = "L'hydrogène est l'élément le plus abondant de l'univers, constituant environ 75% de la matière ordinaire. C'est le carburant des étoiles : par fusion nucléaire, elles transforment l'hydrogène en hélium, libérant l'énergie qui les fait briller.",
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
            explanation = "La température d'un éclair peut atteindre environ 30 000 °C.",
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
            id = "geo_capitale_estonie",
            tags = listOf("capitale"),
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
            id = "geo_capitale_mali",
            tags = listOf("capitale"),
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
            id = "geo_capitale_nouvelle_zelande",
            tags = listOf("capitale"),
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
            id = "geo_capitale_brunei",
            tags = listOf("capitale"),
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
            id = "geo_capitale_mozambique",
            tags = listOf("capitale"),
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
            id = "geo_capitale_micronesie",
            tags = listOf("capitale"),
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
            explanation = "Le pentathlon moderne comprend cinq disciplines : escrime, natation, équitation, tir et course à pied combinés.",
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
        Question(
            id = "geo_limpopo_embouchure",
            title = "Embouchure du Limpopo",
            text = "Dans quel océan le fleuve Limpopo se jette-t-il ?",
            options = listOf("Atlantique", "Indien", "Arctique", "Pacifique"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le Limpopo traverse plusieurs pays d'Afrique australe avant de se jeter dans l'océan Indien au Mozambique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_iles_feroe_souverainete",
            title = "Souveraineté des Féroé",
            text = "Les îles Féroé appartiennent à quel royaume ?",
            options = listOf("Norvège", "Royaume-Uni", "Danemark", "Islande"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Les îles Féroé constituent un territoire autonome du royaume du Danemark situé dans l'Atlantique Nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_slovenie",
            tags = listOf("capitale"),
            title = "Capitale de la Slovénie",
            text = "Quelle est la capitale de la Slovénie ?",
            options = listOf("Zagreb", "Ljubljana", "Bratislava", "Sarajevo"),
            correctIndex = 1,
            rating = 900,
            explanation = "Ljubljana est la capitale de la Slovénie depuis son indépendance en 1991. Elle est traversée par la rivière Ljubljanica.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mer_sargasses",
            title = "Particularité de la mer des Sargasses",
            text = "Quelle particularité distingue la mer des Sargasses ?",
            options = listOf("Elle est entièrement gelée", "Elle n'est bordée par aucune côte", "Elle est la plus profonde du monde", "Elle est artificielle"),
            correctIndex = 1,
            rating = 1700,
            explanation = "La mer des Sargasses est délimitée par des courants océaniques et non par des terres, ce qui en fait un cas unique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_madagascar_canal",
            title = "Canal du Mozambique",
            text = "Quel pays est séparé de Madagascar par le canal du Mozambique ?",
            options = listOf("Kenya", "Afrique du Sud", "Mozambique", "Tanzanie"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le canal du Mozambique sépare Madagascar du Mozambique sur le continent africain.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_victoria_chutes_pays",
            title = "Les chutes Victoria",
            text = "Les chutes Victoria se trouvent à la frontière entre la Zambie et quel autre pays ?",
            options = listOf("Zimbabwe", "Botswana", "Namibie", "Angola"),
            correctIndex = 0,
            rating = 1000,
            explanation = "Les chutes Victoria, parmi les plus impressionnantes du monde, sont situées sur le fleuve Zambèze entre la Zambie et le Zimbabwe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_titicaca_altitude",
            title = "Le lac Titicaca",
            text = "Le lac Titicaca est partagé entre le Pérou et quel autre pays ?",
            options = listOf("Équateur", "Bolivie", "Chili", "Paraguay"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le lac Titicaca est situé sur l'Altiplano andin à la frontière entre le Pérou et la Bolivie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_kerguelen_ocean",
            title = "Les Kerguelen",
            text = "Dans quel océan se trouvent les îles Kerguelen ?",
            options = listOf("Océan Indien", "Atlantique Nord", "Pacifique Nord", "Océan Arctique"),
            correctIndex = 0,
            rating = 1600,
            explanation = "Les îles Kerguelen sont un archipel français isolé situé dans le sud de l'océan Indien.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_volga_mer",
            title = "Destination de la Volga",
            text = "Dans quelle mer se jette la Volga ?",
            options = listOf("Mer Noire", "Mer Baltique", "Mer Caspienne", "Mer d'Azov"),
            correctIndex = 2,
            rating = 1300,
            explanation = "La Volga est le plus long fleuve d'Europe. Elle traverse la Russie avant de se jeter dans la mer Caspienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_alexandrie_fondateur",
            title = "Fondation d'Alexandrie",
            text = "Quel conquérant fonda la ville d'Alexandrie en Égypte ?",
            options = listOf("Jules César", "Alexandre le Grand", "Ptolémée Ier", "Ramsès II"),
            correctIndex = 1,
            rating = 900,
            explanation = "Alexandre le Grand fonda Alexandrie en 331 av. J.-C. La ville devint rapidement l'un des plus grands centres intellectuels du monde antique.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_hadrien_mur",
            title = "Le mur d'Hadrien",
            text = "Dans quelle région actuelle fut construit le mur d'Hadrien par les Romains ?",
            options = listOf("Écosse", "Irlande", "Angleterre", "Pays de Galles"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Le mur d'Hadrien fut construit au IIe siècle pour protéger la frontière nord de la province romaine de Bretagne.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_gutenberg_ville",
            title = "La ville de Gutenberg",
            text = "Dans quelle ville Johannes Gutenberg développa-t-il son imprimerie à caractères mobiles ?",
            options = listOf("Cologne", "Mayence", "Nuremberg", "Vienne"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Gutenberg travailla à Mayence, en Allemagne. Son invention transforma durablement la diffusion du savoir en Europe.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_armada_invincible",
            title = "L'Invincible Armada",
            text = "Quel pays lança l'Invincible Armada contre l'Angleterre en 1588 ?",
            options = listOf("France", "Espagne", "Portugal", "Pays-Bas"),
            correctIndex = 1,
            rating = 1100,
            explanation = "L'Invincible Armada était une immense flotte espagnole envoyée par Philippe II contre l'Angleterre d'Élisabeth Ire.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_capitaine_cook_fin",
            title = "Fin du capitaine Cook",
            text = "Sur quel archipel le navigateur James Cook trouva-t-il la mort en 1779 ?",
            options = listOf("Fidji", "Hawaï", "Samoa", "Tonga"),
            correctIndex = 1,
            rating = 1500,
            explanation = "James Cook fut tué lors d'un affrontement avec des habitants de l'archipel d'Hawaï, qu'il avait contribué à faire connaître aux Européens.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_ruée_or_klondike",
            title = "Ruée vers l'or du Klondike",
            text = "Dans quelle région eut lieu la célèbre ruée vers l'or du Klondike à la fin du XIXe siècle ?",
            options = listOf("Alaska", "Yukon", "Californie", "Sibérie"),
            correctIndex = 1,
            rating = 1450,
            explanation = "La ruée vers l'or du Klondike débuta en 1896 dans le territoire canadien du Yukon et attira des dizaines de milliers de chercheurs d'or.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_nuremberg_ville",
            title = "Procès de Nuremberg",
            text = "Les procès de Nuremberg jugèrent principalement les dirigeants de quel régime ?",
            options = listOf("Empire austro-hongrois", "Allemagne nazie", "Italie fasciste", "URSS stalinienne"),
            correctIndex = 1,
            rating = 950,
            explanation = "Les procès de Nuremberg furent organisés après la Seconde Guerre mondiale pour juger les principaux responsables nazis.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_mur_berlin_chute",
            title = "Chute du mur de Berlin",
            text = "En quelle année le mur de Berlin est-il tombé ?",
            options = listOf("1985", "1987", "1989", "1991"),
            correctIndex = 2,
            rating = 750,
            explanation = "La chute du mur de Berlin, le 9 novembre 1989, symbolisa la fin de la division de l'Europe durant la guerre froide.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_union_europeenne_maastricht",
            title = "Traité de Maastricht",
            text = "Le traité de Maastricht, signé en 1992, a créé quelle organisation ?",
            options = listOf("L'OTAN", "L'Union européenne", "L'ONU", "Le Conseil de l'Europe"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Le traité de Maastricht posa les bases de l'Union européenne moderne et introduisit notamment la citoyenneté européenne.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_axolotl_regeneration",
            title = "Le pouvoir de l'axolotl",
            text = "Quelle capacité exceptionnelle possède l'axolotl ?",
            options = listOf("Changer de couleur instantanément", "Régénérer des membres entiers", "Voler sur de courtes distances", "Produire du venin"),
            correctIndex = 1,
            rating = 1400,
            explanation = "L'axolotl est capable de régénérer des membres, des parties de son cœur, de sa moelle épinière et même certaines régions de son cerveau, ce qui en fait un sujet d'étude majeur en biologie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_uranus_decouverte",
            title = "Découverte d'Uranus",
            text = "Quel astronome découvrit la planète Uranus en 1781 ?",
            options = listOf("Galilée", "Johannes Kepler", "William Herschel", "Edmond Halley"),
            correctIndex = 2,
            rating = 1500,
            explanation = "William Herschel découvrit Uranus en 1781. Il s'agissait de la première planète découverte à l'aide d'un télescope.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_lichen_symbiose",
            title = "Nature d'un lichen",
            text = "Un lichen est l'association symbiotique entre un champignon et quoi ?",
            options = listOf("Une bactérie uniquement", "Une algue ou une cyanobactérie", "Une mousse", "Un insecte"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Les lichens résultent d'une association durable entre un champignon et un organisme photosynthétique, généralement une algue verte ou une cyanobactérie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_nebuleuse_definition",
            title = "Une nébuleuse",
            text = "Qu'est-ce qu'une nébuleuse en astronomie ?",
            options = listOf("Une petite planète", "Un amas d'astéroïdes", "Un nuage de gaz et de poussières", "Un trou noir"),
            correctIndex = 2,
            rating = 950,
            explanation = "Les nébuleuses sont de vastes nuages de gaz et de poussières où peuvent naître de nouvelles étoiles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_ginkgo_fossile_vivant",
            title = "Le ginkgo",
            text = "Pourquoi le ginkgo biloba est-il souvent qualifié de « fossile vivant » ?",
            options = listOf("Il pousse uniquement sur des fossiles", "Son espèce a très peu changé depuis des millions d'années", "Il ne vit qu'un an", "Il se nourrit de minéraux fossiles"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Le ginkgo appartient à une lignée végétale très ancienne dont les caractéristiques ont peu évolué depuis plus de 200 millions d'années.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_arc_en_ciel_primaire",
            title = "Couleur extérieure de l'arc-en-ciel",
            text = "Quelle couleur apparaît sur le bord extérieur d'un arc-en-ciel primaire ?",
            options = listOf("Violet", "Bleu", "Vert", "Rouge"),
            correctIndex = 3,
            rating = 1350,
            explanation = "Dans un arc-en-ciel primaire, le rouge apparaît à l'extérieur tandis que le violet se trouve à l'intérieur en raison de la dispersion de la lumière.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_geyser_definition",
            title = "Un geyser",
            text = "Qu'est-ce qu'un geyser ?",
            options = listOf("Une rivière souterraine", "Une source chaude jaillissant périodiquement", "Un volcan sous-marin", "Une grotte glacée"),
            correctIndex = 1,
            rating = 900,
            explanation = "Un geyser est une source chaude qui projette régulièrement de l'eau et de la vapeur sous pression vers la surface.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_boussole_magnetique",
            title = "Fonctionnement de la boussole",
            text = "Pourquoi une boussole indique-t-elle approximativement le nord ?",
            options = listOf("À cause de la gravité", "Grâce au champ magnétique terrestre", "Grâce au vent solaire", "À cause de la rotation terrestre"),
            correctIndex = 1,
            rating = 800,
            explanation = "L'aiguille aimantée d'une boussole s'aligne sur le champ magnétique terrestre, ce qui permet de repérer les directions.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_manchot_antarctique",
            title = "Le plus grand manchot",
            text = "Quelle est la plus grande espèce de manchot vivant actuellement ?",
            options = listOf("Manchot royal", "Manchot empereur", "Manchot papou", "Manchot Adélie"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le manchot empereur peut mesurer plus d'un mètre de hauteur. Il vit en Antarctique et est célèbre pour son mode de reproduction en plein hiver.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_donatello_sculpteur",
            title = "Le sculpteur Donatello",
            text = "Donatello est l'une des grandes figures artistiques de quelle période ?",
            options = listOf("Le Baroque", "La Renaissance", "Le Romantisme", "L'Art nouveau"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Donatello fut l'un des plus importants sculpteurs de la Renaissance italienne. Ses œuvres influencèrent profondément les artistes des générations suivantes.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_bolchoi_ville",
            title = "Le théâtre Bolchoï",
            text = "Dans quelle ville se trouve le célèbre théâtre Bolchoï ?",
            options = listOf("Saint-Pétersbourg", "Moscou", "Kiev", "Minsk"),
            correctIndex = 1,
            rating = 950,
            explanation = "Le théâtre Bolchoï de Moscou est l'un des temples mondiaux du ballet et de l'opéra depuis le XVIIIe siècle.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_ulysse_bloom",
            title = "Leopold Bloom",
            text = "Le personnage de Leopold Bloom est le héros de quel roman ?",
            options = listOf("À la recherche du temps perdu", "Ulysse", "Le Procès", "Le Bruit et la Fureur"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Leopold Bloom est le personnage principal d'Ulysse de James Joyce, considéré comme l'un des romans majeurs du XXe siècle.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_rodin_penseur",
            title = "Le Penseur",
            text = "Quelle sculpture célèbre représente un homme assis en pleine réflexion ?",
            options = listOf("David", "Le Baiser", "Le Penseur", "Moïse"),
            correctIndex = 2,
            rating = 700,
            explanation = "Le Penseur d'Auguste Rodin est devenu un symbole universel de la réflexion intellectuelle et philosophique.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_noh_japon",
            title = "Le théâtre nô",
            text = "Le théâtre nô est une forme traditionnelle de spectacle originaire de quel pays ?",
            options = listOf("Chine", "Japon", "Corée", "Indonésie"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Le théâtre nô est un art scénique japonais apparu au XIVe siècle, caractérisé par ses masques, sa lenteur et son raffinement.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_madone_cri_munch",
            title = "Peintre de Madone",
            text = "Quel artiste a également peint l'œuvre intitulée « Madone », en plus du célèbre « Cri » ?",
            options = listOf("Gustav Klimt", "Edvard Munch", "Egon Schiele", "Paul Gauguin"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Edvard Munch a réalisé plusieurs versions de Madone, œuvre emblématique de son univers symboliste et expressionniste.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_verdi_prenom",
            title = "Prénom de Verdi",
            text = "Quel était le prénom du compositeur Verdi ?",
            options = listOf("Antonio", "Giuseppe", "Giacomo", "Vincenzo"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Giuseppe Verdi est l'un des plus grands compositeurs d'opéra de l'histoire, auteur notamment de La Traviata et Aïda.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_fauvisme_couleurs",
            title = "Le fauvisme",
            text = "Quelle caractéristique est typique du mouvement fauviste ?",
            options = listOf("Des couleurs vives et non réalistes", "L'absence totale de couleur", "Des œuvres uniquement abstraites", "Des scènes exclusivement religieuses"),
            correctIndex = 0,
            rating = 1150,
            explanation = "Les artistes fauves, comme Matisse, utilisaient des couleurs intenses et expressives sans chercher à reproduire fidèlement la réalité.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_brothers_grimm",
            title = "Les frères Grimm",
            text = "Pour quel type d'œuvres les frères Grimm sont-ils principalement connus ?",
            options = listOf("Les opéras", "Les contes populaires", "Les romans policiers", "Les poèmes épiques"),
            correctIndex = 1,
            rating = 850,
            explanation = "Jacob et Wilhelm Grimm ont collecté et publié de nombreux contes populaires allemands, dont Blanche-Neige et Hansel et Gretel.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_escher_pays",
            title = "Origine d'Escher",
            text = "De quel pays était originaire l'artiste M. C. Escher ?",
            options = listOf("Belgique", "Allemagne", "Pays-Bas", "Danemark"),
            correctIndex = 2,
            rating = 1500,
            explanation = "M. C. Escher était un artiste néerlandais célèbre pour ses œuvres jouant avec les perspectives impossibles, les pavages et les illusions d'optique.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_surf_vague_hawaii",
            title = "Berceau du surf moderne",
            text = "Quel archipel est considéré comme le berceau du surf moderne ?",
            options = listOf("Fidji", "Hawaï", "Canaries", "Tahiti"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Le surf moderne trouve ses racines à Hawaï, où il constituait déjà une pratique culturelle importante bien avant son essor mondial au XXe siècle.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_pingpong_service",
            title = "Service au tennis de table",
            text = "Au tennis de table, la balle doit d'abord rebondir où lors d'un service réglementaire ?",
            options = listOf("Dans le camp adverse uniquement", "Dans le camp du serveur puis dans le camp adverse", "Sur la ligne centrale", "N'importe où sur la table"),
            correctIndex = 1,
            rating = 850,
            explanation = "Lors d'un service réglementaire, la balle doit rebondir une première fois dans le camp du serveur avant de franchir le filet et rebondir dans le camp adverse.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_rallye_copilote_role",
            title = "Rôle du copilote",
            text = "Dans les rallyes automobiles, quel est le rôle principal du copilote ?",
            options = listOf("Contrôler le moteur", "Lire les notes du parcours", "Changer les pneus", "Chronométrer les concurrents"),
            correctIndex = 1,
            rating = 900,
            explanation = "Le copilote annonce les virages, dangers et particularités du parcours à l'aide de notes préparées lors des reconnaissances.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_lancer_marteau_poids",
            title = "Le marteau d'athlétisme",
            text = "Le marteau utilisé en compétition masculine d'athlétisme pèse environ :",
            options = listOf("4 kg", "5 kg", "7,26 kg", "10 kg"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Le marteau masculin réglementaire pèse 7,26 kg. L'épreuve consiste à le lancer le plus loin possible après plusieurs rotations.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_canoe_kayak_difference",
            title = "Canoë ou kayak",
            text = "Quelle caractéristique distingue principalement le kayak du canoë ?",
            options = listOf("Le nombre de rameurs", "La présence d'une pagaie double", "La longueur de l'embarcation", "La couleur du bateau"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Le kayak utilise généralement une pagaie double tandis que le canoë emploie une pagaie simple.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_snooker_score_maximum",
            title = "Break maximal au snooker",
            text = "Quel est le score maximal théorique d'un break au snooker ?",
            options = listOf("147", "155", "167", "180"),
            correctIndex = 0,
            rating = 1700,
            explanation = "Le célèbre break maximum de 147 points est obtenu en empochant toutes les rouges avec les noires puis toutes les couleurs dans l'ordre.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_equitation_dressage",
            title = "Le dressage",
            text = "Le dressage est une discipline de quel sport olympique ?",
            options = listOf("Pentathlon moderne", "Équitation", "Gymnastique", "Polo"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le dressage est l'une des trois disciplines olympiques de l'équitation avec le saut d'obstacles et le concours complet.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_cricket_over",
            title = "L'over au cricket",
            text = "Combien de lancers compose généralement un over au cricket moderne ?",
            options = listOf("4", "5", "6", "8"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Dans la majorité des compétitions actuelles, un over est composé de six lancers valides effectués par le même lanceur.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_alpin_super_g",
            title = "Le Super-G",
            text = "Le Super-G est une discipline de quel sport ?",
            options = listOf("Snowboard", "Biathlon", "Ski alpin", "Ski de fond"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le Super-G est une épreuve de vitesse du ski alpin, située entre la descente et le slalom géant en termes de caractéristiques.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_waterpolo_duree_match",
            title = "Durée d'un match de water-polo",
            text = "Un match international de water-polo est généralement composé de combien de périodes ?",
            options = listOf("2", "3", "4", "6"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Les rencontres internationales de water-polo se disputent en quatre périodes de jeu séparées par de courtes pauses.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_sonic_rings",
            title = "Les anneaux de Sonic",
            text = "Dans les jeux Sonic, que perd généralement le hérisson lorsqu'il est touché par un ennemi ?",
            options = listOf("Ses vies", "Ses chaussures", "Ses anneaux", "Sa vitesse"),
            correctIndex = 2,
            rating = 700,
            explanation = "Lorsque Sonic est touché, il perd ses anneaux. Tant qu'il en possède au moins un, il peut survivre à l'impact.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_kaamelott_createur",
            title = "Créateur de Kaamelott",
            text = "Qui est le créateur de la série Kaamelott ?",
            options = listOf("Franck Pitiot", "Alexandre Astier", "Jean-Christophe Hembert", "Bruno Salomone"),
            correctIndex = 1,
            rating = 900,
            explanation = "Alexandre Astier est le créateur, scénariste, réalisateur et interprète principal de Kaamelott, où il joue le roi Arthur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_seigneur_anneaux_moria",
            title = "Les mines de la Moria",
            text = "Quel peuple a construit les mines de la Moria dans l'univers du Seigneur des Anneaux ?",
            options = listOf("Les Elfes", "Les Hommes", "Les Nains", "Les Hobbits"),
            correctIndex = 2,
            rating = 1150,
            explanation = "La Moria, également appelée Khazad-dûm, était l'un des plus grands royaumes nains de la Terre du Milieu.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_interstellar_robot",
            title = "Le robot TARS",
            text = "Dans quel film de science-fiction apparaît le robot nommé TARS ?",
            options = listOf("Seul sur Mars", "Interstellar", "Gravity", "Premier Contact"),
            correctIndex = 1,
            rating = 1350,
            explanation = "TARS est l'un des robots les plus appréciés du film Interstellar de Christopher Nolan, sorti en 2014.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_minecraft_creeper",
            title = "Le Creeper",
            text = "Quelle est la particularité principale d'un Creeper dans Minecraft ?",
            options = listOf("Il vole", "Il se téléporte", "Il explose près du joueur", "Il lance des flèches"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le Creeper est l'un des monstres les plus emblématiques de Minecraft. Il explose lorsqu'il s'approche suffisamment du joueur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_doctor_who_tardis",
            title = "Le TARDIS",
            text = "Que signifie l'acronyme TARDIS dans Doctor Who ?",
            options = listOf(
                "Time And Relative Dimension In Space",
                "Temporal And Remote Device In Space",
                "Time And Reality Device In System",
                "Temporal Relative Dimension Interface System"
            ),
            correctIndex = 0,
            rating = 1700,
            explanation = "TARDIS signifie « Time And Relative Dimension In Space ». Ce vaisseau temporel est bien plus grand à l'intérieur qu'à l'extérieur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_iles_aland_souverainete",
            title = "Les îles Åland",
            text = "Les îles Åland constituent un territoire autonome rattaché à quel pays ?",
            options = listOf("Suède", "Finlande", "Norvège", "Danemark"),
            correctIndex = 1,
            rating = 1650,
            explanation = "Les îles Åland sont un archipel autonome de langue suédoise appartenant à la Finlande. Elles bénéficient d'un statut démilitarisé unique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_zambeze_ocean",
            title = "Destination du Zambèze",
            text = "Dans quel océan se jette le fleuve Zambèze ?",
            options = listOf("Atlantique", "Indien", "Pacifique", "Arctique"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Après avoir traversé plusieurs pays d'Afrique australe et les chutes Victoria, le Zambèze se jette dans l'océan Indien au Mozambique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mont_elbrouz_pays",
            title = "Le mont Elbrouz",
            text = "Dans quel pays se situe le mont Elbrouz, point culminant de l'Europe selon la définition la plus répandue ?",
            options = listOf("Géorgie", "Russie", "Turquie", "Arménie"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Le mont Elbrouz culmine à 5 642 mètres dans le Caucase russe. Il est généralement considéré comme le plus haut sommet d'Europe.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_detroit_malacca",
            title = "Le détroit de Malacca",
            text = "Quel pays ne borde PAS le détroit de Malacca ?",
            options = listOf("Malaisie", "Indonésie", "Thaïlande", "Philippines"),
            correctIndex = 3,
            rating = 1800,
            explanation = "Le détroit de Malacca est situé entre la péninsule Malaise et l'île indonésienne de Sumatra. Les Philippines n'en sont pas riveraines.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_fjord_plus_long",
            title = "Le plus long fjord",
            text = "Dans quel pays se trouve le Sognefjord, le plus long fjord d'Europe ?",
            options = listOf("Islande", "Canada", "Norvège", "Suède"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Le Sognefjord, en Norvège, s'étend sur plus de 200 kilomètres à l'intérieur des terres.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mekong_pays",
            title = "Pays traversés par le Mékong",
            text = "Le Mékong traverse combien de pays au total ?",
            options = listOf("4", "5", "6", "7"),
            correctIndex = 2,
            rating = 1750,
            explanation = "Le Mékong traverse ou borde six pays : Chine, Myanmar, Laos, Thaïlande, Cambodge et Vietnam.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_suriname_langue",
            title = "Langue officielle du Suriname",
            text = "Quelle est la langue officielle du Suriname ?",
            options = listOf("Anglais", "Espagnol", "Néerlandais", "Français"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Le Suriname est le seul État indépendant d'Amérique du Sud dont la langue officielle est le néerlandais, héritage de son passé colonial.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_bayeux_tapisserie",
            title = "La tapisserie de Bayeux",
            text = "Quel événement historique est représenté sur la célèbre tapisserie de Bayeux ?",
            options = listOf("La guerre de Cent Ans", "La conquête normande de l'Angleterre", "Les croisades", "La bataille d'Azincourt"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La tapisserie de Bayeux raconte la conquête de l'Angleterre par Guillaume le Conquérant en 1066, notamment la bataille d'Hastings.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_versailles_galerie_glaces",
            title = "La galerie des Glaces",
            text = "Sous quel roi fut construite la galerie des Glaces du château de Versailles ?",
            options = listOf("Louis XIII", "Louis XIV", "Louis XV", "Louis XVI"),
            correctIndex = 1,
            rating = 1000,
            explanation = "La galerie des Glaces fut aménagée sous Louis XIV et symbolise la puissance de la monarchie française.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_bataille_lepante",
            title = "La bataille de Lépante",
            text = "La bataille navale de Lépante en 1571 opposa notamment les Ottomans à quelle coalition chrétienne ?",
            options = listOf("La Sainte Ligue", "La Ligue hanséatique", "L'Ordre teutonique", "La Triple Alliance"),
            correctIndex = 0,
            rating = 1700,
            explanation = "La Sainte Ligue remporta une victoire majeure contre l'Empire ottoman lors de la bataille de Lépante.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_transsibérien",
            title = "Le Transsibérien",
            text = "Dans quel pays fut construit le chemin de fer Transsibérien ?",
            options = listOf("Canada", "Russie", "Chine", "Kazakhstan"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le Transsibérien relie Moscou à Vladivostok sur plus de 9 000 kilomètres.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_suez_nationalisation",
            title = "Nationalisation du canal",
            text = "Quel dirigeant nationalisa le canal de Suez en 1956 ?",
            options = listOf("Sadate", "Nasser", "Farouk", "Moubarak"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Gamal Abdel Nasser nationalisa le canal de Suez, provoquant une crise internationale majeure.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_timbuktu_empire",
            title = "Tombouctou médiévale",
            text = "Tombouctou fut un centre intellectuel majeur de quel empire africain ?",
            options = listOf("Empire du Mali", "Empire zoulou", "Empire du Congo", "Empire aksoumite"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Tombouctou connut son âge d'or sous l'Empire du Mali puis l'Empire songhaï, devenant un grand centre du savoir.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_tchernobyl_annee",
            title = "Catastrophe de Tchernobyl",
            text = "En quelle année survint la catastrophe nucléaire de Tchernobyl ?",
            options = listOf("1984", "1986", "1988", "1991"),
            correctIndex = 1,
            rating = 800,
            explanation = "L'accident de Tchernobyl eut lieu le 26 avril 1986 en Ukraine alors membre de l'URSS.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_komodo_venin",
            title = "Le dragon de Komodo",
            text = "Dans quel pays vit naturellement le dragon de Komodo ?",
            options = listOf("Philippines", "Indonésie", "Malaisie", "Papouasie-Nouvelle-Guinée"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Le dragon de Komodo vit sur quelques îles indonésiennes. C'est le plus grand lézard actuel, pouvant dépasser 3 mètres de longueur.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_supernova_definition",
            title = "Une supernova",
            text = "Que désigne une supernova ?",
            options = listOf("Une planète géante", "L'explosion d'une étoile", "Une galaxie naissante", "Un trou noir miniature"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Une supernova est une explosion stellaire extrêmement énergétique pouvant brièvement surpasser l'éclat d'une galaxie entière.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_ornithorynque_ponte",
            title = "L'ornithorynque",
            text = "Quelle particularité rare possède l'ornithorynque parmi les mammifères ?",
            options = listOf("Il pond des œufs", "Il respire sous l'eau", "Il possède trois cœurs", "Il change de couleur"),
            correctIndex = 0,
            rating = 1250,
            explanation = "L'ornithorynque fait partie des monotrèmes, un groupe très rare de mammifères qui pondent des œufs.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_seisme_epicentre",
            title = "L'épicentre",
            text = "Qu'appelle-t-on l'épicentre d'un séisme ?",
            options = listOf("Le point de départ du séisme en profondeur", "Le point situé à la surface au-dessus du foyer", "La zone où les vagues s'arrêtent", "Le centre géographique du pays touché"),
            correctIndex = 1,
            rating = 1200,
            explanation = "L'épicentre est le point de la surface terrestre situé à la verticale du foyer du séisme, là où les secousses sont souvent les plus fortes.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_narval_defense",
            title = "La défense du narval",
            text = "La longue défense du narval est en réalité :",
            options = listOf("Une corne", "Une dent", "Une nageoire modifiée", "Un os du crâne"),
            correctIndex = 1,
            rating = 1450,
            explanation = "La célèbre défense du narval est une canine hypertrophiée qui peut atteindre plus de 2 mètres de longueur.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_vitesse_orbite_terre",
            title = "La Terre autour du Soleil",
            text = "Environ à quelle vitesse la Terre orbite-t-elle autour du Soleil ?",
            options = listOf("3 km/h", "300 km/h", "3 000 km/h", "107 000 km/h"),
            correctIndex = 3,
            rating = 1750,
            explanation = "La Terre se déplace autour du Soleil à une vitesse moyenne d'environ 107 000 km/h, soit près de 30 km/s.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_diatomees_algues",
            title = "Les diatomées",
            text = "Les diatomées sont principalement :",
            options = listOf("Des poissons microscopiques", "Des algues microscopiques", "Des bactéries pathogènes", "Des champignons marins"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Les diatomées sont des algues unicellulaires très abondantes dans les océans et jouent un rôle majeur dans la production d'oxygène.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_ambre_origine",
            title = "Origine de l'ambre",
            text = "L'ambre est principalement formé à partir de quoi ?",
            options = listOf("Lave refroidie", "Résine fossilisée", "Corail pétrifié", "Sable compressé"),
            correctIndex = 1,
            rating = 1100,
            explanation = "L'ambre provient de résines végétales anciennes qui se sont fossilisées pendant des millions d'années.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_octet_bits",
            title = "Composition d'un octet",
            text = "Combien de bits composent un octet ?",
            options = listOf("4", "8", "16", "32"),
            correctIndex = 1,
            rating = 850,
            explanation = "Un octet contient 8 bits. Cette unité est utilisée pour mesurer la taille des données informatiques.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_citizen_kane_realisateur",
            title = "Réalisateur de Citizen Kane",
            text = "Qui a réalisé le film considéré comme un classique du cinéma « Citizen Kane » ?",
            options = listOf("Alfred Hitchcock", "Orson Welles", "Billy Wilder", "John Ford"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Sorti en 1941, Citizen Kane est réalisé et interprété par Orson Welles. Il est souvent cité parmi les plus grands films de l'histoire du cinéma.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_goya_peintre_espagnol",
            title = "Francisco de Goya",
            text = "De quel pays était originaire le peintre Francisco de Goya ?",
            options = listOf("Italie", "Portugal", "Espagne", "Mexique"),
            correctIndex = 2,
            rating = 900,
            explanation = "Francisco de Goya est l'un des plus grands peintres espagnols. Son œuvre couvre aussi bien les portraits de cour que des scènes sombres et visionnaires.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_peter_pan_auteur",
            title = "Auteur de Peter Pan",
            text = "Qui a créé le personnage de Peter Pan ?",
            options = listOf("Lewis Carroll", "J. M. Barrie", "Rudyard Kipling", "Kenneth Grahame"),
            correctIndex = 1,
            rating = 1200,
            explanation = "L'écrivain écossais J. M. Barrie créa Peter Pan au début du XXe siècle. Le personnage est devenu une figure majeure de la littérature jeunesse.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_lascaux_decouverte",
            title = "La grotte de Lascaux",
            text = "Dans quel pays se trouve la célèbre grotte de Lascaux ?",
            options = listOf("Espagne", "France", "Italie", "Belgique"),
            correctIndex = 1,
            rating = 800,
            explanation = "La grotte de Lascaux est située en Dordogne. Ses peintures préhistoriques figurent parmi les plus remarquables du monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_ravel_bolero",
            title = "Le Boléro",
            text = "Quel compositeur a écrit le célèbre Boléro ?",
            options = listOf("Claude Debussy", "Maurice Ravel", "Gabriel Fauré", "Erik Satie"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le Boléro de Maurice Ravel est construit sur une mélodie répétée accompagnée d'une orchestration qui s'enrichit progressivement.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_metropolitan_ville",
            title = "Le Metropolitan Museum",
            text = "Dans quelle ville se trouve le Metropolitan Museum of Art ?",
            options = listOf("Chicago", "Washington", "New York", "Boston"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le Metropolitan Museum of Art, souvent appelé le Met, est l'un des plus grands musées d'art au monde.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_wagner_tetralogie",
            title = "L'Anneau du Nibelung",
            text = "Quel compositeur a créé la tétralogie opératique « L'Anneau du Nibelung » ?",
            options = listOf("Verdi", "Wagner", "Mahler", "Brahms"),
            correctIndex = 1,
            rating = 1600,
            explanation = "Richard Wagner composa cette monumentale série de quatre opéras inspirée des mythologies germaniques et nordiques.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_calligraphie_arabe",
            title = "La calligraphie arabe",
            text = "Dans de nombreuses traditions islamiques, la calligraphie a particulièrement prospéré pour quelle raison ?",
            options = listOf("L'absence de papier", "Le faible coût des encres", "L'importance accordée au texte sacré", "L'interdiction de la sculpture"),
            correctIndex = 2,
            rating = 1700,
            explanation = "La calligraphie occupe une place centrale dans l'art islamique, notamment en raison de l'importance religieuse accordée à la transmission du texte coranique.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_casablanca_replique",
            title = "Film Casablanca",
            text = "Quel acteur interprète Rick Blaine dans le film Casablanca ?",
            options = listOf("Clark Gable", "Humphrey Bogart", "Cary Grant", "James Stewart"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Humphrey Bogart joue Rick Blaine dans Casablanca (1942), l'un des films les plus célèbres de l'âge d'or hollywoodien.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_baroque_periode",
            title = "Le Baroque",
            text = "Le style baroque s'est principalement développé en Europe durant quels siècles ?",
            options = listOf("Xe-XIIe siècles", "XIIIe-XIVe siècles", "XVIIe-XVIIIe siècles", "XIXe-XXe siècles"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Le baroque s'épanouit principalement aux XVIIe et XVIIIe siècles, caractérisé par le mouvement, le contraste et l'exubérance décorative.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_javelot_materiau",
            title = "Le javelot moderne",
            text = "Dans quelle discipline sportive utilise-t-on un javelot ?",
            options = listOf("Pentathlon moderne", "Athlétisme", "Biathlon", "Décathlon aquatique"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le lancer du javelot est l'une des disciplines traditionnelles de l'athlétisme. Les athlètes cherchent à lancer leur engin le plus loin possible.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_scrum_rugby_joueurs",
            title = "La mêlée au rugby",
            text = "Combien de joueurs de chaque équipe participent à une mêlée en rugby à XV ?",
            options = listOf("6", "7", "8", "9"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Une mêlée de rugby à XV rassemble huit avants de chaque équipe. Elle permet de remettre le ballon en jeu dans certaines situations.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_escrime_sabre_cible",
            title = "Zone valable au sabre",
            text = "En escrime, quelle partie du corps constitue la surface valable au sabre ?",
            options = listOf("Le tronc uniquement", "Tout le corps", "La partie située au-dessus de la taille", "Les bras uniquement"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Au sabre, les touches sont valables sur toute la partie du corps située au-dessus de la taille, bras et tête inclus.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_basket_lancer_franc",
            title = "Distance du lancer franc",
            text = "Au basket-ball, à quelle distance approximative du panier se situe la ligne des lancers francs ?",
            options = listOf("2,5 m", "4,6 m", "6,75 m", "9 m"),
            correctIndex = 1,
            rating = 1100,
            explanation = "La ligne de lancer franc est située à environ 4,6 mètres du panneau dans les règles internationales.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_ultra_trail_definition",
            title = "L'ultra-trail",
            text = "Dans le monde de la course à pied, qu'appelle-t-on généralement un ultra-trail ?",
            options = listOf("Une course de moins de 10 km", "Une course en stade", "Une course nature dépassant la distance du marathon", "Une course réservée aux professionnels"),
            correctIndex = 2,
            rating = 850,
            explanation = "On parle généralement d'ultra-trail pour une course nature dont la distance dépasse celle du marathon, souvent avec un important dénivelé.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_badminton_vitesse_volant",
            title = "Vitesse du volant",
            text = "Le volant de badminton peut dépasser quelle vitesse lors des frappes les plus puissantes ?",
            options = listOf("150 km/h", "250 km/h", "400 km/h", "600 km/h"),
            correctIndex = 2,
            rating = 1700,
            explanation = "Les records modernes dépassent les 400 km/h, faisant du badminton l'un des sports de raquette les plus rapides au monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_ligue_champions_trophee",
            title = "La Coupe aux grandes oreilles",
            text = "Quel trophée est surnommé « la Coupe aux grandes oreilles » ?",
            options = listOf("La Coupe du monde", "La Ligue Europa", "La Ligue des champions", "La Copa Libertadores"),
            correctIndex = 2,
            rating = 750,
            explanation = "Le trophée de la Ligue des champions de l'UEFA est surnommé ainsi en raison de la forme caractéristique de ses anses.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_curling_maison",
            title = "La maison au curling",
            text = "Comment appelle-t-on la cible circulaire dessinée sur la glace au curling ?",
            options = listOf("L'anneau", "La maison", "Le cercle central", "Le nid"),
            correctIndex = 1,
            rating = 1450,
            explanation = "La cible du curling est appelée la maison. Les équipes cherchent à placer leurs pierres le plus près possible de son centre.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_voile_babord",
            title = "Babord et tribord",
            text = "Sur un voilier, de quel côté se situe bâbord lorsqu'on regarde vers l'avant du bateau ?",
            options = listOf("À droite", "À gauche", "À l'arrière", "Au centre"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Bâbord désigne le côté gauche d'un navire lorsque l'on regarde vers l'avant, tandis que tribord désigne le côté droit.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_futurama_planete_express",
            title = "Planet Express",
            text = "Dans la série Futurama, quel est le nom de l'entreprise où travaille Fry ?",
            options = listOf("Galaxy Delivery", "Planet Express", "Space Cargo", "Interstellar Mail"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Planet Express est la société de livraison interplanétaire dirigée par le professeur Farnsworth dans Futurama.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_harry_potter_animagus",
            title = "Animagus de Sirius",
            text = "En quel animal Sirius Black peut-il se transformer ?",
            options = listOf("Loup", "Cerf", "Chien noir", "Corbeau"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Sirius Black est un Animagus non déclaré capable de se transformer en grand chien noir, ce qui lui vaut le surnom de Patmol.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_portal_arme",
            title = "Le Portal Gun",
            text = "Dans le jeu Portal, quel objet permet de créer des portails ?",
            options = listOf("Gravity Gun", "Portal Gun", "Teleporter", "Phase Device"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Le Portal Gun permet de créer deux portails reliés entre eux, au cœur des mécaniques de jeu de Portal.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_starwars_kessel",
            title = "Le raid de Kessel",
            text = "Quel personnage se vante d'avoir réalisé le raid de Kessel en moins de douze parsecs ?",
            options = listOf("Luke Skywalker", "Lando Calrissian", "Han Solo", "Poe Dameron"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Han Solo affirme avoir accompli le raid de Kessel en moins de douze parsecs à bord du Faucon Millenium.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_dragonball_nuage",
            title = "Le nuage magique",
            text = "Comment s'appelle le nuage sur lequel voyage souvent Son Goku ?",
            options = listOf("Kinto-un", "Nimbus", "Shenron", "Kaio"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Le Kinto-un, souvent traduit par Nuage Magique, ne peut être utilisé que par les personnes au cœur pur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_fallout_abris",
            title = "Les Vaults",
            text = "Dans la série Fallout, comment s'appellent les abris souterrains construits avant la guerre nucléaire ?",
            options = listOf("Shelters", "Bunkers", "Vaults", "Refuges"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Les Vaults sont des abris souterrains construits par Vault-Tec. Beaucoup servaient aussi à mener des expériences sociales secrètes.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_chaplin_personnage",
            title = "Le Vagabond",
            text = "Quel personnage emblématique est associé à Charlie Chaplin ?",
            options = listOf("Le Vagabond", "Le Dictateur", "Charlot Junior", "Monsieur Verdoux"),
            correctIndex = 0,
            rating = 900,
            explanation = "Le Vagabond, appelé Charlot en français, est le personnage le plus célèbre incarné par Charlie Chaplin.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_blade_runner_replicants",
            title = "Les Réplicants",
            text = "Dans Blade Runner, comment appelle-t-on les êtres artificiels presque indiscernables des humains ?",
            options = listOf("Synthétiques", "Androïdes", "Réplicants", "Clones"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Les Réplicants sont des êtres biologiques artificiels créés par la Tyrell Corporation dans l'univers de Blade Runner.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_witcher_sorceleur_nom",
            title = "Le Sorceleur",
            text = "Quel est le nom du héros principal de la saga The Witcher ?",
            options = listOf("Jaskier", "Vesemir", "Geralt de Riv", "Emhyr"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Geralt de Riv est un sorceleur, un chasseur de monstres génétiquement modifié, héros des romans d'Andrzej Sapkowski et de leurs adaptations.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_capitale_bhoutan",
            tags = listOf("capitale"),
            title = "Capitale du Bhoutan",
            text = "Quelle est la capitale du Bhoutan ?",
            options = listOf("Katmandou", "Thimphou", "Paro", "Dacca"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Thimphou est la capitale du Bhoutan, petit royaume himalayen réputé pour son indice de bonheur national brut.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mer_andaman",
            title = "La mer d'Andaman",
            text = "La mer d'Andaman est située à l'est de quel pays ?",
            options = listOf("Inde", "Sri Lanka", "Pakistan", "Maldives"),
            correctIndex = 0,
            rating = 1450,
            explanation = "La mer d'Andaman se situe à l'est de l'Inde et à l'ouest de la Thaïlande et du Myanmar.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_borneo_partage",
            title = "L'île de Bornéo",
            text = "Combien de pays se partagent l'île de Bornéo ?",
            options = listOf("2", "3", "4", "5"),
            correctIndex = 1,
            rating = 1750,
            explanation = "Bornéo est partagée entre l'Indonésie, la Malaisie et le Brunei, soit trois pays au total.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_benin",
            tags = listOf("capitale"),
            title = "Capitale officielle du Bénin",
            text = "Quelle est la capitale officielle du Bénin ?",
            options = listOf("Porto-Novo", "Cotonou", "Parakou", "Abomey"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Porto-Novo est la capitale officielle du Bénin, même si Cotonou abrite la plupart des institutions gouvernementales.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_carpates_pays",
            title = "Les Carpates",
            text = "Quel pays abrite la plus grande partie de la chaîne des Carpates ?",
            options = listOf("Roumanie", "Slovaquie", "Pologne", "Ukraine"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Les Carpates traversent plusieurs pays d'Europe centrale et orientale, mais leur plus grande portion se situe en Roumanie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_poutine_origine",
            title = "Origine de la poutine",
            text = "La poutine est un plat originaire de quelle région du monde ?",
            options = listOf("Louisiane", "Québec", "Belgique", "Bretagne"),
            correctIndex = 1,
            rating = 900,
            explanation = "La poutine est un plat emblématique du Québec composé de frites, de fromage en grains et de sauce brune. Selon tes règles, l'origine géographique d'un plat relève de la géographie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_solon_athenes",
            title = "Le réformateur Solon",
            text = "Dans quelle cité grecque Solon mena-t-il ses célèbres réformes politiques au VIe siècle av. J.-C. ?",
            options = listOf("Sparte", "Corinthe", "Athènes", "Thèbes"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Solon fut un législateur athénien dont les réformes contribuèrent à poser les bases de la future démocratie athénienne.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_harald_angleterre",
            title = "Dernier roi saxon",
            text = "Quel roi d'Angleterre fut vaincu par Guillaume le Conquérant à la bataille d'Hastings en 1066 ?",
            options = listOf("Harold Godwinson", "Richard Cœur de Lion", "Étienne de Blois", "Henri Ier"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Harold Godwinson fut le dernier roi anglo-saxon d'Angleterre. Sa défaite à Hastings ouvrit la voie à la conquête normande.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_marco_polo_venise",
            title = "Origine de Marco Polo",
            text = "De quelle cité-État italienne Marco Polo était-il originaire ?",
            options = listOf("Florence", "Gênes", "Venise", "Pise"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Marco Polo était un marchand vénitien dont les récits de voyage contribuèrent à faire connaître l'Asie aux Européens.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_louisiane_vente",
            title = "Vente de la Louisiane",
            text = "Quel dirigeant français vendit la Louisiane aux États-Unis en 1803 ?",
            options = listOf("Louis XVI", "Napoléon Bonaparte", "Louis XVIII", "Napoléon III"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Napoléon Bonaparte vendit l'immense territoire de la Louisiane aux États-Unis, doublant presque la superficie du pays.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_nightingale_infirmiere",
            title = "Florence Nightingale",
            text = "Florence Nightingale est principalement connue pour avoir contribué au développement de quelle profession ?",
            options = listOf("Médecin", "Pharmacien", "Infirmière", "Sage-femme"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Florence Nightingale est considérée comme la fondatrice des soins infirmiers modernes grâce à son action durant la guerre de Crimée.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_panama_canal_ouverture",
            title = "Ouverture du canal",
            text = "En quelle année le canal de Panama fut-il officiellement ouvert à la navigation ?",
            options = listOf("1905", "1914", "1923", "1931"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Le canal de Panama fut inauguré en 1914 et permit de relier l'océan Atlantique à l'océan Pacifique sans contourner l'Amérique du Sud.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_enigma_machine",
            title = "La machine Enigma",
            text = "La machine Enigma était utilisée par quel pays durant la Seconde Guerre mondiale ?",
            options = listOf("Japon", "Italie", "Allemagne", "URSS"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Enigma était un système de chiffrement allemand. Son décryptage par les Alliés joua un rôle majeur dans le conflit.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_gandhi_independance",
            title = "Lutte de Gandhi",
            text = "Mahatma Gandhi mena principalement son action politique pour l'indépendance de quel pays ?",
            options = listOf("Pakistan", "Inde", "Sri Lanka", "Bangladesh"),
            correctIndex = 1,
            rating = 800,
            explanation = "Gandhi fut l'une des figures majeures du mouvement pour l'indépendance de l'Inde, notamment grâce à sa stratégie de résistance non violente.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_spoutnik_premier",
            title = "Premier satellite artificiel",
            text = "Quel pays lança Spoutnik 1, le premier satellite artificiel de l'histoire ?",
            options = listOf("États-Unis", "France", "URSS", "Royaume-Uni"),
            correctIndex = 2,
            rating = 850,
            explanation = "L'URSS lança Spoutnik 1 en octobre 1957, marquant le début de l'ère spatiale.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_velours_revolution",
            title = "Révolution de Velours",
            text = "Dans quel pays eut lieu la Révolution de Velours en 1989 ?",
            options = listOf("Pologne", "Hongrie", "Tchécoslovaquie", "Roumanie"),
            correctIndex = 2,
            rating = 1700,
            explanation = "La Révolution de Velours entraîna la fin pacifique du régime communiste en Tchécoslovaquie et l'arrivée au pouvoir de Václav Havel.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_tardigrade_survie",
            title = "Le tardigrade",
            text = "Pour quelle capacité les tardigrades sont-ils particulièrement connus ?",
            options = listOf("Produire de l'électricité", "Changer de forme", "Survivre à des conditions extrêmes", "Vivre uniquement sous terre"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Les tardigrades peuvent survivre à des températures extrêmes, au vide spatial, à de fortes radiations et à une déshydratation prolongée.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_heliocentrisme_copernic",
            title = "L'héliocentrisme",
            text = "Quel astronome est principalement associé à la théorie héliocentrique moderne ?",
            options = listOf("Tycho Brahe", "Nicolas Copernic", "Ptolémée", "Edwin Hubble"),
            correctIndex = 1,
            rating = 900,
            explanation = "Nicolas Copernic proposa que la Terre et les autres planètes tournent autour du Soleil, bouleversant la vision du monde de son époque.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_kiwi_oiseau",
            title = "Le kiwi",
            text = "Quelle particularité caractérise le kiwi, oiseau emblématique de Nouvelle-Zélande ?",
            options = listOf("Il nage sous l'eau", "Il est incapable de voler", "Il vit uniquement dans les arbres", "Il est venimeux"),
            correctIndex = 1,
            rating = 850,
            explanation = "Le kiwi possède des ailes très réduites et ne peut pas voler. Il est devenu un symbole national de la Nouvelle-Zélande.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_adn_support",
            title = "Support de l'hérédité",
            text = "Quelle molécule porte l'information génétique chez la plupart des êtres vivants ?",
            options = listOf("ATP", "ADN", "Protéine", "Glucose"),
            correctIndex = 1,
            rating = 700,
            explanation = "L'ADN contient les instructions génétiques nécessaires au développement et au fonctionnement des organismes vivants.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_mycorhize_definition",
            title = "Une mycorhize",
            text = "Une mycorhize est une association entre les racines d'une plante et quel autre organisme ?",
            options = listOf("Une bactérie", "Un insecte", "Un champignon", "Une algue"),
            correctIndex = 2,
            rating = 1700,
            explanation = "Les mycorhizes sont des associations bénéfiques entre les racines des plantes et certains champignons qui facilitent l'absorption des nutriments.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_venus_retrograde",
            title = "Rotation particulière",
            text = "Quelle planète tourne sur elle-même dans le sens opposé à celui de la plupart des autres planètes du Système solaire ?",
            options = listOf("Mars", "Jupiter", "Vénus", "Neptune"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Vénus possède une rotation rétrograde : le Soleil semble s'y lever à l'ouest et se coucher à l'est.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_levure_pain",
            title = "La levure du pain",
            text = "Quel organisme est principalement responsable de la fermentation utilisée pour faire lever la pâte à pain ?",
            options = listOf("Une algue", "Une levure", "Une mousse", "Un virus"),
            correctIndex = 1,
            rating = 800,
            explanation = "Les levures transforment les sucres en dioxyde de carbone, ce qui fait gonfler la pâte. Selon tes règles, l'aspect scientifique de la cuisine relève de Sciences & Nature.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_mercure_temperature",
            title = "Planète aux extrêmes",
            text = "Pourquoi Mercure connaît-elle de très fortes variations de température entre le jour et la nuit ?",
            options = listOf("Elle tourne trop vite", "Elle ne possède presque pas d'atmosphère", "Elle est couverte d'océans", "Elle reçoit peu de lumière"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Mercure ne possède pratiquement pas d'atmosphère pour retenir la chaleur, ce qui provoque d'énormes écarts de température.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_calorie_definition",
            title = "Une calorie",
            text = "En nutrition, que mesure une calorie ?",
            options = listOf("Une masse", "Une température", "Une énergie", "Une concentration"),
            correctIndex = 2,
            rating = 950,
            explanation = "La calorie est une unité d'énergie. Les aliments sont généralement exprimés en kilocalories (kcal).",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_migration_monarque",
            title = "Le papillon monarque",
            text = "Pour quel phénomène le papillon monarque est-il célèbre ?",
            options = listOf("Sa bioluminescence", "Sa migration sur de très longues distances", "Son venin", "Sa vie sous l'eau"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Les papillons monarques réalisent chaque année l'une des plus impressionnantes migrations du règne animal, parcourant plusieurs milliers de kilomètres.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_chopin_nationalite",
            title = "Nationalité de Chopin",
            text = "De quelle nationalité était le compositeur Frédéric Chopin ?",
            options = listOf("Autrichienne", "Allemande", "Polonaise", "Hongroise"),
            correctIndex = 2,
            rating = 900,
            explanation = "Frédéric Chopin était un compositeur et pianiste polonais du XIXe siècle. Ses mazurkas et ses polonaises s'inspirent fortement de la musique traditionnelle de son pays.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_taj_mahal_fonction",
            title = "Le Taj Mahal",
            text = "À l'origine, le Taj Mahal a été construit pour servir de :",
            options = listOf("Palais royal", "Temple hindou", "Observatoire", "Mausolée"),
            correctIndex = 3,
            rating = 950,
            explanation = "Le Taj Mahal fut construit au XVIIe siècle par l'empereur moghol Shah Jahan comme mausolée pour son épouse Mumtaz Mahal.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_muraille_unesco",
            title = "Patrimoine monumental",
            text = "Dans quel pays se trouve la Grande Muraille ?",
            options = listOf("Mongolie", "Corée du Nord", "Japon", "Chine"),
            correctIndex = 3,
            rating = 700,
            explanation = "La Grande Muraille de Chine est l'un des plus vastes ensembles architecturaux jamais construits et figure au patrimoine mondial de l'UNESCO.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_mozart_requiem",
            title = "Le Requiem",
            text = "Quel compositeur a laissé son célèbre Requiem inachevé à sa mort ?",
            options = listOf("Beethoven", "Mozart", "Haydn", "Schubert"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Mozart mourut en 1791 avant d'achever son Requiem, qui fut complété par certains de ses élèves.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_couscous_ingredient",
            title = "Base du couscous",
            text = "Le couscous traditionnel est préparé à partir de quelle céréale ?",
            options = listOf("Riz", "Orge", "Maïs", "Blé dur"),
            correctIndex = 3,
            rating = 850,
            explanation = "Le couscous est fabriqué à partir de semoule de blé dur. Selon tes règles, la gastronomie au sens culturel relève de la catégorie Art & Culture.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_gaudi_sagrada",
            title = "La Sagrada Família",
            text = "Quel architecte a conçu la basilique de la Sagrada Família à Barcelone ?",
            options = listOf("Antoni Gaudí", "Santiago Calatrava", "Le Corbusier", "Rafael Moneo"),
            correctIndex = 0,
            rating = 1000,
            explanation = "Antoni Gaudí consacra une grande partie de sa vie à la Sagrada Família, devenue l'un des monuments les plus célèbres d'Espagne.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_iliade_theme",
            title = "Sujet de l'Iliade",
            text = "Quel conflit constitue le cadre principal de l'Iliade ?",
            options = listOf("Les guerres médiques", "La guerre de Troie", "Les guerres puniques", "La conquête d'Alexandre"),
            correctIndex = 1,
            rating = 900,
            explanation = "L'Iliade attribuée à Homère raconte un épisode de la guerre de Troie centré sur la colère d'Achille.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_sushi_origine_culturelle",
            title = "Spécialité japonaise",
            text = "Avec quel pays les sushis sont-ils principalement associés ?",
            options = listOf("Corée du Sud", "Chine", "Japon", "Vietnam"),
            correctIndex = 2,
            rating = 650,
            explanation = "Les sushis sont devenus l'une des spécialités culinaires les plus connues du Japon. Selon tes règles, l'aspect culturel de la gastronomie relève d'Art & Culture.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_impression_soleil_levant",
            title = "Naissance de l'impressionnisme",
            text = "Quel peintre a réalisé « Impression, soleil levant », œuvre qui a donné son nom à l'impressionnisme ?",
            options = listOf("Pierre-Auguste Renoir", "Claude Monet", "Camille Pissarro", "Edgar Degas"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Présentée en 1874, l'œuvre de Claude Monet inspira le terme « impressionniste », d'abord utilisé de façon moqueuse par un critique.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_handball_zone",
            title = "La zone au handball",
            text = "À quelle distance du but se situe la ligne de zone au handball ?",
            options = listOf("4 mètres", "6 mètres", "7 mètres", "9 mètres"),
            correctIndex = 1,
            rating = 850,
            explanation = "La zone du gardien est délimitée par une ligne située à 6 mètres du but. Les joueurs de champ ne peuvent pas y pénétrer.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_open_ere_tennis",
            title = "L'ère Open",
            text = "En tennis, que marque le début de l'ère Open en 1968 ?",
            options = listOf("L'apparition du tie-break", "L'autorisation des joueurs professionnels dans les grands tournois", "L'utilisation des raquettes métalliques", "La création du classement ATP"),
            correctIndex = 1,
            rating = 1600,
            explanation = "À partir de 1968, amateurs et professionnels peuvent participer aux mêmes tournois majeurs, ouvrant une nouvelle ère du tennis.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_biathlon_penalite",
            title = "Erreur au tir",
            text = "En biathlon, que se passe-t-il généralement lorsqu'un athlète manque une cible ?",
            options = listOf("Il est éliminé", "Il reçoit une pénalité", "Son temps est remis à zéro", "Il change de carabine"),
            correctIndex = 1,
            rating = 900,
            explanation = "Selon le format de course, une cible manquée entraîne généralement un tour de pénalité ou du temps ajouté au chrono.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_golf_albatros",
            title = "L'albatros au golf",
            text = "Au golf, qu'appelle-t-on un albatros ?",
            options = listOf("Un trou en un", "Trois coups sous le par", "Deux coups sous le par", "Quatre coups sous le par"),
            correctIndex = 1,
            rating = 1750,
            explanation = "Un albatros, aussi appelé double eagle, correspond à un score de trois coups sous le par sur un trou.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_judo_waza_ari",
            title = "Le waza-ari",
            text = "En judo, que vaut un waza-ari ?",
            options = listOf(
                "Une pénalité",
                "Un demi-point",
                "Une victoire immédiate",
                "Un avertissement"
            ),
            correctIndex = 1,
            rating = 1150,
            explanation = "Le waza-ari récompense une technique presque parfaite. Depuis l'évolution des règles internationales, deux waza-ari obtenus par le même judoka équivalent à un ippon et donnent la victoire.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tour_france_maillot_pois",
            title = "Maillot à pois",
            text = "Dans le Tour de France, que récompense le maillot à pois rouges ?",
            options = listOf("Le meilleur jeune", "Le meilleur grimpeur", "Le leader du classement général", "Le meilleur sprinteur"),
            correctIndex = 1,
            rating = 800,
            explanation = "Le maillot à pois distingue le meilleur grimpeur du Tour de France selon un système de points attribués dans les ascensions.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_hockey_glace_prolongation",
            title = "Après un match nul",
            text = "Dans de nombreuses compétitions de hockey sur glace, que se passe-t-il lorsqu'un match est à égalité à la fin du temps réglementaire ?",
            options = listOf("Le match est rejoué", "Une prolongation est disputée", "Les deux équipes sont déclarées vainqueures", "Le score est annulé"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Selon la compétition, une prolongation puis éventuellement une séance de tirs au but permettent de départager les équipes.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_basket_triple_double",
            title = "Le triple-double",
            text = "Au basket-ball, qu'appelle-t-on un triple-double ?",
            options = listOf("Trois paniers à trois points consécutifs", "Dix points inscrits dans trois matchs de suite", "Au moins dix unités dans trois catégories statistiques", "Trois joueurs à plus de dix points"),
            correctIndex = 2,
            rating = 1450,
            explanation = "Un triple-double est réalisé lorsqu'un joueur atteint au moins dix unités dans trois catégories statistiques différentes, par exemple points, rebonds et passes décisives.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_stranger_things_ville",
            title = "La ville de Stranger Things",
            text = "Dans quelle ville fictive se déroule principalement la série Stranger Things ?",
            options = listOf("Riverdale", "Hawkins", "Sunnydale", "Twin Peaks"),
            correctIndex = 1,
            rating = 850,
            explanation = "La série Stranger Things se déroule principalement à Hawkins, une petite ville fictive de l'Indiana où surviennent des phénomènes surnaturels.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_queen_chanteur",
            title = "Voix de Queen",
            text = "Quel chanteur était le leader du groupe Queen ?",
            options = listOf("David Bowie", "Roger Taylor", "Freddie Mercury", "Elton John"),
            correctIndex = 2,
            rating = 700,
            explanation = "Freddie Mercury était le chanteur emblématique de Queen. Sa voix exceptionnelle a contribué au succès mondial du groupe.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_mario_kart_carapace_bleue",
            title = "La carapace bleue",
            text = "Dans Mario Kart, quel est l'effet principal de la carapace bleue ?",
            options = listOf("Accélérer le joueur", "Voler des objets", "Viser le concurrent en tête", "Bloquer tous les adversaires"),
            correctIndex = 2,
            rating = 950,
            explanation = "La carapace bleue cible généralement le joueur en première position, ce qui en fait l'un des objets les plus redoutés de la série.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_beatles_liverpool",
            title = "Origine des Beatles",
            text = "Dans quelle ville les Beatles ont-ils été formés ?",
            options = listOf("Manchester", "Birmingham", "Liverpool", "Londres"),
            correctIndex = 2,
            rating = 800,
            explanation = "Les Beatles ont été formés à Liverpool au début des années 1960 avant de devenir l'un des groupes les plus influents de l'histoire de la musique.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_madonna_prenom",
            title = "Madonna",
            text = "Quel est le prénom complet sous lequel est connue la chanteuse Madonna ?",
            options = listOf("Madonna Louise Ciccone", "Madonna Maria Ciccone", "Madonna Grace Ciccone", "Madonna Anna Ciccone"),
            correctIndex = 0,
            rating = 1650,
            explanation = "Madonna Louise Ciccone est née dans le Michigan en 1958. Elle est devenue l'une des artistes les plus influentes de la musique pop.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pacman_fantome_rouge",
            title = "Le fantôme rouge",
            text = "Comment s'appelle le fantôme rouge dans le jeu Pac-Man ?",
            options = listOf("Pinky", "Blinky", "Inky", "Clyde"),
            correctIndex = 1,
            rating = 1700,
            explanation = "Blinky est le fantôme rouge de Pac-Man. Chaque fantôme possède un comportement spécifique pour traquer le joueur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_black_mirror_anthologie",
            title = "Black Mirror",
            text = "Quel type de série est Black Mirror ?",
            options = listOf("Sitcom", "Anthologie", "Soap opera", "Téléréalité"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Black Mirror est une série d'anthologie : chaque épisode raconte une histoire différente, généralement liée aux dérives technologiques.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_zelda_epee_legendaire",
            title = "L'épée légendaire",
            text = "Comment s'appelle l'épée légendaire que Link manie dans de nombreux jeux The Legend of Zelda ?",
            options = listOf("Excalibur", "Master Sword", "Buster Sword", "Sky Blade"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La Master Sword, souvent appelée Épée de légende en français, est l'arme emblématique de Link dans la série The Legend of Zelda.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_lac_baikal_profondeur",
            title = "Le lac le plus profond",
            text = "Quel lac est le plus profond du monde ?",
            options = listOf("Tanganyika", "Supérieur", "Baïkal", "Victoria"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le lac Baïkal, situé en Sibérie, atteint une profondeur maximale de 1 642 mètres. Il contient environ 20 % des réserves mondiales d'eau douce liquide de surface.",
            category = Category.GEOGRAPHIE
        ),

        Question(
            id = "geo_capitale_botswana",
            tags = listOf("capitale"),
            title = "Capitale du Botswana",
            text = "Quelle est la capitale du Botswana ?",
            options = listOf("Lusaka", "Gaborone", "Windhoek", "Harare"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Gaborone est la capitale du Botswana depuis l'indépendance du pays en 1966.",
            category = Category.GEOGRAPHIE
        ),

        Question(
            id = "geo_capitale_kirghizistan",
            tags = listOf("capitale"),
            title = "Capitale du Kirghizistan",
            text = "Quelle est la capitale du Kirghizistan ?",
            options = listOf("Bichkek", "Achgabat", "Douchanbé", "Almaty"),
            correctIndex = 0,
            rating = 1750,
            explanation = "Bichkek est la capitale du Kirghizistan, pays montagneux d'Asie centrale.",
            category = Category.GEOGRAPHIE
        ),

        Question(
            id = "geo_archipel_azores",
            title = "Les Açores",
            text = "Les Açores appartiennent à quel pays ?",
            options = listOf("Espagne", "Portugal", "France", "Italie"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Les Açores constituent une région autonome du Portugal située dans l'océan Atlantique.",
            category = Category.GEOGRAPHIE
        ),

        Question(
            id = "hist_bataille_actium",
            title = "La bataille d'Actium",
            text = "La bataille navale d'Actium opposa Octave à quel dirigeant romain ?",
            options = listOf("Jules César", "Marc Antoine", "Néron", "Trajan"),
            correctIndex = 1,
            rating = 1650,
            explanation = "En 31 av. J.-C., Octave vainquit Marc Antoine et Cléopâtre à Actium, ouvrant la voie à l'Empire romain.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_suffrage_suisse_femmes",
            title = "Vote des femmes en Suisse",
            text = "En quelle année les femmes ont-elles obtenu le droit de vote au niveau fédéral en Suisse ?",
            options = listOf("1945", "1958", "1971", "1984"),
            correctIndex = 2,
            rating = 1800,
            explanation = "La Suisse a accordé le droit de vote aux femmes au niveau fédéral en 1971, relativement tardivement par rapport à d'autres démocraties.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_bataille_midway",
            title = "La bataille de Midway",
            text = "La bataille de Midway de 1942 opposa principalement les États-Unis à quel pays ?",
            options = listOf("Allemagne", "Italie", "Japon", "URSS"),
            correctIndex = 2,
            rating = 1450,
            explanation = "La victoire américaine à Midway est considérée comme un tournant majeur de la guerre du Pacifique.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_nelson_mandela_prison",
            title = "Prison de Mandela",
            text = "Sur quelle île Nelson Mandela passa-t-il une grande partie de sa détention ?",
            options = listOf("Zanzibar", "Madère", "Robben Island", "Sainte-Hélène"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Nelson Mandela fut emprisonné pendant 18 ans sur Robben Island, près du Cap.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "spo_escalade_jo",
            title = "L'escalade olympique",
            text = "Lors de quels Jeux olympiques l'escalade sportive a-t-elle fait son apparition officielle ?",
            options = listOf("Rio 2016", "Tokyo 2020", "Londres 2012", "Paris 2024"),
            correctIndex = 1,
            rating = 1350,
            explanation = "L'escalade sportive a intégré le programme olympique lors des Jeux de Tokyo 2020.",
            category = Category.SPORTS
        ),

        Question(
            id = "spo_voile_catamaran",
            title = "Le catamaran",
            text = "Combien de coques possède un catamaran ?",
            options = listOf("Une", "Deux", "Trois", "Quatre"),
            correctIndex = 1,
            rating = 900,
            explanation = "Un catamaran possède deux coques parallèles, ce qui lui confère une excellente stabilité.",
            category = Category.SPORTS
        ),

        Question(
            id = "spo_snooker_bille_noire",
            title = "Valeur de la bille noire",
            text = "Au snooker, combien de points rapporte la bille noire ?",
            options = listOf("5", "6", "7", "8"),
            correctIndex = 2,
            rating = 1700,
            explanation = "La bille noire vaut 7 points, soit le score le plus élevé parmi les billes de couleur.",
            category = Category.SPORTS
        ),

        Question(
            id = "div_gta_ville_vice_city",
            title = "Vice City",
            text = "La ville fictive de Vice City est inspirée de quelle ville réelle ?",
            options = listOf("Los Angeles", "Miami", "Chicago", "Las Vegas"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Vice City est largement inspirée de Miami et de son ambiance des années 1980.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_abba_pays",
            title = "Origine d'ABBA",
            text = "Le groupe ABBA est originaire de quel pays ?",
            options = listOf("Norvège", "Danemark", "Suède", "Finlande"),
            correctIndex = 2,
            rating = 850,
            explanation = "ABBA est un groupe suédois formé à Stockholm et devenu mondialement célèbre après sa victoire à l'Eurovision 1974.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_xfiles_agents",
            title = "Agents de X-Files",
            text = "Quels sont les deux agents principaux de la série X-Files ?",
            options = listOf("Mulder et Scully", "Benson et Stabler", "Crockett et Tubbs", "Castle et Beckett"),
            correctIndex = 0,
            rating = 1000,
            explanation = "Fox Mulder et Dana Scully sont les deux agents du FBI au cœur de X-Files, série culte mêlant enquêtes paranormales, science-fiction et complots gouvernementaux.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_capitale_mongolie",
            tags = listOf("capitale"),
            title = "Capitale de la Mongolie",
            text = "Quelle est la capitale de la Mongolie ?",
            options = listOf("Astana", "Oulan-Bator", "Tachkent", "Bichkek"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Oulan-Bator est la capitale de la Mongolie. Elle concentre une grande partie de la population du pays.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_fleuve_tamise",
            title = "Fleuve de Londres",
            text = "Quel fleuve traverse Londres ?",
            options = listOf("La Tamise", "La Severn", "Le Rhin", "La Clyde"),
            correctIndex = 0,
            rating = 750,
            explanation = "La Tamise traverse Londres d'ouest en est avant de se jeter dans la mer du Nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_uruguay",
            tags = listOf("capitale"),
            title = "Capitale de l'Uruguay",
            text = "Quelle est la capitale de l'Uruguay ?",
            options = listOf("Asuncion", "Montevideo", "La Paz", "Quito"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Montevideo est la capitale de l'Uruguay, située sur la rive nord du Río de la Plata.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_origine_paella",
            title = "Origine de la paella",
            text = "De quel pays la paella est-elle originaire ?",
            options = listOf("Italie", "Espagne", "Portugal", "Grèce"),
            correctIndex = 1,
            rating = 800,
            explanation = "La paella est un plat emblématique espagnol, particulièrement associé à la région de Valence.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_iles_shetland_pays",
            title = "Les îles Shetland",
            text = "Les îles Shetland appartiennent à quel pays ?",
            options = listOf("Norvège", "Royaume-Uni", "Islande", "Danemark"),
            correctIndex = 1,
            rating = 1450,
            explanation = "Les Shetland sont un archipel écossais situé au nord du Royaume-Uni.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_liban",
            tags = listOf("capitale"),
            title = "Capitale du Liban",
            text = "Quelle est la capitale du Liban ?",
            options = listOf("Damas", "Beyrouth", "Amman", "Nicosie"),
            correctIndex = 1,
            rating = 850,
            explanation = "Beyrouth est la capitale du Liban, située sur la côte méditerranéenne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_fleuve_tibre",
            title = "Fleuve de Rome",
            text = "Quel fleuve traverse Rome ?",
            options = listOf("Le Pô", "L'Arno", "Le Tibre", "Le Tage"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Le Tibre traverse Rome avant de se jeter dans la mer Tyrrhénienne.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_georgie",
            tags = listOf("capitale"),
            title = "Capitale de la Géorgie",
            text = "Quelle est la capitale de la Géorgie ?",
            options = listOf("Tbilissi", "Erevan", "Bakou", "Batoumi"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Tbilissi est la capitale de la Géorgie, située dans le Caucase.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_altiplano_continent",
            title = "L'Altiplano",
            text = "Sur quel continent se trouve l'Altiplano andin ?",
            options = listOf("Afrique", "Asie", "Amérique du Sud", "Europe"),
            correctIndex = 2,
            rating = 1350,
            explanation = "L'Altiplano est un haut plateau situé dans les Andes, en Amérique du Sud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_cambodge",
            tags = listOf("capitale"),
            title = "Capitale du Cambodge",
            text = "Quelle est la capitale du Cambodge ?",
            options = listOf("Vientiane", "Phnom Penh", "Hanoï", "Bangkok"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Phnom Penh est la capitale du Cambodge, située au confluent du Mékong et du Tonlé Sap.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_origine_tacos",
            title = "Origine des tacos",
            text = "De quel pays les tacos sont-ils originaires ?",
            options = listOf("Mexique", "Espagne", "Colombie", "Pérou"),
            correctIndex = 0,
            rating = 750,
            explanation = "Les tacos sont un plat traditionnel mexicain. L'origine géographique d'un plat relève ici de la catégorie Géographie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_traites_verdun",
            title = "Partage de l'empire carolingien",
            text = "Quel traité a partagé l'empire de Charlemagne entre ses petits-fils ?",
            options = listOf("Traité de Verdun", "Traité de Westphalie", "Traité de Tordesillas", "Traité d'Utrecht"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Le traité de Verdun de 843 partagea l'empire carolingien entre les trois petits-fils de Charlemagne.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_hammurabi_roi",
            title = "Le code d'Hammurabi",
            text = "Le roi Hammurabi a régné sur quelle civilisation antique ?",
            options = listOf("Babylone", "Égypte", "Perse", "Phénicie"),
            correctIndex = 0,
            rating = 1200,
            explanation = "Hammurabi fut un roi de Babylone célèbre pour le code juridique portant son nom.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_constantinople_nom",
            title = "Nom actuel de Constantinople",
            text = "Quelle grande ville porte aujourd'hui le nom de l'ancienne Constantinople ?",
            options = listOf("Athènes", "Izmir", "Istanbul", "Ankara"),
            correctIndex = 2,
            rating = 800,
            explanation = "Constantinople est devenue Istanbul, aujourd'hui la plus grande ville de Turquie.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_carthage_fondation",
            title = "Fondatrice légendaire de Carthage",
            text = "Selon la tradition, qui aurait fondé la ville de Carthage ?",
            options = listOf("Didon", "Cléopâtre", "Sémiramis", "Bérénice"),
            correctIndex = 0,
            rating = 1700,
            explanation = "Didon, également appelée Élyssa, est la fondatrice légendaire de Carthage selon les récits antiques.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_bismarck_pays",
            title = "Otto von Bismarck",
            text = "Otto von Bismarck est principalement associé à l'unification de quel pays ?",
            options = listOf("Italie", "Autriche", "Allemagne", "Pologne"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Bismarck joua un rôle majeur dans l'unification allemande au XIXe siècle.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_route_soie",
            title = "La route de la soie",
            text = "La route de la soie reliait principalement la Chine à quel continent ?",
            options = listOf("Afrique", "Europe", "Océanie", "Amérique"),
            correctIndex = 1,
            rating = 900,
            explanation = "La route de la soie était un vaste réseau commercial reliant l'Asie orientale à l'Europe.",
            category = Category.HISTOIRE
        ),

        Question(
            id = "hist_akhenaton_religion",
            title = "La réforme d'Akhenaton",
            text = "Quel pharaon égyptien tenta d'imposer le culte exclusif d'Aton ?",
            options = listOf("Ramsès II", "Toutânkhamon", "Akhenaton", "Khéops"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Akhenaton mena une importante réforme religieuse centrée sur le dieu Aton.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_cellule_mitochondrie",
            title = "Rôle des mitochondries",
            text = "Quel est le rôle principal des mitochondries dans les cellules ?",
            options = listOf("Produire de l'énergie", "Stocker l'ADN", "Fabriquer les protéines", "Éliminer les déchets"),
            correctIndex = 0,
            rating = 850,
            explanation = "Les mitochondries produisent l'essentiel de l'énergie utilisée par les cellules sous forme d'ATP.",
            category = Category.SCIENCES_ET_NATURE
        ),

        Question(
            id = "sci_roche_metamorphique",
            title = "Une roche métamorphique",
            text = "Laquelle de ces roches est une roche métamorphique ?",
            options = listOf("Granite", "Basalte", "Marbre", "Obsidienne"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Le marbre provient de la transformation du calcaire sous l'effet de la pression et de la température.",
            category = Category.SCIENCES_ET_NATURE
        ),

        Question(
            id = "sci_vitamine_soleil",
            title = "Vitamine du soleil",
            text = "Quelle vitamine est principalement produite par la peau sous l'action du soleil ?",
            options = listOf("Vitamine A", "Vitamine C", "Vitamine D", "Vitamine K"),
            correctIndex = 2,
            rating = 800,
            explanation = "L'exposition de la peau aux rayons UVB permet la synthèse de vitamine D.",
            category = Category.SCIENCES_ET_NATURE
        ),

        Question(
            id = "sci_mars_olympus_mons",
            title = "Olympus Mons",
            text = "Olympus Mons est situé sur quelle planète ?",
            options = listOf("Vénus", "Mars", "Mercure", "Jupiter"),
            correctIndex = 1,
            rating = 950,
            explanation = "Olympus Mons est un immense volcan situé sur Mars.",
            category = Category.SCIENCES_ET_NATURE
        ),

        Question(
            id = "sci_atome_hydrogene",
            title = "L'hydrogène",
            text = "Combien de proton possède l'atome d'hydrogène le plus courant ?",
            options = listOf("1", "2", "6", "8"),
            correctIndex = 0,
            rating = 1100,
            explanation = "L'hydrogène est l'élément chimique le plus simple : son noyau contient un seul proton.",
            category = Category.SCIENCES_ET_NATURE
        ),

        Question(
            id = "sci_groupe_sanguin_receveur",
            title = "Receveur universel",
            text = "Quel groupe sanguin est généralement considéré comme receveur universel pour les globules rouges ?",
            options = listOf("O-", "AB+", "A+", "B-"),
            correctIndex = 1,
            rating = 1700,
            explanation = "Les personnes de groupe AB+ peuvent recevoir des globules rouges de tous les groupes sanguins ABO et Rhésus.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_machu_picchu_civilisation",
            title = "Le Machu Picchu",
            text = "Le Machu Picchu est associé à quelle civilisation ?",
            options = listOf("Aztèque", "Maya", "Inca", "Olmèque"),
            correctIndex = 2,
            rating = 850,
            explanation = "Le Machu Picchu est une cité construite par les Incas dans les Andes péruviennes.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_gatsby_auteur",
            title = "Auteur de Gatsby",
            text = "Qui a écrit le roman « Gatsby le Magnifique » ?",
            options = listOf("Ernest Hemingway", "John Steinbeck", "Francis Scott Fitzgerald", "William Faulkner"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Publié en 1925, Gatsby le Magnifique est l'œuvre la plus célèbre de F. Scott Fitzgerald.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_tour_pise_ville",
            title = "La tour penchée",
            text = "Dans quelle ville italienne se trouve la célèbre tour penchée ?",
            options = listOf("Florence", "Pise", "Sienne", "Gênes"),
            correctIndex = 1,
            rating = 700,
            explanation = "La tour penchée est le campanile de la cathédrale de Pise, en Toscane.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_risotto_origine",
            title = "Origine du risotto",
            text = "Le risotto est une spécialité culinaire traditionnellement associée à quel pays ?",
            options = listOf("France", "Espagne", "Italie", "Grèce"),
            correctIndex = 2,
            rating = 800,
            explanation = "Le risotto est un plat emblématique de la cuisine italienne, particulièrement du nord du pays.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_branly_quai_nom",
            title = "Musée du quai Branly",
            text = "Dans quelle ville se trouve le musée du quai Branly - Jacques Chirac ?",
            options = listOf("Lyon", "Marseille", "Paris", "Toulouse"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Le musée du quai Branly est situé à Paris et est consacré aux arts et civilisations d'Afrique, d'Asie, d'Océanie et des Amériques.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_quatre_saisons_compositeur",
            title = "Les Quatre Saisons",
            text = "Quel compositeur a écrit le cycle de concertos « Les Quatre Saisons » ?",
            options = listOf("Jean-Sébastien Bach", "Antonio Vivaldi", "Georg Friedrich Haendel", "Joseph Haydn"),
            correctIndex = 1,
            rating = 900,
            explanation = "Antonio Vivaldi composa Les Quatre Saisons au XVIIIe siècle. Cette œuvre reste l'une des plus populaires du répertoire classique.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_calligraphie_japonaise",
            title = "Art de l'écriture",
            text = "Comment appelle-t-on traditionnellement l'art japonais de la calligraphie ?",
            options = listOf("Ikebana", "Origami", "Shodō", "Nō"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Le Shodō est l'art japonais de la calligraphie, pratiqué avec pinceau et encre.",
            category = Category.ART_ET_CULTURE
        ),

        Question(
            id = "art_mascarpone_tiramisu",
            title = "Ingrédient du tiramisu",
            text = "Quel fromage est traditionnellement utilisé dans le tiramisu ?",
            options = listOf("Ricotta", "Mozzarella", "Mascarpone", "Gorgonzola"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Le mascarpone est l'ingrédient emblématique du tiramisu, dessert italien mondialement connu.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_volleyball_joueurs_terrain",
            title = "Joueurs au volley-ball",
            text = "Combien de joueurs d'une même équipe sont présents sur le terrain en volley-ball ?",
            options = listOf("5", "6", "7", "8"),
            correctIndex = 1,
            rating = 700,
            explanation = "Au volley-ball, chaque équipe aligne six joueurs sur le terrain : trois à l'avant et trois à l'arrière.",
            category = Category.SPORTS
        ),

        Question(
            id = "spo_aviron_bord",
            title = "Discipline nautique",
            text = "Dans quel sport utilise-t-on des avirons pour propulser une embarcation ?",
            options = listOf("Canoë-kayak", "Voile", "Aviron", "Surf"),
            correctIndex = 2,
            rating = 650,
            explanation = "L'aviron est un sport où les athlètes propulsent leur embarcation à l'aide d'avirons.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_waterpolo_but",
            title = "Marquer au water-polo",
            text = "Quel est l'objectif principal au water-polo ?",
            options = listOf("Faire couler le ballon", "Marquer des buts", "Traverser la piscine", "Garder le ballon sous l'eau"),
            correctIndex = 1,
            rating = 700,
            explanation = "Comme dans de nombreux sports collectifs, l'objectif est de marquer plus de buts que l'équipe adverse.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_fleuret_surface_valable",
            title = "Surface valable au fleuret",
            text = "En escrime, quelle zone constitue la surface valable au fleuret ?",
            options = listOf("Tout le corps", "Le tronc uniquement", "Les bras uniquement", "La tête uniquement"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Au fleuret, seules les touches portées sur le tronc sont considérées comme valables.",
            category = Category.SPORTS
        ),

        Question(
            id = "spo_gymnastique_agres",
            title = "Agrès de gymnastique",
            text = "Le cheval d'arçons est utilisé dans quelle discipline ?",
            options = listOf("Athlétisme", "Gymnastique artistique", "Patinage artistique", "Trampoline"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Le cheval d'arçons est l'un des agrès emblématiques de la gymnastique artistique masculine.",
            category = Category.SPORTS
        ),

        Question(
            id = "spo_rugby_drop",
            title = "Le drop",
            text = "Dans quel sport réalise-t-on un drop pour marquer des points ?",
            options = listOf("Football américain uniquement", "Rugby", "Handball", "Hockey sur gazon"),
            correctIndex = 1,
            rating = 850,
            explanation = "Au rugby, un drop consiste à frapper le ballon du pied après un rebond au sol afin de marquer des points.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_sherlock_adresse",
            title = "Adresse de Sherlock Holmes",
            text = "À quelle adresse fictive habite Sherlock Holmes dans les récits les plus célèbres ?",
            options = listOf("221B Baker Street", "10 Downing Street", "12 Grimmauld Place", "742 Evergreen Terrace"),
            correctIndex = 0,
            rating = 950,
            explanation = "Sherlock Holmes habite au 221B Baker Street à Londres, adresse devenue mondialement célèbre grâce aux romans d'Arthur Conan Doyle.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_queen_bohemian_rhapsody",
            title = "Bohemian Rhapsody",
            text = "Quel groupe a interprété la chanson « Bohemian Rhapsody » ?",
            options = listOf("The Rolling Stones", "Queen", "Pink Floyd", "The Who"),
            correctIndex = 1,
            rating = 700,
            explanation = "Bohemian Rhapsody est l'un des plus grands succès du groupe britannique Queen.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_jurassic_park_createur",
            title = "Créateur de Jurassic Park",
            text = "Qui a réalisé le film Jurassic Park sorti en 1993 ?",
            options = listOf("James Cameron", "Steven Spielberg", "George Lucas", "Ridley Scott"),
            correctIndex = 1,
            rating = 900,
            explanation = "Steven Spielberg a réalisé Jurassic Park, film qui a marqué l'histoire des effets spéciaux.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_game_thrones_trone",
            title = "Le Trône de Fer",
            text = "Dans Game of Thrones, de quoi est principalement composé le Trône de Fer ?",
            options = listOf("Boucliers", "Lances", "Épées", "Haches"),
            correctIndex = 2,
            rating = 1000,
            explanation = "Selon la légende de la saga, le Trône de Fer a été forgé à partir des épées des ennemis vaincus.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_u2_origine",
            title = "Origine de U2",
            text = "De quel pays est originaire le groupe U2 ?",
            options = listOf("Royaume-Uni", "Irlande", "Australie", "Canada"),
            correctIndex = 1,
            rating = 950,
            explanation = "U2 est un groupe de rock irlandais formé à Dublin à la fin des années 1970.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_toy_story_cowboy",
            title = "Le cowboy de Toy Story",
            text = "Comment s'appelle le personnage cowboy principal de Toy Story ?",
            options = listOf("Buzz", "Jessie", "Woody", "Rex"),
            correctIndex = 2,
            rating = 700,
            explanation = "Woody est le cowboy et chef naturel du groupe de jouets dans la saga Toy Story.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_friends_soeur_ross",
            title = "La sœur de Ross",
            text = "Dans la série Friends, comment s'appelle la sœur de Ross Geller ?",
            options = listOf("Phoebe", "Rachel", "Monica", "Janice"),
            correctIndex = 2,
            rating = 850,
            explanation = "Monica Geller est la sœur de Ross. Les deux personnages font partie du groupe central de Friends.",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "div_nirvana_chanteur",
            title = "Chanteur de Nirvana",
            text = "Qui était le chanteur et guitariste du groupe Nirvana ?",
            options = listOf("Dave Grohl", "Kurt Cobain", "Eddie Vedder", "Chris Cornell"),
            correctIndex = 1,
            rating = 950,
            explanation = "Kurt Cobain était le chanteur et guitariste de Nirvana, groupe phare du grunge ; Dave Grohl en était le batteur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_daft_punk_pays",
            title = "Origine de Daft Punk",
            text = "De quel pays est originaire le duo électronique Daft Punk ?",
            options = listOf("Royaume-Uni", "France", "États-Unis", "Allemagne"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Daft Punk, formé par Thomas Bangalter et Guy-Manuel de Homem-Christo, est un duo français.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_rolling_stones_logo",
            title = "Le logo à la langue",
            text = "Quel groupe de rock a pour emblème une bouche ouverte avec une langue tirée ?",
            options = listOf("The Beatles", "Queen", "The Rolling Stones", "The Who"),
            correctIndex = 2,
            rating = 950,
            explanation = "Le logo de la bouche et de la langue tirée est l'emblème des Rolling Stones, apparu en 1971.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_acdc_pays",
            title = "Origine d'AC/DC",
            text = "De quel pays est originaire le groupe de hard rock AC/DC ?",
            options = listOf("Royaume-Uni", "États-Unis", "Australie", "Allemagne"),
            correctIndex = 2,
            rating = 1150,
            explanation = "AC/DC a été fondé à Sydney, en Australie, en 1973 par les frères Young.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_indiana_jones_acteur",
            title = "L'acteur d'Indiana Jones",
            text = "Quel acteur incarne Indiana Jones dans la saga de films d'aventure ?",
            options = listOf("Tom Hanks", "Harrison Ford", "Mel Gibson", "Bruce Willis"),
            correctIndex = 1,
            rating = 850,
            explanation = "Harrison Ford interprète l'archéologue Indiana Jones depuis « Les Aventuriers de l'arche perdue » (1981).",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "spo_carton_rouge",
            title = "Le carton rouge",
            text = "Au football, que signifie un carton rouge brandi par l'arbitre ?",
            options = listOf("Un simple avertissement", "L'exclusion du joueur", "Un penalty accordé", "Un changement obligatoire"),
            correctIndex = 1,
            rating = 700,
            explanation = "Le carton rouge entraîne l'exclusion immédiate du joueur, qui ne peut pas être remplacé : son équipe joue en infériorité numérique.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_bassin_olympique_longueur",
            title = "Longueur d'un bassin olympique",
            text = "Quelle est la longueur d'un bassin de natation olympique ?",
            options = listOf("25 mètres", "50 mètres", "100 mètres", "33 mètres"),
            correctIndex = 1,
            rating = 1000,
            explanation = "Un bassin olympique mesure 50 mètres de long ; les bassins de 25 mètres sont dits semi-olympiques.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_boxe_round_duree",
            title = "Durée d'un round de boxe",
            text = "Combien de temps dure un round en boxe anglaise professionnelle ?",
            options = listOf("1 minute", "2 minutes", "3 minutes", "5 minutes"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Un round dure 3 minutes, suivi d'une minute de repos avant la reprise suivante.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_escrime_armes",
            title = "Les armes de l'escrime",
            text = "Combien d'armes différentes sont utilisées en escrime olympique ?",
            options = listOf("2", "3", "4", "5"),
            correctIndex = 1,
            rating = 1300,
            explanation = "L'escrime olympique se pratique avec trois armes : le fleuret, l'épée et le sabre.",
            category = Category.SPORTS
        ),
        Question(
            id = "art_van_gogh_oreille",
            title = "Le peintre à l'oreille coupée",
            text = "Quel peintre s'est mutilé une partie de l'oreille en 1888 ?",
            options = listOf("Claude Monet", "Paul Gauguin", "Vincent van Gogh", "Paul Cézanne"),
            correctIndex = 2,
            rating = 1050,
            explanation = "Vincent van Gogh se trancha une partie de l'oreille gauche lors d'une crise à Arles, en décembre 1888.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_jazz_origine",
            title = "Berceau du jazz",
            text = "Dans quelle ville américaine le jazz est-il né au début du XXe siècle ?",
            options = listOf("Chicago", "La Nouvelle-Orléans", "New York", "Détroit"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Le jazz est né à La Nouvelle-Orléans, creuset des cultures africaines, créoles et européennes.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_lac_cygnes_compositeur",
            title = "Compositeur du Lac des cygnes",
            text = "Qui a composé le ballet « Le Lac des cygnes » ?",
            options = listOf("Piotr Tchaïkovski", "Igor Stravinsky", "Sergueï Prokofiev", "Claude Debussy"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Le Lac des cygnes a été composé par Piotr Ilitch Tchaïkovski et créé en 1877.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "sci_diamant_carbone",
            title = "Composition du diamant",
            text = "Le diamant est une forme cristalline de quel élément chimique ?",
            options = listOf("Le silicium", "Le carbone", "Le calcium", "Le soufre"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Le diamant est composé uniquement de carbone, dont les atomes forment une structure cristalline extrêmement dure.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_femur_os_long",
            title = "L'os le plus long",
            text = "Quel est l'os le plus long du corps humain ?",
            options = listOf("Le tibia", "L'humérus", "Le fémur", "Le radius"),
            correctIndex = 2,
            rating = 900,
            explanation = "Le fémur, l'os de la cuisse, est le plus long et l'un des plus solides du squelette humain.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_globules_rouges_role",
            title = "Rôle des globules rouges",
            text = "Quel est le rôle principal des globules rouges dans le sang ?",
            options = listOf("Combattre les infections", "Transporter l'oxygène", "Coaguler le sang", "Produire des hormones"),
            correctIndex = 1,
            rating = 950,
            explanation = "Les globules rouges transportent l'oxygène des poumons vers les organes grâce à l'hémoglobine.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "hist_revolution_russe_1917",
            title = "La révolution d'Octobre",
            text = "En quelle année a eu lieu la révolution russe d'Octobre menée par les bolcheviks ?",
            options = listOf("1905", "1917", "1922", "1929"),
            correctIndex = 1,
            rating = 1350,
            explanation = "La révolution d'Octobre 1917 porta les bolcheviks de Lénine au pouvoir et conduisit à la création de l'URSS en 1922.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_plus_petit_os",
            title = "Le plus petit os",
            text = "Quel est le plus petit os du corps humain ?",
            options = listOf("L'étrier", "La clavicule", "La rotule", "Le radius"),
            correctIndex = 0,
            rating = 1350,
            explanation = "L'étrier, situé dans l'oreille moyenne, est le plus petit os du corps humain : il mesure environ 3 millimètres et participe à la transmission du son.",
            category = Category.SCIENCES_ET_NATURE
        ),

        // ── Géographie : montée à 120 (moyennes + 1 difficile) ──
        Question(
            id = "geo_capitale_maroc",
            tags = listOf("capitale"),
            title = "Capitale du Maroc",
            text = "Quelle est la capitale du Maroc ?",
            options = listOf("Casablanca", "Marrakech", "Rabat", "Fès"),
            correctIndex = 2,
            rating = 1150,
            explanation = "La capitale du Maroc est Rabat ; Casablanca, plus peuplée, en est la capitale économique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_turquie",
            tags = listOf("capitale"),
            title = "Capitale de la Turquie",
            text = "Quelle est la capitale de la Turquie ?",
            options = listOf("Ankara", "Istanbul", "Izmir", "Antalya"),
            correctIndex = 0,
            rating = 1100,
            explanation = "Depuis 1923, la capitale de la Turquie est Ankara, et non Istanbul qui demeure la plus grande ville du pays.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_bresil",
            tags = listOf("capitale"),
            title = "Capitale du Brésil",
            text = "Quelle est la capitale du Brésil ?",
            options = listOf("Rio de Janeiro", "Brasília", "São Paulo", "Salvador"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Brasília, ville construite de toutes pièces et inaugurée en 1960, est la capitale du Brésil.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grande_ile",
            title = "La plus grande île du monde",
            text = "Quelle est la plus grande île du monde ?",
            options = listOf("L'Australie", "Madagascar", "Le Groenland", "Bornéo"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le Groenland est la plus grande île du monde ; l'Australie, plus vaste encore, est considérée comme un continent.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_desert",
            title = "Le plus grand désert du monde",
            text = "Quel est le plus grand désert du monde ?",
            options = listOf("L'Antarctique", "Le Sahara", "Le désert de Gobi", "Le désert d'Arabie"),
            correctIndex = 0,
            rating = 1400,
            explanation = "Le plus grand désert du monde est l'Antarctique, un désert froid défini par ses très faibles précipitations. Le Sahara n'est que le plus grand désert chaud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_mer_morte_pays",
            title = "Les rives de la mer Morte",
            text = "Quels pays bordent la mer Morte ?",
            options = listOf("Israël et l'Égypte", "La Jordanie et la Syrie", "Israël et la Jordanie", "Le Liban et Israël"),
            correctIndex = 2,
            rating = 1250,
            explanation = "La mer Morte est bordée par Israël et la Jordanie ; sa surface est le point émergé le plus bas de la Terre.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_pays_afrique",
            title = "Le plus grand pays d'Afrique",
            text = "Quel est le plus grand pays d'Afrique par sa superficie ?",
            options = listOf("L'Algérie", "Le Soudan", "La République démocratique du Congo", "Le Tchad"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Depuis la partition du Soudan en 2011, l'Algérie est le plus grand pays d'Afrique par sa superficie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_lac_afrique",
            title = "Le plus grand lac d'Afrique",
            text = "Quel est le plus grand lac d'Afrique par sa superficie ?",
            options = listOf("Le lac Tanganyika", "Le lac Malawi", "Le lac Victoria", "Le lac Tchad"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Le lac Victoria est le plus grand lac d'Afrique par sa superficie ; le lac Tanganyika est, lui, le plus profond du continent.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_grand_archipel",
            title = "Le plus grand archipel du monde",
            text = "Quel pays forme le plus grand archipel du monde ?",
            options = listOf("Les Philippines", "Le Japon", "L'Indonésie", "La Grèce"),
            correctIndex = 2,
            rating = 1300,
            explanation = "L'Indonésie est le plus grand archipel du monde, avec plus de 17 000 îles.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_andes_chaine",
            title = "La plus longue chaîne de montagnes",
            text = "Quelle est la plus longue chaîne de montagnes émergée du monde ?",
            options = listOf("L'Himalaya", "La cordillère des Andes", "Les Rocheuses", "L'Oural"),
            correctIndex = 1,
            rating = 1250,
            explanation = "La cordillère des Andes longe l'ouest de l'Amérique du Sud sur environ 7 000 km : c'est la plus longue chaîne de montagnes émergée.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_plus_long_fleuve_asie",
            title = "Le plus long fleuve d'Asie",
            text = "Quel est le plus long fleuve d'Asie ?",
            options = listOf("Le Gange", "Le Mékong", "Le Yangtsé", "L'Indus"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Le Yangtsé (Chang Jiang), long d'environ 6 300 km, est le plus long fleuve d'Asie et le troisième du monde.",
            category = Category.GEOGRAPHIE
        ),

        // ── Histoire : montée à 120 (moyennes + 2 difficiles) ──
        Question(
            id = "hist_revolution_industrielle",
            title = "Berceau de la révolution industrielle",
            text = "Dans quel pays la révolution industrielle a-t-elle débuté à la fin du XVIIIe siècle ?",
            options = listOf("La France", "Le Royaume-Uni", "L'Allemagne", "Les États-Unis"),
            correctIndex = 1,
            rating = 1100,
            explanation = "La révolution industrielle débuta au Royaume-Uni à la fin du XVIIIe siècle, portée par la machine à vapeur et l'industrie textile.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premiere_guerre_fin",
            title = "Fin de la Première Guerre mondiale",
            text = "En quelle année s'est terminée la Première Guerre mondiale ?",
            options = listOf("1916", "1918", "1920", "1922"),
            correctIndex = 1,
            rating = 1100,
            explanation = "La Première Guerre mondiale s'acheva le 11 novembre 1918 avec la signature de l'armistice à Rethondes.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premier_empereur_romain",
            title = "Le premier empereur romain",
            text = "Qui fut le premier empereur romain ?",
            options = listOf("Jules César", "Auguste", "Néron", "Constantin"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Auguste (Octave), petit-neveu de Jules César, devint le premier empereur romain en 27 av. J.-C. César, lui, ne porta jamais ce titre.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_crise_cuba",
            title = "La crise de 1962",
            text = "En 1962, quelle crise faillit déclencher une guerre nucléaire entre les États-Unis et l'URSS ?",
            options = listOf("La crise de Suez", "La crise des missiles de Cuba", "La crise de Berlin", "La guerre de Corée"),
            correctIndex = 1,
            rating = 1350,
            explanation = "La crise des missiles de Cuba, en octobre 1962, opposa les États-Unis et l'URSS au sujet de missiles soviétiques déployés à Cuba.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_independance_usa",
            title = "Indépendance des États-Unis",
            text = "En quelle année les États-Unis ont-ils déclaré leur indépendance ?",
            options = listOf("1776", "1783", "1789", "1791"),
            correctIndex = 0,
            rating = 1150,
            explanation = "La Déclaration d'indépendance des États-Unis fut adoptée le 4 juillet 1776.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_guerre_secession",
            title = "La guerre de Sécession",
            text = "La guerre de Sécession (1861-1865) a opposé quelles régions des États-Unis ?",
            options = listOf("L'Est et l'Ouest", "Le Nord et le Sud", "Les villes et les campagnes", "Le Texas et la Californie"),
            correctIndex = 1,
            rating = 1200,
            explanation = "La guerre de Sécession opposa les États du Nord (l'Union) aux États esclavagistes du Sud (la Confédération).",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_mur_berlin_construction",
            title = "Construction du mur de Berlin",
            text = "En quelle année le mur de Berlin a-t-il été construit ?",
            options = listOf("1949", "1953", "1961", "1968"),
            correctIndex = 2,
            rating = 1300,
            explanation = "Le mur de Berlin fut érigé en 1961 par la RDA pour empêcher les départs vers l'Ouest ; il tomba en 1989.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_ecriture_cuneiforme",
            title = "Inventeurs de l'écriture cunéiforme",
            text = "Quelle civilisation est créditée de l'invention de l'écriture cunéiforme ?",
            options = listOf("Les Égyptiens", "Les Sumériens", "Les Phéniciens", "Les Grecs"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Les Sumériens, en Mésopotamie, inventèrent l'écriture cunéiforme vers 3300 av. J.-C., l'une des plus anciennes écritures connues.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_toutankhamon_carter",
            title = "Découvreur de Toutânkhamon",
            text = "Qui a découvert le tombeau de Toutânkhamon en 1922 ?",
            options = listOf("Jean-François Champollion", "Howard Carter", "Heinrich Schliemann", "Auguste Mariette"),
            correctIndex = 1,
            rating = 1600,
            explanation = "L'archéologue britannique Howard Carter découvrit le tombeau quasi intact de Toutânkhamon dans la Vallée des Rois en 1922.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_chute_rome_occident",
            title = "Chute de l'Empire romain d'Occident",
            text = "En quelle année l'Empire romain d'Occident s'est-il effondré ?",
            options = listOf("410", "476", "527", "622"),
            correctIndex = 1,
            rating = 1750,
            explanation = "L'Empire romain d'Occident prit fin en 476, lorsque le chef Odoacre déposa le dernier empereur, Romulus Augustule.",
            category = Category.HISTOIRE
        ),

        // ── Sciences & Nature : montée à 120 (priorité aux difficiles) ──
        Question(
            id = "sci_donneur_universel",
            title = "Le donneur universel",
            text = "Quel groupe sanguin est considéré comme « donneur universel » ?",
            options = listOf("Le groupe AB+", "Le groupe O-", "Le groupe A+", "Le groupe B-"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Le groupe O négatif est le donneur universel : ses globules rouges peuvent être transfusés à presque tous les receveurs.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_plus_petite_planete",
            title = "La plus petite planète",
            text = "Quelle est la plus petite planète du système solaire ?",
            options = listOf("Mars", "Mercure", "Vénus", "Neptune"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Mercure est la plus petite planète du système solaire ; Pluton, plus petite encore, est classée planète naine depuis 2006.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_insecte_pattes",
            title = "Les pattes des insectes",
            text = "Combien de pattes possède un insecte ?",
            options = listOf("4", "6", "8", "10"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Les insectes possèdent six pattes ; les animaux à huit pattes, comme les araignées, sont des arachnides.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_fission_nucleaire",
            title = "Casser un noyau atomique",
            text = "Quel phénomène libère de l'énergie en cassant le noyau d'un atome lourd ?",
            options = listOf("La fusion nucléaire", "La fission nucléaire", "La combustion", "L'électrolyse"),
            correctIndex = 1,
            rating = 1600,
            explanation = "La fission nucléaire libère de l'énergie en cassant le noyau d'un atome lourd comme l'uranium : c'est le principe des centrales nucléaires actuelles.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_adn_bases",
            title = "Les bases de l'ADN",
            text = "Sur combien de bases azotées différentes repose le code de l'ADN ?",
            options = listOf("2", "3", "4", "5"),
            correctIndex = 2,
            rating = 1650,
            explanation = "L'ADN repose sur quatre bases azotées : adénine (A), thymine (T), guanine (G) et cytosine (C).",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_mendeleiev",
            title = "Le tableau périodique",
            text = "Quel chimiste a conçu le tableau périodique des éléments ?",
            options = listOf("Antoine Lavoisier", "Dmitri Mendeleïev", "Niels Bohr", "Marie Curie"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Le chimiste russe Dmitri Mendeleïev publia en 1869 la première version du tableau périodique des éléments.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_zero_absolu",
            title = "Le zéro absolu",
            text = "À quelle température correspond approximativement le zéro absolu ?",
            options = listOf("0 °C", "-100 °C", "-273 °C", "-460 °C"),
            correctIndex = 2,
            rating = 1700,
            explanation = "Le zéro absolu, température la plus basse théoriquement possible, vaut environ -273,15 °C, soit 0 kelvin.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_plaques_tectoniques",
            title = "Les plaques de la croûte terrestre",
            text = "Comment appelle-t-on les vastes fragments mobiles de la croûte terrestre ?",
            options = listOf("Les plaques tectoniques", "Les strates", "Les failles", "Les massifs"),
            correctIndex = 0,
            rating = 1500,
            explanation = "La croûte terrestre est découpée en plaques tectoniques, dont les mouvements provoquent séismes et formation des montagnes.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_relativite_einstein",
            title = "La théorie de la relativité",
            text = "Quel scientifique a formulé la théorie de la relativité ?",
            options = listOf("Isaac Newton", "Albert Einstein", "Niels Bohr", "Galilée"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Albert Einstein formula la relativité restreinte en 1905, puis la relativité générale en 1915.",
            category = Category.SCIENCES_ET_NATURE
        ),

        // ── Art & Culture : montée à 120 (priorité aux difficiles) ──
        Question(
            id = "art_dumas_mousquetaires",
            title = "Auteur des Trois Mousquetaires",
            text = "Qui a écrit « Les Trois Mousquetaires » ?",
            options = listOf("Victor Hugo", "Alexandre Dumas", "Jules Verne", "Émile Zola"),
            correctIndex = 1,
            rating = 1200,
            explanation = "« Les Trois Mousquetaires » (1844) est un roman d'Alexandre Dumas, également auteur du « Comte de Monte-Cristo ».",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_proust_recherche",
            title = "À la recherche du temps perdu",
            text = "Qui a écrit « À la recherche du temps perdu » ?",
            options = listOf("André Gide", "Marcel Proust", "Albert Camus", "Stendhal"),
            correctIndex = 1,
            rating = 1300,
            explanation = "« À la recherche du temps perdu », vaste cycle romanesque en sept tomes, est l'œuvre de Marcel Proust.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_botticelli_venus",
            title = "La Naissance de Vénus",
            text = "Quel peintre a réalisé « La Naissance de Vénus » ?",
            options = listOf("Sandro Botticelli", "Raphaël", "Titien", "Le Caravage"),
            correctIndex = 0,
            rating = 1350,
            explanation = "« La Naissance de Vénus », peinte vers 1485, est une œuvre de Sandro Botticelli conservée à Florence.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_warhol_campbell",
            title = "Les boîtes de soupe Campbell",
            text = "Quel artiste est célèbre pour ses sérigraphies de boîtes de soupe Campbell ?",
            options = listOf("Jackson Pollock", "Andy Warhol", "Salvador Dalí", "Keith Haring"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Andy Warhol, figure majeure du pop art, est célèbre pour ses sérigraphies de boîtes de soupe Campbell et de Marilyn Monroe.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_dante_divine_comedie",
            title = "Auteur de la Divine Comédie",
            text = "Qui a écrit « La Divine Comédie » ?",
            options = listOf("Pétrarque", "Dante Alighieri", "Boccace", "Virgile"),
            correctIndex = 1,
            rating = 1500,
            explanation = "« La Divine Comédie », écrite au début du XIVe siècle, est l'œuvre majeure de Dante Alighieri.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_kafka_metamorphose",
            title = "Auteur de La Métamorphose",
            text = "Qui a écrit la nouvelle « La Métamorphose » ?",
            options = listOf("Thomas Mann", "Franz Kafka", "Hermann Hesse", "Stefan Zweig"),
            correctIndex = 1,
            rating = 1550,
            explanation = "« La Métamorphose » (1915), où un homme se réveille changé en insecte, est une nouvelle de Franz Kafka.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_klimt_baiser",
            title = "Le peintre du Baiser",
            text = "Quel peintre autrichien a réalisé « Le Baiser », tableau recouvert de feuilles d'or ?",
            options = listOf("Egon Schiele", "Gustav Klimt", "Edvard Munch", "Paul Klee"),
            correctIndex = 1,
            rating = 1650,
            explanation = "« Le Baiser » est l'œuvre la plus célèbre du peintre autrichien Gustav Klimt, réalisée durant sa « période dorée ».",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_rossini_barbier",
            title = "Compositeur du Barbier de Séville",
            text = "Qui a composé l'opéra « Le Barbier de Séville » ?",
            options = listOf("Giuseppe Verdi", "Gioachino Rossini", "Giacomo Puccini", "Gaetano Donizetti"),
            correctIndex = 1,
            rating = 1600,
            explanation = "« Le Barbier de Séville » (1816) est un opéra-bouffe de Gioachino Rossini.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_beethoven_symphonies",
            title = "Les symphonies de Beethoven",
            text = "Combien de symphonies Ludwig van Beethoven a-t-il composées ?",
            options = listOf("5", "7", "9", "12"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Beethoven a composé neuf symphonies ; la Neuvième contient le célèbre « Hymne à la joie ».",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_bartholdi_liberte",
            title = "Sculpteur de la statue de la Liberté",
            text = "Quel sculpteur français a conçu la statue de la Liberté ?",
            options = listOf("Gustave Eiffel", "Auguste Bartholdi", "Auguste Rodin", "Camille Claudel"),
            correctIndex = 1,
            rating = 1550,
            explanation = "La statue de la Liberté fut conçue par le sculpteur Auguste Bartholdi ; sa structure interne fut réalisée par Gustave Eiffel.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_surrealisme_breton",
            title = "Le mouvement d'André Breton",
            text = "Quel mouvement artistique André Breton a-t-il théorisé en 1924 ?",
            options = listOf("Le surréalisme", "Le cubisme", "Le dadaïsme", "L'expressionnisme"),
            correctIndex = 0,
            rating = 1500,
            explanation = "André Breton publia le « Manifeste du surréalisme » en 1924, fondant officiellement le mouvement.",
            category = Category.ART_ET_CULTURE
        ),

        // ── Sports : montée à 120 (priorité aux moyennes) ──
        Question(
            id = "spo_jo_anneaux",
            title = "Les anneaux olympiques",
            text = "Combien d'anneaux compte le drapeau olympique ?",
            options = listOf("4", "5", "6", "7"),
            correctIndex = 1,
            rating = 1050,
            explanation = "Le drapeau olympique compte cinq anneaux entrelacés, symbolisant l'union des cinq continents.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_rugby_xv_joueurs",
            title = "Joueurs au rugby à XV",
            text = "Combien de joueurs compte une équipe de rugby à XV sur le terrain ?",
            options = listOf("11", "13", "15", "18"),
            correctIndex = 2,
            rating = 1100,
            explanation = "Le rugby à XV aligne quinze joueurs par équipe ; le rugby à XIII en aligne treize.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_football_duree_match",
            title = "Durée d'un match de football",
            text = "Quelle est la durée réglementaire d'un match de football ?",
            options = listOf("60 minutes", "80 minutes", "90 minutes", "120 minutes"),
            correctIndex = 2,
            rating = 1150,
            explanation = "Un match de football dure 90 minutes, réparties en deux mi-temps de 45 minutes.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tennis_score_apres_30",
            title = "Le décompte au tennis",
            text = "Au tennis, quel score suit le « 30 » dans un jeu ?",
            options = listOf("35", "40", "45", "50"),
            correctIndex = 1,
            rating = 1100,
            explanation = "Dans un jeu de tennis, la séquence de points est 15, 30, 40, puis jeu gagné.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_giro_italie",
            title = "Le grand tour d'Italie",
            text = "Comment s'appelle le grand tour cycliste d'Italie ?",
            options = listOf("La Vuelta", "Le Giro", "Paris-Roubaix", "Le Tour des Flandres"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Le grand tour cycliste d'Italie est le Giro (Giro d'Italia), l'un des trois grands tours avec le Tour de France et la Vuelta.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_tour_arrivee_champs",
            title = "Arrivée du Tour de France",
            text = "Sur quelle avenue le Tour de France s'achève-t-il traditionnellement ?",
            options = listOf("Les Champs-Élysées", "La Canebière", "La Promenade des Anglais", "Les Grands Boulevards"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Le Tour de France s'achève traditionnellement par une arrivée sur les Champs-Élysées, à Paris.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_echecs_pieces",
            title = "Les pièces aux échecs",
            text = "Avec combien de pièces chaque joueur commence-t-il une partie d'échecs ?",
            options = listOf("8", "12", "16", "20"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Chaque joueur débute avec seize pièces : un roi, une dame, deux tours, deux fous, deux cavaliers et huit pions.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_basket_quart_temps",
            title = "Les quart-temps au basket",
            text = "En combien de quart-temps se joue un match de basket NBA ?",
            options = listOf("2", "3", "4", "5"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Un match de basket NBA se joue en quatre quart-temps de douze minutes.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_boxe_ring_forme",
            title = "La forme d'un ring",
            text = "Quelle est la forme d'un ring de boxe ?",
            options = listOf("Rond", "Carré", "Hexagonal", "Ovale"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Malgré son nom anglais signifiant « anneau », le ring de boxe est de forme carrée.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_devise_olympique",
            title = "La devise olympique",
            text = "Quelle est la devise olympique d'origine, en latin ?",
            options = listOf("Citius, Altius, Fortius", "Veni, Vidi, Vici", "Mens sana in corpore sano", "Per aspera ad astra"),
            correctIndex = 0,
            rating = 1500,
            explanation = "La devise olympique « Citius, Altius, Fortius » signifie « Plus vite, plus haut, plus fort ».",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_vuelta_espagne",
            title = "Le grand tour d'Espagne",
            text = "Comment s'appelle le grand tour cycliste d'Espagne ?",
            options = listOf("Le Giro", "La Vuelta", "Le Tour de Romandie", "La Flèche wallonne"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Le grand tour cycliste d'Espagne est la Vuelta (Vuelta a España).",
            category = Category.SPORTS
        ),

        // ── Divertissement : montée à 120 (priorité moyennes/difficiles) ──
        Question(
            id = "div_elvis_king",
            title = "Le King du rock'n'roll",
            text = "Quel chanteur est surnommé « The King », le roi du rock'n'roll ?",
            options = listOf("Chuck Berry", "Elvis Presley", "Buddy Holly", "Little Richard"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Elvis Presley est surnommé « The King », le roi du rock'n'roll.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_marley_reggae",
            title = "Le genre de Bob Marley",
            text = "Quel genre musical Bob Marley a-t-il popularisé dans le monde ?",
            options = listOf("Le ska", "Le reggae", "Le blues", "Le funk"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Bob Marley a fait connaître le reggae dans le monde entier depuis la Jamaïque.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_titanic_realisateur",
            title = "Réalisateur de Titanic",
            text = "Qui a réalisé le film « Titanic » (1997) ?",
            options = listOf("Steven Spielberg", "James Cameron", "Ridley Scott", "Martin Scorsese"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Le film « Titanic » (1997) a été réalisé par James Cameron, également réalisateur d'« Avatar ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_cannes_palme",
            title = "La récompense de Cannes",
            text = "Quelle récompense suprême est décernée au Festival de Cannes ?",
            options = listOf("L'Ours d'or", "La Palme d'or", "Le Lion d'or", "Le César"),
            correctIndex = 1,
            rating = 1300,
            explanation = "La Palme d'or est la plus haute récompense du Festival de Cannes.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_simpsons_createur",
            title = "Créateur des Simpson",
            text = "Qui a créé la série « Les Simpson » ?",
            options = listOf("Seth MacFarlane", "Matt Groening", "Trey Parker", "Mike Judge"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Matt Groening est le créateur des « Simpson » (depuis 1989) ainsi que de « Futurama ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_spielberg_dents_mer",
            title = "Réalisateur des Dents de la mer",
            text = "Qui a réalisé le film « Les Dents de la mer » ?",
            options = listOf("George Lucas", "Steven Spielberg", "James Cameron", "Ridley Scott"),
            correctIndex = 1,
            rating = 1300,
            explanation = "« Les Dents de la mer » (1975), souvent cité comme le premier blockbuster, a été réalisé par Steven Spielberg.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_pink_floyd_dark_side",
            title = "L'album The Dark Side of the Moon",
            text = "Quel groupe a sorti l'album « The Dark Side of the Moon » ?",
            options = listOf("Led Zeppelin", "Pink Floyd", "The Doors", "Genesis"),
            correctIndex = 1,
            rating = 1550,
            explanation = "« The Dark Side of the Moon » (1973), l'un des albums les plus vendus de l'histoire, est signé Pink Floyd.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_parrain_coppola",
            title = "Réalisateur du Parrain",
            text = "Qui a réalisé le film « Le Parrain » ?",
            options = listOf("Martin Scorsese", "Francis Ford Coppola", "Brian De Palma", "Sergio Leone"),
            correctIndex = 1,
            rating = 1600,
            explanation = "« Le Parrain » (1972) a été réalisé par Francis Ford Coppola, d'après le roman de Mario Puzo.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_disney_blanche_neige",
            title = "Premier long-métrage Disney",
            text = "Quel fut le premier long-métrage d'animation des studios Disney ?",
            options = listOf("Pinocchio", "Blanche-Neige et les Sept Nains", "Fantasia", "Bambi"),
            correctIndex = 1,
            rating = 1500,
            explanation = "« Blanche-Neige et les Sept Nains » (1937) est le premier long-métrage d'animation de Disney.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_kubrick_2001",
            title = "Réalisateur de 2001",
            text = "Qui a réalisé « 2001, l'Odyssée de l'espace » ?",
            options = listOf("Ridley Scott", "Stanley Kubrick", "George Lucas", "Andreï Tarkovski"),
            correctIndex = 1,
            rating = 1650,
            explanation = "« 2001, l'Odyssée de l'espace » (1968) est un film de science-fiction réalisé par Stanley Kubrick.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_capitale_perou",
            tags = listOf("capitale"),
            title = "Capitale du Pérou",
            text = "Quelle est la capitale du Pérou ?",
            options = listOf("Bogotá", "Lima", "Quito", "Santiago"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Lima, fondée par les Espagnols en 1535, est la capitale du Pérou, sur la côte pacifique.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_fosse_mariannes",
            title = "Le point le plus profond des océans",
            text = "Quel est le point le plus profond des océans ?",
            options = listOf("La fosse des Mariannes", "La fosse du Japon", "La fosse de Porto Rico", "La fosse des Tonga"),
            correctIndex = 0,
            rating = 1650,
            explanation = "La fosse des Mariannes, dans l'océan Pacifique, atteint près de 11 000 mètres de profondeur : c'est le point le plus profond connu des océans.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_seconde_guerre_debut",
            title = "Début de la Seconde Guerre mondiale",
            text = "En quelle année a débuté la Seconde Guerre mondiale ?",
            options = listOf("1936", "1939", "1941", "1945"),
            correctIndex = 1,
            rating = 1100,
            explanation = "La Seconde Guerre mondiale débuta en 1939 avec l'invasion de la Pologne par l'Allemagne nazie.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_napoleon_sacre",
            title = "Sacre de Napoléon",
            text = "En quelle année Napoléon Bonaparte s'est-il fait sacrer empereur des Français ?",
            options = listOf("1799", "1804", "1812", "1815"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Napoléon Bonaparte se sacra empereur des Français en 1804, lors d'une cérémonie à Notre-Dame de Paris.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_edit_nantes",
            title = "L'édit de Nantes",
            text = "Quel édit accorda en 1598 la liberté de culte aux protestants français ?",
            options = listOf("L'édit de Nantes", "L'édit de Milan", "L'édit de Fontainebleau", "L'édit de Villers-Cotterêts"),
            correctIndex = 0,
            rating = 1650,
            explanation = "L'édit de Nantes, signé par Henri IV en 1598, accorda des droits aux protestants ; il fut révoqué par Louis XIV en 1685.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_pression_pascal",
            title = "L'unité de pression",
            text = "Quelle est l'unité de mesure de la pression dans le Système international ?",
            options = listOf("Le watt", "Le pascal", "Le joule", "Le newton"),
            correctIndex = 1,
            rating = 1600,
            explanation = "La pression se mesure en pascals (Pa) ; un pascal correspond à un newton par mètre carré.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "div_pong_arcade",
            title = "Un des premiers jeux d'arcade",
            text = "Quel jeu de 1972 est l'un des tout premiers jeux vidéo d'arcade à succès ?",
            options = listOf("Pong", "Space Invaders", "Pac-Man", "Donkey Kong"),
            correctIndex = 0,
            rating = 1600,
            explanation = "« Pong », un jeu de tennis virtuel sorti par Atari en 1972, est l'un des premiers jeux d'arcade à connaître un grand succès.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "geo_mer_est_italie",
            title = "Mer à l'est de l'Italie",
            text = "Quelle mer borde la côte est de l'Italie ?",
            options = listOf("La mer Tyrrhénienne", "La mer Égée", "La mer Adriatique", "La mer Ionienne"),
            correctIndex = 2,
            rating = 1200,
            explanation = "La mer Adriatique sépare la péninsule italienne des Balkans. La mer Tyrrhénienne, elle, borde au contraire la côte ouest de l'Italie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_equateur",
            tags = listOf("capitale"),
            title = "Pays de Quito",
            text = "De quel pays Quito est-elle la capitale ?",
            options = listOf("L'Équateur", "Le Pérou", "La Colombie", "La Bolivie"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Quito, perchée à près de 2 850 m d'altitude dans les Andes, est la capitale de l'Équateur, l'une des plus hautes capitales du monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_aconcagua",
            title = "Plus haut sommet d'Amérique",
            text = "Quel est le plus haut sommet du continent américain ?",
            options = listOf("Le Chimborazo", "Le mont Denali", "L'Aconcagua", "Le mont Logan"),
            correctIndex = 2,
            rating = 1600,
            explanation = "L'Aconcagua, dans les Andes argentines, culmine à 6 961 m : c'est le plus haut sommet des Amériques et de tout l'hémisphère sud.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_detroit_ormuz",
            title = "Détroit du golfe Persique",
            text = "Quel détroit stratégique relie le golfe Persique au golfe d'Oman ?",
            options = listOf("Le détroit de Malacca", "Le détroit d'Ormuz", "Le Bosphore", "Le détroit de Gibraltar"),
            correctIndex = 1,
            rating = 1500,
            explanation = "Le détroit d'Ormuz est un passage majeur du commerce pétrolier mondial : une grande partie du pétrole exporté depuis le golfe Persique y transite.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_desert_atacama",
            title = "Le désert le plus aride",
            text = "Quel désert est considéré comme le plus aride du monde ?",
            options = listOf("Le désert d'Atacama", "Le Sahara", "Le désert de Gobi", "Le Kalahari"),
            correctIndex = 0,
            rating = 1550,
            explanation = "Le désert d'Atacama, au Chili, est l'endroit le plus sec de la planète : certaines de ses zones n'ont pas connu de précipitations significatives pendant des décennies.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_etna_ile",
            title = "Île de l'Etna",
            text = "Sur quelle île italienne se trouve le volcan Etna ?",
            options = listOf("La Sardaigne", "La Corse", "Malte", "La Sicile"),
            correctIndex = 3,
            rating = 1200,
            explanation = "L'Etna, en Sicile, est le plus haut volcan actif d'Europe et l'un des plus actifs au monde.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_hongrie",
            tags = listOf("capitale"),
            title = "Capitale de la Hongrie",
            text = "Quelle est la capitale de la Hongrie ?",
            options = listOf("Budapest", "Vienne", "Prague", "Bucarest"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Budapest, traversée par le Danube, est née de la réunion des villes de Buda et de Pest ; c'est la capitale de la Hongrie.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_grande_barriere_corail",
            title = "Pays de la Grande Barrière",
            text = "Au large de quel pays se trouve la Grande Barrière de corail ?",
            options = listOf("L'Indonésie", "Les Philippines", "L'Australie", "Le Mexique"),
            correctIndex = 2,
            rating = 1250,
            explanation = "La Grande Barrière de corail s'étend sur plus de 2 000 km le long de la côte nord-est de l'Australie ; c'est la plus vaste structure vivante de la planète.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_chutes_niagara",
            title = "Frontière des chutes du Niagara",
            text = "Les chutes du Niagara se situent à la frontière entre les États-Unis et quel pays ?",
            options = listOf("Le Mexique", "Le Groenland", "Cuba", "Le Canada"),
            correctIndex = 3,
            rating = 1200,
            explanation = "Les chutes du Niagara se trouvent à la frontière entre l'État de New York (États-Unis) et la province de l'Ontario (Canada).",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "geo_capitale_coree_sud",
            tags = listOf("capitale"),
            title = "Capitale de la Corée du Sud",
            text = "Quelle est la capitale de la Corée du Sud ?",
            options = listOf("Séoul", "Pyongyang", "Tokyo", "Bangkok"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Séoul est la capitale de la Corée du Sud et l'une des plus grandes agglomérations d'Asie. Pyongyang, elle, est la capitale de la Corée du Nord.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "hist_premier_empereur_chine",
            title = "Premier empereur de Chine",
            text = "Qui fut le premier empereur de la Chine unifiée ?",
            options = listOf("Confucius", "Sun Tzu", "Qin Shi Huang", "Kubilai Khan"),
            correctIndex = 2,
            rating = 1650,
            explanation = "Qin Shi Huang unifia la Chine en 221 av. J.-C. et fonda la dynastie Qin ; on lui doit la célèbre armée de terre cuite découverte près de son mausolée.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_serment_jeu_paume",
            title = "Serment du Jeu de paume",
            text = "En quelle année fut prêté le serment du Jeu de paume ?",
            options = listOf("1789", "1792", "1799", "1804"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Le 20 juin 1789, les députés du tiers état réunis dans la salle du Jeu de paume jurèrent de ne pas se séparer avant d'avoir donné une constitution à la France, épisode fondateur de la Révolution.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_attentat_sarajevo",
            title = "Attentat de Sarajevo",
            text = "Dans quelle ville l'archiduc François-Ferdinand fut-il assassiné en 1914, déclenchant la Première Guerre mondiale ?",
            options = listOf("Vienne", "Sarajevo", "Belgrade", "Berlin"),
            correctIndex = 1,
            rating = 1400,
            explanation = "L'assassinat de l'archiduc François-Ferdinand d'Autriche à Sarajevo, le 28 juin 1914, déclencha l'enchaînement diplomatique qui mena à la Première Guerre mondiale.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_bataille_stalingrad",
            title = "Tournant du front de l'Est",
            text = "Quelle bataille (1942-1943) marqua un tournant majeur sur le front de l'Est pendant la Seconde Guerre mondiale ?",
            options = listOf("La bataille de Verdun", "La bataille de Stalingrad", "Le débarquement de Normandie", "La bataille d'Angleterre"),
            correctIndex = 1,
            rating = 1500,
            explanation = "La bataille de Stalingrad s'acheva en 1943 par la capitulation de la 6e armée allemande ; ce fut un tournant décisif de la guerre sur le front de l'Est.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_kheops_pyramide",
            title = "Pharaon de la grande pyramide",
            text = "Pour quel pharaon la grande pyramide de Gizeh fut-elle édifiée ?",
            options = listOf("Khéops", "Toutânkhamon", "Ramsès II", "Akhenaton"),
            correctIndex = 0,
            rating = 1350,
            explanation = "La grande pyramide de Gizeh fut construite vers 2560 av. J.-C. comme tombeau du pharaon Khéops ; c'est la seule des sept merveilles du monde antique encore debout.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_traite_rome_cee",
            title = "Traité fondateur de la CEE",
            text = "Quel traité signé en 1957 a institué la Communauté économique européenne ?",
            options = listOf("Le traité de Maastricht", "Le traité de Lisbonne", "Le traité de Versailles", "Le traité de Rome"),
            correctIndex = 3,
            rating = 1400,
            explanation = "Le traité de Rome, signé en 1957 par six pays, a créé la Communauté économique européenne (CEE), ancêtre de l'actuelle Union européenne.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_marignan_1515",
            title = "Année de Marignan",
            text = "En quelle année eut lieu la bataille de Marignan, remportée par François Ier ?",
            options = listOf("1453", "1515", "1610", "1492"),
            correctIndex = 1,
            rating = 1300,
            explanation = "La bataille de Marignan, en 1515, fut une victoire de François Ier sur les Suisses au début de son règne, une date restée célèbre dans l'enseignement de l'histoire.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_tordesillas",
            title = "Le traité de Tordesillas",
            text = "Le traité de Tordesillas (1494) partagea le Nouveau Monde entre quels deux pays ?",
            options = listOf("La France et l'Angleterre", "L'Espagne et la France", "L'Espagne et le Portugal", "Le Portugal et les Pays-Bas"),
            correctIndex = 2,
            rating = 1600,
            explanation = "Par le traité de Tordesillas, l'Espagne et le Portugal se partagèrent les terres nouvellement découvertes le long d'une ligne tracée dans l'Atlantique, sous l'arbitrage du pape.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_cesar_ides",
            title = "Les ides de mars",
            text = "Quel homme d'État romain fut assassiné lors des ides de mars, en 44 av. J.-C. ?",
            options = listOf("Auguste", "Néron", "Marc Aurèle", "Jules César"),
            correctIndex = 3,
            rating = 1300,
            explanation = "Jules César fut poignardé au Sénat le 15 mars (les ides de mars) 44 av. J.-C. par un groupe de sénateurs conduit par Brutus et Cassius.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_premiere_croisade",
            title = "Fin de la première croisade",
            text = "Quelle ville les croisés prirent-ils au terme de la première croisade, en 1099 ?",
            options = listOf("Constantinople", "Jérusalem", "Antioche", "Le Caire"),
            correctIndex = 1,
            rating = 1550,
            explanation = "La première croisade s'acheva par la prise de Jérusalem en 1099 et la fondation d'États latins en Orient.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "sci_eclipse_solaire",
            title = "Astre d'une éclipse solaire",
            text = "Lors d'une éclipse solaire, quel astre passe entre la Terre et le Soleil ?",
            options = listOf("La Lune", "Mars", "Vénus", "Jupiter"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Une éclipse solaire se produit lorsque la Lune s'interpose entre la Terre et le Soleil, projetant son ombre sur une partie de la Terre.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_animal_plus_grand",
            title = "Le plus grand animal",
            text = "Quel est le plus grand animal connu ayant jamais existé ?",
            options = listOf("La baleine bleue", "Le diplodocus", "L'éléphant de mer", "Le cachalot"),
            correctIndex = 0,
            rating = 1200,
            explanation = "La baleine bleue peut dépasser 30 m de long et 150 tonnes : c'est le plus grand animal connu de toute l'histoire de la vie, plus massif encore que les plus grands dinosaures.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_organe_insuline",
            title = "Organe producteur d'insuline",
            text = "Quel organe produit l'insuline ?",
            options = listOf("Le foie", "Les reins", "La rate", "Le pancréas"),
            correctIndex = 3,
            rating = 1300,
            explanation = "L'insuline, l'hormone qui régule le taux de sucre dans le sang, est sécrétée par le pancréas. Un défaut de cette production est à l'origine du diabète.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_etoile_proche",
            title = "L'étoile la plus proche",
            text = "Quelle est l'étoile la plus proche du Soleil ?",
            options = listOf("Sirius", "Proxima du Centaure", "Bételgeuse", "L'étoile Polaire"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Proxima du Centaure, située à environ 4,24 années-lumière, est l'étoile la plus proche de notre Soleil.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_atome_noyau",
            title = "Composition du noyau atomique",
            text = "Quelles particules composent le noyau d'un atome ?",
            options = listOf("Les protons et les neutrons", "Les protons et les électrons", "Les neutrons et les électrons", "Uniquement des électrons"),
            correctIndex = 0,
            rating = 1350,
            explanation = "Le noyau atomique est constitué de protons (chargés positivement) et de neutrons (neutres) ; les électrons, eux, gravitent autour du noyau.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_decibel_son",
            title = "Unité du niveau sonore",
            text = "Quelle unité mesure le niveau sonore ?",
            options = listOf("Le hertz", "Le watt", "Le newton", "Le décibel"),
            correctIndex = 3,
            rating = 1250,
            explanation = "Le décibel (dB) mesure l'intensité sonore. Le hertz, lui, mesure la fréquence (la hauteur) d'un son, pas son intensité.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_organe_filtre_sang",
            title = "Organes filtrant le sang",
            text = "Quels organes filtrent le sang pour produire l'urine ?",
            options = listOf("Le foie", "Les reins", "Les poumons", "La rate"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Les reins filtrent le sang en continu, éliminant les déchets et l'excès d'eau sous forme d'urine.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_son_vide",
            title = "Le son dans le vide",
            text = "Pourquoi le son ne peut-il pas se propager dans le vide ?",
            options = listOf("Il est trop rapide", "Il est arrêté par le vide lui-même", "Il a besoin d'un milieu matériel pour se propager", "Il se transforme en lumière"),
            correctIndex = 2,
            rating = 1500,
            explanation = "Le son est une onde mécanique : il a besoin d'un support matériel (air, eau, solide) pour se propager. Dans le vide spatial, faute de matière, aucun son ne peut voyager.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_echelle_richter",
            title = "Mesure des séismes",
            text = "Quelle échelle a été historiquement utilisée pour mesurer la magnitude des séismes ?",
            options = listOf("L'échelle de Beaufort", "L'échelle de Mohs", "L'échelle de Kelvin", "L'échelle de Richter"),
            correctIndex = 3,
            rating = 1500,
            explanation = "L'échelle de Richter mesure la magnitude d'un tremblement de terre. L'échelle de Beaufort concerne la force du vent, et celle de Mohs la dureté des minéraux.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_globules_blancs",
            title = "Rôle des globules blancs",
            text = "Quel est le rôle principal des globules blancs ?",
            options = listOf("Transporter l'oxygène", "Défendre l'organisme contre les infections", "Permettre la coagulation du sang", "Réguler la température"),
            correctIndex = 1,
            rating = 1250,
            explanation = "Les globules blancs (leucocytes) sont les cellules du système immunitaire : ils défendent l'organisme contre les microbes. Le transport de l'oxygène est, lui, assuré par les globules rouges.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "art_jazz_satchmo",
            title = "Le trompettiste « Satchmo »",
            text = "Quel trompettiste de jazz était surnommé « Satchmo » ?",
            options = listOf("Miles Davis", "Dizzy Gillespie", "Louis Armstrong", "Duke Ellington"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Louis Armstrong, surnommé « Satchmo », est l'un des musiciens les plus influents de l'histoire du jazz, connu pour sa trompette et sa voix rauque.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_pyramide_louvre",
            title = "Architecte de la pyramide du Louvre",
            text = "Quel architecte a conçu la pyramide de verre du Louvre ?",
            options = listOf("Ieoh Ming Pei", "Le Corbusier", "Jean Nouvel", "Frank Gehry"),
            correctIndex = 0,
            rating = 1600,
            explanation = "La pyramide du Louvre, inaugurée en 1989, est l'œuvre de l'architecte américain d'origine chinoise Ieoh Ming Pei (I. M. Pei).",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_meninas_velasquez",
            title = "Peintre des Ménines",
            text = "Quel peintre espagnol a réalisé le célèbre tableau « Les Ménines » ?",
            options = listOf("Francisco de Goya", "Diego Vélasquez", "Le Greco", "Joan Miró"),
            correctIndex = 1,
            rating = 1600,
            explanation = "« Les Ménines » (1656), tableau à la composition virtuose et énigmatique, est l'œuvre majeure du peintre espagnol Diego Vélasquez.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_pollock_dripping",
            title = "Le peintre du « dripping »",
            text = "Quel peintre américain est célèbre pour sa technique du « dripping » (projection de peinture sur la toile) ?",
            options = listOf("Andy Warhol", "Mark Rothko", "Jackson Pollock", "Roy Lichtenstein"),
            correctIndex = 2,
            rating = 1550,
            explanation = "Jackson Pollock, figure de l'expressionnisme abstrait, peignait en projetant et faisant couler la peinture sur des toiles posées au sol, technique dite du « dripping ».",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_la_cene",
            title = "Peintre de La Cène",
            text = "Qui a peint la célèbre fresque « La Cène » à Milan ?",
            options = listOf("Léonard de Vinci", "Michel-Ange", "Raphaël", "Le Caravage"),
            correctIndex = 0,
            rating = 1250,
            explanation = "« La Cène », peinte par Léonard de Vinci à la fin du XVe siècle sur un mur du couvent Santa Maria delle Grazie à Milan, représente le dernier repas du Christ avec ses apôtres.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_stradivarius_violon",
            title = "Le luthier des violons",
            text = "Quel célèbre luthier italien a fabriqué des violons réputés parmi les meilleurs au monde ?",
            options = listOf("Antonio Stradivari", "Antonio Vivaldi", "Bartolomeo Cristofori", "Niccolò Paganini"),
            correctIndex = 0,
            rating = 1450,
            explanation = "Antonio Stradivari, actif à Crémone vers 1700, a fabriqué les « stradivarius », violons toujours considérés parmi les plus précieux et recherchés.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_clair_lune_debussy",
            title = "Compositeur de Clair de lune",
            text = "Quel compositeur français a écrit « Clair de lune », extrait de la « Suite bergamasque » ?",
            options = listOf("Maurice Ravel", "Claude Debussy", "Gabriel Fauré", "Erik Satie"),
            correctIndex = 1,
            rating = 1400,
            explanation = "« Clair de lune », l'une des pièces pour piano les plus connues du répertoire, est de Claude Debussy. À ne pas confondre avec la « Sonate au clair de lune » de Beethoven.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_germinal_zola",
            title = "Auteur de Germinal",
            text = "Quel écrivain français est l'auteur du roman « Germinal » ?",
            options = listOf("Victor Hugo", "Honoré de Balzac", "Émile Zola", "Gustave Flaubert"),
            correctIndex = 2,
            rating = 1300,
            explanation = "« Germinal » (1885), qui décrit la condition des mineurs et une grande grève, fait partie de la série des « Rougon-Macquart » d'Émile Zola.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_sacre_printemps",
            title = "Compositeur du Sacre du printemps",
            text = "Quel compositeur est l'auteur du ballet « Le Sacre du printemps » ?",
            options = listOf("Piotr Tchaïkovski", "Sergueï Prokofiev", "Claude Debussy", "Igor Stravinsky"),
            correctIndex = 3,
            rating = 1650,
            explanation = "« Le Sacre du printemps » d'Igor Stravinsky provoqua un scandale lors de sa création à Paris en 1913, par sa musique et sa chorégraphie révolutionnaires.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_messie_haendel",
            title = "Compositeur du Messie",
            text = "Quel compositeur baroque est l'auteur de l'oratorio « Le Messie » et de son célèbre « Alléluia » ?",
            options = listOf("Jean-Sébastien Bach", "Georg Friedrich Haendel", "Antonio Vivaldi", "Henry Purcell"),
            correctIndex = 1,
            rating = 1450,
            explanation = "« Le Messie » (1741), dont est tiré le fameux chœur de l'« Alléluia », est l'œuvre la plus célèbre du compositeur baroque Georg Friedrich Haendel.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "spo_natation_rapide",
            title = "La nage la plus rapide",
            text = "Quelle est la nage la plus rapide en compétition ?",
            options = listOf("La brasse", "Le dos", "Le crawl", "Le papillon"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Le crawl (ou nage libre) est la technique la plus rapide ; c'est pourquoi les nageurs le choisissent presque toujours dans les épreuves de « nage libre ».",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_jo_1896_ville",
            title = "Premiers JO modernes",
            text = "Dans quelle ville se tinrent les premiers Jeux olympiques de l'ère moderne, en 1896 ?",
            options = listOf("Athènes", "Paris", "Londres", "Rome"),
            correctIndex = 0,
            rating = 1500,
            explanation = "Les premiers Jeux olympiques modernes se déroulèrent à Athènes en 1896, en hommage à l'Antiquité grecque, sous l'impulsion de Pierre de Coubertin.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_marathon_bataille",
            title = "Origine du mot marathon",
            text = "De quelle bataille de la Grèce antique le mot « marathon » tire-t-il son origine ?",
            options = listOf("La bataille de Salamine", "La bataille des Thermopyles", "La bataille de Platées", "La bataille de Marathon"),
            correctIndex = 3,
            rating = 1550,
            explanation = "Le mot « marathon » vient de la bataille de Marathon (490 av. J.-C.) : selon la légende, un messager aurait couru jusqu'à Athènes, soit environ 40 km, pour annoncer la victoire.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_basket_inventeur",
            title = "Inventeur du basket-ball",
            text = "Qui a inventé le basket-ball, en 1891 ?",
            options = listOf("Pierre de Coubertin", "James Naismith", "Walter Camp", "Abner Doubleday"),
            correctIndex = 1,
            rating = 1650,
            explanation = "Le basket-ball fut inventé en 1891 par James Naismith, professeur d'éducation physique au Massachusetts, qui accrocha des paniers de pêches comme premières cibles.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_haka_nz",
            title = "Le pays du haka",
            text = "L'équipe nationale de rugby de quel pays exécute le « haka » avant ses matchs ?",
            options = listOf("La Nouvelle-Zélande", "L'Australie", "L'Afrique du Sud", "Les Fidji"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Le haka, danse traditionnelle maorie, est exécuté avant chaque match par les All Blacks, l'équipe de Nouvelle-Zélande.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_golf_birdie",
            title = "Un coup sous le par",
            text = "Au golf, comment appelle-t-on un trou réalisé en un coup de moins que le par ?",
            options = listOf("Un bogey", "Un eagle", "Un par", "Un birdie"),
            correctIndex = 3,
            rating = 1500,
            explanation = "Un « birdie » correspond à un coup de moins que le par. Un coup de plus est un « bogey », et deux coups de moins un « eagle ».",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_f1_maranello",
            title = "L'écurie de Maranello",
            text = "Quelle écurie de Formule 1, basée à Maranello, est la plus ancienne de la discipline ?",
            options = listOf("McLaren", "Ferrari", "Williams", "Renault"),
            correctIndex = 1,
            rating = 1200,
            explanation = "Ferrari, dont l'usine historique se trouve à Maranello en Italie, est la plus ancienne et la plus titrée des écuries de Formule 1.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_super_bowl_sport",
            title = "Le sport du Super Bowl",
            text = "Le Super Bowl est la finale de quel sport ?",
            options = listOf("Le baseball", "Le basket-ball", "Le football américain", "Le hockey sur glace"),
            correctIndex = 2,
            rating = 1200,
            explanation = "Le Super Bowl est la grande finale annuelle de la NFL, la ligue professionnelle de football américain ; c'est l'un des événements sportifs les plus suivis au monde.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_jo_2024_paris",
            title = "Ville hôte des JO 2024",
            text = "Quelle ville a accueilli les Jeux olympiques d'été de 2024 ?",
            options = listOf("Londres", "Paris", "Los Angeles", "Tokyo"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Paris a accueilli les Jeux olympiques d'été de 2024, cent ans après les avoir organisés en 1924.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_paris_roubaix",
            title = "L'Enfer du Nord",
            text = "Quelle course cycliste, célèbre pour ses pavés, est surnommée « l'Enfer du Nord » ?",
            options = listOf("Paris-Nice", "Paris-Roubaix", "Le Tour des Flandres", "Milan-San Remo"),
            correctIndex = 1,
            rating = 1550,
            explanation = "Paris-Roubaix, surnommée « l'Enfer du Nord », est réputée pour ses secteurs pavés qui rendent la course particulièrement éprouvante.",
            category = Category.SPORTS
        ),
        Question(
            id = "div_got_stark_embleme",
            title = "Emblème des Stark",
            text = "Quel animal figure sur le blason de la maison Stark dans « Game of Thrones » ?",
            options = listOf("Le lion", "Le dragon", "Le loup", "Le cerf"),
            correctIndex = 2,
            rating = 1300,
            explanation = "L'emblème de la maison Stark est le loup géant (« direwolf »), accompagné de la devise « Winter is coming ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_intouchables_acteur",
            title = "L'acteur d'Intouchables",
            text = "Quel acteur partage l'affiche du film « Intouchables » avec François Cluzet ?",
            options = listOf("Jamel Debbouze", "Omar Sy", "Dany Boon", "Gad Elmaleh"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Omar Sy interprète Driss aux côtés de François Cluzet dans « Intouchables » (2011), rôle pour lequel il a reçu le César du meilleur acteur.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_gta_studio",
            title = "Studio de Grand Theft Auto",
            text = "Quel studio développe la série de jeux vidéo « Grand Theft Auto » ?",
            options = listOf("Ubisoft", "Electronic Arts", "Activision", "Rockstar Games"),
            correctIndex = 3,
            rating = 1400,
            explanation = "La série « Grand Theft Auto » (GTA) est développée par Rockstar Games ; c'est l'une des franchises de jeux vidéo les plus vendues de l'histoire.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_amelie_poulain_real",
            title = "Réalisateur d'Amélie Poulain",
            text = "Qui a réalisé le film « Le Fabuleux Destin d'Amélie Poulain » ?",
            options = listOf("Luc Besson", "Michel Gondry", "Jean-Pierre Jeunet", "Cédric Klapisch"),
            correctIndex = 2,
            rating = 1400,
            explanation = "« Le Fabuleux Destin d'Amélie Poulain » (2001), avec Audrey Tautou, a été réalisé par Jean-Pierre Jeunet et a connu un immense succès international.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_halo_console",
            title = "La console de Halo",
            text = "Sur quelle marque de consoles la série de jeux « Halo » est-elle d'abord sortie ?",
            options = listOf("Xbox", "PlayStation", "Nintendo", "Sega"),
            correctIndex = 0,
            rating = 1350,
            explanation = "« Halo » est une franchise phare de la Xbox de Microsoft, lancée avec « Halo: Combat Evolved » en 2001.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_dragon_ball_auteur",
            title = "Créateur de Dragon Ball",
            text = "Quel mangaka a créé la série « Dragon Ball » ?",
            options = listOf("Eiichirō Oda", "Masashi Kishimoto", "Osamu Tezuka", "Akira Toriyama"),
            correctIndex = 3,
            rating = 1600,
            explanation = "« Dragon Ball » a été créé par le mangaka japonais Akira Toriyama au milieu des années 1980 ; c'est l'un des mangas les plus influents au monde.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_terminator_acteur",
            title = "L'acteur de Terminator",
            text = "Quel acteur incarne le cyborg dans la saga « Terminator » ?",
            options = listOf("Sylvester Stallone", "Arnold Schwarzenegger", "Bruce Willis", "Jean-Claude Van Damme"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Arnold Schwarzenegger interprète le Terminator, rôle qui a lancé sa carrière au cinéma et popularisé la réplique « I'll be back ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_hitchcock_psychose",
            title = "Réalisateur de Psychose",
            text = "Quel réalisateur, maître du suspense, a tourné « Psychose » (1960) ?",
            options = listOf("Stanley Kubrick", "Orson Welles", "Alfred Hitchcock", "Billy Wilder"),
            correctIndex = 2,
            rating = 1500,
            explanation = "« Psychose » et sa célèbre scène de la douche sont l'œuvre d'Alfred Hitchcock, surnommé « le maître du suspense ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_metallica_genre",
            title = "Le genre de Metallica",
            text = "À quel genre musical appartient le groupe Metallica ?",
            options = listOf("Le reggae", "La country", "Le jazz", "Le heavy metal"),
            correctIndex = 3,
            rating = 1300,
            explanation = "Metallica est l'un des groupes les plus emblématiques du heavy metal (et plus précisément du thrash metal), formé en Californie en 1981.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_god_of_war_heros",
            title = "Le héros de God of War",
            text = "Quel est le nom du héros de la série de jeux vidéo « God of War » ?",
            options = listOf("Master Chief", "Kratos", "Aloy", "Geralt"),
            correctIndex = 1,
            rating = 1400,
            explanation = "Kratos, guerrier spartiate inspiré de la mythologie grecque puis nordique, est le protagoniste de la série « God of War ».",
            category = Category.DIVERTISSEMENT
        ),

        Question(
            id = "art_crime_chatiment_dostoievski",
            title = "Auteur de Crime et Châtiment",
            text = "Quel écrivain russe est l'auteur de « Crime et Châtiment » ?",
            options = listOf("Léon Tolstoï", "Anton Tchekhov", "Fiodor Dostoïevski", "Nicolas Gogol"),
            correctIndex = 2,
            rating = 1500,
            explanation = "« Crime et Châtiment » (1866), qui suit le tourment de l'étudiant Raskolnikov après un meurtre, est l'un des grands romans de Fiodor Dostoïevski.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "art_delacroix_liberte",
            title = "La Liberté guidant le peuple",
            text = "Quel peintre français a réalisé « La Liberté guidant le peuple » ?",
            options = listOf("Gustave Courbet", "Eugène Delacroix", "Édouard Manet", "Théodore Géricault"),
            correctIndex = 1,
            rating = 1450,
            explanation = "« La Liberté guidant le peuple » (1830), allégorie de la révolution de Juillet où une femme brandit le drapeau tricolore, est l'œuvre la plus célèbre d'Eugène Delacroix.",
            category = Category.ART_ET_CULTURE
        ),
        Question(
            id = "sci_uranium_combustible",
            title = "Combustible des centrales nucléaires",
            text = "Quel métal radioactif sert principalement de combustible dans les centrales nucléaires ?",
            options = listOf("Le plomb", "Le titane", "L'uranium", "Le cuivre"),
            correctIndex = 2,
            rating = 1400,
            explanation = "L'uranium, métal lourd radioactif, est le principal combustible des centrales nucléaires : la fission de ses noyaux libère une énorme quantité d'énergie.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_prisme_lumiere",
            title = "Décomposer la lumière blanche",
            text = "Quel objet décompose la lumière blanche en un spectre de couleurs ?",
            options = listOf("Une loupe", "Un prisme", "Un miroir", "Une lentille"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Un prisme dévie chaque couleur d'un angle différent et sépare ainsi la lumière blanche en un spectre, comme Newton l'a démontré au XVIIe siècle.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_aimant_poles",
            title = "Les pôles d'un aimant",
            text = "Combien de pôles possède un aimant ?",
            options = listOf("Un", "Trois", "Deux", "Quatre"),
            correctIndex = 2,
            rating = 1250,
            explanation = "Un aimant possède toujours deux pôles, nord et sud. Même coupé en deux, chaque morceau reconstitue aussitôt un pôle nord et un pôle sud.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "sci_ph_acide",
            title = "Une solution de pH inférieur à 7",
            text = "Comment qualifie-t-on une solution dont le pH est inférieur à 7 ?",
            options = listOf("Acide", "Basique", "Neutre", "Saline"),
            correctIndex = 0,
            rating = 1300,
            explanation = "Sur l'échelle de pH (de 0 à 14), une valeur inférieure à 7 indique une solution acide ; supérieure à 7, elle est basique ; égale à 7, elle est neutre.",
            category = Category.SCIENCES_ET_NATURE
        ),
        Question(
            id = "div_call_of_duty_genre",
            title = "Le genre de Call of Duty",
            text = "À quel genre appartient la série de jeux vidéo « Call of Duty » ?",
            options = listOf("Un jeu de course", "Un jeu de gestion", "Un jeu de rôle", "Un jeu de tir (FPS)"),
            correctIndex = 3,
            rating = 1300,
            explanation = "« Call of Duty » est une série de jeux de tir à la première personne (FPS), centrée sur des combats militaires.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_forrest_gump_acteur",
            title = "L'acteur de Forrest Gump",
            text = "Quel acteur tient le rôle-titre du film « Forrest Gump » (1994) ?",
            options = listOf("Kevin Costner", "Tom Hanks", "Robin Williams", "Bruce Willis"),
            correctIndex = 1,
            rating = 1300,
            explanation = "Tom Hanks incarne Forrest Gump, rôle pour lequel il a reçu l'Oscar du meilleur acteur en 1995.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_eminem_ville",
            title = "La ville d'Eminem",
            text = "De quelle ville américaine le rappeur Eminem est-il originaire ?",
            options = listOf("New York", "Los Angeles", "Detroit", "Atlanta"),
            correctIndex = 2,
            rating = 1350,
            explanation = "Eminem a grandi à Detroit, dans le Michigan, cadre de son film semi-autobiographique « 8 Mile ».",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "div_fifa_editeur",
            title = "L'éditeur des jeux FIFA",
            text = "Quel éditeur a longtemps publié la série de jeux vidéo de football « FIFA » ?",
            options = listOf("Electronic Arts", "Ubisoft", "Konami", "Nintendo"),
            correctIndex = 0,
            rating = 1250,
            explanation = "La série « FIFA » a été éditée pendant près de trente ans par Electronic Arts (EA), avant d'être renommée « EA Sports FC » en 2023.",
            category = Category.DIVERTISSEMENT
        ),
        Question(
            id = "hist_austerlitz_1805",
            title = "Année d'Austerlitz",
            text = "En quelle année Napoléon remporta-t-il la bataille d'Austerlitz ?",
            options = listOf("1799", "1810", "1815", "1805"),
            correctIndex = 3,
            rating = 1500,
            explanation = "La bataille d'Austerlitz, dite « bataille des Trois Empereurs », fut remportée par Napoléon le 2 décembre 1805 ; c'est considéré comme sa plus belle victoire.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_krach_1929",
            title = "Le krach de Wall Street",
            text = "En quelle année eut lieu le krach boursier de Wall Street qui déclencha la Grande Dépression ?",
            options = listOf("1918", "1929", "1936", "1945"),
            correctIndex = 1,
            rating = 1350,
            explanation = "Le krach d'octobre 1929 à la Bourse de New York marqua le début de la Grande Dépression, la plus grave crise économique du XXe siècle.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "hist_fondation_rome",
            title = "Fondation de Rome",
            text = "Selon la tradition, en quelle année la ville de Rome fut-elle fondée ?",
            options = listOf("1200 av. J.-C.", "509 av. J.-C.", "753 av. J.-C.", "27 av. J.-C."),
            correctIndex = 2,
            rating = 1550,
            explanation = "La tradition romaine fixe la fondation de Rome en 753 av. J.-C., attribuée à Romulus. 509 av. J.-C. correspond, lui, au début de la République romaine.",
            category = Category.HISTOIRE
        ),
        Question(
            id = "geo_capitale_pologne",
            tags = listOf("capitale"),
            title = "Capitale de la Pologne",
            text = "Quelle est la capitale de la Pologne ?",
            options = listOf("Varsovie", "Cracovie", "Prague", "Budapest"),
            correctIndex = 0,
            rating = 1250,
            explanation = "Varsovie est la capitale et la plus grande ville de la Pologne. Cracovie, ancienne capitale royale, en est une autre grande ville.",
            category = Category.GEOGRAPHIE
        ),
        Question(
            id = "spo_maillot_jaune",
            title = "Le maillot du leader du Tour",
            text = "Quel maillot porte le leader du classement général du Tour de France ?",
            options = listOf("Le maillot vert", "Le maillot à pois", "Le maillot blanc", "Le maillot jaune"),
            correctIndex = 3,
            rating = 1100,
            explanation = "Le leader du classement général du Tour de France porte le maillot jaune, dont la couleur rappelle le papier du journal L'Auto, organisateur historique de la course.",
            category = Category.SPORTS
        ),
        Question(
            id = "spo_ballon_or_football",
            title = "Le sport du Ballon d'Or",
            text = "Le Ballon d'Or récompense chaque année les meilleurs joueurs de quel sport ?",
            options = listOf("Le tennis", "Le football", "Le basket-ball", "Le rugby"),
            correctIndex = 1,
            rating = 1150,
            explanation = "Le Ballon d'Or, créé en 1956 par le magazine France Football, récompense chaque année les meilleurs footballeurs et footballeuses.",
            category = Category.SPORTS
        ),

    )

    fun getByCategory(category: Category): List<Question> =
        questions.filter { it.category == category }
}
