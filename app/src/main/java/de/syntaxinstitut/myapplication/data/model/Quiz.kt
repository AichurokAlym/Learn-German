package de.syntaxinstitut.myapplication.data.model

data class Quiz(
    val question: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val rightAnswer: Int,
    var clicked: Boolean = false
)
