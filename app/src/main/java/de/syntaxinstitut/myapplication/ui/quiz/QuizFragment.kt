package de.syntaxinstitut.myapplication.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Quiz
import de.syntaxinstitut.myapplication.databinding.FragmentQuizBinding


 class QuizFragment : Fragment() {

     // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentQuizBinding

     // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: QuizViewModel by activityViewModels()

     /**
      * Lifecycle Funktion onCreateView
      * Hier wird das binding initialisiert und das Layout gebaut
      */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_quiz, container, false)
        return binding.root
    }

     /**
      * Lifecycle Funktion onViewCreated
      * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
      */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         //recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.rvQuiz

         //QuizAdapter wird als Adapter festgelegt
        recyclerView.adapter = QuizAdapter(requireContext(), viewModel.questionsList,::checkAnswerUpdateUI)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)

         //hier wird zu QuizErgebnisFragment navigiert
        binding.btResult.setOnClickListener {
            findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToMyQuiz())
        }
    }

     /**
      * Diese Funktion ruf die checkAnswer Funktion aus dem ViewModel auf und zeigt anschließend alle
      * betroffenen Elemente richtig an
      */
     fun checkAnswerUpdateUI(quiz: Quiz, answerIndex: Int) : Boolean {

         // prüft ob die Antwort richtig ist
        viewModel.checkAnswer(quiz, answerIndex)

         //prüft ob die LetzteAntwort richtig ist
        if (viewModel.lastAnswer == true) {
            return true
        } else {
            return false
        }

    }
}