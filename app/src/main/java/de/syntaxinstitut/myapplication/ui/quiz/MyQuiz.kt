package de.syntaxinstitut.myapplication.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableBoxBinding
import de.syntaxinstitut.myapplication.ui.vocable.VocableViewModel

class MyQuiz : Fragment() {

    // Hier wird das ViewModel geholt
    private val viewModel: VocableViewModel by activityViewModels()

    // hier wird die binding Variable deklariert
    private lateinit var binding: FragmentMyVocableBoxBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyVocableBoxBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}