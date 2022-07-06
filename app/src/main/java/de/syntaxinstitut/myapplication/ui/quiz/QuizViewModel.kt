package de.syntaxinstitut.myapplication.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntaxinstitut.myapplication.data.QuizRepository
import de.syntaxinstitut.myapplication.data.model.Quiz

/**
 * Das ViewModel des One Fragments
 */
class QuizViewModel(application: Application) : AndroidViewModel(application) {

    // Erstelle eine QuizRepository Instanz
    val qRepository = QuizRepository()

    // Lade die Liste mit den Question Informationen aus der QuizRepository Instanz
    val questionsList = qRepository.loadQuestions()

    // Der Index zeigt die Position der aktuellen Frage in der Liste
    var questionIndex = 0

    // Diese Variable speichert die aktuelle Frage
    var _currentQuestion = questionsList[0]
    val currentQuestion: Quiz
        get() = _currentQuestion


    // Diese Variable speichert, wie die letzte Frage beantwortet wurde
    var _lastAnswer = true
    val lastAnswer: Boolean
        get() = _lastAnswer



    /**
     * Diese Funktion startet das Spiel neu, indem alle Variablen zurückgesetzt werden
     */
    fun restartGame() {
        //_currentQuestion = questionsList[0]

    }

    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend.
     */
    fun checkAnswer(quiz: Quiz, answerIndex: Int) {
        if (answerIndex == quiz.rightAnswer){
            _lastAnswer = true
            } else {
                questionIndex++
               // _currentQuestion = questionsList[questionIndex]
                _lastAnswer = false
            }

    }

}
