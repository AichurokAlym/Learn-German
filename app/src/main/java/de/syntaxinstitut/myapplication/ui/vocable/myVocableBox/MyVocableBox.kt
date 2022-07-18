package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableBoxBinding


class MyVocableBox : Fragment() {

    private lateinit var binding: FragmentMyVocableBoxBinding

    private val viewModel: MyVocableBoxViewModel by activityViewModels()


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

       // myVocableRV.adapter = MyVocableBoxAdapter()
        viewModel.vocableList.observe(
            viewLifecycleOwner,
            Observer {
                myVocableRV.adapter = MyVocableBoxAdapter(it, ::currentSelectedItem)

            }
        )

        binding.btAddVT.setOnClickListener{
            findNavController().navigate(MyVocableBoxDirections.actionMyVocableBoxToMyVocableAdd())

        }
    }

    fun currentSelectedItem(item: MyVocable) {
        viewModel.currentSelected(item)
    }

}