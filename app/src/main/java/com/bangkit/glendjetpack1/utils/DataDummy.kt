package com.bangkit.glendjetpack1.utils

import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.remote.response.FilmResponse
import com.bangkit.glendjetpack1.data.source.remote.response.ShowResponse

object DataDummy {

    fun generateDummyFilm(): List<FilmEntity> {

        val films = ArrayList<FilmEntity>()

        films.add(FilmEntity(1,
            1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "10/05/2018",
            "https://www.themoviedb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
        ))

        films.add(FilmEntity(2,2,
            "Alita",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019",
            "https://www.themoviedb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg",
        ))

        films.add(FilmEntity(3, 3,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "12/21/2018",
            "https://www.themoviedb.org/t/p/original/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
        ))

        films.add(FilmEntity(4, 4,
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "11/02/2018",
            "https://www.themoviedb.org/t/p/original/bmUuhUADvSxzagvm7jewCHjrY6m.jpg",
        ))

        films.add(FilmEntity(5, 5,
            "Cold Pursuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "02/08/2019",
            "https://www.themoviedb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
        ))

        films.add(FilmEntity(6, 6,
            "Creed II",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "11/25/2015",
            "https://www.themoviedb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
        ))

        films.add(FilmEntity(7, 7,
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "11/16/2018",
            "https://www.themoviedb.org/t/p/original/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
        ))

        films.add(FilmEntity(8, 8,
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "01/18/2019",
            "https://www.themoviedb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
        ))

        films.add(FilmEntity(9, 9,
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
            "03/26/2010",
            "https://www.themoviedb.org/t/p/original/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
        ))

        films.add(
            FilmEntity(10, 10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "https://www.themoviedb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            )
        )


        return films
    }


    fun generateDummyShow(): List<ShowEntity> {

        val shows = ArrayList<ShowEntity>()

        shows.add(ShowEntity(1, 1,
            "Marvel's Iron Fist",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "2017",
            "https://www.themoviedb.org/t/p/original/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
        ))

        shows.add(ShowEntity(2, 2,
            "Naruto Shippuuden",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "2007",
            "https://www.themoviedb.org/t/p/original/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
        ))

        shows.add(ShowEntity(3, 3,
            "NCIS",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "2003",
            "https://www.themoviedb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
        ))

        shows.add(ShowEntity(4, 4,
            "Riverdale",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "2017",
            "https://www.themoviedb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
        ))

        shows.add(ShowEntity(5, 5,
            "Shameless",
            "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are..",
            "2011",
            "https://www.themoviedb.org/t/p/original/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
        ))

        shows.add(ShowEntity(6, 6,
            "Supergirl",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "2015",
            "https://www.themoviedb.org/t/p/original/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
        ))

        shows.add(ShowEntity(7, 7,
            "Supernatural",
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
            "2005",
            "https://www.themoviedb.org/t/p/original/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
        ))

        shows.add(ShowEntity(8, 8,
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "1989",
            "https://www.themoviedb.org/t/p/original/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
        ))


        shows.add(ShowEntity(9, 9,
            "The Umbrella Academy",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "2019",
            "https://www.themoviedb.org/t/p/original/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
        ))

        shows.add(
            ShowEntity(10, 10,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010",
                "https://www.themoviedb.org/t/p/original/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            )
        )

        return shows
    }



    fun generateRemoteDummyFilm(): List<FilmResponse> {

        val films = ArrayList<FilmResponse>()

        films.add(FilmResponse(1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "10/05/2018",
            "https://www.themoviedb.org/t/p/original/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
        ))

        films.add(FilmResponse(2,
            "Alita",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019",
            "https://www.themoviedb.org/t/p/original/xRWht48C2V8XNfzvPehyClOvDni.jpg",
        ))

        films.add(FilmResponse(3,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "12/21/2018",
            "https://www.themoviedb.org/t/p/original/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
        ))

        films.add(FilmResponse(4,
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "11/02/2018",
            "https://www.themoviedb.org/t/p/original/bmUuhUADvSxzagvm7jewCHjrY6m.jpg",
        ))

        films.add(FilmResponse(5,
            "Cold Pursuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "02/08/2019",
            "https://www.themoviedb.org/t/p/original/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
        ))

        films.add(FilmResponse(6,
            "Creed II",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "11/25/2015",
            "https://www.themoviedb.org/t/p/original/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
        ))

        films.add(FilmResponse(7,
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "11/16/2018",
            "https://www.themoviedb.org/t/p/original/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
        ))

        films.add(FilmResponse(8,
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "01/18/2019",
            "https://www.themoviedb.org/t/p/original/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
        ))

        films.add(FilmResponse(9,
            "How to Train Your Dragon",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father.",
            "03/26/2010",
            "https://www.themoviedb.org/t/p/original/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
        ))

        films.add(
            FilmResponse(10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "https://www.themoviedb.org/t/p/original/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            )
        )


        return films
    }


    fun generateRemoteDummyShow(): List<ShowResponse> {

        val shows = ArrayList<ShowResponse>()

        shows.add(ShowResponse(1,
            "Marvel's Iron Fist",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "2017",
            "https://www.themoviedb.org/t/p/original/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
        ))

        shows.add(ShowResponse(2,
            "Naruto Shippuuden",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "2007",
            "https://www.themoviedb.org/t/p/original/zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
        ))

        shows.add(ShowResponse(3,
            "NCIS",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "2003",
            "https://www.themoviedb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
        ))

        shows.add(ShowResponse(4,
            "Riverdale",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "2017",
            "https://www.themoviedb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
        ))

        shows.add(ShowResponse(5,
            "Shameless",
            "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are..",
            "2011",
            "https://www.themoviedb.org/t/p/original/9akij7PqZ1g6zl42DQQTtL9CTSb.jpg",
        ))

        shows.add(ShowResponse(6,
            "Supergirl",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "2015",
            "https://www.themoviedb.org/t/p/original/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
        ))

        shows.add(ShowResponse(7,
            "Supernatural",
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
            "2005",
            "https://www.themoviedb.org/t/p/original/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
        ))

        shows.add(ShowResponse(8,
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "1989",
            "https://www.themoviedb.org/t/p/original/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
        ))


        shows.add(ShowResponse(9,
            "The Umbrella Academy",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "2019",
            "https://www.themoviedb.org/t/p/original/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
        ))

        shows.add(
            ShowResponse(10,
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010",
                "https://www.themoviedb.org/t/p/original/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            )
        )

        return shows
    }

}