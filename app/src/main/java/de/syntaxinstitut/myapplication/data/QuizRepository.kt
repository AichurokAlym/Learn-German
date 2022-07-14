package de.syntaxinstitut.myapplication.data

import de.syntaxinstitut.myapplication.data.model.Quiz

class QuizRepository {

    fun loadQuestions(): List<Quiz> {
        return listOf(
            Quiz(
                0,
                "Am Freitag fahre ich _____ meinen Eltern.",
                "nach",
                "bei",
                "mit",
                "zu",
                4
            ),
            Quiz(
                1,
                "Familie Schöne fährt im Winter immer _____ Schweiz zum Skifahren.",
                "nach",
                "in",
                "nach der",
                "in die",
                4
            ),
            Quiz(
                2,
                "Entschuldigung! Sie _____ hier nicht hineingehen! Hier ist nur der Ausgang! Der Eingang ist dort hinten.",
                "sollen",
                "dürfen",
                "müssen",
                "wollen",
                2
            ),
            Quiz(
                3,
                "____ morgen die Sonne scheint, können wir ins Schwimmbad gehen.",
                "Wann",
                "Wie",
                "Wenn",
                "Weil",
                3
            ),
            Quiz(
                4,
                "Immer _____ Susi nach Hause kommt, begrüßt sie zuerst ihren Hund.",
                "wenn",
                "wann",
                "denn",
                "dann",
                1
            ),
            Quiz(
                5,
                "Letztes Jahr ____ wir in Indien. Das war vielleicht schön!",
                "gehen",
                "waren",
                "bleiben",
                "sind",
                2
            ),
            Quiz(
                6,
                "Du räumst jetzt erstmal auf, _____ darfst du nachher nicht nach draußen zum Spielen gehen!",
                "trotzdem",
                "sonst",
                "zwar",
                "obwohl",
                2
            ),
            Quiz(
                7,
                "Ich werde Frieder anrufen, _____ wir gegessen haben.",
                "wann",
                "bevor",
                "nachdem",
                "wärend",
                3
            ),
            Quiz(
                8,
                "John arbeitet jeden Tag mehr, als er müsste, _____ sein Chef mit ihm zufrieden ist.",
                "damit",
                "zu",
                "dafür",
                "um",
                1
            ),
            Quiz(
                9,
                "_____ des Internets kann man unglaublich viele Informationen finden.",
                "Mit",
                "Mithilfe",
                "Indem",
                "Durch",
                2
            ),
            Quiz(
                10,
                "So, und dieser Hustensaft ist morgens und abends _____.",
                "einnehmen",
                "eingenommen",
                "einnehmend",
                "einzunehmen",
                4
            ),
            Quiz(
                11,
                "Herr Junker ist abends meistens zu Hause, aber _____ trifft er sich mit ein paar Kollegen in einer Kneipe.",
                "hin und her",
                "hin und wieder",
                "hingegen",
                "hinauf und hinunter",
                2
            )

        )
    }
}