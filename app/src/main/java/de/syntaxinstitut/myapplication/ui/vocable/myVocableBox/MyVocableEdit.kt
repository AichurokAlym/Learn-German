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

    // Das binding für das MyVocableEditFragment wird deklariert
    private lateinit var binding: FragmentMyVocableEditBinding

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MyVocableBoxViewModel by activityViewModels()

    private var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            id = it.getLong("vocableId")
        }
    }

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_edit, container, false)

        // Der LifecycleOwner wird zugewiesem, damit LiveData automatisch vom Layout beobachtet wird
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vocable = viewModel.selectedVocable.value

        if (vocable != null) {
            binding.editNewWord.setText(vocable.newWord)
            binding.editTranslate.setText(vocable.newWordsTranslate)

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
        binding.btDelete.setOnClickListener {
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