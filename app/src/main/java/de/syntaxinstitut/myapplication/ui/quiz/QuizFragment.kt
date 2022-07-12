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

    // Initialisiere binding & viewModel
    private lateinit var binding: FragmentQuizBinding

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_quiz, container, false
        )

        // Der LifecycleOwner wird zugewiesen, damit LiveData automatisch vom Layout beobachtet wird
        //binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvQuiz

        recyclerView.adapter = QuizAdapter(requireContext(), viewModel.questionsList,::checkAnswerUpdateUI)

        // verbesserte Performance bei fixer Größe
        recyclerView.setHasFixedSize(true)

        binding.btResult.setOnClickListener {
            findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToMyQuiz())
        }
    }

     fun checkAnswerUpdateUI(quiz: Quiz, answerIndex: Int) : Boolean {

        viewModel.checkAnswer(quiz, answerIndex)

        if (viewModel.lastAnswer == true) {
            return true
        } else {
            return false
        }

    }
}