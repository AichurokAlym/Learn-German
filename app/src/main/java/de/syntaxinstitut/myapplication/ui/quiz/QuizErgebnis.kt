package de.syntaxinstitut.myapplication.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.myapplication.data.model.Quiz
import de.syntaxinstitut.myapplication.databinding.FragmentMyQuizBinding
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableBoxBinding
import de.syntaxinstitut.myapplication.ui.vocable.VocableViewModel

class QuizErgebnis : Fragment() {

    // Hier wird das ViewModel geholt
    private val viewModel: QuizViewModel by activityViewModels()

    // hier wird die binding Variable deklariert
    private lateinit var binding: FragmentMyQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyQuizBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myQuizRV = binding.recyclerView

        myQuizRV.adapter = QuizErgebnisAdapter(requireContext(), viewModel.questionsList, ::checkAnswerUpdateUi)
        myQuizRV.setHasFixedSize(true)

        binding.tvCorrectAnswer.text = viewModel.correctAnswer.toString()

    }

    fun checkAnswerUpdateUi(quiz: Quiz, rightAnswer: Int) : Boolean {
        viewModel.checkAnswer(quiz, rightAnswer)


        if (viewModel.lastAnswer == true) {
            return true
        } else {
            return false
        }
    }
}