package de.syntaxinstitut.myapplication.ui.vocable.verb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.databinding.FragmentVerbBinding
import de.syntaxinstitut.myapplication.ui.vocable.VocableAdapter
import de.syntaxinstitut.myapplication.ui.vocable.VocableViewModel

class VerbFragment : Fragment() {

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentVerbBinding

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: VerbViewModel by viewModels()

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verb, container, false)

        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView von Layout wird mit code verknüpft
        val rvVerb = binding.rvVerb

        //VerbAdapter wird als Adapter festgelegt
        rvVerb.adapter = VerbAdapter(viewModel.verbList)
    }


}