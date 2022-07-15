package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableEditBinding


class MyVocableEdit : Fragment() {

    private lateinit var binding: FragmentMyVocableEditBinding
    private val viewModel: MyVocableBoxViewModel by activityViewModels()
    private var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            id = it.getLong("vocableId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_edit, container, false)

        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vocable = viewModel.vocableList.value?.find { it.id == id }

        if (vocable != null) {
            binding.editNewWord.setText(vocable.newWord)
            binding.editTranslate.setText(vocable.newWordsTranslate)
           // val index = resources.getStringArray(R.array.)
        }

        viewModel.complete.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(MyVocableEditDirections.actionMyVocableEditToMyVocableBox())
                viewModel.unsertComplete()
            }
        }
        binding.btEditSave.setOnClickListener {
            if (vocable != null) {
                getValuesAndUpdate(vocable)
            }
        }
        binding.editNewWord.setOnClickListener {
            if (vocable != null) {
                viewModel.deleteVocable(vocable)
            }
        }
    }

    private fun getValuesAndUpdate(vocable: MyVocable) {
        vocable.newWord = binding.editNewWord.text.toString()
        vocable.newWordsTranslate = binding.editTranslate.text.toString()
        viewModel.updateVocable(vocable)
    }

}