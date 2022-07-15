package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.data.model.Vocable
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableAddBinding


class MyVocableAdd : Fragment() {

    private lateinit var binding: FragmentMyVocableAddBinding

    private val viewModel: MyVocableBoxViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_add, container, false)

        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.complete.observe(
            viewLifecycleOwner,
            Observer {
                if (it) {
                    findNavController().navigate(MyVocableAddDirections.actionMyVocableAddToMyVocableBox())
                    viewModel.unsertComplete()
                }
            }
        )

        binding.btSave.setOnClickListener {
            getValuesAndSave()
        }

        binding.btCancel.setOnClickListener {
            findNavController().navigate(MyVocableAddDirections.actionMyVocableAddToMyVocableBox())
        }
    }

    private fun getValuesAndSave() {
        val newWord = binding.addNewWord.text.toString()
        val newTranslate = binding.addTranslate.text.toString()
        val newVocable = MyVocable(0, newWord = newWord, newWordsTranslate = newTranslate) //id sollte eigentlich automatisch generieren
        viewModel.insertVocable(newVocable)
    }
}