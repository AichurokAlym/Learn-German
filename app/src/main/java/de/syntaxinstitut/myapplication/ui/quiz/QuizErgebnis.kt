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

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val myQuizRV = binding.recyclerView

        myQuizRV.adapter = QuizErgebnisAdapter(requireContext(), viewModel.questionsList, ::checkAnswerUpdateUi)
        myQuizRV.setHasFixedSize(true)

        //binding.tvCorrectAnswer.text = viewModel.correctAnswer.toString()

        viewModel.correctAnswer.observe(
            viewLifecycleOwner,
            Observer {
                if (it > 0) {
                    binding.tvCorrectAnswer.text = getString(R.string.quiz_ergebnis, viewModel.correctAnswer.value)
                }
            }
        )

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