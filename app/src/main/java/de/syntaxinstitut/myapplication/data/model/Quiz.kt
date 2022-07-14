package de.syntaxinstitut.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val question: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val rightAnswer: Int,
    var clicked: Boolean = false
)
