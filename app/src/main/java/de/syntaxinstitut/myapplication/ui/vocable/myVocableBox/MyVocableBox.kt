package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableBoxBinding
import de.syntaxinstitut.myapplication.ui.vocable.VocableViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [MyVocableBox.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyVocableBox : Fragment() {

    private lateinit var binding: FragmentMyVocableBoxBinding

    private val viewModel: VocableViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_box, container, false)

        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myVocableRV = binding.recyclerView

        myVocableRV.adapter = MyVocableBoxAdapter()
    }

}