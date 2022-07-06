package de.syntaxinstitut.myapplication.ui.quiz

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.databinding.FragmentQuizBinding

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_quiz_rv.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {

    // Initialisiere binding & viewModel
    private lateinit var binding: FragmentQuizBinding

    private val viewModel: QuizViewModel by activityViewModels()

    private lateinit var backgroundNormal: Drawable
    private lateinit var backgroundWrong: Drawable
    private lateinit var backgroundCorrect: Drawable

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

        // Hole die Hintergründe aus der Ressource
        backgroundNormal = ContextCompat.getDrawable(requireContext(), R.drawable.answer_cards_correct)!!
        backgroundWrong = ContextCompat.getDrawable(requireContext(), R.drawable.answer_cards_wrong)!!
        backgroundCorrect = ContextCompat.getDrawable(requireContext(), R.drawable.answer_cards_style)!!



        val recyclerView = binding.rvQuiz

        recyclerView.adapter = QuizAdapter(viewModel.questionsList,)
    }

    fun checkAnswerUpdateUI(textView: TextView, answerIndex: Int) {

        viewModel.checkAnswer(answerIndex)

    }

    fun selectCallBack(view: View, correctAnswer: String) {

    }


}