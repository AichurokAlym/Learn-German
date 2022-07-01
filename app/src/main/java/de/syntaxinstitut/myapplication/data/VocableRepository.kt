package de.syntaxinstitut.myapplication.data

import de.syntaxinstitut.myapplication.data.model.Vocable

class VocableRepository {

    fun loadVocabularies() : List<Vocable> {
        val umwelt = "Umwelt"
        return listOf(
            Vocable(
                umwelt,
                "Natur",
                "die",
                "nature",
                "Alle wollen zurück zur Natur, aber keiner zu Fuß"
            ),
            Vocable(
                "Umwelt",
                "Umweltschutz",
                "der",
                "environmental protection",
                "Viele Menschen in Deutschland engagieren sich für den Umweltschutz"
            ),
            Vocable(
                "Umwelt",
                "Umweltverschmutzung",
                "die",
                "pollution",
                "Die Umweltverschmutzung ist ein weltweites Problem."
            ),
            Vocable(
                "Umwelt",
                "Energie",
                "die",
                "energy",
                "Deutschland investiert in erneuerbare Energien."
            ),
            Vocable(
                "Umwelt",
                "Verkehr",
                "der",
                "traffic",
                "Der Verkehr am Feierabend ist wirklich verrückt."
            ),
            Vocable(
                "Umwelt",
                "wetter",
                "das",
                "weather",
                "Wie wird das Wetter morgen?"
            ),
            Vocable(
                "Umwelt",
                "Weltraum",
                "der",
                "space",
                "Wenn es irgendwann Weltraumtourismus gibt, würde ich gerne in den Weltraum reisen."
            ),
            Vocable(
                "Umwelt",
                "Pflanze",
                "die",
                "plant",
                "Hast du Pflanzen in deiner Wohnung?"
            ),

        )

    }
}