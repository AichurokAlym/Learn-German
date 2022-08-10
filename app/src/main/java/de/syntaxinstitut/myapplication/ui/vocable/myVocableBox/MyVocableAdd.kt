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

    // Das binding für das MyVocableAddFragment wird deklariert
    private lateinit var binding: FragmentMyVocableAddBinding

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MyVocableBoxViewModel by viewModels()


    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_add, container, false)

        // Der LifecycleOwner wird zugewiesem, damit LiveData automatisch vom Layout beobachtet wird
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
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