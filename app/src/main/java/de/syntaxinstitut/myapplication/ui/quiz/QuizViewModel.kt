package de.syntaxinstitut.myapplication.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    // Diese Variable speichert, wie die letzte Frage beantwortet wurde
    var _lastAnswer = true
    val lastAnswer: Boolean
        get() = _lastAnswer


    // Diese Variable speichert die richtige Antwort
    private var _correctAnswer = MutableLiveData<Int>(0)
    val correctAnswer: LiveData<Int>
        get() = _correctAnswer



    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend.
     */
    fun checkAnswer(quiz: Quiz, answerIndex: Int) {
        if (answerIndex == quiz.rightAnswer){
            _lastAnswer = true
            _correctAnswer.value = _correctAnswer.value!!+1
            } else {
                _lastAnswer = false
            }
    }
}
