package de.syntaxinstitut.myapplication.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Quiz
import de.syntaxinstitut.myapplication.databinding.FragmentMyQuizBinding

class QuizErgebnis : Fragment() {

    // Hier wird das ViewModel geholt
    private val viewModel: QuizViewModel by activityViewModels()

    // hier wird die binding Variable deklariert
    private lateinit var binding: FragmentMyQuizBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyQuizBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
         }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        // recyclerView von Layout wird mit code verknüpft
        val myQuizRV = binding.recyclerView

        // QuizErgebnisAdapter wird als Adapter festgelegt
        myQuizRV.adapter = QuizErgebnisAdapter(requireContext(), viewModel.questionsList, ::checkAnswerUpdateUi)

        // Verbesserte Performance bei fixer Listengröße
        myQuizRV.setHasFixedSize(true)


        //hier wird richtig beantwortete Fragen beobachtet
        //und das Ergebnis wird angezeigt
        viewModel.correctAnswer.observe(
            viewLifecycleOwner,
            Observer {
                if (it > 0) {
                    binding.tvCorrectAnswer.text = getString(R.string.quiz_ergebnis, viewModel.correctAnswer.value)
                }
            }
        )

    }

    /**
     * Diese Funktion ruf die checkAnswer Funktion aus dem ViewModel auf und zeigt anschließend alle
     * betroffenen Elemente richtig an
     */
    fun checkAnswerUpdateUi(quiz: Quiz, rightAnswer: Int) : Boolean {

        // prüft ob die Antwort richtig ist
        viewModel.checkAnswer(quiz, rightAnswer)

        //prüft ob die LetzteAntwort richtig ist
        if (viewModel.lastAnswer == true) {
            return true
        } else {
            return false
        }
    }
}