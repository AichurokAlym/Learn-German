package de.syntaxinstitut.myapplication.data

import de.syntaxinstitut.myapplication.data.model.Verb

/**
 * Diese Klasse stellt die benötigten Informationen zur Verfügung
 */
class VerbRepository {

    /**
     * Diese Funktion liefert eine Liste an Question Objekten zurück, in denen die Frage, die
     * Antwortmöglichkeiten, der Index der richtigen Antwort und die Preisstufe gespeichert sind
     */
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
            ),
            Verb(
                "beginnen mit/Inf.",
                "beginnt",
                "begann",
                "hat begonnen"
            ),
            Verb(
                "denken an/über",
                "denkt",
                "dachte",
                "hat gedacht"
            ),
            Verb(
                "empfinden Akk",
                "empfindet",
                "empfand",
                "hat empfunden"
            ),
            Verb(
                "geschehen  Dat,Akk.",
                "geschieht",
                "geschah",
                "ist geschehen"
            ),
            Verb(
                "lesen Akk.",
                "liest",
                "las",
                "hat gelesen"
            ),
            Verb(
                "rennen",
                "rennt",
                "rannte",
                "ist gerannt"
            ),
            Verb(
                "schmelzen",
                "schmilzt",
                "schmolz",
                "ist/hat geschmolzen"
            ),
            Verb(
                "sprießen",
                "sprießt",
                "spross",
                "ist gesprossen"
            ),
            Verb(
                "tragen Akk.",
                "trägt",
                "trug",
                "hat getragen"
            ),
            Verb(
                "vergessen Dat,Akk/Inf.",
                "vergisst",
                "vergaß",
                "hat vergessen"
            )
            )

    }
}