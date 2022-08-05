package de.syntaxinstitut.myapplication.data.model

data class Vocable(
    val titel: String,
    val word: String,
    val artikel: String,
    val wordsTranslate: String,
    val exampleSentence: String,
    var isClickt: Boolean
)
