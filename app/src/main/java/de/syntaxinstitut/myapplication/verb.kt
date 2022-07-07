package de.syntaxinstitut.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import de.syntaxinstitut.myapplication.databinding.FragmentVerbBinding
import de.syntaxinstitut.myapplication.ui.vocable.VocableAdapter
import de.syntaxinstitut.myapplication.ui.vocable.VocableViewModel

class VerbFragment : Fragment() {

    private lateinit var binding: FragmentVerbBinding

    private val viewModel: VocableViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verb, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvVerb = binding.rvVerb

        //rvVerb.adapter = VocableAdapter(viewModel.verbList)
    }


}