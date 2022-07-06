package de.syntaxinstitut.myapplication.data

import de.syntaxinstitut.myapplication.data.model.Verb

class VerbRepository {

    fun loadVerbs(): List<Verb> {
        return listOf(
            Verb(
                "INFINITIV + ERGÄNZUNG",
                "3.PERSON PRÄSENS",
                "3.PERSON PRÄTERITUM",
                "HILFSVERB + PARTIZIP ||"
            ),
            Verb(
                "backen(DAt)Akk",
                "backt/bäckt",
                "backte/buk",
                "hat gebacken"
            ),
            Verb(
                "befehlen Dat,Akk/Inf",
                "befiehlt",
                "befahl",
                "hat befohlen"
            )
            )

    }
}